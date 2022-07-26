
package gs.payload.request.horequest;

import java.util.List;
import lombok.Data;


 @Data public class SeleniumRequest {
   private Double lat;
   private Double lon;
   private Integer room_cnt;
   private Double total_area;
   private String street_name;
   private Double price;
   private String loc;
   private String txt;
   private List<String> sidebar;
   private List<String> sidebar_values;
   private String contact;
   private List<String> offer_parameters;
   private List<String> offer_parameters_values;
   private String phone;
   private String url;
   private String file_name;
   private List<String> url_small;
   private List<String> file_name_small;
}
