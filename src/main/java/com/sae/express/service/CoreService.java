package com.sae.express.service;

import javax.servlet.http.HttpServletRequest;


public interface CoreService {
     String processRequest(HttpServletRequest request);
     /*{
        String respMessage = null;  
        try {  
            // 默认返回的文本消息内容  
            String respContent = "请求处理异常，请稍候尝试！";
            Map<String, String> requestMap = MessageUtil.parseXml(request);// xml请求解析
            String fromUserName = requestMap.get("FromUserName"); // 发送方帐号（open_id）
            String toUserName = requestMap.get("ToUserName"); // 公众帐号
            String msgType = requestMap.get("MsgType"); // 消息类型
            String content = requestMap.get("Content");//文本消息
            log.info("fromUserName:"+fromUserName+"msgType:"+msgType+"toUserName=="+toUserName+"收到消息："+content+"requestMap"+requestMap.toString());

            // 回复文本消息
            TextMessage textMessage = new TextMessage();
            textMessage.setToUserName(fromUserName);  
            textMessage.setFromUserName(toUserName);  
            textMessage.setCreateTime(new Date().getTime());  
            textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
            textMessage.setFuncFlag(0);  
  
            // 文本消息  
            if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {  
                respContent = "您发送的是文本消息！";
                return null;
            }  
            // 图片消息  
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) {  
                respContent = "您发送的是图片消息！";
                return null;
            }  
            // 地理位置消息  
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) {  
                respContent = "您发送的是地理位置消息！";
                return null;
            }  
            // 链接消息  
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)) {  
                respContent = "您发送的是链接消息！"; 
                return null;
            }  
            // 音频消息  
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) {  
                respContent = "您发送的是音频消息！";
                return null;
            }  
            // 事件推送  
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {  
                // 事件类型  
            	System.out.println("到达==");
                String eventType = requestMap.get("Event");
                System.out.println(eventType);
                
                // 订阅  
                if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {  
                	*//*
                	获取unionId，暂时需求不需要
                	String eventKey  = requestMap.get("EventKey");
                      	if(eventKey!=null){
                		    String unionId = eventKey.substring(eventKey.indexOf("_")+1, eventKey.length());
                    *//*
                    //TODO 通过openID从数据库中获取accesstoken
                   String accessToken= weChatPlatformService.getWeChatPlatform("PUBLIC_APP_ID").getAccess_token();
                   // wxPlatformBLL.getWxPlatform(ConstantsUtil.PUBLIC_APP_ID).getAccess_token()

                    //TODO  根据token和openId获取用户基本信息
					WeChatUnionUser unionUser = WeChatUtil.getWeiXinUnionUser(accessToken, fromUserName);
                    if (unionUser != null) {
                        //TODO 用户信息存入数据库
                        //AgentUser agentUser = agentUserBLL.getAgentUserByUnionId(unionUser.getUnionid());
                        System.out.println("用户关注成功， 微信昵称："+unionUser.getNickName());
                        String name = EmojiExchangeUtil.filterEmoji2(unionUser.getNickName());
                        System.out.println("转换后 微信昵称："+name);

					}
					respContent = "感谢您关注**快递！"+String.valueOf(Character.toChars(0x270c));
                }  
                // 取消订阅  
                else if (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {  
                    // TODO 取消订阅后用户再收不到公众号发送的消息，因此不需要回复消息  
                	
                } 
                //点击KEY菜单
                else if (eventType.equals(MessageUtil.EVENT_TYPE_CLICK)) {  
                    // 事件KEY值，与创建自定义菜单时指定的KEY值对应  
                    String eventKey = requestMap.get("EventKey");
                    respContent= "点击了菜单"+String.valueOf(Character.toChars(0x270c));
                }
                //点击view菜单
                else  if(eventType.equals(MessageUtil.EVENT_TYPE_VIEW)){
                    return null;
                	
                }
                // 上报地理位置
                else if(eventType.equals(MessageUtil.EVENT_TYPE_LOCATION)){
                	return null;
                }
                log.info("eventType--"+eventType);
            }  
            
            textMessage.setContent(respContent);  
            respMessage = MessageUtil.textMessageToXml(textMessage);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
  
        return respMessage;  
    }  */
}
