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
public class C_Tbl_Rec_Rating_His_Manager extends Abstract_Controller_Manager<C_Tbl_Rec_Rating_His> {

  private static C_Tbl_Rec_Rating_His_Manager currentInstance = null;

  public static C_Tbl_Rec_Rating_His_Manager getCI() {
    if (currentInstance == null) {
      currentInstance = new C_Tbl_Rec_Rating_His_Manager();
    }
    return currentInstance;
  }

  public C_Tbl_Rec_Rating_His_Manager() {
    super(C_Tbl_Rec_Rating_His.class);
  }

  public C_Tbl_Rec_Rating_His ins_row(Session session_, Integer c_tbl_id_, Long rec_id_, Integer c_usr_review_kind_id_, Integer month_cnt_, Double rating_) {
    C_Tbl_Rec_Rating_His new_rec_ = new C_Tbl_Rec_Rating_His();
    new_rec_.setC_tbl(c_tbl_id_);
    new_rec_.setRec_id(rec_id_);
    new_rec_.setC_usr_review_kind(c_usr_review_kind_id_);
    new_rec_.setMonth_cnt(month_cnt_);
    new_rec_.setRating(rating_);
    new_rec_.setIs_deleted(false);
    session_.save(new_rec_);
    return new_rec_;
  }

  public C_Tbl_Rec_Rating_His get_row(Session session_, Integer c_tbl_id_, Long rec_id_, Integer c_usr_review_kind_id_, Integer month_cnt_) {
    Query q_ = session_.createQuery("from C_Tbl_Rec_Rating_His t "
      + "where t.is_deleted=false and t.c_tbl=:c_tbl_id_ and t.rec_id=:rec_id_ and t.c_usr_review_kind=:c_usr_review_kind_id_ and t.month_cnt=:month_cnt_ order by 1 asc");
    q_.setInteger("c_tbl_id_", c_tbl_id_);
    q_.setLong("rec_id_", rec_id_);
    q_.setInteger("c_usr_review_kind_id_", c_usr_review_kind_id_);
    q_.setInteger("month_cnt_", month_cnt_);
    List<C_Tbl_Rec_Rating_His> list_ = q_.list();
    if (list_.isEmpty()) {
      return ins_row(session_, c_tbl_id_, rec_id_, c_usr_review_kind_id_, month_cnt_, null);
    } else {
      return list_.get(0);
    }
  }
  
}
