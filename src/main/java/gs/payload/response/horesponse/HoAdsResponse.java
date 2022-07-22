package gs.payload.response.horesponse;
import java.util.Date;
import java.util.List;
import lombok.Data;

@Data public class HoAdsResponse {
  private Integer id;
  private String pageTitle;
  private String title;
  private Double price;
  private Integer categoryId;
  private Boolean isMortgaged;
  private PublishedBy publishedBy;
  private List<Integer> images;
  private Date publishDate;
  private String text;
  private HoAdFieldsResponse properties;

  public HoAdsResponse() {
  }

  public HoAdsResponse(Integer id, String pageTitle, String title, Double price, Integer categoryId, Boolean isMortgaged, PublishedBy publishedBy, List<Integer> images, Date publishDate, String text, HoAdFieldsResponse properties) {
    this.id = id;
    this.pageTitle = pageTitle;
    this.title = title;
    this.price = price;
    this.categoryId = categoryId;
    this.isMortgaged = isMortgaged;
    this.publishedBy = publishedBy;
    this.images = images;
    this.publishDate = publishDate;
    this.text = text;
    this.properties = properties;
  }
 
}
