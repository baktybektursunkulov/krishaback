package gs.model.core.dbtables;

import gs.common.model.db.Abstract_Entity;
import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "c_usr")
public class C_Usr extends Abstract_Entity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "c_usr", unique = true, nullable = false)
  private Long c_usr;

  private Integer c_proj;
  private Integer c_usr_type;

  @NotBlank
  @Size(max = 320)
  private String name;

  @NotBlank
  @Size(max = 320)
  private String pswd;

  private String pswd_salt;
  private Long creator_usr;
  private Boolean can_change_pswd;
  private Boolean is_on;

  @NotBlank
  @Size(max = 320)
  @Email
  private String email;

  private Integer c_tz;
  private String our_note;
  private Date ins_dt;
  private Date sale_date;
  private Boolean is_subscribed_to_sys_news;
  private Boolean is_self_registered;
  private Integer c_usr_status;
  private String phone_num;
  private String cus_fields;
  private Boolean is_email_verified;
  private Boolean is_phone_num_verified;
  private Integer c_usr_person_type;
  private String contact_person_fio;
  private Integer c_country;
  private Integer current_c_lang;
  private Boolean is_deleted;

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "c_lt_usr_role",
    joinColumns = @JoinColumn(name = "c_usr"),
    inverseJoinColumns = @JoinColumn(name = "c_usr_role"))
  private Set<C_Usr_Role> c_usr_roles = new HashSet<>();

  public C_Usr() {
  }

}
