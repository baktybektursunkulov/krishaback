package gs.model.core.dbtables;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "c_tz")
public class C_Tz {

  //fields
  private Integer c_tz;
  private String name;
  private Integer interval_in_min;
  private Boolean is_deleted;

  public C_Tz() {

  }
  //fields getter and setter methods

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "c_tz", unique = true, nullable = false)
  public Integer getC_tz() {
    return this.c_tz;
  }

  public void setC_tz(Integer c_tz) {
    this.c_tz = c_tz;
  }

  @Column(name = "name", nullable = false)
  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Column(name = "interval_in_min", nullable = false)
  public Integer getInterval_in_min() {
    return this.interval_in_min;
  }

  public void setInterval_in_min(Integer interval_in_min) {
    this.interval_in_min = interval_in_min;
  }

  @Transient
  public String getShortName() {
    String res = "";
    int hour_ = getInterval_in_min() / 60;
    if (hour_ == 0) {
      res = "";
    } else if (hour_ > 0) {
      res = "+";
    } else if (hour_ < 0) {
      res = "-";
    }
    res = res + (String.valueOf(Math.abs(hour_)).length() == 1 ? "0" + Math.abs(hour_) : Math.abs(hour_));
    int minute_ = getInterval_in_min() % 60;
    res = res + ":" + (String.valueOf(minute_).length() == 1 ? "0" + minute_ : minute_);
    return res;
  }

}
