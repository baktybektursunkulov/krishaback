package gs.model.core.dbtables;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "c_site")
public class C_Site {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer c_site;

  private Integer c_usr;
  private String domain;
  private String title;
  private String copyright_text;
  private Integer c_theme;
  private String copyright_url;
  private String javascript_text;
  private String css_text;
  private Boolean use_https;
  private String custom_fields;
  private Integer c_proj;
  private String terms_of_use_content;
  private String footer_content;
  private Boolean is_show_terms_of_use; 
  private Boolean is_deleted;
  private Integer c_country;
  
  public C_Site() {

  }

}
