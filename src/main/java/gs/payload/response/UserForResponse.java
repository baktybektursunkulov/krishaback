package gs.payload.response;

import model.core.dbtables.C_Usr;
import gs.security.services.UserDetailsImpl;

public class UserForResponse {

  private Long id;
  private String username;
  private String email;

  public UserForResponse(UserDetailsImpl userDetailsImpl) {
    this.id = userDetailsImpl.getC_usr().getC_usr();
    this.username = userDetailsImpl.getUsername();
    this.email = userDetailsImpl.getC_usr().getEmail();
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  
  
  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

}
