package pf;

import java.io.Serializable; import gs.common.model.db.Abstract_Entity;

public class Theme implements Serializable {

  private String name;
  private String image;

  public Theme() {
  }

  public Theme(String name, String image) {
    this.name = name;
    this.image = image;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return name;
  }

  
}
