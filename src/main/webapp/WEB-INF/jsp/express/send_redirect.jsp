<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   
    
    <title></title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
   <script type="text/javascript">
   var sendRedirect = '${sendRedirect}';
   var appid = '${appid}';
   var  host = '${hostUri}';

   window.location.href = 'https://open.weixin.qq.com/connect/oauth2/authorize?appid='
                          +appid
                          +'&redirect_uri='
                          + host
                          +'wechat/getuser?sendRedirect='
                          +sendRedirect
                          +'&response_type=code&scope=snsapi_base&state=1#wechat_redirect';
   </script>
  </head>
  
  <body>
   
  </body>
</html>
