package model.ecom.dbtables;

import gs.common.model.db.Abstract_Entity;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "bin_file_body_local")
public class Bin_File_Body extends Abstract_Entity {

  private Long bin_file_body;
  private byte[] file_body;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Long getBin_file_body() {
    return bin_file_body;
  }

  public void setBin_file_body(Long bin_file_body) {
    this.bin_file_body = bin_file_body;
  }

  public byte[] getFile_body() {
    return file_body;
  }

  public void setFile_body(byte[] file_body) {
    this.file_body = file_body;
  }

  
  
  public Bin_File_Body(Long bin_file_body, byte[] file_body) {
    this.bin_file_body = bin_file_body;
    this.file_body = file_body;
  }

  public Bin_File_Body() {
  }

  @Transient
  @Override
  public Serializable getEntity_id() {
    return getBin_file_body();
  }
  
}
