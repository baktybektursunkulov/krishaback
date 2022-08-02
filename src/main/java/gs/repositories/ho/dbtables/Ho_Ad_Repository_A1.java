package gs.repositories.ho.dbtables;

import gs.payload.response.horesponse.*;
import gs.repositories.core.dbtables.*;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.ho.dbtables.Ho_Ad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class Ho_Ad_Repository_A1 {

  @PersistenceContext(unitName = "hoEntityManagerFactory")
  EntityManager em;
//
//  @Autowired
//  Ho_Ad_House_Field_Activ_Repository ho_ad_house_field_activ_repository;

  public List<FiltrationResponse> filters(Integer id, List<Integer> ho_build_type, List<Integer> room_cnt_arr, Boolean not_last_floor, Boolean not_first_floor, FiltrationFieldsResponse price,
    FiltrationFieldsResponse floor, FiltrationFieldsResponse max_floor, FiltrationFieldsResponse construction_year, FiltrationFieldsResponse total_area, FiltrationFieldsResponse kitchen_area, FiltrationFieldsResponse living_area,
    FiltrationFieldsResponse land_area, FiltrationFieldsResponse adj_territory_area, FiltrationFieldsResponse warehouse_area, FiltrationFieldsResponse max_power_consumption, FiltrationFieldsResponse office_area,
    Boolean has_photo, Boolean owner, Boolean is_in_priv_hostel, Boolean is_has_railway_siding, Boolean is_has_own_substation, Boolean is_pledged, Boolean is_exch_possible, Boolean is_operating_business, Boolean is_divisible, Boolean is_has_sep_entr_group, Integer ho_house_spec_purpose, String txt_has,
    List<Integer> ho_house_furniture, List<Integer> ho_house_inet, List<Integer> ho_house_bathroom, List<Integer> ho_house_condition, List<Integer> ho_house_phone, List<Integer> ho_house_rent_period, List<Integer> ho_house_electricity,
    List<Integer> ho_house_drink_water, List<Integer> ho_house_irrigation_water, List<Integer> ho_house_gas, List<Integer> ho_house_office_type, List<Integer> ho_house_shop_type, List<Integer> ho_house_loc,
    List<Integer> ho_house_indus_base_type, List<Integer> ho_house_field_activ, List<Integer> ho_house_sewerage) {
    List<FiltrationResponse> res = new ArrayList();
    List<Ho_Ad> ho_ads;

    String tmp_query_ = "";
    if (ho_house_field_activ != null && !ho_house_field_activ.isEmpty()) {
      for (Integer ho_house_field_activ_item_ : ho_house_field_activ) {
        if (!tmp_query_.isEmpty()) {
          tmp_query_ = tmp_query_ + " or ";
        }
        tmp_query_ = tmp_query_ + "exists (select 1 from ho_ad_house_field_activ ahfa "
          + "where ahfa.is_deleted=false and ahfa.ho_ad=t.ho_ad and ahfa.ho_house_field_activ=" + ho_house_field_activ_item_ + ")";
      }
    }
    String ho_house_field_activ_query_ = (tmp_query_.isEmpty() ? "" : "and (" + tmp_query_ + ")");

    javax.persistence.Query q_ = em.createNativeQuery("select t.* from Ho_Ad t "
      + "where "
      + "t.ho_cat=:id "
      + ((ho_build_type != null) ? " and t.ho_build_type in :ho_build_type" : "")
      + ((room_cnt_arr != null) ? " and t.room_cnt in :room_cnt_arr " : "")
      + ((not_last_floor != null && not_last_floor == true) ? " and t.floor=t.max_floor" : "")
      + ((not_first_floor != null && not_first_floor == true) ? " and t.floor=1" : "")
      + ((price != null && price.getFrom() != null && price.getTo() != null) ? " and t.price between :price_from and :price_to " : "")
      + ((price != null && price.getFrom() != null && price.getTo() == null) ? " and t.price>=:price_from " : "")
      + ((price != null && price.getFrom() == null && price.getTo() != null) ? " and t.price<=:price_to " : "")
      + ((floor != null && floor.getFrom() != null && floor.getTo() != null) ? " and t.floor between :floor_from and :floor_to " : "")
      + ((floor != null && floor.getFrom() != null && floor.getTo() == null) ? " and t.floor>=:floor_from " : "")
      + ((floor != null && floor.getFrom() == null && floor.getTo() != null) ? " and t.floor<=:floor_to " : "")
      + ((max_floor != null && max_floor.getFrom() != null && max_floor.getTo() != null) ? " and t.max_floor between :max_floor_from and :max_floor_to " : "")
      + ((max_floor != null && max_floor.getFrom() != null && max_floor.getTo() == null) ? " and t.max_floor>=:max_floor_from " : "")
      + ((max_floor != null && max_floor.getFrom() == null && max_floor.getTo() != null) ? " and t.max_floor<=:max_floor_to " : "")
      + ((construction_year != null && construction_year.getFrom() != null && construction_year.getTo() != null) ? " and t.construction_year between :construction_year_from and :construction_year_to " : "")
      + ((construction_year != null && construction_year.getFrom() != null && construction_year.getTo() == null) ? " and t.construction_year>=:construction_year_from " : "")
      + ((construction_year != null && construction_year.getFrom() == null && construction_year.getTo() != null) ? " and t.construction_year<=:construction_year_to " : "")
      + ((total_area != null && total_area.getFrom() != null && total_area.getTo() != null) ? " and t.total_area between :total_area_from and :total_area_to " : "")
      + ((total_area != null && total_area.getFrom() != null && total_area.getTo() == null) ? " and t.total_area>=:total_area_from " : "")
      + ((total_area != null && total_area.getFrom() == null && total_area.getTo() != null) ? " and t.total_area<=:total_area_to " : "")
      + ((kitchen_area != null && kitchen_area.getFrom() != null && kitchen_area.getTo() != null) ? " and t.kitchen_area between :kitchen_area_from and :kitchen_area_to " : "")
      + ((kitchen_area != null && kitchen_area.getFrom() != null && kitchen_area.getTo() == null) ? " and t.kitchen_area>=:kitchen_area_from " : "")
      + ((kitchen_area != null && kitchen_area.getFrom() == null && kitchen_area.getTo() != null) ? " and t.kitchen_area<=:kitchen_area_to " : "")
      + ((living_area != null && living_area.getFrom() != null && living_area.getTo() != null) ? " and t.living_area between :living_area_from and :living_area_to " : "")
      + ((living_area != null && living_area.getFrom() != null && living_area.getTo() == null) ? " and t.living_area>=:living_area_from " : "")
      + ((living_area != null && living_area.getFrom() == null && living_area.getTo() != null) ? " and t.living_area<=:living_area_to " : "")
      + ((land_area != null && land_area.getFrom() != null && land_area.getTo() != null) ? " and t.land_area between :land_area_from and :land_area_to " : "")
      + ((land_area != null && land_area.getFrom() != null && land_area.getTo() == null) ? " and t.land_area>=:land_area_from " : "")
      + ((land_area != null && land_area.getFrom() == null && land_area.getTo() != null) ? " and t.land_area<=:land_area_to " : "")
      + ((adj_territory_area != null && adj_territory_area.getFrom() != null && adj_territory_area.getTo() != null) ? " and t.adj_territory_area between :adj_territory_area_from and :adj_territory_area_to " : "")
      + ((adj_territory_area != null && adj_territory_area.getFrom() != null && adj_territory_area.getTo() == null) ? " and t.adj_territory_area>=:adj_territory_area_from " : "")
      + ((adj_territory_area != null && adj_territory_area.getFrom() == null && adj_territory_area.getTo() != null) ? " and t.adj_territory_area<=:adj_territory_area_to " : "")
      + ((warehouse_area != null && warehouse_area.getFrom() != null && warehouse_area.getTo() != null) ? " and t.warehouse_area between :warehouse_area_from and :warehouse_area_to " : "")
      + ((warehouse_area != null && warehouse_area.getFrom() != null && warehouse_area.getTo() == null) ? " and t.warehouse_area>=:warehouse_area_from " : "")
      + ((warehouse_area != null && warehouse_area.getFrom() == null && warehouse_area.getTo() != null) ? " and t.warehouse_area<=:warehouse_area_to " : "")
      + ((max_power_consumption != null && max_power_consumption.getFrom() != null && max_power_consumption.getTo() != null) ? " and t.max_power_consumption between :max_power_consumption_from and :max_power_consumption_to " : "")
      + ((max_power_consumption != null && max_power_consumption.getFrom() != null && max_power_consumption.getTo() == null) ? " and t.max_power_consumption>=:max_power_consumption_from " : "")
      + ((max_power_consumption != null && max_power_consumption.getFrom() == null && max_power_consumption.getTo() != null) ? " and t.max_power_consumption<=:max_power_consumption_to " : "")
      + ((office_area != null && office_area.getFrom() != null && office_area.getTo() != null) ? " and t.office_area between :office_area_from and :office_area_to " : "")
      + ((office_area != null && office_area.getFrom() != null && office_area.getTo() == null) ? " and t.office_area>=:office_area_from " : "")
      + ((office_area != null && office_area.getFrom() == null && office_area.getTo() != null) ? " and t.office_area<=:office_area_to " : "")
      + ((owner != null && owner == true) ? " and t.ho_contact_info_type=1 " : "")
      + ((owner != null && owner == false) ? " and t.ho_contact_info_type<>1 " : "")
      + ((is_in_priv_hostel != null && is_in_priv_hostel == true) ? " and t.is_in_priv_hostel=true " : "")
      + ((is_in_priv_hostel != null && is_in_priv_hostel == false) ? " and t.is_in_priv_hostel=false " : "")
      + ((is_has_railway_siding != null && is_has_railway_siding == true) ? " and t.is_has_railway_siding=true " : "")
      + ((is_has_railway_siding != null && is_has_railway_siding == false) ? " and t.is_has_railway_siding=false " : "")
      + ((is_has_own_substation != null && is_has_own_substation == true) ? " and t.is_has_own_substation=true " : "")
      + ((is_has_own_substation != null && is_has_own_substation == false) ? " and t.is_has_own_substation=false " : "")
      + ((is_pledged != null && is_pledged == true) ? " and t.is_pledged=true " : "")
      + ((is_pledged != null && is_pledged == false) ? " and t.is_pledged=false " : "")
      + ((is_exch_possible != null && is_exch_possible == true) ? " and t.is_exch_possible=true " : "")
      + ((is_exch_possible != null && is_exch_possible == false) ? " and t.is_exch_possible=false " : "")
      + ((is_operating_business != null && is_operating_business == true) ? " and t.is_operating_business=true " : "")
      + ((is_operating_business != null && is_operating_business == false) ? " and t.is_operating_business=false " : "")
      + ((is_divisible != null && is_divisible == true) ? " and t.is_divisible=true " : "")
      + ((is_divisible != null && is_divisible == false) ? " and t.is_divisible=false " : "")
      + ((is_has_sep_entr_group != null && is_has_sep_entr_group == true) ? " and t.is_has_sep_entr_group=true " : "")
      + ((is_has_sep_entr_group != null && is_has_sep_entr_group == false) ? " and t.is_has_sep_entr_group=false " : "")
      + ((ho_house_spec_purpose != null) ? " and t.ho_house_spec_purpose=:ho_house_spec_purpose_ " : "")
      + ((ho_house_furniture != null) ? " and t.ho_house_furniture in :ho_house_furniture_ " : "")
      + ((ho_house_inet != null) ? " and t.ho_house_inet in :ho_house_inet_ " : "")
      + ((ho_house_bathroom != null) ? " and t.ho_house_bathroom in :ho_house_bathroom_ " : "")
      + ((ho_house_condition != null) ? " and t.ho_house_condition in :ho_house_condition_ " : "")
      + ((ho_house_phone != null) ? " and t.ho_house_phone in :ho_house_phone_ " : "")
      + ((ho_house_rent_period != null) ? " and t.ho_house_rent_period in :ho_house_rent_period_ " : "")
      + ((ho_house_electricity != null) ? " and t.ho_house_electricity in :ho_house_electricity_ " : "")
      + ((ho_house_drink_water != null) ? " and t.ho_house_drink_water in :ho_house_drink_water_ " : "")
      + ((ho_house_irrigation_water != null) ? " and t.ho_house_irrigation_water in :ho_house_irrigation_water_ " : "")
      + ((ho_house_gas != null) ? " and t.ho_house_gas in :ho_house_gas_ " : "")
      + ((ho_house_office_type != null) ? " and t.ho_house_office_type in :ho_house_office_type_ " : "")
      + ((ho_house_shop_type != null) ? " and t.ho_house_shop_type in :ho_house_shop_type_ " : "")
      + ((ho_house_loc != null) ? " and t.ho_house_loc in :ho_house_loc_ " : "")
      + ((ho_house_indus_base_type != null) ? " and t.ho_house_indus_base_type in :ho_house_indus_base_type_ " : "")
      + ((ho_house_sewerage != null) ? " and t.ho_house_sewerage in :ho_house_sewerage_ " : "")
      + (has_photo == null ? "" : " and " + (has_photo ? "exists" : "not exists") + " ("
        + "select 1 from c_tbl_rec_img_moder trim "
        + "where "
        + "  trim.is_deleted=false "
        + "  and trim.c_tbl=" + C_Tbl_Repository.id__ho_ad
        + "  and trim.rec_id=t.ho_ad"
        + "  and trim.c_img_status=" + C_Img_Status_Repository.id__approved
        + ")")
      + " and t.is_deleted=false "
      + ho_house_field_activ_query_, Ho_Ad.class);

    q_.setParameter("id", id);
    if (room_cnt_arr != null) {
      q_.setParameter("room_cnt_arr", room_cnt_arr);
    }
    if (ho_build_type != null) {
      q_.setParameter("ho_build_type", ho_build_type);
    }
    if (price != null) {
      if (price.getFrom() != null) {
        q_.setParameter("price_from", price.getFrom());
      }
      if (price.getTo() != null) {
        q_.setParameter("price_to", price.getTo());
      }
    }
    if (floor != null) {
      if (floor.getFrom() != null) {
        q_.setParameter("floor_from", floor.getFrom());
      }
      if (floor.getTo() != null) {
        q_.setParameter("floor_to", floor.getTo());
      }
    }
    if (max_floor != null) {
      if (max_floor.getFrom() != null) {
        q_.setParameter("max_floor_from", max_floor.getFrom());
      }
      if (max_floor.getTo() != null) {
        q_.setParameter("max_floor_to", max_floor.getTo());
      }
    }
    if (construction_year != null) {
      if (construction_year.getFrom() != null) {
        q_.setParameter("construction_year_from", construction_year.getFrom());
      }
      if (construction_year.getTo() != null) {
        q_.setParameter("construction_year_to", construction_year.getTo());
      }
    }
    if (total_area != null) {
      if (total_area.getFrom() != null) {
        q_.setParameter("total_area_from", total_area.getFrom());
      }
      if (total_area.getTo() != null) {
        q_.setParameter("total_area_to", total_area.getTo());
      }
    }
    if (kitchen_area != null) {
      if (kitchen_area.getFrom() != null) {
        q_.setParameter("kitchen_area_from", kitchen_area.getFrom());
      }
      if (kitchen_area.getTo() != null) {
        q_.setParameter("kitchen_area_to", kitchen_area.getTo());
      }
    }
    if (living_area != null) {
      if (living_area.getFrom() != null) {
        q_.setParameter("living_area_from", living_area.getFrom());
      }
      if (living_area.getTo() != null) {
        q_.setParameter("living_area_to", living_area.getTo());
      }
    }
    if (land_area != null) {
      if (land_area.getFrom() != null) {
        q_.setParameter("land_area_from", land_area.getFrom());
      }
      if (land_area.getTo() != null) {
        q_.setParameter("land_area_to", land_area.getTo());
      }
    }
    if (adj_territory_area != null) {
      if (adj_territory_area.getFrom() != null) {
        q_.setParameter("adj_territory_area_from", adj_territory_area.getFrom());
      }
      if (adj_territory_area.getTo() != null) {
        q_.setParameter("adj_territory_area_to", adj_territory_area.getTo());
      }
    }
    if (warehouse_area != null) {
      if (warehouse_area.getFrom() != null) {
        q_.setParameter("warehouse_area_from", warehouse_area.getFrom());
      }
      if (warehouse_area.getTo() != null) {
        q_.setParameter("warehouse_area_to", warehouse_area.getTo());
      }
    }
    if (max_power_consumption != null) {
      if (max_power_consumption.getFrom() != null) {
        q_.setParameter("max_power_consumption_from", max_power_consumption.getFrom());
      }
      if (max_power_consumption.getTo() != null) {
        q_.setParameter("max_power_consumption_to", max_power_consumption.getTo());
      }
    }
    if (office_area != null) {
      if (office_area.getFrom() != null) {
        q_.setParameter("office_area_from", office_area.getFrom());
      }
      if (office_area.getTo() != null) {
        q_.setParameter("office_area_to", office_area.getTo());
      }
    }

    if (ho_house_spec_purpose != null) {
      q_.setParameter("ho_house_spec_purpose_", ho_house_spec_purpose);
    }
    if (txt_has != null) {
      q_.setParameter("txt_has", txt_has);
    }

    if (ho_house_furniture != null) {
      q_.setParameter("ho_house_furniture_", ho_house_furniture);
    }
    if (ho_house_inet != null) {
      q_.setParameter("ho_house_inet_", ho_house_inet);
    }
    if (ho_house_bathroom != null) {
      q_.setParameter("ho_house_bathroom_", ho_house_bathroom);
    }
    if (ho_house_condition != null) {
      q_.setParameter("ho_house_condition_", ho_house_condition);
    }
    if (ho_house_phone != null) {
      q_.setParameter("ho_house_phone_", ho_house_phone);
    }
    if (ho_house_rent_period != null) {
      q_.setParameter("ho_house_rent_period_", ho_house_rent_period);
    }
    if (ho_house_electricity != null) {
      q_.setParameter("ho_house_electricity_", ho_house_electricity);
    }
    if (ho_house_drink_water != null) {
      q_.setParameter("ho_house_drink_water_", ho_house_drink_water);
    }
    if (ho_house_irrigation_water != null) {
      q_.setParameter("ho_house_irrigation_water_", ho_house_irrigation_water);
    }
    if (ho_house_gas != null) {
      q_.setParameter("ho_house_gas_", ho_house_gas);
    }
    if (ho_house_office_type != null) {
      q_.setParameter("ho_house_office_type_", ho_house_office_type);
    }
    if (ho_house_shop_type != null) {
      q_.setParameter("ho_house_shop_type_", ho_house_shop_type);
    }
    if (ho_house_loc != null) {
      q_.setParameter("ho_house_loc_", ho_house_loc);
    }
    if (ho_house_indus_base_type != null) {
      q_.setParameter("ho_house_indus_base_type_", ho_house_indus_base_type);
    }
    if (ho_house_sewerage != null) {
      q_.setParameter("ho_house_sewerage_", ho_house_sewerage);
    }
    res = q_.getResultList();
    return res;
  }

}
