<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
  <title>消息</title>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">

  <meta name="description" content="weui">


  <link rel="stylesheet" href="//cdn.bootcss.com/weui/0.4.3/style/weui.min.css">
  <link rel="stylesheet" href="//cdn.bootcss.com/jquery-weui/0.8.0/css/jquery-weui.min.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/demo.css">


</head>

<body ontouchstart>

<div class="weui_msg">

  <div class="weui_text_area">
    <h2 class="weui_msg_title">${customMsg.msg}</h2>
  </div>
  <div class="weui_icon_area"><a href="${pageContext.request.contextPath}/path/express/custom_service">在线客服</a></div>
</div>


<script src="//cdn.bootcss.com/jquery/1.11.0/jquery.min.js"></script>
<script src="//cdn.bootcss.com/jquery-weui/0.8.0/js/jquery-weui.min.js"></script>
<script src="${pageContext.request.contextPath}/lib/fastclick.js"></script>
<script>
  $(function() {
    FastClick.attach(document.body);
  });
</script>


</body>
</html>
