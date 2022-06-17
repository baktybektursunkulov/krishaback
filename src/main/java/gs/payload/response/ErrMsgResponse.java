package gs.payload.response;

public class ErrMsgResponse {

  private String err_msg;

  public ErrMsgResponse(String err_msg) {
    this.err_msg = err_msg;
  }

  public String getErr_msg() {
    return err_msg;
  }

  public void setErr_msg(String err_msg) {
    this.err_msg = err_msg;
  }

}
