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
      <input class="weui_input user_name" type="text" id="userName"  placeholder="请输入姓名">
    </div>
  </div>

  <div class="weui_cell">
    <div class="weui_cell_hd"><label class="weui_label">电话</label></div>
    <div class="weui_cell_bd weui_cell_primary">
      <input class="weui_input user_phone" type="text" id="phone" placeholder="请输入电话">
    </div>
  </div>

  <div class="weui_cell ">
    <div class="weui_cell_hd"><label class="weui_label">宿舍栋数</label></div>
    <div class="weui_cell_bd weui_cell_primary">
      <select class="builder_num weui_select"  id="buildingNum">
          <option selected="" value="0">选择</option>
          <option value="6">6栋</option>
          <option value="7">7栋</option>
          <option value="8">8栋</option>
          <option value="9">9栋</option>
          <option value="10">10栋</option>
          <option value="11">11栋</option>
          <option value="12">12栋</option>
      </select>
    </div>
  </div>

  <div class="weui_cell">
    <div class="weui_cell_hd"><label class="weui_label">宿舍号</label></div>
    <div class="weui_cell_bd weui_cell_primary">
      <input class="weui_input room_num" type="number" id="buildingCode" placeholder="宿舍号">
    </div>
  </div>

    <div class="weui_cell">
        <div class="weui_cell_hd"><label class="weui_label">备注</label></div>
        <div class="weui_cell_bd weui_cell_primary">
            <input class="weui_input remark" type="text"  placeholder="是否放鞋柜/门口/其他">
        </div>
    </div>

    <div class="box" style="padding: 0 5px;">
        <div class="clearfix basic">
            <p class="tt" style="border-top: 15px solid #d9d9d9;">收件信息</p>
            <div class="pickup div1">
                <ul class="toplist pick_up_model_i">
                    <span class="remove" datatype="1" onclick="removefun(1)"></span>
                    <li >
                        <div>编号：<input type="text" class="code" style="width: 600px;height:35px" name="" placeholder="快递信息中的编号"></div>
                    </li>
                    <li>
                        <div>快递：<select  name="express" class="express" style="width: 600px;height:35px">
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
                            <option value="12">其他</option>
                        </select>

                        </div>

                    </li>
                    <li >
                        <div>件数：<input type="number" class="count" placeholder="请输入件数" style="width: 600px;height:35px"></div>
                    </li>
                    <li>
                        <div  style="clear:both;">快递签收到达时间：
                            <input type="text" class="pickUpTime"   onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm'});" style="width: 600px;height:35px">
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

var classnum=1;
  $(function(){
    $("#showTooltips").click(function() {
        var user_name = $('.user_name').val();
        var tel = $('.user_phone').val();
        if(!tel || !/1[3|4|5|7|8]\d{9}/.test(tel)){//else if(!code || !/\d{6}/.test(code)) $.toptip('请输入六位手机验证码');
          $.toptip('请输入手机号');
        } else {
            var pickUpModel ;
            var pickUpModelOrder = new Array();
            var user_name = $('.user_name').val();
            var user_phone = $('.user_phone').val();
            var builderNum = $('.builder_num').val();
            var roomNum = $('.room_num').val();
            var remark = $('.remark').val();

            if(user_name == ''||user_name == null){
                $.toptip("请输入姓名！");
                return;
            }

            if(user_phone == ''||user_phone == null){
                $.toptip("请输入电话！");
                return;
            }

            if(builderNum == ''||builderNum == null){
                $.toptip("请输入宿舍栋数！");
                return;
            }

            if(roomNum == ''||roomNum == null){
                $.toptip("请输入宿舍号！");
                return;
            }

            var pickUserJson= {
                userName : user_name,
                phone : user_phone,
                buildingNum : builderNum,
                buildingCode : roomNum,
                remark:remark
            };
            var quitOut = false;
            $(".pick_up_model_i").each(function() {
                //var id = $(this).next("input").val();
                var count = $(this).find('.count').val();
                var express = $(this).find('.express').find("option:selected").val();
                var code = $(this).find('.code').val();
                var pickUpTime = $(this).find('.pickUpTime').val();


                if(count==''||count==null){
                    $.toptip("件数不能为空！");
                    quitOut = true;
                    return;
                } else if(express=='0'||express == 0){
                    $.toptip("快递公司不能为空！");
                    quitOut = true;
                    return;
                } else if(code==''||code == null){
                    $.toptip("编号不能为空！");
                    quitOut = true;
                    return;
                } else if(pickUpTime==''||pickUpTime == null){
                    $.toptip("日期不能为空！");
                    quitOut = true;
                    return;
                }

                //var userId = $("#no_" + id).val();
                //alert(count);
                pickUpModel = {
                    count : count,
                    express : express,
                    expressCode : code,
                    expressDateStr : pickUpTime
                };
                pickUpModelOrder.push(pickUpModel);
            });

            if(quitOut){
                return;
            }
          var pickUpModelListJson=JSON.stringify(pickUpModelOrder);
          $.ajax({
             type: "post",
             url: "${pageContext.request.contextPath}/insert/pickUpOrder",
             data: {"pickUpModelListJson":pickUpModelListJson,"pickUserJson":JSON.stringify(pickUserJson)},
             dataType: "json",
              success: function(data){

                  window.location.href="${pageContext.request.contextPath}/pay/nakeOrder/?pickUpId="+data;
              },
              complete:function(request,status){
                  $.hideLoading();
              }
          });

            $.showLoading("正在提交订单...");
      }
    });


    $('.add').click(function(){
              //=Number($(this).attr('datatype'));
     $('.basic').append('<div class="pickup div'+(classnum+1)+'">'+
             ' <ul class="toplist pick_up_model_i">'+
             '<span class="remove" onclick="removefun('+(classnum+1)+')""></span>'+
               '  <li class="clearfix ">'+
                '   <div>编号：<input type="text" class="code" name="" style="width: 600px;height:35px"></div></li><li>'+
                '<div>快递：<select class="express"  style="width: 600px;height:35px">'+
        '  <option selected="" value="0" >选择</option> '+
             '   <option value="1">中通快递</option>'+
        '     <option value="2">圆通快递</option>'+
        '    <option value="3">申通快递</option>'+
        '     <option value="4">韵达快递</option>'+
        '     <option value="5">顺丰快递</option>'+
        '       <option value="6">邮政快递</option>'+
        '       <option value="7">优速快递</option>'+
        '      <option value="8">天猫</option>'+
        '      <option value="9">京东</option>'+
        '      <option value="10">百世汇通</option>'+
        '      <option value="11">国通快递</option>'+
        '</select>'+
        '       </div>'+
                '       </li>'+
               '       <li class="clearfix">'+
                '       <div>件数：<input type="number" class="count" style="width: 600px;height:35px"></div></li><li>'+
                ' <div>快递签收到达时间：<input type="text" class="pickUpTime"  style="width: 600px;height:35px" placeholder="输入收件时间"></div>'+
                ' </li>'+
               '</ul>'+
      ' <p class="tt" style="border-top: 1px solid #d9d9d9;"></p>'+
      ' </div>');




      $('.add').attr("datatype",(classnum+1));
      classnum=classnum+1;
      $('.clearfix').trigger("create");
        $('.pickUpTime').click(function(){
            WdatePicker({dateFmt:'yyyy-MM-dd HH:mm'});
        });
    });

      $.ajax({
          type: "post",
          url: "${pageContext.request.contextPath}/pickUp/userInfo",
          data: {},
          dataType: "json",
          success: function(data){
              var result = data.data;
              if(result!=null&&result!=undefined){
                  $("#userName").val(result.userName);
                  $("#phone").val(result.phone);
                  $("#buildingCode").val(result.buildingCode);

                  $("#buildingNum option").removeAttr("selected");
                  $("#buildingNum option[value='"+result.buildingNum+"']").attr("selected", true);

              }
          },
          complete:function(request,status){}
      });


  });


function removefun(classnum){
  if(Number($('.clearfix').find('.pickup').size())==1){
    $.toptip('低于一条数不能删除')
  }else{
    $('.div'+classnum).remove()
  }
}
</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/lib/My97DatePicker/WdatePicker.js"></script>

<script>
    $("#time").datetimePicker();
</script>
</body>
</html>
