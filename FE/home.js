
let blogs  = JSON.parse(localStorage.getItem("blogs"));
show();

function clear(){
    let id = document.getElementById("id").value='';
    let title = document.getElementById("title").value='';
    let img = document.getElementById("img").value='';
    let content = document.getElementById("content").value='';
}

function show() {
let str = '';
for (const blog of blogs) {
    str += `<div class="col-sm-4">
            <p>${blog.id}</p>
            <h2>${blog.title}</h2>
            <img src="${blog.img}" width="300" height="200">
            <p>${blog.content}</p>
            <a type="button" class="btn btn-warning" onclick="edit(${blog.id})" >Edit</a>
            <a type="button" class="btn btn-danger" onclick="delete01(${blog.id})">Delete</a>
        </div>`
}
document.getElementById("show").innerHTML = str;
}


function add() {
    let id = document.getElementById("id").value;
    let title = document.getElementById("title").value;
    let img = document.getElementById("img").value;
    let content = document.getElementById("content").value;
    blogs.push({id,title,img,content});
    show();
    clear();
    localStorage.setItem("blogs",JSON.stringify(blogs));
}

function findIndex(index) {
    for (let i = 0; i < blogs.length; i++) {
        if (blogs[i].id==index){
            return i;
        }
    }
    return -1;
}

function edit(index) {
    let index1=findIndex(index);
   document.getElementById("id").value = blogs[index1].id;
   document.getElementById("title").value = blogs[index1].title;
   document.getElementById("img").value = blogs[index1].img;
    document.getElementById("content").value = blogs[index1].content;
}

function save() {
    let id=document.getElementById("id").value ;
    let title=document.getElementById("title").value;
    let img=document.getElementById("img").value;
    let content= document.getElementById("content").value;

    let index1=findIndex(id);
    blogs.splice(index1,1, {id,title,img,content});
    show();
    clear();
    localStorage.setItem("blogs",JSON.stringify(blogs));
}

function delete01(index) {
    blogs.splice(findIndex(index), 1);
    show();
    localStorage.setItem("blogs",JSON.stringify(blogs));
}