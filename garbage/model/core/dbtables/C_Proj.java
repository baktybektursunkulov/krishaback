package gs.model.core.dbtables;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "c_proj")
public class C_Proj {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer c_proj;

  private String code;
  private String name;
  private String admin_email;
  private String cus_fields;
  private Integer def_c_country;
  private Integer def_c_lang;
  private Integer def_c_cur;
  private Boolean is_deleted;

  public C_Proj() {

  }

}
