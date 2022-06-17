package lists.core.dbtables;

import filters.core.dbtables.*;
import gs.common.model.db.*;
import model.core.dbtables.*;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.model.LazyDataModel;
import gs.common.jsf.jsf_funcs;
import java.util.*;
import model.core.dbutil.CoreSessionFactoryUtil;
import org.hibernate.Session;
import others.CustomLogger;

@ManagedBean
@SessionScoped
public class C_Cur_Course_List_Bean extends Abstract_List_Bean<C_Cur_Course> {

  public C_Cur_Course_List_Bean() {
    super("C_Cur_Course", (C_Cur_Course_Filter_Bean) jsf_funcs.findBean("c_Cur_Course_Filter_Bean"));
  }

  public LazyDataModel<C_Cur_Course> getConverted_rec_list() {
    return getRec_list();
  }

  public List<C_Cur_Course> getConverted_rec_array_list() {
    return getRec_array_list();
  }
  
  public C_Cur_Course_Filter_Bean getFilter_bean_wrapped() {
    return (C_Cur_Course_Filter_Bean) getFilter_bean();
  }

  @Override
  protected void add_sql_where_conditions(ArrayList<SQL_Where_Condition> sql_where_condition_arr_) {
    sql_where_condition_arr_.add(new SQL_Where_Condition("t.is_deleted=false"));
  }

    @Override
  protected Object rec_list_getRowData(String rowKey) {
    List<C_Cur_Course> list_ = (List<C_Cur_Course>) getConverted_rec_list().getWrappedData();
    Integer value = Integer.valueOf(rowKey);
    for (C_Cur_Course rec : list_) {
      if (rec.getC_cur_course().equals(value)) {
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
  protected void deleteRec(Session session_, C_Cur_Course rec_) {
    rec_.setIs_deleted(true);
    session_.merge(rec_);
  }
}
