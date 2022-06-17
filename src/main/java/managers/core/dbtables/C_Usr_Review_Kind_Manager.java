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
public class C_Usr_Review_Kind_Manager extends Abstract_Controller_Manager<C_Usr_Review_Kind> {

  private static C_Usr_Review_Kind_Manager currentInstance = null;
  private Integer c_usr_review_kind_id__main = 1;// Основной
  private Integer c_usr_review_kind_id__compliance_with_description = 3;// Соответствие товара описанию
  private Integer c_usr_review_kind_id__communication_with_the_seller = 5;// Общение с продавцом
  private Integer c_usr_review_kind_id__speed_and_quality_of_delivery = 6;// Скорость и качество доставки товара

  public static C_Usr_Review_Kind_Manager getCI() {
    if (currentInstance == null) {
      currentInstance = new C_Usr_Review_Kind_Manager();
    }
    return currentInstance;
  }

  public Integer getC_usr_review_kind_id__main() {
    return c_usr_review_kind_id__main;
  }

  public void setC_usr_review_kind_id__main(Integer c_usr_review_kind_id__main) {
    this.c_usr_review_kind_id__main = c_usr_review_kind_id__main;
  }

  public Integer getC_usr_review_kind_id__compliance_with_description() {
    return c_usr_review_kind_id__compliance_with_description;
  }

  public void setC_usr_review_kind_id__compliance_with_description(Integer c_usr_review_kind_id__compliance_with_description) {
    this.c_usr_review_kind_id__compliance_with_description = c_usr_review_kind_id__compliance_with_description;
  }

  public Integer getC_usr_review_kind_id__communication_with_the_seller() {
    return c_usr_review_kind_id__communication_with_the_seller;
  }

  public void setC_usr_review_kind_id__communication_with_the_seller(Integer c_usr_review_kind_id__communication_with_the_seller) {
    this.c_usr_review_kind_id__communication_with_the_seller = c_usr_review_kind_id__communication_with_the_seller;
  }

  public Integer getC_usr_review_kind_id__speed_and_quality_of_delivery() {
    return c_usr_review_kind_id__speed_and_quality_of_delivery;
  }

  public void setC_usr_review_kind_id__speed_and_quality_of_delivery(Integer c_usr_review_kind_id__speed_and_quality_of_delivery) {
    this.c_usr_review_kind_id__speed_and_quality_of_delivery = c_usr_review_kind_id__speed_and_quality_of_delivery;
  }

  public C_Usr_Review_Kind_Manager() {
    super(C_Usr_Review_Kind.class);
  }

}
