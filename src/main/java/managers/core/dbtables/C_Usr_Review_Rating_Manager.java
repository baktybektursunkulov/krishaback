package managers.core.dbtables;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import model.core.dbtables.*;
import gs.common.managers.My_Abstract_Controller_Manager;
import gs.common.model.db.*;
import org.hibernate.*;
import others.CustomLogger;
import gs.common.hibernate_funcs;
import java.util.*;
import java.text.*;

@ManagedBean
@ApplicationScoped
public class C_Usr_Review_Rating_Manager extends Abstract_Controller_Manager<C_Usr_Review_Rating> {

  private static C_Usr_Review_Rating_Manager currentInstance = null;

  public static C_Usr_Review_Rating_Manager getCI() {
    if (currentInstance == null) {
      currentInstance = new C_Usr_Review_Rating_Manager();
    }
    return currentInstance;
  }

  public C_Usr_Review_Rating_Manager() {
    super(C_Usr_Review_Rating.class);
  }

  public C_Usr_Review_Rating get_row(Session session_, Integer c_usr_review_id_, Integer c_usr_review_kind_id_) {
    Query q_ = session_.createQuery("from C_Usr_Review_Rating t where t.is_deleted=false and t.c_usr_review=:c_usr_review_id_ and t.c_usr_review_kind=:c_usr_review_kind_id_ order by 1 asc");
    q_.setInteger("c_usr_review_id_", c_usr_review_id_);
    q_.setInteger("c_usr_review_kind_id_", c_usr_review_kind_id_);
    q_.setMaxResults(1);
    List<C_Usr_Review_Rating> list_ = q_.list();
    if (list_.isEmpty()) {
      return null;
    } else {
      return list_.get(0);
    }
  }

  public Integer ins_row(Session session_, Integer c_usr_review_id_, Integer c_usr_review_kind_id_, Integer rating_) {
    C_Usr_Review_Rating res = new C_Usr_Review_Rating();
    res.setC_usr_review(c_usr_review_id_);
    res.setC_usr_review_kind(c_usr_review_kind_id_);
    res.setRating(rating_);
    res.setIs_deleted(false);
    session_.save(res);
    return res.getC_usr_review_rating();
  }
}
