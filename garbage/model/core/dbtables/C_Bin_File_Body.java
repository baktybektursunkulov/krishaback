package gs.model.core.dbtables;

import javax.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name = "c_bin_file_body")
public class C_Bin_File_Body implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "c_bin_file_body", unique = true, nullable = false)
  private Long c_bin_file_body;

  @Lob
  private byte[] file_body;

  public C_Bin_File_Body(Long c_bin_file_body, byte[] file_body) {
    this.c_bin_file_body = c_bin_file_body;
    this.file_body = file_body;
  }

  public C_Bin_File_Body() {
  }

}
