<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>修改密码</title>
    <link rel="shortcut icon" href="favicon.ico">
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <link href="../css/font-awesome.min.css" rel="stylesheet">
    <link href="../css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="../css/animate.min.css" rel="stylesheet">
    <link href="../css/style.min.css" rel="stylesheet">
    <script src="../js/jquery.min.js"></script>
    <script src="../js/bootstrap.min.js"></script>
    <script src="../js/plugins/iCheck/icheck.min.js"></script>
</head>
<body class="gray-bg">
<script>
    function check() {
        var pass1 = $("#password1").val();
        var pass2 = $("#password2").val();
        if (pass1 != pass2) {
            $("#password2").val("");
            alert("两次密码不相符");
        }
    }
    function chessboard() {
        var password = $("#passbook").val();
        $.ajax({
            url: "/UpDataInformServlet",
            type: "POST",
            data:{
                "pass":password
            },
            success: function (data) {
                if(data.toString()=="false"){
                    $("#passbook").val("");
                    alert("原密码填写不正确")
                }
            },
            dataType: 'json'
        });
    }
</script>
<div class="middle-box text-center loginscreen   animated fadeInDown" style="margin-left: 100px;margin-top: -30px">
    <div>
        <div style="margin-top: 120px">
            <h1 style="font-size: 28px">修改密码</h1>
        </div>
        <form class="m-t" role="form" action="/ResetPasswordServlet" method="post">
            <div class="form-group">
                <input type="text" name="passbook" id="passbook" class="form-control" onchange="chessboard()"
                       placeholder="原密码" required="">
            </div>
            <div class="form-group">
                <input type="password" id="password1" name="password" class="form-control" placeholder="新密码"
                       required="">
            </div>
            <div class="form-group">
                <input type="password" id="password2" onchange="check()" class="form-control" placeholder="确认新密码"
                       required="">
            </div>
            <button type="submit" class="btn btn-primary block full-width m-b">修 改</button>
        </form>
    </div>
</div>

<script>
    $(document).ready(function () {
        $(".i-checks").iCheck({checkboxClass: "icheckbox_square-green", radioClass: "iradio_square-green",})
    });
</script>
</div>
</body>
</html>
