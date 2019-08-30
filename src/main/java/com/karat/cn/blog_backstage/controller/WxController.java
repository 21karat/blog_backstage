package com.karat.cn.blog_backstage.controller;

import com.karat.cn.blog_backstage.wx.AES;
import org.apache.commons.codec.binary.Base64;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class WxController {


    @RequestMapping("/decrypt")
    public Map decrypt(String encryptedData, String iv, String sessionKey){
        Map map = new HashMap();
        try {
            byte[] resultByte  = AES.decrypt(Base64.decodeBase64(encryptedData),
                    Base64.decodeBase64(sessionKey),
                    Base64.decodeBase64(iv));
            if(null != resultByte && resultByte.length > 0){
                String userInfo = new String(resultByte, "UTF-8");
                map.put("status", "1");
                map.put("msg", "解密成功");
                map.put("userInfo", userInfo);
            }else{
                map.put("status", "0");
                map.put("msg", "解密失败");
            }
        }catch (InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return map;
    }
}
