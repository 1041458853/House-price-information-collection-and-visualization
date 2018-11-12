$(function () {
    userInfo()
});


//======================================================================================================================

function userInfo() {
    $.ajax({
        type: "get", //请求方式
        url:"/userinfo",
        success: function (result) {
            if (result != null && ""!=result){
                $("#username").text("Nickname: " + result);
            }else {
                $("#username").text("点击登录");
                $("#user").on('click', function(){
                    window.location.href="/login";
                });
            }
        }
    });

}