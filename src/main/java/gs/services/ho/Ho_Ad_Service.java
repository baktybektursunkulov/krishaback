package gs.services.ho;

import gs.payload.response.horesponse.FiltrationFieldsResponse;
import gs.repositories.ho.dbtables.Ho_Ad_Repository;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import model.ho.dbtables.Ho_Ad;
import org.hibernate.Session;
import org.hibernate.query.Query;

@Service
public class Ho_Ad_Service {

  @Autowired
  private Ho_Ad_Repository repository;

  public Ho_Ad saveOrUpdate(Ho_Ad ho_ad) {
    repository.save(ho_ad);
    return ho_ad;
  }

  public List<Integer> find_all() {
    return repository.find_all();
  }

  public void update(Ho_Ad ho_ad, int id) {
    repository.save(ho_ad);
  }

  public List<Ho_Ad> find(Integer id) {
    return repository.find(id);
  }

  public List<Ho_Ad> pagination(Integer id, Integer limit, Integer offset) {
    return repository.pagination(id, limit, offset);
  }

  public Ho_Ad find_by_id(Integer id) {
    return repository.find_by_id(id);
  }

  public Integer countofcat(Integer id) {
    return repository.countofcat(id);
  }

  public Integer filters_cnt(Session session_,Integer id, List<Integer> ho_build_type,List<Integer> room_cnt_arr,Boolean not_last_floor,Boolean not_first_floor,FiltrationFieldsResponse price,
    FiltrationFieldsResponse floor,FiltrationFieldsResponse max_floor,FiltrationFieldsResponse construction_year,FiltrationFieldsResponse total_area,FiltrationFieldsResponse kitchen_area) {
     
    Query q_ = session_.createSQLQuery("select t.* from Ho_Ad t "
            + "where "
            + "t.ho_cat=:id "
            + ((ho_build_type != null) ? " and t.ho_build_type in :ho_build_type" : "")
            +((room_cnt_arr != null) ? " and t.room_cnt in :room_cnt_arr " : "")
            +((not_last_floor !=null&&not_last_floor ==true ) ? " and t.floor=t.max_floor" : "")
            +((not_first_floor !=null&&not_first_floor ==true  ) ? " and t.floor=1" : "")
            +((price!=null&&price.getFrom() !=null&&price.getTo() !=null) ? " and t.price between :price_from and :price_to " : "")
            +((price!=null&&price.getFrom() !=null&&price.getTo() ==null) ? " and t.price>=:price_from " : "")
            +((price!=null&&price.getFrom() ==null&&price.getTo() !=null) ? " and t.price<=:price_to " : "")
            +((floor!=null&&floor.getFrom() !=null&&floor.getTo() !=null) ? " and t.floor between :floor_from and :floor_to " : "")
            +((floor!=null&&floor.getFrom() !=null&&floor.getTo() ==null) ? " and t.floor>=:floor_from " : "")
            +((floor!=null&&floor.getFrom() ==null&&floor.getTo() !=null) ? " and t.floor<=:floor_to " : "")
            +((max_floor!=null&&max_floor.getFrom() !=null&&max_floor.getTo() !=null) ? " and t.max_floor between :max_floor_from and :max_floor_to " : "")
            +((max_floor!=null&&max_floor.getFrom() !=null&&max_floor.getTo() ==null) ? " and t.max_floor>=:max_floor_from " : "")
            +((max_floor!=null&&max_floor.getFrom() ==null&&max_floor.getTo() !=null) ? " and t.max_floor<=:max_floor_to " : "")
            +((construction_year!=null&&construction_year.getFrom() !=null&&construction_year.getTo() !=null) ? " and t.construction_year between :construction_year_from and :construction_year_to " : "")
            +((construction_year!=null&&construction_year.getFrom() !=null&&construction_year.getTo() ==null) ? " and t.construction_year>=:construction_year_from " : "")
            +((construction_year!=null&&construction_year.getFrom() ==null&&construction_year.getTo() !=null) ? " and t.construction_year<=:construction_year_to " : "")
            +((total_area!=null&&total_area.getFrom() !=null&&total_area.getTo() !=null) ? " and t.total_area between :total_area_from and :total_area_to " : "")
            +((total_area!=null&&total_area.getFrom() !=null&&total_area.getTo() ==null) ? " and t.total_area>=:total_area_from " : "")
            +((total_area!=null&&total_area.getFrom() ==null&&total_area.getTo() !=null) ? " and t.total_area<=:total_area_to " : "")
            +((kitchen_area!=null&&kitchen_area.getFrom() !=null&&kitchen_area.getTo() !=null) ? " and t.kitchen_area between :kitchen_area_from and :kitchen_area_to " : "")
            +((kitchen_area!=null&&kitchen_area.getFrom() !=null&&kitchen_area.getTo() ==null) ? " and t.kitchen_area>=:kitchen_area_from " : "")
            +((kitchen_area!=null&&kitchen_area.getFrom() ==null&&kitchen_area.getTo() !=null) ? " and t.kitchen_area<=:kitchen_area_to " : "")
            + " and t.is_deleted=false ");
     q_.setParameter("id",id);
      if(room_cnt_arr != null )q_.setParameter("room_cnt_arr",room_cnt_arr);
      if(ho_build_type != null ) q_.setParameter("ho_build_type",ho_build_type);
     if(price!=null) {
      if(price.getFrom() != null ) q_.setParameter("price_from",price.getFrom());
      if(price.getTo() != null ) q_.setParameter("price_to",price.getTo());
     }
     if(floor!=null){
      if(floor.getFrom() != null ) q_.setParameter("floor_from",floor.getFrom());
      if(floor.getTo() != null ) q_.setParameter("floor_to",floor.getTo());
      }
     if(max_floor!=null){
      if(max_floor.getFrom() != null ) q_.setParameter("max_floor_from",max_floor.getFrom());
      if(max_floor.getTo() != null ) q_.setParameter("max_floor_to",max_floor.getTo());
     }
     if(construction_year!=null){
      if(construction_year.getFrom() != null ) q_.setParameter("construction_year_from",construction_year.getFrom());
      if(construction_year.getTo() != null ) q_.setParameter("construction_year_to",construction_year.getTo());
     }
     if(total_area!=null){
      if(total_area.getFrom() != null ) q_.setParameter("total_area_from",total_area.getFrom());
      if(total_area.getTo() != null ) q_.setParameter("total_area_to",total_area.getTo());
     }
     if(kitchen_area!=null){
      if(kitchen_area.getFrom() != null ) q_.setParameter("kitchen_area_from",kitchen_area.getFrom());
      if(kitchen_area.getTo() != null ) q_.setParameter("kitchen_area_to",kitchen_area.getTo());
     }
     return q_.list().size();
  }
  
  
//  public List<Mt_Prod> get_prod_list(Session session_, Integer mt_prod_cat_id_, List<Integer> mt_brand_id_arr_, Integer page_num_, Integer page_size_) {
//    List<Mt_Prod> res;
//    Query q_ = session_.createSQLQuery("select t.* from Mt_Prod t "
//            + "where "
//            + "  t.mt_prod_cat=:mt_prod_cat_id_ "
//            + ((mt_brand_id_arr_ != null && mt_brand_id_arr_.isEmpty()) ? "mt_brand=any(" + mt_brand_id_arr_.toString() + ")" : "")
//            + "  and t.is_deleted=false ").addEntity(Mt_Prod.class);
//    q_.setFirstResult((page_num_ - 1) * page_size_);
//    q_.setMaxResults(page_size_);
//    q_.setInteger("mt_prod_cat_id_", mt_prod_cat_id_);
//
//    res = q_.list();
//    return res;
//  }
}
