<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
  <title>取件下单</title>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">

  <meta name="description" content="weui">


  <link rel="stylesheet" href="${pageContext.request.contextPath}/lib/weui.min.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/jquery-weui.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/demo.css">

  <style type="text/css">
    .box .tt {
      line-height: 37px;
      font-size: 13px;
      color: #4c4c4b;
      border-bottom: 1px solid #d7d7d7;
    }
    ol, ul, li {
      list-style: none;
    }
    li {
      display: -webkit-box;
      display: -moz-box;
      display: -ms-flexbox;
      /*
            border-bottom: 1px solid #d7d7d7;
      */
    }
    li div {
      width: 50%;
      padding: 8px 0;
      color: #4c4c4b;
      font-size: 15px;
    }
    li input{
      width: 58%;
      font-size: 15px;
    }
    span{
      float: right;
      width:30px;
      height: 30px;
      border:0px;
      background-image: url("${pageContext.request.contextPath}/images/remove.png");
      background-position: 50% 50%;
    }
    .add{
      background-image: url("${pageContext.request.contextPath}/images/add.png");
    }

  </style>

</head>

<body ontouchstart>


<header class='demos-header'>
  <h1 class="demos-title">取件</h1>
</header>

<div class="weui_cells weui_cells_form">
  <div class="weui_cell">
    <div class="weui_cell_hd"><label class="weui_label">姓名</label></div>
    <div class="weui_cell_bd weui_cell_primary">
      <input class="weui_input user_name" type="text"  placeholder="请输入姓名">
    </div>
  </div>

  <div class="weui_cell">
    <div class="weui_cell_hd"><label class="weui_label">电话</label></div>
    <div class="weui_cell_bd weui_cell_primary">
      <input class="weui_input user_phone" type="text" placeholder="请输入电话">
    </div>
  </div>

  <div class="weui_cell ">
    <div class="weui_cell_hd"><label class="weui_label">栋数</label></div>
    <div class="weui_cell_bd weui_cell_primary">
      <select class="builder_num weui_select"  >
        <option selected="" value="0">选择</option>
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
      <input class="weui_input room_num" type="number" placeholder="宿舍号">
    </div>
  </div>

  <div class="box" style="padding: 0 5px;">
    <div class="clearfix basic">
      <p class="tt" style="border-top: 15px solid #d9d9d9;">收件信息</p>
      <div class="pickup div1">
        <ul class="toplist pick_up_model_i">
          <li class="clearfix ">
            <div>编号：<input type="text" class="code" name="" placeholder="请输入快递号"></div>
            <div>快递：<select  name="express" class="express" >
              <option selected="" value="0">选择</option>
              <option value="1">中通快递</option>
              <option value="2">圆通快递</option>
              <option value="3">申通快递</option>
              <option value="4">韵达快递</option>
              <option value="5">顺丰快递</option>
              <option value="6">邮政快递</option>
              <option value="7">优速快递</option>
              <option value="8">天猫</option>
              <option value="9">京东</option>
              <option value="10">百世汇通</option>
              <option value="11">国通快递</option>
            </select><span class="remove" datatype="1" onclick="removefun(1)"></span>

            </div>

          </li>
          <li class="clearfix">
            <div>件数：<input type="number" class="count" placeholder="请输入件数"></div>
            <div>时间：
              <input type="text" class="pickUpTime"  style="width: 130px" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH-mm'});">
              <%-- <input type="datetime-local" class="pickUpTime" placeholder="请选择时间">--%>
            </div>
          </li>
        </ul>
        <p class="tt" style="border-top: 1px solid #d9d9d9;"></p>
      </div>

    </div>
    <span class="add" datatype="1"></span>

  </div>
</div>


<div class="weui_btn_area">
  <a class="weui_btn weui_btn_primary" href="javascript:" id="showTooltips">提交订单</a>
</div>
</div>

<script src="${pageContext.request.contextPath}/lib/jquery-2.1.4.js"></script>
<script src="${pageContext.request.contextPath}/lib/fastclick.js"></script>

<script src="${pageContext.request.contextPath}/js/jquery-weui.js"></script>


<script>
  $(function() {
    FastClick.attach(document.body);
  });
</script>
</body>
</html>