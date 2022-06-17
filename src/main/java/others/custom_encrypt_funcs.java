package others;

import static gs.common.ClasspathHacker.addFilePath;
import gs.common.other_funcs;
import java.security.SecureRandom;
import java.util.Random;
import managers.core.dbtables.C_Usr_Manager;
import model.core.dbtables.C_Usr;
import static gs.common.user_password_funcs.*;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.security.DigestException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.MessageDigest;
import java.security.Security;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Arrays;
import java.util.Properties;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringEscapeUtils;

public class custom_encrypt_funcs {

  /*
  public static String decrypt_aes(String cipherText, String secret) throws Exception {
    byte[] cipherData = DatatypeConverter.parseBase64Binary(cipherText);
    byte[] saltData = Arrays.copyOfRange(cipherData, 8, 16);

    MessageDigest md5 = MessageDigest.getInstance("MD5");
    final byte[][] keyAndIV = GenerateKeyAndIV(32, 16, 1, saltData, secret.getBytes(StandardCharsets.UTF_8), md5);
    SecretKeySpec key = new SecretKeySpec(keyAndIV[0], "AES");
    IvParameterSpec iv = new IvParameterSpec(keyAndIV[1]);

    byte[] encrypted = Arrays.copyOfRange(cipherData, 16, cipherData.length);
    Cipher aesCBC = Cipher.getInstance("AES/CBC/PKCS5Padding");
    aesCBC.init(Cipher.DECRYPT_MODE, key, iv);
    byte[] decryptedData = aesCBC.doFinal(encrypted);
    String decryptedText = new String(decryptedData, StandardCharsets.UTF_8);

    System.out.println(decryptedText);
    return decryptedText;
  }

  public static byte[][] GenerateKeyAndIV(int keyLength, int ivLength, int iterations, byte[] salt, byte[] password, MessageDigest md) {

    int digestLength = md.getDigestLength();
    int requiredLength = (keyLength + ivLength + digestLength - 1) / digestLength * digestLength;
    byte[] generatedData = new byte[requiredLength];
    int generatedLength = 0;

    try {
      md.reset();

      // Repeat process until sufficient data has been generated
      while (generatedLength < keyLength + ivLength) {

        // Digest data (last digest if available, password data, salt if available)
        if (generatedLength > 0) {
          md.update(generatedData, generatedLength - digestLength, digestLength);
        }
        md.update(password);
        if (salt != null) {
          md.update(salt, 0, 8);
        }
        md.digest(generatedData, generatedLength, digestLength);

        // additional rounds
        for (int i = 1; i < iterations; i++) {
          md.update(generatedData, generatedLength, digestLength);
          md.digest(generatedData, generatedLength, digestLength);
        }

        generatedLength += digestLength;
      }

      // Copy key and IV into separate byte arrays
      byte[][] result = new byte[2][];
      result[0] = Arrays.copyOfRange(generatedData, 0, keyLength);
      if (ivLength > 0) {
        result[1] = Arrays.copyOfRange(generatedData, keyLength, keyLength + ivLength);
      }

      return result;

    } catch (DigestException e) {
      throw new RuntimeException(e);

    } finally {
      // Clean out temporary data
      Arrays.fill(generatedData, (byte) 0);
    }
  }

  public static String encrypt(String key, String initVector, String value) {
    try {
      IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
      SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

      Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
      cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);

      byte[] encrypted = cipher.doFinal(value.getBytes());
      System.out.println("encrypted string: "
        + Base64.encodeBase64String(encrypted));

      return Base64.encodeBase64String(encrypted);
    } catch (Exception ex) {
      ex.printStackTrace();
    }

    return null;
  }

  public static String decrypt(String key, String initVector, String encrypted) {
    try {
      IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
      SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

      Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
      cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);

      byte[] original = cipher.doFinal(Base64.decodeBase64(encrypted));

      return new String(original);
    } catch (Exception ex) {
      ex.printStackTrace();
    }

    return null;
  }
   */
 /*
  public static String toJson(final String encrypted) {
    try {
      SecretKey key = new SecretKeySpec(DatatypeConverter.parseBase64Binary("u/Gu5posvwDsXUnV5Zaq4g=="), "AES");
      AlgorithmParameterSpec iv = new IvParameterSpec(DatatypeConverter.parseBase64Binary("5D9r9ZVzEYYgha93/aUK2w=="));
      byte[] decodeBase64 = DatatypeConverter.parseBase64Binary(encrypted);

      Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
      cipher.init(Cipher.DECRYPT_MODE, key, iv);

      return new String(cipher.doFinal(decodeBase64), "UTF-8");
    } catch (Exception e) {
      throw new RuntimeException("This should not happen in production.", e);
    }
  }
   */
  public static String symmetricEncrypt(String text, String secretKey) {
    byte[] raw;
    String encryptedString;
    SecretKeySpec skeySpec;
    byte[] encryptText = text.getBytes();
    Cipher cipher;
    try {
      //raw = Base64.decodeBase64(secretKey);
      skeySpec = new SecretKeySpec(text.getBytes(), "AES");
      cipher = Cipher.getInstance("AES");
      cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
      encryptedString = Base64.encodeBase64String(cipher.doFinal(encryptText));
    } catch (Exception e) {
      e.printStackTrace();
      return "Error";
    }
    return encryptedString;
  }

  public static String toJson(final String encrypted) {
    try {
      SecretKey key = new SecretKeySpec(Base64.decodeBase64("u/Gu5posvwDsXUnV5Zaq4g=="), "AES");
      AlgorithmParameterSpec iv = new IvParameterSpec(Base64.decodeBase64("5D9r9ZVzEYYgha93/aUK2w=="));
      byte[] decodeBase64 = Base64.decodeBase64(encrypted);

      Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
      cipher.init(Cipher.DECRYPT_MODE, key, iv);

      return new String(cipher.doFinal(decodeBase64), "UTF-8");
    } catch (Exception e) {
      throw new RuntimeException("This should not happen in production.", e);
    }
  }

  public static String decodeURIComponent(String s) {
    if (s == null) {
      return null;
    }

    String result = null;

    try {
      result = URLDecoder.decode(s, "UTF-8");
    } // This exception should never occur.
    catch (Exception e) {
      result = s;
    }

    return result;
  }

  public static void main(String[] params) throws Exception {
    //Random r = new SecureRandom();
    //System.out.println(r.nextLong());
    //System.out.println(sha1("test"));
    //System.out.println("getSaltForPassword=" + getSaltForPassword());
    //System.out.println("getEncodedPassword=" + getEncodedPassword("barkuan_135", "f6cfd34df5196ef2755a"));

    //CustomLogger.log(isUserPasswordCorrect("12367", "456", "e186d3ae3fb9b090718be93facc5fdcc05e28959"));
    addFilePath("H:\\Program Files\\apache-tomcat-7.0.19-core-v3\\lib");
    addFilePath("H:\\Program Files\\apache-tomcat-7.0.19-core-v3\\lib\\additional");
    //System.out.println(decrypt_aes("U2FsdGVkX1+tsmZvCEFa/iGeSA0K7gvgs9KXeZKwbCDNCs2zPo+BXjvKYLrJutMK+hxTwl/hyaQLOaD7LLIRo2I5fyeRMPnroo6k8N9uwKk=", "René Über"));
    //String key = "Bar12345Bar12345"; // 128 bit key
    //String initVector = "RandomInitVector"; // 16 bytes IV

    //System.out.println(decrypt(key, initVector,
    //  encrypt(key, initVector, "Hello World")));
    //System.out.println(toJson("tet"));
    String secret = "1234567812345678";
    String text_ = "demo";
    Key key = new SecretKeySpec(secret.getBytes(), "AES");
    AlgorithmParameterSpec iv = new IvParameterSpec(Base64.decodeBase64("5D9r9ZVzEYYgha93/aUK2w=="));

// Encrypt
    System.out.println(Arrays.toString(Security.getProviders()));
    /*
    for (java.​securityProvider prov : Security.getProviders()) {
      System.out.println("prov=" + prov);
    }
     */
    Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
    cipher.init(Cipher.ENCRYPT_MODE, key, iv);
    byte[] encryptedData = cipher.doFinal("demo".getBytes());
    System.out.println(Base64.encodeBase64String(encryptedData));

    //System.out.println(symmetricEncrypt(text_, secret));
// Decrypt
    //cipher.init(Cipher.DECRYPT_MODE, key);
    //byte[] decryptedData = cipher.doFinal("U2FsdGVkX1/OA8Kox+IQLB4PAZQCPvIj3ixaF5ROFwE=".getBytes());
    //System.out.println(new String(decryptedData, "UTF-8"));
    //System.out.println(toJson("bbeb784d0cd93c684f81692dcb2270d7"));
    System.out.println("res=" + new String(Base64.decodeBase64("ZGVtbw==")));
    System.out.println(new String(Base64.decodeBase64("0J/RgNC40LLQtdGCXzYxOQ==")));
    System.out.println(decodeURIComponent(new String(Base64.decodeBase64("0J/RgNC40LLQtdGCXzYxOQ=="))));
    System.out.println(StringEscapeUtils.escapeEcmaScript(new String(Base64.decodeBase64("0J/RgNC40LLQtdGCXzYxOQ=="))));
    System.out.println(decodeURIComponent(StringEscapeUtils.escapeEcmaScript(new String(Base64.decodeBase64("0J/RgNC40LLQtdGCXzYxOQ==")))));
    System.out.println(decodeURIComponent(StringEscapeUtils.escapeEcmaScript(new String(Base64.decodeBase64("0J/RgNC40LLQtdGCXzYxOQ=="), "UTF-8"))));
    System.out.println(StringEscapeUtils.unescapeJava(decodeURIComponent(StringEscapeUtils.escapeEcmaScript(new String(Base64.decodeBase64("w5DCn8ORwoDDkMK4w5DCssOQwrXDkcKCXzYxOQ=="), "UTF-8")))));
    
    System.out.println(custom_user_password_funcs.get_json_api_decoded_password("0KHRg9GB0LvQuNC6K183MS0oIScpfg=="));
    System.exit(0);
  }
}
