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

    <div id="showInfo">

    </div>

    <div class="weui-infinite-scroll" id="scroll">
      <div class="infinite-preloader"></div>
        <span class="load_info">正在加载</span>
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
  $(document).ready(function(){

    $.ajax({
      type: "post",
      url: "${pageContext.request.contextPath}/feedback/listFeedback",
      data: {"offset":param.offset,"limit":param.limit},
      dataType: "json",
      success: function(data){
        param.loading = false;

        $.each(data.list,function(i,obj){
          var content = obj.content;
           if(content.length > 10)
             content = content.substring(0,10)+"...";
          $("#showInfo").append(showList.getDiv(obj.id,obj.id,content));
        })

        if(param.offset>=data.count ){
            $('.load_info').html("已加载全部");
            $('.infinite-preloader').hide();
        }
        param.offset = param.offset + param.limit;
      },
      complete:function(request,status){

      }});


    $(document.body).infinite().on("infinite", function() {
      if(param.loading) return;
      param.loading = true;

      $.ajax({
        type: "post",
        url: "${pageContext.request.contextPath}/feedback/listFeedback",
        data: {"offset":param.offset,"limit":param.limit},
        dataType: "json",
        success: function(data){
          param.loading = false;

          $.each(data.list,function(i,obj){
            var content = obj.content;
            if(content.length > 10)
              content = content.substring(0,10)+"...";
            $("#showInfo").append(showList.getDiv(obj.id,obj.id,content));
          })

          if(param.offset>=data.count ){
              $("#scroll").html("已经加载完毕");
              $('.infinite-preloader').hide();
          }

          param.offset = param.offset + param.limit;
        },
        complete:function(request,status){

        }});

    });

  });

 var param = {
   "loading":false,
   "offset":0,
   "limit":10
 }

 var showList = {
   getDiv: function (param, title, content) {
     var html = "<a href='${pageContext.request.contextPath}/feedback/showFeedback?id="+param+"'>"
             + "<div class=\"weui_cells\">"
             + "<div class=\"weui_cell\">"
             + "<div class=\"weui_cell_bd weui_cell_primary\">"
             + "<p>" + title + "</p>"
             + "</div>"
             + "<div class=\"weui_cell_ft\">"
             + content
             + "</div>"
             + "</div>"
             + "</div>"
             + "</a>";

     return html;
   },
   format:function(time, format){
    var t = new Date(time);
    var tf = function(i){return (i < 10 ? '0' : '') + i};
     return format.replace(/yyyy|MM|dd|HH|mm|ss/g, function(a){
       switch(a){
         case 'yyyy':
           return tf(t.getFullYear());
           break;
         case 'MM':
           return tf(t.getMonth() + 1);
           break;
         case 'mm':
           return tf(t.getMinutes());
           break;
         case 'dd':
           return tf(t.getDate());
           break;
         case 'HH':
           return tf(t.getHours());
           break;
         case 'ss':
           return tf(t.getSeconds());
           break;
       }
     });

  }

 }

</script>
</body>
</html>
