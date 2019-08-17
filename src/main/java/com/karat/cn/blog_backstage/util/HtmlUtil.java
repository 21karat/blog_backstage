package com.karat.cn.blog_backstage.util;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

public class HtmlUtil {

    public static String getHtmlString(){
        String a="<div style=\"background: #EEEED1\">\n" +
                "        <div style=\"padding-left:15px;margin-right:15px;margin-top:-5px;margin-bottom:15px\"><br>\n" +
                "        <span>最近哼多人都在完绝地求生，缺是第一次玩很多人都晕3D，有些进场打CF的人玩起来比起没玩过枪战的人更加适合这款游戏。</span><br></div></div>\n" +
                "    <span style=\"font-weight:bold;font-size:12px\">关于小程序开发</span>\n" +
                "    <ul>\n" +
                "        <li>Java</li>\n" +
                "        <li>HTML</li>\n" +
                "        <li>Python</li>\n" +
                "    </ul> \n" +
                "        <img src=\"http://img4.imgtn.bdimg.com/it/u=1451023851,4108165595&fm=26&gp=0.jpg\"></img>  \n" +
                "    <p>微信小程序如何解析HTML富文本（使用wxParse解析富文本的demo）微信小程序如何解析HTML富文本（使用wxParse解析富文本的demo）微信小程序如何解析HTML富文本（使用wxParse解析富文本的demo）</p>  \n" +
                "    <p>微信小程序如何解析HTML富文本（使用wxParse解析富文本的demo）微信小程序如何解析HTML富文本（使用wxParse解析富文本的demo）微信小程序如何解析HTML富文本（使用wxParse解析富文本的demo）</p>  \n" +
                "        <img src=\"http://img5.imgtn.bdimg.com/it/u=69050753,1382655822&fm=26&gp=0.jpg\"></img>  \n" +
                "    <p>近两年，小青柑的火爆有目共睹，娇小玲珑的产品形态、便携式的消费场景、柑与茶结合的时尚方式以及独特的口感和养生功效，都在顺应着目前年轻化、多元化、便携化的茶叶消费市场需求，让它成为了一大爆品。</p> ";
        return a;
    }


    public static String getHtml(String adrr){
        String html="";
        File fin = new File(adrr);
        try (RandomAccessFile accessFile = new RandomAccessFile(fin, "r");FileChannel fcin = accessFile.getChannel();){
            Charset charset = Charset.forName("UTF-8");
            int bufSize = 100000;
            ByteBuffer rBuffer = ByteBuffer.allocate(bufSize);
            String enterStr = "\n";
            byte[] bs = new byte[bufSize];
            StringBuilder strline = new StringBuilder("");
            StringBuilder strBuf = new StringBuilder("");
            while (fcin.read(rBuffer) != -1) {
                int rSize = rBuffer.position();
                rBuffer.rewind();
                rBuffer.get(bs);
                rBuffer.clear();
                String tempString = new String(bs, 0, rSize,charset);
                tempString = tempString.replaceAll("\r", "");

                int fromIndex = 0;
                int endIndex = 0;
                while ((endIndex = tempString.indexOf(enterStr, fromIndex)) != -1) {
                    String line = tempString.substring(fromIndex, endIndex);
                    line = strBuf.toString() + line;
                    strline.append(line.trim());

                    strBuf.delete(0, strBuf.length());
                    fromIndex = endIndex + 1;
                }
                if (rSize > tempString.length()) {
                    strline.append(tempString.substring(fromIndex, tempString.length()));
                    strBuf.append(tempString.substring(fromIndex, tempString.length()));
                } else {
                    strline.append(tempString.substring(fromIndex, rSize));
                    strBuf.append(tempString.substring(fromIndex, rSize));
                }
            }
            html=strline.toString().replaceAll("\"", "'");
        } catch (Exception e) {

        }
        return html;
    }
}
