package filters.core.dbtables;

import gs.common.filters.My_Abstract_Filter_Bean;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import others.CustomLogger;

public class Abstract_Filter_Bean<T> extends My_Abstract_Filter_Bean<T> {

  public Abstract_Filter_Bean(Class<T> filter_entity_class_, String sort_field_name_, String sort_field_order_) {
    super(filter_entity_class_, sort_field_name_, sort_field_order_);
  }

  public Abstract_Filter_Bean(String sort_field_name_, String sort_field_order_) {
    super(sort_field_name_, sort_field_order_);
  }

  @Override
  protected void error(Exception e) {
    CustomLogger.error(e);
  }

}
