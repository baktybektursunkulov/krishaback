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
public class C_Usr_Role_Manager extends Abstract_Controller_Manager<C_Usr_Role> {

  private static C_Usr_Role_Manager currentInstance = null;
  private Integer id_code__admin = 1;// Администратор
  private Integer id_code__moderator = 2;// Модератор
  private Integer id_code__user = 3;// Пользователь

  public static C_Usr_Role_Manager getCI() {
    if (currentInstance == null) {
      currentInstance = new C_Usr_Role_Manager();
    }
    return currentInstance;
  }

  public Integer getId_code__admin() {
    return id_code__admin;
  }

  public void setId_code__admin(Integer id_code__admin) {
    this.id_code__admin = id_code__admin;
  }

  public Integer getId_code__moderator() {
    return id_code__moderator;
  }

  public void setId_code__moderator(Integer id_code__moderator) {
    this.id_code__moderator = id_code__moderator;
  }

  public Integer getId_code__user() {
    return id_code__user;
  }

  public void setId_code__user(Integer id_code__user) {
    this.id_code__user = id_code__user;
  }

  public C_Usr_Role_Manager() {
    super(C_Usr_Role.class);
  }

}
