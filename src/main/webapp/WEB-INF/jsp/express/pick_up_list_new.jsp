<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>取件列表</title>
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
<div class="weui_cell">
    <div class="weui_cell_hd"><label for="date" class="weui_label">日期</label></div>
    <div class="weui_cell_bd weui_cell_primary">
        <input class="weui_input" id="date" type="text" value="${date}">
    </div>
    <a href="javascript:;" class="weui_btn weui_btn_mini weui_btn_default" id="btnUpdate">刷新</a>
</div>
<br>


<div id="list">
<c:if test="${pickUpList != null&&pickUpList.size()>0}">
    <c:forEach items="${pickUpList}" var="pickUpModel">
        <div class="weui_cell weui_cell_switch">
            <div class="weui_cell_hd weui_cell_primary">选择</div>
            <div class="weui_cell_ft">
                <input class="weui_switch" type="checkbox" value="${pickUpModel.id}">
            </div>
        </div>
        <a href="${pageContext.request.contextPath}/pickUp/showPickUpInfo?id=${pickUpModel.id}&showMsg=false">
        <div class="weui_cells">
            <div class="weui_cell">
                <div class="weui_cell_bd weui_cell_primary">
                    <p>姓名:${pickUpModel.userName}</p>
                    <p>宿舍号:${pickUpModel.buildingNum}栋${pickUpModel.buildingCode}</p>
                </div>
                <div class="weui_cell_ft">
                    <c:forEach items="${pickUpInfoList}" var="pickUpInfoModel">
                        <c:if test="${pickUpInfoModel.pickUpId eq pickUpModel.id}">
                            <p>快递:${expressList[pickUpInfoModel.express]}</p>
                            <p>编号:${pickUpInfoModel.expressCode}</p>
                        </c:if>
                    </c:forEach>
                </div>
            </div>
        </div>
        </a>
        <br>
    </c:forEach>
</c:if>
</div>


<a href="javascript:;" class="weui_btn weui_btn_primary" index="0">更新待取状态</a>
<a href="javascript:;" class="weui_btn weui_btn_primary" index="1">更新已取状态</a>
<a href="javascript:;" class="weui_btn weui_btn_primary" index="2">更新已派送状态</a>
<a href="javascript:;" class="weui_btn weui_btn_primary" index="3">更新存件状态</a>
<a href="javascript:;" class="weui_btn weui_btn_primary" index="4">更新未取状态</a>

<script src="//cdn.bootcss.com/jquery/1.11.0/jquery.min.js"></script>
<script src="//cdn.bootcss.com/jquery-weui/0.8.0/js/jquery-weui.min.js"></script>
<script src="${pageContext.request.contextPath}/lib/fastclick.js"></script>
<script>
    $(function() {
        FastClick.attach(document.body);
    });
</script>
<script>
    var express = "${express}";

    $(function(){
       $("#date").calendar({
            onChange: function (p, values, displayValues) {
            }
        });


       /* $("#date").val(pickUpList.getNowFormatDate());*/


        $("a").click(function(){
            var index = $(this).attr("index");

            if(index != undefined){
                var orderArray = new Array();
                $(".weui_switch").each(function(){
                   if($(this).prop("checked")){
                       var order = {};
                       order.id = $(this).val();
                       order.status = index;
                       orderArray.push(order);
                    }
                });

                if(orderArray.length == 0){
                    $.alert("请选择订单！");
                    return ;
                }

                $.ajax({
                    type: "post",
                    url: "${pageContext.request.contextPath}/pickUp/updateOrderStatus",
                    data: JSON.stringify(orderArray),
                    dataType: "json",
                    contentType: "application/json; charset=utf-8",
                    success: function(data){
                        $.alert( "更新订单状态成功！");

                    },error:function(){
                        $.alert("更新订单状态失败！");
                    },
                    complete:function(request,status){
                        $.hideLoading();
                    }});
                $.showLoading("正在更新订单状态...");
            }
        });

        $("#btnUpdate").click(function(){
            location.href = "${pageContext.request.contextPath}/pickUp/showPickUpList?date="+ $("#date").val()+"&express="+express;
        });
    });

 /* var pickUpList = {
      getNowFormatDate:function(){
        var day = new Date();
        var Year = 0;
        var Month = 0;
        var Day = 0;
        var CurrentDate = "";
        Year= day.getFullYear();//支持IE和火狐浏览器.
        Month= day.getMonth()+1;
        Day = day.getDate();
        CurrentDate += Year;
          CurrentDate = CurrentDate +"-"
        if (Month >= 10 ){
            CurrentDate += Month;
        }
        else{
            CurrentDate += "0" + Month;
        }
          CurrentDate = CurrentDate +"-"
        if (Day >= 10 ){
            CurrentDate += Day ;
        }
        else{
            CurrentDate += "0" + Day ;
        }
        return CurrentDate;
    }
  }*/
</script>

</body>
</html>
