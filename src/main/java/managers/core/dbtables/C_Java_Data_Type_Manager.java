package managers.core.dbtables;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import model.core.dbtables.*;
import gs.common.managers.My_Abstract_Controller_Manager;

@ManagedBean
@ApplicationScoped
public class C_Java_Data_Type_Manager extends Abstract_Controller_Manager<C_Java_Data_Type> {

  private static C_Java_Data_Type_Manager currentInstance = null;
  
  public static Integer c_java_data_type_id_String = 1;
  private static C_Java_Data_Type c_java_data_type_String;
  public static Integer c_java_data_type_id_Integer = 2;
  private static C_Java_Data_Type c_java_data_type_Integer;
  public static Integer c_java_data_type_id_Double = 3;
  private static C_Java_Data_Type c_java_data_type_Double;
  public static Integer c_java_data_type_id_Long = 8;
  private static C_Java_Data_Type c_java_data_type_Long;

  public static C_Java_Data_Type_Manager getCI() {
    if (currentInstance == null) {
      currentInstance = new C_Java_Data_Type_Manager();
    }
    return currentInstance;
  }

  public C_Java_Data_Type_Manager() {
    super(C_Java_Data_Type.class);
  }

  public static void main(String[] args) {

  }

  public static C_Java_Data_Type getC_java_data_type_String() {
    if (c_java_data_type_String == null) {
      c_java_data_type_String = getCI().get_rec(c_java_data_type_id_String);
    }
    return c_java_data_type_String;
  }

  public static C_Java_Data_Type getC_java_data_type_Double() {
    if (c_java_data_type_Double == null) {
      c_java_data_type_Double = getCI().get_rec(c_java_data_type_id_Double);
    }
    return c_java_data_type_Double;
  }

  public static C_Java_Data_Type getC_java_data_type_Integer() {
    if (c_java_data_type_Integer == null) {
      c_java_data_type_Integer = getCI().get_rec(c_java_data_type_id_Integer);
    }

    return c_java_data_type_Integer;
  }

  public static Integer getC_java_data_type_id_String() {
    return c_java_data_type_id_String;
  }

  public static void setC_java_data_type_id_String(Integer c_java_data_type_id_String) {
    C_Java_Data_Type_Manager.c_java_data_type_id_String = c_java_data_type_id_String;
  }

  public static Integer getC_java_data_type_id_Integer() {
    return c_java_data_type_id_Integer;
  }

  public static void setC_java_data_type_id_Integer(Integer c_java_data_type_id_Integer) {
    C_Java_Data_Type_Manager.c_java_data_type_id_Integer = c_java_data_type_id_Integer;
  }

  public static void setC_java_data_type_Integer(C_Java_Data_Type c_java_data_type_Integer) {
    C_Java_Data_Type_Manager.c_java_data_type_Integer = c_java_data_type_Integer;
  }

  public static Integer getC_java_data_type_id_Double() {
    return c_java_data_type_id_Double;
  }

  public static void setC_java_data_type_id_Double(Integer c_java_data_type_id_Double) {
    C_Java_Data_Type_Manager.c_java_data_type_id_Double = c_java_data_type_id_Double;
  }

  public static Integer getC_java_data_type_id_Long() {
    return c_java_data_type_id_Long;
  }

  public static void setC_java_data_type_id_Long(Integer c_java_data_type_id_Long) {
    C_Java_Data_Type_Manager.c_java_data_type_id_Long = c_java_data_type_id_Long;
  }

  public static C_Java_Data_Type getC_java_data_type_Long() {
    if (c_java_data_type_Long == null) {
      c_java_data_type_Long = getCI().get_rec(c_java_data_type_id_Long);
    }
    return c_java_data_type_Long;
  }

  public static void setC_java_data_type_Long(C_Java_Data_Type c_java_data_type_Long) {
    C_Java_Data_Type_Manager.c_java_data_type_Long = c_java_data_type_Long;
  }

}
