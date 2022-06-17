package controllers.core.dbtables;

import beans.CUsrBean;
import gs.common.controllers.My_Abstract_Controller;
import gs.common.model.db.Abstract_Entity;
import model.core.dbutil.CoreSessionFactoryUtil;
import org.hibernate.Session;
import gs.common.hibernate_funcs;
import managers.core.dbtables.C_Tbl_Oper_Manager;
import model.core.dbtables.C_Usr;
import others.CustomLogger;

public class Abstract_Controller<T> extends My_Abstract_Controller<T> {

  public Abstract_Controller(Class<T> abstract_entity_class_, String crud_outcome_, Boolean is_insert_history_) {
    super(abstract_entity_class_, crud_outcome_, is_insert_history_);
  }

  public Abstract_Controller(Class<T> abstract_entity_class_, String crud_outcome_) {
    super(abstract_entity_class_, crud_outcome_);
  }

  @Override
  protected void error(Exception e) {
    CustomLogger.error(e);
  }

  @Override
  protected Session getOpenedSession() {
    return CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
  }

  @Override
  protected Session getCurrentSession() {
    return CoreSessionFactoryUtil.getSessionFactoryUtilInstance().getCurrentSession();
  }

  @Override
  protected void insert_object_his(Session session_, String object_type_id_, String object_id_, String object_oper_type_id_, String his_text_) {
    C_Tbl_Oper_Manager.insert_object_his(session_, getAbstract_entity_class().getSimpleName().toLowerCase(), ((Abstract_Entity) getAbstract_entity()).getEntity_id(), "insert", getAbstract_entity().toString(),
      getCUsr());
  }

  protected C_Usr getCUsr() {
    return CUsrBean.getCurrentBean().getLoggedCUsr();
  }

}
