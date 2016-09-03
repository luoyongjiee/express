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

---
layout: demos
---
<div class="weui_grids">
  <a href="javascript:;" class="weui_grid js_grid" data-id="button">
    <div class="weui_grid_icon">
      <img src="{{ "${pageContext.request.contextPath}/images/icon_nav_button.png" | prepend: site.baseurl }}" alt="">
    </div>
    <p class="weui_grid_label">
      Button
    </p>
  </a>
  <a href="javascript:;" class="weui_grid js_grid" data-id="cell">
    <div class="weui_grid_icon">
      <img src="{{ "${pageContext.request.contextPath}/images/icon_nav_cell.png" | prepend: site.baseurl }}" alt="">
    </div>
    <p class="weui_grid_label">
      Cell
    </p>
  </a>
  <a href="javascript:;" class="weui_grid js_grid" data-id="toast">
    <div class="weui_grid_icon">
      <img src="{{ "${pageContext.request.contextPath}/images/icon_nav_toast.png" | prepend: site.baseurl }}" alt="">
    </div>
    <p class="weui_grid_label">
      Toast
    </p>
  </a>
  <a href="javascript:;" class="weui_grid js_grid" data-id="dialog">
    <div class="weui_grid_icon">
      <img src="{{ "${pageContext.request.contextPath}/images/icon_nav_dialog.png" | prepend: site.baseurl }}" alt="">
    </div>
    <p class="weui_grid_label">
      Dialog
    </p>
  </a>
  <a href="javascript:;" class="weui_grid js_grid" data-id="progress">
    <div class="weui_grid_icon">
      <img src="{{ "${pageContext.request.contextPath}/images/icon_nav_progress.png" | prepend: site.baseurl }}" alt="">
    </div>
    <p class="weui_grid_label">
      Progress
    </p>
  </a>
  <a href="javascript:;" class="weui_grid js_grid" data-id="msg">
    <div class="weui_grid_icon">
      <img src="{{ "${pageContext.request.contextPath}/images/icon_nav_msg.png" | prepend: site.baseurl }}" alt="">
    </div>
    <p class="weui_grid_label">
      Msg
    </p>
  </a>
  <a href="javascript:;" class="weui_grid js_grid" data-id="article">
    <div class="weui_grid_icon">
      <img src="{{ "${pageContext.request.contextPath}/images/icon_nav_article.png" | prepend: site.baseurl }}" alt="">
    </div>
    <p class="weui_grid_label">
      Article
    </p>
  </a>
  <a href="javascript:;" class="weui_grid js_grid" data-id="actionsheet">
    <div class="weui_grid_icon">
      <img src="{{ "${pageContext.request.contextPath}/images/icon_nav_actionSheet.png" | prepend: site.baseurl }}" alt="">
    </div>
    <p class="weui_grid_label">
      ActionSheet
    </p>
  </a>
  <a href="javascript:;" class="weui_grid js_grid" data-id="icons">
    <div class="weui_grid_icon">
      <img src="{{ "${pageContext.request.contextPath}/images/icon_nav_icons.png" | prepend: site.baseurl }}" alt="">
    </div>
    <p class="weui_grid_label">
      Icons
    </p>
  </a>
  <a href="javascript:;" class="weui_grid js_grid">
    <div class="weui_grid_icon">
      <img src="{{ "${pageContext.request.contextPath}/images/icon_nav_panel.png" | prepend: site.baseurl }}" alt="">
    </div>
    <p class="weui_grid_label">
      Panel
    </p>
  </a>
  <a href="javascript:;" class="weui_grid js_grid">
    <div class="weui_grid_icon">
      <img src="{{ "${pageContext.request.contextPath}/images/icon_nav_tab.png" | prepend: site.baseurl }}" alt="">
    </div>
    <p class="weui_grid_label">
      Tabbar
    </p>
  </a>
  <a href="javascript:;" class="weui_grid js_grid">
    <div class="weui_grid_icon">
      <img src="{{ "${pageContext.request.contextPath}/images/icon_nav_search_bar.png" | prepend: site.baseurl }}" alt="">
    </div>
    <p class="weui_grid_label">
      SearchBar
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
