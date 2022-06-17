package lists.core.dbtables;

import gs.common.filters.My_Abstract_Filter_Bean;
import gs.common.lists.My_Abstract_List_Bean;
import model.db.SQL_Manager;

public class Abstract_List_Bean<T> extends My_Abstract_List_Bean<T> {

  public Abstract_List_Bean(String table_name_, My_Abstract_Filter_Bean filter_bean_) {
    super(SQL_Manager.getCI(), table_name_, filter_bean_);
  }

}
