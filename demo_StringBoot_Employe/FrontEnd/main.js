
let isCreate = true;
function show() {
    $.ajax({
        type: "GET",
        headers: {
            'Accept': 'application/json'
        },
        url: "http://localhost:8080/employ",
        //xử lý khi thành công
        success: function (employ) {
            console.log(employ)
            let str = '';
            for (const employs of employ) {
                str += `
                 <tr>
                    <td>${employs.id}</td>
                    <td>${employs.name}</td>
                    <td>${employs.age}</td>
<!--                    <td>${employs.salary}</td>-->
                    <td>${employs.department.name}</td>
                    <td><button type="button" class="btn btn-primary"  onclick="showEdit('${employs.id}')" data-toggle="modal" data-target="#myModal">Edit</button>
                    <button type="button" class="btn btn-warning"  onclick="showDelete('${employs.id}')">Delete</button></td>
                 </tr>
                      `
            }

            document.getElementById("show").innerHTML = str;

        },
        error: function (err) {
            console.log(err)
        }
    })
}
show();
function clearEdit() {
    isCreate = true;
    document.getElementById("id").value = '';
    // $("#id").val("");
    $("#name").val("");
    // $("#salary").val("");
    $("#age").val("");
    $("#idDepartment").val("");
}

function create() {
    let employ = {
        "id": document.getElementById("id").value,
        "name": $("#name").val(),
        "age": $("#age").val(),
        // "salary": $("#salary").val(),
        "department": {
            "id": $("#idDepartment").val(),
        }
    }

    if (!isCreate){
        employ.id = $("#id").val();
    }

    $.ajax({
        type: "Post",
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        url: "http://localhost:8080/employ",
        data: JSON.stringify(employ),
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
            'Accept': 'application/json'
        },
        url: "http://localhost:8080/employ/" + id,
        //xử lý khi thành công
        success: function (employ) {
            // document.getElementById("id").value = employ.id;
            $("#id").val(employ.id);
            $("#name").val(employ.name);
            $("#age").val(employ.age);
            // $("#salary").val(employee.salary);
            $("#idDepartment").val(employ.department.id);
        },
        error: function (err) {
            console.log(err)
        }
    })
}


function showDelete(id){
    $.ajax({
        type: "DELETE",
        headers: {
            'Accept': 'application/json'
        },
        url: "http://localhost:8080/employ/" + id,
        //xử lý khi thành công
        success: function (employ) {
            alert("Đã xoá thành công");
            show();
        },
        error: function (err) {
            console.log(err)
        }
    })
}


