<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
<c:if test="${showMsg}">
  <div class="weui_msg">
    <div class="weui_icon_area"><i class="weui_icon_success weui_icon_msg"></i></div>
    <div class="weui_text_area">
      <h2 class="weui_msg_title">添加取订单成功</h2>
    </div>
  </div>
</c:if>


<header class='demos-header'>
  <h1 class="demos-title">取件</h1>
</header>

<div class="weui_cells weui_cells_form">
  <div class="weui_cell">
    <div class="weui_cell_hd"><label class="weui_label">订单号</label></div>
    <div class="weui_cell_bd weui_cell_primary">
      <input class="weui_input id" type="text"  placeholder="请输入订单号" value="${pickUp.id}" readonly>
    </div>
  </div>

  <div class="weui_cell">
    <div class="weui_cell_hd"><label class="weui_label">姓名</label></div>
    <div class="weui_cell_bd weui_cell_primary">
      <input class="weui_input user_name" type="text"  placeholder="请输入姓名" value="${pickUp.userName}" readonly>
    </div>
  </div>

  <div class="weui_cell">
    <div class="weui_cell_hd"><label class="weui_label">电话</label></div>
    <div class="weui_cell_bd weui_cell_primary">
      <input class="weui_input user_phone" type="text" placeholder="请输入电话" value="${pickUp.phone}" readonly>
    </div>
  </div>

  <div class="weui_cell ">
    <div class="weui_cell_hd"><label class="weui_label">栋数</label></div>
    <div class="weui_cell_bd weui_cell_primary">
      <input class="weui_input buildingNum" type="text" placeholder="请输入栋数" value="${pickUp.buildingNum}" readonly>
    </div>
  </div>

  <div class="weui_cell">
    <div class="weui_cell_hd"><label class="weui_label">宿舍号</label></div>
    <div class="weui_cell_bd weui_cell_primary">
      <input class="weui_input room_num" type="number" placeholder="宿舍号" value="${pickUp.buildingCode}" readonly>
    </div>
  </div>

  <div class="weui_cell">
    <div class="weui_cell_hd"><label class="weui_label">备注</label></div>
    <div class="weui_cell_bd weui_cell_primary">
      <input class="weui_input remark" type="text"  value="${pickUp.remark}" readonly>
    </div>
  </div>

  <div class="weui_cell">
    <div class="weui_cell_hd"><label class="weui_label">创建时间</label></div>

    <div class="weui_cell_bd weui_cell_primary">
      <fmt:formatDate value="${pickUp.createTime}" pattern="yyyy-MM-dd HH:mm:ss" />
    </div>
  </div>

<br>
  <c:if test="${pickUpInfoList != null}">
    <c:forEach items="${pickUpInfoList}" var="pickUpInfo">
        <div class="weui_progress">
          <div class="weui_progress_bar">
            <div class="weui_progress_inner_bar js_progress" style="width: 100%;"></div>
          </div>
          <a href="javascript:;" class="weui_progress_opr">
            <i class="weui_icon_cancel"></i>
          </a>
        </div>

        <div class="weui_cell">
          <div class="weui_cell_hd"><label class="weui_label">编号</label></div>
          <div class="weui_cell_bd weui_cell_primary">
            <input class="weui_input room_num" type="number" placeholder="编号" value="${pickUpInfo.expressCode}" readonly>
          </div>
        </div>

        <div class="weui_cell">
          <div class="weui_cell_hd"><label class="weui_label">快递</label></div>
          <div class="weui_cell_bd weui_cell_primary">
            <input class="weui_input room_num" type="text" placeholder="快递" value="${pickUpInfo.express}" readonly>
          </div>
        </div>

        <div class="weui_cell">
          <div class="weui_cell_hd"><label class="weui_label">件数</label></div>
          <div class="weui_cell_bd weui_cell_primary">
            <input class="weui_input room_num" type="text" placeholder="件数" value="${pickUpInfo.count}" readonly>
          </div>
        </div>


        <div class="weui_cell">
          <div class="weui_cell_hd"><label class="weui_label">快递签收到达时间</label></div>
          <div class="weui_cell_bd weui_cell_primary">
            <fmt:formatDate value="${pickUpInfo.expressDate}" pattern="yyyy-MM-dd HH:mm:ss" />
          </div>
        </div>


        <div class="weui_progress">
          <div class="weui_progress_bar">
            <div class="weui_progress_inner_bar js_progress" style="width: 100%;"></div>
          </div>
          <a href="javascript:;" class="weui_progress_opr">
            <i class="weui_icon_cancel"></i>
          </a>
        </div>
    </c:forEach>
  </c:if>

  <br>

  <div class="weui_cell">
    <div class="weui_cell_hd"><label class="weui_label">订单状态</label></div>
    <div class="weui_cell_bd weui_cell_primary">
      <c:if test="${pickUp.orderStatus eq '0'}">
        <input class="weui_input orderStatus" id="orderStatus" type="text"  value="待取" readonly>
      </c:if>

      <c:if test="${pickUp.orderStatus eq '1'}">
        <input class="weui_input orderStatus" id="orderStatus" type="text"  value="已取" readonly>
      </c:if>

      <c:if test="${pickUp.orderStatus eq '2'}">
        <input class="weui_input orderStatus" id="orderStatus" type="text"  value="已派送" readonly>
      </c:if>

      <c:if test="${pickUp.orderStatus eq '3'}">
        <input class="weui_input orderStatus" id="orderStatus" type="text"  value="存件" readonly>
      </c:if>

      <c:if test="${pickUp.orderStatus eq '4'}">
        <input class="weui_input orderStatus" id="orderStatus" type="text"  value="未取" readonly>
      </c:if>

      <c:if test="${pickUp.orderStatus eq '5'}">
        <input class="weui_input orderStatus" id="orderStatus" type="text"  value="已申请退款" readonly>
      </c:if>

      <c:if test="${pickUp.orderStatus eq '6'}">
        <input class="weui_input orderStatus" id="orderStatus" type="text"  value="申请退款失败" readonly>
      </c:if>
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
