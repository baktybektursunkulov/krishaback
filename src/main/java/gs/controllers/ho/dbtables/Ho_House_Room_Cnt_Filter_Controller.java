package gs.controllers.ho.dbtables;

import gs.controllers.core.dbtables.*;
import gs.payload.response.adresponse.AdCatResponse;
import gs.payload.response.adresponse.AdCatResponse1;
import gs.payload.response.AdCatResponseId;
import gs.payload.response.horesponse.HoCatResponse;
import gs.payload.response.horesponse.HoHouseRoomCntFilterResponse;
import model.core.dbtables.*;
import gs.services.core.dbtables.*;
import gs.services.ho.Ho_Cat_Service;
import gs.services.ho.Ho_House_Room_Cnt_Filter_Service;
import io.swagger.annotations.Api;
import java.util.ArrayList;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import model.ho.dbtables.Ho_Cat;
import model.ho.dbtables.Ho_House_Room_Cnt_Filter;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/ho_house_room_cnt_filter")
@Api(tags = {"Ad_Cat_Controller"})
public class Ho_House_Room_Cnt_Filter_Controller {

  @Autowired
 Ho_House_Room_Cnt_Filter_Service ho_house_room_cnt_filter_Service;

  @GetMapping(value = "/find_all")
  public ResponseEntity<List<HoHouseRoomCntFilterResponse>> find_all(HttpServletRequest httpServletRequest) throws RuntimeException {
    
    List<HoHouseRoomCntFilterResponse> ho_list = new ArrayList();
    List<Ho_House_Room_Cnt_Filter> ho_Cats = ho_house_room_cnt_filter_Service.find_all();
    
    for (Ho_House_Room_Cnt_Filter ho_Cat : ho_Cats) {
      ho_list.add(new HoHouseRoomCntFilterResponse(ho_Cat.getHo_house_room_cnt_filter(),
                                             ho_Cat.getName()));
    }
    
 
    return new ResponseEntity<>(ho_list, HttpStatus.OK);
  }
  
//   @GetMapping(value = "/find_page_title")
//  public ResponseEntity<HoCatResponse> find_page_title(@Valid @RequestParam Integer id,HttpServletRequest httpServletRequest) throws RuntimeException {
//    HoCatResponse child_list;
//    List<Ho_Cat> ho_Cats = ho_Cat_Service.find_page_title();
//    
//    Ho_Cat ho_Cat = ho_Cat_Service.find_by_id(id);
//   
//      child_list=new HoCatResponse(ho_Cat.getHo_cat(),
//                                             ho_Cat.getPage_title());
//     
//    
//    
// 
//    return new ResponseEntity<>(child_list, HttpStatus.OK);
//  }
//  
//    @GetMapping(value = "/get_subcat_list")
//  public ResponseEntity<List<HoCatResponse>> get_subcat_list(@Valid @RequestParam Integer id,HttpServletRequest httpServletRequest) throws RuntimeException {
//   
//    
//    //Ho_Cat ho_Cat1 = ho_Cat_Service.get_subcat_list(id);
//    List<HoCatResponse> ho_list = new ArrayList();
//    List<Ho_Cat> ho_Cats = ho_Cat_Service.get_subcat_list(id);
//    
//    for (Ho_Cat ho_Cat : ho_Cats) {
//      ho_list.add(new HoCatResponse(ho_Cat.getHo_cat(),
//                                             ho_Cat.getPlural_name()));
//    }
//    return new ResponseEntity<>(ho_list, HttpStatus.OK);
//  }
//  
//     @GetMapping(value = "/find_title")
//  public ResponseEntity<List<HoCatResponse>> find_title(HttpServletRequest httpServletRequest) throws RuntimeException {
//   
//    List<HoCatResponse> child_list = new ArrayList();
//    List<Ho_Cat> ho_Cats = ho_Cat_Service.find_page_title();
//    
//    for (Ho_Cat ho_Cat : ho_Cats) {
//      child_list.add(new HoCatResponse(ho_Cat.getHo_cat(),
//                                             ho_Cat.getName()));
//    }
//    
// 
//    return new ResponseEntity<>(child_list, HttpStatus.OK);
//  }
//  
//   @GetMapping(value = "/get_seocontent_menu_list")
//  public ResponseEntity<List<HoCatResponse>> get_seocontent_menu_list(HttpServletRequest httpServletRequest) throws RuntimeException {
//   
//    List<HoCatResponse> child_list = new ArrayList();
//    List<Ho_Cat> ho_Cats = ho_Cat_Service.get_seocontent_menu_list();
//    
//    for (Ho_Cat ho_Cat : ho_Cats) {
//      child_list.add(new HoCatResponse(ho_Cat.getHo_cat(),
//                                             ho_Cat.getName()));
//    }
//    
// 
//    return new ResponseEntity<>(child_list, HttpStatus.OK);
//  }
//  
//  @GetMapping(value = "/get_sell_rent_cat")
//  public ResponseEntity<List<HoCatResponse>> get_sell_rent_cat(HttpServletRequest httpServletRequest) throws RuntimeException {
//   
//    List<HoCatResponse> child_list = new ArrayList();
//    List<Ho_Cat> ho_Cats = ho_Cat_Service.get_sell_rent_cat();
//    
//    for (Ho_Cat ho_Cat : ho_Cats) {
//      child_list.add(new HoCatResponse(ho_Cat.getHo_cat(),
//                                             ho_Cat.getName()));
//    }
//    
// 
//    return new ResponseEntity<>(child_list, HttpStatus.OK);
//  }
  
}



