package gs.model.core.dbtables;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "c_usr_type")
public class C_Usr_Type {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer c_usr_type;

  @Column(length = 20)
  private String code;

  private String name;

  private Boolean is_deleted;

  public C_Usr_Type() {

  }

}
