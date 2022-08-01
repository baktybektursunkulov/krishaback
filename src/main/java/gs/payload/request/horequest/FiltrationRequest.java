package gs.payload.request.horequest;

import gs.payload.response.horesponse.FiltrationFieldsResponse;
import java.util.List;
import lombok.Data;

@Data public class FiltrationRequest {
  private Integer cat_id;
  private List<Integer> room_cnt;
  private List<Integer> ho_build_type;
  private Boolean not_last_floor;
  private Boolean not_first_floor;
  
 
  private FiltrationFieldsResponse price;
  private FiltrationFieldsResponse floor;
  private FiltrationFieldsResponse max_floor;
  private FiltrationFieldsResponse construction_year;
  private FiltrationFieldsResponse total_area;
  private FiltrationFieldsResponse kitchen_area;
  
}
