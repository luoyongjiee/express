package com.sae.express.util.wechat;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.imageio.ImageIO;
import jp.sourceforge.qrcode.QRCodeDecoder;
import jp.sourceforge.qrcode.data.QRCodeImage;
import jp.sourceforge.qrcode.exception.DecodingFailedException;
import com.swetake.util.Qrcode;

public class QRCodeUtil {

	  /**
     * 生成二维码(QRCode)图片
     * @param content 存储内容
     * @param imgPath 图片路径
     */
    public static void encoderQRCode(String content, String imgPath) { 
        encoderQRCode(content, imgPath, "png", 7); 
    } 
       
    /**
     * 生成二维码(QRCode)图片
     * @param content 存储内容
     * @param output 输出流
     */
    public static void encoderQRCode(String content, OutputStream output) { 
        encoderQRCode(content, output, "png", 7); 
    } 
       
    /**
     * 生成二维码(QRCode)图片
     * @param content 存储内容
     * @param imgPath 图片路径
     * @param imgType 图片类型
     */
    public static void encoderQRCode(String content, String imgPath, String imgType) { 
        encoderQRCode(content, imgPath, imgType, 15); 
    } 
       
    /**
     * 生成二维码(QRCode)图片
     * @param content 存储内容
     * @param output 输出流
     * @param imgType 图片类型
     */
    public static void encoderQRCode(String content, OutputStream output, String imgType) { 
        encoderQRCode(content, output, imgType, 7); 
    } 
   
    /**
     * 生成二维码(QRCode)图片
     * @param content 存储内容
     * @param imgPath 图片路径
     * @param imgType 图片类型
     * @param size 二维码尺寸
     */
    public static void encoderQRCode(String content, String imgPath, String imgType, int size) { 
        try { 
            BufferedImage bufImg = qRCodeCommon(content, size); 
               
            File imgFile = new File(imgPath); 
            // 生成二维码QRCode图片 
            ImageIO.write(bufImg, imgType, imgFile); 
        } catch (Exception e) { 
            e.printStackTrace(); 
        } 
    } 
   
    /**
     * 生成二维码(QRCode)图片
     * @param content 存储内容
     * @param output 输出流
     * @param imgType 图片类型
     * @param size 二维码尺寸
     */
    public static void encoderQRCode(String content, OutputStream output, String imgType, int size) { 
        try { 
            BufferedImage bufImg = qRCodeCommon(content, size); 
            // 生成二维码QRCode图片 
            ImageIO.write(bufImg, imgType, output); 
        } catch (Exception e) { 
            e.printStackTrace(); 
        } 
    } 
       
    /**
     * 生成二维码(QRCode)图片的公共方法
     * @param content 存储内容
     * @param size 二维码尺寸
     * @return
     */
    public static BufferedImage qRCodeCommon(String content, int size) { 
        BufferedImage bufImg = null; 
        try { 
            Qrcode qrcodeHandler = new Qrcode();
            // 设置二维码排错率，可选L(7%)、M(15%)、Q(25%)、H(30%)，排错率越高可存储的信息越少，但对二维码清晰度的要求越小 
            qrcodeHandler.setQrcodeErrorCorrect('M');
            //编码模式：Numeric 数字， Alphanumeric 英文字母，Binary 二进制，Kanji 汉字
            qrcodeHandler.setQrcodeEncodeMode('B'); 
            // 设置设置二维码尺寸，取值范围1-40，值越大尺寸越大，可存储的信息越大 
            qrcodeHandler.setQrcodeVersion(size); 
            
            // 获得内容的字节数组，设置编码格式 
            byte[] contentBytes = content.getBytes("utf-8"); 
            boolean[][] codeOut = qrcodeHandler.calQrcode(contentBytes);
            size = qrcodeHandler.getQrcodeVersion();
            // 图片尺寸 
            int imgSize = 67 + 12 * (size - 1); 
            bufImg = new BufferedImage(imgSize, imgSize, BufferedImage.TYPE_INT_RGB); 
            Graphics2D gs = bufImg.createGraphics(); 
            // 设置背景颜色 
            gs.setBackground(Color.WHITE); 
            gs.clearRect(0, 0, imgSize, imgSize); 
           
            // 设定图像颜色> BLACK 
            gs.setColor(Color.BLACK); 
            // 设置偏移量，不设置可能导致解析出错 
            int pixoff = 2; 
            // 输出内容> 二维码 
            if (contentBytes.length > 0 && contentBytes.length < 800) { 
                //boolean[][] codeOut = qrcodeHandler.calQrcode(contentBytes); 
                for (int i = 0; i < codeOut.length; i++) { 
                    for (int j = 0; j < codeOut.length; j++) { 
                        if (codeOut[j][i]) { 
                            gs.fillRect(j * 3 + pixoff, i * 3 + pixoff, 3, 3); 
                        } 
                    } 
                } 
            } else { 
                throw new Exception("QRCode content bytes length = " + contentBytes.length + " not in [0, 800]."); 
            } 
            gs.dispose(); 
            bufImg.flush(); 
        } catch (Exception e) { 
            e.printStackTrace(); 
        } 
        return bufImg; 
    } 
       
    /**
     * 解析二维码（QRCode）
     * @param imgPath 图片路径
     * @return
     */
    public static String decoderQRCode(String imgPath) { 
        // QRCode 二维码图片的文件 
        File imageFile = new File(imgPath); 
        BufferedImage bufImg = null; 
        String content = null; 
        try { 
            bufImg = ImageIO.read(imageFile); 
            QRCodeDecoder decoder = new QRCodeDecoder(); 
            content = new String(decoder.decode(new TwoDimensionCodeImage(bufImg)), "utf-8");  
        } catch (IOException e) { 
            System.out.println("Error: " + e.getMessage()); 
            e.printStackTrace(); 
        } catch (DecodingFailedException dfe) { 
            System.out.println("Error: " + dfe.getMessage()); 
            dfe.printStackTrace(); 
        } 
        return content; 
    } 
       
    /**
     * 解析二维码（QRCode）
     * @param input 输入流
     * @return
     */
    public static String decoderQRCode(InputStream input) { 
        BufferedImage bufImg = null; 
        String content = null; 
        try { 
            bufImg = ImageIO.read(input); 
            QRCodeDecoder decoder = new QRCodeDecoder(); 
            content = new String(decoder.decode(new TwoDimensionCodeImage(bufImg)), "utf-8");  
        } catch (IOException e) { 
            System.out.println("Error: " + e.getMessage()); 
            e.printStackTrace(); 
        } catch (DecodingFailedException dfe) { 
            System.out.println("Error: " + dfe.getMessage()); 
            dfe.printStackTrace(); 
        } 
        return content; 
    } 
    
    /**
     * 图像缩放   
     * @param source   
     * @param targetW   
     * @param targetH   
     * @return   
     */
    public static BufferedImage resizeBufImage(BufferedImage source, int targetW,  
            int targetH) {  
        int type = source.getType();  
        BufferedImage target = null;  
        double sx = (double) targetW / source.getWidth();  
        double sy = (double) targetH / source.getHeight();  
        target = new BufferedImage(targetW, targetH, type);  
        Graphics2D g = target.createGraphics();  
        g.drawRenderedImage(source, AffineTransform.getScaleInstance(sx, sy));  
        g.dispose();  
        return target;  
    }  
   
   /* public static void main(String[] args) {
        String imgPath = "F:/img.jpg"; 
        String encoderContent = "https://open.weixin.qq.com/connect/oauth2/authorize?wx2c2ce644d2a9c3f4&redirect_uri=http://203.195.131.25:8080/HongWuYe/findBusinessListByIdMobileApi.a?token=1,1&response_type=code&scope=snsapi_base&state=1#wechat_redirect"; 
        encoderQRCode(encoderContent, imgPath, "jpg");   
        System.out.println("========encoder success"); 
           
           
       
        System.out.println("解析结果如下："); 
       
        System.out.println("========decoder success!!!"); 
    }*/
    
    static  class TwoDimensionCodeImage implements QRCodeImage  {
        BufferedImage bufImg; 
         
           public TwoDimensionCodeImage(BufferedImage bufImg) { 
               this.bufImg = bufImg; 
           } 
              
           @Override 
           public int getHeight() { 
               return bufImg.getHeight(); 
           } 
          
           @Override 
           public int getPixel(int x, int y) { 
               return bufImg.getRGB(x, y); 
           } 
          
           @Override 
           public int getWidth() { 
               return bufImg.getWidth(); 
           } 
   }
}