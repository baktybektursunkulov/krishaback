package managers.core.dbtables;

import gs.common.hibernate_funcs;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import model.core.dbtables.*;
import gs.common.managers.My_Abstract_Controller_Manager;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import model.core.dbutil.CoreSessionFactoryUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import others.CustomLogger;

@ManagedBean
@ApplicationScoped
public class C_Tbl_Prop_Manager extends Abstract_Controller_Manager<C_Tbl_Prop> {

  private static C_Tbl_Prop_Manager currentInstance = null;
  public ConcurrentHashMap<String, C_Tbl_Prop> c_tbl_prop_map = new ConcurrentHashMap();
  private Integer c_tbl_prop_id__customer_last_logged_usr_name = 4;// Имя пользователя последнего входа покупателя
  private Integer c_tbl_prop_id__is_customer_logged_in = 5;// Покупатель вошел в систему
  private Integer c_tbl_prop_id__customer_location_id = 7;// ID локации покупателя
  private Integer c_tbl_prop_id__customer_country_id = 8;// ID страны покупателя
  private Integer c_tbl_prop_id__customer_last_lat = 9;// Последняя широта покупателя
  private Integer c_tbl_prop_id__customer_last_lon = 10;// Последняя долгота покупателя
  private Integer c_tbl_prop_id__customer_cur_id = 11;// ID валюты покупателя

  public static C_Tbl_Prop_Manager getCI() {
    if (currentInstance == null) {
      currentInstance = new C_Tbl_Prop_Manager();
    }
    return currentInstance;
  }

  public ConcurrentHashMap<String, C_Tbl_Prop> getC_tbl_prop_map() {
    return c_tbl_prop_map;
  }

  public void setC_tbl_prop_map(ConcurrentHashMap<String, C_Tbl_Prop> c_tbl_prop_map) {
    this.c_tbl_prop_map = c_tbl_prop_map;
  }

  public Integer getC_tbl_prop_id__customer_last_logged_usr_name() {
    return c_tbl_prop_id__customer_last_logged_usr_name;
  }

  public void setC_tbl_prop_id__customer_last_logged_usr_name(Integer c_tbl_prop_id__customer_last_logged_usr_name) {
    this.c_tbl_prop_id__customer_last_logged_usr_name = c_tbl_prop_id__customer_last_logged_usr_name;
  }

  public Integer getC_tbl_prop_id__is_customer_logged_in() {
    return c_tbl_prop_id__is_customer_logged_in;
  }

  public void setC_tbl_prop_id__is_customer_logged_in(Integer c_tbl_prop_id__is_customer_logged_in) {
    this.c_tbl_prop_id__is_customer_logged_in = c_tbl_prop_id__is_customer_logged_in;
  }

  public Integer getC_tbl_prop_id__customer_location_id() {
    return c_tbl_prop_id__customer_location_id;
  }

  public void setC_tbl_prop_id__customer_location_id(Integer c_tbl_prop_id__customer_location_id) {
    this.c_tbl_prop_id__customer_location_id = c_tbl_prop_id__customer_location_id;
  }

  public Integer getC_tbl_prop_id__customer_country_id() {
    return c_tbl_prop_id__customer_country_id;
  }

  public void setC_tbl_prop_id__customer_country_id(Integer c_tbl_prop_id__customer_country_id) {
    this.c_tbl_prop_id__customer_country_id = c_tbl_prop_id__customer_country_id;
  }

  public Integer getC_tbl_prop_id__customer_last_lat() {
    return c_tbl_prop_id__customer_last_lat;
  }

  public void setC_tbl_prop_id__customer_last_lat(Integer c_tbl_prop_id__customer_last_lat) {
    this.c_tbl_prop_id__customer_last_lat = c_tbl_prop_id__customer_last_lat;
  }

  public Integer getC_tbl_prop_id__customer_last_lon() {
    return c_tbl_prop_id__customer_last_lon;
  }

  public void setC_tbl_prop_id__customer_last_lon(Integer c_tbl_prop_id__customer_last_lon) {
    this.c_tbl_prop_id__customer_last_lon = c_tbl_prop_id__customer_last_lon;
  }

  public Integer getC_tbl_prop_id__customer_cur_id() {
    return c_tbl_prop_id__customer_cur_id;
  }

  public void setC_tbl_prop_id__customer_cur_id(Integer c_tbl_prop_id__customer_cur_id) {
    this.c_tbl_prop_id__customer_cur_id = c_tbl_prop_id__customer_cur_id;
  }

  public C_Tbl_Prop_Manager() {
    super(C_Tbl_Prop.class);
  }

  public String get_c_tbl_prop_map_key(String c_tbl_code_, String code_) {
    return c_tbl_code_ + "," + code_;
  }

  public C_Tbl_Prop get_c_tbl_prop_by_c_tbl_code_and_code(String c_tbl_code_, String code_, boolean create_if_not_exists) {
    Transaction tx = null;
    C_Tbl_Prop res = null;
    Session session_ = CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      tx = session_.beginTransaction();
      res = get_c_tbl_prop_by_c_tbl_code_and_code(session_, c_tbl_code_, code_, create_if_not_exists);
      hibernate_funcs.commitAndClose(session_);
    } catch (Exception e) {
      CustomLogger.error(e);
      if (tx != null) {
        hibernate_funcs.rollbackAndClose(session_);
      }
      throw e;
    }
    return res;
  }

  public C_Tbl_Prop get_c_tbl_prop_by_c_tbl_code_and_code(Session session_, String c_tbl_code_, String code_, boolean create_if_not_exists) {
    C_Tbl_Prop res = null;
    String key_ = get_c_tbl_prop_map_key(c_tbl_code_, code_);
    if (c_tbl_prop_map.containsKey(key_)) {
      return c_tbl_prop_map.get(key_);
    }
    Query q_ = session_.createQuery("from C_Tbl_Prop where is_deleted=false and c_tbl=:c_tbl_id_ and code=:code_");
    //q_.setCacheable(use_query_cache);
    Integer c_tbl_id_ = C_Tbl_Manager.getCI().get_rec_by_code(session_, c_tbl_code_).getC_tbl();
    q_.setInteger("c_tbl_id_", c_tbl_id_);
    q_.setString("code_", code_);
    List<C_Tbl_Prop> list_ = q_.list();
    if (list_.size() > 0) {
      res = list_.get(0);
    } else if (list_.size() == 0) {
      if (create_if_not_exists) {
        res = new C_Tbl_Prop();
        res.setC_tbl(c_tbl_id_);
        res.setCode(code_);
        res.setName("");
        res.setC_java_data_type(C_Java_Data_Type_Manager.c_java_data_type_id_String);
        res.setDefault_val("");
        session_.save(res);
      }
    }
    if (res != null) {
      c_tbl_prop_map.put(key_, res);
    }
    return res;
  }
  
}
