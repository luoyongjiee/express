package com.sae.express.util.wechat;

import com.sae.express.dao.model.wechat.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** 
 * 菜单管理器类 
 *  
 * @author liufeng 
 * @date 2013-08-08 
 */  
public class MenuManager {  
    private static Logger log = LoggerFactory.getLogger(MenuManager.class);  
//    private String appId;
//    private String appSecret;
   
    /*public static void main(String[] args) {
        // 第三方用户唯一凭证  
        String appId = "wxde02f58dc6d9ea18";
        // 第三方用户唯一凭证密钥  
        String appSecret = "035d7320d6398647aa6635359f848b4e";
  
        //deleteMenu(appId, appSecret);
        createMenu(appId, appSecret);
//        // 调用接口获取access_token  
//        AccessToken at = WeChatUtil.getAccessToken(appId, appSecret);
//        if (null != at) {  
//            // 调用接口创建菜单  
//            int result = WeChatUtil.createMenu(getMenu(), at.getToken());
//            //删除菜单
////       int result = WeChatUtil.deleteMenu(at.getToken());
//            // 判断菜单创建结果  
//            if (0 == result)  
//                log.info("菜单创建成功！");  
//            else  
//                log.info("菜单创建失败，错误码：" + result);  
//        }  
    }  */
     
    
    public static AccessToken createMenu(String appId,String appSecret){
    	AccessToken at = WeChatUtil.getAccessToken(appId, appSecret);
    	if (null != at) {
    		// 调用接口创建菜单  
            int result = WeChatUtil.createMenu(getMenu(appId), at.getToken());
            if (0 == result){
            	 log.info("菜单创建成功！");
            	 return at;
            }else { 
                log.info("菜单创建失败，错误码：" + result);
                return null;
            }
    	}
    	
    	return at;
    }
    
    public static boolean createMenu(String accessToken,Menu menu){
    	// 调用接口创建菜单  
        int result = WeChatUtil.createMenu(menu, accessToken);
        if (0 == result){
        	 log.info("菜单创建成功！");
        	 return true;
        }else { 
            log.info("菜单创建失败，错误码：" + result);
            return false;
        }
    	
    }
    
    public static boolean deleteMenu(String appId,String appSecret){
    	AccessToken at = WeChatUtil.getAccessToken(appId, appSecret);
    	if (null != at) {
    		int result = WeChatUtil.deleteMenu(at.getToken());
    		if (0 == result) { 
                log.info("菜单删除成功！");
    		   return true;
    		}
            else  
                log.info("菜单删除失败，错误码：" + result); 
    	}
    	return false;
    }
    /** 
     * 组装菜单数据 
     *  
     * @return 
     */  
    private static Menu getMenu(String appId) {  
        
        ViewButton btn11 = new ViewButton();
        btn11.setName("用户注册");  
        btn11.setType("view");  
        btn11.setUrl("https://open.weixin.qq.com/connect/oauth2/authorize?appid="
        		+appId +"&redirect_uri=http://weizengke.com/DingXinTianXia/toRegisterWeiXinUser.a?appId="
        		+appId +"&response_type=code&scope=snsapi_base&state=1#wechat_redirect");
//      btn11.setUrl("https://www.baidu.com/");
        
        ViewButton btn21 = new ViewButton();  
        btn21.setName("楼房信息");  
        btn21.setType("view");  
        btn21.setUrl("https://open.weixin.qq.com/connect/oauth2/authorize?appid="+appId
        		+"&redirect_uri=http://weizengke.com/DingXinTianXia/listMobileContentInfos.a?appId="
        		+appId+"&response_type=code&scope=snsapi_base&state=1#wechat_redirect");
       
      /*  ViewButton btn31 = new ViewButton();  
        btn31.setName("积分商城");  
        btn31.setType("view");  
        btn31.setUrl("https://open.weixin.qq.com/connect/oauth2/authorize?appid="
        		+appId+"&redirect_uri=http://yshyouji.oicp.net/DingXinTianXia/mobileListGiftsTypes.a?appId="
        		+appId+"&response_type=code&scope=snsapi_base&state=1#wechat_redirect");
 */    
        ViewButton btn31 = new ViewButton();  
        btn31.setName("我的积分");  
        btn31.setType("view");  
        btn31.setUrl("https://open.weixin.qq.com/connect/oauth2/authorize?appid="+appId
        		+"&redirect_uri=http://weizengke.com/DingXinTianXia/findMobileWeiXinUser.a?appId="
        		+appId+"&response_type=code&scope=snsapi_base&state=1#wechat_redirect");
        
        
        ViewButton btn32 = new ViewButton();  
        btn32.setName("商品兑换");  
        btn32.setType("view");  
        btn32.setUrl("https://open.weixin.qq.com/connect/oauth2/authorize?appid="
        		+appId+"&redirect_uri=http://weizengke.com/DingXinTianXia/mobileListGiftsTypes.a?appId="
        		+appId+"&response_type=code&scope=snsapi_base&state=1#wechat_redirect");
   
        ComplexButton mainBtn1 = new ComplexButton();
        mainBtn1.setName("积分商城");  
        mainBtn1.setSub_button(new Button[] { btn31, btn32});  
  
       
  
        /** 
         * 这是公众号xiaoqrobot目前的菜单结构，每个一级菜单都有二级菜单项<br> 
         *  
         * 在某个一级菜单下没有二级菜单的情况，menu该如何定义呢？<br> 
         * 比如，第三个一级菜单项不是“更多体验”，而直接是“幽默笑话”，那么menu应该这样定义：<br> 
         * menu.setButton(new Button[] { mainBtn1, mainBtn2, btn33 }); 
         */  
        Menu menu = new Menu();  
        menu.setButton(new Button[]{btn11,btn21,mainBtn1});
  
        return menu;  
    }  
}  