package gs.controllers.ho.dbtables;

import gs.payload.request.horequest.SeleniumRequest;
import gs.payload.response.horesponse.HoAdCatResponse;
import gs.repositories.core.dbtables.*;
import gs.repositories.ho.dbtables.*;
import gs.services.ho.Ho_Ad_Service;
import io.swagger.annotations.Api;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Date;
import java.util.List;
import model.core.dbtables.*;
import model.ho.dbtables.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/selenium")
@Api(tags = {"Ho_Ad_Controller"})
public class Selenium {

  @Autowired
  Ho_Ad_Service ho_Ad_Service;
  @Autowired
  Ho_Ad_Repository ho_Ad_repository;
  @Autowired
  private Ho_Contact_Info_Type_Repository repc;
  @Autowired
  private Ho_House_Rent_Period_Repository ho_house_rent_period_repository;
  @Autowired
  private Ho_Ad_Phone_Num_Repository ho_ad_phone_num_repository;
  @Autowired
  private Ho_House_Indus_Base_Type_Repository Ho_House_Indus_Base_Type_Repository;
  @Autowired
  C_Bin_File_Body_Repository c_bin_file_body_repository;
  @Autowired
  C_Img_Repository c_img_repository;
  @Autowired
  C_Tbl_Rec_Img_Moder_Repository c_tbl_rec_img_moder_repository;
  @Autowired
  private C_Loc_Repository c_loc_repository;

  @PostMapping("/prods")
  public void prods(@RequestBody SeleniumRequest seleniumrequest) throws FileNotFoundException, InterruptedException, IOException {
    Ho_Ad ho_ad = new Ho_Ad();
    ho_ad.setLat(seleniumrequest.getLat());
    ho_ad.setLon(seleniumrequest.getLon());
    ho_ad.setRoom_cnt(seleniumrequest.getRoom_cnt());
    String loc = seleniumrequest.getLoc();
    C_Loc c_loc = c_loc_repository.ho_ad_loc(seleniumrequest.getLoc());
    ho_ad.setC_loc(c_loc.getC_loc());
    for (int itip = 0; itip < seleniumrequest.getSidebar().size(); itip++) {
      String tip = seleniumrequest.getSidebar().get(itip);
      String s = seleniumrequest.getSidebar_values().get(itip);
      if (tip.equals("Тип дома")) {
        tipdoma(s, ho_ad);
      } else if (tip.equals("Жилой комплекс")) {
        jilkomp(s, ho_ad);
      } else if (tip.equals("Парковка")) {
        parking(s, ho_ad);
      } else if (tip.equals("Состояние")) {
        condition(s, ho_ad);
      } else if (tip.equals("Этаж")) {
        stage(s, ho_ad);
      } else if (tip.equals("Интернет")) {
        inet(s, ho_ad);
      } else if (tip.equals("Санузел")) {
        bathroom(s, ho_ad);
      } else if (tip.equals("Балкон")) {
        balcony(s, ho_ad);
      } else if (tip.equals("Пол")) {
        floor(s, ho_ad);
      } else if (tip.equals("Мебель")) {
        furniture(s, ho_ad);
      } else if (tip.equals("Телефон")) {
        phone(s, ho_ad);
      } else if (tip.equals("Год постройки")) {
        ho_ad.setConstruction_year(Integer.parseInt(s));
      } else if (tip.equals("Дверь")) {
        door(s, ho_ad);
      }

    }
    List<Ho_Contact_Info_Type> ho_cit = repc.find_all1();
    for (Ho_Contact_Info_Type ho_usr : ho_cit) {
      if (ho_usr.getName().equals(seleniumrequest.getContact())) {
        ho_ad.setHo_contact_info_type(ho_usr.getHo_contact_info_type());
        break;
      }
    }
    for (int itip = 0; itip < seleniumrequest.getOffer_parameters().size(); itip++) {
      String s = seleniumrequest.getOffer_parameters().get(itip);
      String f = seleniumrequest.getOffer_parameters_values().get(itip);
      if (f.equals("В прив. общежитии")) {
        flat_priv_dorm(s, ho_ad);
      } else if (f.equals("Потолки")) {
        ceiling(s, ho_ad);
      } else if (f.equals("Парковка")) {
        parking(s, ho_ad);
      } else if (f.equals("Дверь")) {
        door(s, ho_ad);
      } else if (f.equals("Балкон остеклён")) {
        flat_balcony_g(s, ho_ad);
      } else if (f.equals("Интернет")) {
        inet(s, ho_ad);
      } else if (f.equals("Санузел")) {
        bathroom(s, ho_ad);
      } else if (f.equals("Балкон")) {
        balcony(s, ho_ad);
      } else if (f.equals("Пол")) {
        floor(s, ho_ad);
      } else if (f.equals("Мебель")) {
        furniture(s, ho_ad);
      } else if (f.equals("Телефон")) {
        phone(s, ho_ad);
      }
    }
    Date timestamp = new Date();
    ho_ad.setIns_dt(timestamp);
    ho_ad.setIs_deleted(Boolean.FALSE);
    ho_ad.setC_country(2);
    ho_ad.setIs_agree_with_rules(true);
    ho_ad.setHo_usr(1L);
    ho_ad.setHo_cat(9);
    ho_ad.setHo_ad_status(1);
    ho_Ad_Service.saveOrUpdate(ho_ad);
    try {
      for (int itip = 0; itip < seleniumrequest.getSidebar().size(); itip++) {
        String tip = seleniumrequest.getSidebar().get(itip);
        String s = seleniumrequest.getSidebar_values().get(itip);
        if (tip.equals("Безопасность")) {
          house_security(s, ho_ad);
        }
      }

      for (int itip = 0; itip < seleniumrequest.getOffer_parameters().size(); itip++) {
        String s = seleniumrequest.getOffer_parameters().get(itip);
        String f = seleniumrequest.getOffer_parameters_values().get(itip);
        if (f.equals("Безопасность")) {
          house_security(s, ho_ad);
        }
      }
      C_Bin_File_Body c_Bin_File_Body = new C_Bin_File_Body();
      URL url = new URL(seleniumrequest.getUrl());
      ByteArrayOutputStream baos = new ByteArrayOutputStream();
      InputStream is = null;
      try {
        is = url.openStream();
        byte[] byteChunk = new byte[4096]; // Or whatever size you want to read in at a time.
        int n;
        while ((n = is.read(byteChunk)) > 0) {
          baos.write(byteChunk, 0, n);
        }
      } catch (IOException e) {
      }
      c_Bin_File_Body.setFile_body(baos.toByteArray());
      c_bin_file_body_repository.save(c_Bin_File_Body);
      C_Img c_Img = new C_Img();
      c_Img.setVersion(1);
      c_Img.setIs_deleted(Boolean.FALSE);
      c_Img.setFile_name(seleniumrequest.getFile_name());
      c_Img.setC_bin_file_body(c_Bin_File_Body.getC_bin_file_body());
      c_img_repository.save(c_Img);

      C_Tbl_Rec_Img_Moder c_tbl_rec_img_moder = new C_Tbl_Rec_Img_Moder();
      c_tbl_rec_img_moder.setC_tbl(12);
      c_tbl_rec_img_moder.setRec_id(Long.valueOf(ho_ad.getHo_ad()));
      c_tbl_rec_img_moder.setC_img_kind(1);
      c_tbl_rec_img_moder.setC_img_status(2);
      c_tbl_rec_img_moder.setIs_deleted(Boolean.FALSE);
      c_tbl_rec_img_moder.setC_img(c_Img.getC_img());

      c_tbl_rec_img_moder_repository.save(c_tbl_rec_img_moder);
    } catch (NullPointerException ex) {
    }

    try {
      for (int l = 0; l < seleniumrequest.getUrl_small().size(); l++) {
        String s = seleniumrequest.getUrl_small().get(l);
        String file_name = seleniumrequest.getFile_name_small().get(l);
        C_Bin_File_Body c_Bin_File_Body = new C_Bin_File_Body();
        URL url = new URL(s);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        InputStream is = null;
        try {
          is = url.openStream();
          byte[] byteChunk = new byte[4096]; // Or whatever size you want to read in at a time.
          int n;

          while ((n = is.read(byteChunk)) > 0) {
            baos.write(byteChunk, 0, n);
          }
        } catch (IOException e) {
        }
        c_Bin_File_Body.setFile_body(baos.toByteArray());
        c_bin_file_body_repository.save(c_Bin_File_Body);
        C_Img c_Img = new C_Img();
        c_Img.setVersion(1);
        c_Img.setIs_deleted(Boolean.FALSE);
        c_Img.setFile_name(file_name);
        c_Img.setC_bin_file_body(c_Bin_File_Body.getC_bin_file_body());
        c_img_repository.save(c_Img);

        C_Tbl_Rec_Img_Moder c_tbl_rec_img_moder = new C_Tbl_Rec_Img_Moder();
        c_tbl_rec_img_moder.setC_tbl(12);
        c_tbl_rec_img_moder.setRec_id(Long.valueOf(ho_ad.getHo_ad()));
        c_tbl_rec_img_moder.setC_img_kind(2);
        c_tbl_rec_img_moder.setC_img_status(2);
        c_tbl_rec_img_moder.setIs_deleted(Boolean.FALSE);
        c_tbl_rec_img_moder.setC_img(c_Img.getC_img());

        c_tbl_rec_img_moder_repository.save(c_tbl_rec_img_moder);
      }
      Ho_Ad_Phone_Num ho_ad_phone_num = new Ho_Ad_Phone_Num();
      ho_ad_phone_num.setHo_ad(ho_ad.getHo_ad());
      ho_ad_phone_num.setIs_deleted(Boolean.FALSE);
      ho_ad_phone_num.setPhone_num(seleniumrequest.getPhone());
      ho_ad_phone_num_repository.save(ho_ad_phone_num);
    } catch (NullPointerException ex) {
    }
  }

  public void flat_priv_dorm(String prob, Ho_Ad ho_ad) {
    Boolean trf = false;
    if (prob.equals("да")) {
      trf = true;
    }
    ho_ad.setIs_in_priv_hostel(trf);

  }

  public void is_has_sep_entr_group(String prob, Ho_Ad ho_ad) {
    Boolean trf = false;
    if (prob.equals("есть")) {
      trf = true;
    }
    ho_ad.setIs_in_priv_hostel(trf);

  }

  public void is_exch_possible(String prob, Ho_Ad ho_ad) {
    Boolean trf = false;
    if (prob.equals("Возможен обмен")) {
      trf = true;
    }
    ho_ad.setIs_in_priv_hostel(trf);

  }

  public void is_pledged(String prob, Ho_Ad ho_ad) {
    Boolean trf = false;
    if (prob.equals("да")) {
      trf = true;
    }
    ho_ad.setIs_pledged(trf);

  }

  public void stage(String s, Ho_Ad ho_ad) {
    int k = 0;
    for (int l = 0; l < s.length(); l++) {
      if (s.charAt(l) == ' ') {
        k++;
      }
    }
    if (k > 0) {
      int i = 0;
      String d = "";
      while (true) {
        if (s.charAt(i) == ' ') {

          break;
        }
        d += s.charAt(i);
        i++;
      }
      i = i + 1;
      String area = "";
      while (i < s.length()) {
        if (s.charAt(i) == '0' || s.charAt(i) == '1' || s.charAt(i) == '2' || s.charAt(i) == '3' || s.charAt(i) == '4'
          || s.charAt(i) == '5' || s.charAt(i) == '6' || s.charAt(i) == '7' || s.charAt(i) == '8' || s.charAt(i) == '9') {
          area += s.charAt(i);
        }
        i++;
      }
      ho_ad.setFloor(Integer.parseInt(d));
      ho_ad.setMax_floor(Integer.parseInt(area));
    } else {
      ho_ad.setFloor(Integer.parseInt(s));
      ho_ad.setMax_floor(Integer.parseInt(s));
    }

  }

  public void flat_balcony_g(String prob, Ho_Ad ho_ad) {
    Boolean trf = false;
    if (prob.equals("да")) {
      trf = true;
    }
    ho_ad.setIs_balcony_glazed(trf);

  }

  public void ceiling(String potolok, Ho_Ad ho_ad) {
    String d = "";
    for (int i = 0; i < potolok.length(); i++) {
      if (potolok.charAt(i) == ' ') {
        break;
      }
      d += potolok.charAt(i);
    }

    ho_ad.setCeiling_height(Double.parseDouble(d));

  }
  @Autowired
  private Ho_Build_Type_Repository repb;

  public void tipdoma(String s, Ho_Ad ho_ad) {
    List<Ho_Build_Type> ho_usrs = repb.find_all1();
    for (Ho_Build_Type ho_usr1 : ho_usrs) {

      if (ho_usr1.getName().equals(s)) {

        ho_ad.setHo_build_type(ho_usr1.getHo_build_type());
        break;
      }
    }
  }

  @Autowired
  private C_Land_Area_Unit_Repository C_Land_Area_Unit_Repository;

  public void territory_area_unit(String s, Ho_Ad ho_ad) {
    List<C_Land_Area_Unit> ho_usrs = C_Land_Area_Unit_Repository.find_all1();
    int k7 = 0;
    while (k7 < s.length()) {
      if (s.charAt(k7) == ' ') {
        break;
      }
      k7++;
    }
    k7 = k7 + 1;
    String f = "";
    while (k7 < s.length()) {
      f += s.charAt(k7);
      k7++;
    }
    for (C_Land_Area_Unit ho_usr1 : ho_usrs) {

      if (ho_usr1.getName().equals(f)) {

        ho_ad.setTerritory_area_unit(ho_usr1.getC_land_area_unit());
        break;
      }
    }
  }

  @Autowired
  private Ho_House_Land_Price_Repository Ho_House_Laand_Price_Repository;

  public void land_price(String s, Ho_Ad ho_ad) {
    List<Ho_House_Land_Price> ho_usrs = Ho_House_Laand_Price_Repository.find_all1();
    for (Ho_House_Land_Price ho_usr1 : ho_usrs) {

      if (ho_usr1.getName().equals(s)) {

        ho_ad.setHo_house_land_price(ho_usr1.getHo_house_land_price());
        break;
      }
    }
  }
  @Autowired
  private Ho_House_Spec_Purpose_Repository Ho_House_Spec_Purpose_Repository;

  public void spec_purpose(String s, Ho_Ad ho_ad) {
    List<Ho_House_Spec_Purpose> ho_usrs = Ho_House_Spec_Purpose_Repository.find_all1();
    for (Ho_House_Spec_Purpose ho_usr1 : ho_usrs) {

      if (ho_usr1.getName().equals(s)) {

        ho_ad.setHo_house_spec_purpose(ho_usr1.getHo_house_spec_purpose());
        break;
      }
    }
  }
  @Autowired
  private Ho_House_Office_Type_Repository Ho_House_Office_Type_Repository;

  public void type_office(String s, Ho_Ad ho_ad) {
    List<Ho_House_Office_Type> ho_usrs = Ho_House_Office_Type_Repository.find_all1();
    for (Ho_House_Office_Type ho_usr1 : ho_usrs) {

      if (ho_usr1.getName().equals(s)) {

        ho_ad.setHo_house_office_type(ho_usr1.getHo_house_office_type());
        break;
      }
    }
  }
  @Autowired
  private Ho_House_Sewerage_Repository ho_house_sewerage_repository;

  public void sewerage(String s, Ho_Ad ho_ad) {
    List<Ho_House_Sewerage> ho_usrs = ho_house_sewerage_repository.find_all1();
    for (Ho_House_Sewerage ho_usr1 : ho_usrs) {

      if (ho_usr1.getName().equals(s)) {

        ho_ad.setHo_house_sewerage(ho_usr1.getHo_house_sewerage());
        break;
      }
    }
  }
  @Autowired
  private Ho_House_Shop_Type_Repository Ho_House_Shop_Type_Repository;

  public void shop_type(String s, Ho_Ad ho_ad) {
    List<Ho_House_Shop_Type> ho_usrs = Ho_House_Shop_Type_Repository.find_all1();
    for (Ho_House_Shop_Type ho_usr1 : ho_usrs) {

      if (ho_usr1.getName().equals(s)) {

        ho_ad.setHo_house_shop_type(ho_usr1.getHo_house_shop_type());
        break;
      }
    }
  }
  @Autowired
  private Ho_House_Loc_Repository Ho_House_Loc_Repository;

  public void house_loc(String s, Ho_Ad ho_ad) {
    List<Ho_House_Loc> ho_usrs = Ho_House_Loc_Repository.find_all1();
    for (Ho_House_Loc ho_usr1 : ho_usrs) {

      if (ho_usr1.getName().equals(s)) {

        ho_ad.setHo_house_loc(ho_usr1.getHo_house_loc());
        break;
      }
    }
  }
  @Autowired
  private Ho_Ad_House_Loc_Repository Ho_Ad_House_Loc_Repository;

  public void house_ad_loc(String s, Ho_Ad ho_ad) {
    List<Ho_House_Loc> ho_usrs = Ho_House_Loc_Repository.find_all1();

    s = s + ",";
    int d = 0, k = 0;
    while (k < s.length()) {
      if (s.charAt(k) == ',') {
        d++;
      }
      k++;
    }
    int i = 0;
    for (int j = 0; j < d; j++) {
      Ho_Ad_House_Loc h1 = new Ho_Ad_House_Loc();
      String f = "";
      while (true) {
        if (s.charAt(i) == ',') {
          i = i + 2;
          break;
        }
        f += s.charAt(i);
        i++;
      }
      System.out.println(f);
      for (Ho_House_Loc ho_usr1 : ho_usrs) {

        if (ho_usr1.getName().equals(f)) {
          h1.setHo_ad(ho_ad.getHo_ad());
          h1.setIs_deleted(Boolean.FALSE);
          h1.setHo_house_loc(ho_usr1.getHo_house_loc());
          Ho_Ad_House_Loc_Repository.save(h1);
          break;
        }
      }

    }
  }
  @Autowired
  private Ho_House_Security_Repository Ho_House_Security_Repository;
  @Autowired
  private Ho_Ad_House_Security_Repository Ho_Ad_House_Security_Repository;

  public void house_security(String s, Ho_Ad ho_ad) {
    List<Ho_House_Security> ho_usrs = Ho_House_Security_Repository.find_all1();

    s = s + ",";
    int d = 0, k = 0;
    while (k < s.length()) {
      if (s.charAt(k) == ',') {
        d++;
      }
      k++;
    }
    int i = 0;
    for (int j = 0; j < d; j++) {
      Ho_Ad_House_Security h1 = new Ho_Ad_House_Security();
      String f = "";
      while (true) {
        if (s.charAt(i) == ',') {
          i = i + 2;
          break;
        }
        f += s.charAt(i);
        i++;
      }
      System.out.println(f);
      for (Ho_House_Security ho_usr1 : ho_usrs) {

        if (ho_usr1.getName().equals(f)) {
          h1.setHo_ad(ho_ad.getHo_ad());
          h1.setIs_deleted(Boolean.FALSE);
          h1.setHo_house_security(ho_usr1.getHo_house_security());
          Ho_Ad_House_Security_Repository.save(h1);
          break;
        }
      }
    }
  }
  @Autowired
  private Ho_House_Commun_Repository Ho_House_Commun_Repository;
  @Autowired
  private Ho_Ad_House_Commun_Repository Ho_Ad_House_Commun_Repository;

  public void house_commun(String s, Ho_Ad ho_ad) {
    List<Ho_House_Commun> ho_usrs = Ho_House_Commun_Repository.find_all1();

    s = s + ",";
    int d = 0, k = 0;
    while (k < s.length()) {
      if (s.charAt(k) == ',') {
        d++;
      }
      k++;
    }
    int i = 0;
    for (int j = 0; j < d; j++) {
      Ho_Ad_House_Commun h1 = new Ho_Ad_House_Commun();
      String f = "";
      while (true) {
        if (s.charAt(i) == ',') {
          i = i + 2;
          break;
        }
        f += s.charAt(i);
        i++;
      }
      System.out.println(f);
      for (Ho_House_Commun ho_usr1 : ho_usrs) {

        if (ho_usr1.getName().equals(f)) {
          h1.setHo_ad(ho_ad.getHo_ad());
          h1.setIs_deleted(Boolean.FALSE);
          h1.setHo_house_commun(ho_usr1.getHo_house_commun());
          Ho_Ad_House_Commun_Repository.save(h1);
          break;
        }
      }
    }
  }
  @Autowired
  private Ho_House_Irrigation_Water_Repository Ho_House_Irrigation_Water_Repository;

  public void water(String s, Ho_Ad ho_ad) {
    List<Ho_House_Irrigation_Water> ho_usrs = Ho_House_Irrigation_Water_Repository.find_all1();
    for (Ho_House_Irrigation_Water ho_usr1 : ho_usrs) {

      if (ho_usr1.getName().equals(s)) {

        ho_ad.setHo_house_irrigation_water(ho_usr1.getHo_house_irrigation_water());
        break;
      }
    }
  }
  @Autowired
  private Ho_House_Electricity_Repository ho_house_electricity_repository;

  public void electricity(String s, Ho_Ad ho_ad) {
    List<Ho_House_Electricity> ho_usrs = ho_house_electricity_repository.find_all1();
    for (Ho_House_Electricity ho_usr1 : ho_usrs) {

      if (ho_usr1.getName().equals(s)) {

        ho_ad.setHo_house_electricity(ho_usr1.getHo_house_electricity());
        break;
      }
    }
  }
  @Autowired
  private Ho_House_Heating_Repository Ho_House_Heating_Repository;

  public void heating(String s, Ho_Ad ho_ad) {
    List<Ho_House_Heating> ho_usrs = Ho_House_Heating_Repository.find_all1();
    for (Ho_House_Heating ho_usr1 : ho_usrs) {

      if (ho_usr1.getName().equals(s)) {

        ho_ad.setHo_house_heating(ho_usr1.getHo_house_heating());
        break;
      }
    }
  }
  @Autowired
  private Ho_House_Drink_Water_Repository Ho_House_Drink_Water_Repository;

  public void drink_water(String s, Ho_Ad ho_ad) {
    List<Ho_House_Drink_Water> ho_usrs = Ho_House_Drink_Water_Repository.find_all1();
    for (Ho_House_Drink_Water ho_usr1 : ho_usrs) {

      if (ho_usr1.getName().equals(s)) {

        ho_ad.setHo_house_drink_water(ho_usr1.getHo_house_drink_water());
        break;
      }
    }
  }
  @Autowired
  private Ho_House_Gas_Repository Ho_House_Gas_Repository;

  public void gas(String s, Ho_Ad ho_ad) {
    List<Ho_House_Gas> ho_usrs = Ho_House_Gas_Repository.find_all1();
    for (Ho_House_Gas ho_usr1 : ho_usrs) {

      if (ho_usr1.getName().equals(s)) {

        ho_ad.setHo_house_gas(ho_usr1.getHo_house_gas());
        break;
      }
    }
  }
  @Autowired
  private Ho_Resid_Complex_Repository repj;

  public void jilkomp(String jk, Ho_Ad ho_ad) {
    HoAdCatResponse c_tbl_rec_corr_by_name1 = repj.find_by_name(jk);
    Ho_Resid_Complex ho_rc = new Ho_Resid_Complex();
    if (c_tbl_rec_corr_by_name1 != null) {
      if (c_tbl_rec_corr_by_name1.getName().equals(jk)) {
        ho_ad.setHo_resid_complex(c_tbl_rec_corr_by_name1.getId());
      }
    } else {
      ho_rc.setC_loc(147);
      ho_rc.setName(jk);
      ho_rc.setIs_deleted(false);
      repj.save(ho_rc);
      ho_ad.setHo_resid_complex(ho_rc.getHo_resid_complex());

    }
  }
  @Autowired
  private Ho_House_Parking_Repository repp;

  public void parking(String parking, Ho_Ad ho_ad) {
    List<Ho_House_Parking> ho_prk = repp.find_all1();
    for (Ho_House_Parking ho_usr : ho_prk) {
      if (ho_usr.getName().equals(parking)) {
        ho_ad.setHo_house_parking(ho_usr.getHo_house_parking());
        break;
      }
    }
  }
  @Autowired
  Ho_House_Condition_Repository Ho_House_Condition_Repository;

  public void condition(String parking, Ho_Ad ho_ad) {
    List<Ho_House_Condition> ho_prk = Ho_House_Condition_Repository.find_all1();
    for (Ho_House_Condition ho_usr : ho_prk) {
      if (ho_usr.getName().equals(parking)) {
        ho_ad.setHo_house_condition(ho_usr.getHo_house_condition());
        break;
      }
    }
  }
  @Autowired
  Ho_House_Inet_Repository Ho_House_Inet_Repository;

  public void inet(String parking, Ho_Ad ho_ad) {
    List<Ho_House_Inet> ho_prk = Ho_House_Inet_Repository.find_all1();
    for (Ho_House_Inet ho_usr : ho_prk) {
      if (ho_usr.getName().equals(parking)) {
        ho_ad.setHo_house_inet(ho_usr.getHo_house_inet());
        break;
      }
    }
  }
  @Autowired
  Ho_House_Bathroom_Repository Ho_House_Bathroom_Repository;

  public void bathroom(String parking, Ho_Ad ho_ad) {
    List<Ho_House_Bathroom> ho_prk = Ho_House_Bathroom_Repository.find_all1();
    for (Ho_House_Bathroom ho_usr : ho_prk) {
      if (ho_usr.getName().equals(parking)) {
        ho_ad.setHo_house_bathroom(ho_usr.getHo_house_bathroom());
        break;
      }
    }

  }
  @Autowired
  Ho_House_Balcony_Repository Ho_House_Balcony_Repository;

  public void balcony(String parking, Ho_Ad ho_ad) {
    List<Ho_House_Balcony> ho_prk = Ho_House_Balcony_Repository.find_all1();
    for (Ho_House_Balcony ho_usr : ho_prk) {
      if (ho_usr.getName().equals(parking)) {
        ho_ad.setHo_house_balcony(ho_usr.getHo_house_balcony());
        break;
      }
    }
  }
  @Autowired
  Ho_House_Door_Repository Ho_House_Door_Repository;

  public void door(String parking, Ho_Ad ho_ad) {
    List<Ho_House_Door> ho_prk = Ho_House_Door_Repository.find_all1();
    for (Ho_House_Door ho_usr : ho_prk) {
      if (ho_usr.getName().equals(parking)) {
        ho_ad.setHo_house_door(ho_usr.getHo_house_door());
        break;
      }
    }
  }
  @Autowired
  Ho_House_Floor_Repository Ho_House_Floor_Repository;

  public void floor(String parking, Ho_Ad ho_ad) {
    List<Ho_House_Floor> ho_prk = Ho_House_Floor_Repository.find_all1();
    for (Ho_House_Floor ho_usr : ho_prk) {
      if (ho_usr.getName().equals(parking)) {
        ho_ad.setHo_house_floor(ho_usr.getHo_house_floor());
        break;
      }
    }
  }
  @Autowired
  Ho_House_Furniture_Repository Ho_House_Furniture_Repository;

  public void furniture(String parking, Ho_Ad ho_ad) {
    List<Ho_House_Furniture> ho_prk = Ho_House_Furniture_Repository.find_all1();
    for (Ho_House_Furniture ho_usr : ho_prk) {
      if (ho_usr.getName().equals(parking)) {
        ho_ad.setHo_house_furniture(ho_usr.getHo_house_furniture());
        break;
      }
    }
  }
  @Autowired
  Ho_House_Phone_Repository Ho_House_Phone_Repository;

  public void phone(String parking, Ho_Ad ho_ad) {
    List<Ho_House_Phone> ho_prk = Ho_House_Phone_Repository.find_all1();
    for (Ho_House_Phone ho_usr : ho_prk) {
      if (ho_usr.getName().equals(parking)) {
        ho_ad.setHo_house_phone(ho_usr.getHo_house_phone());
        break;
      }
    }
  }
}
