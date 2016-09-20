<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
  <title>查询</title>
  <meta charset="utf-8">
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
  <meta name="description" content="weui">


  <link rel="stylesheet" href="//cdn.bootcss.com/weui/0.4.3/style/weui.min.css">
  <link rel="stylesheet" href="//cdn.bootcss.com/jquery-weui/0.8.0/css/jquery-weui.min.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/demos.css">

</head>

<body ontouchstart>

<div class="weui_search_bar"  id="search_bar">

  <form class="weui_search_outer"  action="${pageContext.request.contextPath}/pickUp/getPickUpModel" method="post">

    <div class="weui_search_inner">
      <i class="weui_icon_search"></i>
      <input type="search" class="weui_search_input" id="searchInput" name="searchInput" placeholder="下单号  收件人名字" required/>
      <a href="javascript:" class="weui_icon_clear" id="search_clear"></a>
    </div>
    <label for="searchInput" class="weui_search_text" id="search_text">
      <i class="weui_icon_search"></i>
      <span>下单号  收件人名字</span>
    </label>

    <a href="javascript:" class="weui_search_cancel" id="search_cancel">取消</a>
  </form>
</div>

<c:if test="${pickUpList != null}">
  <c:forEach items="${pickUpList}" var="pickUpModel">
    <a href="${pageContext.request.contextPath}/pickUp/Detail?id=${pickUpModel.id}&showMsg=false">
      <div class="weui_cells">
        <div class="weui_cell">
          <div class="weui_cell_bd weui_cell_primary">
            <p>单号:${pickUpModel.id}</p>
          </div>
          <div class="weui_cell_ft">
            收件：${pickUpModel.phone}-${pickUpModel.userName}
          </div>
        </div>
      </div>
    </a>
  </c:forEach>
</c:if>

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
