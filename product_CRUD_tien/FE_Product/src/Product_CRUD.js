let isCreate = true;

let imgInp = document.getElementById("img");
let blah = document.getElementById("blah");

function showImg() {
    let file = imgInp.files;
    blah.src = URL.createObjectURL(file[0])
}

function show() {
    $.ajax({
        type: "GET",
        headers: {
            'Accept': 'application/json',
            'Authorization': 'Bearer ' + localStorage.getItem("token")
        },
        url: "http://localhost:8080/products",
        //xử lý khi thành công
        success: function (products) {
            console.log(products)
            let str = '';
            for (const product of products) {
                str += `<div class="col-sm-4">
                        <h3>${product.name}</h3>
                        <p>${product.category.category_name}</p>
                        <img src="${product.img}" width="300" height="200">      
                        <p>${product.price}</p>                 
                        <p>${product.created_at}</p>   
                         <a type="button" class="btn btn-warning" onclick="showEdit(${product.id})" data-toggle="modal" data-target="#myModal">Edit</a>
                        <a type="button" class="btn btn-danger" onclick="showDelete('${product.id}')" >Delete</a>
                        </div>`
            }

            document.getElementById("show").innerHTML = str;
        },
        error: function (err) {
            console.log(err)
        }
    })
}

// function category() {
//     $.ajax({
//         type: "GET",
//         headers: {
//             'Accept': 'application/json',
//             'Authorization': 'Bearer ' + localStorage.getItem("token")
//         },
//         url: "http://localhost:8080/products/category/category",
//         //xử lý khi thành công
//         success: function (category) {
//             console.log(category)
//             let str = '';
//           for (const c of category) {
//               str +=`
//             <option  value="${c.category_id}">${c.category_name}</option>`
//           }
//             document.getElementById("category01").innerHTML = str;
//         },
//         error: function (err) {
//             console.log(err)
//         }
//     })
// }
//
// category();

show();

function clearEdit() {
    isCreate = true;
    document.getElementById("id").value = 0;
    $("#name").val("");
    $("#idCategory").val("");
    $("#img").val("");
    $("#blah").val("");
    $("#price").val("");
    $("#created_at").val("");

}


function upImg() {
    let fileImg = document.getElementById("img").files;
    var formData = new FormData();
    formData.append("fileImg", fileImg[0]);

    $.ajax({
        contentType: false,
        processData: false,
        headers: {
            'Authorization': 'Bearer ' + localStorage.getItem("token")
        },
        type: "POST",
        data: formData,
        url: "http://localhost:8080/products/upImg",
        success: function (img) {
            create(img)
        }
    });
}

function create(img) {
    let product = {
        "name": $("#name").val(),
        "category": {
            "category_id": $("#idCategory").val(),
        },
        "img": img,
        "price": $("#price").val(),
        // "created_at": $("#created_at").val()
        "created_at": Date.now()
    }

    if (!isCreate) {
        product.id = $("#id").val();
    }

    $.ajax({
        type: "Post",
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            'Authorization': 'Bearer ' + localStorage.getItem("token")

        },
        url: "http://localhost:8080/products",
        data: JSON.stringify(product),
        //xử lý khi thành công
        success: function (data) {
            alert("Thành công");
            show();
        },
        error: function (err) {
            console.log(err)
        }
    })
}

function showEdit(id) {
    isCreate = false;
    $.ajax({
        type: "Get",
        headers: {
            'Accept': 'application/json',
            'Authorization': 'Bearer ' + localStorage.getItem("token")

        },
        url: "http://localhost:8080/products/" + id,
        //xử lý khi thành công
        success: function (product) {
            document.getElementById("id").value = product.id;
            document.getElementById("checdate").innerHTML = "Cập nhật lại ngày";
            $("#name").val(product.name);
            $("#idCategory").val(product.category.category_id);
            $("#price").val(product.price);
            $("#img").val(product.img);
            $("#blah").val();
            $("#created_at").val(product.created_at);
            document.getElementById("checdate").innerHTML = "Cập nhật lại ngày";
        },
        error: function (err) {
            console.log(err)
        }
    })
}

function showDelete(id) {
    $.ajax({
        type: "DELETE",
        headers: {
            'Accept': 'application/json'
        },
        url: "http://localhost:8080/products/" + id,
        //xử lý khi thành công
        success: function (product) {
            alert("Đã xoá thành công");
            show();
        },
        error: function (err) {
            console.log(err)
        }
    })
}

function isDuplicateName(name) {
    document.getElementById("checkname").innerHTML = "";
    $.ajax({
        type: "Get",
        headers: {
            'Accept': 'application/json'
        },
        url: "http://localhost:8080/products/check/" + name,
        success: function (product) {

        },
        error: function (err) {
            document.getElementById("checkname").innerHTML = "Sản phẩm trùng tên";
            console.log(err)
            clearEdit();
        }
    })
}