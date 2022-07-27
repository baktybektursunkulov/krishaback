package gs.controllers.ho.dbtables;

import gs.payload.response.horesponse.HoHouseRoomCntFilterResponse;
import gs.services.ho.Ho_House_Room_Cnt_Filter_Service;
import io.swagger.annotations.Api;
import java.util.ArrayList;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import model.ho.dbtables.Ho_House_Room_Cnt_Filter;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/ho_house_room_cnt_filter")
@Api(tags = {"Ad_Cat_Controller"})
public class Ho_House_Room_Cnt_Filter_Controller {

  @Autowired
  Ho_House_Room_Cnt_Filter_Service ho_house_room_cnt_filter_Service;

  @GetMapping(value = "/find_all")
  public ResponseEntity<List<HoHouseRoomCntFilterResponse>> find_all(HttpServletRequest httpServletRequest) throws RuntimeException {

    List<HoHouseRoomCntFilterResponse> ho_list = new ArrayList();
    List<Ho_House_Room_Cnt_Filter> ho_Cats = ho_house_room_cnt_filter_Service.find_all();

    for (Ho_House_Room_Cnt_Filter ho_Cat : ho_Cats) {
      ho_list.add(new HoHouseRoomCntFilterResponse(ho_Cat.getHo_house_room_cnt_filter(),
        ho_Cat.getName()));
    }

    return new ResponseEntity<>(ho_list, HttpStatus.OK);
  }
}
