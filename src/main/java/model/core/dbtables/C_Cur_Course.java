package model.core.dbtables;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.*;
import org.hibernate.annotations.Proxy;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import gs.common.model.db.Abstract_Entity;
import managers.core.dbtables.*;
import org.hibernate.Session;

@Entity
@Table(name="c_cur_course")
@Proxy(lazy=false) 
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class C_Cur_Course extends Abstract_Entity {

  //fields
  private Integer c_cur_course;
  private Integer c_cur;
  private Date course_dt;
  private Double course;
  private Date ins_dt;
  private Boolean is_deleted;

  //transient fields
  private C_Cur c_cur_t = null;


  public C_Cur_Course() {

  }

  //fields getter and setter methods
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="c_cur_course", unique=true, nullable=false)
  public Integer getC_cur_course() {
    return this.c_cur_course;
  }
  public void setC_cur_course(Integer c_cur_course) {
    this.c_cur_course = c_cur_course;
  }

  @Column(name="c_cur", nullable=false)
  public Integer getC_cur() {
    return this.c_cur;
  }
  public void setC_cur(Integer c_cur) {
    this.c_cur = c_cur;
  }

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name="course_dt", nullable=false, length = 19, columnDefinition="TIMESTAMP WITHOUT TIME ZONE")
  public Date getCourse_dt() {
    return this.course_dt;
  }
  public void setCourse_dt(Date course_dt) {
    this.course_dt = course_dt;
  }

  @Column(name="course", nullable=false)
  public Double getCourse() {
    return this.course;
  }
  public void setCourse(Double course) {
    this.course = course;
  }

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name="ins_dt", nullable=false, length = 19, columnDefinition="TIMESTAMP WITHOUT TIME ZONE")
  public Date getIns_dt() {
    return this.ins_dt;
  }
  public void setIns_dt(Date ins_dt) {
    this.ins_dt = ins_dt;
  }

  @Column(name="is_deleted", nullable=false)
  public Boolean getIs_deleted() {
    return this.is_deleted;
  }
  public void setIs_deleted(Boolean is_deleted) {
    this.is_deleted = is_deleted;
  }


  @Transient
  public C_Cur getC_cur_t() {
    if (this.c_cur_t == null && this.getC_cur() != null) {
      this.c_cur_t = C_Cur_Manager.getCI().get_rec(this.getC_cur()); 
    }
    return this.c_cur_t;
  }
  @Transient
  public C_Cur getC_cur_t_2(Session session_) {
    if (this.c_cur_t == null && this.getC_cur() != null) {
      this.c_cur_t = C_Cur_Manager.getCI().get_rec(session_, this.getC_cur()); 
    }
    return this.c_cur_t;
  }
  public void setC_cur_t(C_Cur c_cur_t) {
    this.c_cur_t = c_cur_t;
    this.c_cur = (this.c_cur_t != null?this.c_cur_t.getC_cur():null);
  }






  
  @Override
  public int hashCode() {
    int hash = 7;
    hash = 89 * hash + Objects.hashCode(this.getC_cur_course());
    return hash;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final C_Cur_Course other = (C_Cur_Course) obj;
    if (!Objects.equals(this.getC_cur_course(), other.getC_cur_course())) {
      return false;
    }
    return true;
  }

  @Transient
  @Override
  public Serializable getEntity_id() {
    return getC_cur_course();
  }

} 
