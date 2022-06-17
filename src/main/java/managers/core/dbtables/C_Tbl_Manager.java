package managers.core.dbtables;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import model.core.dbtables.*;
import gs.common.managers.My_Abstract_Controller_Manager;
import java.util.concurrent.ConcurrentHashMap;

@ManagedBean
@ApplicationScoped
public class C_Tbl_Manager extends Abstract_Controller_Manager<C_Tbl> {

  private static C_Tbl_Manager currentInstance = null;

  private Integer c_tbl_id__c_session = 14;
  private Integer c_tbl_id__ec_prod = 12;
  private Integer c_tbl_id__c_usr = 8;
  private Integer c_tbl_id__ec_store = 16;
  private Integer c_tbl_id__ec_cus = 17;
  private Integer c_tbl_id__ec_seller = 18;
  //private ConcurrentHashMap<String, Integer> id_map = new ConcurrentHashMap();

  public static C_Tbl_Manager getCI() {
    if (currentInstance == null) {
      currentInstance = new C_Tbl_Manager();
    }
    return currentInstance;
  }

  public Integer getC_tbl_id__c_session() {
    return c_tbl_id__c_session;
  }

  public void setC_tbl_id__c_session(Integer c_tbl_id__c_session) {
    this.c_tbl_id__c_session = c_tbl_id__c_session;
  }

  public Integer getC_tbl_id__ec_prod() {
    return c_tbl_id__ec_prod;
  }

  public void setC_tbl_id__ec_prod(Integer c_tbl_id__ec_prod) {
    this.c_tbl_id__ec_prod = c_tbl_id__ec_prod;
  }

  public Integer getC_tbl_id__c_usr() {
    return c_tbl_id__c_usr;
  }

  public void setC_tbl_id__c_usr(Integer c_tbl_id__c_usr) {
    this.c_tbl_id__c_usr = c_tbl_id__c_usr;
  }

  public Integer getC_tbl_id__ec_store() {
    return c_tbl_id__ec_store;
  }

  public void setC_tbl_id__ec_store(Integer c_tbl_id__ec_store) {
    this.c_tbl_id__ec_store = c_tbl_id__ec_store;
  }

  public Integer getC_tbl_id__ec_cus() {
    return c_tbl_id__ec_cus;
  }

  public void setC_tbl_id__ec_cus(Integer c_tbl_id__ec_cus) {
    this.c_tbl_id__ec_cus = c_tbl_id__ec_cus;
  }

  public Integer getC_tbl_id__ec_seller() {
    return c_tbl_id__ec_seller;
  }

  public void setC_tbl_id__ec_seller(Integer c_tbl_id__ec_seller) {
    this.c_tbl_id__ec_seller = c_tbl_id__ec_seller;
  }

  
  
  public C_Tbl_Manager() {
    super(C_Tbl.class);
  }

}
