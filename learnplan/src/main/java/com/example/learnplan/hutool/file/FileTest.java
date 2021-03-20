package com.example.learnplan.hutool.file;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.StrUtil;

/** @author wangfk */
public class FileTest {
  public static void main(String[] args) {
    String filePath = "E:\\temp\\old\\123.pdf";
    String filePathTemp = "E:\\temp\\decrypt\\1.pdf";
    FileTest fileTest = new FileTest();
    String base64 = fileTest.encryptToBase64(filePath);
    System.out.println(base64);
    System.out.println(fileTest.decryptByBase64(base64, filePathTemp));
  }

  public String encryptToBase64(String filePath) {
    if (StrUtil.isBlank(filePath)) {
      return null;
    }
    byte[] bytes = FileUtil.readBytes(filePath);
    return Base64.encode(bytes);
  }

  public String decryptByBase64(String base64, String filePath) {
    if (StrUtil.isBlank(base64) || StrUtil.isBlank(filePath)) {
      return "生成文件失败，请给出相应的数据。";
    }
    FileUtil.writeBytes(Base64.decode(base64), filePath);
    return "指定路径下生成文件成功！";
  }
}
