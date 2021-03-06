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
    <h2 class="weui_msg_title">您好，欢迎使用小递递，现取件服务已到一段落(我们的接单时间为：00:00~19:00,其他时间无法为您服务，请谅解！)，若刚有下单成功的亲请耐心等候您的递物品，我们将持续为您提供咨询。需要查询递物品进度的亲可点击菜单“跟踪查询”进行查询。如下单后递物品未取到，请您留意微信钱包我们给予的退款服务。以上服务若有不便，敬请谅解，祝您生活愉快！
    </h2>
  </div>

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
