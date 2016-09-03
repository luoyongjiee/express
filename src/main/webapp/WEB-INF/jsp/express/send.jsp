<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
  <title>寄件</title>
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

<form action="${pageContext.request.contextPath}/addSend" method="post"  id="formAddSend" <%--onsubmit="return validate()"--%>>

<header class='demos-header'>
  <h1 class="demos-title">寄件</h1>
</header>
<h2 class="demos-second-title">寄件人信息</h2>
<div class="weui_cells weui_cells_form">
  <div class="weui_cell">
    <div class="weui_cell_hd"><label class="weui_label">姓名</label></div>
    <div class="weui_cell_bd weui_cell_primary">
      <input class="weui_input" type="text" id="senderName" name="senderName" placeholder="请输入姓名">
    </div>
  </div>

  <div class="weui_cell">
    <div class="weui_cell_hd"><label class="weui_label">电话</label></div>
    <div class="weui_cell_bd weui_cell_primary">
      <input class="weui_input" type="number" id="senderPhone" name="senderPhone" placeholder="请输入电话">
    </div>
  </div>

  <div class="weui_cell weui_cell_select">
    <div class="weui_cell_hd"><label class="weui_label">宿舍栋数</label></div>
    <div class="weui_cell_bd weui_cell_primary">
      <select class="weui_select" name="senderBuilderNum" id="senderBuilderNum">
          <option selected="" value="-1">选择</option>
          <option value="1">6栋</option>
          <option value="2">7栋</option>
          <option value="1">8栋</option>
          <option value="2">9栋</option>
          <option value="1">10栋</option>
          <option value="2">11栋</option>
          <option value="2">12栋</option>
      </select>
    </div>
  </div>

  <div class="weui_cell">
    <div class="weui_cell_hd"><label class="weui_label">宿舍号</label></div>
    <div class="weui_cell_bd weui_cell_primary">
      <input class="weui_input" type="number" id="senderRoomNum" name="senderRoomNum" placeholder="宿舍号">
    </div>
  </div>

</div>

<h2 class="demos-second-title">收件人信息</h2>

<div class="weui_cells weui_cells_form">
  <div class="weui_cell">
    <div class="weui_cell_hd"><label class="weui_label">姓名</label></div>
    <div class="weui_cell_bd weui_cell_primary">
      <input class="weui_input" type="text" id="receiverName" name="receiverName" placeholder="请输入收件人姓名">
    </div>
  </div>

  <div class="weui_cell">
    <div class="weui_cell_hd"><label class="weui_label">电话</label></div>
    <div class="weui_cell_bd weui_cell_primary">
      <input class="weui_input" type="number" id="receiverPhone" name="receiverPhone" placeholder="请输入收件人电话">
    </div>
  </div>

</div>

<div class="weui_cells_title"><font size="4" color="#FF0000">地址</font></div>
<div class="weui_cells weui_cells_form">
  <div class="weui_cell">
    <div class="weui_cell_bd weui_cell_primary">
      <textarea class="weui_textarea" id="receiverAddress" name="receiverAddress" placeholder="请输入收件人地址" rows="3"></textarea>
      <div class="weui_textarea_counter"><span>0</span>/200</div>
    </div>
  </div>
</div>

  <div class="weui_btn_area">
    <input name="btnAddSend"  class="weui_btn weui_btn_primary" type="button" id="btnAddSend" value="提交">
  </div>

</div>
</form>
<!-- body 最后 -->
<script src="//cdn.bootcss.com/jquery/1.11.0/jquery.min.js"></script>
<script src="//cdn.bootcss.com/jquery-weui/0.8.0/js/jquery-weui.min.js"></script>

<script src="${pageContext.request.contextPath}/lib/fastclick.js"></script>
<script>
    $(document).ready(function(){
        $("#btnAddSend").click(function(){
            var obj = new Object();

            obj.senderName = $("#senderName").val();

            if(Utils.validate(obj.senderName)) {
                $.toptip('请输寄件人姓名');
                return false;
            }


            obj.senderPhone = $("#senderPhone").val();
            if(Utils.validate(obj.senderPhone)) {
                $.toptip('请输寄件人电话');
                return false;
            }


            obj.senderBuilderNum = $("#senderBuilderNum").find("option:selected").val();
            if(obj.senderBuilderNum == -1||obj.senderBuilderNum == "-1") {
                $.toptip('请输寄件人宿舍栋数');
                return false;
            }


            obj.senderRoomNum = $("#senderRoomNum").val();
            if(Utils.validate(obj.senderRoomNum)) {
                $.toptip('请输寄件人宿舍号');
                return false;
            }

            obj.receiverName = $("#receiverName").val();

            if(Utils.validate(obj.receiverName)) {
                $.toptip('请输收件人姓名');
                return false;
            }

            obj.receiverPhone = $("#receiverPhone").val();
            if(Utils.validate(obj.receiverPhone)) {
                $.toptip('请输收件人电话');
                return false;
            }

            obj.receiverAddress = $("#receiverAddress").val();

            if(Utils.validate(obj.receiverAddress)) {
                $.toptip('请输收件人地址');
                return false;
            }

            console.log("start");
            $.ajax({
                type: "post",
                url: "${pageContext.request.contextPath}/addSend",
                data: obj,
                dataType: "json",
                success: function(data){
                    window.location.href = "${pageContext.request.contextPath}/addSendMsg?id="+data;
                },
                complete:function(request,status){
                    $.hideLoading();
                }});


            $.showLoading("正在提交订单...");
            console.log("end");

        });
    });


  var Utils =  {
    validate:function(arg){
      if(arg == ""|| arg ==null || arg == undefined)
        return true;
      return false;
    }
  }

</script>
</body>
</html>
