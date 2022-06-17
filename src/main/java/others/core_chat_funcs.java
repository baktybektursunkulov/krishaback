package others;

import gs.common.Consts;
import gs.common.date_time_funcs;
import gs.common.hibernate_funcs;
import gs.common.jsf.bundle_funcs;
import java.util.Calendar;
import java.util.Date;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import managers.core.dbtables.C_Chat_Cli_Manager;
import managers.core.dbtables.C_Chat_Manager;
import managers.core.dbtables.C_Chat_Msg_Manager;
import managers.core.dbtables.C_Chat_Party_Status_Manager;
import model.core.dbtables.*;
import org.hibernate.Session;

@ManagedBean
@ApplicationScoped
public class core_chat_funcs {

  private static core_chat_funcs currentInstance = null;

  public static core_chat_funcs getCI() {
    if (currentInstance == null) {
      currentInstance = new core_chat_funcs();
    }
    return currentInstance;
  }

  public void send_message(Integer from_c_tbl_id_, Long from_rec_id_, Integer to_c_tbl_id_, Long to_rec_id_,
    Integer c_chat_msg_type_id_, String msg_txt_, Long reply_id_, Date dt_) {
    Session session_ = model.core.dbutil.CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      session_.beginTransaction();
      send_message(session_, from_c_tbl_id_, from_rec_id_, to_c_tbl_id_, to_rec_id_, c_chat_msg_type_id_, msg_txt_, reply_id_, dt_);
      hibernate_funcs.commitAndClose(session_);
    } catch (Exception e) {
      CustomLogger.error(e);
      hibernate_funcs.rollbackAndClose(session_);
      throw e;
    }
  }

  public void send_message(Session session_, Integer from_c_tbl_id_, Long from_rec_id_, Integer to_c_tbl_id_, Long to_rec_id_,
    Integer c_chat_msg_type_id_, String msg_txt_, Long reply_id_, Date dt_) {
    C_Chat c_Chat = C_Chat_Manager.getCI().get_row_for_indiv_chat_or_ins(session_, from_c_tbl_id_, from_rec_id_, to_c_tbl_id_, to_rec_id_);
    C_Chat_Msg c_Chat_Msg = C_Chat_Msg_Manager.getCI().ins_row(session_, c_Chat.getC_chat(), c_chat_msg_type_id_,
      from_c_tbl_id_, from_rec_id_, to_c_tbl_id_, to_rec_id_,
      msg_txt_, reply_id_, dt_);
    c_Chat.setLast_c_chat_msg_t(c_Chat_Msg);
    session_.merge(c_Chat);
    C_Chat_Party_Status_Manager.getCI().set_last_visit_dt(session_, from_c_tbl_id_, from_rec_id_, dt_);

    C_Chat_Cli opposite_c_chat_cli_ = c_Chat.getOpposite_chat_cli_2(session_, from_c_tbl_id_, from_rec_id_);
    C_Chat_Cli_Manager.getCI().upd_unread_msg_cnt(session_, opposite_c_chat_cli_.getC_chat_cli());
  }

  public String get_chat_dt_str(Date date_) {
    Date now_ = new Date();
    String res = "";
    if (date_ == null) {
      return "";
    }
    if (date_time_funcs.dates_without_time_are_equal(date_, now_)) {
      res = Consts.sdfHHmm().format(date_);
    } else {
      if (date_time_funcs.dates_without_time_are_equal(date_, date_time_funcs.subtract_day(now_, 1))) {
        res = bundle_funcs.getBundleValue("вчера");
      } else {
        if (date_time_funcs.get_time_diff_in_day(date_, now_) < 7) {
          int dow_ = date_time_funcs.get_day_of_week(date_);
          if (dow_ == Calendar.MONDAY) {
            res = bundle_funcs.getBundleValue("понедельник");
          } else if (dow_ == Calendar.TUESDAY) {
            res = bundle_funcs.getBundleValue("вторник");
          } else if (dow_ == Calendar.WEDNESDAY) {
            res = bundle_funcs.getBundleValue("среда");
          } else if (dow_ == Calendar.THURSDAY) {
            res = bundle_funcs.getBundleValue("четверг");
          } else if (dow_ == Calendar.FRIDAY) {
            res = bundle_funcs.getBundleValue("пятница");
          } else if (dow_ == Calendar.SATURDAY) {
            res = bundle_funcs.getBundleValue("суббота");
          } else if (dow_ == Calendar.SUNDAY) {
            res = bundle_funcs.getBundleValue("воскресенье");
          }
        } else {
          res = Consts.sdfddMMyyyy().format(date_);
        }
      }
    }
    return res;
  }

  public String get_chat_dt_str_for_status(Date date_) {
    Date now_ = new Date();
    String res = "";
    if (date_ == null) {
      return "";
    }
    if (date_time_funcs.dates_without_time_are_equal(date_, now_)) {
      res = bundle_funcs.getBundleValue("сегодня");
    } else {
      if (date_time_funcs.dates_without_time_are_equal(date_, date_time_funcs.subtract_day(now_, 1))) {
        res = bundle_funcs.getBundleValue("вчера");
      } else {
        if (date_time_funcs.get_time_diff_in_day(date_, now_) < 7) {
          int dow_ = date_time_funcs.get_day_of_week(date_);
          if (dow_ == Calendar.MONDAY) {
            res = bundle_funcs.getBundleValue("понедельник");
          } else if (dow_ == Calendar.TUESDAY) {
            res = bundle_funcs.getBundleValue("вторник");
          } else if (dow_ == Calendar.WEDNESDAY) {
            res = bundle_funcs.getBundleValue("среда");
          } else if (dow_ == Calendar.THURSDAY) {
            res = bundle_funcs.getBundleValue("четверг");
          } else if (dow_ == Calendar.FRIDAY) {
            res = bundle_funcs.getBundleValue("пятница");
          } else if (dow_ == Calendar.SATURDAY) {
            res = bundle_funcs.getBundleValue("суббота");
          } else if (dow_ == Calendar.SUNDAY) {
            res = bundle_funcs.getBundleValue("воскресенье");
          }
        } else {
          res = Consts.sdfddMMyyyy().format(date_);
        }
      }
    }
    res = res + " " + bundle_funcs.getBundleValue("в") + " " + Consts.sdfHHmm().format(date_);
    return res;
  }

}
