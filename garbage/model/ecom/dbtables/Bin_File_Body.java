package gs.model.ecom.dbtables;

import javax.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name = "bin_file_body_local")
public class Bin_File_Body implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long bin_file_body;

  //@Lob
  private byte[] file_body;

  public Bin_File_Body(Long bin_file_body, byte[] file_body) {
    this.bin_file_body = bin_file_body;
    this.file_body = file_body;
  }

  public Bin_File_Body() {
  }

}
