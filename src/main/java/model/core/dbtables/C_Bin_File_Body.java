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
@Table(name = "c_bin_file_body")
@Proxy(lazy = false)
//@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class C_Bin_File_Body extends Abstract_Entity {

  //fields
  private Long c_bin_file_body;
  private byte[] file_body;

  //transient fields
  public C_Bin_File_Body() {

  }

  //fields getter and setter methods
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "c_bin_file_body")
  public Long getC_bin_file_body() {
    return this.c_bin_file_body;
  }

  public void setC_bin_file_body(Long c_bin_file_body) {
    this.c_bin_file_body = c_bin_file_body;
  }

  @Column(name = "file_body")
  public byte[] getFile_body() {
    return this.file_body;
  }

  public void setFile_body(byte[] file_body) {
    this.file_body = file_body;
  }

  public C_Bin_File_Body(Long c_bin_file_body, byte[] file_body) {
    this.c_bin_file_body = c_bin_file_body;
    this.file_body = file_body;
  } 
  
  @Override
  public int hashCode() {
    int hash = 7;
    hash = 89 * hash + Objects.hashCode(this.getC_bin_file_body());
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
    final C_Bin_File_Body other = (C_Bin_File_Body) obj;
    if (!Objects.equals(this.getC_bin_file_body(), other.getC_bin_file_body())) {
      return false;
    }
    return true;
  }

  
  @Transient
  @Override
  public Serializable getEntity_id() {
    return getC_bin_file_body();
  }

}
