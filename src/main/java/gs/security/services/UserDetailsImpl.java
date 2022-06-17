package gs.security.services;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import model.core.dbtables.C_Usr;

public class UserDetailsImpl implements UserDetails {

  private static final long serialVersionUID = 1L;
  private C_Usr c_usr;
  private String username;

  @JsonIgnore
  private String password;

  private Collection<? extends GrantedAuthority> authorities;

  public UserDetailsImpl(C_Usr c_usr, String username, String password,
    Collection<? extends GrantedAuthority> authorities) {
    this.c_usr = c_usr;
    this.username = username;
    this.password = password;
    this.authorities = authorities;
  }

  public static UserDetailsImpl build(C_Usr c_Usr) {
    List<GrantedAuthority> authorities = c_Usr.getC_usr_roles().stream()
      .map(role -> new SimpleGrantedAuthority(role.getCode()))
      .collect(Collectors.toList());
    return new UserDetailsImpl(
      c_Usr,
      c_Usr.getName(),
      c_Usr.getPswd(),
      authorities);
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return authorities;
  }

  public C_Usr getC_usr() {
    return c_usr;
  }

  @Override
  public String getUsername() {
    return username;
  }

  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }

}
