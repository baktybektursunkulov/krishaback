package gs.controllers.ho.dbtables;

import gs.controllers.core.dbtables.*;
import gs.payload.response.horesponse.HoAdCatResponse;
import gs.payload.response.horesponse.HoAdFieldsResponse;
import gs.payload.response.horesponse.HoAdsResponse;
import gs.payload.response.horesponse.HoCLocResponse;
import gs.payload.response.horesponse.HoCatResponse;
import gs.payload.response.horesponse.HoHouseRoomCntFilterResponse;
import gs.payload.response.horesponse.Offer_previewResponse;
import gs.payload.response.horesponse.PublishedBy;
import gs.repositories.core.dbtables.C_Img_Repository;
import gs.repositories.core.dbtables.C_Land_Area_Unit_Repository;
import gs.repositories.core.dbtables.C_Loc_Repository;
import gs.repositories.core.dbtables.C_Tbl_Rec_Corr_By_Name_Repository;
import gs.repositories.core.dbtables.C_Tbl_Rec_Img_Moder_Repository;
import gs.repositories.core.dbtables.C_Usr_Repository;
import gs.repositories.ho.dbtables.Ho_Ad_House_Alloc_Type_Repository;
import gs.repositories.ho.dbtables.Ho_Ad_House_Commun_Repository;
import gs.repositories.ho.dbtables.Ho_Ad_House_Field_Activ_Repository;
import gs.repositories.ho.dbtables.Ho_Ad_House_Loc_Repository;
import gs.repositories.ho.dbtables.Ho_Ad_House_Misc_Repository;
import gs.repositories.ho.dbtables.Ho_Ad_House_Security_Repository;
import gs.repositories.ho.dbtables.Ho_Ad_Phone_Num_Repository;
import gs.repositories.ho.dbtables.Ho_Ad_Repository;
import gs.repositories.ho.dbtables.Ho_Ad_Status_Repository;
import gs.repositories.ho.dbtables.Ho_Build_Type_Repository;
import gs.repositories.ho.dbtables.Ho_Contact_Info_Type_Repository;
import gs.repositories.ho.dbtables.Ho_House_Alloc_Type_Repository;
import gs.repositories.ho.dbtables.Ho_House_Balcony_Repository;
import gs.repositories.ho.dbtables.Ho_House_Bathroom_Repository;
import gs.repositories.ho.dbtables.Ho_House_Commun_Repository;
import gs.repositories.ho.dbtables.Ho_House_Condition_Repository;
import gs.repositories.ho.dbtables.Ho_House_Door_Repository;
import gs.repositories.ho.dbtables.Ho_House_Drink_Water_Repository;
import gs.repositories.ho.dbtables.Ho_House_Electricity_Repository;
import gs.repositories.ho.dbtables.Ho_House_Field_Activ_Repository;
import gs.repositories.ho.dbtables.Ho_House_Floor_Repository;
import gs.repositories.ho.dbtables.Ho_House_Furniture_Repository;
import gs.repositories.ho.dbtables.Ho_House_Gas_Repository;
import gs.repositories.ho.dbtables.Ho_House_Heating_Repository;
import gs.repositories.ho.dbtables.Ho_House_Indus_Base_Type_Repository;
import gs.repositories.ho.dbtables.Ho_House_Inet_Repository;
import gs.repositories.ho.dbtables.Ho_House_Irrigation_Water_Repository;
import gs.repositories.ho.dbtables.Ho_House_Land_Price_Repository;
import gs.repositories.ho.dbtables.Ho_House_Loc_Repository;
import gs.repositories.ho.dbtables.Ho_House_Misc_Repository;
import gs.repositories.ho.dbtables.Ho_House_Office_Type_Repository;
import gs.repositories.ho.dbtables.Ho_House_Parking_Repository;
import gs.repositories.ho.dbtables.Ho_House_Phone_Repository;
import gs.repositories.ho.dbtables.Ho_House_Rent_Period_Repository;
import gs.repositories.ho.dbtables.Ho_House_Security_Repository;
import gs.repositories.ho.dbtables.Ho_House_Sewerage_Repository;
import gs.repositories.ho.dbtables.Ho_House_Shop_Type_Repository;
import gs.repositories.ho.dbtables.Ho_House_Spec_Purpose_Repository;
import gs.repositories.ho.dbtables.Ho_Resid_Complex_Repository;
import gs.repositories.ho.dbtables.Ho_Usr_Repository;
import model.core.dbtables.*;
import gs.services.core.dbtables.*;
import gs.services.ho.Ho_Ad_Service;
import gs.services.ho.Ho_Cat_Service;
import gs.services.ho.Ho_House_Room_Cnt_Filter_Service;
import gs.services.ho.Ho_Usr_Service;
import io.swagger.annotations.Api;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat.Field;
import java.util.ArrayList;
import java.util.Date;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import model.ho.dbtables.Ho_Ad;
import model.ho.dbtables.Ho_Ad_House_Alloc_Type;
import model.ho.dbtables.Ho_Ad_House_Commun;
import model.ho.dbtables.Ho_Ad_House_Field_Activ;
import model.ho.dbtables.Ho_Ad_House_Loc;
import model.ho.dbtables.Ho_Ad_House_Misc;
import model.ho.dbtables.Ho_Ad_House_Security;
import model.ho.dbtables.Ho_Ad_Phone_Num;
import model.ho.dbtables.Ho_Build_Type;
import model.ho.dbtables.Ho_Cat;
import model.ho.dbtables.Ho_Contact_Info_Type;
import model.ho.dbtables.Ho_House_Alloc_Type;
import model.ho.dbtables.Ho_House_Commun;
import model.ho.dbtables.Ho_House_Field_Activ;
import model.ho.dbtables.Ho_House_Indus_Base_Type;
import model.ho.dbtables.Ho_House_Misc;
import model.ho.dbtables.Ho_House_Parking;
import model.ho.dbtables.Ho_House_Rent_Period;
import model.ho.dbtables.Ho_House_Room_Cnt_Filter;
import model.ho.dbtables.Ho_House_Security;
import model.ho.dbtables.Ho_House_Shop_Type;
import model.ho.dbtables.Ho_Resid_Complex;
import model.ho.dbtables.Ho_Usr;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.*;


import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/ho_ad")
@Api(tags = {"Ho_Ad_Controller"})
public class Ho_Ad_Controller {

  @Autowired
  Ho_Ad_Service ho_Ad_Service;
  @Autowired
  private Ho_Usr_Repository repository;
  @Autowired
  Ho_Cat_Service ho_cat_service;
   @Autowired
  private  Ho_House_Security_Repository ho_house_security_repository;
   @Autowired
  private  Ho_House_Alloc_Type_Repository ho_house_alloc_type_repository;
   @Autowired
  private  Ho_House_Field_Activ_Repository ho_house_field_activ_repository;
     @Autowired
  private  Ho_House_Commun_Repository ho_house_commun_repository;
      @Autowired
  private  Ho_House_Misc_Repository ho_house_misc_repository;
    @Autowired
  private  Ho_Ad_House_Security_Repository ho_ad_house_security_repository;
    @Autowired
  private  Ho_Ad_House_Alloc_Type_Repository ho_ad_house_alloc_type_repository;
     @Autowired
  private  Ho_Ad_House_Field_Activ_Repository ho_ad_house_field_activ_repository;
     @Autowired
  private  Ho_Ad_House_Loc_Repository ho_ad_house_loc_repository;
      @Autowired
  private  Ho_Ad_House_Commun_Repository ho_ad_house_commun_repository;
       @Autowired
  private  Ho_Ad_House_Misc_Repository ho_ad_house_misc_repository;
  @Autowired
  private  Ho_House_Shop_Type_Repository ho_house_shop_type_repository;
  @Autowired
  private C_Loc_Repository c_loc_repository;
   @Autowired
  private C_Img_Repository c_img_repository; 
  @Autowired
 private  C_Tbl_Rec_Img_Moder_Repository c_tbl_rec_img_moder_repository;
  @Autowired
  private Ho_Contact_Info_Type_Repository ho_contact_info_type_repository;
  @Autowired
  private Ho_Build_Type_Repository ho_build_type_Repository;
  @Autowired
  private Ho_Resid_Complex_Repository ho_resid_complex_repository;
  @Autowired
  private Ho_House_Phone_Repository ho_house_phone_repository;
  @Autowired
  private Ho_House_Inet_Repository ho_house_inet_repository;
  @Autowired
  private Ho_House_Balcony_Repository ho_house_balcony_repository;
  @Autowired
  private Ho_House_Bathroom_Repository ho_house_bathroom_repository;
  @Autowired
  private Ho_House_Door_Repository ho_house_door_repository;
  @Autowired
  private Ho_House_Parking_Repository ho_house_parking_repository;
  @Autowired
  private Ho_House_Furniture_Repository ho_house_furniture_repository;
  @Autowired
  private Ho_House_Floor_Repository ho_house_floor_repository;
 @Autowired
  private Ho_House_Sewerage_Repository ho_house_sewerege_repository;
 @Autowired
  private Ho_House_Drink_Water_Repository ho_house_drink_water_repository;
 @Autowired
  private Ho_House_Electricity_Repository ho_house_electricity_repository;
  @Autowired
  private Ho_House_Heating_Repository ho_house_heating_repository;
 @Autowired
  private Ho_House_Gas_Repository ho_house_gas_repository;
 @Autowired
  private Ho_House_Irrigation_Water_Repository ho_house_irrigation_water_repository;
 @Autowired
  private Ho_House_Office_Type_Repository ho_house_office_type_repository;
@Autowired
  private Ho_House_Loc_Repository ho_house_loc_repository;
@Autowired
  private C_Land_Area_Unit_Repository C_land_area_unit_repository;
@Autowired
  private Ho_House_Land_Price_Repository ho_house_land_price_repository;
@Autowired
  private Ho_House_Spec_Purpose_Repository ho_house_spec_purpose_repository;
@Autowired
  private Ho_House_Rent_Period_Repository ho_house_rent_period_repository;
 @Autowired
  private Ho_House_Condition_Repository ho_house_condition_repository;
  @Autowired
  private Ho_Ad_Phone_Num_Repository ho_ad_phone_num_repository;
  @Autowired
  private Ho_House_Indus_Base_Type_Repository ho_house_indus_base_type_repository;
   
  @PostMapping("/save_ads")
  private Ho_Ad save_ads(@RequestBody Ho_Ad ho_ad) {
    String str = "2018-09-01 09:01:15";
    Timestamp timestamp = Timestamp.valueOf(str);
    ho_ad.setIns_dt(timestamp);
    ho_ad.setIs_deleted(Boolean.FALSE);
    Long kl = 11L;
    Ho_Usr ho_usr = get_ho_usr(kl);
    ho_ad.setHo_usr(ho_usr.getHo_usr());
    return ho_Ad_Service.saveOrUpdate(ho_ad);
  }

  public Ho_Usr get_ho_usr(Long c_usr_id_) {
    Ho_Usr res = repository.find_rec_by_c_usr_id(c_usr_id_);
    if (res == null) {
      res = new Ho_Usr();
      res.setC_usr(c_usr_id_);
      res.setIs_notif_when_publish(true);
      res.setIs_notif_when_refuse(true);
      res.setIs_notif_when_remove(true);
      res.setIs_notif_when_new_msg(true);
      res.setIs_deleted(false);
      repository.save(res);
    }
    return res;
  }
 
  @GetMapping("/ads")
 public ResponseEntity<HoAdsResponse> ads(@Valid @RequestParam Integer id) throws RuntimeException, NoSuchFieldException {
    Ho_Ad ho_ads = ho_Ad_Service.find_by_id(id);
    Ho_Cat ho_cats=ho_cat_service.find_by_id(ho_ads.getHo_cat());
     Ho_Cat ho_cat=ho_cat_service.find_by_id(ho_cats.getParent_id());
     String s=ho_cats.getPage_title();  
     Ho_House_Shop_Type shop_type=ho_house_shop_type_repository.find_by_id(ho_ads.getHo_house_shop_type());
     String s_typ="";
     if(ho_ads.getHo_house_shop_type()!=null)s_typ=shop_type.getName();
      Ho_House_Indus_Base_Type indus_type=ho_house_indus_base_type_repository.find_by_id(ho_ads.getHo_house_indus_base_type());
     String i_typ="";
     if(ho_ads.getHo_house_indus_base_type()!=null)i_typ=indus_type.getName();
     String t="";
     if(ho_ads.getRoom_cnt()!=null&&ho_ads.getHo_cat()!=15&&ho_ads.getHo_cat()!=26)t=String.valueOf(ho_ads.getRoom_cnt());
     C_Loc c_loc=c_loc_repository.find_all(ho_ads.getC_loc());
    
     if(c_loc.getParent_id()!=1){
       c_loc=c_loc_repository.find_all(c_loc.getParent_id());
     }
      List<C_Tbl_Rec_Img_Moder> c_tbl_rec_img_moder_list_ = c_tbl_rec_img_moder_repository.find_all(ho_ads.getHo_ad().longValue());
    //  if (!c_tbl_rec_img_moder_list_.isEmpty()) {
          
        C_Tbl_Rec_Img_Moder c_tbl_rec_img_moder = c_tbl_rec_img_moder_list_.get(0);
        C_Img c_img = c_img_repository.find_all(c_tbl_rec_img_moder.getC_img());
        String ho_contact_info_type= ho_contact_info_type_repository.find_by_id(ho_ads.getHo_contact_info_type());
        List<Ho_Ad_Phone_Num> ho_ad_phone_nums=ho_ad_phone_num_repository.find_by_id(ho_ads.getHo_ad());
        List<String> phone=new ArrayList();
        for(Ho_Ad_Phone_Num ho_ad_phone_num:ho_ad_phone_nums){
          phone.add(ho_ad_phone_num.getPhone_num());
        }
       
        List<String> security=new ArrayList();
        List<Ho_Ad_House_Security> ho_ad_house_security=ho_ad_house_security_repository.find_by_id(ho_ads.getHo_ad());
        for (Ho_Ad_House_Security ho_Ad_House_Security : ho_ad_house_security) {
          Ho_House_Security Ho_House_Security=ho_house_security_repository.find_by_id(ho_Ad_House_Security.getHo_house_security());
          security.add(Ho_House_Security.getName());
        }
        
        List<String> commun=new ArrayList();
        List<Ho_Ad_House_Commun> ho_ad_house_commun=ho_ad_house_commun_repository.find_by_id(ho_ads.getHo_ad());
        for (Ho_Ad_House_Commun ho_Ad_House_Security : ho_ad_house_commun) {
         Ho_House_Commun Ho_House_Security=ho_house_commun_repository.find_by_id(ho_Ad_House_Security.getHo_ad_house_commun());
          commun.add(Ho_House_Security.getName());
        }
        List<String> loc=new ArrayList();
     
        List<Ho_Ad_House_Loc> ho_ad_house_loc=ho_ad_house_loc_repository.find_by_id(ho_ads.getHo_ad());
        for (Ho_Ad_House_Loc ho_Ad_House_Security : ho_ad_house_loc) {
          loc.add(ho_house_loc_repository.find_by_id(ho_Ad_House_Security.getHo_ad_house_loc()));
        }
       
        List<String> misc=new ArrayList();
     
        List<Ho_Ad_House_Misc> ho_ad_house_misc=ho_ad_house_misc_repository.find_by_id(ho_ads.getHo_ad());
        for (Ho_Ad_House_Misc ho_Ad_House_Security : ho_ad_house_misc) {
         Ho_House_Misc Ho_House_Security=ho_house_misc_repository.find_by_id(ho_Ad_House_Security.getHo_ad_house_misc());
          misc.add(Ho_House_Security.getName());
        }
        List<String> alloc_type=new ArrayList();
     
        List<Ho_Ad_House_Alloc_Type> ho_ad_house_alloc_type=ho_ad_house_alloc_type_repository.find_by_id(ho_ads.getHo_ad());
        for (Ho_Ad_House_Alloc_Type ho_Ad_House_Security : ho_ad_house_alloc_type) {
         Ho_House_Alloc_Type Ho_House_Security=ho_house_alloc_type_repository.find_by_id(ho_Ad_House_Security.getHo_ad_house_alloc_type());
          alloc_type.add(Ho_House_Security.getName());
        }
          List<String> fiel_activ=new ArrayList();
     
        List<Ho_Ad_House_Field_Activ> ho_ad_house_fiel_activ=ho_ad_house_field_activ_repository.find_by_id(ho_ads.getHo_ad());
        for (Ho_Ad_House_Field_Activ ho_Ad_House_Security : ho_ad_house_fiel_activ) {
         Ho_House_Field_Activ Ho_House_Security=ho_house_field_activ_repository.find_by_id(ho_Ad_House_Security.getHo_ad_house_field_activ());
          fiel_activ.add(Ho_House_Security.getName());
        }
        PublishedBy publishedBy=new PublishedBy(ho_contact_info_type,phone);
        C_Loc c_loc1=c_loc_repository.find_all(ho_ads.getC_loc());
        
        String location=c_loc.getName();
        if(location!=c_loc_repository.find_by_Id(ho_ads.getC_loc()))
           location+=", "+c_loc_repository.find_by_Id(ho_ads.getC_loc());
        
        List<Integer> images=c_tbl_rec_img_moder_repository.find_small_pictures(ho_ads.getHo_ad().longValue());
       HoAdFieldsResponse hoadfieldsresponse=new HoAdFieldsResponse(ho_ads.getHo_ad(),ho_ads.getC_country(),ho_ads.getRoom_cnt(),
       ho_build_type_Repository.find_by_id(ho_ads.getHo_build_type()),ho_ads.getConstruction_year(),ho_ads.getFloor(),ho_ads.getMax_floor(),ho_ads.getTotal_area(),ho_ads.getLiving_area(),ho_ads.getKitchen_area(),ho_ads.getIs_in_priv_hostel(),location,ho_resid_complex_repository.find_by_id(ho_ads.getHo_resid_complex()),ho_ads.getStreet_name(),ho_ads.getHouse_num(),
       ho_ads.getIntersection(),ho_ads.getIs_hide_house_num(),ho_ads.getLat(),ho_ads.getLon(),ho_house_condition_repository.find_by_id(ho_ads.getHo_house_condition()),ho_house_phone_repository.find_by_id(ho_ads.getHo_house_phone()),ho_house_inet_repository.find_by_id(ho_ads.getHo_house_inet()),ho_house_bathroom_repository.find_by_id(ho_ads.getHo_house_bathroom()),ho_house_balcony_repository.find_by_id(ho_ads.getHo_house_balcony()),ho_ads.getIs_balcony_glazed(),ho_house_door_repository.find_by_id(ho_ads.getHo_house_door()),ho_house_parking_repository.find_by_id(ho_ads.getHo_house_parking()),ho_house_furniture_repository.find_by_id(ho_ads.getHo_house_furniture()),ho_house_floor_repository.find_by_id(ho_ads.getHo_house_floor()),ho_ads.getCeiling_height(),ho_contact_info_type_repository.find_by_id(ho_ads.getHo_contact_info_type()),ho_ads.getContact_name(),ho_ads.getIs_exch_possible(),
       ho_ads.getIs_agree_with_rules(),ho_ads.getHo_ad_status(),ho_ads.getIs_deleted(),ho_ads.getLevel_num(),ho_ads.getLand_area(),ho_ads.getHow_area_fenced(),ho_house_sewerege_repository.find_by_id(ho_ads.getHo_house_sewerage()),ho_house_drink_water_repository.find_by_id(ho_ads.getHo_house_drink_water()),ho_house_electricity_repository.find_by_id(ho_ads.getHo_house_electricity()),ho_house_heating_repository.find_by_id(ho_ads.getHo_house_heating()),ho_house_gas_repository.find_by_id(ho_ads.getHo_house_gas()),ho_ads.getRoofing(),
       ho_ads.getSuburban_area_name(),ho_ads.getHouse_area(),ho_house_irrigation_water_repository.find_by_id(ho_ads.getHo_house_irrigation_water()),ho_house_office_type_repository.find_by_id(ho_ads.getHo_house_office_type()),ho_ads.getBusiness_center_name(),ho_ads.getPhone_lines_num(),ho_ads.getParking(),ho_ads.getIs_has_sep_entr_group(),ho_ads.getAdj_territory_area(),ho_house_shop_type_repository.find_by_id1(ho_ads.getHo_house_shop_type()),ho_house_loc_repository.find_by_id(ho_ads.getHo_house_loc()),ho_ads.getShop_center_name(),ho_house_indus_base_type_repository.find_by_id1(ho_ads.getHo_house_indus_base_type()),
       ho_ads.getTerritory_area(),C_land_area_unit_repository.find_by_id(ho_ads.getTerritory_area_unit()),ho_ads.getProduction_area(),ho_ads.getProduction_area_ceiling_height(),ho_ads.getWarehouse_area(),ho_ads.getWarehouse_ceiling_height(),ho_ads.getOffice_area(),ho_ads.getIs_has_railway_siding(),ho_ads.getMax_power_consumption(),ho_ads.getIs_has_own_substation(),
       ho_house_land_price_repository.find_by_id(ho_ads.getHo_house_land_price()),ho_ads.getIs_divisible(),ho_house_spec_purpose_repository.find_by_id(ho_ads.getHo_house_spec_purpose()),ho_ads.getTitle(),ho_ads.getIs_operating_business(),ho_house_rent_period_repository.find_by_id(ho_ads.getHo_house_rent_period()),ho_ads.getHo_usr(),security,commun,loc,misc,alloc_type,fiel_activ);
    
       String title="";
       if(ho_ads.getTitle()!=null)title+=ho_ads.getTitle();
       
       String Ho_house_rent_period=ho_house_rent_period_repository.find_by_id(ho_ads.getHo_house_rent_period());
     String rent_period="";
     if(Ho_house_rent_period!=null)rent_period=" "+Ho_house_rent_period; 
     String total_area="";
     
     if(ho_ads.getHo_cat()==13){
     total_area=" "+ho_ads.getTerritory_area().intValue()+" "+C_land_area_unit_repository.find_by_id(ho_ads.getTerritory_area_unit());
     }
     else if(s_typ==""&&i_typ==""){
     if(ho_ads.getTotal_area()!=null)
     total_area=", "+ho_ads.getTotal_area().intValue()+" м²";   
     }
    else if(s_typ!="")total_area=" "+ho_ads.getTotal_area().intValue()+" м²"; 
    else if(i_typ!=""&&ho_ads.getTerritory_area()!=null)total_area=" "+ho_ads.getTerritory_area().intValue()+" м²";
     if(ho_ads.getHo_cat()==16||ho_ads.getHo_cat()==27||ho_ads.getHo_cat()==15||ho_ads.getHo_cat()==26)total_area=" "+ho_ads.getTotal_area().intValue()+" м²";
     String floor="";
     String floor_ru=" этаж";
     if(ho_ads.getFloor()!=null){
       floor=", "+ho_ads.getFloor();
       if(ho_ads.getMax_floor()!=null)floor+="/"+ho_ads.getMax_floor();
       floor+=floor_ru;
     }
    HoAdsResponse ho_list =new HoAdsResponse(ho_ads.getHo_ad(),ho_cat.getSingular_name()+" "+t+" "+s+" "+s_typ+" "+i_typ+" №"+ho_ads.getHo_ad()+": "+ho_ads.getStreet_name()+", "+c_loc.getName()+" -за "+ho_ads.getPrice(),
    title+s_typ+i_typ+t+""+ho_cats.getSingular_name()+""+rent_period+total_area+floor+", "+ho_ads.getStreet_name(),ho_ads.getPrice(),ho_ads.getHo_cat(),ho_ads.getIs_pledged(),publishedBy,images,ho_ads.getIns_dt(),ho_ads.getTxt(),hoadfieldsresponse);
   
  //}
   return new ResponseEntity<>( ho_list,HttpStatus.OK);
  }
}
