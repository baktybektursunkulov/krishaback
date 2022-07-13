package gs.controllers.ho.dbtables;

import gs.controllers.core.dbtables.*;
import gs.payload.response.horesponse.HoAdCatResponse;
import gs.payload.response.horesponse.HoAdResponseFlat;
import gs.payload.response.horesponse.HoCatResponse;
import gs.payload.response.horesponse.HoHouseRoomCntFilterResponse;
import gs.repositories.core.dbtables.C_Tbl_Rec_Corr_By_Name_Repository;
import gs.repositories.core.dbtables.C_Usr_Repository;
import gs.repositories.ho.dbtables.Ho_Ad_Repository;
import gs.repositories.ho.dbtables.Ho_Build_Type_Repository;
import gs.repositories.ho.dbtables.Ho_Contact_Info_Type_Repository;
import gs.repositories.ho.dbtables.Ho_House_Parking_Repository;
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
import model.ho.dbtables.Ho_Build_Type;
import model.ho.dbtables.Ho_Cat;
import model.ho.dbtables.Ho_Contact_Info_Type;
import model.ho.dbtables.Ho_House_Parking;
import model.ho.dbtables.Ho_House_Room_Cnt_Filter;
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
  private C_Usr_Repository repository1;

  @Autowired
  private Ho_Build_Type_Repository repb;
  @Autowired
  private Ho_House_Parking_Repository repp;

  @Autowired
  private Ho_Resid_Complex_Repository repj;

  @Autowired
  private Ho_Contact_Info_Type_Repository repc;

  @Autowired
  private C_Tbl_Rec_Corr_By_Name_Repository c_tbl_rec_corr_by_name_repository;

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

}
