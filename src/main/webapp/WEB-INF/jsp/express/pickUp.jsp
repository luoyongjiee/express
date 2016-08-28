<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
  <title>取件</title>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">

  <meta name="description" content="weui">


  <link rel="stylesheet" href="${pageContext.request.contextPath}/lib/weui.min.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/jquery-weui.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/demo.css">

</head>

<body ontouchstart>


<header class='demos-header'>
  <h1 class="demos-title">取件</h1>
</header>

<div class="weui_cells weui_cells_form">
  <div class="weui_cell">
    <div class="weui_cell_hd"><label class="weui_label">姓名</label></div>
    <div class="weui_cell_bd weui_cell_primary">
      <input class="weui_input" type="tel" id="senderName" name="senderName" placeholder="请输入姓名">
    </div>
  </div>

  <div class="weui_cell">
    <div class="weui_cell_hd"><label class="weui_label">姓名</label></div>
    <div class="weui_cell_bd weui_cell_primary">
      <input class="weui_input" type="tel" id="senderPhone" name="senderPhone" placeholder="请输入电话">
    </div>
  </div>

  <div class="weui_cell weui_cell_select">
    <div class="weui_cell_hd"><label class="weui_label">宿舍栋数</label></div>
    <div class="weui_cell_bd weui_cell_primary">
      <select class="weui_select" name="senderBuilderNum" id="senderBuilderNum">
        <option selected="" value="0">选择</option>
        <option value="1">1栋</option>
        <option value="2">2栋</option>
      </select>
    </div>
  </div>

  <div class="weui_cell">
    <div class="weui_cell_hd"><label class="weui_label">宿舍号</label></div>
    <div class="weui_cell_bd weui_cell_primary">
      <input class="weui_input" type="tel" id="senderRoomNum" name="senderRoomNum" placeholder="宿舍号">
    </div>
  </div>

</div>


<div class="weui_btn_area">
  <a class="weui_btn weui_btn_primary" href="javascript:" id="showTooltips">确定</a>
</div>
</div>

<script src="${pageContext.request.contextPath}/lib/jquery-2.1.4.js"></script>
<script src="${pageContext.request.contextPath}/lib/fastclick.js"></script>

<script src="${pageContext.request.contextPath}/js/jquery-weui.js"></script>


<script>
  $("#showTooltips").click(function() {
    var tel = $('#tel').val();
    var code = $('#code').val();
    if(!tel || !/1[3|4|5|7|8]\d{9}/.test(tel)) $.toptip('请输入手机号');
    else if(!code || !/\d{6}/.test(code)) $.toptip('请输入六位手机验证码');
    else $.toptip('提交成功', 'success');
  });
</script>
</body>
</html>
