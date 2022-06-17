package others;

import gs.common.jsf.bundle_funcs;
import gs.common.other_funcs;
import gs.payload.response.ErrMsgResponse;
import gs.payload.response.MsgResponse;
import org.springframework.http.ResponseEntity;

public class core_spring_funcs {

  public static ResponseEntity<?> get_succ_msg_response() {
    return get_msg_response("");
  }

  public static ResponseEntity<?> get_msg_response(String msg_) {
    return ResponseEntity.ok().body(new MsgResponse(msg_));
  }
  
  public static ResponseEntity<?> get_err_msg_response(Exception e) {
    CustomLogger.error(e);
    return get_err_msg_response(other_funcs.stack2string(e));
  }

  public static ResponseEntity<?> get_err_msg_response(String err_msg_) {
    return ResponseEntity.badRequest().body(new ErrMsgResponse(err_msg_));
  }
  
}
