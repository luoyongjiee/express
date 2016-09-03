package com.sae.express.util.wechat;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.ConnectException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.servlet.http.HttpServletRequest;

import com.sae.express.dao.model.wechat.*;


import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 公众平台通用接口工具类
 * 
 * @author
 * @date 2013-08-09
 */
public class WeChatUtil {
	private static Logger log = LoggerFactory.getLogger(WeChatUtil.class);

	/**
	 * 发起https请求并获取结果
	 * 
	 * @param requestUrl
	 *            请求地址
	 * @param requestMethod
	 *            请求方式（GET、POST）
	 * @param outputStr
	 *            提交的数据
	 * @return JSONObject(通过JSONObject.get(key)的方式获取json对象的属性值)
	 */
	public static JSONObject httpRequest(String requestUrl,
			String requestMethod, String outputStr) {
		JSONObject jsonObject = null;
		StringBuffer buffer = new StringBuffer();
		try {
			// 创建SSLContext对象，并使用我们指定的信任管理器初始化
			TrustManager[] tm = { new MyX509TrustManager() };
			SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
			sslContext.init(null, tm, new java.security.SecureRandom());
			// 从上述SSLContext对象中得到SSLSocketFactory对象
			SSLSocketFactory ssf = sslContext.getSocketFactory();

			URL url = new URL(requestUrl);
			HttpsURLConnection httpUrlConn = (HttpsURLConnection) url
					.openConnection();
			httpUrlConn.setSSLSocketFactory(ssf);

			httpUrlConn.setDoOutput(true);
			httpUrlConn.setDoInput(true);
			httpUrlConn.setUseCaches(false);
			// 设置请求方式（GET/POST）
			httpUrlConn.setRequestMethod(requestMethod);

			if ("GET".equalsIgnoreCase(requestMethod))
				httpUrlConn.connect();

			// 当有数据需要提交时
			if (null != outputStr) {
				OutputStream outputStream = httpUrlConn.getOutputStream();
				// 注意编码格式，防止中文乱码
				outputStream.write(outputStr.getBytes("UTF-8"));
				outputStream.close();
			}

			// 将返回的输入流转换成字符串
			InputStream inputStream = httpUrlConn.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(
					inputStream, "utf-8");
			BufferedReader bufferedReader = new BufferedReader(
					inputStreamReader);

			String str = null;
			while ((str = bufferedReader.readLine()) != null) {
				buffer.append(str);
			}
			bufferedReader.close();
			inputStreamReader.close();
			// 释放资源
			inputStream.close();
			inputStream = null;
			httpUrlConn.disconnect();
			System.out.println(buffer.toString());
			jsonObject = JSONObject.fromObject(buffer.toString());
		} catch (ConnectException ce) {
			log.error("Weixin server connection timed out.");
		} catch (Exception e) {
			log.error("https request error:{}", e);
		}
		return jsonObject;
	}
	
	
	/**
	 * 发起https请求并获取结果
	 * 
	 * @param requestUrl
	 *            请求地址
	 *            请求方式（POST）
	 * @param outputStr
	 *            提交的数据
	 * @return Map键值对数据
	 */
	public static Map<String, String> httpRequest(String requestUrl, String outputStr) {
		Map<String, String> map = new HashMap<String, String>();
		
		try {
			// 创建SSLContext对象，并使用我们指定的信任管理器初始化
			TrustManager[] tm = { new MyX509TrustManager() };
			SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
			sslContext.init(null, tm, new java.security.SecureRandom());
			// 从上述SSLContext对象中得到SSLSocketFactory对象
			SSLSocketFactory ssf = sslContext.getSocketFactory();

			URL url = new URL(requestUrl);
			HttpsURLConnection httpUrlConn = (HttpsURLConnection) url
					.openConnection();
			httpUrlConn.setSSLSocketFactory(ssf);

			httpUrlConn.setDoOutput(true);
			httpUrlConn.setDoInput(true);
			httpUrlConn.setUseCaches(false);
			// 设置请求方式（GET/POST）
			httpUrlConn.setRequestMethod("POST");


			// 当有数据需要提交时
			if (null != outputStr) {
				OutputStream outputStream = httpUrlConn.getOutputStream();
				// 注意编码格式，防止中文乱码
				outputStream.write(outputStr.getBytes("UTF-8"));
				outputStream.close();
			}

			
			InputStream inputStream = httpUrlConn.getInputStream();
			
			map = MessageUtil.parseXml(inputStream);
			// 释放资源
			inputStream.close();
			inputStream = null;
			httpUrlConn.disconnect();
			
			
		} catch (ConnectException ce) {
			log.error("Weixin server connection timed out.");
		} catch (Exception e) {
			log.error("https request error:{}", e);
		}
		return map;
	}
	

	// 获取access_token的接口地址（GET） 限2000（次/天）
	public final static String access_token_url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";

	/**
	 * 获取access_token
	 * 
	 * @param appid
	 *            凭证
	 * @param appsecret
	 *            密钥
	 * @return
	 */
	public static AccessToken getAccessToken(String appid, String appsecret) {
		AccessToken accessToken = null;

		String requestUrl = access_token_url.replace("APPID", appid).replace(
				"APPSECRET", appsecret);
		JSONObject jsonObject = httpRequest(requestUrl, "GET", null);
		// 如果请求成功
		if (null != jsonObject) {
			try {
				accessToken = new AccessToken();
				accessToken.setToken(jsonObject.getString("access_token"));
				accessToken.setExpiresIn(jsonObject.getInt("expires_in"));
			} catch (JSONException e) {
				accessToken = null;
				// 获取token失败
				log.error("获取token失败 errcode:{} errmsg:{}", jsonObject
						.getInt("errcode"), jsonObject.getString("errmsg"));
			}
		}
		return accessToken;
	}

	// 获取jsapi_ticket的接口地址GET
	public final static String jsapi_ticket_url = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=ACCESS_TOKEN&type=jsapi";

	public static JsapiTicket getJsapiTicket(String accessToken){
		JsapiTicket jsapiTicket = null;
		String requestUrl  = jsapi_ticket_url.replaceAll("ACCESS_TOKEN", accessToken);
		JSONObject jsonObject = httpRequest(requestUrl, "GET", null);
		// 如果请求成功
		if (null != jsonObject) {
			try {
				jsapiTicket = new JsapiTicket();
				jsapiTicket.setTicket(jsonObject.getString("ticket"));
				jsapiTicket.setExpires_in(jsonObject.getInt("expires_in"));
			} catch (JSONException e) {
				jsapiTicket = null;
				// 获取ticket失败
				log.error("获取ticket失败 errcode:{} errmsg:{}", jsonObject
						.getInt("errcode"), jsonObject.getString("errmsg"));
			}
		}
		return jsapiTicket;
	}
	
	// 获取openId的接口地址
	public final static String openId_url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";

	public static OAuthAccessToken getOAuthByCode(String appid, String appsecret,
			String code) {
		OAuthAccessToken open = null;
		if (code != null) {
			String requestUrl = openId_url.replace("APPID", appid).replace(
					"SECRET", appsecret).replace("CODE", code);
             System.out.println("获取openId的接口地址"+requestUrl);
			JSONObject jsonObject = httpRequest(requestUrl, "GET", null);
			//System.out.println("获取成功！"+jsonObject.toString());
			if (null != jsonObject) {
				try {
				open = new OAuthAccessToken();
				open.setToken(jsonObject.getString("access_token"));
				open.setExpiresIn(jsonObject.getInt("expires_in"));
				open.setRefresh_token(jsonObject.getString("refresh_token"));
				open.setOpenid(jsonObject.getString("openid"));
				open.setScope(jsonObject.getString("scope"));
				if(jsonObject.containsKey("unionid")){
					open.setUnionid(jsonObject.getString("unionid"));
				}
				}catch (JSONException e) {
					open = null;
					// 获取OAuthAccessToken失败
					log.error("获取open失败 errcode:{} errmsg:{}", jsonObject
							.getInt("errcode"), jsonObject.getString("errmsg"));
				}
			}
		}
		return open;
	}
	
	//获取用户基本信息 GET
	public static String get_user_url = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
    /**
     * 公众平台获取用户基本信息
     * @param access_token
     * @param openId
     * @return
     */
	public static WeChatUnionUser getWeiXinUnionUser(String access_token, String openId){
		WeChatUnionUser user = null;
		if(openId==null||access_token==null)
			return null;
		String requestUrl = get_user_url.replace("ACCESS_TOKEN", access_token).replace("OPENID", openId);
		JSONObject jsonObject = httpRequest(requestUrl, "GET", null);
		
		if (null != jsonObject) {
			//log.info(jsonObject.toString());
			try {
				
				user = new WeChatUnionUser();
				user.setSubscribe(jsonObject.getInt("subscribe"));
				if(user.getSubscribe()!=0){
					user.setNickName(jsonObject.getString("nickname"));
					user.setSex(jsonObject.getInt("sex"));
					user.setLanguage(jsonObject.getString("language"));
					user.setCity(jsonObject.getString("city"));
					user.setProvince(jsonObject.getString("province"));
					user.setCountry(jsonObject.getString("country"));
					user.setHeadImgUrl(jsonObject.getString("headimgurl"));
					user.setSubscribe_time(jsonObject.getInt("subscribe_time"));
					user.setRemark(jsonObject.getString("remark"));
					user.setGroupid(jsonObject.getString("groupid"));
					
				}
				user.setOpenId(jsonObject.getString("openid"));
				if(jsonObject.containsKey("unionid")){
					user.setUnionid(jsonObject.getString("unionid"));
				}
				
			}catch (JSONException e) {
				
				user = null;
				
				// 获取WeiXinUser失败
				log.error("获取WeiXinUser失败 errcode:{} errmsg:{}", jsonObject
						.getString("errcode"), jsonObject.getString("errmsg"));
				e.printStackTrace();
			}
		}
		
		return user;
	}
	/**
	 * 开放平台获取用户基本信息
	 */
	//APP获取用户基本信息 GET
	public static String get_appuser_url = "https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID";
	public static WeChatAppUser getWeiXinAppUser(String access_token, String openId){
		WeChatAppUser appUser = null;
		if(openId==null||access_token==null)
			return null;
		String requestUrl = get_appuser_url.replace("ACCESS_TOKEN", access_token).replace("OPENID", openId);
		JSONObject jsonObject = httpRequest(requestUrl, "GET", null);
		if (null != jsonObject) {
			try {
				appUser = new WeChatAppUser();
				appUser.setOpenid(jsonObject.getString("openid"));
				appUser.setNickname(jsonObject.getString("nickname"));
				appUser.setSex(jsonObject.getInt("sex"));
				appUser.setProvince(jsonObject.getString("province"));
				appUser.setCity(jsonObject.getString("city"));
				appUser.setCountry(jsonObject.getString("country"));
				appUser.setHeadimgurl(jsonObject.getString("headimgurl"));
				if(jsonObject.containsKey("unionid")){
					appUser.setUnionid(jsonObject.getString("unionid"));
				}
				
			} catch (Exception e) {
				appUser = null;
				log.error("获取WeixinAppUser失败 errcode:{} errmsg:{}", jsonObject
						.getInt("errcode"), jsonObject.getString("errmsg"));
				e.printStackTrace();
			}
		}
		
		return appUser;
	}
	
	// 网页授权获取用户信息
	public static String get_snsapi_userinfo = "https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
	public static WeChatUnionUser getWeiXinSnsapi(String access_token, String openId){
		WeChatUnionUser user = null;
		String requestUrl = get_snsapi_userinfo.replace("ACCESS_TOKEN", access_token).replace("OPENID", openId);
		System.out.println();
		JSONObject jsonObject = httpRequest(requestUrl, "GET", null);
		
		if (null != jsonObject) {
			//log.info(jsonObject.toString());
			try {
				user = new WeChatUnionUser();
				user.setOpenId(jsonObject.getString("openid"));
				user.setNickName(jsonObject.getString("nickname"));
				user.setSex(jsonObject.getInt("sex"));
				user.setProvince(jsonObject.getString("province"));
				user.setCity(jsonObject.getString("city"));
				user.setCountry(jsonObject.getString("country"));
				user.setHeadImgUrl(jsonObject.getString("headimgurl"));
				if(jsonObject.containsKey("unionid")){
					user.setUnionid(jsonObject.getString("unionid"));
				}
			}catch (JSONException e) {
				user = null;
				
				// 获取WeiXinSnsapi失败
				log.error("获取WeiXinSnsapi失败 errcode:{} errmsg:{}", jsonObject
						.getInt("errcode"), jsonObject.getString("errmsg"));
			}
		
		}
		
		return user;
	}
	
	
	// 菜单创建（POST） 限100（次/天）
	public static String menu_create_url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
	// 菜单删除（GET） 限100（次/天）
	public static String menu_delte_url = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=ACCESS_TOKEN";

	/**
	 * 创建菜单
	 * 
	 * @param menu
	 *            菜单实例
	 * @param accessToken
	 *            有效的access_token
	 * @return 0表示成功，其他值表示失败
	 */
	public static int createMenu(Menu menu, String accessToken) {
		int result = 0;

		// 拼装创建菜单的url
		String url = menu_create_url.replace("ACCESS_TOKEN", accessToken);
		// 将菜单对象转换成json字符串
		String jsonMenu = JSONObject.fromObject(menu).toString();
		// 调用接口创建菜单
		JSONObject jsonObject = httpRequest(url, "GET", jsonMenu);

		if (null != jsonObject) {
			if (0 != jsonObject.getInt("errcode")) {
				result = jsonObject.getInt("errcode");
				log.error("创建菜单失败 errcode:{} errmsg:{}", jsonObject
						.getInt("errcode"), jsonObject.getString("errmsg"));
			}
		}

		return result;
	}
	/**
	 * 删除菜单
	 * @param accessToken
	 * @return
	 */

	public static int deleteMenu(String accessToken) {
		int result = 0;
		// 拼装创建菜单的url
		String url = menu_delte_url.replace("ACCESS_TOKEN", accessToken);
		// 调用接口删除菜单
		JSONObject jsonObject = httpRequest(url, "GET", null);

		if (null != jsonObject) {
			if (0 != jsonObject.getInt("errcode")) {
				result = jsonObject.getInt("errcode");
				log.error("删除菜单失败 errcode:{} errmsg:{}", jsonObject
						.getInt("errcode"), jsonObject.getString("errmsg"));
			}
		}
		return result;
	}
	//查询菜单
	public static String menu_query_url = "https://api.weixin.qq.com/cgi-bin/menu/get?access_token=ACCESS_TOKEN";

	public static JSONArray queryMenu(String accessToken){
		JSONArray jsonArray = null;
		String requestUrl = menu_query_url.replace("ACCESS_TOKEN", accessToken);
		JSONObject jsonObject = httpRequest(requestUrl, "GET", null);
		
		if (null != jsonObject) {
			//log.info(jsonObject.toString());
			try {
			JSONObject menudata = jsonObject.getJSONObject("menu");
			jsonArray =  menudata.getJSONArray("button");	
			}catch (JSONException e) {
				jsonArray = null;
				log.info("查询菜单失败:"+jsonObject.toString());
			}
		
		}
		return jsonArray;
	}
	/**
	 * 二维码类型
	 */
	public static final String QR_SCENE = "QR_SCENE";//为临时
	public static final String QR_LIMIT_SCENE = "QR_LIMIT_SCENE";//为永久
	public static final String QR_LIMIT_STR_SCENE = "QR_LIMIT_STR_SCENE";//为永久的字符串参数值 
	
	//POST
	public static String QRCode_url = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=ACCESS_TOKEN";
	public static String Tem_QRCode_post = "{\"action_info\":{\"scene\":{\"scene_id\":SCENEID}},\"action_name\":\"ACTIONNAME\",\"expire_seconds\":SECONDS}";
	/**
	 * 获取二维码
	 * @param accessToken
	 * @param sceneid
	 * @return
	 */
	
	public static QRCode getTemQRCode(String accessToken, int sceneid, String actionName){
		String outputStr = Tem_QRCode_post.replace("SCENEID", Integer.toString(sceneid)).replace("ACTIONNAME", actionName).replace("SECONDS", "604800");
		String requestUrl = QRCode_url.replace("ACCESS_TOKEN", accessToken);
		System.out.println(outputStr);
		return getQRCode(requestUrl,outputStr);
	}
	public static String Limit_Str_QRCode_post = "{\"action_name\": \"QR_LIMIT_STR_SCENE\", \"action_info\": {\"scene\": {\"scene_str\": \"SCENESTR\"}}}";
	public static QRCode getLimitStrQRCode(String accessToken,String scene_str){
		String outputStr = Limit_Str_QRCode_post.replace("SCENESTR", scene_str);
		String requestUrl = QRCode_url.replace("ACCESS_TOKEN", accessToken);
		System.out.println(outputStr);
		return getQRCode(requestUrl,outputStr);
	}
	
	
	private static QRCode getQRCode(String requestUrl,String outputStr){
		QRCode qrCode = null;
		JSONObject jsonObject = httpRequest(requestUrl, "POST", outputStr);
		if (null != jsonObject) {
			log.info(jsonObject.toString());
			try {
				qrCode = new QRCode();
				
				qrCode.setUrl(jsonObject.getString("url"));
				qrCode.setTicket(jsonObject.getString("ticket"));
				if(jsonObject.containsKey("expire_seconds")){
				    qrCode.setExpire_seconds(jsonObject.getInt("expire_seconds"));
				}
			}catch (JSONException e) {
				qrCode = null;
				
				// 获取QRCode失败
				log.error("获取QRCode失败 errcode:{} errmsg:{}", jsonObject
						.getInt("errcode"), jsonObject.getString("errmsg"));
			}
		
	    }
		return qrCode;
	}
	
	public static String or_code_img_url = "https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=TICKET";
	
	/*public static byte[] getAndWriteCodeImg(String ticket,String path,String fileName){
		try {
			ticket = URLEncoder.encode(ticket, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String  url = or_code_img_url.replace("TICKET", ticket);
		return URLDownloaderImageUtil.writeByUrl(url, path, fileName);
	}*/
	
	
	public static String material_list_url = "https://api.weixin.qq.com/cgi-bin/material/batchget_material?access_token=ACCESS_TOKEN";
	
	public static void getMaterialList(String accessToken, MaterialType materialType){
		String requestUrl = material_list_url.replace("ACCESS_TOKEN", accessToken);
		String outputStr = JSONObject.fromObject(materialType).toString();
		System.out.println(outputStr);
		JSONObject jsonObject = httpRequest(requestUrl, "POST", outputStr);
		System.out.println(jsonObject.toString());
	}
	
	//统一下单
	public static String unifiedorder_url = "https://api.mch.weixin.qq.com/pay/unifiedorder";
	public static String getPrepayId(String xml_body){
		Map<String, String> map = httpRequest(unifiedorder_url,xml_body);
		//log.info(map.toString());
		System.out.println("====="+map.toString());
		return map.get("prepay_id");
	}
	/**
	 * 退款申请
	 * @param xml_body
	 * @return
	 */
	public static String refund_url = "https://api.mch.weixin.qq.com/secapi/pay/refund";
	public static Map<String, String> refundFee(String xml_body){
		return httpRequest(refund_url,xml_body);
	}
	/**
	 * 查询订单
	 */
	public static String order_query_url = "https://api.mch.weixin.qq.com/pay/orderquery";
	public static Map<String, String> orderQuery(String xml_body){
		return httpRequest(order_query_url,xml_body);
	}
	
	/*
	 * 模版消息
	 */
	
	//获得模板ID
	//http请求方式: POST
	public static String get_template_id = "https://api.weixin.qq.com/cgi-bin/template/api_add_template?access_token=ACCESS_TOKEN";
	
	public static String getTemplateId(String templateIdShort,String accessToken){
		String templateId = null;
		JSONObject outputJson = new JSONObject();
		outputJson.put("template_id_short", templateIdShort);
		String requestUrl = get_template_id.replace("ACCESS_TOKEN", accessToken);
		JSONObject jsonObject = httpRequest(requestUrl, "POST", outputJson.toString());
		if (null != jsonObject) {
			//log.info(jsonObject.toString());
			try {
				templateId = jsonObject.getString("template_id");
			}catch (JSONException e) {
				
				log.error("获取TemplateId失败 errcode:{} errmsg:{}", jsonObject
						.getInt("errcode"), jsonObject.getString("errmsg"));
			}
		
	    }
		return templateId;
	}
	
	
	/**
	 * 发送模版消息
	 * @param outputStr 模版消息json String
	 * @param accessToken 
	 * @return  消息id 
	 */
	public static String push_msg_url = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=ACCESS_TOKEN";
	public static long pushMsgByTemplate(String outputStr,String accessToken){
		long msgid =0;
		String requestUrl = push_msg_url.replace("ACCESS_TOKEN", accessToken);
		JSONObject jsonObject = httpRequest(requestUrl, "POST", outputStr);
		if (null != jsonObject) {
			//log.info(jsonObject.toString());
			try {
				msgid = jsonObject.getLong("msgid");
			}catch (JSONException e) {
				
				log.error("发送Template失败 errcode:{} errmsg:{}", jsonObject
						.getInt("errcode"), jsonObject.getString("errmsg"));
			}
		
	    }
		return msgid;
	}
	
	/**
	 * 生成签名（暂时写死）
	 * @param request
	 * @return
	 */
	public static String getSign(HttpServletRequest request ,String nonceStr,String timeStamp,String jsapi_ticket){
		String url = request.getRequestURL().toString();
       
		if(request.getQueryString()!=null){
			url += "?" + toUtf8(request.getQueryString());
		}
		
		System.out.println("==="+url);	
		return SignUtil.getSignature(jsapi_ticket, nonceStr, timeStamp, url);
	}
	
	/**
	 * 根据内容类型判断文件扩展名
	 * 
	 * @param contentType 内容类型
	 * @return
	 */
	public static String getFileEndWitsh(String contentType) {
		String fileEndWitsh = "";
		if ("image/jpeg".equals(contentType))
			fileEndWitsh = ".jpg";
		else if ("audio/mpeg".equals(contentType))
			fileEndWitsh = ".mp3";
		else if ("audio/amr".equals(contentType))
			fileEndWitsh = ".amr";
		else if ("video/mp4".equals(contentType))
			fileEndWitsh = ".mp4";
		else if ("video/mpeg4".equals(contentType))
			fileEndWitsh = ".mp4";
		return fileEndWitsh;
	}
	public  static String toUtf8(String str) {
		String utf8Str = "";
		if (str != null) {
			try {
				utf8Str = new String(str.getBytes("UTF-8"), "UTF-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return utf8Str;
	}
	
	
}
