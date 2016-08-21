<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/8/21
  Time: 13:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>查询页面</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/lib/bootstrap/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/lib/bootstrap/bootstrap-theme.min.css">
    <script src="${pageContext.request.contextPath}/lib/jquery/jquery-1.11.3.min.js"></script>
    <script src="${pageContext.request.contextPath}/lib/bootstrap/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/pick_up.css">
</head>
<body>
<div class="container">
    <%--header--%>
    <div class="col-xs-12 header">
        <div class="header-title">
            <a href=""><span class="left"><img></span></a>
            <h1>查询</h1>
        </div>
    </div>
    <!-- start 寄件人信息-->
    <div class="" style="padding-top: 30%;">
        <div class="row">
            <div class="col-xs-12 username">
                <div class="username-info">
                    <div class="username-logo"><h2>姓名：</h2></div>
                    <div class="username-num"><input type="input" class="form-control" placeholder="请输入您姓名"></div>
                    <div class="username-logo-yc"></div>
                </div>
            </div>
        </div>
    </div>
    <div class="col-xs-12 submit-btn" >
        <div class="submit-btn-info">
            <a>查询</a>
        </div>
    </div>
</div>
</body>
</html>
