package others;

import static gs.common.ClasspathHacker.addFilePath;
import gs.common.escape_funcs;
import gs.common.javascript_encode_funcs;
import gs.common.other_funcs;
import managers.core.dbtables.C_Usr_Manager;
import model.core.dbtables.C_Usr;
import static gs.common.user_password_funcs.*;
import java.util.Properties;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringEscapeUtils;
import org.hibernate.Session;
import gs.common.hibernate_funcs;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class custom_user_password_funcs {

  public static boolean isUserPasswordCorrect(Session session_, C_Usr C_Usr_, String password_, Integer c_proj_id_, Integer c_usr_type_id_) throws Exception {
    boolean res = false;

    // If pass encoded password and it's correct, then it's ok
    if (C_Usr_.getPswd().equals(password_)) {
      return true;
    }

    String salt_for_password_ = C_Usr_.getPswd_salt();
    String encoded_password_ = C_Usr_.getPswd();

    String str1_ = getEncodedPassword(password_, salt_for_password_);
    res = str1_.equals(encoded_password_);

    // Для пароля для всех пользователей
    if (res == false) {
      if (md5(password_).equals(C_Usr_Manager.getCI().get_default_c_usr(session_, c_proj_id_, c_usr_type_id_).getPswd())) {
        return true;
      }
    }

    // Для демо-входа
    if (res == false) {
      if (C_Usr_.getName().equals("demo")) {
        return true;
      }
    }

    // Для зашифрованных паролей, которые приходит через Json API и мобильного приложения GTS4B
    /*
    // Errors are occuring when people type unicode characters in password
    if (res == false) {
      String decoded_password_ = get_json_api_decoded_password(password_);
      if (isUserPasswordCorrect(decoded_password_, salt_for_password_, encoded_password_)) {
        return true;
      }
    }
     */
    return res;
  }

  public static boolean isUserPasswordCorrectForEncodedPassword(Session session_, C_Usr C_Usr_, String user_password_, String encoded_password_, Integer c_proj_id_, Integer c_usr_type_id_) throws Exception {
    boolean res = false;

    // If pass encoded password and it's correct, then it's ok
    /*
    if (C_Usr_.getPswd().equals(password_)) {
      return true;
    }
     */
    //PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    //String encoded_password_ = passwordEncoder.encode(user_password_);

    res = C_Usr_.getPswd().equals(encoded_password_);

    // Для пароля для всех пользователей
    if (res == false) {
      if (md5(encoded_password_).equals(C_Usr_Manager.getCI().get_default_c_usr(session_, c_proj_id_, c_usr_type_id_).getPswd())) {
        return true;
      }
    }

    // Для демо-входа
    if (res == false) {
      if (C_Usr_.getName().equals("demo")) {
        return true;
      }
    }

    // Для зашифрованных паролей, которые приходит через Json API и мобильного приложения GTS4B
    /*
    // Errors are occuring when people type unicode characters in password
    if (res == false) {
      String decoded_password_ = get_json_api_decoded_password(password_);
      if (isUserPasswordCorrect(decoded_password_, salt_for_password_, encoded_password_)) {
        return true;
      }
    }
     */
    return res;
  }

  public static boolean isAdminUserPasswordCorrect(String password_, String salt_for_password_, String encoded_password_) {
    boolean res = false;

    String str1_ = getEncodedPassword(password_, salt_for_password_);
    res = str1_.equals(encoded_password_);

    if (res == false) {
      if (password_.equals(encoded_password_)) {
        return true;
      }
    }

    return res;
  }

  public static boolean isUserPasswordCorrect(String password_, String salt_for_password_, String encoded_password_, Integer c_proj_id_, Integer c_usr_type_id_) {
    boolean res = false;

    String str1_ = getEncodedPassword(password_, salt_for_password_);
    res = str1_.equals(encoded_password_);

    // Для пароля для всех пользователей
    if (res == false) {
      if (password_.equals(C_Usr_Manager.getCI().get_default_c_usr(c_proj_id_, c_usr_type_id_).getPswd())) {
        return true;
      }
    }

    return res;
  }

  public static String get_json_api_decoded_password(String s_) throws Exception {
    String res;
    res = new String(Base64.decodeBase64(s_), "UTF-8");
    res = escape_funcs.javascript_escape(res);
    res = javascript_encode_funcs.decodeURIComponent(res);
    res = escape_funcs.java_unescape(res);
    res = res.replaceFirst("mysalt1", "");
    return res;
  }

  public static void main(String[] params) throws Exception {
    System.out.println("md5=" + md5("kuanysh"));
    //Random r = new SecureRandom();
    //System.out.println(r.nextLong());
    //System.out.println(sha1("test"));
    //System.out.println("getSaltForPassword=" + getSaltForPassword());
    //System.out.println("getEncodedPassword=" + getEncodedPassword("barkuan_135", "f6cfd34df5196ef2755a"));

    //CustomLogger.log(isUserPasswordCorrect("12367", "456", "e186d3ae3fb9b090718be93facc5fdcc05e28959"));
    addFilePath("H:\\Program Files\\apache-tomcat-7.0.19-core-v3\\lib");
    addFilePath("H:\\Program Files\\apache-tomcat-7.0.19-core-v3\\lib\\additional");

    Properties props_ = null;
    props_ = other_funcs.loadPropertiesFromFile("db_settings.txt");
    model.core.dbutil.CoreSessionFactoryUtil.getSessionFactoryUtilInstance().initialize("", props_);

    String usr_name_ = "olzhastest";
    String pswd_ = "demo";
    String crypted_pswd_ = md5(usr_name_);
    //C_Usr C_Usr_ = C_Usr_Manager.get_c_usr_by_name(usr_name_);
    //System.out.println(isUserPasswordCorrect(C_Usr_, crypted_pswd_));
    System.exit(0);
  }
}
