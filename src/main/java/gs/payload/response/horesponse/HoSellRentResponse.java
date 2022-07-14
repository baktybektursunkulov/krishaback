/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gs.payload.response.horesponse;

/**
 *
 * @author User
 */
public class HoSellRentResponse {
  private Integer id;
  private String title;
  private Boolean hasChildren;

  public Boolean getHasChildren() {
    return hasChildren;
  }

  public void setHasChildren(Boolean hasChildren) {
    this.hasChildren = hasChildren;
  }
  
  public HoSellRentResponse(Integer id, String title,Boolean hasChildren) {
    this.id = id;
    this.title = title;
    this.hasChildren=hasChildren;
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
