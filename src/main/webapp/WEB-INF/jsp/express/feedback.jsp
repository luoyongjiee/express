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
    <title>反馈</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/lib/bootstrap/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/lib/bootstrap/bootstrap-theme.min.css">
    <script src="${pageContext.request.contextPath}/lib/jquery/jquery-1.11.3.min.js"></script>
    <script src="${pageContext.request.contextPath}/lib/bootstrap/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/send.css">
    <style type="text/css">
         span{font-size: 16px;font-weight: bold; position: relative;margin: 0px;padding: 0px;
            line-height: 48px;margin-left:10px;}
         .freeback-num{padding-left:10px;height: auto;margin-top: 10px;padding-right: 10px;}

         textarea{border: 0px;box-shadow: none;font-size: 16px;color:#b2b2b2;width: 100%}
    </style>
</head>
<body>
<div class="container">
    <%--header--%>
    <div class="col-xs-12 header">
        <div class="header-title">
            <a href=""><span class="left"><img></span></a>
            <h1>反馈</h1>
        </div>
    </div>

        <form action="${pageContext.request.contextPath}/addFeedback" method="post" id="test">


    <!-- start 寄件人信息-->
    <div class="" style="padding-top: 30%;">
        <span>服务反馈</span>
        <div class="row">
            <div class="col-xs-12 address">
                <div class="address-info">
                    <div class="freeback-num">
                        <textarea class="form-control" name="content" placeholder="请输入您建议" rows="10" ></textarea>
                    </div>
                    <div class="address-logo-xs"></div>
                </div>
            </div>
        </div>
    </div>
    <div class="col-xs-12 submit-btn" >
        <div class="submit-btn-info">
            <a>提交</a>
            <input type="submit" value="提交" id="btn"/>
        </div>
    </div>
        </form>
</div>
</body>
</html>
