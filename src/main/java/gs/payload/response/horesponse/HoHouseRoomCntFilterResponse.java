/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gs.payload.response.horesponse;

/**
 *
 * @author User
 */
public class HoHouseRoomCntFilterResponse {
  private Integer id;
  private String quantity;

  public HoHouseRoomCntFilterResponse(Integer id, String quantity) {
    this.id = id;
    this.quantity = quantity;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getQuantity() {
    return quantity;
  }

  public void setQuantity(String quantity) {
    this.quantity = quantity;
  }
  
  
}
