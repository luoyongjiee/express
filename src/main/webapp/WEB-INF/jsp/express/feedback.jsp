<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>反馈</title>
    <meta charset="utf-8">
    <meta http-equiv="content-Type" content="text/html;charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">

    <meta name="description" content="weui">


    <link rel="stylesheet" href="//cdn.bootcss.com/weui/0.4.3/style/weui.min.css">
    <link rel="stylesheet" href="//cdn.bootcss.com/jquery-weui/0.8.0/css/jquery-weui.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/demo.css">

</head>

<body ontouchstart>

<form action="${pageContext.request.contextPath}/addSend" method="post"  id="formAddSend" <%--onsubmit="return validate()"--%>>

    <header class='demos-header'>
        <h1 class="demos-title">反馈</h1>
    </header>



    <div class="weui_cells_title"><font size="4" color="#FF0000">服务反馈</font></div>
    <div class="weui_cells weui_cells_form">
        <div class="weui_cell">
            <div class="weui_cell_bd weui_cell_primary">
                <textarea class="weui_textarea" id="receiverAddress" name="receiverAddress" placeholder="请输入收件人地址" rows="3"></textarea>
                <div class="weui_textarea_counter"><span>0</span>/200</div>
            </div>
        </div>
    </div>

    <div class="weui_btn_area">
        <input name="btnAddSend"  class="weui_btn weui_btn_primary" type="button" id="btnAddSend" value="提交">
    </div>

    </div>
</form>
<!-- body 最后 -->
<script src="//cdn.bootcss.com/jquery/1.11.0/jquery.min.js"></script>
<script src="//cdn.bootcss.com/jquery-weui/0.8.0/js/jquery-weui.min.js"></script>

<script src="${pageContext.request.contextPath}/lib/fastclick.js"></script>
<script>
    $(document).ready(function(){

    });

</script>
</body>
</html>
