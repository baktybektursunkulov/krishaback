package gs.controllers.ho.dbtables;

import static gs.common.byte_funcs.bytes;
import gs.controllers.core.dbtables.*;
import gs.payload.response.horesponse.HoCatResponse;
import gs.payload.response.horesponse.Offer_previewResponse;
import gs.repositories.core.dbtables.C_Bin_File_Body_Repository;
import gs.repositories.core.dbtables.C_Img_Repository;
import gs.repositories.core.dbtables.C_Loc_Repository;
import gs.repositories.core.dbtables.C_Tbl_Rec_Img_Moder_Repository;
import gs.repositories.ho.dbtables.Ho_Ad_Repository;
import model.core.dbtables.*;
import gs.services.core.dbtables.*;
import gs.services.ho.Ho_Ad_Service;
import gs.services.ho.Ho_Cat_Service;
import io.swagger.annotations.Api;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.util.ArrayList;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import model.ho.dbtables.Ho_Ad;
import model.ho.dbtables.Ho_Cat;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/ho_cat")
@Api(tags = {"Ad_Cat_Controller"})
public class Ho_Cat_Controller {

  @Autowired
  Ho_Cat_Service ho_Cat_Service;
  @Autowired
  Ho_Ad_Service ho_ad_Service;
  @Autowired
  C_Loc_Repository c_loc_repository;
  @Autowired
  C_Tbl_Rec_Img_Moder_Repository c_tbl_rec_img_moder_repository;
  @Autowired
  C_Img_Repository c_img_repository;
  @Autowired
  C_Bin_File_Body_Repository c_bin_file_body_repository;

  @GetMapping(value = "/offer_preview")
  public ResponseEntity<List<Offer_previewResponse>> offer_preview(@Valid @RequestParam Integer page,HttpServletRequest httpServletRequest) throws RuntimeException {
    List<Offer_previewResponse> offer_preview = new ArrayList();
    List<Ho_Ad> ho_ads = ho_ad_Service.find();
    int d=page*18;
    for (int i=d-18;i< ho_ads.size();i++) {
      if(i==d)break;
      List<C_Tbl_Rec_Img_Moder> c_tbl_rec_img_moder_list_ = c_tbl_rec_img_moder_repository.find_all(ho_ads.get(i).getHo_ad().longValue());
      if (!c_tbl_rec_img_moder_list_.isEmpty()) {
        C_Tbl_Rec_Img_Moder c_tbl_rec_img_moder = c_tbl_rec_img_moder_list_.get(0);
        C_Img c_img = c_img_repository.find_all(c_tbl_rec_img_moder.getC_img());
        System.out.println("test");
      System.out.println("test");
      offer_preview.add(new Offer_previewResponse(ho_ads.get(i).getHo_ad(), c_tbl_rec_img_moder.getC_img().intValue(), c_img.getFile_name(),
        ho_ads.get(i).getPrice(), c_loc_repository.find_by_Id(ho_ads.get(i).getC_loc()), c_tbl_rec_img_moder_repository.find_all_small(ho_ads.get(i).getHo_ad().longValue()),
        ho_ads.get(i).getStreet_name()));
      }else continue;
     
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

    //Ho_Cat ho_Cat1 = ho_Cat_Service.get_subcat_list(id);
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

  @GetMapping(value = "/get_sell_rent_cat")
  public ResponseEntity<List<HoCatResponse>> get_sell_rent_cat(HttpServletRequest httpServletRequest) throws RuntimeException {

    List<HoCatResponse> child_list = new ArrayList();
    List<Ho_Cat> ho_Cats = ho_Cat_Service.get_sell_rent_cat();

    for (Ho_Cat ho_Cat : ho_Cats) {
      child_list.add(new HoCatResponse(ho_Cat.getHo_cat(),
        ho_Cat.getName()));
    }

    return new ResponseEntity<>(child_list, HttpStatus.OK);
  }

  @GetMapping(value = "/get_sell_rent_subcat")
  public ResponseEntity<List<HoCatResponse>> get_sell_rent_subcat(@Valid @RequestParam Integer id, HttpServletRequest httpServletRequest) throws RuntimeException {

    //Ho_Cat ho_Cat1 = ho_Cat_Service.get_subcat_list(id);
    List<HoCatResponse> ho_list = new ArrayList();
    List<Ho_Cat> ho_Cats = ho_Cat_Service.get_sell_rent_subcat(id);

    for (Ho_Cat ho_Cat : ho_Cats) {
      ho_list.add(new HoCatResponse(ho_Cat.getHo_cat(),
        ho_Cat.getName()));
    }
    return new ResponseEntity<>(ho_list, HttpStatus.OK);
  }
//  
//  
// private List<AdCatResponse1> convert(List<Ad_Cat> list) {
//    List<AdCatResponse1> res = new ArrayList();
//   
//    for (Ad_Cat rec : list) {
//      res.add(new AdCatResponse1(rec.getAd_cat(),
//                                      rec.getName()));
//    }
//    return res;
//  }
// 
//  private List<AdCatResponseId> convertid(List<Ad_Cat> list) {
//    List<AdCatResponseId> res = new ArrayList();
//   
//    for (Ad_Cat rec : list) {
//      res.add(new AdCatResponseId(rec.getAd_cat(),
//                                      rec.getName()));
//    }
//    return res;
//  }
// 
//  @GetMapping(value = "/find_subcat_id")
//  public ResponseEntity<?> get_cat_info_id(@Valid @RequestParam Integer id, HttpServletRequest httpServletRequest) throws RuntimeException {
//    System.out.println(id);
//    
//    Ad_Cat mt_Prod_Cat = ad_Cat_Service.find_by_id(id);
//    List<AdCatResponseId> child_list = new ArrayList();
//    List<Ad_Cat> ad_Cats = ad_Cat_Service.find_all_sub_prod_cat(id);
//    
//    for (Ad_Cat ad_Cat : ad_Cats) {
//      child_list.add(new AdCatResponseId(ad_Cat.getAd_cat(),
//                                             ad_Cat.getName(), 
//                                             convertid(ad_Cat_Service.find_all_sub_prod_cat(ad_Cat.getAd_cat()))));
//    }
//    
//   AdCatResponseId res = new AdCatResponseId(mt_Prod_Cat.getAd_cat(),
//                                                      mt_Prod_Cat.getName(),
//                                                      child_list);
//    
//    return new ResponseEntity<>(res, HttpStatus.OK);
//  }
//  
//   @GetMapping(value = "/find_subcat")
//  public ResponseEntity<List<?>> get_cat_info(HttpServletRequest httpServletRequest) throws RuntimeException {
//    List <AdCatResponse> res1 = new ArrayList();
//    for(int i=1;i<=10;i++){
//    System.out.println(i);
//    
//    Ad_Cat mt_Prod_Cat = ad_Cat_Service.find_by_id(i);
//    List<AdCatResponse1> child_list = new ArrayList();
//    List<Ad_Cat> ad_Cats = ad_Cat_Service.find_all_sub_prod_cat(i);
//    
//    for (Ad_Cat ad_Cat : ad_Cats) {
//      child_list.add(new AdCatResponse1(ad_Cat.getAd_cat(),
//                                             ad_Cat.getName()));
//    }
//    
//   AdCatResponse res = new AdCatResponse(mt_Prod_Cat.getAd_cat(),mt_Prod_Cat.getName(),child_list);
//     res1.add(res);
//  }
//    return new ResponseEntity<>(res1, HttpStatus.OK);
//  }

}
