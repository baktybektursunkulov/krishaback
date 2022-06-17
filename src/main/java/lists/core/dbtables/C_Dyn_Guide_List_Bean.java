package lists.core.dbtables;

import filters.core.dbtables.*;
import model.core.dbtables.*;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.model.LazyDataModel;
import gs.common.jsf.jsf_funcs;
import gs.common.model.db.*;
import java.util.*;
import model.core.dbutil.CoreSessionFactoryUtil;
import org.hibernate.Session;
import others.CustomLogger;

@ManagedBean
@SessionScoped
public class C_Dyn_Guide_List_Bean extends Abstract_List_Bean<C_Dyn_Guide> {

  public C_Dyn_Guide_List_Bean() {
    super("C_Dyn_Guide", (C_Dyn_Guide_Filter_Bean) jsf_funcs.findBean("c_Dyn_Guide_Filter_Bean"));
  }

  public LazyDataModel<C_Dyn_Guide> getConverted_rec_list() {
    return getRec_list();
  }

  public List<C_Dyn_Guide> getConverted_rec_array_list() {
    return getRec_array_list();
  }
  
  public C_Dyn_Guide_Filter_Bean getFilter_bean_wrapped() {
    return (C_Dyn_Guide_Filter_Bean) getFilter_bean();
  }

  @Override
  protected void add_sql_where_conditions(ArrayList<SQL_Where_Condition> sql_where_condition_arr_) {
    sql_where_condition_arr_.add(new SQL_Where_Condition("t.is_deleted=false"));
    C_Dyn_Guide filter_rec_ = getFilter_bean_wrapped().getFilter_entity_wrapped();
    if (filter_rec_.getC_proj()!= null) {
      sql_where_condition_arr_.add(new SQL_Where_Condition("t.c_proj=" + filter_rec_.getC_proj().toString()));
    }
    if (filter_rec_.getCode() != null && !filter_rec_.getCode().trim().isEmpty()) {
      sql_where_condition_arr_.add(new SQL_Where_Condition("lower(trim(t.code)) like '%" + filter_rec_.getCode().trim().toLowerCase() + "%'"));
    }
    if (filter_rec_.getName() != null && !filter_rec_.getName().trim().isEmpty()) {
      sql_where_condition_arr_.add(new SQL_Where_Condition("lower(trim(t.name)) like '%" + filter_rec_.getName().trim().toLowerCase() + "%'"));
    }
  }

  
  @Override
  protected Object rec_list_getRowData(String rowKey) {
    List<C_Dyn_Guide> list_ = (List<C_Dyn_Guide>) getConverted_rec_list().getWrappedData();
    Integer value = Integer.valueOf(rowKey);
    for (C_Dyn_Guide rec : list_) {
      if (rec.getC_dyn_guide().equals(value)) {
        return rec;
      }
    }
    return null;
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
  protected void deleteRec(Session session_, C_Dyn_Guide rec_) {
    rec_.setIs_deleted(true);
    session_.merge(rec_);
  }   
}
