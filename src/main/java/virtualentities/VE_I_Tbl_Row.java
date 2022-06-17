package virtualentities;

import gs.common.other_funcs;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import managers.core.dbtables.I_Tbl_Fld_Trans_Manager;
import org.hibernate.Session;

public class VE_I_Tbl_Row implements Serializable {

  private String id;
  private String label;

  //transient fields
  private String label_translation;

  public VE_I_Tbl_Row() {

  }

  public VE_I_Tbl_Row(String id, String label) {
    this.id = id;
    this.label = label;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }

  @Transient
  public String getLabel_translation() {
    return label_translation;
  }

  public void setLabel_translation(String label_translation) {
    this.label_translation = label_translation;
  }

  @Transient
  public String getLabel_translation_3(Session session_, String i_tbl_name_, String i_tbl_fld_name_, String lang_) {
    if (label_translation == null) {
      if (lang_.equals("ru")) {
        label_translation = getLabel();
      } else {
        label_translation = I_Tbl_Fld_Trans_Manager.get_tbl_fld_translation(session_, i_tbl_name_, other_funcs.parseInt(getId(), 0), i_tbl_fld_name_, lang_, getLabel());
      }
    }
    return label_translation;
  }

}
