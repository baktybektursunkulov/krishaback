package managers.core.dbtables;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import model.core.dbtables.*;
import gs.common.managers.My_Abstract_Controller_Manager;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

@ManagedBean
@ApplicationScoped
public class I_Html_Txt_Manager extends Abstract_Controller_Manager<I_Html_Txt> {

  private static I_Html_Txt_Manager currentInstance = null;

  public static I_Html_Txt_Manager getCI() {
    if (currentInstance == null) {
      currentInstance = new I_Html_Txt_Manager();
    }
    return currentInstance;
  }

  public I_Html_Txt_Manager() {
    super(I_Html_Txt.class);
  }

  public I_Html_Txt get_row(Session session_, Integer c_proj_id_, String code_) {
    Query q_ = session_.createQuery("from I_Html_Txt t where t.is_deleted=false and t.c_proj=:c_proj_id_ and t.code=:code_ order by 1 asc");
    q_.setInteger("c_proj_id_", c_proj_id_);
    q_.setString("code_", code_);
    List<I_Html_Txt> list_ = q_.list();
    if (!list_.isEmpty()) {
      return list_.get(0);
    }
    return null;
  }

  public I_Html_Txt get_suitable_row(Session session_, Integer c_proj_id_, String code_) {
    I_Html_Txt res = get_row(session_, c_proj_id_, code_);
    if (res == null) {
      res = get_row(session_, C_Proj_Manager.const_c_proj_id_common, code_);
    }
    return res;
  }

}
