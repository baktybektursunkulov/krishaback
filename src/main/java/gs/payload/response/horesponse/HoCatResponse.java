/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gs.payload.response.horesponse;

/**
 *
 * @author User
 */
public class HoCatResponse {
  private Integer id;
  private String title;

  public HoCatResponse(Integer id, String title) {
    this.id = id;
    this.title = title;
  }
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }
  
  
}
