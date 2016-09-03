package com.sae.express.util.wechat;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.sae.express.dao.model.wechat.WeChatMedia;
import net.sf.json.JSONObject;

/**
 * 媒体接口类
 * @author panda
 *
 */
public class MediaUtil {
	public static String unload_media_url ="http://file.api.weixin.qq.com/cgi-bin/media/upload?access_token=ACCESS_TOKEN&type=TYPE";
	public static String download_media_url ="http://file.api.weixin.qq.com/cgi-bin/media/get?access_token=ACCESS_TOKEN&media_id=MEDIA_ID";

	/**
	 * 获取媒体文件
	 * @param accessToken 接口访问凭证
	 * @param savePath 文件在服务器上的存储路径
	 * */
	public static String downloadMedia(String accessToken, String mediaId, String savePath) {
		String path = "";
				//ServletActionContext.getServletContext().getRealPath("/");
		String imgStr="";
		HttpServletRequest request = null;
				//ServletActionContext.getRequest();
		String headPath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ request.getContextPath() + "/";
	
		String fileExt = null;
		String filePath = null;
		// 拼接请求地址
		download_media_url = download_media_url.replace("MEDIA_ID", mediaId).replace("ACCESS_TOKEN", accessToken);
		System.out.println(mediaId+"-------download_media_url:----------"+download_media_url);
		try {
			URL url = new URL(download_media_url);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoInput(true);
			conn.setRequestMethod("GET");

			if (!savePath.endsWith("/")) {
				savePath += "/";
			}
			// 根据内容类型获取扩展名
			fileExt = WeChatUtil.getFileEndWitsh(conn.getHeaderField("Content-Type"));
			// 将mediaId作为文件名
			filePath = path+savePath + mediaId + fileExt;

			BufferedInputStream bis = new BufferedInputStream(conn.getInputStream());
			FileOutputStream fos = new FileOutputStream(new File(filePath));
			byte[] buf = new byte[8096];
			int size = 0;
			while ((size = bis.read(buf)) != -1)
				fos.write(buf, 0, size);
			fos.close();
			bis.close();

			conn.disconnect();
			String info = String.format("下载媒体文件成功，filePath=" + filePath);
			System.out.println(info);
		} catch (Exception e) {
			filePath = null;
			String error = String.format("下载媒体文件失败：", e);
			System.out.println(error);
		}
		return (headPath+savePath + mediaId + fileExt);
	}
	public static String downloadMedia(String accessToken, List<Object> mediaIdList, String savePath) {
		String path = "";
				//ServletActionContext.getServletContext().getRealPath("/");
		String imgStr="";
		HttpServletRequest request = null;
				//ServletActionContext.getRequest();
		String headPath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ request.getContextPath() + "/";
		String mediaIdStr="";
		String fileExt = null;
		String filePath = null;
		URL url=null;
		HttpURLConnection conn=null;
		BufferedInputStream bis =null;
		FileOutputStream fos =null;
		String dowUrl=null;
		if (!savePath.endsWith("/")) {
			savePath += "/";
		}
		if(mediaIdList!=null&&mediaIdList.size()>0){
			for (int i = 0; i < mediaIdList.size(); i++) {
				mediaIdStr=mediaIdList.get(i).toString();
				System.out.println("----------idstr---------"+mediaIdStr);
				if(mediaIdStr==null||mediaIdStr.equals(""))
					continue;
				dowUrl = download_media_url.replace("MEDIA_ID", mediaIdStr).replace("ACCESS_TOKEN", accessToken);
				System.out.println(mediaIdStr+"-------download_media_url:----------"+dowUrl);
				//download_media_url=download_media_url.replace("MEDIA_ID", mediaIdStr);
				//System.out.println(mediaIdStr+"-------download_media_url:----------"+download_media_url);

				// 拼接请求地址
				try {
					url= new URL(dowUrl);
					conn = (HttpURLConnection) url.openConnection();
					conn.setDoInput(true);
					conn.setRequestMethod("GET");

					
					// 根据内容类型获取扩展名
					fileExt = WeChatUtil.getFileEndWitsh(conn.getHeaderField("Content-Type"));
					// 将mediaId作为文件名
					filePath = path+savePath + mediaIdStr + fileExt;

					bis = new BufferedInputStream(conn.getInputStream());
					fos = new FileOutputStream(new File(filePath));
					byte[] buf = new byte[8096];
					int size = 0;
					while ((size = bis.read(buf)) != -1)
						fos.write(buf, 0, size);
					
					fos.close();
					bis.close();
					conn.disconnect();
					String info = String.format("下载媒体文件成功，filePath=" + filePath);
					System.out.println(info);
				} catch (Exception e) {
					filePath = null;
					String error = String.format("下载媒体文件失败：", e);
					System.out.println(error);
				}
				if(imgStr!=null&&!imgStr.equals(""))
					imgStr=imgStr+","+(headPath+savePath + mediaIdStr + fileExt);
				else 
					imgStr=(headPath+savePath + mediaIdStr + fileExt);
				System.out.println("-----imgStr----"+imgStr);
			}
			
		}
		return imgStr;
	}
	/**
	 * 上传媒体文件
	 * @param accessToken 接口访问凭证
	 * @param type 媒体文件类型，分别有图片（image）、语音（voice）、视频（video），普通文件(file)
	 * @param mediaFileUrl 媒体文件的url
	 * 上传的媒体文件限制
     * 图片（image）:1MB，支持JPG格式
     * 语音（voice）：2MB，播放长度不超过60s，支持AMR格式
     * 视频（video）：10MB，支持MP4格式
     * 普通文件（file）：10MB
	 * */
	public static WeChatMedia uploadMedia(String accessToken, String type, String mediaFileUrl) {
		WeChatMedia weChatMedia = null;
		// 拼装请求地址
		unload_media_url = unload_media_url.replace("ACCESS_TOKEN", accessToken).replace("TYPE", type);
		// 定义数据分隔符
		String boundary = "------------7da2e536604c8";
		try {
			URL uploadUrl = new URL(unload_media_url);
			HttpURLConnection uploadConn = (HttpURLConnection) uploadUrl.openConnection();
			uploadConn.setDoOutput(true);
			uploadConn.setDoInput(true);
			uploadConn.setRequestMethod("POST");
			// 设置请求头Content-Type
			uploadConn.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + boundary);
			// 获取媒体文件上传的输出流（往微信服务器写数据）
			OutputStream outputStream = uploadConn.getOutputStream();

			URL mediaUrl = new URL(mediaFileUrl);
			HttpURLConnection meidaConn = (HttpURLConnection) mediaUrl.openConnection();
			meidaConn.setDoOutput(true);
			meidaConn.setRequestMethod("GET");

			// 从请求头中获取内容类型
			String contentType = meidaConn.getHeaderField("Content-Type");
			// 根据内容类型判断文件扩展名
			String fileExt = WeChatUtil.getFileEndWitsh(contentType);
			// 请求体开始
			outputStream.write(("--" + boundary + "\r\n").getBytes());
			outputStream.write(String.format("Content-Disposition: form-data; name=\"media\"; filename=\"file1%s\"\r\n", fileExt).getBytes());
			outputStream.write(String.format("Content-Type: %s\r\n\r\n", contentType).getBytes());

			// 获取媒体文件的输入流（读取文件）
			BufferedInputStream bis = new BufferedInputStream(meidaConn.getInputStream());
			byte[] buf = new byte[8096];
			int size = 0;
			while ((size = bis.read(buf)) != -1) {
				// 将媒体文件写到输出流（往微信服务器写数据）
				outputStream.write(buf, 0, size);
			}
			// 请求体结束
			outputStream.write(("\r\n--" + boundary + "--\r\n").getBytes());
			outputStream.close();
			bis.close();
			meidaConn.disconnect();

			// 获取媒体文件上传的输入流（从微信服务器读数据）
			InputStream inputStream = uploadConn.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			StringBuffer buffer = new StringBuffer();
			String str = null;
			while ((str = bufferedReader.readLine()) != null) {
				buffer.append(str);
			}
			bufferedReader.close();
			inputStreamReader.close();
			// 释放资源
			inputStream.close();
			inputStream = null;
			uploadConn.disconnect();

			// 使用JSON-lib解析返回结果
			JSONObject jsonObject = JSONObject.fromObject(buffer.toString());
			weChatMedia = new WeChatMedia();
			weChatMedia.setType(jsonObject.getString("type"));
			// type等于 缩略图（thumb） 时的返回结果和其它类型不一样
			if ("thumb".equals(type))
				weChatMedia.setMediaId(jsonObject.getString("thumb_media_id"));
			else
				weChatMedia.setMediaId(jsonObject.getString("media_id"));
			    weChatMedia.setCreatedAt(jsonObject.getInt("created_at"));
		} catch (Exception e) {
			weChatMedia = null;
			String error = String.format("上传媒体文件失败：%s", e);
			System.out.println(error);
		}
	
		return weChatMedia;
	}
	
}
