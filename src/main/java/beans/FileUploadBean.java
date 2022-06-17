package beans;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class FileUploadBean implements Serializable {  
  
  private Integer c_tbl_id;
  private Long rec_id;
  private String user_name;

  public Long getRec_id() {
    return rec_id;
  }

  public void setRec_id(Long rec_id) {
    this.rec_id = rec_id;
  }

  public Integer getC_tbl_id() {
    return c_tbl_id;
  }

  public void setC_tbl_id(Integer c_tbl_id) {
    this.c_tbl_id = c_tbl_id;
  }

  public String getUser_name() {
    return user_name;
  }

  public void setUser_name(String user_name) {
    this.user_name = user_name;
  }

	@Override
	public String toString() {
    String res = "FileUploadBean record, c_tbl_id=%1, rec_id=%2, user_name=%3";
    res = res.replace("%1", c_tbl_id==null?"null":c_tbl_id.toString());
    res = res.replace("%2", rec_id==null?"null":rec_id.toString());
    res = res.replace("%3", user_name==null?"null":user_name.toString());
		return res;
	}
  
}  