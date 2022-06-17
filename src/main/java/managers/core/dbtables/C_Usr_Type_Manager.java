package managers.core.dbtables;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import model.core.dbtables.*;
import gs.common.managers.My_Abstract_Controller_Manager;

@ManagedBean
@ApplicationScoped
public class C_Usr_Type_Manager extends Abstract_Controller_Manager<C_Usr_Type> {

  private static C_Usr_Type_Manager currentInstance = null;
  private Integer const_c_usr_type_id_admin = 1;
  private Integer const_c_usr_type_id_user = 2;
  private Integer const_c_usr_type_id_seller = 3;
  private Integer const_c_usr_type_id_customer = 5;
  private Integer const_c_usr_type_id_moderator = 7;
  private Integer const_c_usr_type_id_client = 10;

  public static C_Usr_Type_Manager getCI() {
    if (currentInstance == null) {
      currentInstance = new C_Usr_Type_Manager();
    }
    return currentInstance;
  }

  public Integer getConst_c_usr_type_id_admin() {
    return const_c_usr_type_id_admin;
  }

  public void setConst_c_usr_type_id_admin(Integer const_c_usr_type_id_admin) {
    this.const_c_usr_type_id_admin = const_c_usr_type_id_admin;
  }

  public Integer getConst_c_usr_type_id_user() {
    return const_c_usr_type_id_user;
  }

  public void setConst_c_usr_type_id_user(Integer const_c_usr_type_id_user) {
    this.const_c_usr_type_id_user = const_c_usr_type_id_user;
  }

  public Integer getConst_c_usr_type_id_seller() {
    return const_c_usr_type_id_seller;
  }

  public void setConst_c_usr_type_id_seller(Integer const_c_usr_type_id_seller) {
    this.const_c_usr_type_id_seller = const_c_usr_type_id_seller;
  }

  public Integer getConst_c_usr_type_id_customer() {
    return const_c_usr_type_id_customer;
  }

  public void setConst_c_usr_type_id_customer(Integer const_c_usr_type_id_customer) {
    this.const_c_usr_type_id_customer = const_c_usr_type_id_customer;
  }

  public Integer getConst_c_usr_type_id_moderator() {
    return const_c_usr_type_id_moderator;
  }

  public void setConst_c_usr_type_id_moderator(Integer const_c_usr_type_id_moderator) {
    this.const_c_usr_type_id_moderator = const_c_usr_type_id_moderator;
  }

  public Integer getConst_c_usr_type_id_client() {
    return const_c_usr_type_id_client;
  }

  public void setConst_c_usr_type_id_client(Integer const_c_usr_type_id_client) {
    this.const_c_usr_type_id_client = const_c_usr_type_id_client;
  }

  public C_Usr_Type_Manager() {
    super(C_Usr_Type.class);
  }

}
