<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>收件列表</title>
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
    <meta name="description" content="weui">

    <link rel="stylesheet" href="//cdn.bootcss.com/weui/0.4.3/style/weui.min.css">
    <link rel="stylesheet" href="//cdn.bootcss.com/jquery-weui/0.8.0/css/jquery-weui.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/demos.css">

</head>
<style type="text/css">
.weui-infinite-scroll {
    height: 24px;
    line-height: 24px;
    padding: 10px;
    text-align: center;
}
.infinite-preloader {
    display: inline-block;
    margin-right: 4px;
    vertical-align: -4px;
    width: 20px;
    height: 20px;
    -webkit-transform-origin: 50%;
    transform-origin: 50%;
    -webkit-animation: preloader-spin 1s steps(12, end) infinite;
    animation: preloader-spin 1s steps(12, end) infinite;
}
</style>
<body ontouchstart>


<div id="list">
<c:if test="${pickUpList != null&&pickUpList.size()>0}">
    <c:forEach items="${pickUpList}" var="pickUpModel">
        <a href="${pageContext.request.contextPath}/pickUp/Detail?id=${pickUpModel.id}&showMsg=false">
        <div class="weui_cells">
            <div class="weui_cell">
                <div class="weui_cell_bd weui_cell_primary">
                    <p>下单号:${pickUpModel.id}</p>
                </div>
                <div class="weui_cell_ft">
                        收件：${pickUpModel.phone}-${pickUpModel.userName}
                </div>
            </div>
        </div>
        </a>
    </c:forEach>
</c:if>
</div>
<div class="weui-infinite-scroll">
    <c:if test="${pickUpList != null&&pickUpList.size()>0}">
        <div class="infinite-preloader"></div>
        <span class="load_info">正在加载</span>
    </c:if>
    <c:if test="${pickUpList == null||pickUpList.size()<=0}">
    <span class="load_info">没有数据</span>
    </c:if>
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
    var offset = 10;
    $(document.body).infinite().on("infinite", function() {
        if(loading) return;
        loading = true;
        $.ajax({
            type: "post",
            url: "${pageContext.request.contextPath}/pickUp/page",
            data: {"offset":offset,"limit":10},
            dataType: "json",
            success: function(data){
                offset = offset + 10;

                if(data == null || data.length<=0){
                    loading = false;
                    $('.infinite-preloader').hide();
                    $('.load_info').html("已加载全部")
                    return;
                }
                for(var i = 0; i < data.length; i++){
                    $("#list").append('<a href="${pageContext.request.contextPath}/pickUp/Detail?showMsg=false&id='+data[i].id+'">'+
                            ' <div class="weui_cells">'+
                            '<div class="weui_cell">'+
                            '<div class="weui_cell_bd weui_cell_primary">'+
                            '<p>下单号:'+data[i].id+'</p>'+
                            ' </div>'+
                            '<div class="weui_cell_ft">'+
                            '收件：'+data[i].phone+'-'+data[i].userName+
                            ' </div>'+
                            '</div>'+
                            '</div>'+
                            ' </a>');
                }
                loading = false;
            },
            complete:function(request,status){
                $.hideLoading();
            }});
    });
</script>

</body>
</html>
