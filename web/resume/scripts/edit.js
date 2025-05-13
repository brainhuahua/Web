const name1 = document.querySelector('#name');
const toward = document.querySelector('#position');


const address = document.querySelector('#address');
const birth = document.querySelector('#birth');
const tel = document.querySelector('#tel');
const email1 = document.querySelector('#email');

let photosrc ="img/head.png"
function shauxin(){
    var url = '/WebServlet/resource1?email=1';
    console.log(url);
    fetch(url)
        .then(response => response.json())
        .then(data => {

            name1.value = data.name;
            toward.value = data.position;
            address.value = data.address;
            birth.value = data.birth;
            tel.value = data.tel;
            email1.value = data.email;
            console.log(data);
            photosrc = data.photourl;
            var o = document.querySelectorAll("img")
            for (let i = 0; i < o.length; i++) {
                o[i].src="img/" + data.photourl;
            }
        });
}
shauxin()

function ret(){
    location.href="/resume"
}


function getresource2(){
    var url = '/WebServlet/resource2';
    var ul = document.querySelectorAll('.zujian ul')[17]
    console.log(ul);
    fetch(url)
        .then(response => response.json())
        .then(data => {
            console.log(data);
            ul.innerHTML = '';
            for (var k in data){
                console.log(k+" "+data[k]);
                const li = document.createElement('li');
                li.innerHTML = data[k];
                ul.appendChild(li);
            }
        });
}
getresource2();

function getFileContent(){
    // file[0]就是上传的图片本身
    // FileReader的readAsDataURL方法可以将图片转换为base64格式
    var reader = new FileReader();
    var file = document.querySelector("#myFile").files;
    reader.readAsDataURL(file[0]);
    // 一定要在文件读取 成功完成时 再进行相应的操作：
    reader.onload = function(){
        var o = document.querySelectorAll("img")
        for (let i = 0; i < o.length; i++) {
            o[i].src=reader.result;
        }
    }
}




function openphoto(){
    var con = document.getElementsByClassName('upphoto')[0];
    con.style.display = 'flex';
}



function closephoto(){
    var con = document.getElementsByClassName('upphoto')[0];
    con.style.display = 'none';
    var o = document.querySelectorAll("img")
    for (let i = 0; i < o.length; i++) {
        o[i].src="img/" + photosrc;
    }
}


function openedit(){
    var con = document.getElementsByClassName('alter')[0];
    con.style.display = 'flex';
    var ul = document.querySelectorAll('.alter .ba ol')[0]
    var url = '/WebServlet/resource2';
    fetch(url)
        .then(response => response.json())
        .then(data => {
            console.log(data);
            ul.innerHTML = '';
            for (var k in data){
                console.log(k+" "+data[k]);
                const li = document.createElement('li');
                const tr = document.createElement('tr');
                const td1 = document.createElement('td');
                const td2 = document.createElement('td');
                td2.innerHTML = data[k];
                td1.innerHTML = k;
                tr.appendChild(td1);
                tr.appendChild(td2);
                ul.appendChild(tr);
            }
        });
}

function alterAdd(){
    var id = document.getElementById('alterId').value;
    var newcontent = document.getElementById('alterContent').value;
    var ul = document.querySelectorAll('.zujian ul')[17]
    console.log(ul);
    console.log(id);
    console.log(newcontent);
    //var oldcontent = ul.children[parseInt(id)].innerHTML;
    //console.log(oldcontent);
    var url = '/WebServlet/renew2';

    var formData = new URLSearchParams();
    formData.append("opreate", "0");
    formData.append("oldcontent", null);
    formData.append("newcontent", newcontent);
    fetch(url,{
        method: 'post',
        body: formData,
        headers: {
            "Content-Type": "application/x-www-form-urlencoded"
        }
    }).then(response => response.json()).then(
        date =>{
            alert("更新成功")
            closeba();
            getresource2();
        }
    );

}

function alter(){
    var id = document.getElementById('alterId').value;
    var newcontent = document.getElementById('alterContent').value;
    var ul = document.querySelectorAll('.zujian ul')[17]
    if(id === ''){
        alert("id不为空");
        return;
    }
    console.log(ul);
    console.log(id);
    console.log(newcontent);
    var oldcontent = ul.children[parseInt(id)].innerHTML;
    console.log(oldcontent);
    var url = '/WebServlet/renew2';
    var formData = new URLSearchParams();
    formData.append("opreate", "1");
    formData.append("oldcontent", oldcontent);
    formData.append("newcontent", newcontent);
    fetch(url,{
        method: 'post',
        body: formData,
        headers: {
            "Content-Type": "application/x-www-form-urlencoded"
        }}).then(response => response.json()).then(date=>{
        alert("更新成功")
        closeba();
        getresource2();
    })
}


function alterDelete(){
    var id = document.getElementById('alterId').value;
    var newcontent = document.getElementById('alterContent').value;
    var ul = document.querySelectorAll('.zujian ul')[17]
    if(id === ''){
        alert("id不为空");
        return;
    }
    console.log(ul);
    console.log(id);
    console.log(newcontent);
    var oldcontent = ul.children[parseInt(id)].innerHTML;
    console.log(oldcontent);
    var url = '/WebServlet/renew2';
    var formData = new URLSearchParams();
    formData.append("opreate", "2");
    formData.append("oldcontent", oldcontent);
    formData.append("newcontent", null);
    fetch(url,{
        method: 'post',
        body: formData,
        headers: {
            "Content-Type": "application/x-www-form-urlencoded"
        }}).then(response => response.json()).then(date=>{
        alert("更新成功")
        closeba();
        getresource2();
    })
}


function closeba(){
    var con = document.getElementsByClassName('alter')[0];
    con.style.display = 'none';
}