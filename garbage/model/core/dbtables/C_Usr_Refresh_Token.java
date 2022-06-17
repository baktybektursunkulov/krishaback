package gs.model.core.dbtables;

import gs.repositories.core.dbtables.C_Usr_Repository;
import java.time.Instant;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "c_usr_refresh_token")
public class C_Usr_Refresh_Token {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "c_usr_refresh_token", unique = true, nullable = false)
  private long c_usr_refresh_token;

  /*
  @OneToOne
  @JoinColumn(name = "c_usr", referencedColumnName = "c_usr")
  private C_Usr cUsr;
   */
  @Column(name = "c_usr", nullable = false)
  private Long c_usr;

  //@Column(name = "refresh_token", nullable = false)
  private String refresh_token;

  @Column(nullable = false)
  private Instant exp_dt;

  private Boolean is_deleted;

  public C_Usr_Refresh_Token() {
  }

}
