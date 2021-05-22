//若为空
function isEmpty(id){
    id.setAttribute("placeholder","不能为空");
};
//将对的标签改为错的标签
// function seterror(node){
//     node.nextSibling.setAttribute("src","./img/error.png");
// };
//显示判断后的结果
function showTip(node){
    node.nextSibling.setAttribute("class","show");
};

//登录函数
function login(){
    var btn=document.getElementById("login");
//  var flag=false;
    btn.onclick=function(){
        var username=document.getElementById("username");
        var password=document.getElementById("password");
        //判断用户名是否为空
        if(username.value.length<=0){
            isEmpty(username);
            // seterror(username);

        }
        //判断密码是否为空
        if(password.value.length<=0){
            isEmpty(password);
            // seterror(password);

        }
        //调用函数
        useLoginAjax();
        showTip(username);
        showTip(password);
    };
};

//Ajax调用
function useLoginAjax() {
    var request = false;
    if (window.ActiveXObject) { // 调用创建XMLHttpRequest对象的方法
        request = new ActiveXObject("Microsoft.XMLHTTP");
    } else if (window.XMLHttpRequest) {
        request = new XMLHttpRequest(); // IE7+,Firefox,Chrome,Opera,Safari
    }
    var myform = document.getElementById("myform");
    var username = myform.username.value;
    var password = myform.password.value;
    request.onreadystatechange = function() {
        if (request.readyState == 4) {
            if (request.status == 200) {
                var str = request.responseText;
                if (str == "fail") {
                    var password = document.getElementById("password");
                    password.value = "";
                    password.setAttribute("placeholder", "密码错误！");
                    password.nextSibling.setAttribute("src", "./img/error.png");
                    alert("密码错误！");
                } else {
                    //button转化为subimit按钮
                    document.forms[0].submit();
                }
            }
        }
    };

    //还记得web.xml配合的/check么？
    var url = "Main?username=" + username + "&password=" + password;
    request.open("get", url);
    request.setRequestHeader("ContentType",
        "application/x-www-form-urlencoded;charset=UTF-8");
    request.send(null);
};