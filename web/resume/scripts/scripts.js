

function getcount(){
    var co = document.getElementsByClassName("count")[0];
    fetch('/WebServlet/count')
        .then(response => response.text())
        .then(count => {
            console.log(count);
            console.log(co.innerText);
            co.innerText = "访问次数:"+count.toString();
        });
}


function change(){
    location.href="/login";
}

getcount();


function getresource(){
    var name1 = document.querySelector('.head .left-right .left .name');
    var toward = document.querySelector('.head .left-right .left .position');

    var address = document.querySelector('#span1');
    var birth = document.querySelector('#span2');
    var tel = document.querySelector('#span3');
    var email1 = document.querySelector('#span4');
    var url = '/WebServlet/resource1?email=1';
    fetch(url)
        .then(response => response.json())
        .then(data => {
            console.log(name1)
            console.log(toward)
            name1.innerHTML = data.name;
            toward.innerHTML = '意向职位: '+data.position;
            address.innerHTML = '地址: '+data.address;
            birth.innerHTML= '出生日期: '+data.birth;
            tel.innerHTML= '电话: '+data.tel;
            email1.innerHTML= '邮箱: '+data.email;
            var o = document.querySelectorAll("img")
            for (let i = 0; i < o.length; i++) {
                o[i].src="img/" + data.photourl;
            }
            console.log(data);
        });
}

function getresource2(){
    var url = '/WebServlet/resource2';
    var ul = document.querySelectorAll('.zujian ul')[17]
    console.log(ul);
    fetch(url)
        .then(response => response.json())
        .then(data => {
            console.log(data);
            for (var k in data){
                console.log(k+" "+data[k]);
                const li = document.createElement('li');
                li.innerHTML = data[k];
                ul.appendChild(li);
            }
        });
}
getresource();
getresource2();