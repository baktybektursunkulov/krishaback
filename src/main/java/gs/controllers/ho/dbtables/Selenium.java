package gs.controllers.ho.dbtables;

import gs.payload.response.horesponse.HoAdCatResponse;
import gs.payload.response.horesponse.HoPhoneResponse;
import gs.repositories.core.dbtables.C_Bin_File_Body_Repository;
import gs.repositories.core.dbtables.C_Img_Repository;
import gs.repositories.core.dbtables.C_Land_Area_Unit_Repository;
import gs.repositories.core.dbtables.C_Tbl_Rec_Corr_By_Name_Repository;
import gs.repositories.core.dbtables.C_Tbl_Rec_Img_Moder_Repository;
import gs.repositories.core.dbtables.C_Usr_Repository;
import gs.repositories.ho.dbtables.Ho_Ad_House_Commun_Repository;
import gs.repositories.ho.dbtables.Ho_Ad_House_Loc_Repository;
import gs.repositories.ho.dbtables.Ho_Ad_House_Security_Repository;
import gs.repositories.ho.dbtables.Ho_Ad_Phone_Num_Repository;
import gs.repositories.ho.dbtables.Ho_Ad_Repository;
import gs.repositories.ho.dbtables.Ho_Build_Type_Repository;
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
import gs.services.ho.Ho_Ad_Service;
import io.swagger.annotations.Api;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import javax.imageio.ImageIO;
import model.core.dbtables.C_Bin_File_Body;
import model.core.dbtables.C_Img;
import model.core.dbtables.C_Land_Area_Unit;
import model.core.dbtables.C_Tbl_Rec_Corr_By_Name;
import model.core.dbtables.C_Tbl_Rec_Img_Moder;
import model.ho.dbtables.Ho_Ad;
import model.ho.dbtables.Ho_Ad_House_Commun;
import model.ho.dbtables.Ho_Ad_House_Loc;
import model.ho.dbtables.Ho_Ad_House_Security;
import model.ho.dbtables.Ho_Ad_Phone_Num;
import model.ho.dbtables.Ho_Build_Type;
import model.ho.dbtables.Ho_Contact_Info_Type;
import model.ho.dbtables.Ho_House_Balcony;
import model.ho.dbtables.Ho_House_Bathroom;
import model.ho.dbtables.Ho_House_Commun;
import model.ho.dbtables.Ho_House_Condition;
import model.ho.dbtables.Ho_House_Door;
import model.ho.dbtables.Ho_House_Drink_Water;
import model.ho.dbtables.Ho_House_Electricity;
import model.ho.dbtables.Ho_House_Floor;
import model.ho.dbtables.Ho_House_Furniture;
import model.ho.dbtables.Ho_House_Gas;
import model.ho.dbtables.Ho_House_Heating;
import model.ho.dbtables.Ho_House_Indus_Base_Type;
import model.ho.dbtables.Ho_House_Inet;
import model.ho.dbtables.Ho_House_Irrigation_Water;
import model.ho.dbtables.Ho_House_Land_Price;
import model.ho.dbtables.Ho_House_Loc;
import model.ho.dbtables.Ho_House_Office_Type;
import model.ho.dbtables.Ho_House_Parking;
import model.ho.dbtables.Ho_House_Phone;
import model.ho.dbtables.Ho_House_Rent_Period;
import model.ho.dbtables.Ho_House_Security;
import model.ho.dbtables.Ho_House_Sewerage;
import model.ho.dbtables.Ho_House_Shop_Type;
import model.ho.dbtables.Ho_House_Spec_Purpose;
import model.ho.dbtables.Ho_Resid_Complex;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
  private Ho_Usr_Repository repository;
  @Autowired
  private C_Usr_Repository repository1;
  @Autowired
  private Ho_Contact_Info_Type_Repository repc;
  @Autowired
  private Ho_House_Rent_Period_Repository ho_house_rent_period_repository;
  @Autowired
  private C_Tbl_Rec_Corr_By_Name_Repository c_tbl_rec_corr_by_name_repository;
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

//  @PutMapping("/update_ho_ad")
//  private void update(@RequestBody Ho_Ad ho_ad) throws FileNotFoundException, InterruptedException, InterruptedException {
//    File file = new File("C:\\Users\\User\\Downloads\\demo\\parse");
//     List<Integer> ho_ad1 = ho_Ad_Service.find_all();
//    Scanner scanner = new Scanner(file);
//    int j = 0;
//    System.out.println(scanner.nextLine());
//    List<Ho_Ad> ho_add=ho_Ad_repository.find();
//    while (scanner.hasNextLine()) {
//      String stringt = scanner.nextLine();
//      Document doc;
//        try {
//        doc = (Document) Jsoup.connect(stringt).get();
//        Thread.sleep(2000);
//        ho_ad.setHo_ad(ho_ad1.get(j));
//          Date timestamp = new Date();
//          ho_ad.setIns_dt(timestamp);
//          ho_ad.setIs_deleted(Boolean.FALSE);
//          ho_ad.setIs_agree_with_rules(true);
//          ho_ad.setHo_usr(1L);
//          ho_ad.setHo_cat(20);
//          ho_ad.setHo_ad_status(1);
//          ho_ad.setHo_house_rent_period(ho_add.get(j).getHo_house_rent_period());
//          ho_ad.setLat(ho_add.get(j).getLat());
//        ho_ad.setLon(ho_add.get(j).getLon());
//        ho_ad.setRoom_cnt(ho_add.get(j).getRoom_cnt());
//        ho_ad.setPrice(ho_add.get(j).getPrice());
//        ho_ad.setHo_build_type(ho_add.get(j).getHo_build_type());
//        ho_ad.setConstruction_year(ho_add.get(j).getConstruction_year());
//        ho_ad.setFloor(ho_add.get(j).getFloor());
//        ho_ad.setMax_floor(ho_add.get(j).getMax_floor());
//        ho_ad.setTotal_area(ho_add.get(j).getTotal_area());
//        ho_ad.setIs_in_priv_hostel(ho_add.get(j).getIs_in_priv_hostel());
//        ho_ad.setC_loc(ho_add.get(j).getC_loc());
//        ho_ad.setHo_resid_complex(ho_add.get(j).getHo_resid_complex());
//        ho_ad.setStreet_name(ho_add.get(j).getStreet_name());
//        ho_ad.setCeiling_height(ho_add.get(j).getCeiling_height());
//        ho_ad.setTxt(ho_add.get(j).getTxt());
//        ho_ad.setHo_contact_info_type(ho_add.get(j).getHo_contact_info_type());
//        Elements inputElements = doc.getElementsByClass("offer__advert-short-info");
//
//        Elements elements = doc.getElementsByClass("offer__info-title");
//        String[] s_elem = new String[elements.size()];
//        int iterator = 0;
//        for (Element inElement : elements) {
//          s_elem[iterator] = inElement.text();
//          iterator++;
//        }
//        int iteratorx = 0;
//        String[] s_elemx = new String[elements.size()];
//        for (Element inputElement : inputElements) {
//          s_elemx[iteratorx] = inputElement.text();
//          iteratorx++;
//        }
//        System.out.println("Tip doma");
//        for (int itip = 0; itip < elements.size(); itip++) {
//          String tip = s_elem[itip];
//          System.out.println(itip);
//          if (tip.equals("Город")) {
//            continue;
//          }
//          String s = s_elemx[itip];
//
//          if (tip.equals("Тип дома")) {
//            tipdoma(s, ho_ad);
//          } else if (tip.equals("Жилой комплекс")) {
//            jilkomp(s, ho_ad);
//          } else if (tip.equals("Парковка")) {
//            parking(s, ho_ad);
//          } else if (tip.equals("Состояние")) {
//            condition(s, ho_ad);
//          } else if (tip.equals("Этаж")) {
//            stage(s, ho_ad);
//          } else if (tip.equals("Интернет")) {
//            inet(s, ho_ad);
//          } else if (tip.equals("Санузел")) {
//            bathroom(s, ho_ad);
//          } else if (tip.equals("Балкон")) {
//            balcony(s, ho_ad);
//          } else if (tip.equals("Пол")) {
//            floor(s, ho_ad);
//          } else if (tip.equals("Мебель")) {
//            furniture(s, ho_ad);
//          } else if (tip.equals("Телефон")) {
//            phone(s, ho_ad);
//          } else if (tip.equals("Год постройки")) {
//            ho_ad.setConstruction_year(Integer.parseInt(s));
//          } else if (tip.equals("Дверь")) {
//            door(s, ho_ad);
//          }
//
//        }
//        System.out.println("god postroikiy");
//        Elements elementsClient = doc.getElementsByTag("dd");
//        Elements elementss = doc.getElementsByTag("dt");
//        String[] offer = new String[elementsClient.size()];
//        int i_offer = 0;
//        for (Element offerElement : elementsClient) {
//          offer[i_offer] = offerElement.text();
//          i_offer++;
//        }
//        int i_offerx = 0;
//        String[] offerx = new String[elementsClient.size()];
//        for (Element offerxElement : elementss) {
//          offerx[i_offerx] = offerxElement.text();
//          i_offerx++;
//        }
//        for (int itip = 0; itip < elementsClient.size(); itip++) {
//          String s = offer[itip];
//          String f = offerx[itip];
//          if (f.equals("В прив. общежитии")) {
//            flat_priv_dorm(s, ho_ad);
//          } else if (f.equals("Потолки")) {
//            ceiling(s, ho_ad);
//          } else if (f.equals("Парковка")) {
//            parking(s, ho_ad);
//          } else if (f.equals("Балкон остеклён")) {
//            flat_balcony_g(s, ho_ad);
//          } else if (f.equals("Интернет")) {
//            inet(s, ho_ad);
//          } else if (f.equals("Санузел")) {
//            bathroom(s, ho_ad);
//          } else if (f.equals("Балкон")) {
//            balcony(s, ho_ad);
//          } else if (f.equals("Пол")) {
//            floor(s, ho_ad);
//          } else if (f.equals("Мебель")) {
//            furniture(s, ho_ad);
//          } else if (f.equals("Телефон")) {
//            phone(s, ho_ad);
//          } else if (f.equals("Дверь")) {
//            door(s, ho_ad);
//
//          }
//        }
//        System.out.println("text");
//        ho_Ad_Service.saveOrUpdate(ho_ad);
//        }catch (IOException ex) {
//      continue;
//    }
//    
//    j++;
//    }
//   
//    
//  }
//
  @GetMapping("/phone")
  public void phone() throws FileNotFoundException {
    List<Integer> ho_ad1 = ho_Ad_Service.find_all();
    String separator = File.separator;
    File file = new File("C:\\Users\\User\\Downloads\\demo\\Phone");
    Scanner scanner = new Scanner(file);
    int i = 0;

    while (scanner.hasNextLine()) {
      Ho_Ad ho_ad = new Ho_Ad();
      Ho_Ad_Phone_Num ho_ad_phone_num = new Ho_Ad_Phone_Num();
      String stringt = scanner.nextLine();
      ho_ad_phone_num.setHo_ad(ho_ad1.get(i));
      ho_ad_phone_num.setIs_deleted(Boolean.FALSE);
      if (stringt == "") stringt="87789477600";
        ho_ad_phone_num.setPhone_num(stringt);
      ho_ad_phone_num_repository.save(ho_ad_phone_num);
      i++;
    }

  }

  @GetMapping("/loc")
  public void loc() throws InterruptedException, FileNotFoundException, IOException {
    String separator = File.separator;
    File file = new File("C:\\Users\\User\\Downloads\\demo\\parse");
    Scanner scanner = new Scanner(file);
    int has = 0;
    while (scanner.hasNextLine()) {

      String stringt = scanner.nextLine();
      Document doc;
      // try {
      try {
        doc = (Document) Jsoup.connect(stringt).get();
        Thread.sleep(2000);
        String loc = doc.getElementsByClass("offer__location").first().child(0).text();
        HoAdCatResponse c_tbl_rec_corr_by_name1 = c_tbl_rec_corr_by_name_repository.find_by_name(loc);
        C_Tbl_Rec_Corr_By_Name c_tbl_rec_corr_by_name = new C_Tbl_Rec_Corr_By_Name();
        if (c_tbl_rec_corr_by_name1 != null) {
          if (c_tbl_rec_corr_by_name1.getName().equals(loc)) {
            System.out.println("yes");
          }
        } else {
          c_tbl_rec_corr_by_name.setC_tbl(24);
          c_tbl_rec_corr_by_name.setName(loc);
          c_tbl_rec_corr_by_name.setRec_id(147L);
          c_tbl_rec_corr_by_name.setIs_deleted(false);
          c_tbl_rec_corr_by_name_repository.save(c_tbl_rec_corr_by_name);

        }
      } catch (MalformedURLException en) {
        continue;
      }
//    }catch (IOException ex) {
//      continue;
//    }
      has++;
      System.out.println(has);
    }
  }

  @GetMapping("/kvartiry")
  public void kvartiry() throws FileNotFoundException, InterruptedException, IOException {

    String separator = File.separator;
    File file = new File("C:\\Users\\User\\Downloads\\demo\\parse");
    Scanner scanner = new Scanner(file);
    int has = 0;
    while (scanner.hasNextLine()) {
      Thread.sleep(2000);
      Ho_Ad ho_ad = new Ho_Ad();

      String stringt = scanner.nextLine();

      Date timestamp = new Date();
      ho_ad.setIns_dt(timestamp);
      ho_ad.setIs_deleted(Boolean.FALSE);
      ho_ad.setC_country(2);
      ho_ad.setIs_agree_with_rules(true);
      ho_ad.setHo_usr(1L);
      ho_ad.setHo_cat(20);
      ho_ad.setHo_ad_status(1);
      Document doc;
      try {
        doc = (Document) Jsoup.connect(stringt).get();
        Thread.sleep(2000);
        Element element = doc.getElementById("jsdata");
        String kord = String.valueOf(element);
        String k = "";
        int d2 = 0;
        for (int i = 0; i < kord.length(); i++) {
          if (kord.charAt(i) == '"' && kord.charAt(i + 1) == 'l' && kord.charAt(i + 2) == 'a' && kord.charAt(i + 3) == 't' && kord.charAt(i + 4) == '"') {
            d2 = i + 6;
          }
        }
        for (int i = d2; i < kord.length(); i++) {
          if (kord.charAt(i) == ',') {
            break;
          }
          k += kord.charAt(i);
        }
        String k1 = "";
        int d1 = 0;
        for (int i = 0; i < kord.length(); i++) {
          if (kord.charAt(i) == '"' && kord.charAt(i + 1) == 'l' && kord.charAt(i + 2) == 'o' && kord.charAt(i + 3) == 'n' && kord.charAt(i + 4) == '"') {
            d1 = i + 6;
          }
        }
        for (int i = d1; i < kord.length(); i++) {
          if (kord.charAt(i) == ',') {
            break;
          }
          k1 += kord.charAt(i);
        }
        ho_ad.setLat(Double.parseDouble(k));
        ho_ad.setLon(Double.parseDouble(k1));
        String r = doc.getElementsByClass("offer__advert-title").first().child(0).text();
        String room = r.substring(0, 1);
        System.out.println(r);
        System.out.println(room);
        int utirr = 0;
        int utir = 0;
        while (utir < r.length()) {
          if (r.charAt(utir) == ',') {
            utirr++;
          }
          utir++;
        }
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
        System.out.println(area);
        ho_ad.setTotal_area(Double.parseDouble(area));
        System.out.println("kl;j;lkjl;kjl;k");
        if (utirr == 3) {
          String floor = "";
          while (true) {
            if (r.charAt(i) == ',') {
              break;
            }
            floor += r.charAt(i);
            i++;
          }
          i = i + 2;

          int d23 = 0;
          for (int is = 0; is < floor.length(); is++) {
            if (floor.charAt(is) == 'э' && floor.charAt(is + 1) == 'т' && floor.charAt(is + 2) == 'а' && floor.charAt(is + 3) == 'ж') {
              d23 = is + 5;
            }
          }
          String k23 = "";
          System.out.println(d23);
          for (int is = d23; is < floor.length(); is++) {
            if (floor.charAt(is) == ',') {
              break;
            }
            k23 += floor.charAt(is);
          }
          System.out.println(k23);
          List<Ho_House_Rent_Period> ho_usrs = ho_house_rent_period_repository.find_all1();
          for (Ho_House_Rent_Period ho_usr1 : ho_usrs) {
            System.out.println(ho_usr1.getName().equals(k23));
            if (ho_usr1.getName().equals(k23)) {
              ho_ad.setHo_house_rent_period(ho_usr1.getHo_house_rent_period());
              break;
            }
          }
        }
        String street = "";
        while (i < r.length()) {
          street += r.charAt(i);
          i++;
        }
        String street_num = street.substring(street.length() - 4, street.length());
        ho_ad.setStreet_name(street);
        System.out.println("ioipoipoipo");
        String kl = doc.getElementsByClass("offer__price").text();
        String kli = kl;
        int d = 0;
        String lk = "";
        while (d < kli.length()) {
          if (kli.charAt(d) == '0' || kli.charAt(d) == '1' || kli.charAt(d) == '2' || kli.charAt(d) == '3' || kli.charAt(d) == '4'
            || kli.charAt(d) == '5' || kli.charAt(d) == '6' || kli.charAt(d) == '7' || kli.charAt(d) == '8' || kli.charAt(d) == '9') {
            lk += kli.charAt(d);
          }
          d++;
        }

        ho_ad.setPrice(Double.valueOf(lk));

        String loc = doc.getElementsByClass("offer__location").first().child(0).text();
        HoAdCatResponse c_tbl_rec_corr_by_name1 = c_tbl_rec_corr_by_name_repository.find_by_name(loc);
        C_Tbl_Rec_Corr_By_Name c_tbl_rec_corr_by_name = new C_Tbl_Rec_Corr_By_Name();
        if (c_tbl_rec_corr_by_name1 != null) {
          if (c_tbl_rec_corr_by_name1.getName().equals(loc)) {
            ho_ad.setC_loc(c_tbl_rec_corr_by_name1.getId());
          }
        } else {
          c_tbl_rec_corr_by_name.setC_tbl(24);
          c_tbl_rec_corr_by_name.setName(loc);
          c_tbl_rec_corr_by_name.setRec_id(147L);
          c_tbl_rec_corr_by_name.setIs_deleted(false);
          c_tbl_rec_corr_by_name_repository.save(c_tbl_rec_corr_by_name);
          ho_ad.setC_loc(c_tbl_rec_corr_by_name.getRec_id().intValue());
        }
        try {
          ho_ad.setTxt(doc.getElementsByClass("a-text").first().text());
        } catch (NullPointerException e) {
          System.out.println("jkljkl");
        }
        Elements inputElements = doc.getElementsByClass("offer__advert-short-info");

        Elements elements = doc.getElementsByClass("offer__info-title");
        String[] s_elem = new String[elements.size()];
        int iterator = 0;
        for (Element inElement : elements) {
          s_elem[iterator] = inElement.text();
          iterator++;
        }
        int iteratorx = 0;
        String[] s_elemx = new String[elements.size()];
        for (Element inputElement : inputElements) {
          s_elemx[iteratorx] = inputElement.text();
          iteratorx++;
        }
        System.out.println("Tip doma");
        for (int itip = 0; itip < elements.size(); itip++) {
          String tip = s_elem[itip];
          System.out.println(itip);
          if (tip.equals("Город")) {
            continue;
          }
          String s = s_elemx[itip];

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
        System.out.println("god postroikiy");
        try {
          String contact = doc.getElementsByClass("label-user-identified-specialist").first().text();
          System.out.println(contact);
          List<Ho_Contact_Info_Type> ho_cit = repc.find_all1();
          for (Ho_Contact_Info_Type ho_usr : ho_cit) {
            if (ho_usr.getName().equals(contact)) {
              ho_ad.setHo_contact_info_type(ho_usr.getHo_contact_info_type());
              break;
            }
          }
        } catch (NullPointerException e) {
          try {
            String contact = doc.getElementsByClass("builder__contacts").text();
            System.out.println(contact);
            List<Ho_Contact_Info_Type> ho_cit = repc.find_all1();
            for (Ho_Contact_Info_Type ho_usr : ho_cit) {
              if (ho_usr.getName().equals(contact)) {
                ho_ad.setHo_contact_info_type(ho_usr.getHo_contact_info_type());
                break;
              }
            }
          } catch (NullPointerException ex) {

            try {
              String contact = doc.getElementsByClass("owners__label owners__label--default label-user-agent").first().text();
              System.out.println(contact);
              List<Ho_Contact_Info_Type> ho_cit = repc.find_all1();
              for (Ho_Contact_Info_Type ho_usr : ho_cit) {
                if (ho_usr.getName().equals(contact)) {
                  ho_ad.setHo_contact_info_type(ho_usr.getHo_contact_info_type());
                  break;
                }
              }
            } catch (NullPointerException exp) {
              String contact = doc.getElementsByClass("owners__name owners__name--large").text();
              System.out.println(contact);
              List<Ho_Contact_Info_Type> ho_cit = repc.find_all1();
              for (Ho_Contact_Info_Type ho_usr : ho_cit) {
                if (ho_usr.getName().equals(contact)) {
                  ho_ad.setHo_contact_info_type(ho_usr.getHo_contact_info_type());
                  break;
                }
              }

            }
          }
        }

        System.out.println("kljhjklhkjhk");
        Elements elementsClient = doc.getElementsByTag("dd");

        Elements elementss = doc.getElementsByTag("dt");
        String[] offer = new String[elementsClient.size()];
        int i_offer = 0;
        for (Element offerElement : elementsClient) {
          offer[i_offer] = offerElement.text();
          i_offer++;
        }
        int i_offerx = 0;
        String[] offerx = new String[elementsClient.size()];
        for (Element offerxElement : elementss) {
          offerx[i_offerx] = offerxElement.text();
          i_offerx++;
        }
        for (int itip = 0; itip < elementsClient.size(); itip++) {
          String s = offer[itip];
          String f = offerx[itip];
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
          } else if (f.equals("Дверь")) {
            door(s, ho_ad);

          }
        }
        System.out.println("text");

      } catch (IOException ex) {
        continue;
      }
      System.out.println(has);
      has++;
      ho_Ad_Service.saveOrUpdate(ho_ad);
    }
  }

  @GetMapping("/dom")
  public void dom() throws FileNotFoundException, InterruptedException, IOException {

    String separator = File.separator;
    File file = new File("C:\\Users\\User\\Downloads\\demo\\parse");
    Scanner scanner = new Scanner(file);
    int has = 0;
    while (scanner.hasNextLine()) {
      Thread.sleep(2000);
      Ho_Ad ho_ad = new Ho_Ad();

      String stringt = scanner.nextLine();

      Date timestamp = new Date();
      ho_ad.setIns_dt(timestamp);
      ho_ad.setIs_deleted(Boolean.FALSE);
      ho_ad.setC_country(2);
      ho_ad.setIs_agree_with_rules(true);
      ho_ad.setHo_usr(1L);
      ho_ad.setHo_cat(21);
      ho_ad.setHo_ad_status(1);
      Document doc;
      try {
        doc = (Document) Jsoup.connect(stringt).get();
        Thread.sleep(2000);
        Element element = doc.getElementById("jsdata");
        String kord = String.valueOf(element);
        String k = "";
        int d2 = 0;
        for (int i = 0; i < kord.length(); i++) {
          if (kord.charAt(i) == '"' && kord.charAt(i + 1) == 'l' && kord.charAt(i + 2) == 'a' && kord.charAt(i + 3) == 't' && kord.charAt(i + 4) == '"') {
            d2 = i + 6;
          }
        }
        for (int i = d2; i < kord.length(); i++) {
          if (kord.charAt(i) == ',') {
            break;
          }
          k += kord.charAt(i);
        }
        String k1 = "";
        int d1 = 0;
        for (int i = 0; i < kord.length(); i++) {
          if (kord.charAt(i) == '"' && kord.charAt(i + 1) == 'l' && kord.charAt(i + 2) == 'o' && kord.charAt(i + 3) == 'n' && kord.charAt(i + 4) == '"') {
            d1 = i + 6;
          }
        }
        for (int i = d1; i < kord.length(); i++) {
          if (kord.charAt(i) == ',') {
            break;
          }
          k1 += kord.charAt(i);
        }
        ho_ad.setLat(Double.parseDouble(k));
        ho_ad.setLon(Double.parseDouble(k1));
        System.out.println("test");
        String r = doc.getElementsByClass("offer__advert-title").first().child(0).text();
        System.out.println("tset");

        int d23 = 0;
        for (int is = 0; is < r.length(); is++) {
          if (r.charAt(is) == ' ' && r.charAt(is + 1) == 'д' && r.charAt(is + 2) == 'о' && r.charAt(is + 3) == 'м' && r.charAt(is + 4) == ' ') {
            d23 = is + 5;
            break;
          }
        }
        String k23 = "";
        System.out.println(d23);
        for (int is = d23; is < r.length(); is++) {
          if (r.charAt(is) == ',') {
            break;
          }
          k23 += r.charAt(is);
        }
        System.out.println(k23);
        List<Ho_House_Rent_Period> ho_usrs = ho_house_rent_period_repository.find_all1();
        for (Ho_House_Rent_Period ho_usr1 : ho_usrs) {
          System.out.println(ho_usr1.getName().equals(k23));
          if (ho_usr1.getName().equals(k23)) {
            ho_ad.setHo_house_rent_period(ho_usr1.getHo_house_rent_period());
            break;
          }
        }
        String room = "";
        for (int i = 0; i < r.length(); i++) {
          if (r.charAt(i) == '-') {
            break;
          }
          room += r.charAt(i);
        }

        System.out.println(r);
        System.out.println(room);
        int utirr = 0;
        int utir = 0;
        while (utir < r.length()) {
          if (r.charAt(utir) == ',') {
            utirr++;
          }
          utir++;
        }
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
        String land_area = "";
        for (int l = 0; l < area.length(); l++) {
          if (area.charAt(l) == ' ') {
            break;
          }
          land_area += area.charAt(l);
        }
        System.out.println(area);
        ho_ad.setTotal_area(Double.parseDouble(land_area));
        System.out.println("kl;j;lkjl;kjl;k");

        if (utirr == 3) {
          String floor = "";
          while (true) {
            if (r.charAt(i) == ',') {
              break;
            }
            floor += r.charAt(i);
            i++;
          }
          i = i + 2;

        }
        String street = "";
        while (i < r.length()) {
          street += r.charAt(i);
          i++;
        }
        //  String street_num = street.substring(street.length() - 4, street.length());
        ho_ad.setStreet_name(street);
        System.out.println("ioipoipoipo");
        String kl = doc.getElementsByClass("offer__price").text();
        String kli = kl;
        int d = 0;
        String lk = "";
        while (d < kli.length()) {
          if (kli.charAt(d) == '0' || kli.charAt(d) == '1' || kli.charAt(d) == '2' || kli.charAt(d) == '3' || kli.charAt(d) == '4'
            || kli.charAt(d) == '5' || kli.charAt(d) == '6' || kli.charAt(d) == '7' || kli.charAt(d) == '8' || kli.charAt(d) == '9') {
            lk += kli.charAt(d);
          }
          d++;
        }

        ho_ad.setPrice(Double.valueOf(lk));

        String loc = doc.getElementsByClass("offer__location").first().child(0).text();
        HoAdCatResponse c_tbl_rec_corr_by_name1 = c_tbl_rec_corr_by_name_repository.find_by_name(loc);
        C_Tbl_Rec_Corr_By_Name c_tbl_rec_corr_by_name = new C_Tbl_Rec_Corr_By_Name();
        if (c_tbl_rec_corr_by_name1 != null) {
          if (c_tbl_rec_corr_by_name1.getName().equals(loc)) {
            ho_ad.setC_loc(c_tbl_rec_corr_by_name1.getId());
          }
        } else {
          c_tbl_rec_corr_by_name.setC_tbl(24);
          c_tbl_rec_corr_by_name.setName(loc);
          c_tbl_rec_corr_by_name.setRec_id(147L);
          c_tbl_rec_corr_by_name.setIs_deleted(false);
          c_tbl_rec_corr_by_name_repository.save(c_tbl_rec_corr_by_name);
          ho_ad.setC_loc(c_tbl_rec_corr_by_name.getRec_id().intValue());
        }
        try {
          ho_ad.setTxt(doc.getElementsByClass("a-text").first().text());
        } catch (NullPointerException e) {
          System.out.println("jkljkl");
        }
        Elements inputElements = doc.getElementsByClass("offer__advert-short-info");

        Elements elements = doc.getElementsByClass("offer__info-title");
        String[] s_elem = new String[elements.size()];
        int iterator = 0;
        for (Element inElement : elements) {
          s_elem[iterator] = inElement.text();
          iterator++;
        }
        int iteratorx = 0;
        String[] s_elemx = new String[elements.size()];
        for (Element inputElement : inputElements) {
          s_elemx[iteratorx] = inputElement.text();
          iteratorx++;
        }
        System.out.println("Tip doma");
        for (int itip = 0; itip < elements.size(); itip++) {
          String tip = s_elem[itip];
          System.out.println(itip);
          if (tip.equals("Город")) {
            continue;
          }
          String s = s_elemx[itip];

          if (tip.equals("Дом")) {
            int dell = 0;
            for (int n = 0; n < s.length(); n++) {
              if (s.charAt(n) == ',') {
                dell++;
              }
            }
            if (dell > 0) {
              String tips = "";
              for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == ',') {
                  break;
                }
                tips += s.charAt(j);
              }
              tipdoma(tips, ho_ad);
              String year = "";
              for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == '0' || s.charAt(j) == '1' || s.charAt(j) == '2' || s.charAt(j) == '3' || s.charAt(j) == '4'
                  || s.charAt(j) == '5' || s.charAt(j) == '6' || s.charAt(j) == '7' || s.charAt(j) == '8' || s.charAt(j) == '9') {
                  year += s.charAt(j);
                }
              }
              ho_ad.setConstruction_year(Integer.parseInt(year));
            } else {
              tipdoma(s, ho_ad);
            }
          } else if (tip.equals("Количество уровней")) {
            ho_ad.setLevel_num(Integer.valueOf(s));
          } else if (tip.equals("Канализация")) {
            sewerage(s, ho_ad);
          } else if (tip.equals("Электричество")) {
            electricity(s, ho_ad);
          } else if (tip.equals("Отопление")) {
            heating(s, ho_ad);
          } else if (tip.equals("Газ")) {
            gas(s, ho_ad);
          } else if (tip.equals("Вода")) {
            drink_water(s, ho_ad);
          } else if (tip.equals("Парковка")) {
            parking(s, ho_ad);
          } else if (tip.equals("Высота потолков")) {
            ceiling(s, ho_ad);
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
          } else if (tip.equals("Участок")) {
            String lare = "";
            for (int l = 0; l < s.length(); l++) {
              if (s.charAt(l) == ' ') {
                break;
              }
              lare += s.charAt(l);
            }
            ho_ad.setLand_area(Double.parseDouble(lare));
          } else if (tip.equals("Дверь")) {
            door(s, ho_ad);
          }

        }
        System.out.println("god postroikiy");
        try {
          String contact = doc.getElementsByClass("label-user-identified-specialist").first().text();
          System.out.println(contact);
          List<Ho_Contact_Info_Type> ho_cit = repc.find_all1();
          for (Ho_Contact_Info_Type ho_usr : ho_cit) {
            if (ho_usr.getName().equals(contact)) {
              ho_ad.setHo_contact_info_type(ho_usr.getHo_contact_info_type());
              break;
            }
          }
        } catch (NullPointerException e) {
          try {
            String contact = doc.getElementsByClass("builder__contacts").text();
            System.out.println(contact);
            List<Ho_Contact_Info_Type> ho_cit = repc.find_all1();
            for (Ho_Contact_Info_Type ho_usr : ho_cit) {
              if (ho_usr.getName().equals(contact)) {
                ho_ad.setHo_contact_info_type(ho_usr.getHo_contact_info_type());
                break;
              }
            }
          } catch (NullPointerException ex) {

            try {
              String contact = doc.getElementsByClass("owners__label owners__label--default label-user-agent").first().text();
              System.out.println(contact);
              List<Ho_Contact_Info_Type> ho_cit = repc.find_all1();
              for (Ho_Contact_Info_Type ho_usr : ho_cit) {
                if (ho_usr.getName().equals(contact)) {
                  ho_ad.setHo_contact_info_type(ho_usr.getHo_contact_info_type());
                  break;
                }
              }
            } catch (NullPointerException exp) {
              String contact = doc.getElementsByClass("owners__name owners__name--large").text();
              System.out.println(contact);
              List<Ho_Contact_Info_Type> ho_cit = repc.find_all1();
              for (Ho_Contact_Info_Type ho_usr : ho_cit) {
                if (ho_usr.getName().equals(contact)) {
                  ho_ad.setHo_contact_info_type(ho_usr.getHo_contact_info_type());
                  break;
                }
              }

            }
          }
        }

        System.out.println("kljhjklhkjhk");
        Elements elementsClient = doc.getElementsByTag("dd");

        Elements elementss = doc.getElementsByTag("dt");
        String[] offer = new String[elementsClient.size()];
        int i_offer = 0;
        for (Element offerElement : elementsClient) {
          offer[i_offer] = offerElement.text();
          i_offer++;
        }
        int i_offerx = 0;
        String[] offerx = new String[elementsClient.size()];
        for (Element offerxElement : elementss) {
          offerx[i_offerx] = offerxElement.text();
          i_offerx++;
        }
        for (int itip = 0; itip < elementsClient.size(); itip++) {
          String s = offer[itip];
          String f = offerx[itip];
          if (f.equals("В залоге")) {
            is_pledged(s, ho_ad);
          } else if (f.equals("Высота потолков")) {
            ceiling(s, ho_ad);
          } else if (f.equals("Покрытие крыши")) {
            ho_ad.setRoofing(s);
          } else if (f.equals("Как огорожен участок")) {
            ho_ad.setHow_area_fenced(s);
          } else if (f.equals("Парковка")) {
            parking(s, ho_ad);
          } else if (f.equals("Дверь")) {
            door(s, ho_ad);
          } else if (f.equals("Канализация")) {
            sewerage(s, ho_ad);
          } else if (f.equals("Участок")) {
            String lare = "";
            for (int l = 0; l < s.length(); l++) {
              if (s.charAt(l) == ' ') {
                break;
              }
              lare += s.charAt(l);
            }
            ho_ad.setLand_area(Double.parseDouble(lare));
          } else if (f.equals("Электричество")) {
            electricity(s, ho_ad);
          } else if (f.equals("Отопление")) {
            heating(s, ho_ad);
          } else if (f.equals("Газ")) {
            gas(s, ho_ad);
          } else if (f.equals("Вода")) {
            drink_water(s, ho_ad);
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
          } else if (f.equals("Дверь")) {
            door(s, ho_ad);

          }
        }
        System.out.println("text");

      } catch (IOException ex) {
        continue;
      }
      System.out.println(has);
      has++;
      ho_Ad_Service.saveOrUpdate(ho_ad);
    }
  }

  @GetMapping("/dacha")
  public void dacha() throws FileNotFoundException, InterruptedException, IOException {
    File file = new File("C:\\Users\\User\\Downloads\\demo\\parse");
    Scanner scanner = new Scanner(file);
    int has = 0;
    while (scanner.hasNextLine()) {
      Thread.sleep(2000);
      Ho_Ad ho_ad = new Ho_Ad();

      String stringt = scanner.nextLine();

      Date timestamp = new Date();
      ho_ad.setIns_dt(timestamp);
      ho_ad.setIs_deleted(Boolean.FALSE);
      ho_ad.setC_country(2);
      ho_ad.setIs_agree_with_rules(true);
      ho_ad.setHo_usr(1L);
      ho_ad.setHo_cat(23);
      ho_ad.setHo_ad_status(1);
      Document doc;
      try {
        doc = (Document) Jsoup.connect(stringt).get();
        Thread.sleep(2000);
        Element element = doc.getElementById("jsdata");
        String kord = String.valueOf(element);
        String k = "";
        int d2 = 0;
        for (int i = 0; i < kord.length(); i++) {
          if (kord.charAt(i) == '"' && kord.charAt(i + 1) == 'l' && kord.charAt(i + 2) == 'a' && kord.charAt(i + 3) == 't' && kord.charAt(i + 4) == '"') {
            d2 = i + 6;
          }
        }
        for (int i = d2; i < kord.length(); i++) {
          if (kord.charAt(i) == ',') {
            break;
          }
          k += kord.charAt(i);
        }
        String k1 = "";
        int d1 = 0;
        for (int i = 0; i < kord.length(); i++) {
          if (kord.charAt(i) == '"' && kord.charAt(i + 1) == 'l' && kord.charAt(i + 2) == 'o' && kord.charAt(i + 3) == 'n' && kord.charAt(i + 4) == '"') {
            d1 = i + 6;
          }
        }
        for (int i = d1; i < kord.length(); i++) {
          if (kord.charAt(i) == ',') {
            break;
          }
          k1 += kord.charAt(i);
        }
        ho_ad.setLat(Double.parseDouble(k));
        ho_ad.setLon(Double.parseDouble(k1));
        System.out.println("test");
        String r = doc.getElementsByClass("offer__advert-title").first().child(0).text();
        System.out.println("tset");
       
        int d23 = 0;
        for (int is = 0; is < r.length(); is++) {
            if(r.charAt(is)=='с'&&r.charAt(is+1)=='о'&&r.charAt(is+2)=='т'&&r.charAt(is+3)=='.'&&r.charAt(is+4)==' '){
                d23=is+5;
                break;
            }
        }
        String k23= "" ;
        System.out.println(d23);
        for (int is = d23; is < r.length(); is++) {
            if (r.charAt(is)==',')break;
            k23+=r.charAt(is);
        }
        System.out.println(k23);
         List<Ho_House_Rent_Period> ho_usrs = ho_house_rent_period_repository.find_all1();
          for (Ho_House_Rent_Period ho_usr1 : ho_usrs) {
            System.out.println(ho_usr1.getName().equals(k23));
            if (ho_usr1.getName().equals(k23)) {
              ho_ad.setHo_house_rent_period(ho_usr1.getHo_house_rent_period());
              break;
            }
          }
        String room = "";
        for (int i = 0; i < r.length(); i++) {
          if (r.charAt(i) == '-') {
            break;
          }
          room += r.charAt(i);
        }

        System.out.println(r);
        System.out.println(room);
        int utirr = 0;
        int utir = 0;
        while (utir < r.length()) {
          if (r.charAt(utir) == ',') {
            utirr++;
          }
          utir++;
        }
        int i = 0;
        while (true) {
          if (r.charAt(i) == ',') {
            break;
          }
          i++;
        }
        i = i + 1;

        String street = "";
        while (i < r.length()) {
          street += r.charAt(i);
          i++;
        }
        //  String street_num = street.substring(street.length() - 4, street.length());
        ho_ad.setStreet_name(street);
        System.out.println("ioipoipoipo");
        String kl = doc.getElementsByClass("offer__price").text();
        String kli = kl;
        int d = 0;
        String lk = "";
        while (d < kli.length()) {
          if (kli.charAt(d) == '0' || kli.charAt(d) == '1' || kli.charAt(d) == '2' || kli.charAt(d) == '3' || kli.charAt(d) == '4'
            || kli.charAt(d) == '5' || kli.charAt(d) == '6' || kli.charAt(d) == '7' || kli.charAt(d) == '8' || kli.charAt(d) == '9') {
            lk += kli.charAt(d);
          }
          d++;
        }

        ho_ad.setPrice(Double.valueOf(lk));

        String loc = doc.getElementsByClass("offer__location").first().child(0).text();
        HoAdCatResponse c_tbl_rec_corr_by_name1 = c_tbl_rec_corr_by_name_repository.find_by_name(loc);
        C_Tbl_Rec_Corr_By_Name c_tbl_rec_corr_by_name = new C_Tbl_Rec_Corr_By_Name();
        if (c_tbl_rec_corr_by_name1 != null) {
          if (c_tbl_rec_corr_by_name1.getName().equals(loc)) {
            ho_ad.setC_loc(c_tbl_rec_corr_by_name1.getId());
          }
        } else {
          c_tbl_rec_corr_by_name.setC_tbl(24);
          c_tbl_rec_corr_by_name.setName(loc);
          c_tbl_rec_corr_by_name.setRec_id(147L);
          c_tbl_rec_corr_by_name.setIs_deleted(false);
          c_tbl_rec_corr_by_name_repository.save(c_tbl_rec_corr_by_name);
          ho_ad.setC_loc(c_tbl_rec_corr_by_name.getRec_id().intValue());
        }
        try {
          ho_ad.setTxt(doc.getElementsByClass("a-text").first().text());
        } catch (NullPointerException e) {
          System.out.println("jkljkl");
        }
        Elements inputElements = doc.getElementsByClass("offer__advert-short-info");

        Elements elements = doc.getElementsByClass("offer__info-title");
        String[] s_elem = new String[elements.size()];
        int iterator = 0;
        for (Element inElement : elements) {
          s_elem[iterator] = inElement.text();
          iterator++;
        }
        int iteratorx = 0;
        String[] s_elemx = new String[elements.size()];
        for (Element inputElement : inputElements) {
          s_elemx[iteratorx] = inputElement.text();
          iteratorx++;
        }
        System.out.println("Tip doma");
        for (int itip = 0; itip < elements.size(); itip++) {
          String tip = s_elem[itip];
          System.out.println(itip);
          if (tip.equals("Город")) {
            continue;
          }
          String s = s_elemx[itip];

          if (tip.equals("Тип строения")) {
            int dell = 0;
            for (int n = 0; n < s.length(); n++) {
              if (s.charAt(n) == ',') {
                dell++;
              }
            }
            if (dell > 0) {
              String tips = "";
              for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == ',') {
                  break;
                }
                tips += s.charAt(j);
              }
              tipdoma(tips, ho_ad);
              String year = "";
              for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == '0' || s.charAt(j) == '1' || s.charAt(j) == '2' || s.charAt(j) == '3' || s.charAt(j) == '4'
                  || s.charAt(j) == '5' || s.charAt(j) == '6' || s.charAt(j) == '7' || s.charAt(j) == '8' || s.charAt(j) == '9') {
                  year += s.charAt(j);
                }
              }
              ho_ad.setConstruction_year(Integer.parseInt(year));
            } else {
              tipdoma(s, ho_ad);
            }
          } else if (tip.equals("Количество уровней")) {
            ho_ad.setLevel_num(Integer.valueOf(s));
          } else if (tip.equals("Электричество")) {
            electricity(s, ho_ad);
          } else if (tip.equals("Отопление")) {
            heating(s, ho_ad);
          } else if (tip.equals("Газ")) {
            gas(s, ho_ad);
          } else if (tip.equals("Вода")) {
            drink_water(s, ho_ad);
          } else if (tip.equals("Название дачного массива")) {
            ho_ad.setSuburban_area_name(s);
          } else if (tip.equals("Площадь дома, м²")) {
            ho_ad.setHouse_area(Double.parseDouble(s));
          } else if (tip.equals("Парковка")) {
            parking(s, ho_ad);
          } else if (tip.equals("Высота потолков")) {
            ceiling(s, ho_ad);
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
          } else if (tip.equals("Покрытие крыши")) {
            ho_ad.setRoofing(s);
          } else if (tip.equals("Как огорожен участок")) {
            ho_ad.setHow_area_fenced(s);
          } else if (tip.equals("Участок")) {
            String lare = "";
            for (int l = 0; l < s.length(); l++) {
              if (s.charAt(l) == ' ') {
                break;
              }
              lare += s.charAt(l);
            }
            ho_ad.setLand_area(Double.parseDouble(lare));
          } else if (tip.equals("Дверь")) {
            door(s, ho_ad);
          } else if (tip.equals("Канализация")) {
            sewerage(s, ho_ad);
          } else if (tip.equals("Площадь участка, соток")) {
            ho_ad.setTotal_area(Double.parseDouble(s));
          } else if (tip.equals("Поливная вода")) {
            water(s, ho_ad);
          }
        }
        System.out.println("god postroikiy");
        try {
          String contact = doc.getElementsByClass("label-user-identified-specialist").first().text();
          System.out.println(contact);
          List<Ho_Contact_Info_Type> ho_cit = repc.find_all1();
          for (Ho_Contact_Info_Type ho_usr : ho_cit) {
            if (ho_usr.getName().equals(contact)) {
              ho_ad.setHo_contact_info_type(ho_usr.getHo_contact_info_type());
              break;
            }
          }
        } catch (NullPointerException e) {
          try {
            String contact = doc.getElementsByClass("builder__contacts").text();
            System.out.println(contact);
            List<Ho_Contact_Info_Type> ho_cit = repc.find_all1();
            for (Ho_Contact_Info_Type ho_usr : ho_cit) {
              if (ho_usr.getName().equals(contact)) {
                ho_ad.setHo_contact_info_type(ho_usr.getHo_contact_info_type());
                break;
              }
            }
          } catch (NullPointerException ex) {

            try {
              String contact = doc.getElementsByClass("owners__label owners__label--default label-user-agent").first().text();
              System.out.println(contact);
              List<Ho_Contact_Info_Type> ho_cit = repc.find_all1();
              for (Ho_Contact_Info_Type ho_usr : ho_cit) {
                if (ho_usr.getName().equals(contact)) {
                  ho_ad.setHo_contact_info_type(ho_usr.getHo_contact_info_type());
                  break;
                }
              }
            } catch (NullPointerException exp) {
              String contact = doc.getElementsByClass("owners__name owners__name--large").text();
              System.out.println(contact);
              List<Ho_Contact_Info_Type> ho_cit = repc.find_all1();
              for (Ho_Contact_Info_Type ho_usr : ho_cit) {
                if (ho_usr.getName().equals(contact)) {
                  ho_ad.setHo_contact_info_type(ho_usr.getHo_contact_info_type());
                  break;
                }
              }

            }
          }
        }

        System.out.println("kljhjklhkjhk");
        Elements elementsClient = doc.getElementsByTag("dd");

        Elements elementss = doc.getElementsByTag("dt");
        String[] offer = new String[elementsClient.size()];
        int i_offer = 0;
        for (Element offerElement : elementsClient) {
          offer[i_offer] = offerElement.text();
          i_offer++;
        }
        int i_offerx = 0;
        String[] offerx = new String[elementsClient.size()];
        for (Element offerxElement : elementss) {
          offerx[i_offerx] = offerxElement.text();
          i_offerx++;
        }
        for (int itip = 0; itip < elementsClient.size(); itip++) {
          String s = offer[itip];
          String f = offerx[itip];
          if (f.equals("В залоге")) {
            is_pledged(s, ho_ad);
          } else if (f.equals("Высота потолков")) {
            ceiling(s, ho_ad);
          } else if (f.equals("Поливная вода")) {
            water(s, ho_ad);
          } else if (f.equals("Покрытие крыши")) {
            ho_ad.setRoofing(s);
          } else if (f.equals("Как огорожен участок")) {
            ho_ad.setHow_area_fenced(s);
          } else if (f.equals("Парковка")) {
            parking(s, ho_ad);
          } else if (f.equals("Дверь")) {
            door(s, ho_ad);
          } else if (f.equals("Канализация")) {
            sewerage(s, ho_ad);
          } else if (f.equals("Участок")) {
            String lare = "";
            for (int l = 0; l < s.length(); l++) {
              if (s.charAt(l) == ' ') {
                break;
              }
              lare += s.charAt(l);
            }
            ho_ad.setLand_area(Double.parseDouble(lare));
          } else if (f.equals("Электричество")) {
            electricity(s, ho_ad);
          } else if (f.equals("Отопление")) {
            heating(s, ho_ad);
          } else if (f.equals("Газ")) {
            gas(s, ho_ad);
          } else if (f.equals("Вода")) {
            drink_water(s, ho_ad);
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
        System.out.println("text");

      } catch (IOException ex) {
        continue;
      }
      System.out.println(has);
      has++;
      ho_Ad_Service.saveOrUpdate(ho_ad);
      try {
        Elements inputElements = doc.getElementsByClass("offer__advert-short-info");
        Elements elements = doc.getElementsByClass("offer__info-title");
        String[] s_elem = new String[elements.size()];
        int iterator = 0;
        for (Element inElement : elements) {
          s_elem[iterator] = inElement.text();
          iterator++;
        }
        int iteratorx = 0;
        String[] s_elemx = new String[elements.size()];
        for (Element inputElement : inputElements) {
          s_elemx[iteratorx] = inputElement.text();
          iteratorx++;
        }
        for (int itip = 0; itip < elements.size(); itip++) {
          String tip = s_elem[itip];

          String s = s_elemx[itip];
          if (tip.equals("Безопасность")) {
            house_security(s, ho_ad);
          }
        }
        Elements elementsClient = doc.getElementsByTag("dd");
        Elements elementss = doc.getElementsByTag("dt");
        String[] offer = new String[elementsClient.size()];
        int i_offer = 0;
        for (Element offerElement : elementsClient) {
          offer[i_offer] = offerElement.text();
          i_offer++;
        }
        int i_offerx = 0;
        String[] offerx = new String[elementsClient.size()];
        for (Element offerxElement : elementss) {
          offerx[i_offerx] = offerxElement.text();
          i_offerx++;
        }
        for (int itip = 0; itip < elementsClient.size(); itip++) {
          String s = offer[itip];
          String f = offerx[itip];
          if (f.equals("Безопасность")) {
            house_security(s, ho_ad);
          }
        }
        String s = doc.getElementsByClass("gallery__main").first().child(1).child(0).child(2).attr("src");
        String file_name = doc.getElementsByClass("gallery__main").first().child(1).child(0).child(2).attr("alt");
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
          e.printStackTrace();
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
        c_tbl_rec_img_moder.setC_img_kind(1);
        c_tbl_rec_img_moder.setC_img_status(2);
        c_tbl_rec_img_moder.setIs_deleted(Boolean.FALSE);
        c_tbl_rec_img_moder.setC_img(c_Img.getC_img());

        c_tbl_rec_img_moder_repository.save(c_tbl_rec_img_moder);
      } catch (NullPointerException ex) {
      }

      try {
        Elements elementsClient = doc.getElementsByClass("gallery__small-item");
        String[] offer = new String[elementsClient.size()];
        String[] offerx = new String[elementsClient.size()];
        int i_offer = 0;
        for (Element offerElement : elementsClient) {
          offer[i_offer] = offerElement.child(0).child(2).attr("src");
          System.out.println(offer[i_offer]);
          offerx[i_offer] = offerElement.child(0).child(2).attr("alt");
          System.out.println(offerx[i_offer]);
          i_offer++;
        }
        System.out.println("test2");
        for (int l = 0; l < elementsClient.size(); l++) {
          String s = offer[l];
          String file_name = offerx[l];
          System.out.println(s);
          System.out.println(file_name);

          C_Bin_File_Body c_Bin_File_Body = new C_Bin_File_Body();
          URL url = new URL(s);
          System.out.println("lkjhlkjhoiutbtgy");
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
            e.printStackTrace();
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
          System.out.println("end procces");
        }
      } catch (NullPointerException ex) {
      }
    }
  }

  @GetMapping("/zdania")
  public void zdania() throws FileNotFoundException, InterruptedException, IOException {

    String separator = File.separator;
    File file = new File("C:\\Users\\User\\Downloads\\demo\\parse");
    Scanner scanner = new Scanner(file);
    int has = 0;
    while (scanner.hasNextLine()) {
      Thread.sleep(2000);
      Ho_Ad ho_ad = new Ho_Ad();

      String stringt = scanner.nextLine();

      Date timestamp = new Date();
      ho_ad.setIns_dt(timestamp);
      ho_ad.setIs_deleted(Boolean.FALSE);
      ho_ad.setC_country(2);
      ho_ad.setIs_agree_with_rules(true);
      ho_ad.setHo_usr(1L);
      ho_ad.setHo_cat(28);//28
      ho_ad.setHo_ad_status(1);
      Document doc;
      try {
        doc = (Document) Jsoup.connect(stringt).get();
        Thread.sleep(2000);
        Element element = doc.getElementById("jsdata");
        String kord = String.valueOf(element);
        String k = "";
        int d2 = 0;
        for (int i = 0; i < kord.length(); i++) {
          if (kord.charAt(i) == '"' && kord.charAt(i + 1) == 'l' && kord.charAt(i + 2) == 'a' && kord.charAt(i + 3) == 't' && kord.charAt(i + 4) == '"') {
            d2 = i + 6;
          }
        }
        for (int i = d2; i < kord.length(); i++) {
          if (kord.charAt(i) == ',') {
            break;
          }
          k += kord.charAt(i);
        }
        String k1 = "";
        int d1 = 0;
        for (int i = 0; i < kord.length(); i++) {
          if (kord.charAt(i) == '"' && kord.charAt(i + 1) == 'l' && kord.charAt(i + 2) == 'o' && kord.charAt(i + 3) == 'n' && kord.charAt(i + 4) == '"') {
            d1 = i + 6;
          }
        }
        for (int i = d1; i < kord.length(); i++) {
          if (kord.charAt(i) == ',') {
            break;
          }
          k1 += kord.charAt(i);
        }
        ho_ad.setLat(Double.parseDouble(k));
        ho_ad.setLon(Double.parseDouble(k1));
        System.out.println("test");
        String r = doc.getElementsByClass("offer__advert-title").first().child(0).text();
        System.out.println("tset");
        String room = "";
        for (int i = 0; i < r.length(); i++) {
          if (r.charAt(i) == '-') {
            break;
          }
          room += r.charAt(i);
        }

        System.out.println(r);
        System.out.println(room);
        int utirr = 0;
        int utir = 0;
        while (utir < r.length()) {
          if (r.charAt(utir) == ',') {
            utirr++;
          }
          utir++;
        }
        int i = 0;
        while (true) {
          if (r.charAt(i) == ',') {
            break;
          }
          i++;
        }
        i = i + 1;
        if(utirr==3){
        String area = "";
        while (true) {
          if (r.charAt(i) == ',') {
            break;
          }
          i++;
          area += r.charAt(i);

        }
        i = i + 1;
        String street = "";
        while (i < r.length()) {
          street += r.charAt(i);
          i++;
        }
        ho_ad.setStreet_name(street);
        }
        System.out.println("ioipoipoipo");
        String kl = doc.getElementsByClass("offer__price").text();
        String kli = kl;
        int d = 0;
        String lk = "";
        while (d < kli.length()) {
          if (kli.charAt(d) == '0' || kli.charAt(d) == '1' || kli.charAt(d) == '2' || kli.charAt(d) == '3' || kli.charAt(d) == '4'
            || kli.charAt(d) == '5' || kli.charAt(d) == '6' || kli.charAt(d) == '7' || kli.charAt(d) == '8' || kli.charAt(d) == '9') {
            lk += kli.charAt(d);
          }
          d++;
        }

        ho_ad.setPrice(Double.valueOf(lk));

        String loc = doc.getElementsByClass("offer__location").first().child(0).text();
        HoAdCatResponse c_tbl_rec_corr_by_name1 = c_tbl_rec_corr_by_name_repository.find_by_name(loc);
        C_Tbl_Rec_Corr_By_Name c_tbl_rec_corr_by_name = new C_Tbl_Rec_Corr_By_Name();
        if (c_tbl_rec_corr_by_name1 != null) {
          if (c_tbl_rec_corr_by_name1.getName().equals(loc)) {
            ho_ad.setC_loc(c_tbl_rec_corr_by_name1.getId());
          }
        } else {
          c_tbl_rec_corr_by_name.setC_tbl(24);
          c_tbl_rec_corr_by_name.setName(loc);
          c_tbl_rec_corr_by_name.setRec_id(147L);
          c_tbl_rec_corr_by_name.setIs_deleted(false);
          c_tbl_rec_corr_by_name_repository.save(c_tbl_rec_corr_by_name);
          ho_ad.setC_loc(c_tbl_rec_corr_by_name.getRec_id().intValue());
        }
        try {
          ho_ad.setTxt(doc.getElementsByClass("a-text").first().text());
        } catch (NullPointerException e) {
          System.out.println("jkljkl");
        }
        Elements inputElements = doc.getElementsByClass("offer__advert-short-info");

        Elements elements = doc.getElementsByClass("offer__info-title");
        String[] s_elem = new String[elements.size()];
        int iterator = 0;
        for (Element inElement : elements) {
          s_elem[iterator] = inElement.text();
          iterator++;
        }
        int iteratorx = 0;
        String[] s_elemx = new String[elements.size()];
        for (Element inputElement : inputElements) {
          s_elemx[iteratorx] = inputElement.text();
          iteratorx++;
        }
        System.out.println("Tip doma");
        for (int itip = 0; itip < elements.size(); itip++) {
          String tip = s_elem[itip];
          System.out.println(itip);
          if (tip.equals("Город")) {
            continue;
          }
          String s = s_elemx[itip];

          if (tip.equals("Тип строения")) {
            int dell = 0;
            for (int n = 0; n < s.length(); n++) {
              if (s.charAt(n) == ',') {
                dell++;
              }
            }
            if (dell > 0) {
              String tips = "";
              for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == ',') {
                  break;
                }
                tips += s.charAt(j);
              }
              tipdoma(tips, ho_ad);
              String year = "";
              for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == '0' || s.charAt(j) == '1' || s.charAt(j) == '2' || s.charAt(j) == '3' || s.charAt(j) == '4'
                  || s.charAt(j) == '5' || s.charAt(j) == '6' || s.charAt(j) == '7' || s.charAt(j) == '8' || s.charAt(j) == '9') {
                  year += s.charAt(j);
                }
              }
              ho_ad.setConstruction_year(Integer.parseInt(year));
            } else {
              tipdoma(s, ho_ad);
            }
          } else if (tip.equals("Количество уровней")) {
            ho_ad.setLevel_num(Integer.valueOf(s));
          } else if (tip.equals("Канализация")) {
            sewerage(s, ho_ad);
          } else if (tip.equals("Электричество")) {
            electricity(s, ho_ad);
          } else if (tip.equals("Отопление")) {
            heating(s, ho_ad);
          } else if (tip.equals("Газ")) {
            gas(s, ho_ad);
          } else if (tip.equals("Вода")) {
            drink_water(s, ho_ad);
          } else if (tip.equals("Площадь дома, м²")) {
            ho_ad.setHouse_area(Double.parseDouble(s));
          } else if (tip.equals("Общая площадь, м²")) {
            ho_ad.setTotal_area(Double.parseDouble(s));
          } else if (tip.equals("Площадь участка, соток")) {
            ho_ad.setAdj_territory_area(Double.parseDouble(s));
          } else if (tip.equals("Парковка")) {
            ho_ad.setParking(s);
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
          } else if (tip.equals("Кол-во телефонных линий")) {
            ho_ad.setPhone_lines_num(Integer.parseInt(s));
          } else if (tip.equals("Возможен обмен")) {
            is_exch_possible(s, ho_ad);
          } else if (tip.equals("Цена в месяц")) {
            land_price(s, ho_ad);
          } else if (tip.equals("Год постройки (сдачи в эксплуатацию)")) {
            ho_ad.setConstruction_year(Integer.parseInt(s));
          } else if (tip.equals("Высота потолков")) {
            ceiling(s, ho_ad);
          } else if (tip.equals("Покрытие крыши")) {
            ho_ad.setRoofing(s);
          } else if (tip.equals("Как огорожен участок")) {
            ho_ad.setHow_area_fenced(s);
          } else if (tip.equals("Участок")) {
            String lare = "";
            for (int l = 0; l < s.length(); l++) {
              if (s.charAt(l) == ' ') {
                break;
              }
              lare += s.charAt(l);
            }
            ho_ad.setLand_area(Double.parseDouble(lare));
          } else if (tip.equals("Дверь")) {
            door(s, ho_ad);
          } else if (tip.equals("Поливная вода")) {
            water(s, ho_ad);
          }
        }
        System.out.println("god postroikiy");
        try {
          String contact = doc.getElementsByClass("label-user-identified-specialist").first().text();
          System.out.println(contact);
          List<Ho_Contact_Info_Type> ho_cit = repc.find_all1();
          for (Ho_Contact_Info_Type ho_usr : ho_cit) {
            if (ho_usr.getName().equals(contact)) {
              ho_ad.setHo_contact_info_type(ho_usr.getHo_contact_info_type());
              break;
            }
          }
        } catch (NullPointerException e) {
          try {
            String contact = doc.getElementsByClass("builder__contacts").text();
            System.out.println(contact);
            List<Ho_Contact_Info_Type> ho_cit = repc.find_all1();
            for (Ho_Contact_Info_Type ho_usr : ho_cit) {
              if (ho_usr.getName().equals(contact)) {
                ho_ad.setHo_contact_info_type(ho_usr.getHo_contact_info_type());
                break;
              }
            }
          } catch (NullPointerException ex) {

            try {
              String contact = doc.getElementsByClass("owners__label owners__label--default label-user-agent").first().text();
              System.out.println(contact);
              List<Ho_Contact_Info_Type> ho_cit = repc.find_all1();
              for (Ho_Contact_Info_Type ho_usr : ho_cit) {
                if (ho_usr.getName().equals(contact)) {
                  ho_ad.setHo_contact_info_type(ho_usr.getHo_contact_info_type());
                  break;
                }
              }
            } catch (NullPointerException exp) {
              String contact = doc.getElementsByClass("owners__name owners__name--large").text();
              System.out.println(contact);
              List<Ho_Contact_Info_Type> ho_cit = repc.find_all1();
              for (Ho_Contact_Info_Type ho_usr : ho_cit) {
                if (ho_usr.getName().equals(contact)) {
                  ho_ad.setHo_contact_info_type(ho_usr.getHo_contact_info_type());
                  break;
                }
              }

            }
          }
        }
        System.out.println("kljhjklhkjhk");
        Elements elementsClient = doc.getElementsByTag("dd");
        Elements elementss = doc.getElementsByTag("dt");
        String[] offer = new String[elementsClient.size()];
        int i_offer = 0;
        for (Element offerElement : elementsClient) {
          offer[i_offer] = offerElement.text();
          i_offer++;
        }
        int i_offerx = 0;
        String[] offerx = new String[elementsClient.size()];
        for (Element offerxElement : elementss) {
          offerx[i_offerx] = offerxElement.text();
          i_offerx++;
        }
        for (int itip = 0; itip < elementsClient.size(); itip++) {
          String s = offer[itip];
          String f = offerx[itip];
          if (f.equals("В залоге")) {
            is_pledged(s, ho_ad);
          } else if (f.equals("Потолки")) {
            ceiling(s, ho_ad);
          } else if (f.equals("Поливная вода")) {
            water(s, ho_ad);
          } else if (f.equals("Кол-во телефонных линий")) {
            ho_ad.setPhone_lines_num(Integer.parseInt(s));
          } else if (f.equals("Покрытие крыши")) {
            ho_ad.setRoofing(s);
          } else if (f.equals("Площадь участка, соток")) {
            ho_ad.setAdj_territory_area(Double.parseDouble(s));
          } else if (f.equals("Как огорожен участок")) {
            ho_ad.setHow_area_fenced(s);
          } else if (f.equals("Парковка")) {
            ho_ad.setParking(s);
          } else if (f.equals("Возможен обмен")) {
            is_exch_possible(s, ho_ad);
          } else if (f.equals("Канализация")) {
            sewerage(s, ho_ad);
          } else if (f.equals("Участок")) {
            String lare = "";
            for (int l = 0; l < s.length(); l++) {
              if (s.charAt(l) == ' ') {
                break;
              }
              lare += s.charAt(l);
            }
            ho_ad.setLand_area(Double.parseDouble(lare));
          } else if (f.equals("Электричество")) {
            electricity(s, ho_ad);
          } else if (f.equals("Отопление")) {
            heating(s, ho_ad);
          } else if (f.equals("Газ")) {
            gas(s, ho_ad);
          } else if (f.equals("Вода")) {
            drink_water(s, ho_ad);
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
          } else if (f.equals("Дверь")) {
            door(s, ho_ad);

          }
        }
        System.out.println("text");

      } catch (IOException ex) {
        continue;
      }
      System.out.println(has);
      has++;
      ho_Ad_Service.saveOrUpdate(ho_ad);
      try {
        Elements inputElements = doc.getElementsByClass("offer__advert-short-info");
        Elements elements = doc.getElementsByClass("offer__info-title");
        String[] s_elem = new String[elements.size()];
        int iterator = 0;
        for (Element inElement : elements) {
          s_elem[iterator] = inElement.text();
          iterator++;
        }
        int iteratorx = 0;
        String[] s_elemx = new String[elements.size()];
        for (Element inputElement : inputElements) {
          s_elemx[iteratorx] = inputElement.text();
          iteratorx++;
        }
        for (int itip = 0; itip < elements.size(); itip++) {
          String tip = s_elem[itip];

          String s = s_elemx[itip];
          if (tip.equals("Безопасность")) {
            house_security(s, ho_ad);
          }
        }
        Elements elementsClient = doc.getElementsByTag("dd");
        Elements elementss = doc.getElementsByTag("dt");
        String[] offer = new String[elementsClient.size()];
        int i_offer = 0;
        for (Element offerElement : elementsClient) {
          offer[i_offer] = offerElement.text();
          i_offer++;
        }
        int i_offerx = 0;
        String[] offerx = new String[elementsClient.size()];
        for (Element offerxElement : elementss) {
          offerx[i_offerx] = offerxElement.text();
          i_offerx++;
        }
        for (int itip = 0; itip < elementsClient.size(); itip++) {
          String s = offer[itip];
          String f = offerx[itip];
          if (f.equals("Безопасность")) {
            house_security(s, ho_ad);
          }
        }
        String s = doc.getElementsByClass("gallery__main").first().child(1).child(0).child(2).attr("src");
        String file_name = doc.getElementsByClass("gallery__main").first().child(1).child(0).child(2).attr("alt");
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
          e.printStackTrace();
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
        c_tbl_rec_img_moder.setC_img_kind(1);
        c_tbl_rec_img_moder.setC_img_status(2);
        c_tbl_rec_img_moder.setIs_deleted(Boolean.FALSE);
        c_tbl_rec_img_moder.setC_img(c_Img.getC_img());

        c_tbl_rec_img_moder_repository.save(c_tbl_rec_img_moder);
      } catch (NullPointerException ex) {
      }

      try {
        Elements elementsClient = doc.getElementsByClass("gallery__small-item");
        String[] offer = new String[elementsClient.size()];
        String[] offerx = new String[elementsClient.size()];
        int i_offer = 0;
        for (Element offerElement : elementsClient) {
          offer[i_offer] = offerElement.child(0).child(2).attr("src");
          System.out.println(offer[i_offer]);
          offerx[i_offer] = offerElement.child(0).child(2).attr("alt");
          System.out.println(offerx[i_offer]);
          i_offer++;
        }
        System.out.println("test2");
        for (int l = 0; l < elementsClient.size(); l++) {
          String s = offer[l];
          String file_name = offerx[l];
          System.out.println(s);
          System.out.println(file_name);

          C_Bin_File_Body c_Bin_File_Body = new C_Bin_File_Body();
          URL url = new URL(s);
          System.out.println("lkjhlkjhoiutbtgy");
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
            e.printStackTrace();
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
      } catch (NullPointerException ex) {
      }
    }
  }

  @GetMapping("/magazin")
  public void magazin() throws FileNotFoundException, InterruptedException, IOException {

    String separator = File.separator;
    File file = new File("C:\\Users\\User\\Downloads\\demo\\parse");
    Scanner scanner = new Scanner(file);
    int has = 0;
    while (scanner.hasNextLine()) {
      Thread.sleep(2000);
      Ho_Ad ho_ad = new Ho_Ad();

      String stringt = scanner.nextLine();

      Date timestamp = new Date();
      ho_ad.setIns_dt(timestamp);
      ho_ad.setIs_deleted(Boolean.FALSE);
      ho_ad.setC_country(2);
      ho_ad.setIs_agree_with_rules(true);
      ho_ad.setHo_usr(1L);
      ho_ad.setHo_cat(29);//29
      ho_ad.setHo_ad_status(1);
      Document doc;
      try {
        doc = (Document) Jsoup.connect(stringt).get();
        Thread.sleep(2000);
        Element element = doc.getElementById("jsdata");
        String kord = String.valueOf(element);
        String k = "";
        int d2 = 0;
        for (int i = 0; i < kord.length(); i++) {
          if (kord.charAt(i) == '"' && kord.charAt(i + 1) == 'l' && kord.charAt(i + 2) == 'a' && kord.charAt(i + 3) == 't' && kord.charAt(i + 4) == '"') {
            d2 = i + 6;
          }
        }
        for (int i = d2; i < kord.length(); i++) {
          if (kord.charAt(i) == ',') {
            break;
          }
          k += kord.charAt(i);
        }
        String k1 = "";
        int d1 = 0;
        for (int i = 0; i < kord.length(); i++) {
          if (kord.charAt(i) == '"' && kord.charAt(i + 1) == 'l' && kord.charAt(i + 2) == 'o' && kord.charAt(i + 3) == 'n' && kord.charAt(i + 4) == '"') {
            d1 = i + 6;
          }
        }
        for (int i = d1; i < kord.length(); i++) {
          if (kord.charAt(i) == ',') {
            break;
          }
          k1 += kord.charAt(i);
        }
        ho_ad.setLat(Double.parseDouble(k));
        ho_ad.setLon(Double.parseDouble(k1));
        System.out.println("test");
        String r = doc.getElementsByClass("offer__advert-title").first().child(0).text();
        System.out.println("tset");
        String room = "";
        for (int i = 0; i < r.length(); i++) {
          if (r.charAt(i) == '-') {
            break;
          }
          room += r.charAt(i);
        }

        System.out.println(r);
        System.out.println(room);
        int utirr = 0;
        int utir = 0;
        while (utir < r.length()) {
          if (r.charAt(utir) == ',') {
            utirr++;
          }
          utir++;
        }
        int i = 0;
        while (true) {
          if (r.charAt(i) == ',') {
            break;
          }
          i++;
        }
        i = i + 1;
        String street = "";
        while (i < r.length()) {
          street += r.charAt(i);
          i++;
        }
        ho_ad.setStreet_name(street);
        System.out.println("ioipoipoipo");
        String kl = doc.getElementsByClass("offer__price").text();
        String kli = kl;
        int d = 0;
        String lk = "";
        while (d < kli.length()) {
          if (kli.charAt(d) == '0' || kli.charAt(d) == '1' || kli.charAt(d) == '2' || kli.charAt(d) == '3' || kli.charAt(d) == '4'
            || kli.charAt(d) == '5' || kli.charAt(d) == '6' || kli.charAt(d) == '7' || kli.charAt(d) == '8' || kli.charAt(d) == '9') {
            lk += kli.charAt(d);
          }
          d++;
        }

        ho_ad.setPrice(Double.valueOf(lk));

        String loc = doc.getElementsByClass("offer__location").first().child(0).text();
        HoAdCatResponse c_tbl_rec_corr_by_name1 = c_tbl_rec_corr_by_name_repository.find_by_name(loc);
        C_Tbl_Rec_Corr_By_Name c_tbl_rec_corr_by_name = new C_Tbl_Rec_Corr_By_Name();
        if (c_tbl_rec_corr_by_name1 != null) {
          if (c_tbl_rec_corr_by_name1.getName().equals(loc)) {
            ho_ad.setC_loc(c_tbl_rec_corr_by_name1.getId());
          }
        } else {
          c_tbl_rec_corr_by_name.setC_tbl(24);
          c_tbl_rec_corr_by_name.setName(loc);
          c_tbl_rec_corr_by_name.setRec_id(147L);
          c_tbl_rec_corr_by_name.setIs_deleted(false);
          c_tbl_rec_corr_by_name_repository.save(c_tbl_rec_corr_by_name);
          ho_ad.setC_loc(c_tbl_rec_corr_by_name.getRec_id().intValue());
        }
        try {
          ho_ad.setTxt(doc.getElementsByClass("a-text").first().text());
        } catch (NullPointerException e) {
          System.out.println("jkljkl");
        }
        Elements inputElements = doc.getElementsByClass("offer__advert-short-info");

        Elements elements = doc.getElementsByClass("offer__info-title");
        String[] s_elem = new String[elements.size()];
        int iterator = 0;
        for (Element inElement : elements) {
          s_elem[iterator] = inElement.text();
          iterator++;
        }
        int iteratorx = 0;
        String[] s_elemx = new String[elements.size()];
        for (Element inputElement : inputElements) {
          s_elemx[iteratorx] = inputElement.text();
          iteratorx++;
        }
        System.out.println("Tip doma");
        for (int itip = 0; itip < elements.size(); itip++) {
          String tip = s_elem[itip];
          
          String s = s_elemx[itip];

          if (tip.equals("Тип строения")) {
            int dell = 0;
            for (int n = 0; n < s.length(); n++) {
              if (s.charAt(n) == ',') {
                dell++;
              }
            }
            if (dell > 0) {
              String tips = "";
              for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == ',') {
                  break;
                }
                tips += s.charAt(j);
              }
              tipdoma(tips, ho_ad);
              String year = "";
              for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == '0' || s.charAt(j) == '1' || s.charAt(j) == '2' || s.charAt(j) == '3' || s.charAt(j) == '4'
                  || s.charAt(j) == '5' || s.charAt(j) == '6' || s.charAt(j) == '7' || s.charAt(j) == '8' || s.charAt(j) == '9') {
                  year += s.charAt(j);
                }
              }
              ho_ad.setConstruction_year(Integer.parseInt(year));
            } else {
              tipdoma(s, ho_ad);
            }
          } else if (tip.equals("Количество уровней")) {
            ho_ad.setLevel_num(Integer.valueOf(s));
          } else if (tip.equals("Канализация")) {
            sewerage(s, ho_ad);
          } else if (tip.equals("Что именно?")) {
            shop_type(s, ho_ad);
          } else if (tip.equals("Местоположение")) {
            house_loc(s, ho_ad);
          } else if (tip.equals("Цена в месяц")) {
            land_price(s, ho_ad);
          } else if (tip.equals("Название торгового центра, рынка")) {
            ho_ad.setShop_center_name(s);
          } else if (tip.equals("Электричество")) {
            electricity(s, ho_ad);
          } else if (tip.equals("Отопление")) {
            heating(s, ho_ad);
          } else if (tip.equals("Газ")) {
            gas(s, ho_ad);
          } else if (tip.equals("Вода")) {
            drink_water(s, ho_ad);
          } else if (tip.equals("Площадь дома, м²")) {
            ho_ad.setHouse_area(Double.parseDouble(s));
          } else if (tip.equals("Общая площадь, м²")) {
            ho_ad.setTotal_area(Double.parseDouble(s));
          } else if (tip.equals("Площадь участка, соток")) {
            ho_ad.setAdj_territory_area(Double.parseDouble(s));
          } else if (tip.equals("Парковка")) {
            ho_ad.setParking(s);
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
          } else if (tip.equals("Кол-во телефонных линий")) {
            ho_ad.setPhone_lines_num(Integer.parseInt(s));
          } else if (tip.equals("Возможен обмен")) {
            is_exch_possible(s, ho_ad);
          } else if (tip.equals("Год постройки (сдачи в эксплуатацию)")) {
            ho_ad.setConstruction_year(Integer.parseInt(s));
          } else if (tip.equals("Высота потолков")) {
            ceiling(s, ho_ad);
          } else if (tip.equals("Покрытие крыши")) {
            ho_ad.setRoofing(s);
          } else if (tip.equals("Как огорожен участок")) {
            ho_ad.setHow_area_fenced(s);
          } else if (tip.equals("Участок")) {
            String lare = "";
            for (int l = 0; l < s.length(); l++) {
              if (s.charAt(l) == ' ') {
                break;
              }
              lare += s.charAt(l);
            }
            ho_ad.setLand_area(Double.parseDouble(lare));
          } else if (tip.equals("Дверь")) {
            door(s, ho_ad);
          } //            else  if(tip.equals("Площадь участка, соток"))
          //             ho_ad.setTotal_area(Double.parseDouble(s));
          else if (tip.equals("Поливная вода")) {
            water(s, ho_ad);
          }
        }
        System.out.println("god postroikiy");
        try {
          String contact = doc.getElementsByClass("label-user-identified-specialist").first().text();
          System.out.println(contact);
          List<Ho_Contact_Info_Type> ho_cit = repc.find_all1();
          for (Ho_Contact_Info_Type ho_usr : ho_cit) {
            if (ho_usr.getName().equals(contact)) {
              ho_ad.setHo_contact_info_type(ho_usr.getHo_contact_info_type());
              break;
            }
          }
        } catch (NullPointerException e) {
          try {
            String contact = doc.getElementsByClass("builder__contacts").text();
            System.out.println(contact);
            List<Ho_Contact_Info_Type> ho_cit = repc.find_all1();
            for (Ho_Contact_Info_Type ho_usr : ho_cit) {
              if (ho_usr.getName().equals(contact)) {
                ho_ad.setHo_contact_info_type(ho_usr.getHo_contact_info_type());
                break;
              }
            }
          } catch (NullPointerException ex) {

            try {
              String contact = doc.getElementsByClass("owners__label owners__label--default label-user-agent").first().text();
              System.out.println(contact);
              List<Ho_Contact_Info_Type> ho_cit = repc.find_all1();
              for (Ho_Contact_Info_Type ho_usr : ho_cit) {
                if (ho_usr.getName().equals(contact)) {
                  ho_ad.setHo_contact_info_type(ho_usr.getHo_contact_info_type());
                  break;
                }
              }
            } catch (NullPointerException exp) {
              String contact = doc.getElementsByClass("owners__name owners__name--large").text();
              System.out.println(contact);
              List<Ho_Contact_Info_Type> ho_cit = repc.find_all1();
              for (Ho_Contact_Info_Type ho_usr : ho_cit) {
                if (ho_usr.getName().equals(contact)) {
                  ho_ad.setHo_contact_info_type(ho_usr.getHo_contact_info_type());
                  break;
                }
              }

            }
          }
        }
        System.out.println("kljhjklhkjhk");
        Elements elementsClient = doc.getElementsByTag("dd");
        Elements elementss = doc.getElementsByTag("dt");
        String[] offer = new String[elementsClient.size()];
        int i_offer = 0;
        for (Element offerElement : elementsClient) {
          offer[i_offer] = offerElement.text();
          i_offer++;
        }
        int i_offerx = 0;
        String[] offerx = new String[elementsClient.size()];
        for (Element offerxElement : elementss) {
          offerx[i_offerx] = offerxElement.text();
          i_offerx++;
        }
        for (int itip = 0; itip < elementsClient.size(); itip++) {
          String s = offer[itip];
          String f = offerx[itip];
          if (f.equals("В залоге")) {
            is_pledged(s, ho_ad);
          } else if (f.equals("Потолки")) {
            ceiling(s, ho_ad);
          } else if (f.equals("Поливная вода")) {
            water(s, ho_ad);
          } else if (f.equals("Кол-во телефонных линий")) {
            ho_ad.setPhone_lines_num(Integer.parseInt(s));
          } else if (f.equals("Покрытие крыши")) {
            ho_ad.setRoofing(s);
          } else if (f.equals("Что именно?")) {
            shop_type(s, ho_ad);
          } else if (f.equals("Местоположение")) {
            house_loc(s, ho_ad);
          } else if (f.equals("Название торгового центра, рынка")) {
            ho_ad.setShop_center_name(s);
          } else if (f.equals("Площадь участка, соток")) {
            ho_ad.setAdj_territory_area(Double.parseDouble(s));
          } else if (f.equals("Как огорожен участок")) {
            ho_ad.setHow_area_fenced(s);
          } else if (f.equals("Парковка")) {
            ho_ad.setParking(s);
          } else if (f.equals("Возможен обмен")) {
            is_exch_possible(s, ho_ad);
          } else if (f.equals("Канализация")) {
            sewerage(s, ho_ad);
          } else if (f.equals("Участок")) {
            String lare = "";
            for (int l = 0; l < s.length(); l++) {
              if (s.charAt(l) == ' ') {
                break;
              }
              lare += s.charAt(l);
            }
            ho_ad.setLand_area(Double.parseDouble(lare));
          } else if (f.equals("Электричество")) {
            electricity(s, ho_ad);
          } else if (f.equals("Отопление")) {
            heating(s, ho_ad);
          } else if (f.equals("Газ")) {
            gas(s, ho_ad);
          } else if (f.equals("Вода")) {
            drink_water(s, ho_ad);
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
          } else if (f.equals("Дверь")) {
            door(s, ho_ad);

          }
        }
        System.out.println("text");

      } catch (IOException ex) {
        continue;
      }
      System.out.println(has);
      has++;
      ho_Ad_Service.saveOrUpdate(ho_ad);

      try {
        Elements inputElements = doc.getElementsByClass("offer__advert-short-info");
        Elements elements = doc.getElementsByClass("offer__info-title");
        String[] s_elem = new String[elements.size()];
        int iterator = 0;
        for (Element inElement : elements) {
          s_elem[iterator] = inElement.text();
          iterator++;
        }
        int iteratorx = 0;
        String[] s_elemx = new String[elements.size()];
        for (Element inputElement : inputElements) {
          s_elemx[iteratorx] = inputElement.text();
          iteratorx++;
        }
        for (int itip = 0; itip < elements.size(); itip++) {
          String tip = s_elem[itip];

          String s = s_elemx[itip];
          if (tip.equals("Безопасность")) {
            house_security(s, ho_ad);
          }
        }
        Elements elementsClient = doc.getElementsByTag("dd");
        Elements elementss = doc.getElementsByTag("dt");
        String[] offer = new String[elementsClient.size()];
        int i_offer = 0;
        for (Element offerElement : elementsClient) {
          offer[i_offer] = offerElement.text();
          i_offer++;
        }
        int i_offerx = 0;
        String[] offerx = new String[elementsClient.size()];
        for (Element offerxElement : elementss) {
          offerx[i_offerx] = offerxElement.text();
          i_offerx++;
        }
        for (int itip = 0; itip < elementsClient.size(); itip++) {
          String s = offer[itip];
          String f = offerx[itip];
          if (f.equals("Безопасность")) {
            house_security(s, ho_ad);
          }
        }
        String s = doc.getElementsByClass("gallery__main").first().child(1).child(0).child(2).attr("src");
        String file_name = doc.getElementsByClass("gallery__main").first().child(1).child(0).child(2).attr("alt");
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
          e.printStackTrace();
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
        c_tbl_rec_img_moder.setC_img_kind(1);
        c_tbl_rec_img_moder.setC_img_status(2);
        c_tbl_rec_img_moder.setIs_deleted(Boolean.FALSE);
        c_tbl_rec_img_moder.setC_img(c_Img.getC_img());

        c_tbl_rec_img_moder_repository.save(c_tbl_rec_img_moder);
      } catch (NullPointerException ex) {
      }

      try {
        Elements elementsClient = doc.getElementsByClass("gallery__small-item");
        String[] offer = new String[elementsClient.size()];
        String[] offerx = new String[elementsClient.size()];
        int i_offer = 0;
        for (Element offerElement : elementsClient) {
          offer[i_offer] = offerElement.child(0).child(2).attr("src");
          System.out.println(offer[i_offer]);
          offerx[i_offer] = offerElement.child(0).child(2).attr("alt");
          System.out.println(offerx[i_offer]);
          i_offer++;
        }
        System.out.println("test2");
        for (int l = 0; l < elementsClient.size(); l++) {
          String s = offer[l];
          String file_name = offerx[l];
          System.out.println(s);
          System.out.println(file_name);

          C_Bin_File_Body c_Bin_File_Body = new C_Bin_File_Body();
          URL url = new URL(s);
          System.out.println("lkjhlkjhoiutbtgy");
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
            e.printStackTrace();
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
      } catch (NullPointerException ex) {
      }
    }
  }

  @GetMapping("/ofis")
  public void ofis() throws FileNotFoundException, InterruptedException, IOException {
    File file = new File("C:\\Users\\User\\Downloads\\demo\\parse");
    Scanner scanner = new Scanner(file);
    int has = 0;
    while (scanner.hasNextLine()) {
      Thread.sleep(2000);
      Ho_Ad ho_ad = new Ho_Ad();
      String stringt = scanner.nextLine();
      Date timestamp = new Date();
      ho_ad.setIns_dt(timestamp);
      ho_ad.setIs_deleted(Boolean.FALSE);
      ho_ad.setC_country(2);
      ho_ad.setIs_agree_with_rules(true);
      ho_ad.setHo_usr(1L);
      ho_ad.setHo_cat(26);//26
      ho_ad.setHo_ad_status(1);
      Document doc;
      try {
        doc = (Document) Jsoup.connect(stringt).get();
        Thread.sleep(2000);
        Element element = doc.getElementById("jsdata");
        String kord = String.valueOf(element);
        String k = "";
        int d2 = 0;
        for (int i = 0; i < kord.length(); i++) {
          if (kord.charAt(i) == '"' && kord.charAt(i + 1) == 'l' && kord.charAt(i + 2) == 'a' && kord.charAt(i + 3) == 't' && kord.charAt(i + 4) == '"') {
            d2 = i + 6;
          }
        }
        for (int i = d2; i < kord.length(); i++) {
          if (kord.charAt(i) == ',') {
            break;
          }
          k += kord.charAt(i);
        }
        String k1 = "";
        int d1 = 0;
        for (int i = 0; i < kord.length(); i++) {
          if (kord.charAt(i) == '"' && kord.charAt(i + 1) == 'l' && kord.charAt(i + 2) == 'o' && kord.charAt(i + 3) == 'n' && kord.charAt(i + 4) == '"') {
            d1 = i + 6;
          }
        }
        for (int i = d1; i < kord.length(); i++) {
          if (kord.charAt(i) == ',') {
            break;
          }
          k1 += kord.charAt(i);
        }
        ho_ad.setLat(Double.parseDouble(k));
        ho_ad.setLon(Double.parseDouble(k1));
        System.out.println("test");
        String r = doc.getElementsByClass("offer__advert-title").first().child(0).text();
        System.out.println("tset");
        String room = "";
        for (int i = 0; i < r.length(); i++) {
          if (r.charAt(i) == '-') {
            break;
          }
          room += r.charAt(i);
        }

        System.out.println(r);
        System.out.println(room);
        int utirr = 0;
        int utir = 0;
        while (utir < r.length()) {
          if (r.charAt(utir) == ',') {
            utirr++;
          }
          utir++;
        }
        int i = 0;
        while (true) {
          if (r.charAt(i) == ',') {
            break;
          }
          i++;
        }
        i = i + 1;
        String street = "";
        while (i < r.length()) {
          street += r.charAt(i);
          i++;
        }
        ho_ad.setStreet_name(street);
        System.out.println("ioipoipoipo");
        String kl = doc.getElementsByClass("offer__price").text();
        String kli = kl;
        int d = 0;
        String lk = "";
        while (d < kli.length()) {
          if (kli.charAt(d) == '0' || kli.charAt(d) == '1' || kli.charAt(d) == '2' || kli.charAt(d) == '3' || kli.charAt(d) == '4'
            || kli.charAt(d) == '5' || kli.charAt(d) == '6' || kli.charAt(d) == '7' || kli.charAt(d) == '8' || kli.charAt(d) == '9') {
            lk += kli.charAt(d);
          }
          d++;
        }

        ho_ad.setPrice(Double.valueOf(lk));

        String loc = doc.getElementsByClass("offer__location").first().child(0).text();
        HoAdCatResponse c_tbl_rec_corr_by_name1 = c_tbl_rec_corr_by_name_repository.find_by_name(loc);
        C_Tbl_Rec_Corr_By_Name c_tbl_rec_corr_by_name = new C_Tbl_Rec_Corr_By_Name();
        if (c_tbl_rec_corr_by_name1 != null) {
          if (c_tbl_rec_corr_by_name1.getName().equals(loc)) {
            ho_ad.setC_loc(c_tbl_rec_corr_by_name1.getId());
          }
        } else {
          c_tbl_rec_corr_by_name.setC_tbl(24);
          c_tbl_rec_corr_by_name.setName(loc);
          c_tbl_rec_corr_by_name.setRec_id(147L);
          c_tbl_rec_corr_by_name.setIs_deleted(false);
          c_tbl_rec_corr_by_name_repository.save(c_tbl_rec_corr_by_name);
          ho_ad.setC_loc(c_tbl_rec_corr_by_name.getRec_id().intValue());
        }
        try {
          ho_ad.setTxt(doc.getElementsByClass("a-text").first().text());
        } catch (NullPointerException e) {
          System.out.println("jkljkl");
        }
        Elements inputElements = doc.getElementsByClass("offer__advert-short-info");

        Elements elements = doc.getElementsByClass("offer__info-title");
        String[] s_elem = new String[elements.size()];
        int iterator = 0;
        for (Element inElement : elements) {
          s_elem[iterator] = inElement.text();
          iterator++;
        }
        int iteratorx = 0;
        String[] s_elemx = new String[elements.size()];
        for (Element inputElement : inputElements) {
          s_elemx[iteratorx] = inputElement.text();
          iteratorx++;
        }
        System.out.println("Tip doma");
        for (int itip = 0; itip < elements.size(); itip++) {
          String tip = s_elem[itip];
          System.out.println(itip);
          if (tip.equals("Город")) {
            continue;
          }
          String s = s_elemx[itip];

          if (tip.equals("Тип строения")) {
            int dell = 0;
            for (int n = 0; n < s.length(); n++) {
              if (s.charAt(n) == ',') {
                dell++;
              }
            }
            if (dell > 0) {
              String tips = "";
              for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == ',') {
                  break;
                }
                tips += s.charAt(j);
              }
              tipdoma(tips, ho_ad);
              String year = "";
              for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == '0' || s.charAt(j) == '1' || s.charAt(j) == '2' || s.charAt(j) == '3' || s.charAt(j) == '4'
                  || s.charAt(j) == '5' || s.charAt(j) == '6' || s.charAt(j) == '7' || s.charAt(j) == '8' || s.charAt(j) == '9') {
                  year += s.charAt(j);
                }
              }
              ho_ad.setConstruction_year(Integer.parseInt(year));
            } else {
              tipdoma(s, ho_ad);
            }
          } else if (tip.equals("Количество уровней")) {
            ho_ad.setLevel_num(Integer.valueOf(s));
          } else if (tip.equals("Канализация")) {
            sewerage(s, ho_ad);
          } else if (tip.equals("Что именно?")) {
            shop_type(s, ho_ad);
          } else if (tip.equals("Местоположение")) {
            house_loc(s, ho_ad);
          } else if (tip.equals("Цена в месяц")) {
            land_price(s, ho_ad);
          } else if (tip.equals("Название торгового центра, рынка")) {
            ho_ad.setShop_center_name(s);
          } else if (tip.equals("Электричество")) {
            electricity(s, ho_ad);
          } else if (tip.equals("Отопление")) {
            heating(s, ho_ad);
          } else if (tip.equals("Газ")) {
            gas(s, ho_ad);
          } else if (tip.equals("Название бизнес центра")) {
            ho_ad.setBusiness_center_name(s);
          } else if (tip.equals("Вода")) {
            drink_water(s, ho_ad);
          } else if (tip.equals("Площадь дома, м²")) {
            ho_ad.setHouse_area(Double.parseDouble(s));
          } else if (tip.equals("Общая площадь, м²")) {
            ho_ad.setTotal_area(Double.parseDouble(s));
          } else if (tip.equals("Площадь участка, соток")) {
            ho_ad.setAdj_territory_area(Double.parseDouble(s));
          } else if (tip.equals("Парковка")) {
            ho_ad.setParking(s);
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
          } else if (tip.equals("Кол-во телефонных линий")) {
            ho_ad.setPhone_lines_num(Integer.parseInt(s));
          } else if (tip.equals("Возможен обмен")) {
            is_exch_possible(s, ho_ad);
          } else if (tip.equals("Тип офиса")) {
            type_office(s, ho_ad);
          } else if (tip.equals("Год постройки")) {
            String year = "";
            for (int j = 0; j < s.length(); j++) {
              if (s.charAt(j) == '0' || s.charAt(j) == '1' || s.charAt(j) == '2' || s.charAt(j) == '3' || s.charAt(j) == '4'
                || s.charAt(j) == '5' || s.charAt(j) == '6' || s.charAt(j) == '7' || s.charAt(j) == '8' || s.charAt(j) == '9') {
                year += s.charAt(j);
              }
            }
            ho_ad.setConstruction_year(Integer.parseInt(year));
          } else if (tip.equals("Высота потолков")) {
            ceiling(s, ho_ad);
          } else if (tip.equals("Количество комнат")) {
            ho_ad.setRoom_cnt(Integer.parseInt(s));
          } else if (tip.equals("Покрытие крыши")) {
            ho_ad.setRoofing(s);
          } else if (tip.equals("Как огорожен участок")) {
            ho_ad.setHow_area_fenced(s);
          } else if (tip.equals("Участок")) {
            String lare = "";
            for (int l = 0; l < s.length(); l++) {
              if (s.charAt(l) == ' ') {
                break;
              }
              lare += s.charAt(l);
            }
            ho_ad.setLand_area(Double.parseDouble(lare));
          } else if (tip.equals("Дверь")) {
            door(s, ho_ad);
          } //            else  if(tip.equals("Площадь участка, соток"))
          //             ho_ad.setTotal_area(Double.parseDouble(s));
          else if (tip.equals("Поливная вода")) {
            water(s, ho_ad);
          }
        }
        System.out.println("god postroikiy");
        try {
          String contact = doc.getElementsByClass("label-user-identified-specialist").first().text();
          System.out.println(contact);
          List<Ho_Contact_Info_Type> ho_cit = repc.find_all1();
          for (Ho_Contact_Info_Type ho_usr : ho_cit) {
            if (ho_usr.getName().equals(contact)) {
              ho_ad.setHo_contact_info_type(ho_usr.getHo_contact_info_type());
              break;
            }
          }
        } catch (NullPointerException e) {
          try {
            String contact = doc.getElementsByClass("builder__contacts").text();
            System.out.println(contact);
            List<Ho_Contact_Info_Type> ho_cit = repc.find_all1();
            for (Ho_Contact_Info_Type ho_usr : ho_cit) {
              if (ho_usr.getName().equals(contact)) {
                ho_ad.setHo_contact_info_type(ho_usr.getHo_contact_info_type());
                break;
              }
            }
          } catch (NullPointerException ex) {

            try {
              String contact = doc.getElementsByClass("owners__label owners__label--default label-user-agent").first().text();
              System.out.println(contact);
              List<Ho_Contact_Info_Type> ho_cit = repc.find_all1();
              for (Ho_Contact_Info_Type ho_usr : ho_cit) {
                if (ho_usr.getName().equals(contact)) {
                  ho_ad.setHo_contact_info_type(ho_usr.getHo_contact_info_type());
                  break;
                }
              }
            } catch (NullPointerException exp) {
              String contact = doc.getElementsByClass("owners__name owners__name--large").text();
              System.out.println(contact);
              List<Ho_Contact_Info_Type> ho_cit = repc.find_all1();
              for (Ho_Contact_Info_Type ho_usr : ho_cit) {
                if (ho_usr.getName().equals(contact)) {
                  ho_ad.setHo_contact_info_type(ho_usr.getHo_contact_info_type());
                  break;
                }
              }

            }
          }
        }
        System.out.println("kljhjklhkjhk");
        Elements elementsClient = doc.getElementsByTag("dd");
        Elements elementss = doc.getElementsByTag("dt");
        String[] offer = new String[elementsClient.size()];
        int i_offer = 0;
        for (Element offerElement : elementsClient) {
          offer[i_offer] = offerElement.text();
          i_offer++;
        }
        int i_offerx = 0;
        String[] offerx = new String[elementsClient.size()];
        for (Element offerxElement : elementss) {
          offerx[i_offerx] = offerxElement.text();
          i_offerx++;
        }
        for (int itip = 0; itip < elementsClient.size(); itip++) {
          String s = offer[itip];
          String f = offerx[itip];
          if (f.equals("В залоге")) {
            is_pledged(s, ho_ad);
          } else if (f.equals("Потолки")) {
            ceiling(s, ho_ad);
          } else if (f.equals("Поливная вода")) {
            water(s, ho_ad);
          } else if (f.equals("Кол-во телефонных линий")) {
            ho_ad.setPhone_lines_num(Integer.parseInt(s));
          } else if (f.equals("Покрытие крыши")) {
            ho_ad.setRoofing(s);
          } else if (f.equals("Что именно?")) {
            shop_type(s, ho_ad);
          } else if (f.equals("Местоположение")) {
            house_loc(s, ho_ad);
          } else if (f.equals("Название торгового центра, рынка")) {
            ho_ad.setShop_center_name(s);
          } else if (f.equals("Площадь участка, соток")) {
            ho_ad.setAdj_territory_area(Double.parseDouble(s));
          } else if (f.equals("Как огорожен участок")) {
            ho_ad.setHow_area_fenced(s);
          } else if (f.equals("Парковка")) {
            ho_ad.setParking(s);
          } else if (f.equals("Отдельная входная группа")) {
            is_has_sep_entr_group(s, ho_ad);
          } else if (f.equals("Возможен обмен")) {
            is_exch_possible(s, ho_ad);
          } else if (f.equals("Канализация")) {
            sewerage(s, ho_ad);
          } else if (f.equals("Участок")) {
            String lare = "";
            for (int l = 0; l < s.length(); l++) {
              if (s.charAt(l) == ' ') {
                break;
              }
              lare += s.charAt(l);
            }
            ho_ad.setLand_area(Double.parseDouble(lare));
          } else if (f.equals("Электричество")) {
            electricity(s, ho_ad);
          } else if (f.equals("Отопление")) {
            heating(s, ho_ad);
          } else if (f.equals("Газ")) {
            gas(s, ho_ad);
          } else if (f.equals("Вода")) {
            drink_water(s, ho_ad);
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
          } else if (f.equals("Дверь")) {
            door(s, ho_ad);

          }
        }
        System.out.println("text");

      } catch (IOException ex) {
        continue;
      }
      System.out.println(has);
      has++;
      ho_Ad_Service.saveOrUpdate(ho_ad);

      try {
        Elements inputElements = doc.getElementsByClass("offer__advert-short-info");
        Elements elements = doc.getElementsByClass("offer__info-title");
        String[] s_elem = new String[elements.size()];
        int iterator = 0;
        for (Element inElement : elements) {
          s_elem[iterator] = inElement.text();
          iterator++;
        }
        int iteratorx = 0;
        String[] s_elemx = new String[elements.size()];
        for (Element inputElement : inputElements) {
          s_elemx[iteratorx] = inputElement.text();
          iteratorx++;
        }
        for (int itip = 0; itip < elements.size(); itip++) {
          String tip = s_elem[itip];

          String s = s_elemx[itip];
          if (tip.equals("Безопасность")) {
            house_security(s, ho_ad);
          }
        }
        Elements elementsClient = doc.getElementsByTag("dd");
        Elements elementss = doc.getElementsByTag("dt");
        String[] offer = new String[elementsClient.size()];
        int i_offer = 0;
        for (Element offerElement : elementsClient) {
          offer[i_offer] = offerElement.text();
          i_offer++;
        }
        int i_offerx = 0;
        String[] offerx = new String[elementsClient.size()];
        for (Element offerxElement : elementss) {
          offerx[i_offerx] = offerxElement.text();
          i_offerx++;
        }
        for (int itip = 0; itip < elementsClient.size(); itip++) {
          String s = offer[itip];
          String f = offerx[itip];
          if (f.equals("Безопасность")) {
            house_security(s, ho_ad);
          }
        }
        String s = doc.getElementsByClass("gallery__main").first().child(1).child(0).child(2).attr("src");
        String file_name = doc.getElementsByClass("gallery__main").first().child(1).child(0).child(2).attr("alt");
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
          e.printStackTrace();
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
        c_tbl_rec_img_moder.setC_img_kind(1);
        c_tbl_rec_img_moder.setC_img_status(2);
        c_tbl_rec_img_moder.setIs_deleted(Boolean.FALSE);
        c_tbl_rec_img_moder.setC_img(c_Img.getC_img());

        c_tbl_rec_img_moder_repository.save(c_tbl_rec_img_moder);
      } catch (NullPointerException ex) {
      }

      try {
        Elements elementsClient = doc.getElementsByClass("gallery__small-item");
        String[] offer = new String[elementsClient.size()];
        String[] offerx = new String[elementsClient.size()];
        int i_offer = 0;
        for (Element offerElement : elementsClient) {
          offer[i_offer] = offerElement.child(0).child(2).attr("src");
          System.out.println(offer[i_offer]);
          offerx[i_offer] = offerElement.child(0).child(2).attr("alt");
          System.out.println(offerx[i_offer]);
          i_offer++;
        }
        System.out.println("test2");
        for (int l = 0; l < elementsClient.size(); l++) {
          String s = offer[l];
          String file_name = offerx[l];
          System.out.println(s);
          System.out.println(file_name);

          C_Bin_File_Body c_Bin_File_Body = new C_Bin_File_Body();
          URL url = new URL(s);
          System.out.println("lkjhlkjhoiutbtgy");
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
            e.printStackTrace();
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
      } catch (NullPointerException ex) {
      }
    }
  }

  @GetMapping("/pomeshenie")
  public void pomeshenie() throws FileNotFoundException, InterruptedException, IOException {
    File file = new File("C:\\Users\\User\\Downloads\\demo\\parse");
    Scanner scanner = new Scanner(file);
    int has = 0;
    while (scanner.hasNextLine()) {
      Thread.sleep(2000);
      Ho_Ad ho_ad = new Ho_Ad();
      String stringt = scanner.nextLine();
      Date timestamp = new Date();
      ho_ad.setIns_dt(timestamp);
      ho_ad.setIs_deleted(Boolean.FALSE);
      ho_ad.setC_country(2);
      ho_ad.setIs_agree_with_rules(true);
      ho_ad.setHo_usr(1L);
      ho_ad.setHo_cat(27);//27
      ho_ad.setHo_ad_status(1);
      Document doc;
      try {
        doc = (Document) Jsoup.connect(stringt).get();
        Thread.sleep(2000);
        Element element = doc.getElementById("jsdata");
        String kord = String.valueOf(element);
        String k = "";
        int d2 = 0;
        for (int i = 0; i < kord.length(); i++) {
          if (kord.charAt(i) == '"' && kord.charAt(i + 1) == 'l' && kord.charAt(i + 2) == 'a' && kord.charAt(i + 3) == 't' && kord.charAt(i + 4) == '"') {
            d2 = i + 6;
          }
        }
        for (int i = d2; i < kord.length(); i++) {
          if (kord.charAt(i) == ',') {
            break;
          }
          k += kord.charAt(i);
        }
        String k1 = "";
        int d1 = 0;
        for (int i = 0; i < kord.length(); i++) {
          if (kord.charAt(i) == '"' && kord.charAt(i + 1) == 'l' && kord.charAt(i + 2) == 'o' && kord.charAt(i + 3) == 'n' && kord.charAt(i + 4) == '"') {
            d1 = i + 6;
          }
        }
        for (int i = d1; i < kord.length(); i++) {
          if (kord.charAt(i) == ',') {
            break;
          }
          k1 += kord.charAt(i);
        }
        ho_ad.setLat(Double.parseDouble(k));
        ho_ad.setLon(Double.parseDouble(k1));
        System.out.println("test");
        String r = doc.getElementsByClass("offer__advert-title").first().child(0).text();
        System.out.println("tset");
        String room = "";
        for (int i = 0; i < r.length(); i++) {
          if (r.charAt(i) == '-') {
            break;
          }
          room += r.charAt(i);
        }

        System.out.println(r);
        System.out.println(room);
        int utirr = 0;
        int utir = 0;
        while (utir < r.length()) {
          if (r.charAt(utir) == ',') {
            utirr++;
          }
          utir++;
        }
        int i = 0;
        while (true) {
          if (r.charAt(i) == ',') {
            break;
          }
          i++;
        }
        i = i + 1;
        String street = "";
        while (i < r.length()) {
          street += r.charAt(i);
          i++;
        }
        ho_ad.setStreet_name(street);
        System.out.println("ioipoipoipo");
        String kl = doc.getElementsByClass("offer__price").text();
        String kli = kl;
        int d = 0;
        String lk = "";
        while (d < kli.length()) {
          if (kli.charAt(d) == '0' || kli.charAt(d) == '1' || kli.charAt(d) == '2' || kli.charAt(d) == '3' || kli.charAt(d) == '4'
            || kli.charAt(d) == '5' || kli.charAt(d) == '6' || kli.charAt(d) == '7' || kli.charAt(d) == '8' || kli.charAt(d) == '9') {
            lk += kli.charAt(d);
          }
          d++;
        }

        ho_ad.setPrice(Double.valueOf(lk));
        String loc = doc.getElementsByClass("offer__location").first().child(0).text();
        HoAdCatResponse c_tbl_rec_corr_by_name1 = c_tbl_rec_corr_by_name_repository.find_by_name(loc);
        C_Tbl_Rec_Corr_By_Name c_tbl_rec_corr_by_name = new C_Tbl_Rec_Corr_By_Name();
        if (c_tbl_rec_corr_by_name1 != null) {
          if (c_tbl_rec_corr_by_name1.getName().equals(loc)) {
            ho_ad.setC_loc(c_tbl_rec_corr_by_name1.getId());
          }
        } else {
          c_tbl_rec_corr_by_name.setC_tbl(24);
          c_tbl_rec_corr_by_name.setName(loc);
          c_tbl_rec_corr_by_name.setRec_id(147L);
          c_tbl_rec_corr_by_name.setIs_deleted(false);
          c_tbl_rec_corr_by_name_repository.save(c_tbl_rec_corr_by_name);
          ho_ad.setC_loc(c_tbl_rec_corr_by_name.getRec_id().intValue());
        }
        try {
          ho_ad.setTxt(doc.getElementsByClass("a-text").first().text());
        } catch (NullPointerException e) {
        }
        Elements inputElements = doc.getElementsByClass("offer__advert-short-info");
        Elements elements = doc.getElementsByClass("offer__info-title");
        String[] s_elem = new String[elements.size()];
        int iterator = 0;
        for (Element inElement : elements) {
          s_elem[iterator] = inElement.text();
          iterator++;
        }
        int iteratorx = 0;
        String[] s_elemx = new String[elements.size()];
        for (Element inputElement : inputElements) {
          s_elemx[iteratorx] = inputElement.text();
          iteratorx++;
        }
        System.out.println("Tip doma");
        for (int itip = 0; itip < elements.size(); itip++) {
          String tip = s_elem[itip];
          String s = s_elemx[itip];
          if (tip.equals("Общая площадь, м²")) {
            ho_ad.setTotal_area(Double.parseDouble(s));
          } else if (tip.equals("Парковка")) {
            ho_ad.setParking(s);
          } else if (tip.equals("Состояние")) {
            condition(s, ho_ad);
          } else if (tip.equals("Интернет")) {
            inet(s, ho_ad);
          } else if (tip.equals("Кол-во телефонных линий")) {
            ho_ad.setPhone_lines_num(Integer.parseInt(s));
          } else if (tip.equals("Возможен обмен")) {
            is_exch_possible(s, ho_ad);
          }  else if (tip.equals("Цена в месяц")) {
            land_price(s, ho_ad);
          } else if (tip.equals("Тип офиса")) {
            type_office(s, ho_ad);
          } else if (tip.equals("Год постройки")) {
            String year = "";
            for (int j = 0; j < s.length(); j++) {
              if (s.charAt(j) == '0' || s.charAt(j) == '1' || s.charAt(j) == '2' || s.charAt(j) == '3' || s.charAt(j) == '4'
                || s.charAt(j) == '5' || s.charAt(j) == '6' || s.charAt(j) == '7' || s.charAt(j) == '8' || s.charAt(j) == '9') {
                year += s.charAt(j);
              }
            }
            ho_ad.setConstruction_year(Integer.parseInt(year));
          } else if (tip.equals("Потолки")) {
            ceiling(s, ho_ad);
          }
        }
        System.out.println("god postroikiy");
        try {
          String contact = doc.getElementsByClass("label-user-identified-specialist").first().text();
          System.out.println(contact);
          List<Ho_Contact_Info_Type> ho_cit = repc.find_all1();
          for (Ho_Contact_Info_Type ho_usr : ho_cit) {
            if (ho_usr.getName().equals(contact)) {
              ho_ad.setHo_contact_info_type(ho_usr.getHo_contact_info_type());
              break;
            }
          }
        } catch (NullPointerException e) {
          try {
            String contact = doc.getElementsByClass("builder__contacts").text();
            System.out.println(contact);
            List<Ho_Contact_Info_Type> ho_cit = repc.find_all1();
            for (Ho_Contact_Info_Type ho_usr : ho_cit) {
              if (ho_usr.getName().equals(contact)) {
                ho_ad.setHo_contact_info_type(ho_usr.getHo_contact_info_type());
                break;
              }
            }
          } catch (NullPointerException ex) {

            try {
              String contact = doc.getElementsByClass("owners__label owners__label--default label-user-agent").first().text();
              System.out.println(contact);
              List<Ho_Contact_Info_Type> ho_cit = repc.find_all1();
              for (Ho_Contact_Info_Type ho_usr : ho_cit) {
                if (ho_usr.getName().equals(contact)) {
                  ho_ad.setHo_contact_info_type(ho_usr.getHo_contact_info_type());
                  break;
                }
              }
            } catch (NullPointerException exp) {
              String contact = doc.getElementsByClass("owners__name owners__name--large").text();
              System.out.println(contact);
              List<Ho_Contact_Info_Type> ho_cit = repc.find_all1();
              for (Ho_Contact_Info_Type ho_usr : ho_cit) {
                if (ho_usr.getName().equals(contact)) {
                  ho_ad.setHo_contact_info_type(ho_usr.getHo_contact_info_type());
                  break;
                }
              }

            }
          }
        }
        System.out.println("kljhjklhkjhk");
        Elements elementsClient = doc.getElementsByTag("dd");
        Elements elementss = doc.getElementsByTag("dt");
        String[] offer = new String[elementsClient.size()];
        int i_offer = 0;
        for (Element offerElement : elementsClient) {
          offer[i_offer] = offerElement.text();
          i_offer++;
        }
        int i_offerx = 0;
        String[] offerx = new String[elementsClient.size()];
        for (Element offerxElement : elementss) {
          offerx[i_offerx] = offerxElement.text();
          i_offerx++;
        }
        for (int itip = 0; itip < elementsClient.size(); itip++) {
          String s = offer[itip];
          String f = offerx[itip];
          if (f.equals("В залоге")) {
            is_pledged(s, ho_ad);
          } else if (f.equals("Состояние")) {
            condition(s, ho_ad);
          } else if (f.equals("Потолки")) {
            ceiling(s, ho_ad);
          } else if (f.equals("Кол-во телефонных линий")) {
            ho_ad.setPhone_lines_num(Integer.parseInt(s));
          } else if (f.equals("Площадь участка, соток")) {
            ho_ad.setAdj_territory_area(Double.parseDouble(s));
          } else if (f.equals("Парковка")) {
            ho_ad.setParking(s);
          } else if (f.equals("Возможен обмен")) {
            is_exch_possible(s, ho_ad);
          } else if (f.equals("Участок")) {
            String lare = "";
            for (int l = 0; l < s.length(); l++) {
              if (s.charAt(l) == ' ') {
                break;
              }
              lare += s.charAt(l);
            }
            ho_ad.setLand_area(Double.parseDouble(lare));
          } else if (f.equals("Интернет")) {
            inet(s, ho_ad);
          }
        }
        System.out.println("text");

      } catch (IOException ex) {
        continue;
      }
      System.out.println(has);
      has++;
      ho_Ad_Service.saveOrUpdate(ho_ad);

      try {
        Elements inputElements = doc.getElementsByClass("offer__advert-short-info");
        Elements elements = doc.getElementsByClass("offer__info-title");
        String[] s_elem = new String[elements.size()];
        int iterator = 0;
        for (Element inElement : elements) {
          s_elem[iterator] = inElement.text();
          iterator++;
        }
        int iteratorx = 0;
        String[] s_elemx = new String[elements.size()];
        for (Element inputElement : inputElements) {
          s_elemx[iteratorx] = inputElement.text();
          iteratorx++;
        }
        for (int itip = 0; itip < elements.size(); itip++) {
          String tip = s_elem[itip];

          String s = s_elemx[itip];
          if (tip.equals("Безопасность")) {
            house_security(s, ho_ad);
          }
        }
        Elements elementsClient = doc.getElementsByTag("dd");
        Elements elementss = doc.getElementsByTag("dt");
        String[] offer = new String[elementsClient.size()];
        int i_offer = 0;
        for (Element offerElement : elementsClient) {
          offer[i_offer] = offerElement.text();
          i_offer++;
        }
        int i_offerx = 0;
        String[] offerx = new String[elementsClient.size()];
        for (Element offerxElement : elementss) {
          offerx[i_offerx] = offerxElement.text();
          i_offerx++;
        }
        for (int itip = 0; itip < elementsClient.size(); itip++) {
          String s = offer[itip];
          String f = offerx[itip];
          if (f.equals("Безопасность")) {
            house_security(s, ho_ad);
          }
        }
        String s = doc.getElementsByClass("gallery__main").first().child(1).child(0).child(2).attr("src");
        String file_name = doc.getElementsByClass("gallery__main").first().child(1).child(0).child(2).attr("alt");
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
          e.printStackTrace();
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
        c_tbl_rec_img_moder.setC_img_kind(1);
        c_tbl_rec_img_moder.setC_img_status(2);
        c_tbl_rec_img_moder.setIs_deleted(Boolean.FALSE);
        c_tbl_rec_img_moder.setC_img(c_Img.getC_img());

        c_tbl_rec_img_moder_repository.save(c_tbl_rec_img_moder);
      } catch (NullPointerException ex) {
      }

      try {
        Elements elementsClient = doc.getElementsByClass("gallery__small-item");
        String[] offer = new String[elementsClient.size()];
        String[] offerx = new String[elementsClient.size()];
        int i_offer = 0;
        for (Element offerElement : elementsClient) {
          offer[i_offer] = offerElement.child(0).child(2).attr("src");
          System.out.println(offer[i_offer]);
          offerx[i_offer] = offerElement.child(0).child(2).attr("alt");
          System.out.println(offerx[i_offer]);
          i_offer++;
        }
        System.out.println("test2");
        for (int l = 0; l < elementsClient.size(); l++) {
          String s = offer[l];
          String file_name = offerx[l];
          System.out.println(s);
          System.out.println(file_name);

          C_Bin_File_Body c_Bin_File_Body = new C_Bin_File_Body();
          URL url = new URL(s);
          System.out.println("lkjhlkjhoiutbtgy");
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
            e.printStackTrace();
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
      } catch (NullPointerException ex) {
      }
    }
  }

  @GetMapping("/uchastokprodat")
  public void uchastokprodat() throws FileNotFoundException, InterruptedException, IOException {
    File file = new File("C:\\Users\\User\\Downloads\\demo\\parse");
    Scanner scanner = new Scanner(file);
    int has = 0;
    while (scanner.hasNextLine()) {
      Thread.sleep(2000);
      Ho_Ad ho_ad = new Ho_Ad();
      String stringt = scanner.nextLine();
      Date timestamp = new Date();
      ho_ad.setIns_dt(timestamp);
      ho_ad.setIs_deleted(Boolean.FALSE);
      ho_ad.setC_country(2);
      ho_ad.setIs_agree_with_rules(true);
      ho_ad.setHo_usr(1L);
      ho_ad.setHo_cat(13);
      ho_ad.setHo_ad_status(1);
      Document doc;
      try {
        doc = (Document) Jsoup.connect(stringt).get();
        Thread.sleep(2000);
        Element element = doc.getElementById("jsdata");
        String kord = String.valueOf(element);
        String k = "";
        int d2 = 0;
        for (int i = 0; i < kord.length(); i++) {
          if (kord.charAt(i) == '"' && kord.charAt(i + 1) == 'l' && kord.charAt(i + 2) == 'a' && kord.charAt(i + 3) == 't' && kord.charAt(i + 4) == '"') {
            d2 = i + 6;
          }
        }
        for (int i = d2; i < kord.length(); i++) {
          if (kord.charAt(i) == ',') {
            break;
          }
          k += kord.charAt(i);
        }
        String k1 = "";
        int d1 = 0;
        for (int i = 0; i < kord.length(); i++) {
          if (kord.charAt(i) == '"' && kord.charAt(i + 1) == 'l' && kord.charAt(i + 2) == 'o' && kord.charAt(i + 3) == 'n' && kord.charAt(i + 4) == '"') {
            d1 = i + 6;
          }
        }
        for (int i = d1; i < kord.length(); i++) {
          if (kord.charAt(i) == ',') {
            break;
          }
          k1 += kord.charAt(i);
        }
        ho_ad.setLat(Double.parseDouble(k));
        ho_ad.setLon(Double.parseDouble(k1));
        System.out.println("test");
        String r = doc.getElementsByClass("offer__advert-title").first().child(0).text();
        System.out.println("tset");
        String room = "";
        for (int i = 0; i < r.length(); i++) {
          if (r.charAt(i) == '-') {
            break;
          }
          room += r.charAt(i);
        }

        System.out.println(r);
        System.out.println(room);
        int utirr = 0;
        int utir = 0;
        while (utir < r.length()) {
          if (r.charAt(utir) == ',') {
            utirr++;
          }
          utir++;
        }
        int i = 0;
        while (true) {
          if (r.charAt(i) == ',') {
            break;
          }
          i++;
        }
        i = i + 1;
        String street = "";
        while (i < r.length()) {
          street += r.charAt(i);
          i++;
        }
        ho_ad.setStreet_name(street);
        String kl = doc.getElementsByClass("offer__price").text();
        String kli = kl;
        int d = 0;
        String lk = "";
        while (d < kli.length()) {
          if (kli.charAt(d) == '0' || kli.charAt(d) == '1' || kli.charAt(d) == '2' || kli.charAt(d) == '3' || kli.charAt(d) == '4'
            || kli.charAt(d) == '5' || kli.charAt(d) == '6' || kli.charAt(d) == '7' || kli.charAt(d) == '8' || kli.charAt(d) == '9') {
            lk += kli.charAt(d);
          }
          d++;
        }

        ho_ad.setPrice(Double.valueOf(lk));

        String loc = doc.getElementsByClass("offer__location").first().child(0).text();
        HoAdCatResponse c_tbl_rec_corr_by_name1 = c_tbl_rec_corr_by_name_repository.find_by_name(loc);
        C_Tbl_Rec_Corr_By_Name c_tbl_rec_corr_by_name = new C_Tbl_Rec_Corr_By_Name();
        if (c_tbl_rec_corr_by_name1 != null) {
          if (c_tbl_rec_corr_by_name1.getName().equals(loc)) {
            ho_ad.setC_loc(c_tbl_rec_corr_by_name1.getId());
          }
        } else {
          c_tbl_rec_corr_by_name.setC_tbl(24);
          c_tbl_rec_corr_by_name.setName(loc);
          c_tbl_rec_corr_by_name.setRec_id(147L);
          c_tbl_rec_corr_by_name.setIs_deleted(false);
          c_tbl_rec_corr_by_name_repository.save(c_tbl_rec_corr_by_name);
          ho_ad.setC_loc(c_tbl_rec_corr_by_name.getRec_id().intValue());
        }
        try {
          ho_ad.setTxt(doc.getElementsByClass("a-text").first().text());
        } catch (NullPointerException e) {
          System.out.println("jkljkl");
        }
        Elements inputElements = doc.getElementsByClass("offer__advert-short-info");
        Elements elements = doc.getElementsByClass("offer__info-title");
        String[] s_elem = new String[elements.size()];
        int iterator = 0;
        for (Element inElement : elements) {
          s_elem[iterator] = inElement.text();
          iterator++;
        }
        int iteratorx = 0;
        String[] s_elemx = new String[elements.size()];
        for (Element inputElement : inputElements) {
          s_elemx[iteratorx] = inputElement.text();
          iteratorx++;
        }
        System.out.println("Tip doma");
        for (int itip = 0; itip < elements.size(); itip++) {
          String tip = s_elem[itip];
          System.out.println(itip);
          String s = s_elemx[itip];
          if (tip.equals("Делимость")) {
            Boolean trf = false;
            if (s.equals("делимый")) {
              trf = true;
            }
            ho_ad.setIs_divisible(trf);
          } else if (tip.equals("Целевое назначение")) {
            spec_purpose(s, ho_ad);
          } else if (tip.equals("Цена в месяц")) {
            land_price(s, ho_ad);
          } else if (tip.equals("Площадь участка")) {
            String year = "";
            for (int j = 0; j < s.length(); j++) {
              if (s.charAt(j) == '0' || s.charAt(j) == '1' || s.charAt(j) == '2' || s.charAt(j) == '3' || s.charAt(j) == '4'
                || s.charAt(j) == '5' || s.charAt(j) == '6' || s.charAt(j) == '7' || s.charAt(j) == '8' || s.charAt(j) == '9') {
                year += s.charAt(j);
              }
             
            }
            territory_area_unit(s,ho_ad);
            ho_ad.setAdj_territory_area(Double.parseDouble(year));
          } else if (tip.equals("Возможен обмен")) {
            is_exch_possible(s, ho_ad);
          }
        }
        System.out.println("god postroikiy");
        try {
          String contact = doc.getElementsByClass("label-user-identified-specialist").first().text();
          System.out.println(contact);
          List<Ho_Contact_Info_Type> ho_cit = repc.find_all1();
          for (Ho_Contact_Info_Type ho_usr : ho_cit) {
            if (ho_usr.getName().equals(contact)) {
              ho_ad.setHo_contact_info_type(ho_usr.getHo_contact_info_type());
              break;
            }
          }
        } catch (NullPointerException e) {
          try {
            String contact = doc.getElementsByClass("builder__contacts").text();
            System.out.println(contact);
            List<Ho_Contact_Info_Type> ho_cit = repc.find_all1();
            for (Ho_Contact_Info_Type ho_usr : ho_cit) {
              if (ho_usr.getName().equals(contact)) {
                ho_ad.setHo_contact_info_type(ho_usr.getHo_contact_info_type());
                break;
              }
            }
          } catch (NullPointerException ex) {

            try {
              String contact = doc.getElementsByClass("owners__label owners__label--default label-user-agent").first().text();
              System.out.println(contact);
              List<Ho_Contact_Info_Type> ho_cit = repc.find_all1();
              for (Ho_Contact_Info_Type ho_usr : ho_cit) {
                if (ho_usr.getName().equals(contact)) {
                  ho_ad.setHo_contact_info_type(ho_usr.getHo_contact_info_type());
                  break;
                }
              }
            } catch (NullPointerException exp) {
              String contact = doc.getElementsByClass("owners__name owners__name--large").text();
              System.out.println(contact);
              List<Ho_Contact_Info_Type> ho_cit = repc.find_all1();
              for (Ho_Contact_Info_Type ho_usr : ho_cit) {
                if (ho_usr.getName().equals(contact)) {
                  ho_ad.setHo_contact_info_type(ho_usr.getHo_contact_info_type());
                  break;
                }
              }

            }
          }
        }
        System.out.println("kljhjklhkjhk");
        Elements elementsClient = doc.getElementsByTag("dd");
        Elements elementss = doc.getElementsByTag("dt");
        String[] offer = new String[elementsClient.size()];
        int i_offer = 0;
        for (Element offerElement : elementsClient) {
          offer[i_offer] = offerElement.text();
          i_offer++;
        }
        int i_offerx = 0;
        String[] offerx = new String[elementsClient.size()];
        for (Element offerxElement : elementss) {
          offerx[i_offerx] = offerxElement.text();
          i_offerx++;
        }
        for (int itip = 0; itip < elementsClient.size(); itip++) {
          String s = offer[itip];
          String f = offerx[itip];
          if (f.equals("В залоге")) {
            is_pledged(s, ho_ad);
          } else if (f.equals("Площадь участка, соток")) {
            ho_ad.setAdj_territory_area(Double.parseDouble(s));
          } else if (f.equals("Возможен обмен")) {
            is_exch_possible(s, ho_ad);
          }
        }
        System.out.println("text");
      } catch (IOException ex) {
        continue;
      }
      System.out.println(has);
      has++;
      ho_Ad_Service.saveOrUpdate(ho_ad);

      try {
        Elements inputElements = doc.getElementsByClass("offer__advert-short-info");
        Elements elements = doc.getElementsByClass("offer__info-title");
        String[] s_elem = new String[elements.size()];
        int iterator = 0;
        for (Element inElement : elements) {
          s_elem[iterator] = inElement.text();
          iterator++;
        }
        int iteratorx = 0;
        String[] s_elemx = new String[elements.size()];
        for (Element inputElement : inputElements) {
          s_elemx[iteratorx] = inputElement.text();
          iteratorx++;
        }
        for (int itip = 0; itip < elements.size(); itip++) {
          String tip = s_elem[itip];

          String s = s_elemx[itip];
          if (tip.equals("Коммуникации")) {
            house_commun(s, ho_ad);
          }
          if (tip.equals("Местоположение")) {
            house_ad_loc(s, ho_ad);
          }

        }
        Elements elementsClient = doc.getElementsByTag("dd");
        Elements elementss = doc.getElementsByTag("dt");
        String[] offer = new String[elementsClient.size()];
        int i_offer = 0;
        for (Element offerElement : elementsClient) {
          offer[i_offer] = offerElement.text();
          i_offer++;
        }
        int i_offerx = 0;
        String[] offerx = new String[elementsClient.size()];
        for (Element offerxElement : elementss) {
          offerx[i_offerx] = offerxElement.text();
          i_offerx++;
        }
        for (int itip = 0; itip < elementsClient.size(); itip++) {
          String s = offer[itip];
          String f = offerx[itip];
          if (f.equals("Безопасность")) {
            house_security(s, ho_ad);
          }
        }
        String s = doc.getElementsByClass("gallery__main").first().child(1).child(0).child(2).attr("src");
        String file_name = doc.getElementsByClass("gallery__main").first().child(1).child(0).child(2).attr("alt");
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
          e.printStackTrace();
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
        c_tbl_rec_img_moder.setC_img_kind(1);
        c_tbl_rec_img_moder.setC_img_status(2);
        c_tbl_rec_img_moder.setIs_deleted(Boolean.FALSE);
        c_tbl_rec_img_moder.setC_img(c_Img.getC_img());

        c_tbl_rec_img_moder_repository.save(c_tbl_rec_img_moder);
      } catch (NullPointerException ex) {
      }

      try {
        Elements elementsClient = doc.getElementsByClass("gallery__small-item");
        String[] offer = new String[elementsClient.size()];
        String[] offerx = new String[elementsClient.size()];
        int i_offer = 0;
        for (Element offerElement : elementsClient) {
          offer[i_offer] = offerElement.child(0).child(2).attr("src");
          System.out.println(offer[i_offer]);
          offerx[i_offer] = offerElement.child(0).child(2).attr("alt");
          System.out.println(offerx[i_offer]);
          i_offer++;
        }
        System.out.println("test2");
        for (int l = 0; l < elementsClient.size(); l++) {
          String s = offer[l];
          String file_name = offerx[l];
          System.out.println(s);
          System.out.println(file_name);

          C_Bin_File_Body c_Bin_File_Body = new C_Bin_File_Body();
          URL url = new URL(s);
          System.out.println("lkjhlkjhoiutbtgy");
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
            e.printStackTrace();
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
      } catch (NullPointerException ex) {
      }
    }
  }

  @GetMapping("/arendakomnaty")
  public void arendakomnaty() throws FileNotFoundException, InterruptedException, IOException {
    File file = new File("C:\\Users\\User\\Downloads\\demo\\parse");
    Scanner scanner = new Scanner(file);
    int has = 0;
    while (scanner.hasNextLine()) {
      Thread.sleep(2000);
      Ho_Ad ho_ad = new Ho_Ad();
      String stringt = scanner.nextLine();
      Date timestamp = new Date();
      ho_ad.setIns_dt(timestamp);
      ho_ad.setIs_deleted(Boolean.FALSE);
      ho_ad.setC_country(2);
      ho_ad.setIs_agree_with_rules(true);
      ho_ad.setHo_usr(1L);
      ho_ad.setHo_cat(22);
      ho_ad.setHo_ad_status(1);
      Document doc;
      try {
        doc = (Document) Jsoup.connect(stringt).get();
        Thread.sleep(2000);
        Element element = doc.getElementById("jsdata");
        String kord = String.valueOf(element);
        String k = "";
        int d2 = 0;
        for (int i = 0; i < kord.length(); i++) {
          if (kord.charAt(i) == '"' && kord.charAt(i + 1) == 'l' && kord.charAt(i + 2) == 'a' && kord.charAt(i + 3) == 't' && kord.charAt(i + 4) == '"') {
            d2 = i + 6;
          }
        }
        for (int i = d2; i < kord.length(); i++) {
          if (kord.charAt(i) == ',') {
            break;
          }
          k += kord.charAt(i);
        }
        String k1 = "";
        int d1 = 0;
        for (int i = 0; i < kord.length(); i++) {
          if (kord.charAt(i) == '"' && kord.charAt(i + 1) == 'l' && kord.charAt(i + 2) == 'o' && kord.charAt(i + 3) == 'n' && kord.charAt(i + 4) == '"') {
            d1 = i + 6;
          }
        }
        for (int i = d1; i < kord.length(); i++) {
          if (kord.charAt(i) == ',') {
            break;
          }
          k1 += kord.charAt(i);
        }
        ho_ad.setLat(Double.parseDouble(k));
        ho_ad.setLon(Double.parseDouble(k1));
        System.out.println("test");
        String r = doc.getElementsByClass("offer__advert-title").first().child(0).text();
        System.out.println("tset");
        String room = "";
        for (int i = 0; i < r.length(); i++) {
          if (r.charAt(i) == ' ') {
            break;
          }
          room += r.charAt(i);
        }

        System.out.println(r);
        System.out.println(room);
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
        String street = "";
        while (i < r.length()) {
          street += r.charAt(i);
          i++;
        }
        ho_ad.setStreet_name(street);
        String kl = doc.getElementsByClass("offer__price").text();
        String kli = kl;
        int d = 0;
        String lk = "";
        while (d < kli.length()) {
          if (kli.charAt(d) == '0' || kli.charAt(d) == '1' || kli.charAt(d) == '2' || kli.charAt(d) == '3' || kli.charAt(d) == '4'
            || kli.charAt(d) == '5' || kli.charAt(d) == '6' || kli.charAt(d) == '7' || kli.charAt(d) == '8' || kli.charAt(d) == '9') {
            lk += kli.charAt(d);
          }
          d++;
        }

        ho_ad.setPrice(Double.valueOf(lk));

        String loc = doc.getElementsByClass("offer__location").first().child(0).text();
        HoAdCatResponse c_tbl_rec_corr_by_name1 = c_tbl_rec_corr_by_name_repository.find_by_name(loc);
        C_Tbl_Rec_Corr_By_Name c_tbl_rec_corr_by_name = new C_Tbl_Rec_Corr_By_Name();
        if (c_tbl_rec_corr_by_name1 != null) {
          if (c_tbl_rec_corr_by_name1.getName().equals(loc)) {
            ho_ad.setC_loc(c_tbl_rec_corr_by_name1.getId());
          }
        } else {
          c_tbl_rec_corr_by_name.setC_tbl(24);
          c_tbl_rec_corr_by_name.setName(loc);
          c_tbl_rec_corr_by_name.setRec_id(147L);
          c_tbl_rec_corr_by_name.setIs_deleted(false);
          c_tbl_rec_corr_by_name_repository.save(c_tbl_rec_corr_by_name);
          ho_ad.setC_loc(c_tbl_rec_corr_by_name.getRec_id().intValue());
        }
        try {
          ho_ad.setTxt(doc.getElementsByClass("a-text").first().text());
        } catch (NullPointerException e) {
          System.out.println("jkljkl");
        }
        Elements inputElements = doc.getElementsByClass("offer__advert-short-info");

        Elements elements = doc.getElementsByClass("offer__info-title");
        String[] s_elem = new String[elements.size()];
        int iterator = 0;
        for (Element inElement : elements) {
          s_elem[iterator] = inElement.text();
          iterator++;
        }
        int iteratorx = 0;
        String[] s_elemx = new String[elements.size()];
        for (Element inputElement : inputElements) {
          s_elemx[iteratorx] = inputElement.text();
          iteratorx++;
        }
        System.out.println("Tip doma");
        for (int itip = 0; itip < elements.size(); itip++) {
          String tip = s_elem[itip];
          System.out.println(itip);
          String s = s_elemx[itip];
          if (tip.equals("Площадь, м²")) {
            ho_ad.setTotal_area(Double.parseDouble(s));
          } else if (tip.equals("Этаж")) {
            stage(s, ho_ad);
          } else if (tip.equals("Интернет")) {
            inet(s, ho_ad);
          } else if (tip.equals("Телефон")) {
            phone(s, ho_ad);
          } else if (tip.equals("Возможен обмен")) {
            is_exch_possible(s, ho_ad);
          } else if (tip.equals("Год постройки")) {
            String year = "";
            for (int j = 0; j < s.length(); j++) {
              if (s.charAt(j) == '0' || s.charAt(j) == '1' || s.charAt(j) == '2' || s.charAt(j) == '3' || s.charAt(j) == '4'
                || s.charAt(j) == '5' || s.charAt(j) == '6' || s.charAt(j) == '7' || s.charAt(j) == '8' || s.charAt(j) == '9') {
                year += s.charAt(j);
              }
            }
            ho_ad.setConstruction_year(Integer.parseInt(year));
          } else if (tip.equals("Потолки")) {
            ceiling(s, ho_ad);
          }
        }
        System.out.println("god postroikiy");
        try {
          String contact = doc.getElementsByClass("label-user-identified-specialist").first().text();
          System.out.println(contact);
          List<Ho_Contact_Info_Type> ho_cit = repc.find_all1();
          for (Ho_Contact_Info_Type ho_usr : ho_cit) {
            if (ho_usr.getName().equals(contact)) {
              ho_ad.setHo_contact_info_type(ho_usr.getHo_contact_info_type());
              break;
            }
          }
        } catch (NullPointerException e) {
          try {
            String contact = doc.getElementsByClass("builder__contacts").text();
            System.out.println(contact);
            List<Ho_Contact_Info_Type> ho_cit = repc.find_all1();
            for (Ho_Contact_Info_Type ho_usr : ho_cit) {
              if (ho_usr.getName().equals(contact)) {
                ho_ad.setHo_contact_info_type(ho_usr.getHo_contact_info_type());
                break;
              }
            }
          } catch (NullPointerException ex) {

            try {
              String contact = doc.getElementsByClass("owners__label owners__label--default label-user-agent").first().text();
              System.out.println(contact);
              List<Ho_Contact_Info_Type> ho_cit = repc.find_all1();
              for (Ho_Contact_Info_Type ho_usr : ho_cit) {
                if (ho_usr.getName().equals(contact)) {
                  ho_ad.setHo_contact_info_type(ho_usr.getHo_contact_info_type());
                  break;
                }
              }
            } catch (NullPointerException exp) {
              String contact = doc.getElementsByClass("owners__name owners__name--large").text();
              System.out.println(contact);
              List<Ho_Contact_Info_Type> ho_cit = repc.find_all1();
              for (Ho_Contact_Info_Type ho_usr : ho_cit) {
                if (ho_usr.getName().equals(contact)) {
                  ho_ad.setHo_contact_info_type(ho_usr.getHo_contact_info_type());
                  break;
                }
              }

            }
          }
        }
        System.out.println("kljhjklhkjhk");
        Elements elementsClient = doc.getElementsByTag("dd");
        Elements elementss = doc.getElementsByTag("dt");
        String[] offer = new String[elementsClient.size()];
        int i_offer = 0;
        for (Element offerElement : elementsClient) {
          offer[i_offer] = offerElement.text();
          i_offer++;
        }
        int i_offerx = 0;
        String[] offerx = new String[elementsClient.size()];
        for (Element offerxElement : elementss) {
          offerx[i_offerx] = offerxElement.text();
          i_offerx++;
        }
        for (int itip = 0; itip < elementsClient.size(); itip++) {
          String s = offer[itip];
          String f = offerx[itip];
          if (f.equals("В залоге")) {
            is_pledged(s, ho_ad);
          } else if (f.equals("Потолки")) {
            ceiling(s, ho_ad);
          } else if (f.equals("Возможен обмен")) {
            is_exch_possible(s, ho_ad);
          } else if (f.equals("Интернет")) {
            inet(s, ho_ad);
          } else if (f.equals("Мебель")) {
            furniture(s, ho_ad);
          } else if (f.equals("Телефон")) {
            phone(s, ho_ad);
          }
        }

        System.out.println("text");
      } catch (IOException ex) {
        continue;
      }
      System.out.println(has);
      has++;
      ho_Ad_Service.saveOrUpdate(ho_ad);
      try {
        String s = doc.getElementsByClass("gallery__main").first().child(1).child(0).child(2).attr("src");
        String file_name = doc.getElementsByClass("gallery__main").first().child(1).child(0).child(2).attr("alt");
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
          e.printStackTrace();
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
        c_tbl_rec_img_moder.setC_img_kind(1);
        c_tbl_rec_img_moder.setC_img_status(2);
        c_tbl_rec_img_moder.setIs_deleted(Boolean.FALSE);
        c_tbl_rec_img_moder.setC_img(c_Img.getC_img());

        c_tbl_rec_img_moder_repository.save(c_tbl_rec_img_moder);
      } catch (NullPointerException ex) {
      }

      try {
        Elements elementsClient = doc.getElementsByClass("gallery__small-item");
        String[] offer = new String[elementsClient.size()];
        String[] offerx = new String[elementsClient.size()];
        int i_offer = 0;
        for (Element offerElement : elementsClient) {
          offer[i_offer] = offerElement.child(0).child(2).attr("src");
          System.out.println(offer[i_offer]);
          offerx[i_offer] = offerElement.child(0).child(2).attr("alt");
          System.out.println(offerx[i_offer]);
          i_offer++;
        }
        System.out.println("test2");
        for (int l = 0; l < elementsClient.size(); l++) {
          String s = offer[l];
          String file_name = offerx[l];
          System.out.println(s);
          System.out.println(file_name);

          C_Bin_File_Body c_Bin_File_Body = new C_Bin_File_Body();
          URL url = new URL(s);
          System.out.println("lkjhlkjhoiutbtgy");
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
            e.printStackTrace();
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
      } catch (NullPointerException ex) {
      }
    }
  }

  @GetMapping("/prombasy")
  public void prombasy() throws FileNotFoundException, InterruptedException, IOException {
    File file = new File("C:\\Users\\User\\Downloads\\demo\\parse");
    Scanner scanner = new Scanner(file);
    int has = 0;
    while (scanner.hasNextLine()) {
      Thread.sleep(2000);
      Ho_Ad ho_ad = new Ho_Ad();
      String stringt = scanner.nextLine();
      Date timestamp = new Date();
      ho_ad.setIns_dt(timestamp);
      ho_ad.setIs_deleted(Boolean.FALSE);
      ho_ad.setC_country(2);
      ho_ad.setIs_agree_with_rules(true);
      ho_ad.setHo_usr(1L);
      ho_ad.setHo_cat(30);//30
      ho_ad.setHo_ad_status(1);
      Document doc;
      try {
        doc = (Document) Jsoup.connect(stringt).get();
        Thread.sleep(2000);
        Element element = doc.getElementById("jsdata");
        String kord = String.valueOf(element);
        String k = "";
        int d2 = 0;
        for (int i = 0; i < kord.length(); i++) {
          if (kord.charAt(i) == '"' && kord.charAt(i + 1) == 'l' && kord.charAt(i + 2) == 'a' && kord.charAt(i + 3) == 't' && kord.charAt(i + 4) == '"') {
            d2 = i + 6;
          }
        }
        for (int i = d2; i < kord.length(); i++) {
          if (kord.charAt(i) == ',') {
            break;
          }
          k += kord.charAt(i);
        }
        String k1 = "";
        int d1 = 0;
        for (int i = 0; i < kord.length(); i++) {
          if (kord.charAt(i) == '"' && kord.charAt(i + 1) == 'l' && kord.charAt(i + 2) == 'o' && kord.charAt(i + 3) == 'n' && kord.charAt(i + 4) == '"') {
            d1 = i + 6;
          }
        }
        for (int i = d1; i < kord.length(); i++) {
          if (kord.charAt(i) == ',') {
            break;
          }
          k1 += kord.charAt(i);
        }
        ho_ad.setLat(Double.parseDouble(k));
        ho_ad.setLon(Double.parseDouble(k1));
        System.out.println("test");
        String r = doc.getElementsByClass("offer__advert-title").first().child(0).text();
        System.out.println("tset");
        String room = "";
        for (int i = 0; i < r.length(); i++) {
          if (r.charAt(i) == ',') {
            break;
          }
          room += r.charAt(i);
        }
        try{
        String tipsk = "";
        
        for (int i = 0; i < room.length(); i++) {
          if (room.charAt(i) == ' ') {
           if (room.charAt(i + 1) == ',' || room.charAt(i+1) == '0' || room.charAt(i+1) == '1' || room.charAt(i+1) == '2' || room.charAt(i+1) == '3' || room.charAt(i+1) == '4'
                        || room.charAt(i+1) == '5' || room.charAt(i+1) == '6' || room.charAt(i+1) == '7' || room.charAt(i+1) == '8' || room.charAt(i+1) == '9') {
                    break;
                }
          

          }
          tipsk += room.charAt(i);
          System.out.println(tipsk);
        List<Ho_House_Indus_Base_Type> ho_usrs = Ho_House_Indus_Base_Type_Repository.find_all1();
        for (Ho_House_Indus_Base_Type ho_usr1 : ho_usrs) {

          if (ho_usr1.getName().equals(tipsk.toLowerCase())) {

            ho_ad.setHo_house_indus_base_type(ho_usr1.getHo_house_indus_base_type());
            break;
          }
        }
        }
        }catch(StringIndexOutOfBoundsException exxx){}
        
        
        int i = 0;
        while (true) {
          if (r.charAt(i) == ',') {
            break;
          }
          i++;
        }
        i = i + 1;
        int utirr = 0;
        int utir = 0;
        while (utir < r.length()) {
          if (r.charAt(utir) == ',') {
            utirr++;
          }
          utir++;
        }
        if(utirr==3){
        String area = "";
        while (true) {
          if (r.charAt(i) == ',') {
            break;
          }
          i++;
          area += r.charAt(i);

        }
        i = i + 1;
        }
        String street = "";
        while (i < r.length()) {
          street += r.charAt(i);
          i++;
        }
        ho_ad.setStreet_name(street);
        System.out.println("ioipoipoipo");
        String kl = doc.getElementsByClass("offer__price").text();
        String kli = kl;
        int d = 0;
        String lk = "";
        while (d < kli.length()) {
          if (kli.charAt(d) == '0' || kli.charAt(d) == '1' || kli.charAt(d) == '2' || kli.charAt(d) == '3' || kli.charAt(d) == '4'
            || kli.charAt(d) == '5' || kli.charAt(d) == '6' || kli.charAt(d) == '7' || kli.charAt(d) == '8' || kli.charAt(d) == '9') {
            lk += kli.charAt(d);
          }
          d++;
        }
        ho_ad.setPrice(Double.valueOf(lk));
        String loc = doc.getElementsByClass("offer__location").first().child(0).text();
        HoAdCatResponse c_tbl_rec_corr_by_name1 = c_tbl_rec_corr_by_name_repository.find_by_name(loc);
        C_Tbl_Rec_Corr_By_Name c_tbl_rec_corr_by_name = new C_Tbl_Rec_Corr_By_Name();
        if (c_tbl_rec_corr_by_name1 != null) {
          if (c_tbl_rec_corr_by_name1.getName().equals(loc)) {
            ho_ad.setC_loc(c_tbl_rec_corr_by_name1.getId());
          }
        } else {
          c_tbl_rec_corr_by_name.setC_tbl(24);
          c_tbl_rec_corr_by_name.setName(loc);
          c_tbl_rec_corr_by_name.setRec_id(147L);
          c_tbl_rec_corr_by_name.setIs_deleted(false);
          c_tbl_rec_corr_by_name_repository.save(c_tbl_rec_corr_by_name);
          ho_ad.setC_loc(c_tbl_rec_corr_by_name.getRec_id().intValue());
        }
        try {
          ho_ad.setTxt(doc.getElementsByClass("a-text").first().text());
        } catch (NullPointerException e) {
          System.out.println("jkljkl");
        }
        Elements inputElements = doc.getElementsByClass("offer__advert-short-info");

        Elements elements = doc.getElementsByClass("offer__info-title");
        String[] s_elem = new String[elements.size()];
        int iterator = 0;
        for (Element inElement : elements) {
          s_elem[iterator] = inElement.text();
          iterator++;
        }
        int iteratorx = 0;
        String[] s_elemx = new String[elements.size()];
        for (Element inputElement : inputElements) {
          s_elemx[iteratorx] = inputElement.text();
          iteratorx++;
        }
        System.out.println("Tip doma");
        for (int itip = 0; itip < elements.size(); itip++) {
          String tip = s_elem[itip];
          System.out.println(itip);
          String s = s_elemx[itip];
          if (tip.equals("Количество уровней")) {
            ho_ad.setLevel_num(Integer.valueOf(s));
          } else if (tip.equals("Площадь производственных помещений, м²")) {
            ho_ad.setProduction_area(Double.parseDouble(s));
          } else if (tip.equals("Высота потолков производственных помещений, м")) {
            ho_ad.setProduction_area_ceiling_height(Double.parseDouble(s));
          } else if (tip.equals("Площадь складских помещений, м²")) {
            ho_ad.setWarehouse_area(Double.parseDouble(s));
          } else if (tip.equals("Высота потолков складских помещений, м")) {
            ho_ad.setWarehouse_ceiling_height(Double.parseDouble(s));
          } else if (tip.equals("Площадь офисных помещений, м²")) {
            ho_ad.setOffice_area(Double.parseDouble(s));
          } else if (tip.equals("Площадь территории")) {
            String year = "";
            for (int j = 0; j < s.length(); j++) {
              if (s.charAt(j) == '0' || s.charAt(j) == '1' || s.charAt(j) == '2' || s.charAt(j) == '3' || s.charAt(j) == '4'
                || s.charAt(j) == '5' || s.charAt(j) == '6' || s.charAt(j) == '7' || s.charAt(j) == '8' || s.charAt(j) == '9') {
                year += s.charAt(j);
              }
            }
            ho_ad.setTerritory_area_unit(1);
            ho_ad.setTerritory_area(Double.parseDouble(year));
          } else if (tip.equals("Кол-во телефонных линий")) {
            ho_ad.setPhone_lines_num(Integer.parseInt(s));
          } else if (tip.equals("Возможен обмен")) {
            is_exch_possible(s, ho_ad);
          } else if (tip.equals("Год постройки")) {
            String year = "";
            for (int j = 0; j < s.length(); j++) {
              if (s.charAt(j) == '0' || s.charAt(j) == '1' || s.charAt(j) == '2' || s.charAt(j) == '3' || s.charAt(j) == '4'
                || s.charAt(j) == '5' || s.charAt(j) == '6' || s.charAt(j) == '7' || s.charAt(j) == '8' || s.charAt(j) == '9') {
                year += s.charAt(j);
              }
            }
            ho_ad.setConstruction_year(Integer.parseInt(year));
          }
        }
        System.out.println("god postroikiy");
        try {
          String contact = doc.getElementsByClass("label-user-identified-specialist").first().text();
          System.out.println(contact);
          List<Ho_Contact_Info_Type> ho_cit = repc.find_all1();
          for (Ho_Contact_Info_Type ho_usr : ho_cit) {
            if (ho_usr.getName().equals(contact)) {
              ho_ad.setHo_contact_info_type(ho_usr.getHo_contact_info_type());
              break;
            }
          }
        } catch (NullPointerException e) {
          try {
            String contact = doc.getElementsByClass("builder__contacts").text();
            System.out.println(contact);
            List<Ho_Contact_Info_Type> ho_cit = repc.find_all1();
            for (Ho_Contact_Info_Type ho_usr : ho_cit) {
              if (ho_usr.getName().equals(contact)) {
                ho_ad.setHo_contact_info_type(ho_usr.getHo_contact_info_type());
                break;
              }
            }
          } catch (NullPointerException ex) {

            try {
              String contact = doc.getElementsByClass("owners__label owners__label--default label-user-agent").first().text();
              System.out.println(contact);
              List<Ho_Contact_Info_Type> ho_cit = repc.find_all1();
              for (Ho_Contact_Info_Type ho_usr : ho_cit) {
                if (ho_usr.getName().equals(contact)) {
                  ho_ad.setHo_contact_info_type(ho_usr.getHo_contact_info_type());
                  break;
                }
              }
            } catch (NullPointerException exp) {
              String contact = doc.getElementsByClass("owners__name owners__name--large").text();
              System.out.println(contact);
              List<Ho_Contact_Info_Type> ho_cit = repc.find_all1();
              for (Ho_Contact_Info_Type ho_usr : ho_cit) {
                if (ho_usr.getName().equals(contact)) {
                  ho_ad.setHo_contact_info_type(ho_usr.getHo_contact_info_type());
                  break;
                }
              }
            }
          }
        }
        System.out.println("kljhjklhkjhk");
        Elements elementsClient = doc.getElementsByTag("dd");
        Elements elementss = doc.getElementsByTag("dt");
        String[] offer = new String[elementsClient.size()];
        int i_offer = 0;
        for (Element offerElement : elementsClient) {
          offer[i_offer] = offerElement.text();
          i_offer++;
        }
        int i_offerx = 0;
        String[] offerx = new String[elementsClient.size()];
        for (Element offerxElement : elementss) {
          offerx[i_offerx] = offerxElement.text();
          i_offerx++;
        }
        for (int itip = 0; itip < elementsClient.size(); itip++) {
          String s = offer[itip];
          String f = offerx[itip];
          if (f.equals("В залоге")) {
            is_pledged(s, ho_ad);
          } else if (f.equals("Площадь производственных помещений, м²")) {
            ho_ad.setProduction_area(Double.parseDouble(s));
          } else if (f.equals("Высота потолков производственных помещений, м")) {
            ho_ad.setProduction_area_ceiling_height(Double.parseDouble(s));
          } else if (f.equals("Площадь складских помещений, м²")) {
            ho_ad.setWarehouse_area(Double.parseDouble(s));
          } else if (f.equals("Высота потолков складских помещений, м")) {
            ho_ad.setWarehouse_ceiling_height(Double.parseDouble(s));
          } else if (f.equals("Площадь офисных помещений, м²")) {
            ho_ad.setOffice_area(Double.parseDouble(s));
          } else if (f.equals("Кол-во телефонных линий")) {
            ho_ad.setPhone_lines_num(Integer.parseInt(s));
          } else if (f.equals("Ж/д тупик")) {
            Boolean trf = false;
            if (s.equals("есть")) {
              trf = true;
            }
            ho_ad.setIs_has_railway_siding(trf);
          } else if (f.equals("Своя подстанция (ТП)")) {
            Boolean trf = false;
            if (s.equals("есть")) {
              trf = true;
            }
            ho_ad.setIs_has_own_substation(trf);
          } else if (f.equals("Макс. потребление энергии")) {
            int j=0;
            String ddd="";
            while(j<s.length()){
              if (s.charAt(j) == '0' || s.charAt(j) == '1' || s.charAt(j) == '2' || s.charAt(j) == '3' || s.charAt(j) == '4'
                || s.charAt(j) == '5' || s.charAt(j) == '6' || s.charAt(j) == '7' || s.charAt(j) == '8' || s.charAt(j) == '9') 
                ddd += s.charAt(j);
            j++;
            
            }
            ho_ad.setMax_power_consumption(Double.parseDouble(ddd));
          } else if (f.equals("Возможен обмен")) {
            is_exch_possible(s, ho_ad);
          }
        }
        System.out.println("text");
      } catch (IOException ex) {
        continue;
      }
      System.out.println(has);
      has++;
      ho_Ad_Service.saveOrUpdate(ho_ad);
      try {
        Elements inputElements = doc.getElementsByClass("offer__advert-short-info");
        Elements elements = doc.getElementsByClass("offer__info-title");
        String[] s_elem = new String[elements.size()];
        int iterator = 0;
        for (Element inElement : elements) {
          s_elem[iterator] = inElement.text();
          iterator++;
        }
        int iteratorx = 0;
        String[] s_elemx = new String[elements.size()];
        for (Element inputElement : inputElements) {
          s_elemx[iteratorx] = inputElement.text();
          iteratorx++;
        }
        for (int itip = 0; itip < elements.size(); itip++) {
          String tip = s_elem[itip];

          String s = s_elemx[itip];
          if (tip.equals("Безопасность")) {
            house_security(s, ho_ad);
          }
          if (tip.equals("Коммуникации")) {
            house_commun(s, ho_ad);
          }
        }
        Elements elementsClient = doc.getElementsByTag("dd");
        Elements elementss = doc.getElementsByTag("dt");
        String[] offer = new String[elementsClient.size()];
        int i_offer = 0;
        for (Element offerElement : elementsClient) {
          offer[i_offer] = offerElement.text();
          i_offer++;
        }
        int i_offerx = 0;
        String[] offerx = new String[elementsClient.size()];
        for (Element offerxElement : elementss) {
          offerx[i_offerx] = offerxElement.text();
          i_offerx++;
        }
        for (int itip = 0; itip < elementsClient.size(); itip++) {
          String s = offer[itip];
          String f = offerx[itip];
          if (f.equals("Безопасность")) {
            house_security(s, ho_ad);
          }
          if (f.equals("Коммуникации")) {
            house_commun(s, ho_ad);
          }
        }
        String s = doc.getElementsByClass("gallery__main").first().child(1).child(0).child(2).attr("src");
        String file_name = doc.getElementsByClass("gallery__main").first().child(1).child(0).child(2).attr("alt");
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
          e.printStackTrace();
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
        c_tbl_rec_img_moder.setC_img_kind(1);
        c_tbl_rec_img_moder.setC_img_status(2);
        c_tbl_rec_img_moder.setIs_deleted(Boolean.FALSE);
        c_tbl_rec_img_moder.setC_img(c_Img.getC_img());

        c_tbl_rec_img_moder_repository.save(c_tbl_rec_img_moder);
      } catch (NullPointerException ex) {
      }

      try {
        Elements elementsClient = doc.getElementsByClass("gallery__small-item");
        String[] offer = new String[elementsClient.size()];
        String[] offerx = new String[elementsClient.size()];
        int i_offer = 0;
        for (Element offerElement : elementsClient) {
          offer[i_offer] = offerElement.child(0).child(2).attr("src");
          System.out.println(offer[i_offer]);
          offerx[i_offer] = offerElement.child(0).child(2).attr("alt");
          System.out.println(offerx[i_offer]);
          i_offer++;
        }
        System.out.println("test2");
        for (int l = 0; l < elementsClient.size(); l++) {
          String s = offer[l];
          String file_name = offerx[l];
          System.out.println(s);
          System.out.println(file_name);

          C_Bin_File_Body c_Bin_File_Body = new C_Bin_File_Body();
          URL url = new URL(s);
          System.out.println("lkjhlkjhoiutbtgy");
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
            e.printStackTrace();
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
      } catch (NullPointerException ex) {
      }
    }
  }

  @GetMapping("/nedvijimost")
  public void nedvijimost() throws FileNotFoundException, InterruptedException, IOException {
    File file = new File("C:\\Users\\User\\Downloads\\demo\\parse");
    Scanner scanner = new Scanner(file);
    int has = 0;
    while (scanner.hasNextLine()) {
      Thread.sleep(2000);
      Ho_Ad ho_ad = new Ho_Ad();
      String stringt = scanner.nextLine();
      Date timestamp = new Date();
      ho_ad.setIns_dt(timestamp);
      ho_ad.setIs_deleted(Boolean.FALSE);
      ho_ad.setC_country(2);
      ho_ad.setIs_agree_with_rules(true);
      ho_ad.setHo_usr(1L);
      ho_ad.setHo_cat(25);//25
      ho_ad.setHo_ad_status(1);
      Document doc;
      try {
        doc = (Document) Jsoup.connect(stringt).get();
        Thread.sleep(2000);
        Element element = doc.getElementById("jsdata");
        String kord = String.valueOf(element);
        String k = "";
        int d2 = 0;
        for (int i = 0; i < kord.length(); i++) {
          if (kord.charAt(i) == '"' && kord.charAt(i + 1) == 'l' && kord.charAt(i + 2) == 'a' && kord.charAt(i + 3) == 't' && kord.charAt(i + 4) == '"') {
            d2 = i + 6;
          }
        }
        for (int i = d2; i < kord.length(); i++) {
          if (kord.charAt(i) == ',') {
            break;
          }
          k += kord.charAt(i);
        }
        String k1 = "";
        int d1 = 0;
        for (int i = 0; i < kord.length(); i++) {
          if (kord.charAt(i) == '"' && kord.charAt(i + 1) == 'l' && kord.charAt(i + 2) == 'o' && kord.charAt(i + 3) == 'n' && kord.charAt(i + 4) == '"') {
            d1 = i + 6;
          }
        }
        for (int i = d1; i < kord.length(); i++) {
          if (kord.charAt(i) == ',') {
            break;
          }
          k1 += kord.charAt(i);
        }
        ho_ad.setLat(Double.parseDouble(k));
        ho_ad.setLon(Double.parseDouble(k1));
        System.out.println("test");
        String r = doc.getElementsByClass("offer__advert-title").first().child(0).text();
        ho_ad.setTitle(r);
        String kl = doc.getElementsByClass("offer__price").text();
        String kli = kl;
        int d = 0;
        String lk = "";
        while (d < kli.length()) {
          if (kli.charAt(d) == '0' || kli.charAt(d) == '1' || kli.charAt(d) == '2' || kli.charAt(d) == '3' || kli.charAt(d) == '4'
            || kli.charAt(d) == '5' || kli.charAt(d) == '6' || kli.charAt(d) == '7' || kli.charAt(d) == '8' || kli.charAt(d) == '9') {
            lk += kli.charAt(d);
          }
          d++;
        }
        ho_ad.setPrice(Double.valueOf(lk));
        String loc = doc.getElementsByClass("offer__location").first().child(0).text();
        HoAdCatResponse c_tbl_rec_corr_by_name1 = c_tbl_rec_corr_by_name_repository.find_by_name(loc);
        C_Tbl_Rec_Corr_By_Name c_tbl_rec_corr_by_name = new C_Tbl_Rec_Corr_By_Name();
        if (c_tbl_rec_corr_by_name1 != null) {
          if (c_tbl_rec_corr_by_name1.getName().equals(loc)) {
            ho_ad.setC_loc(c_tbl_rec_corr_by_name1.getId());
          }
        } else {
          c_tbl_rec_corr_by_name.setC_tbl(24);
          c_tbl_rec_corr_by_name.setName(loc);
          c_tbl_rec_corr_by_name.setRec_id(147L);
          c_tbl_rec_corr_by_name.setIs_deleted(false);
          c_tbl_rec_corr_by_name_repository.save(c_tbl_rec_corr_by_name);
          ho_ad.setC_loc(c_tbl_rec_corr_by_name.getRec_id().intValue());
        }
        try {
          ho_ad.setTxt(doc.getElementsByClass("a-text").first().text());
        } catch (NullPointerException e) {
          System.out.println("jkljkl");
        }
        Elements inputElements = doc.getElementsByClass("offer__advert-short-info");

        Elements elements = doc.getElementsByClass("offer__info-title");
        String[] s_elem = new String[elements.size()];
        int iterator = 0;
        for (Element inElement : elements) {
          s_elem[iterator] = inElement.text();
          iterator++;
        }
        int iteratorx = 0;
        String[] s_elemx = new String[elements.size()];
        for (Element inputElement : inputElements) {
          s_elemx[iteratorx] = inputElement.text();
          iteratorx++;
        }
        System.out.println("Tip doma");
        for (int itip = 0; itip < elements.size(); itip++) {
          String tip = s_elem[itip];
          System.out.println(itip);
          String s = s_elemx[itip];
          if (tip.equals("Общая площадь, м²")) {
            ho_ad.setTotal_area(Double.parseDouble(s));
          } else if (tip.equals("Площадь территории")) {
            String year = "";
            for (int j = 0; j < s.length(); j++) {
              if (s.charAt(j) == '0' || s.charAt(j) == '1' || s.charAt(j) == '2' || s.charAt(j) == '3' || s.charAt(j) == '4'
                || s.charAt(j) == '5' || s.charAt(j) == '6' || s.charAt(j) == '7' || s.charAt(j) == '8' || s.charAt(j) == '9') {
                year += s.charAt(j);
              }
            }
            ho_ad.setTerritory_area(Double.parseDouble(year));
          } else if (tip.equals("Действующий бизнес")) {
            Boolean trf = false;
            if (s.equals("да")) {
              trf = true;
            }
            ho_ad.setIs_has_railway_siding(trf);
          } else if (tip.equals("Возможен обмен")) {
            is_exch_possible(s, ho_ad);
          }
        }
        System.out.println("god postroikiy");
        try {
          String contact = doc.getElementsByClass("label-user-identified-specialist").first().text();
          System.out.println(contact);
          List<Ho_Contact_Info_Type> ho_cit = repc.find_all1();
          for (Ho_Contact_Info_Type ho_usr : ho_cit) {
            if (ho_usr.getName().equals(contact)) {
              ho_ad.setHo_contact_info_type(ho_usr.getHo_contact_info_type());
              break;
            }
          }
        } catch (NullPointerException e) {
          try {
            String contact = doc.getElementsByClass("builder__contacts").text();
            System.out.println(contact);
            List<Ho_Contact_Info_Type> ho_cit = repc.find_all1();
            for (Ho_Contact_Info_Type ho_usr : ho_cit) {
              if (ho_usr.getName().equals(contact)) {
                ho_ad.setHo_contact_info_type(ho_usr.getHo_contact_info_type());
                break;
              }
            }
          } catch (NullPointerException ex) {

            try {
              String contact = doc.getElementsByClass("owners__label owners__label--default label-user-agent").first().text();
              System.out.println(contact);
              List<Ho_Contact_Info_Type> ho_cit = repc.find_all1();
              for (Ho_Contact_Info_Type ho_usr : ho_cit) {
                if (ho_usr.getName().equals(contact)) {
                  ho_ad.setHo_contact_info_type(ho_usr.getHo_contact_info_type());
                  break;
                }
              }
            } catch (NullPointerException exp) {
              String contact = doc.getElementsByClass("owners__name owners__name--large").text();
              System.out.println(contact);
              List<Ho_Contact_Info_Type> ho_cit = repc.find_all1();
              for (Ho_Contact_Info_Type ho_usr : ho_cit) {
                if (ho_usr.getName().equals(contact)) {
                  ho_ad.setHo_contact_info_type(ho_usr.getHo_contact_info_type());
                  break;
                }
              }
            }
          }
        }
        System.out.println("kljhjklhkjhk");
        Elements elementsClient = doc.getElementsByTag("dd");
        Elements elementss = doc.getElementsByTag("dt");
        String[] offer = new String[elementsClient.size()];
        int i_offer = 0;
        for (Element offerElement : elementsClient) {
          offer[i_offer] = offerElement.text();
          i_offer++;
        }
        int i_offerx = 0;
        String[] offerx = new String[elementsClient.size()];
        for (Element offerxElement : elementss) {
          offerx[i_offerx] = offerxElement.text();
          i_offerx++;
        }
        for (int itip = 0; itip < elementsClient.size(); itip++) {
          String s = offer[itip];
          String f = offerx[itip];
          if (f.equals("В залоге")) {
            is_pledged(s, ho_ad);
          } else if (f.equals("Действующий бизнес")) {
            Boolean trf = false;
            if (s.equals("да")) {
              trf = true;
            }
            ho_ad.setIs_has_railway_siding(trf);
          } else if (f.equals("Возможен обмен")) {
            is_exch_possible(s, ho_ad);
          }
        }
        System.out.println("text");
      } catch (IOException ex) {
        continue;
      }
      System.out.println(has);
      has++;
      ho_Ad_Service.saveOrUpdate(ho_ad);
      try {
        Elements inputElements = doc.getElementsByClass("offer__advert-short-info");
        Elements elements = doc.getElementsByClass("offer__info-title");
        String[] s_elem = new String[elements.size()];
        int iterator = 0;
        for (Element inElement : elements) {
          s_elem[iterator] = inElement.text();
          iterator++;
        }
        int iteratorx = 0;
        String[] s_elemx = new String[elements.size()];
        for (Element inputElement : inputElements) {
          s_elemx[iteratorx] = inputElement.text();
          iteratorx++;
        }
        for (int itip = 0; itip < elements.size(); itip++) {
          String tip = s_elem[itip];

          String s = s_elemx[itip];
          if (tip.equals("Безопасность")) {
            house_security(s, ho_ad);
          }
          if (tip.equals("Коммуникации")) {
            house_commun(s, ho_ad);
          }
          if (tip.equals("Местоположение")) {
            house_ad_loc(s, ho_ad);
          }

        }
        Elements elementsClient = doc.getElementsByTag("dd");
        Elements elementss = doc.getElementsByTag("dt");
        String[] offer = new String[elementsClient.size()];
        int i_offer = 0;
        for (Element offerElement : elementsClient) {
          offer[i_offer] = offerElement.text();
          i_offer++;
        }
        int i_offerx = 0;
        String[] offerx = new String[elementsClient.size()];
        for (Element offerxElement : elementss) {
          offerx[i_offerx] = offerxElement.text();
          i_offerx++;
        }
        for (int itip = 0; itip < elementsClient.size(); itip++) {
          String s = offer[itip];
          String f = offerx[itip];
          if (f.equals("Безопасность")) {
            house_security(s, ho_ad);
          }
          if (f.equals("Коммуникации")) {
            house_commun(s, ho_ad);
          }
        }
        String s = doc.getElementsByClass("gallery__main").first().child(1).child(0).child(2).attr("src");
        String file_name = doc.getElementsByClass("gallery__main").first().child(1).child(0).child(2).attr("alt");
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
          e.printStackTrace();
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
        c_tbl_rec_img_moder.setC_img_kind(1);
        c_tbl_rec_img_moder.setC_img_status(2);
        c_tbl_rec_img_moder.setIs_deleted(Boolean.FALSE);
        c_tbl_rec_img_moder.setC_img(c_Img.getC_img());

        c_tbl_rec_img_moder_repository.save(c_tbl_rec_img_moder);
      } catch (NullPointerException ex) {
      }
      try {
        Elements elementsClient = doc.getElementsByClass("gallery__small-item");
        String[] offer = new String[elementsClient.size()];
        String[] offerx = new String[elementsClient.size()];
        int i_offer = 0;
        for (Element offerElement : elementsClient) {
          offer[i_offer] = offerElement.child(0).child(2).attr("src");
          System.out.println(offer[i_offer]);
          offerx[i_offer] = offerElement.child(0).child(2).attr("alt");
          System.out.println(offerx[i_offer]);
          i_offer++;
        }
        System.out.println("test2");
        for (int l = 0; l < elementsClient.size(); l++) {
          String s = offer[l];
          String file_name = offerx[l];
          System.out.println(s);
          System.out.println(file_name);

          C_Bin_File_Body c_Bin_File_Body = new C_Bin_File_Body();
          URL url = new URL(s);
          System.out.println("lkjhlkjhoiutbtgy");
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
            e.printStackTrace();
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
      } catch (NullPointerException ex) {
      }
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
