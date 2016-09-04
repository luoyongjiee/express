<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
  <title>菜单</title>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">

  <meta name="description" content="weui">


  <link rel="stylesheet" href="//cdn.bootcss.com/weui/0.4.3/style/weui.min.css">
  <link rel="stylesheet" href="//cdn.bootcss.com/jquery-weui/0.8.0/css/jquery-weui.min.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/demo.css">


</head>

<body ontouchstart>

<div class="weui_grids">

  <a href="${pageContext.request.contextPath}/query/sendList" class="weui_grid js_grid" data-id="toast">
    <div class="weui_grid_icon">
      <img src="${pageContext.request.contextPath}/images/icon_nav_cell.png" alt="">
    </div>
    <p class="weui_grid_label">
      寄件列表
    </p>
  </a>

  <a href="javascript:;" class="weui_grid js_grid" data-id="toast">
    <div class="weui_grid_icon">
      <img src="${pageContext.request.contextPath}/images/icon_nav_cell.png" alt="">
    </div>
    <p class="weui_grid_label">
      取件列表
    </p>
  </a>

  <a href="${pageContext.request.contextPath}/path/express/feedbackList;" class="weui_grid js_grid" data-id="toast">
    <div class="weui_grid_icon">
      <img src="${pageContext.request.contextPath}/images/icon_nav_cell.png" alt="">
    </div>
    <p class="weui_grid_label">
      反馈列表
    </p>
  </a>


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
