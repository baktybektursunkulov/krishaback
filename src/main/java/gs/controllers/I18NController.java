package gs.controllers;

import managers.core.dbtables.C_Res_Bundle_Manager;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/i18n")
public class I18NController {
	@GetMapping("/{lang}")
	public ResponseEntity<?> user(@PathVariable("lang") String lang) {
    //System.out.println(C_Res_Bundle_Manager.c_res_bundle_map.get("bundle_ru")); 
    //System.out.println("lang=" + lang);
    JSONObject jSONObject =C_Res_Bundle_Manager.get_json_object_for_i18n("bundle", lang);
    //json_funcs.silent_put(jSONObject, "welcome", "Добро пожаловать Kuan1!");
    return ResponseEntity.ok(jSONObject.toString());
  }
	
}
