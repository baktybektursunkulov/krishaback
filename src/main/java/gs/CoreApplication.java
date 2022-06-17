package gs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class CoreApplication {

  public static void main(String[] args) {
    //System.setProperty("is_initialize_res_bundle", "false");
    SpringApplication.run(CoreApplication.class, args);
  }

}
