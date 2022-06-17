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
public class C_Loc_List_Bean extends Abstract_List_Bean<C_Loc> {

  public C_Loc_List_Bean() {
    super("C_Loc", (C_Loc_Filter_Bean) jsf_funcs.findBean("c_Loc_Filter_Bean"));
  }

  public LazyDataModel<C_Loc> getConverted_rec_list() {
    return getRec_list();
  }

  public List<C_Loc> getConverted_rec_array_list() {
    return getRec_array_list();
  }

  public C_Loc_Filter_Bean getFilter_bean_wrapped() {
    return (C_Loc_Filter_Bean) getFilter_bean();
  }

  @Override
  protected void add_sql_where_conditions(ArrayList<SQL_Where_Condition> sql_where_condition_arr_) {
    sql_where_condition_arr_.add(new SQL_Where_Condition("t.is_deleted=false"));
    C_Loc filter_rec_ = getFilter_bean_wrapped().getFilter_entity_wrapped();
    if (filter_rec_.getName() != null && !filter_rec_.getName().trim().isEmpty()) {
      sql_where_condition_arr_.add(new SQL_Where_Condition("lower(trim(t.name)) like '%" + filter_rec_.getName().trim().toLowerCase() + "%'"));
    }
    if (filter_rec_.getParent_id_t()!= null) {
      sql_where_condition_arr_.add(new SQL_Where_Condition("t.parent_id=" + filter_rec_.getParent_id_t().getC_loc()));
    }
  }

  @Override
  protected Object rec_list_getRowData(String rowKey) {
    List<C_Loc> list_ = (List<C_Loc>) getConverted_rec_list().getWrappedData();
    Integer value = Integer.valueOf(rowKey);
    for (C_Loc rec : list_) {
      if (rec.getC_loc().equals(value)) {
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
  protected void deleteRec(Session session_, C_Loc rec_) {
    rec_.setIs_deleted(true);
    session_.merge(rec_);
  }  
}
