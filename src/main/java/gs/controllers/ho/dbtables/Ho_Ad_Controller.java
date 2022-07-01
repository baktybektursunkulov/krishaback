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
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
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
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;


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

//  @Autowired
//  Ho_Usr_Service ho_usr_service;
  @PostMapping("/books")
  private Ho_Ad saveBook(@RequestBody Ho_Ad ho_ad) {
    String str = "2018-09-01 09:01:15";
    Timestamp timestamp = Timestamp.valueOf(str);
    ho_ad.setIns_dt(timestamp);
    ho_ad.setIs_deleted(Boolean.FALSE);
    Long kl = 11L;
    Ho_Usr ho_usr = get_ho_usr(kl);
    ho_ad.setHo_usr(ho_usr.getHo_usr());
    return ho_Ad_Service.saveOrUpdate(ho_ad);
  }

  @PostMapping("/parse")
  private Ho_Ad parse(@RequestBody Ho_Ad ho_ad) {
    
    
    
    Date timestamp = new Date();
    ho_ad.setIns_dt(timestamp);
    ho_ad.setIs_deleted(Boolean.FALSE);
    ho_ad.setC_country(3);
    ho_ad.setC_loc(3);
    ho_ad.setIs_agree_with_rules(true);
    ho_ad.setHo_usr(1L);
    ho_ad.setHo_ad_status(1);
//    
//    
    Document doc;
    try {
      doc = (Document) Jsoup.connect("https://krisha.kz/a/show/676830679").get();
      String r = doc.getElementsByClass("offer__advert-title").first().child(0).text();
      String room = r.substring(0, 1);
      ho_ad.setRoom_cnt(Integer.parseInt(room));
      int i = 0;
      while (true) {
        if (r.charAt(i) == ',') {
          break;
        }
        i++;
      }
      i = i + 1;
      String area = "";
      while (true) {
        if (r.charAt(i) == ',') {
          break;
        }
        i++;
        area += r.charAt(i);

      }
      i = i + 1;
      area = area.substring(0, 3);
      ho_ad.setTotal_area(Double.parseDouble(area));

      String floor = "";
      while (true) {
        if (r.charAt(i) == ',') {
          break;
        }
        floor += r.charAt(i);
        i++;
      }
      i = i + 2;
      String max_floor = floor.substring(3, 4);
      floor = floor.substring(1, 2);
      ho_ad.setFloor(Integer.parseInt(floor));
      ho_ad.setMax_floor(Integer.parseInt(max_floor));
      String street = "";
      while (i < r.length()) {
        street += r.charAt(i);
        i++;
      }
      String street_num = street.substring(street.length() - 4, street.length());
      street = street.substring(0, street.length() - 5);

      ho_ad.setStreet_name(street);
      ho_ad.setHouse_num(street_num);
       String kl=doc.getElementsByClass("offer__price").text();
            String kli=kl.substring(0,10);
      int d=0;
            String lk=""; 
            while(d<kli.length()) {
                 if(kli.charAt(d)=='0'||kli.charAt(d)=='1'||kli.charAt(d)=='2'||kli.charAt(d)=='3'||kli.charAt(d)=='4'
                   ||kli.charAt(d)=='5'||kli.charAt(d)=='6'||kli.charAt(d)=='7'||kli.charAt(d)=='8'||kli.charAt(d)=='9')
                   lk+=kli.charAt(d);
                  d++;
                }

       ho_ad.setPrice(Double.valueOf(lk));
      String loc = doc.getElementsByClass("offer__location").first().child(0).text();
      List<C_Tbl_Rec_Corr_By_Name> c_tbl_loc = c_tbl_rec_corr_by_name_repository.find_all1();
      int c_tbl=0;
      for (C_Tbl_Rec_Corr_By_Name ho_usr1 : c_tbl_loc) {
        if (ho_usr1.getName().equals(loc)) {
          c_tbl+=1;
          ho_ad.setC_loc(ho_usr1.getRec_id().intValue());

        } 
      }
      C_Tbl_Rec_Corr_By_Name c_tbl_rec_corr_by_name=new C_Tbl_Rec_Corr_By_Name();
      if(c_tbl==0){
          c_tbl_rec_corr_by_name.setC_tbl(24);
          c_tbl_rec_corr_by_name.setName(loc);
          c_tbl_rec_corr_by_name.setRec_id(147L);
          c_tbl_rec_corr_by_name.setIs_deleted(false);
          c_tbl_rec_corr_by_name_repository.save(c_tbl_rec_corr_by_name);
          ho_ad.setC_loc(c_tbl_rec_corr_by_name.getRec_id().intValue());
        }
      Elements inputElements = doc.getElementsByClass("offer__advert-short-info");
      int h = 0;
      for (Element inputElement : inputElements) {
        if (h == 1) {
          String s = inputElement.text();

          List<Ho_Build_Type> ho_usrs = repb.find_all1();
          for (Ho_Build_Type ho_usr1 : ho_usrs) {

            if (ho_usr1.getName().equals(s)) {

              ho_ad.setHo_build_type(ho_usr1.getHo_build_type());
              break;
            }
          }
        }
        if (h == 4) {
          String jk = inputElement.text();
          List<Ho_Resid_Complex> ho_jk = repj.find_all1();
          int rc = 0;
          for (Ho_Resid_Complex ho_usr : ho_jk) {
            if (ho_usr.getName().equals(jk)) {
              rc += 1;
              ho_ad.setHo_resid_complex(ho_usr.getHo_resid_complex());
              break;
            }
          }
          System.out.println("Baktybek" + rc);
          Ho_Resid_Complex ho_rc = new Ho_Resid_Complex();
          if (rc == 0) {
            ho_rc.setC_loc(147);

            ho_rc.setName(jk);
            ho_rc.setIs_deleted(false);
            repj.save(ho_rc);
            ho_ad.setHo_resid_complex(ho_rc.getHo_resid_complex());

          }
        }
        if(h==5){
           ho_ad.setConstruction_year(Integer.parseInt(inputElement.text()));
        }
        if(h==6){
           String parking=inputElement.text();
        List<Ho_House_Parking> ho_prk=repp.find_all1();
        for (Ho_House_Parking ho_usr : ho_prk) {
         if(ho_usr.getName().equals(parking)){
            ho_ad.setHo_house_parking(ho_usr.getHo_house_parking());
            break;
         }
        }
        }

        h++;
      }
        String contact=doc.getElementsByClass("label-user-identified-specialist").first().text();
        System.out.println(contact);
        List<Ho_Contact_Info_Type> ho_cit=repc.find_all1();
        for (Ho_Contact_Info_Type ho_usr : ho_cit) {
         if(ho_usr.getName().equals(contact)){
            ho_ad.setHo_contact_info_type(ho_usr.getHo_contact_info_type());
            break;
         }
        }
        String potolok=doc.getElementsByClass("offer__parameters").first().child(0).child(1).text();
        potolok = potolok.substring(0,3);
        ho_ad.setCeiling_height(Double.parseDouble(potolok));
                String prob=doc.getElementsByClass("offer__parameters").first().child(1).child(1).text();
                Boolean trf=false;
                if(prob.equals("да"))trf=true;
                ho_ad.setIs_in_priv_hostel(trf);
                ho_ad.setTxt(doc.getElementsByClass("a-text").first().text()); 

    } catch (IOException ex) {
      System.out.println("Error NUll");
    }
//      
     
//
    return ho_Ad_Service.saveOrUpdate(ho_ad);

  }

  @GetMapping("/parse1")
  public void Parse() { 
    
    Document doc;
    System.setProperty("webdriver.chrome.driver","C:\\projects\\qo-core-back\\src\\main\\java\\chromedriver_win32(1)\\chromedriver.exe");
//
        WebDriver webdriver=new ChromeDriver();
//        webdriver.get("https://krisha.kz/a/show/676830679");
//        System.out.print(webdriver.getTitle());

//
//        WebElement webElement=webdriver.findElement(By.className("show-phones"));
//        System.out.println(webElement);
//        webElement.click();
//        Document document= Jsoup.parse(webdriver.getPageSource());
//        System.out.println(document.getElementsByClass("offer__contacts-phones").first().child(0).text());
//        System.out.println(document.getElementsByClass("offer__contacts-phones").first().child(1).text());
//    System.out.print(firefoxDriver.getTitle());
//
//
//    WebElement webElement=firefoxDriver.findElement(By.className("show-phones"));
//    System.out.println(webElement);
//    webElement.click();
//    Document document= Jsoup.parse(firefoxDriver.getPageSource());
//    System.out.println(document.getElementsByClass("offer__contacts-phones").first().child(0).text());
//    System.out.println(document.getElementsByClass("offer__contacts-phones").first().child(1).text());
//  
    //driver.quit();
       
//        FirefoxDriver firefoxDriver=new FirefoxDriver();
//         firefoxDriver.get("https://krisha.kz/a/show/676830679");
//      System.out.print(firefoxDriver.getTitle());
//
//
//        WebElement webElement=firefoxDriver.findElementByClassName("show-phones");
//        System.out.println(webElement);
//        webElement.click();
//        Document document= Jsoup.parse(firefoxDriver.getPageSource());
//        System.out.println(document.getElementsByClass("offer__contacts-phones").first().child(0).text());
//        System.out.println(document.getElementsByClass("offer__contacts-phones").first().child(1).text());
    try {
      doc = Jsoup.connect("https://krisha.kz/a/show/676830679").get();
                         
                 
           
            
    } catch (IOException ex) {
      System.out.println("Error Null");
    }

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
