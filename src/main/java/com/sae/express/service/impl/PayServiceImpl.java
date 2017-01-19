package com.sae.express.service.impl;

import com.sae.express.dao.iface.PickUpModelMapper;
import com.sae.express.dao.model.PickUpModel;
import com.sae.express.service.PayService;

import com.sae.express.util.HttpClient;
import com.sae.express.util.RandomGeneratorUtil;
import com.sae.express.util.SignatureUtil;
import com.sae.express.util.constant.CommonCode;
import com.sae.express.util.error.LogicException;
import com.sae.express.util.tool.StringTools;
import com.sae.express.util.wechat.GsonUtil;
import com.sae.express.util.wechat.WeChatUtil;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by luoqi on 2016-10-16.
 */
@Service
public class PayServiceImpl implements PayService {

    private Logger log = LoggerFactory.getLogger(PayServiceImpl.class);

    @Value("${wechat.public_app_id}")
    private String appid;

    @Value("${wechat.mch_id}")
    private String mchid;

    @Value("${wechat.key}")
    private String apiKey;

    @Value("${wechat.notify.uri}")
    private String notifyUri;

    @Autowired
    private PickUpModelMapper pickUpModelMapper;

    private HttpClient httpClient = new HttpClient();

    public Map<String,Object> makeOrder(Integer pickUpId,String totalFee,String createIp,String openid) throws IllegalAccessException {


        Map<String, Object> map = new HashMap<String, Object>();
        map.put("body", "微信公众号支付");
        map.put("attach", pickUpId);
        map.put("out_trade_no", pickUpId);
        map.put("total_fee", Integer.valueOf(totalFee)*100);
       /* Date now = new Date();
        map.put("time_start", DateTool.format(now,DateTool.YYYYMMDDHHMMSS));
        map.put("time_expire",DateTool.format(DateUtils.addMinutes(now,10),DateTool.YYYYMMDDHHMMSS));*/
        map.put("goods_tag","express");
        map.put("trade_type", "JSAPI");
        map.put("openid",openid);


        map.put("appid", appid);
        map.put("mch_id", mchid);
        map.put("device_info","WEB");
        map.put("nonce_str", RandomGeneratorUtil.getRandomStringByLength(32));
        map.put("spbill_create_ip", "8.8.8.8");
        map.put("notify_url", notifyUri+pickUpId);

        String sign = SignatureUtil.getSign(map, apiKey);
        map.put("sign",sign);

        String postDataXML = toXml(map);
        log.info("unifiedorder的请求参数:"+postDataXML);
        String prepayId = WeChatUtil.getPrepayId(postDataXML);

        if(StringTools.isBlank(prepayId)){
            throw new LogicException(CommonCode.FAILURE_CODE,"支付失败");
        }

        //组装map用于生成sign
        Map<String, Object> resultMap=new HashMap<String, Object>();
        resultMap.put("appId", appid);
        resultMap.put("timeStamp", Long.toString(System.currentTimeMillis()/1000));
        resultMap.put("nonceStr", RandomGeneratorUtil.getRandomStringByLength(32));
        resultMap.put("package", "prepay_id="+prepayId);
        resultMap.put("signType", "MD5");
        resultMap.put("paySign",SignatureUtil.getSign(resultMap,apiKey));
        resultMap.put("prepay_id","prepay_id="+prepayId);
        log.info("支付表单:"+ GsonUtil.toJson(resultMap,Map.class));
        return resultMap;
    }

    public Map<String,String> refund(Integer pickUpId){
        PickUpModel pickUpModel =pickUpModelMapper.selectByPrimaryKey(pickUpId);
        String  totalFee = String.valueOf(Integer.valueOf(pickUpModel.getMoney())*100);
        String refundFee = String.valueOf(Integer.valueOf(pickUpModel.getMoney())*100);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("appid", appid);
        map.put("mch_id", mchid);
        map.put("nonce_str", RandomGeneratorUtil.getRandomStringByLength(32));
        map.put("out_trade_no",pickUpId);
        map.put("out_refund_no",pickUpId);
        map.put("total_fee",totalFee);
        map.put("refund_fee",refundFee);
        map.put("op_user_id",mchid);
        map.put("transaction_id","");
        String sign = SignatureUtil.getSign(map, apiKey);
        map.put("sign",sign);

        String postDataXML = toXml(map);
        log.info("refund的请求参数:"+postDataXML);
        Map<String, String> returnMap = new HashMap<String, String>();
        map.put("code",CommonCode.FAILURE_CODE);
        try {
            String xml = httpClient.sendPost(WeChatUtil.refund_url,postDataXML);
            Map<String,String> stringMap = WeChatUtil.toMap(xml);
            if("SUCCESS".equals(stringMap.get("result_code"))){
                returnMap.put("code",CommonCode.SUCCESS_CODE);
            }
        } catch (Exception e) {
            log.error("错误",e);
            return returnMap;
        }

        return returnMap;
    }


    private String toXml(Map<String,Object> map){
        //数据为空时不能转化为xml格式
        String xml = "<xml>";
        Iterator it=map.keySet().iterator();
        while(it.hasNext()){
            String key = it.next().toString();
            Object value =  map.get(key);
            if(value instanceof Integer){
                xml += "<" + key + ">" + value + "</" + key + ">";
            }else if (value instanceof String){
                xml += "<" + key + ">" + "<![CDATA[" + value + "]]></" + key + ">";
            }
        }
        xml += "</xml>";
        return xml;
    }




}
