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
public class I_Plain_Txt_Manager extends Abstract_Controller_Manager<I_Plain_Txt> {

  private static I_Plain_Txt_Manager currentInstance = null;

  public static I_Plain_Txt_Manager getCI() {
    if (currentInstance == null) {
      currentInstance = new I_Plain_Txt_Manager();
    }
    return currentInstance;
  }

  public I_Plain_Txt_Manager() {
    super(I_Plain_Txt.class);
  }

  public I_Plain_Txt get_row(Session session_, Integer c_proj_id_, String code_) {
    Query q_ = session_.createQuery("from I_Plain_Txt t where t.is_deleted=false and t.c_proj=:c_proj_id_ and t.code=:code_ order by 1 asc");
    q_.setInteger("c_proj_id_", c_proj_id_);
    q_.setString("code_", code_);
    List<I_Plain_Txt> list_ = q_.list();
    if (!list_.isEmpty()) {
      return list_.get(0);
    }
    return null;
  }
}
