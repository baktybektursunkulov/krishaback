package lists.core.dbtables;

import filters.core.dbtables.*;
import model.core.dbtables.*;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.model.LazyDataModel;
import gs.common.jsf.jsf_funcs;
import gs.common.model.db.*;
import java.util.*;
import org.hibernate.Session;
import others.CustomLogger;
import gs.common.other_funcs;
import model.core.dbutil.*;

@ManagedBean
@SessionScoped
public class C_Site_Page_List_Bean extends Abstract_List_Bean<C_Site_Page> {

  public C_Site_Page_List_Bean() {
    super("C_Site_Page", (C_Site_Page_Filter_Bean) jsf_funcs.findBean(C_Site_Page_Filter_Bean.class));
  }

  public static C_Site_Page_List_Bean getCurrentBean() {
    return jsf_funcs.findBean(C_Site_Page_List_Bean.class);
  }

  public LazyDataModel<C_Site_Page> getConverted_rec_list() {
    return getRec_list();
  }

  public List<C_Site_Page> getConverted_rec_array_list() {
    return getRec_array_list();
  }
  
  public C_Site_Page_Filter_Bean getFilter_bean_wrapped() {
    return (C_Site_Page_Filter_Bean) getFilter_bean();
  }

  @Override
  protected void add_sql_where_conditions(ArrayList<SQL_Where_Condition> sql_where_condition_arr_) {
    sql_where_condition_arr_.add(new SQL_Where_Condition("t.is_deleted=false"));
  }

  
  @Override
  protected Object rec_list_getRowData(String rowKey) {
    List<C_Site_Page> list_ = (List<C_Site_Page>) getConverted_rec_list().getWrappedData();
    Integer value = Integer.valueOf(rowKey);
    for (C_Site_Page rec : list_) {
      if (rec.getC_site_page().equals(value)) {
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
  protected void deleteRec(Session session_, C_Site_Page rec_) {
    rec_.setIs_deleted(true);
    session_.merge(rec_);
  }
  
}
