<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
    <title>微信网页支付</title>
    <meta charset="utf-8">
    <meta http-equiv="content-Type" content="text/html;charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">

    <meta name="description" content="weui">

    <link rel="stylesheet" href="//cdn.bootcss.com/weui/0.4.3/style/weui.min.css">
    <link rel="stylesheet" href="//cdn.bootcss.com/jquery-weui/0.8.0/css/jquery-weui.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/demo.css">
</head>
<body>
<br><br>
<%--<div class="weui_cells">
    <div class="weui_cell">
        <div class="weui_cell_bd weui_cell_primary">
            <p>取件单号：</p>
        </div>
        <div class="weui_cell_ft">
            ${result.pickUpId}
        </div>
    </div>
</div>--%>
<div class="weui_cells">
    <div class="weui_cell">
        <div class="weui_cell_bd weui_cell_primary">
            <p>支付金额：</p>
        </div>
        <div class="weui_cell_ft">
            ${result.totalFee}元
        </div>
    </div>
</div>
<br>
<%--<a href="javascript:;" class="weui_btn weui_btn_plain_default">${result.totalFee} 元</a>--%>
<a href="javascript:;" class="weui_btn weui_btn_primary" onclick="callpay()">去付款</a>

<script src="//cdn.bootcss.com/jquery/1.11.0/jquery.min.js"></script>
<script src="//cdn.bootcss.com/jquery-weui/0.8.0/js/jquery-weui.min.js"></script>
<script src="${pageContext.request.contextPath}/lib/fastclick.js"></script>

<script type="text/javascript">
    var code = "${result.code}";
    var appId="${result.appId}";
    var timeStamp="${result.timeStamp}";
    var nonceStr="${result.nonceStr}";
    var prepay_id="${result.prepay_id}";
    var sign="${result.paySign}";
    var signType = "${result.signType}";
    var pickUpId = "${result.pickUpId}";


    //支付接口
    function jsApiCall(){


        WeixinJSBridge.invoke(
                'getBrandWCPayRequest', {
                    "appId" : appId,     //公众号名称，由商户传入
                    "timeStamp" : timeStamp, //时间戳，自1970年以来的秒数 (java需要处理成10位才行，又一坑)
                    "nonceStr" : nonceStr, //随机串
                    "package" : prepay_id, //拼装好的预支付标示
                    "signType" : signType,//微信签名方式
                    "paySign" : sign //微信签名
                },
                function(res){
                    //使用以下方式判断前端返回,微信团队郑重提示：res.err_msg将在用户支付成功后返回    ok，但并不保证它绝对可靠。
                    if(res.err_msg == "get_brand_wcpay_request:ok" ) {
                        //更新订单状态 ---成功
                        updatePickUpStatus(pickUpId,"1");
                        $.toast("支付成功!!!");
                        window.location.href="${pageContext.request.contextPath}/pickUp/Detail?id="+pickUpId;
                    }else{
                        //更新订单状态 ---失败
                        updatePickUpStatus(pickUpId,"2");
                        $.alert("请求参数：appId="+appId+",timeStamp="+timeStamp+",nonceStr="+nonceStr+",package="+prepay_id+",signType="+signType+",sign="+sign+"--"+res.err_code +","+ res.err_desc +","+ res.err_msg);
                      /*  $.alert("支付失败!!!!!!!"+res.err_msg);*/

                    }
                }
        );
    }

    function callpay()
    {
        if(code == -1 || code == "-1"){
            $.alert("下单失败!");
            return;
        }

        if (typeof WeixinJSBridge == "undefined")
        {
            if (document.addEventListener)
            {
                document.addEventListener('WeixinJSBridgeReady', jsApiCall, false);
            }
            else if (document.attachEvent)
            {
                document.attachEvent('WeixinJSBridgeReady', jsApiCall);
                document.attachEvent('onWeixinJSBridgeReady', jsApiCall);
            }
        }
        else
        {
            jsApiCall();
        }
    }

    function updatePickUpStatus(pickId,status){
        $.ajax({
            type: "post",
            url: "${pageContext.request.contextPath}/pickUp/status",
            data: {"pickUpId":pickId,
                "status":status
            },
            dataType: "json",
            success: function(data){

            },
            complete:function(request,status){

            }});
    }
</script>
</body>
</html>
