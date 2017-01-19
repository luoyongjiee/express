package com.sae.express.util.common;


/**
 * 发生信息
 */
public class SMSUtil {

	/*private static Logger log = LoggerFactory.getLogger(SMSUtil.class);
	@SuppressWarnings("unchecked")
	public static HashMap<String,Object> getSMSResult(String phone,String No,String[] message){
		CCPRestSmsSD restAPI = new CCPRestSmsSDK();
		restAPI.init(ConstantsUtil.SMS_URL, ConstantsUtil.SMS_PORT);
		restAPI.setAccount(ConstantsUtil.SMS_ACOUNT_SID, ConstantsUtil.SMS_AUTH_TOKEN);
		restAPI.setAppId(ConstantsUtil.SMS_APP_ID);
		
		HashMap<String, Object> result = restAPI.sendTemplateSMS(phone,No,message);
		System.out.println(result.toString());
		if("000000".equals(result.get("statusCode"))){
			//正常返回输出data包体信息（map）
			return (HashMap<String, Object>) result.get("data");
			
		}else{
			//异常返回输出错误码和错误信息
			//System.out.println("错误码=" + result.get("statusCode") +" 错误信息= "+result.get("statusMsg"));
			log.error("发送短信失败：Code：{} Msg：{}",result.get("statusCode"),result.get("statusMsg"));
			return null;
		}
	}
	*/
	
}
