package managers.core.dbtables;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import model.core.dbtables.*;
import gs.common.managers.My_Abstract_Controller_Manager;
import gs.common.model.db.*;
import java.util.List;
import model.core.dbutil.CoreSessionFactoryUtil;
import org.hibernate.*;
import others.CustomLogger;
import gs.common.hibernate_funcs;
import java.util.*;
import java.text.*;

@ManagedBean
@ApplicationScoped
public class Dc_Doc_Cont_Row_Manager extends Abstract_Controller_Manager<Dc_Doc_Cont_Row> {

  private static Dc_Doc_Cont_Row_Manager currentInstance = null;

  public static Dc_Doc_Cont_Row_Manager getCI() {
    if (currentInstance == null) {
      currentInstance = new Dc_Doc_Cont_Row_Manager();
    }
    return currentInstance;
  }

  public Dc_Doc_Cont_Row_Manager() {
    super(Dc_Doc_Cont_Row.class);
  }

  public List<Dc_Doc_Cont_Row> get_dc_doc_cont_row_list_sorted_by_tree(Integer dc_doc_cont_id_, Boolean is_only_active_) {
    List<Dc_Doc_Cont_Row> res = new ArrayList<>();
    Transaction tx_ = null;
    Session session_ = model.core.dbutil.CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      tx_ = session_.beginTransaction();
      res = get_dc_doc_cont_row_list_sorted_by_tree(session_, dc_doc_cont_id_, is_only_active_);
      hibernate_funcs.commitAndClose(session_);
    } catch (Exception e) {
      CustomLogger.error(e);
      if (tx_ != null) {
        hibernate_funcs.rollbackAndClose(session_);
      }
      throw e;
    }
    return res;
  }

  public List<Dc_Doc_Cont_Row> get_dc_doc_cont_row_list_sorted_by_tree(Session session_, Integer dc_doc_cont_id_, Boolean is_only_active_) {
    List<Dc_Doc_Cont_Row> res = new ArrayList<>();
    addNodeToList(session_, res, dc_doc_cont_id_, null, is_only_active_);
    return res;
  }

  public void addNodeToList(Session session_, List<Dc_Doc_Cont_Row> list_, Integer dc_doc_cont_id_, Integer parent_id_, Boolean is_only_active_) {
    List<Dc_Doc_Cont_Row> dc_doc_cont_row_list_ = Dc_Doc_Cont_Row_Manager.getCI().get_dc_doc_cont_row_list(session_, dc_doc_cont_id_, parent_id_, is_only_active_);
    Dc_Doc_Cont_Row dc_doc_cont_row_;
    for (int i = 0; i < dc_doc_cont_row_list_.size(); i++) {
      dc_doc_cont_row_ = dc_doc_cont_row_list_.get(i);
      list_.add(dc_doc_cont_row_);
      addNodeToList(session_, list_, dc_doc_cont_id_, dc_doc_cont_row_.getDc_doc_cont_row(), is_only_active_);
    }
  }

  public List<Dc_Doc_Cont_Row> get_dc_doc_cont_row_list_2(Integer dc_doc_cont_id_, Integer parent_id_, Boolean is_only_active_) {
    List<Dc_Doc_Cont_Row> res = null;

    List<SQL_Where_Condition> sql_where_condition_list_ = new ArrayList<>();
    List<SQL_Order_Condition> sql_order_condition_list_ = new ArrayList<>();
    sql_where_condition_list_.add(new SQL_Where_Condition("is_deleted=false"));
    sql_where_condition_list_.add(new SQL_Where_Condition("dc_doc_cont=" + dc_doc_cont_id_.toString()));
    sql_where_condition_list_.add(new SQL_Where_Condition("parent_id=" + (parent_id_ == null ? "null" : parent_id_.toString())));
    if (is_only_active_) {
      sql_where_condition_list_.add(new SQL_Where_Condition("is_active=true"));
    }
    sql_order_condition_list_.add(new SQL_Order_Condition("order_num", "asc"));
    res = get_rec_list_4_c(sql_where_condition_list_, sql_order_condition_list_, true);

    return res;
  }

  public List<Dc_Doc_Cont_Row> get_dc_doc_cont_row_list(Session session_, Integer dc_doc_cont_id_, Integer parent_id_, Boolean is_only_active_) {
    List<Dc_Doc_Cont_Row> res = null;

    List<SQL_Where_Condition> sql_where_condition_list_ = new ArrayList<>();
    List<SQL_Order_Condition> sql_order_condition_list_ = new ArrayList<>();
    sql_where_condition_list_.add(new SQL_Where_Condition("is_deleted=false"));
    sql_where_condition_list_.add(new SQL_Where_Condition("dc_doc_cont=" + dc_doc_cont_id_.toString()));
    sql_where_condition_list_.add(new SQL_Where_Condition("parent_id=" + (parent_id_ == null ? "null" : parent_id_.toString())));
    if (is_only_active_) {
      sql_where_condition_list_.add(new SQL_Where_Condition("is_active=true"));
    }
    sql_order_condition_list_.add(new SQL_Order_Condition("order_num", "asc"));
    res = get_rec_list_4_1_c(session_, sql_where_condition_list_, sql_order_condition_list_, true);

    return res;
  }

  public boolean is_exist_childs(Integer dc_doc_cont_id_, Integer parent_id_, Boolean is_only_active_) {
    return get_dc_doc_cont_row_list_2(dc_doc_cont_id_, parent_id_, is_only_active_).size() > 0;
  }

  public boolean is_exist_childs(Session session_, Integer dc_doc_cont_id_, Integer parent_id_, Boolean is_only_active_) {
    return get_dc_doc_cont_row_list(session_, dc_doc_cont_id_, parent_id_, is_only_active_).size() > 0;
  }

  public Integer get_max_order_num(Session session_, Integer dc_doc_cont_id_, Integer parent_id_) {
    List<Dc_Doc_Cont_Row> list_ = null;

    Query q_ = session_.createQuery("from Dc_Doc_Cont_Row where is_deleted=false and dc_doc_cont=:dc_doc_cont_id_ and parent_id=" + parent_id_ + " order by order_num desc");
    q_.setInteger("dc_doc_cont_id_", dc_doc_cont_id_);
  //q_.setCacheable(use_query_cache);
    q_.setMaxResults(1);
    list_ = q_.list();
    if (list_.size() > 0) {
      return list_.get(0).getOrder_num();
    }

    return 0;
  }

  public Dc_Doc_Cont_Row get_prev_rec_by_parent_id(Dc_Doc_Cont_Row dc_doc_cont_row_) {
    Dc_Doc_Cont_Row res = null;
    Transaction tx_ = null;
    Session session_ = model.core.dbutil.CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      tx_ = session_.beginTransaction();
      res = get_prev_rec_by_parent_id(session_, dc_doc_cont_row_);
      hibernate_funcs.commitAndClose(session_);
    } catch (Exception e) {
      CustomLogger.error(e);
      if (tx_ != null) {
        hibernate_funcs.rollbackAndClose(session_);
      }
      throw e;
    }
    return res;
  }

  public Dc_Doc_Cont_Row get_prev_rec_by_parent_id(Session session_, Dc_Doc_Cont_Row dc_doc_cont_row_) {
    List<Dc_Doc_Cont_Row> list_ = null;

    Query q_ = session_.createQuery("from Dc_Doc_Cont_Row where is_deleted=false and dc_doc_cont=:dc_doc_cont_id_ and parent_id=" + (dc_doc_cont_row_.getParent_id() == null ? null : dc_doc_cont_row_.getParent_id_t_2(session_).getDc_doc_cont_row()) + ""
      + " and order_num < " + dc_doc_cont_row_.getOrder_num() + " order by order_num desc");
    q_.setInteger("dc_doc_cont_id_", dc_doc_cont_row_.getDc_doc_cont());
  //q_.setCacheable(use_query_cache);
    q_.setMaxResults(1);
    list_ = q_.list();
    if (list_.size() > 0) {
      return list_.get(0);
    }

    return null;
  }

  public Dc_Doc_Cont_Row get_next_rec_by_parent_id(Dc_Doc_Cont_Row dc_doc_cont_row_) {
    Dc_Doc_Cont_Row res = null;
    Transaction tx_ = null;
    Session session_ = model.core.dbutil.CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      tx_ = session_.beginTransaction();
      res = get_next_rec_by_parent_id(session_, dc_doc_cont_row_);
      hibernate_funcs.commitAndClose(session_);
    } catch (Exception e) {
      CustomLogger.error(e);
      if (tx_ != null) {
        hibernate_funcs.rollbackAndClose(session_);
      }
      throw e;
    }
    return res;
  }

  public Dc_Doc_Cont_Row get_next_rec_by_parent_id(Session session_, Dc_Doc_Cont_Row dc_doc_cont_row_) {
    List<Dc_Doc_Cont_Row> list_ = null;

    Query q_ = session_.createQuery("from Dc_Doc_Cont_Row where is_deleted=false and dc_doc_cont=:dc_doc_cont_id_ and parent_id=" + (dc_doc_cont_row_.getParent_id() == null ? null : dc_doc_cont_row_.getParent_id_t_2(session_).getDc_doc_cont_row()) + ""
      + " and order_num > " + dc_doc_cont_row_.getOrder_num() + " order by order_num asc");
    q_.setInteger("dc_doc_cont_id_", dc_doc_cont_row_.getDc_doc_cont());
  //q_.setCacheable(use_query_cache);
    q_.setMaxResults(1);
    list_ = q_.list();
    if (list_.size() > 0) {
      return list_.get(0);
    }

    return null;
  }

  public void inc_order_num(Session session_, Dc_Doc_Cont_Row dc_doc_cont_row_) {
    Query q_ = session_.createQuery("update Dc_Doc_Cont_Row set order_num=(order_num+1) * -1 where is_deleted=false and dc_doc_cont=:dc_doc_cont_id_ and parent_id=" + (dc_doc_cont_row_.getParent_id() == null ? null : dc_doc_cont_row_.getParent_id_t_2(session_).getDc_doc_cont_row()) + ""
      + " and order_num >= " + dc_doc_cont_row_.getOrder_num());
    q_.setInteger("dc_doc_cont_id_", dc_doc_cont_row_.getDc_doc_cont());
    q_.executeUpdate();

    q_ = session_.createQuery("update Dc_Doc_Cont_Row set order_num=order_num * -1 where is_deleted=false and dc_doc_cont=:dc_doc_cont_id_ and parent_id=" + (dc_doc_cont_row_.getParent_id() == null ? null : dc_doc_cont_row_.getParent_id_t_2(session_).getDc_doc_cont_row()) + ""
      + " and order_num < 0");
    q_.setInteger("dc_doc_cont_id_", dc_doc_cont_row_.getDc_doc_cont());
    q_.executeUpdate();
  }  
}
