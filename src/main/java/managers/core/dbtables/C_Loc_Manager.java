package managers.core.dbtables;

import additional_classes.core.comparators.C_Loc_Comparator;
import gs.common.additional_classes.GoogleGeocodeResult;
import gs.common.gis.gis_funcs;
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
import org.hibernate.type.StandardBasicTypes;
import others.core_custom_consts;

@ManagedBean
@ApplicationScoped
public class C_Loc_Manager extends Abstract_Controller_Manager<C_Loc> {

  private static C_Loc_Manager currentInstance = null;

  public static C_Loc_Manager getCI() {
    if (currentInstance == null) {
      currentInstance = new C_Loc_Manager();
    }
    return currentInstance;
  }

  public C_Loc_Manager() {
    super(C_Loc.class);
  }

  public C_Loc get_unique_rec(Session session_, Integer parent_id_, String name_, Integer exclude_id_) {
    Query q_ = session_.createQuery("from C_Loc where "
      + (parent_id_ == null ? "parent_id is null" : "parent_id=" + parent_id_) + " "
      + " and lower(trim(name))=:name_ "
      + (exclude_id_ == null ? "" : "and c_loc<>:exclude_id_") + " and is_deleted=false ");
    q_.setString("name_", name_.trim().toLowerCase());
    if (exclude_id_ != null) {
      q_.setInteger("exclude_id_", exclude_id_);
    }
    List<C_Loc> list_ = q_.list();
    if (!list_.isEmpty()) {
      return list_.get(0);
    }
    return null;
  }

  public String get_unique_violation_exception_string(Session session_, C_Loc rec_) {
    return "(" + (rec_.getParent_id_t_2(session_) == null ? "null" : rec_.getParent_id_t_2(session_).getName()) + ", " + rec_.getName() + ")";
  }

  public List<C_Loc> get_child_list_for_select(Integer parent_id_, String lang_) {
    List<C_Loc> res = null;
    Session session_ = model.core.dbutil.CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      session_.beginTransaction();
      res = get_child_list_for_select(session_, parent_id_, lang_);
      hibernate_funcs.commitAndClose(session_);
    } catch (Exception e) {
      CustomLogger.error(e);
      hibernate_funcs.rollbackAndClose(session_);
      throw e;
    }
    return res;
  }

  public List<C_Loc> get_child_list_for_select(Session session_, Integer parent_id_, String lang_) {
    Query q_ = session_.createQuery("from C_Loc t "
      + "where "
      + " t.is_deleted=false "
      + (parent_id_ == null ? "and t.parent_id is null " : "and t.parent_id=:parent_id_ ")
    //      + "order by t.name asc"
    );
    if (parent_id_ != null) {
      q_.setInteger("parent_id_", parent_id_);
    }
    List<C_Loc> res = q_.list();
    for (int i = 0; i < res.size(); i++) {
      res.get(i).getName_translation_3(session_, lang_);
    }

    res.sort(new C_Loc_Comparator());
    return res;
  }

  public List<C_Loc> get_child_list(Session session_, Integer parent_id_) {
    Query q_ = session_.createQuery("from C_Loc t "
      + "where "
      + "t.is_deleted=false "
      + (parent_id_ == null ? "and t.parent_id is null " : "and t.parent_id=:parent_id_ ")
    //      + "order by t.name asc"
    );
    if (parent_id_ != null) {
      q_.setInteger("parent_id_", parent_id_);
    }
    return q_.list();
  }

  public Boolean has_childs(Session session_, Integer parent_id_) {
    Query q_ = session_.createQuery("from C_Loc t "
      + "where "
      + "t.is_deleted=false "
      + (parent_id_ == null ? "and t.parent_id is null " : "and t.parent_id=:parent_id_ ")
    //      + "order by t.name asc"
    );
    if (parent_id_ != null) {
      q_.setInteger("parent_id_", parent_id_);
    }
    q_.setMaxResults(1);
    List<C_Loc> list_ = q_.list();
    return !list_.isEmpty();
  }

  public Integer get_child_rec_cnt(Session session_, Integer parent_id_) {
    Query q_ = session_.createQuery("select count(*) from C_Loc t "
      + "where "
      + "t.is_deleted=false "
      + (parent_id_ == null ? "and t.parent_id is null " : "and t.parent_id=:parent_id_ ")
    );
    if (parent_id_ != null) {
      q_.setInteger("parent_id_", parent_id_);
    }
    return ((Long) q_.list().get(0)).intValue();
  }

  public List<C_Loc> get_c_loc_list_for_select(String lang_) {
    List<C_Loc> res = null;
    Session session_ = model.core.dbutil.CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      session_.beginTransaction();
      res = get_c_loc_list_for_select(session_, lang_);
      hibernate_funcs.commitAndClose(session_);
    } catch (Exception e) {
      CustomLogger.error(e);
      hibernate_funcs.rollbackAndClose(session_);
      throw e;
    }
    return res;
  }

  public List<C_Loc> get_c_loc_list_for_select(Session session_, String lang_) {
    List<C_Loc> res = new ArrayList();
    add_c_loc_for_select(session_, null, res, lang_);
    return res;
  }

  public void add_c_loc_for_select(Session session_, Integer parent_id_, List<C_Loc> list_, String lang_) {
    List<C_Loc> child_list_ = C_Loc_Manager.getCI().get_child_list_for_select(session_, parent_id_, lang_);
    for (int i = 0; i < child_list_.size(); i++) {
      list_.add(child_list_.get(i));
      add_c_loc_for_select(session_, child_list_.get(i).getC_loc(), list_, lang_);
    }
  }

  public void update_c_loc_is_grp(Session session_, C_Loc c_loc_) {
    if (c_loc_ == null) {
      return;
    }
    Integer child_rec_cnt_ = C_Loc_Manager.getCI().get_child_rec_cnt(session_, c_loc_.getC_loc());
    if (child_rec_cnt_ > 0 && !c_loc_.getIs_grp()) {
      c_loc_.setIs_grp(true);
      session_.merge(c_loc_);
    } else if (child_rec_cnt_ == 0 && c_loc_.getIs_grp()) {
      c_loc_.setIs_grp(false);
      session_.merge(c_loc_);
    }
    update_c_loc_is_grp(session_, c_loc_.getParent_id_t_2(session_));
  }

  public C_Loc get_row_by_c_country_id(Integer c_country_id_) {
    C_Loc res;
    Session session_ = model.core.dbutil.CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      session_.beginTransaction();
      res = get_row_by_c_country_id(session_, c_country_id_);
      hibernate_funcs.commitAndClose(session_);
    } catch (Exception e) {
      CustomLogger.error(e);
      hibernate_funcs.rollbackAndClose(session_);
      throw e;
    }
    return res;
  }

  public C_Loc get_row_by_c_country_id(Session session_, Integer c_country_id_) {
    Query q_ = session_.createQuery("from C_Loc t where t.is_deleted=false and t.is_country=true and t.c_country=:c_country_id_ order by 1 asc");
    q_.setInteger("c_country_id_", c_country_id_);
    q_.setMaxResults(1);
    List<C_Loc> list_ = q_.list();
    if (list_.isEmpty()) {
      return null;
    } else {
      return list_.get(0);
    }
  }

  public List<C_Loc> get_row_list_wo_lat_lon() {
    List<C_Loc> res;
    Session session_ = model.core.dbutil.CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      session_.beginTransaction();
      res = get_row_list_wo_lat_lon(session_);
      hibernate_funcs.commitAndClose(session_);
    } catch (Exception e) {
      CustomLogger.error(e);
      hibernate_funcs.rollbackAndClose(session_);
      throw e;
    }
    return res;
  }

  public List<C_Loc> get_row_list_wo_lat_lon(Session session_) {
    Query q_ = session_.createQuery("from C_Loc t where t.is_deleted=false and (t.lat is null or t.lon is null or t.lat=0.0 or t.lon=0.0) order by 1 asc");
    return q_.list();
  }

  public void update_c_loc__lat_lon(C_Loc c_Loc) {
    Session session_ = model.core.dbutil.CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      session_.beginTransaction();
      update_c_loc__lat_lon(session_, c_Loc);
      hibernate_funcs.commitAndClose(session_);
    } catch (Exception e) {
      CustomLogger.error(e);
      hibernate_funcs.rollbackAndClose(session_);
      throw e;
    }
  }

  public void update_c_loc__lat_lon(Session session_, C_Loc c_Loc) {
    if (c_Loc == null) {
      return;
    }

    String address_ = c_Loc.getCalc_full_name_translation_2(session_, "ru", ",");
    GoogleGeocodeResult googleGeocodeResult = C_Geocoding_Manager.geocode(session_, address_);
    if (googleGeocodeResult != null) {
      c_Loc.setLat(googleGeocodeResult.getResponse_lat());
      c_Loc.setLon(googleGeocodeResult.getResponse_lon());
      c_Loc.setNe_lat(googleGeocodeResult.getResponse_view_ne_lat());
      c_Loc.setNe_lon(googleGeocodeResult.getResponse_view_ne_lon());
      c_Loc.setSw_lat(googleGeocodeResult.getResponse_view_sw_lat());
      c_Loc.setSw_lon(googleGeocodeResult.getResponse_view_sw_lon());
      C_Loc_Manager.getCI().update_rec(session_, c_Loc);
    }
  }

  public C_Loc get_nearest_c_loc(Session session_, Integer parent_c_loc_id_, Double lat_, Double lon_, Boolean is_only_country_) {
    C_Loc res = null;
    String sql_;
    sql_ = core_custom_consts.hierarchical_c_loc_sql_.replace("= :c_loc_id_", parent_c_loc_id_ == null ? "is null" : "= " + parent_c_loc_id_.toString());
    Query q_ = session_.createSQLQuery("select t.* from C_Loc t "
      + "where "
      + "  t.is_deleted=false "
      + "  and :lat_ between LEAST(t.ne_lat, t.sw_lat) and GREATEST (t.ne_lat, t.sw_lat) "
      + "  and :lon_ between LEAST(t.ne_lon, t.sw_lon) and GREATEST (t.ne_lon, t.sw_lon) "
      + (parent_c_loc_id_ != null ? "  and t.c_loc = any(array((" + sql_ + "))) " : " ")
      + "  and t.c_loc <> " + parent_c_loc_id_ + " "
      + (is_only_country_ ? "  and t.is_country=true " : " ")
    ).addEntity(C_Loc.class);
    q_.setDouble("lat_", lat_);
    q_.setDouble("lon_", lon_);
    List<C_Loc> list_ = q_.list();
    Double min_area_ = null;
    Double area_;
    C_Loc c_loc_;
    for (int i = 0; i < list_.size(); i++) {
      c_loc_ = list_.get(i);
      area_ = Math.abs((c_loc_.getSw_lat() - c_loc_.getNe_lat()) * (c_loc_.getNe_lon() - c_loc_.getSw_lon()));
      if (min_area_ == null) {
        min_area_ = area_;
        res = c_loc_;
      } else {
        if (area_ < min_area_) {
          min_area_ = area_;
          res = c_loc_;
        }
      }
    }

    if (res == null) {
      Double min_distance_ = null;
      Double distance_;
      q_ = session_.createSQLQuery("select t.* from C_Loc t "
        + "where "
        + "  t.is_deleted=false "
        + "  and t.c_loc = any(array((" + sql_ + "))) "
        + "  and t.c_loc <> " + parent_c_loc_id_
      ).addEntity(C_Loc.class);
      list_ = q_.list();
      for (int i = 0; i < list_.size(); i++) {
        c_loc_ = list_.get(i);
        distance_ = gis_funcs.distance_in_meters(lat_, lon_, c_loc_.getLat(), c_loc_.getLon());
        if (min_distance_ == null) {
          min_distance_ = distance_;
          res = c_loc_;
        } else {
          if (distance_ < min_distance_) {
            min_distance_ = distance_;
            res = c_loc_;
          }
        }
      }
    }

    return res;
  }

  public C_Loc get_new_row_with_default_vals(Session session_) {
    C_Loc res = (C_Loc) get_rec(session_, -1).clone();
    res.setC_loc(null);
    res.setName("");
    res.setIs_deleted(false);
    return res;
  }

  public void fill_has_childs(List<C_Loc> list_) {
    Session session_ = model.core.dbutil.CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      session_.beginTransaction();
      fill_has_childs(session_, list_);
      hibernate_funcs.commitAndClose(session_);
    } catch (Exception e) {
      CustomLogger.error(e);
      hibernate_funcs.rollbackAndClose(session_);
      throw e;
    }
  }

  public void fill_has_childs(Session session_, List<C_Loc> list_) {
    for (int i = 0; i < list_.size(); i++) {
      list_.get(i).getHas_childs_2(session_);
    }

  }

  public C_Country get_c_country(Session session_, C_Loc c_loc_) {
    C_Country res = null;
    C_Loc tmp_c_loc_ = c_loc_;
    while (tmp_c_loc_ != null) {
      if (tmp_c_loc_.getIs_country() && tmp_c_loc_.getC_country() != null) {
        res = tmp_c_loc_.getC_country_t_2(session_);
        break;
      }
      tmp_c_loc_ = tmp_c_loc_.getParent_id_t_2(session_);
    }
    return res;
  }
}
