package managers.core.dbtables;

import gs.common.google_translate_funcs;
import static gs.common.google_translate_funcs.get_google_translate_key;
import static gs.common.google_translate_funcs.translate;
import static gs.common.google_translate_funcs.translate_text_format;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import model.core.dbtables.*;
import gs.common.managers.My_Abstract_Controller_Manager;
import gs.common.model.db.*;
import org.hibernate.*;
import others.CustomLogger;
import gs.common.hibernate_funcs;
import gs.common.user_password_funcs;
import java.util.*;
import java.text.*;
import static managers.core.dbtables.C_Res_Bundle_Manager.check_all_translations;
import model.core.dbutil.CoreSessionFactoryUtil;

@ManagedBean
@ApplicationScoped
public class C_Translation_Manager extends Abstract_Controller_Manager<C_Translation> {

  private static C_Translation_Manager currentInstance = null;

  public static C_Translation_Manager getCI() {
    if (currentInstance == null) {
      currentInstance = new C_Translation_Manager();
    }
    return currentInstance;
  }

  public C_Translation_Manager() {
    super(C_Translation.class);
  }

  public C_Translation get_row(String source_lang_, String target_lang_, String txt_, String txt_format_) {
    C_Translation res = null;
    Session session_ = CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      session_.getTransaction().begin();
      res = get_row(session_, source_lang_, target_lang_, txt_, txt_format_);
      hibernate_funcs.commitAndClose(session_);
    } catch (Exception e) {
      CustomLogger.error(e);
      if (session_.getTransaction() != null) {
        hibernate_funcs.rollbackAndClose(session_);
      }
      throw e;
    }
    return res;
  }

  public C_Translation get_row(Session session_, String source_lang_, String target_lang_, String txt_, String txt_format_) {
    Query q_ = session_.createQuery("from C_Translation t where t.is_deleted=false and t.source_lang=:source_lang_ and t.target_lang=:target_lang_ and t.txt_format=:txt_format_ and md5(t.txt)=:txt_ order by 1 asc");
    q_.setString("source_lang_", source_lang_);
    q_.setString("target_lang_", target_lang_);
    q_.setString("txt_", user_password_funcs.md5(txt_));
    q_.setString("txt_format_", txt_format_);
    List<C_Translation> list_ = q_.list();
    if (list_.isEmpty()) {
      return null;
    } else {
      return list_.get(0);
    }
  }

  public static String translate_text_format(String source_lang_, String target_lang_, String text_) {
    return translate(source_lang_, target_lang_, text_, "text");
  }

  public static String translate_text_format(Session session_, String source_lang_, String target_lang_, String text_) {
    return translate(session_, source_lang_, target_lang_, text_, "text");
  }

  public static String translate_html_format(String source_lang_, String target_lang_, String text_) {
    return translate(source_lang_, target_lang_, text_, "html");
  }

  public static String translate_html_format(Session session_, String source_lang_, String target_lang_, String text_) {
    return translate(session_, source_lang_, target_lang_, text_, "html");
  }

  public static String translate(String source_lang_, String target_lang_, String text_, String format_) {
    String res = null;
    Session session_ = CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      session_.getTransaction().begin();
      res = translate(session_, source_lang_, target_lang_, text_, format_);
      hibernate_funcs.commitAndClose(session_);
    } catch (Exception e) {
      CustomLogger.error(e);
      if (session_.getTransaction() != null) {
        hibernate_funcs.rollbackAndClose(session_);
      }
      throw e;
    }
    return res;
  }

  public static String translate(Session session_, String source_lang_, String target_lang_, String text_, String format_) {
    String res;

    C_Translation rec_ = getCI().get_row(session_, source_lang_, target_lang_, text_, format_);
    if (rec_ == null) {
      res = google_translate_funcs.translate(source_lang_, target_lang_, text_, format_);
      if (res != null) {
        rec_ = new C_Translation();
        rec_.setSource_lang(source_lang_);
        rec_.setTarget_lang(target_lang_);
        rec_.setTxt(text_);
        rec_.setTxt_format(format_);
        rec_.setTranslation(res);
        rec_.setIs_deleted(false);
        session_.save(rec_);
      }
    } else {
      return rec_.getTranslation();
    }

    return res;
  }

}
