package com.example.learnplan.hutool.crypto;

import cn.hutool.core.util.CharsetUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.asymmetric.Sign;
import cn.hutool.crypto.asymmetric.SignAlgorithm;
import cn.hutool.crypto.symmetric.AES;

import java.nio.charset.StandardCharsets;

/** @author wangfk */
public class CryptoTest {
  public static void main(String[] args) {
    String content = "{\"aa\":\"cc\",\"bb\":\"cc\"}";
    // 构建
    AES aes = SecureUtil.aes("Gbzt@1306@GanDao".getBytes(StandardCharsets.UTF_8));
    // 加密为16进制表示
    String encryptHex = aes.encryptHex(content);
    System.out.println(encryptHex);
    // 解密为字符串
    String decryptStr = aes.decryptStr(encryptHex, CharsetUtil.CHARSET_UTF_8);
    System.out.println(decryptStr);
    byte[] data = "我是一段测试字符串".getBytes();
    Sign sign = SecureUtil.sign(SignAlgorithm.MD5withRSA);
    // 签名
    byte[] signed = sign.sign(data);
    // 验证签名
    byte[] dataErr = "我是一段错误字符串".getBytes();
    boolean verify = sign.verify(dataErr, signed);
    System.out.println(verify);
  }
}
