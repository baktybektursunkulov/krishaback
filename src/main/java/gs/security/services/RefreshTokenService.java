package gs.security.services;

import gs.exception.TokenRefreshException;
import model.core.dbtables.C_Usr_Refresh_Token;
import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import gs.repositories.core.dbtables.C_Usr_Repository;
import gs.repositories.core.dbtables.C_Usr_Refresh_Token_Repository;
import model.core.dbtables.C_Usr;

@Service
public class RefreshTokenService {
  @Value("${app.jwtRefreshExpirationMs}")
  private Long refreshTokenDurationMs;

  @Autowired
  private C_Usr_Refresh_Token_Repository c_Usr_Refresh_Token_Repository;

  @Autowired
  private C_Usr_Repository c_Usr_Repository;

  public Optional<C_Usr_Refresh_Token> find_by_refresh_token(String refresh_token_) {
    return c_Usr_Refresh_Token_Repository.find_by_refresh_token(refresh_token_);
  }

  public C_Usr_Refresh_Token createRefreshToken(C_Usr c_Usr) {
    C_Usr_Refresh_Token c_Usr_Refresh_Token = new C_Usr_Refresh_Token();

    c_Usr_Refresh_Token.setC_usr(c_Usr.getC_usr());
    c_Usr_Refresh_Token.setExp_dt(Instant.now().plusMillis(refreshTokenDurationMs));
    c_Usr_Refresh_Token.setRefresh_token(UUID.randomUUID().toString());
    c_Usr_Refresh_Token.setIs_deleted(false);

    c_Usr_Refresh_Token = c_Usr_Refresh_Token_Repository.save(c_Usr_Refresh_Token);
    return c_Usr_Refresh_Token;
  }

  public C_Usr_Refresh_Token verifyExpiration(C_Usr_Refresh_Token c_Usr_Refresh_Token) {
    if (c_Usr_Refresh_Token.getExp_dt().compareTo(Instant.now()) < 0) {
      c_Usr_Refresh_Token_Repository.delete(c_Usr_Refresh_Token);
      throw new TokenRefreshException(c_Usr_Refresh_Token.getRefresh_token(), "Refresh token was expired. Please make a new signin request");
    }

    return c_Usr_Refresh_Token;
  }

  @Transactional
  public void del_by_c_usr_id(Long cUsrId) {
    c_Usr_Refresh_Token_Repository.del_by_c_usr_id(c_Usr_Repository.findById(cUsrId).get().getC_usr());
  }
  
  @Transactional
  public void del_by_refresh_token(String refresh_token_) {
    c_Usr_Refresh_Token_Repository.del_by_refresh_token(refresh_token_);
  }
  
}
