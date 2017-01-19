<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
  <title>在线客服</title>
  <meta charset="utf-8">
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
  <meta name="description" content="weui">

  <link rel="stylesheet" href="//cdn.bootcss.com/weui/0.4.3/style/weui.min.css">
  <link rel="stylesheet" href="//cdn.bootcss.com/jquery-weui/0.8.0/css/jquery-weui.min.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/demos.css">

</head>
<body ontouchstart style="background: gainsboro">


<script src="//cdn.bootcss.com/jquery/1.11.0/jquery.min.js"></script>
<script src="//cdn.bootcss.com/jquery-weui/0.8.0/js/jquery-weui.min.js"></script>
<script src="${pageContext.request.contextPath}/lib/fastclick.js"></script>

<div id="content" class="weui_panel weui_panel_access">
  <div class="weui-row">
    <div class="weui-col-80">
      <div class="weui_cell_bd weui_cell_primary">
        hi，您好，我是小递递，现在让我为您服务，请输入您想问的内容！
      </div>
    </div>
    <div class="weui-col-20"></div>
  </div>
</div>

<br><br><br>
<div >
  <div class="weui-row">
    <div class="weui_cell_bd weui_cell_primary">
      <textarea class="weui_textarea" placeholder="请输入发送内容" rows="3" id="msg"></textarea>
    </div>
  </div>
  <div class="button_sp_area">
    <div class="weui-row">
      <div class="weui-col-20"></div>
      <div class="weui-col-20"><a  href="javascript:;" class="weui_btn weui_btn_mini weui_btn_primary" id="btnSend">&nbsp;发送&nbsp;</a></div>
    </div>
  </div>

</div>

<script src="//cdn.bootcss.com/jquery/1.11.0/jquery.min.js"></script>
<script src="//cdn.bootcss.com/jquery-weui/0.8.0/js/jquery-weui.min.js"></script>
<script src="${pageContext.request.contextPath}/lib/fastclick.js"></script>
<script>
  $(function() {
    FastClick.attach(document.body);

    $("#btnSend").click(function(){

      var sendMsg = $.trim($("#msg").val());
      $("#msg").val("");
      if(sendMsg == ""|| sendMsg == null){
        return;
      }

      var msg = '<div class="weui-row" id=""><div class="weui-col-20"></div> <div class="weui-col-80"> <div class="weui_cell_ft">';

      /* msg = msg + '<p class="weui_btn weui_btn_plain_default">'+sendMsg+'</p>';*/
      msg = msg +sendMsg;
      msg = msg + ' </div> </div></div><br>';
      $("#content").append(msg);


      $.ajax({
        type: "post",
        url: "${pageContext.request.contextPath}/custom/msg",
        data: {msg:sendMsg},
        dataType: "json",
        success: function(data){
          var arr = data.result;
          if(arr != null){
            var result= ' <div class="weui-row"><div class="weui-col-80"><div class="weui_cell_bd weui_cell_primary">';
             /*result = result +'<p class="weui_btn weui_btn_plain_default">';*/
            result = result + "hi,我是您的小递递:<br>"
             for(var i = 0; i < arr.length; i++){
               result = result + '<span "linkMsg"> <a   href="javascript:;"  index="'+arr[i].id+'">'+arr[i].keyword+'<a></span><br>';
             }

            /*result = result + '</p>';*/
            result = result + '</div> </div><div class="weui-col-20"></div> </div><br>'

            $("#content").append(result);

            $("a").on("click",function(){
              var index= $(this).attr("index");

              $.ajax({
                type: "post",
                url: "${pageContext.request.contextPath}/custom/showMsg",
                data: {id:index},
                dataType: "json",
                success: function(data){
                  if(data != null){
                    $.alert(data.msg);
                  }
                },
                complete:function(request,status){}});
            });




          }
        },
        complete:function(request,status){}});

    });



  });

</script>
</body>
</html>
