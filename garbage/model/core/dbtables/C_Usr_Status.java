package gs.model.core.dbtables;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "c_usr_status")
public class C_Usr_Status {

  //fields
  private Integer c_usr_status;
  private String code;
  private String name;

  //transient fields
  public C_Usr_Status() {

  }

  //fields getter and setter methods
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "c_usr_status", unique = true, nullable = false)
  public Integer getC_usr_status() {
    return this.c_usr_status;
  }

  public void setC_usr_status(Integer c_usr_status) {
    this.c_usr_status = c_usr_status;
  }

  @Column(name = "code", nullable = false)
  public String getCode() {
    return this.code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  @Column(name = "name", nullable = false)
  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
