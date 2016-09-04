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
      <input class="weui_input" type="tel" id="senderName" name="senderName" placeholder="请输入姓名">
    </div>
  </div>

  <div class="weui_cell">
    <div class="weui_cell_hd"><label class="weui_label">电话</label></div>
    <div class="weui_cell_bd weui_cell_primary">
      <input class="weui_input" type="tel" id="senderPhone" name="senderPhone" placeholder="请输入电话">
    </div>
  </div>

  <div class="weui_cell ">
    <div class="weui_cell_hd"><label class="weui_label">栋数</label></div>
    <div class="weui_cell_bd weui_cell_primary">
      <select class="" name="senderBuilderNum" id="senderBuilderNum">
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

  <div class="box" style="padding: 0 5px;">
    <div class="clearfix basic">
      <p class="tt" style="border-top: 15px solid #d9d9d9;">收件信息</p>
     <div class="pickup div1">
      <ul class="toplist">
        <li class="clearfix">
          <div>编号：<input type="text" class="" name="" placeholder="请输入快递号"></div>
          <div>快递：<select class="" name="" >
                            <option selected="" value="0">选择</option>
                            <option value="1">快递一</option>
                            <option value="2">快递二</option>
                          </select><span class="remove" datatype="1" onclick="removefun(1)"></span>

          </div>

        </li>
        <li class="clearfix">
          <div>件数：<input type="number" class="" name="" placeholder="请输入件数"></div>
          <div>时间：<input type="datetime" class="" name="" placeholder="请选择时间"></div>
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

var classnum=1;
  $(function(){
    $("#showTooltips").click(function() {
      var tel = $('#tel').val();
      var code = $('#code').val();
      if(!tel || !/1[3|4|5|7|8]\d{9}/.test(tel)) $.toptip('请输入手机号');
      else if(!code || !/\d{6}/.test(code)) $.toptip('请输入六位手机验证码');
      else {
          var pickUpModelListJson="";
          $.ajax({
            type: "post",
            url: "${pageContext.request.contextPath}/query/sendList",
            data: {"pickUpModelJson":pickUpModelJson},
            dataType: "json",
            success: function(data){
              $.toptip('提交成功', 'success');
              loading = false;
            },
          });
      }
    });

    $('.add').click(function(){
              //=Number($(this).attr('datatype'));
     $('.basic').append('<div class="pickup div'+(classnum+1)+'">'+
             ' <ul class="toplist 2">'+
               '  <li class="clearfix">'+
                '   <div>编号：<input type="text" class="" name=""></div>'+
                '<div>快递：<select class="" name="" >'+
        '  <option selected="" value="0">选择</option>'+
        '  <option value="1">快递一</option>'+
        '  <option value="2">快递二</option>'+
        '</select><span class="remove" onclick="removefun('+(classnum+1)+')""></span>'+
        '       </div>'+
                '       </li>'+
               '       <li class="clearfix">'+
                '       <div>件数：<input type="number" class="" name=""></div>'+
                ' <div>时间：<input type="datetime" class="" name=""></div>'+
                ' </li>'+
               '</ul>'+
      ' <p class="tt" style="border-top: 1px solid #d9d9d9;"></p>'+
      ' </div>');
      $('.add').attr("datatype",(classnum+1));
      classnum=classnum+1;
      $('.clearfix').trigger("create");

    });



  })
function removefun(classnum){
  if(Number($('.clearfix').find('.pickup').size())==1){
    $.toptip('低于一条数不能删除')
  }else{
    $('.div'+classnum).remove()
  }
}
</script>

<script type="text/javascript">


</script>
</body>
</html>
