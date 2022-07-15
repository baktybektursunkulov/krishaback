package gs.payload.response;


public class C_Loc_Response {
  private Integer id;
  private String title;
  private Boolean hasChildren;
  private Boolean isBigCity;

  public Boolean getIsBigCity() {
    return isBigCity;
  }

  public void setIsBigCity(Boolean isBigCity) {
    this.isBigCity = isBigCity;
  }
  private String latitude;
  private String longitude;

  public String getLatitude() {
    return latitude;
  }

  public void setLatitude(String latitude) {
    this.latitude = latitude;
  }

  public String getLongitude() {
    return longitude;
  }

  public void setLongitude(String longitude) {
    this.longitude = longitude;
  }

  public Boolean getHasChildren() {
    return hasChildren;
  }

  public void setHasChildren(Boolean hasChildren) {
    this.hasChildren = hasChildren;
  }
  
  public C_Loc_Response(Integer id, String title,Boolean hasChildren,Boolean isBigCity,String latitude,String longitude) {
    this.id = id;
    this.title = title;
    this.hasChildren=hasChildren;
    this.isBigCity=isBigCity;
    this.latitude=latitude;
    this.longitude=longitude;
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
