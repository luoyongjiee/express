<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
  <title>登录</title>
  <meta charset="utf-8">
  <meta http-equiv="content-Type" content="text/html;charset=UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">

  <meta name="description" content="weui">


  <link rel="stylesheet" href="//cdn.bootcss.com/weui/0.4.3/style/weui.min.css">
  <link rel="stylesheet" href="//cdn.bootcss.com/jquery-weui/0.8.0/css/jquery-weui.min.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/demo.css">

</head>

<body ontouchstart>

<header class='demos-header'>
  <h1 class="demos-title">登录</h1>
</header>

<div class='demos-content-padded'>
  <a href="javascript:;" id='show-login1' class="weui_btn weui_btn_primary">(正式开放给用户的时候删除这个按钮)暂时设定用户名：admin,密码：admin</a>
  <a href="javascript:;" id='show-login' class="weui_btn weui_btn_primary">显示登录弹窗</a>
</div>

<!-- body 最后 -->
<script src="//cdn.bootcss.com/jquery/1.11.0/jquery.min.js"></script>
<script src="//cdn.bootcss.com/jquery-weui/0.8.0/js/jquery-weui.min.js"></script>

<script src="${pageContext.request.contextPath}/lib/fastclick.js"></script>
<script>
  $(document).on('click', '#show-login', function() {
    $.login({
      title: '登录',
      text: '请输入用户名和密码',
      onOK: function (username, password) {
        $.ajax({
          type: "post",
          url: "${pageContext.request.contextPath}/login",
          data: {userId:$("#weui-prompt-username").val(),password:$("#weui-prompt-password").val()},
          dataType: "json",
          success: function(data){

            if(data){
              $.toast('登录成功!');
              window.location.href = "${pageContext.request.contextPath}/path/express/menu";
            }else{
              $.toast('密码用户错误!');
            }

          },
          complete:function(request,status){
          }});

      },
      onCancel: function () {
        $.toast('取消登录!', 'cancel');
      }
    });
  });

</script>
</body>
</html>
