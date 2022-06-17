package gs.payload.response;

import com.fasterxml.jackson.annotation.JsonKey;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

public class UserResponse {

  @JsonProperty(value="user")
  private UserForResponse userForResponse;

  public UserResponse(UserForResponse userForResponse) {
    this.userForResponse = userForResponse;
  }

  public UserForResponse getUserForResponse() {
    return userForResponse;
  }

  public void setUserForResponse(UserForResponse userForResponse) {
    this.userForResponse = userForResponse;
  }

}
