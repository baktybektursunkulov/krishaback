package managers.core.dbtables;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import model.core.dbtables.*;
import gs.common.managers.My_Abstract_Controller_Manager;
import gs.common.model.db.*;
import org.hibernate.*;
import others.CustomLogger;
import gs.common.hibernate_funcs;
import java.util.*;
import java.text.*;

@ManagedBean
@ApplicationScoped
public class C_Site_Page_Manager extends Abstract_Controller_Manager<C_Site_Page> {

  private static C_Site_Page_Manager currentInstance = null;
  private Integer c_site_page_id__home = 1;// Главная
  private Integer c_site_page_id__docs = 5;// Документация
  private Integer c_site_page_id__requisites = 7;// Реквизиты
  private Integer c_site_page_id__about_us = 9;// О нас
  private Integer c_site_page_id__contacts = 10;// Контакты
  private Integer c_site_page_id__offer_for_sellers = 11;// Предложение для продавцов

  public static C_Site_Page_Manager getCI() {
    if (currentInstance == null) {
      currentInstance = new C_Site_Page_Manager();
    }
    return currentInstance;
  }

  public C_Site_Page_Manager() {
    super(C_Site_Page.class);
  }

  public Integer getC_site_page_id__home() {
    return c_site_page_id__home;
  }

  public void setC_site_page_id__home(Integer c_site_page_id__home) {
    this.c_site_page_id__home = c_site_page_id__home;
  }

  public Integer getC_site_page_id__docs() {
    return c_site_page_id__docs;
  }

  public void setC_site_page_id__docs(Integer c_site_page_id__docs) {
    this.c_site_page_id__docs = c_site_page_id__docs;
  }

  public Integer getC_site_page_id__requisites() {
    return c_site_page_id__requisites;
  }

  public void setC_site_page_id__requisites(Integer c_site_page_id__requisites) {
    this.c_site_page_id__requisites = c_site_page_id__requisites;
  }

  public Integer getC_site_page_id__about_us() {
    return c_site_page_id__about_us;
  }

  public void setC_site_page_id__about_us(Integer c_site_page_id__about_us) {
    this.c_site_page_id__about_us = c_site_page_id__about_us;
  }

  public Integer getC_site_page_id__contacts() {
    return c_site_page_id__contacts;
  }

  public void setC_site_page_id__contacts(Integer c_site_page_id__contacts) {
    this.c_site_page_id__contacts = c_site_page_id__contacts;
  }

  public Integer getC_site_page_id__offer_for_sellers() {
    return c_site_page_id__offer_for_sellers;
  }

  public void setC_site_page_id__offer_for_sellers(Integer c_site_page_id__offer_for_sellers) {
    this.c_site_page_id__offer_for_sellers = c_site_page_id__offer_for_sellers;
  }

  

  
  
}
