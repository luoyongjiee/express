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
  <div class="weui_icon_area"><i class="weui_icon_success weui_icon_msg"></i></div>
  <div class="weui_text_area">
    <h2 class="weui_msg_title">操作成功</h2>
   <%-- <p class="weui_msg_desc">内容详情，可根据实际需要安排</p>--%>
  </div>
</div>


<div class="weui_cells">
  <div class="weui_cell">
    <div class="weui_cell_bd weui_cell_primary">
      <p>订单号</p>
    </div>
    <div class="weui_cell_ft">
      ${sendInfo.id}

    </div>
  </div>
</div>

<div class="weui_cells">
  <div class="weui_cell">
    <div class="weui_cell_bd weui_cell_primary">
      <p>创建时间</p>
    </div>
    <div class="weui_cell_ft">
      <fmt:formatDate value="${sendInfo.createTime}" pattern="yyyy-MM-dd HH:mm:ss" />
    </div>
  </div>
</div>

<h2 class="demos-second-title">寄件人信息</h2>
<div class="weui_cells">
  <div class="weui_cell">
    <div class="weui_cell_bd weui_cell_primary">
      <p>寄件人姓名</p>
    </div>
    <div class="weui_cell_ft">
      ${sendInfo.senderName}
    </div>
  </div>
</div>

<div class="weui_cells">
  <div class="weui_cell">
    <div class="weui_cell_bd weui_cell_primary">
      <p>寄件人电话</p>
    </div>
    <div class="weui_cell_ft">
      ${sendInfo.senderPhone}
    </div>
  </div>
</div>

<div class="weui_cells">
  <div class="weui_cell">
    <div class="weui_cell_bd weui_cell_primary">
      <p>寄件人宿舍</p>
    </div>
    <div class="weui_cell_ft">
      ${sendInfo.senderBuilderNum}-${sendInfo.senderRoomNum}
    </div>
  </div>
</div>

<h2 class="demos-second-title">收件人信息</h2>

<div class="weui_cells">
  <div class="weui_cell">
    <div class="weui_cell_bd weui_cell_primary">
      <p>收件人姓名</p>
    </div>
    <div class="weui_cell_ft">
      ${sendInfo.receiverName}
    </div>
  </div>
</div>

<div class="weui_cells">
  <div class="weui_cell">
    <div class="weui_cell_bd weui_cell_primary">
      <p>收件人电话</p>
    </div>
    <div class="weui_cell_ft">
      ${sendInfo.receiverPhone}
    </div>
  </div>
</div>

<div class="weui_cells_title"><font size="4" color="#FF0000">收件人地址</font></div>
<div class="weui_cells">
  <div class="weui_cell">
    <div class="weui_cell_bd weui_cell_primary">
      ${sendInfo.receiverAddress}
    </div>
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
