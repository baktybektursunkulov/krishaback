/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gs.payload.response.adresponse;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 *
 * @author User
 */
public class AdCatResponse {



  private Integer id;
  private String name;
  private List<AdCatResponse1> child_list;

  public AdCatResponse(Integer id, String name, List<AdCatResponse1> child_list) {
    this.id = id;
    this.name = name;
    this.child_list = child_list;
  }
  

  public AdCatResponse(Integer ad_cat, String name) {
   this.id = id;
    this.name = name;  
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @JsonProperty("subcategory")
  public List<AdCatResponse1> getChild_list() {
    return child_list;
  }

  public void setChild_list(List<AdCatResponse1> child_list) {
    this.child_list = child_list;
  }
}
  
  


