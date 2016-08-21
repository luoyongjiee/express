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
    <title>寄件页面</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/lib/bootstrap/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/lib/bootstrap/bootstrap-theme.min.css">
    <script src="${pageContext.request.contextPath}/lib/jquery/jquery-1.11.3.min.js"></script>
    <script src="${pageContext.request.contextPath}/lib/bootstrap/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/send.css">
</head>
<body>
    <div class="container">
       <%-- header--%>
        <div class="col-xs-12 header">
            <div class="header-title">
                <a href=""><span class="left"><img ></span></a>
                <h1>寄件</h1>
            </div>
        </div>
        <!-- start 寄件人信息-->
        <div class="title-info">
            <span>寄件人信息</span>
            <div class="row">
                <div class="col-xs-12 username">
                    <div class="username-info">
                        <div class="username-logo"><h2>姓名：</h2></div>
                        <div class="username-num"><input type="input" class="form-control" placeholder="请输入您姓名"></div>
                        <div class="username-logo-yc"></div>
                    </div>
                </div>
                <div class="col-xs-12 username">
                    <div class="username-info">
                        <div class="username-logo"><h2>电话：</h2></div>
                        <div class="username-num"><input type="input" class="form-control" placeholder="请输入您电话"></div>
                        <div class="username-logo-xs"></div>
                    </div>
                </div>
                <div class="col-xs-12 username">
                    <div class="username-info">
                        <div class="username-logo"><h2>宿舍号：</h2></div>
                        <div class="username-num"><input type="input" class="form-control" placeholder="请输入您宿舍号"></div>
                        <div class="username-logo-xs"></div>
                    </div>
                </div>
            </div>
        </div>
        <!--end 寄件人信息-->
        <!-- start 收件人信息-->

        <div class="title-info">
            <span>收件人信息</span>
            <div class="row">
                <div class="col-xs-12 code">
                    <div class="code-info">
                        <div class="code-title"><h2>姓名：</h2></div>
                        <div class="code-num"><input type="input" class="form-control" placeholder="请输入收件人姓名"></div>
                    </div>
                </div>
                <div class="col-xs-12 username">
                    <div class="username-info">
                        <div class="username-logo"><h2>电话</h2></div>
                        <div class="username-num"><input type="input" class="form-control" placeholder="请输入收件人电话"></div>
                        <div class="username-logo-yc"></div>
                    </div>
                </div>
                <div class="col-xs-12 address">
                    <div class="address-info">
                        <div class="address-logo"><h2>地址:</h2></div>
                        <div class="address-num">
                            <textarea class="form-control" placeholder="请输入收件人地址" rows="5" ></textarea>

                        </div>
                        <div class="address-logo-xs"></div>
                    </div>
                </div>
            </div>
        </div>
        <!--end 收件人信息-->
        <div class="col-xs-12 submit-btn">
            <div class="submit-btn-info">
                <a >提交订单</a>
            </div>
        </div>
    </div>
</body>
</html>
