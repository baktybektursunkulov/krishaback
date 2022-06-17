package managers.core.dbtables;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import model.core.dbtables.*;
import gs.common.managers.My_Abstract_Controller_Manager;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

@ManagedBean
@ApplicationScoped
public class C_Cur_Course_Manager extends Abstract_Controller_Manager<C_Cur_Course> {

  private static C_Cur_Course_Manager currentInstance = null;

  public static C_Cur_Course_Manager getCI() {
    if (currentInstance == null) {
      currentInstance = new C_Cur_Course_Manager();
    }
    return currentInstance;
  }

  public C_Cur_Course_Manager() {
    super(C_Cur_Course.class);
  }

  public Double get_course(Session session_, Integer c_cur_id_, Date course_dt_) {
    Double res;
    Query q_ = session_.createQuery("from C_Cur_Course t where t.is_deleted=false and t.c_cur=:c_cur_id_ and t.course_dt<=:course_dt_ order by t.course_dt desc");
    q_.setInteger("c_cur_id_", c_cur_id_);
    q_.setTimestamp("course_dt_", course_dt_);
    q_.setMaxResults(1);
    List<C_Cur_Course> list_ = q_.list();
    if (list_.isEmpty()) {
      res = null;
    } else {
      res = list_.get(0).getCourse();
    }
    return res;  
  }
  
  public Double get_cross_course(Session session_, Date course_dt_, Integer from_c_cur_id_, Integer to_c_cur_id_) {
    Double from_course_ = get_course(session_, from_c_cur_id_, course_dt_);
    Double to_course_ = get_course(session_, to_c_cur_id_, course_dt_);
    return from_course_ / to_course_;
  }
}
