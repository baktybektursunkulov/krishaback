package gs.controllers.ho.dbtables;

import static gs.common.byte_funcs.bytes;
import gs.controllers.core.dbtables.*;
import gs.payload.response.horesponse.HoAdFieldsResponse;
import gs.payload.response.horesponse.HoAdsResponse;
import gs.payload.response.horesponse.HoCatResponse;
import gs.payload.response.horesponse.HoSellRentResponse;
import gs.payload.response.horesponse.Offer_previewResponse;
import gs.payload.response.horesponse.PublishedBy;
import gs.repositories.core.dbtables.C_Bin_File_Body_Repository;
import gs.repositories.core.dbtables.C_Img_Repository;
import gs.repositories.core.dbtables.C_Land_Area_Unit_Repository;
import gs.repositories.core.dbtables.C_Loc_Repository;
import gs.repositories.core.dbtables.C_Tbl_Rec_Img_Moder_Repository;
import gs.repositories.ho.dbtables.Ho_Ad_House_Commun_Repository;
import gs.repositories.ho.dbtables.Ho_Ad_House_Loc_Repository;
import gs.repositories.ho.dbtables.Ho_Ad_House_Misc_Repository;
import gs.repositories.ho.dbtables.Ho_Ad_House_Security_Repository;
import gs.repositories.ho.dbtables.Ho_Ad_Phone_Num_Repository;
import gs.repositories.ho.dbtables.Ho_Ad_Repository;
import gs.repositories.ho.dbtables.Ho_Build_Type_Repository;
import gs.repositories.ho.dbtables.Ho_Cat_Repository;
import gs.repositories.ho.dbtables.Ho_Contact_Info_Type_Repository;
import gs.repositories.ho.dbtables.Ho_House_Balcony_Repository;
import gs.repositories.ho.dbtables.Ho_House_Bathroom_Repository;
import gs.repositories.ho.dbtables.Ho_House_Commun_Repository;
import gs.repositories.ho.dbtables.Ho_House_Condition_Repository;
import gs.repositories.ho.dbtables.Ho_House_Door_Repository;
import gs.repositories.ho.dbtables.Ho_House_Drink_Water_Repository;
import gs.repositories.ho.dbtables.Ho_House_Electricity_Repository;
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
import model.core.dbtables.*;
import gs.services.core.dbtables.*;
import gs.services.ho.Ho_Ad_Service;
import gs.services.ho.Ho_Cat_Service;
import io.swagger.annotations.Api;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.sql.Timestamp;
import java.util.ArrayList;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import model.ho.dbtables.Ho_Ad;
import model.ho.dbtables.Ho_Ad_House_Commun;
import model.ho.dbtables.Ho_Ad_House_Loc;
import model.ho.dbtables.Ho_Ad_House_Misc;
import model.ho.dbtables.Ho_Ad_House_Security;
import model.ho.dbtables.Ho_Ad_Phone_Num;
import model.ho.dbtables.Ho_Cat;
import model.ho.dbtables.Ho_House_Commun;
import model.ho.dbtables.Ho_House_Indus_Base_Type;
import model.ho.dbtables.Ho_House_Misc;
import model.ho.dbtables.Ho_House_Shop_Type;
import model.ho.dbtables.Ho_Usr;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/ho_cat")
@Api(tags = {"Ad_Cat_Controller"})
public class Ho_Cat_Controller {
  @Autowired
  private  Ho_House_Shop_Type_Repository ho_house_shop_type_repository;
  @Autowired
  private C_Loc_Repository c_loc_repository;
   @Autowired
  private C_Img_Repository c_img_repository; 
  @Autowired
 private  C_Tbl_Rec_Img_Moder_Repository c_tbl_rec_img_moder_repository;
@Autowired
  private Ho_House_Rent_Period_Repository ho_house_rent_period_repository;
  @Autowired
  private Ho_House_Indus_Base_Type_Repository ho_house_indus_base_type_repository;
  @Autowired
  Ho_Cat_Service ho_Cat_Service;
  @Autowired
  Ho_Ad_Service ho_ad_Service;

 
  @GetMapping(value = "/preview_sell_rent")
  public ResponseEntity<List<Offer_previewResponse>> preview_sell_rent(@Valid @RequestParam Integer id,@Valid @RequestParam Integer parent_id,@Valid @RequestParam Integer page,HttpServletRequest httpServletRequest) throws RuntimeException {
    List<Offer_previewResponse> offer_preview = new ArrayList();
    List<Integer> ho_cat=ho_Cat_Service.ho_cat_sell_rent(parent_id,id);
     List<Ho_Ad> ho_ads = ho_ad_Service.find(ho_cat.get(0));
    int d=page*18;
    int i=d-18;
    int j=d-18;
    int k=1;
    while(ho_ads.size()<d&&ho_cat.size()>k){
    if(ho_ads.size()-j<18){
      ho_ads.addAll(ho_ad_Service.find(ho_cat.get(k)));
      k++;
    }    }
    System.out.println(ho_ads.size());
    while(i< ho_ads.size()) {
      
     C_Loc c_loc=c_loc_repository.find_all(ho_ads.get(j).getC_loc());
     try{if(c_loc.getIs_city().equals(false))
      System.out.println(c_loc.getIs_city());
     while(c_loc.getIs_city().equals(false)){
       c_loc=c_loc_repository.find_all(c_loc.getParent_id());
     }
     if(c_loc.getIs_city().equals(false)){j++;continue;}
     
     
      List<C_Tbl_Rec_Img_Moder> c_tbl_rec_img_moder_list_ = c_tbl_rec_img_moder_repository.find_all(ho_ads.get(j).getHo_ad().longValue());
      if (!c_tbl_rec_img_moder_list_.isEmpty()) {
        
        C_Tbl_Rec_Img_Moder c_tbl_rec_img_moder = c_tbl_rec_img_moder_list_.get(0);
        C_Img c_img = c_img_repository.find_all(c_tbl_rec_img_moder.getC_img());
        Ho_Ad ho_ad = ho_ad_Service.find_by_id(ho_ads.get(i).getHo_ad());
    Ho_Cat ho_cats=ho_Cat_Service.find_by_id(ho_ad.getHo_cat());
     Ho_Cat ho_cat1=ho_Cat_Service.find_by_id(ho_cats.getParent_id());
     String s=ho_cats.getPage_title();  
     Ho_House_Shop_Type shop_type=ho_house_shop_type_repository.find_by_id(ho_ad.getHo_house_shop_type());
     String s_typ="";
     if(ho_ad.getHo_house_shop_type()!=null)s_typ=shop_type.getName();
      Ho_House_Indus_Base_Type indus_type=ho_house_indus_base_type_repository.find_by_id(ho_ad.getHo_house_indus_base_type());
     String i_typ="";
     if(ho_ad.getHo_house_indus_base_type()!=null)i_typ=indus_type.getName();
     String t="";
     if(ho_ad.getRoom_cnt()!=null&&ho_ad.getHo_cat()!=15&&ho_ad.getHo_cat()!=26)t=String.valueOf(ho_ad.getRoom_cnt());
    
       String Ho_house_rent_period=ho_house_rent_period_repository.find_by_id(ho_ad.getHo_house_rent_period());
     String rent_period="";
     if(Ho_house_rent_period!=null)rent_period=" "+Ho_house_rent_period; 
     String total_area="";
     if(s_typ==""&&i_typ==""){
     if(ho_ad.getTotal_area()!=null)
     total_area=", "+ho_ad.getTotal_area().intValue()+" м²";   
     }
     else if(s_typ!=""||i_typ!="")total_area=" "+ho_ad.getTotal_area().intValue()+" м²";
     if(ho_ad.getHo_cat()==16||ho_ad.getHo_cat()==27||ho_ad.getHo_cat()==15||ho_ad.getHo_cat()==26)total_area=" "+ho_ad.getTotal_area().intValue()+" м²";
     String floor="";
     String floor_ru=" этаж";
     if(ho_ad.getFloor()!=null){
       floor=", "+ho_ad.getFloor();
       if(ho_ad.getMax_floor()!=null)floor+="/"+ho_ad.getMax_floor();
       floor+=floor_ru;
     }
      offer_preview.add(new Offer_previewResponse(ho_ads.get(i).getHo_ad(), c_tbl_rec_img_moder.getC_img().intValue(), s_typ+i_typ+t+""+ho_cats.getSingular_name()+""+rent_period+total_area+floor,
        ho_ads.get(j).getPrice(),c_loc.getName() , c_tbl_rec_img_moder_repository.find_all_small(ho_ads.get(j).getHo_ad().longValue()),
        ho_ads.get(j).getStreet_name()));
      i++;
      }
      j++;
    }catch(NullPointerException e){
      j++;
      continue;
      }
     if(i==d)break;
    }
    return new ResponseEntity<>(offer_preview, HttpStatus.OK);
  }
  
  @GetMapping(value = "/offer_preview")
  public ResponseEntity<List<Offer_previewResponse>> offer_preview(@Valid @RequestParam Integer parent_id,@Valid @RequestParam Integer page,HttpServletRequest httpServletRequest) throws RuntimeException {
    List<Offer_previewResponse> offer_preview = new ArrayList();
    List<Integer> ho_cat=ho_Cat_Service.ho_cat_sell(parent_id);
     List<Ho_Ad> ho_ads = ho_ad_Service.find(ho_cat.get(0));
    int d=page*18;
    int i=d-18;
    int j=d-18;
    int k=1;
    while(ho_ads.size()<d&&ho_cat.size()>k){
    if(ho_ads.size()-j<18){ho_ads.addAll(ho_ad_Service.find(ho_cat.get(k)));k++;}
    }
    while(i< ho_ads.size()) {
      
     C_Loc c_loc=c_loc_repository.find_all(ho_ads.get(j).getC_loc());
      try{
     while(c_loc.getIs_city().equals(false)){
       c_loc=c_loc_repository.find_all(c_loc.getParent_id());
     }
     if(c_loc.getIs_city().equals(false)){j++;continue;}
     
      List<C_Tbl_Rec_Img_Moder> c_tbl_rec_img_moder_list_ = c_tbl_rec_img_moder_repository.find_all(ho_ads.get(j).getHo_ad().longValue());
      if (!c_tbl_rec_img_moder_list_.isEmpty()) {
        C_Tbl_Rec_Img_Moder c_tbl_rec_img_moder = c_tbl_rec_img_moder_list_.get(0);
        C_Img c_img = c_img_repository.find_all(c_tbl_rec_img_moder.getC_img());
             Ho_Ad ho_ad = ho_ad_Service.find_by_id(ho_ads.get(i).getHo_ad());
    Ho_Cat ho_cats=ho_Cat_Service.find_by_id(ho_ad.getHo_cat());
     Ho_Cat ho_cat1=ho_Cat_Service.find_by_id(ho_cats.getParent_id());
     String s=ho_cats.getPage_title();  
     Ho_House_Shop_Type shop_type=ho_house_shop_type_repository.find_by_id(ho_ad.getHo_house_shop_type());
     String s_typ="";
     if(ho_ad.getHo_house_shop_type()!=null)s_typ=shop_type.getName();
      Ho_House_Indus_Base_Type indus_type=ho_house_indus_base_type_repository.find_by_id(ho_ad.getHo_house_indus_base_type());
     String i_typ="";
     if(ho_ad.getHo_house_indus_base_type()!=null)i_typ=indus_type.getName();
     String t="";
     if(ho_ad.getRoom_cnt()!=null&&ho_ad.getHo_cat()!=15&&ho_ad.getHo_cat()!=26)t=String.valueOf(ho_ad.getRoom_cnt());
    
       String Ho_house_rent_period=ho_house_rent_period_repository.find_by_id(ho_ad.getHo_house_rent_period());
     String rent_period="";
     if(Ho_house_rent_period!=null)rent_period=" "+Ho_house_rent_period; 
     String total_area="";
     if(s_typ==""&&i_typ==""){
     if(ho_ad.getTotal_area()!=null)
     total_area=", "+ho_ad.getTotal_area().intValue()+" м²";   
     }
     else if(s_typ!=""||i_typ!="")total_area=" "+ho_ad.getTotal_area().intValue()+" м²";
     if(ho_ad.getHo_cat()==16||ho_ad.getHo_cat()==27||ho_ad.getHo_cat()==15||ho_ad.getHo_cat()==26)total_area=" "+ho_ad.getTotal_area().intValue()+" м²";
     String floor="";
     String floor_ru=" этаж";
     if(ho_ad.getFloor()!=null){
       floor=", "+ho_ad.getFloor();
       if(ho_ad.getMax_floor()!=null)floor+="/"+ho_ad.getMax_floor();
       floor+=floor_ru;
     }
      offer_preview.add(new Offer_previewResponse(ho_ads.get(i).getHo_ad(), c_tbl_rec_img_moder.getC_img().intValue(), s_typ+i_typ+t+""+ho_cats.getSingular_name()+""+rent_period+total_area+floor,
        ho_ads.get(j).getPrice(), c_loc_repository.find_by_Id(ho_ads.get(j).getC_loc()), c_tbl_rec_img_moder_repository.find_all_small(ho_ads.get(j).getHo_ad().longValue()),
        ho_ads.get(j).getStreet_name()));
      i++;
      }
      j++;
      }catch(NullPointerException e){
      j++;
      continue;
      }
     if(i==d)break;
    }
    return new ResponseEntity<>(offer_preview, HttpStatus.OK);
  }

  @GetMapping(value = "/find_all")
  public ResponseEntity<List<HoCatResponse>> find_all(HttpServletRequest httpServletRequest) throws RuntimeException {

    List<HoCatResponse> ho_list = new ArrayList();
    List<Ho_Cat> ho_Cats = ho_Cat_Service.find_all();

    for (Ho_Cat ho_Cat : ho_Cats) {
      
      ho_list.add(new HoCatResponse(ho_Cat.getHo_cat(),
        ho_Cat.getSingular_name()));
    }

    return new ResponseEntity<>(ho_list, HttpStatus.OK);
  }

  @GetMapping(value = "/find_page_title")
  public ResponseEntity<HoCatResponse> find_page_title(@Valid @RequestParam Integer id, HttpServletRequest httpServletRequest) throws RuntimeException {
    HoCatResponse child_list;
    List<Ho_Cat> ho_Cats = ho_Cat_Service.find_page_title();

    Ho_Cat ho_Cat = ho_Cat_Service.find_by_id(id);

    child_list = new HoCatResponse(ho_Cat.getHo_cat(),
      ho_Cat.getPage_title());

    return new ResponseEntity<>(child_list, HttpStatus.OK);
  }

  @GetMapping(value = "/get_subcat_list")
  public ResponseEntity<List<HoCatResponse>> get_subcat_list(@Valid @RequestParam Integer id, HttpServletRequest httpServletRequest) throws RuntimeException {

    List<HoCatResponse> ho_list = new ArrayList();
    List<Ho_Cat> ho_Cats = ho_Cat_Service.get_subcat_list(id);

    for (Ho_Cat ho_Cat : ho_Cats) {
      ho_list.add(new HoCatResponse(ho_Cat.getHo_cat(),
        ho_Cat.getPlural_name()));
    }
    return new ResponseEntity<>(ho_list, HttpStatus.OK);
  }

  @GetMapping(value = "/find_title")
  public ResponseEntity<List<HoCatResponse>> find_title(HttpServletRequest httpServletRequest) throws RuntimeException {

    List<HoCatResponse> child_list = new ArrayList();
    List<Ho_Cat> ho_Cats = ho_Cat_Service.find_page_title();

    for (Ho_Cat ho_Cat : ho_Cats) {
      child_list.add(new HoCatResponse(ho_Cat.getHo_cat(),
        ho_Cat.getName()));
    }

    return new ResponseEntity<>(child_list, HttpStatus.OK);
  }

  @GetMapping(value = "/get_seocontent_menu_list")
  public ResponseEntity<List<HoCatResponse>> get_seocontent_menu_list(HttpServletRequest httpServletRequest) throws RuntimeException {

    List<HoCatResponse> child_list = new ArrayList();
    List<Ho_Cat> ho_Cats = ho_Cat_Service.get_seocontent_menu_list();

    for (Ho_Cat ho_Cat : ho_Cats) {
      child_list.add(new HoCatResponse(ho_Cat.getHo_cat(),
        ho_Cat.getName()));
    }

    return new ResponseEntity<>(child_list, HttpStatus.OK);
  }
  @GetMapping(value = "/get_sell_rent_subcat")
  public ResponseEntity<List<HoSellRentResponse>> get_sell_rent_subcat(@Valid @RequestParam Integer id, HttpServletRequest httpServletRequest) throws RuntimeException {
    List<HoSellRentResponse> ho_list = new ArrayList();
    List<Ho_Cat> ho_Cats = ho_Cat_Service.get_sell_rent_subcat(id);
    for (Ho_Cat ho_Cat : ho_Cats) {
      List<Ho_Cat> ho_cat1=ho_Cat_Service.get_subcat_list(ho_Cat.getHo_cat());
      boolean trf=true;
      if(ho_cat1.isEmpty())trf=false;
      ho_list.add(new HoSellRentResponse(ho_Cat.getHo_cat(),
        ho_Cat.getName(),trf));
    }
    return new ResponseEntity<>(ho_list, HttpStatus.OK);
  }
 
}
