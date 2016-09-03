<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
  <title>反馈列表</title>
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

    <a href="${pageContext.request.contextPath}/getSendDetail?id=${sendInfoModel.id}">
      <div class="weui_cells">
        <div class="weui_cell">
          <div class="weui_cell_bd weui_cell_primary">
            <p></p>
          </div>
          <div class="weui_cell_ft">
          </div>
        </div>
      </div>
    </a>

    <div class="weui-infinite-scroll">
      <div class="infinite-preloader"></div>
      正在加载
    </div>
<script src="//cdn.bootcss.com/jquery/1.11.0/jquery.min.js"></script>
<script src="//cdn.bootcss.com/jquery-weui/0.8.0/js/jquery-weui.min.js"></script>
<script src="${pageContext.request.contextPath}/lib/fastclick.js"></script>
<script>
  $(function() {
    FastClick.attach(document.body);
  });
</script>

<script>
  var loading = false;
  var offset = 0;
  var page = 1;
  $(document.body).infinite().on("infinite", function() {
    if(loading) return;
    loading = true;

    $.ajax({
      type: "post",
      url: "${pageContext.request.contextPath}/feedback/listFeedback",
      data: {"offset":offset,"limit":10},
      dataType: "json",
      success: function(data){
        loading = false;
        offset = page * 10 -1;
        page = page + 1;
      },
      complete:function(request,status){

      }});

  });
</script>
</body>
</html>
