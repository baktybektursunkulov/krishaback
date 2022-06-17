package managers.core.dbtables;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import model.core.dbtables.*;
import gs.common.managers.My_Abstract_Controller_Manager;

@ManagedBean
@ApplicationScoped
public class C_Usr_Status_Manager extends Abstract_Controller_Manager<C_Usr_Status> {

  private static C_Usr_Status_Manager currentInstance = null;
  private Integer id__active = 1;// Активен
  private Integer id__blocked = 2;// Заблокирован
  private Integer id__under_consideration = 3;// На рассмотрении

  public static C_Usr_Status_Manager getCI() {
    if (currentInstance == null) {
      currentInstance = new C_Usr_Status_Manager();
    }
    return currentInstance;
  }

  public Integer getId__active() {
    return id__active;
  }

  public void setId__active(Integer id__active) {
    this.id__active = id__active;
  }

  public Integer getId__blocked() {
    return id__blocked;
  }

  public void setId__blocked(Integer id__blocked) {
    this.id__blocked = id__blocked;
  }

  public Integer getId__under_consideration() {
    return id__under_consideration;
  }

  public void setId__under_consideration(Integer id__under_consideration) {
    this.id__under_consideration = id__under_consideration;
  }

  public C_Usr_Status_Manager() {
    super(C_Usr_Status.class);
  }

}
