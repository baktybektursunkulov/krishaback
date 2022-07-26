package gs.controllers.ho.dbtables;

import gs.payload.response.horesponse.HoCatResponse;
import gs.payload.response.horesponse.HoSellRentResponse;
import gs.payload.response.horesponse.Offer_previewResponse;
import gs.repositories.core.dbtables.C_Land_Area_Unit_Repository;
import gs.repositories.core.dbtables.C_Loc_Repository;
import gs.repositories.core.dbtables.C_Tbl_Rec_Img_Moder_Repository;
import gs.repositories.ho.dbtables.Ho_Ad_Repository;
import gs.repositories.ho.dbtables.Ho_House_Indus_Base_Type_Repository;
import gs.repositories.ho.dbtables.Ho_House_Rent_Period_Repository;
import gs.repositories.ho.dbtables.Ho_House_Shop_Type_Repository;
import model.core.dbtables.*;
import gs.services.ho.Ho_Ad_Service;
import gs.services.ho.Ho_Cat_Service;
import io.swagger.annotations.Api;
import java.util.ArrayList;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import model.ho.dbtables.Ho_Ad;
import model.ho.dbtables.Ho_Cat;
import model.ho.dbtables.Ho_House_Indus_Base_Type;
import model.ho.dbtables.Ho_House_Shop_Type;
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
  private C_Land_Area_Unit_Repository C_land_area_unit_repository;
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
  @Autowired 
  private Ho_Ad_Repository ho_ad_repository;

  @GetMapping(value = "/preview_sell_rent")
  public ResponseEntity<List<Offer_previewResponse>> preview_sell_rent(@Valid @RequestParam Integer id,@Valid @RequestParam Integer parent_id,@Valid @RequestParam Integer page,@Valid @RequestParam Integer limit,HttpServletRequest httpServletRequest) throws RuntimeException {
    List<Offer_previewResponse> offer_preview = new ArrayList();
    List<Integer> ho_cat=ho_Cat_Service.ho_cat_sell_rent(parent_id,id);
    int d=page*limit;
    int k=0;
    Integer countof=0;
    while(d>countof&&ho_cat.size()>k){
    countof+=ho_ad_Service.countofcat(ho_cat.get(k));
    k++;
    }
     int s11=0;
     int l=countof-ho_ad_Service.countofcat(ho_cat.get(k-1));
     if(d-limit-l>0)s11+=l;
     if(d-limit<l)k--;
     List<Ho_Ad> ho_ads = ho_ad_Service.pagination(ho_cat.get(k-1),limit,page*limit-limit-s11);
    
     while(ho_ads.size()<limit&&ho_cat.size()>k){
    if(ho_ads.size()<limit){ho_ads.addAll(ho_ad_Service.pagination(ho_cat.get(k),limit-ho_ads.size(),0));k++;}
    }
    int i=0;
    while(i< ho_ads.size()) {
     C_Loc c_loc=c_loc_repository.find_all(ho_ads.get(i).getC_loc());
     
     while(c_loc.getIs_city().equals(false)&&c_loc.getParent_id()!=1){
       c_loc=c_loc_repository.find_all(c_loc.getParent_id());
     }
      List<C_Tbl_Rec_Img_Moder> c_tbl_rec_img_moder_list_ = c_tbl_rec_img_moder_repository.find_all(ho_ads.get(i).getHo_ad().longValue());
      if (!c_tbl_rec_img_moder_list_.isEmpty()) {
        
        C_Tbl_Rec_Img_Moder c_tbl_rec_img_moder = c_tbl_rec_img_moder_list_.get(0);
        Ho_Ad ho_ad = ho_ad_Service.find_by_id(ho_ads.get(i).getHo_ad());
        System.out.println(ho_ad.getHo_ad());
    Ho_Cat ho_cats=ho_Cat_Service.find_by_id(ho_ad.getHo_cat());
     String s=ho_cats.getPage_title();  
     Ho_House_Shop_Type shop_type=ho_house_shop_type_repository.find_by_id(ho_ad.getHo_house_shop_type());
     String s_typ="";
     if(ho_ad.getHo_house_shop_type()!=null)s_typ=shop_type.getName();
      Ho_House_Indus_Base_Type indus_type=ho_house_indus_base_type_repository.find_by_id(ho_ad.getHo_house_indus_base_type());
     String i_typ="";
     if(ho_ad.getHo_house_indus_base_type()!=null)i_typ=indus_type.getName();
     String t="";
     if(ho_ad.getRoom_cnt()!=null&&ho_ad.getHo_cat()!=15&&ho_ad.getHo_cat()!=26)t=String.valueOf(ho_ad.getRoom_cnt());
    
      String title="";
       if(ho_ad.getTitle()!=null)title+=ho_ad.getTitle();
       String Ho_house_rent_period=ho_house_rent_period_repository.find_by_id(ho_ad.getHo_house_rent_period());
     String rent_period="";
     if(Ho_house_rent_period!=null)rent_period=" "+Ho_house_rent_period; 
     String total_area="";
     if(ho_ad.getHo_cat()==13){
     total_area=" "+ho_ad.getTerritory_area().intValue()+" "+C_land_area_unit_repository.find_by_id(ho_ad.getTerritory_area_unit());
     }
     else if(s_typ==""&&i_typ==""){
     if(ho_ad.getTotal_area()!=null)
     total_area=", "+ho_ad.getTotal_area().intValue()+" м²";   
     }
     else if(s_typ!="")total_area=" "+ho_ad.getTotal_area().intValue()+" м²";
     else if(i_typ!=""&&ho_ad.getTerritory_area()!=null)total_area=" "+ho_ad.getTerritory_area().intValue()+" м²";
     if(ho_ad.getHo_cat()==16||ho_ad.getHo_cat()==27||ho_ad.getHo_cat()==15||ho_ad.getHo_cat()==26)total_area=" "+ho_ad.getTotal_area().intValue()+" м²";
     String floor="";
     String floor_ru=" этаж";
     if(ho_ad.getFloor()!=null){
       floor=", "+ho_ad.getFloor();
       if(ho_ad.getMax_floor()!=null)floor+="/"+ho_ad.getMax_floor();
       floor+=floor_ru;
     }
      offer_preview.add(new Offer_previewResponse(ho_ads.get(i).getHo_ad(), c_tbl_rec_img_moder.getC_img().intValue(), title+s_typ+i_typ+t+""+ho_cats.getSingular_name()+""+rent_period+total_area+floor,
        ho_ads.get(i).getPrice(),c_loc.getName() , c_tbl_rec_img_moder_repository.find_all_small(ho_ads.get(i).getHo_ad().longValue()),
        ho_ads.get(i).getStreet_name()));
      i++;
      }
      else i++;
    }
    return new ResponseEntity<>(offer_preview, HttpStatus.OK);
  }
  
  @GetMapping(value = "/offer_preview")
  public ResponseEntity<List<Offer_previewResponse>> offer_preview(@Valid @RequestParam Integer parent_id,@Valid @RequestParam Integer page,@Valid @RequestParam Integer limit,HttpServletRequest httpServletRequest) throws RuntimeException {
    List<Offer_previewResponse> offer_preview = new ArrayList();
    List<Integer> ho_cat=ho_Cat_Service.ho_cat_sell(parent_id);
    int d=page*limit;
    int k=0;
    Integer countof=0;
    while(d>countof&&ho_cat.size()>k){
    countof+=ho_ad_Service.countofcat(ho_cat.get(k));
    k++;
    }
     int s11=0;
     int l=countof-ho_ad_Service.countofcat(ho_cat.get(k-1));
     if(d-limit-l>0)s11+=l;
     if(d-limit<l)k--;
     List<Ho_Ad> ho_ads = ho_ad_Service.pagination(ho_cat.get(k-1),limit,page*limit-limit-s11);
    while(ho_ads.size()<limit&&ho_cat.size()>k){
    if(ho_ads.size()<limit){ho_ads.addAll(ho_ad_Service.pagination(ho_cat.get(k),limit-ho_ads.size(),0));k++;}
    }
    int i=0;
    while(i< ho_ads.size()) {
     C_Loc c_loc=c_loc_repository.find_all(ho_ads.get(i).getC_loc());
     while(c_loc.getIs_city().equals(false)&&c_loc.getParent_id()!=1){
       c_loc=c_loc_repository.find_all(c_loc.getParent_id());
     }
      List<C_Tbl_Rec_Img_Moder> c_tbl_rec_img_moder_list_ = c_tbl_rec_img_moder_repository.find_all(ho_ads.get(i).getHo_ad().longValue());
      if (!c_tbl_rec_img_moder_list_.isEmpty()) {
        C_Tbl_Rec_Img_Moder c_tbl_rec_img_moder = c_tbl_rec_img_moder_list_.get(0);
        Ho_Ad ho_ad = ho_ad_Service.find_by_id(ho_ads.get(i).getHo_ad());
        System.out.println(ho_ad.getHo_ad());
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
    
      String title="";
       if(ho_ad.getTitle()!=null)title+=ho_ad.getTitle();
       String Ho_house_rent_period=ho_house_rent_period_repository.find_by_id(ho_ad.getHo_house_rent_period());
     String rent_period="";
     if(Ho_house_rent_period!=null)rent_period=" "+Ho_house_rent_period; 
     String total_area="";
     if(ho_ad.getHo_cat()==13){
     total_area=" "+ho_ad.getTerritory_area().intValue()+" "+C_land_area_unit_repository.find_by_id(ho_ad.getTerritory_area_unit());
     }
     else if(s_typ==""&&i_typ==""){
     if(ho_ad.getTotal_area()!=null)
     total_area=", "+ho_ad.getTotal_area().intValue()+" м²";   
     }
     else if(s_typ!="")total_area=" "+ho_ad.getTotal_area().intValue()+" м²";
     else if(i_typ!=""&&ho_ad.getTerritory_area()!=null)total_area=" "+ho_ad.getTerritory_area().intValue()+" м²";
     if(ho_ad.getHo_cat()==16||ho_ad.getHo_cat()==27||ho_ad.getHo_cat()==15||ho_ad.getHo_cat()==26)total_area=" "+ho_ad.getTotal_area().intValue()+" м²";
     String floor="";
     String floor_ru=" этаж";
     if(ho_ad.getFloor()!=null){
       floor=", "+ho_ad.getFloor();
       if(ho_ad.getMax_floor()!=null)floor+="/"+ho_ad.getMax_floor();
       floor+=floor_ru;
     }
      offer_preview.add(new Offer_previewResponse(ho_ads.get(i).getHo_ad(), c_tbl_rec_img_moder.getC_img().intValue(), title+s_typ+i_typ+t+""+ho_cats.getSingular_name()+""+rent_period+total_area+floor,
        ho_ads.get(i).getPrice(),c_loc.getName() , c_tbl_rec_img_moder_repository.find_all_small(ho_ads.get(i).getHo_ad().longValue()),
        ho_ads.get(i).getStreet_name()));
      i++;
      }
      else i++;
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
