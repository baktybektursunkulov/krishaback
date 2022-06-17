package controllers.core.dbtables;

import model.core.dbutil.CoreSessionFactoryUtil;
import java.io.Serializable; import gs.common.model.db.Abstract_Entity;
import org.hibernate.Session;import gs.common.hibernate_funcs;
import org.hibernate.Transaction;

public class Common_Controller implements Serializable, Cloneable {

  public Common_Controller() {

  }

  public static void insertRecAction(Object object_) throws Exception {
    Session session_ = CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    Transaction tx_ = null;
    try {
      tx_ = session_.beginTransaction();

      session_.save(object_);
      //Integer new_rec_id_ = v3_equip_type.getV3_equip_type();
      //Object_His_Manager.insert_object_his(session_, this.getClass().getSimpleName().toLowerCase(), String.valueOf(new_rec_id_), "insert", new_rec_.toString());

      hibernate_funcs.commitAndClose(session_);
    } catch (Exception e) {
      if (tx_ != null) {
        hibernate_funcs.rollbackAndClose(session_);
      }
      throw e;
    }
  }

  public static void updateRecAction(Object object_) throws Exception {
    Session session_ = CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    Transaction tx_ = null;
    try {
      tx_ = session_.beginTransaction();

      //V3_Equip_Type old_rec_ = (V3_Equip_Type) session_.load(V3_Equip_Type.class, v3_equip_type.getV3_equip_type());
      //V3_Equip_Type clone_old_rec_ = old_rec_.clone();
      //V3_Equip_Type rec_ = (V3_Equip_Type) session_.load(V3_Equip_Type.class, v3_equip_type.getV3_equip_type());
      //rec_.setModel(v3_equip_type.getModel());
      session_.update(object_);
      hibernate_funcs.commitAndClose(session_);
      /*
       if (!rec_.equals(clone_old_rec_)) {
       session_.update(rec_);
       //Object_His_Manager.insert_object_his(session_, this.getClass().getSimpleName().toLowerCase(), String.valueOf(rec_.getV3_equip_type()), "update", rec_.toString());
       hibernate_funcs.commitAndClose(session_);
       } else {
       hibernate_funcs.rollbackAndClose(session_);
       }
       */

    } catch (Exception e) {
      if (tx_ != null) {
        hibernate_funcs.rollbackAndClose(session_);
      }
      throw e;
    }
  }

  public static void deleteRecAction(Object object_) throws Exception {
    Session session_ = CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    Transaction tx_ = null;
    try {
      tx_ = session_.beginTransaction();

      //V3_Equip_Type rec_ = (V3_Equip_Type) session_.load(V3_Equip_Type.class, v3_equip_type.getV3_equip_type());
      session_.delete(object_);
      hibernate_funcs.commitAndClose(session_);
    } catch (Exception e) {
      if (tx_ != null) {
        hibernate_funcs.rollbackAndClose(session_);
      }
      throw e;
    }
  }

  public static Object getObject(Object object_, Serializable object_id_) {
    Object res = null;
    Session session_ = CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    Transaction tx_ = null;
    try {
      tx_ = session_.beginTransaction();

      //V3_Equip_Type rec_ = (V3_Equip_Type) session_.load(V3_Equip_Type.class, v3_equip_type.getV3_equip_type());
      res = session_.load(object_.getClass(), object_id_);
      hibernate_funcs.commitAndClose(session_);
      return res;
    } catch (Exception e) {
      if (tx_ != null) {
        hibernate_funcs.rollbackAndClose(session_);
      }
      throw e;
    }
  }

}
