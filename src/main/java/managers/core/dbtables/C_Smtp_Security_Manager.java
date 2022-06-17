package managers.core.dbtables;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import model.core.dbtables.*;
import gs.common.managers.My_Abstract_Controller_Manager;

@ManagedBean
@ApplicationScoped
public class C_Smtp_Security_Manager extends Abstract_Controller_Manager<C_Smtp_Security> {

  private static C_Smtp_Security_Manager currentInstance = null;
  private Integer id_NO = 1;// Нет
  private Integer id_SSL = 2;// SSL
  private Integer id_TLS = 3;// TLS

  public static C_Smtp_Security_Manager getCI() {
    if (currentInstance == null) {
      currentInstance = new C_Smtp_Security_Manager();
    }
    return currentInstance;
  }

  public Integer getId_NO() {
    return id_NO;
  }

  public void setId_NO(Integer id_NO) {
    this.id_NO = id_NO;
  }

  public Integer getId_SSL() {
    return id_SSL;
  }

  public void setId_SSL(Integer id_SSL) {
    this.id_SSL = id_SSL;
  }

  public Integer getId_TLS() {
    return id_TLS;
  }

  public void setId_TLS(Integer id_TLS) {
    this.id_TLS = id_TLS;
  }

  
  
  public C_Smtp_Security_Manager() {
    super(C_Smtp_Security.class);
  }

  public static String get_smtp_security_model(C_Smtp_Security C_Smtp_Security_) {
    String res = "";
    switch (C_Smtp_Security_.getCode()) {
      case "NO":
        res = email.funcs.c_smtp_security_model_none;
        break;
      case "SSL":
        res = email.funcs.c_smtp_security_model_ssl;
        break;
      case "TLS":
        res = email.funcs.c_smtp_security_model_tls;
        break;
    }
    return res;
  }   
}
