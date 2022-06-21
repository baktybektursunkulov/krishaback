/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gs.services.ho;

import gs.payload.response.horesponse.HoCatResponse;
import gs.repositories.core.dbtables.C_Usr_Repository;
import gs.repositories.ho.dbtables.Ho_Ad_Repository;
import gs.repositories.ho.dbtables.Ho_Usr_Repository;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import model.core.dbtables.C_Usr;
import model.ho.dbtables.Ho_Ad;
import model.ho.dbtables.Ho_Cat;
import model.ho.dbtables.Ho_Usr;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author User
 */
public class Ho_Usr_Service {
//   @Autowired
//  private Ho_Usr_Repository repository;
//   
//    @Autowired
//  private C_Usr_Repository repository1;
//  
//  public Ho_Usr get_ho_usr(Long c_usr_id_)  {
//    Ho_Usr ho_usr=new Ho_Usr() ;
//     Optional<C_Usr> c_usr1 = repository1.find(c_usr_id_);
//    
//        List<Ho_Usr> ho_usrs=repository.findAll();
//        for (Ho_Usr ho_usr1 : ho_usrs) {
//         if(c_usr1.get().getC_usr()!=ho_usr1.getC_usr()){
//             ho_usr.setC_usr(c_usr_id_);
//             ho_usr.setHo_contact_info_type(1);
//             ho_usr.setContact_name(c_usr1.get().getName());
//             ho_usr.setMain_phone_num(c_usr1.get().getPhone_num());
//             ho_usr.setC_loc(2);
//             ho_usr.setIs_notif_when_publish(Boolean.TRUE);
//             ho_usr.setIs_notif_when_refuse(Boolean.TRUE);
//             ho_usr.setIs_notif_when_remove(Boolean.TRUE);
//             ho_usr.setIs_notif_when_new_msg(Boolean.TRUE);
//             ho_usr.setIs_deleted(Boolean.FALSE);
//         }
//         else return ho_usr;
//        }
//    repository.save(ho_usr);
//    return ho_usr;
//} 
  
}
