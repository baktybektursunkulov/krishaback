package gs.payload.request;

import java.util.Set;

import javax.validation.constraints.*;

public class SignupRequest {

  @NotBlank
  @Size(min = 5, max = 250)
  @Email
  private String username;

  /*
    @NotBlank
    @Size(min = 3, max = 20)
    private String username;
 
    @NotBlank
    @Size(max = 50)
    @Email
    private String email;
   */
  private Set<String> role;

  @NotBlank
  @Size(min = 6, max = 40)
  private String password;

  @NotBlank
  @Size(min = 6, max = 40)
  private String password2;

  @NotNull
  private Integer tz_offset_in_min;

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  /*
    public String getEmail() {
        return email;
    }
 
    public void setEmail(String email) {
        this.email = email;
    }
   */
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getPassword2() {
    return password2;
  }

  public void setPassword2(String password2) {
    this.password2 = password2;
  }

  public Set<String> getRole() {
    return this.role;
  }

  public void setRole(Set<String> role) {
    this.role = role;
  }

  public Integer getTz_offset_in_min() {
    return tz_offset_in_min;
  }

  public void setTz_offset_in_min(Integer tz_offset_in_min) {
    this.tz_offset_in_min = tz_offset_in_min;
  }

}
