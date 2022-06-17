package extras;

import javax.servlet.ServletContext;
import org.ocpsoft.logging.Logger.Level;
import org.ocpsoft.rewrite.annotation.RewriteConfiguration;
import org.ocpsoft.rewrite.config.Configuration;
import org.ocpsoft.rewrite.config.ConfigurationBuilder;
import org.ocpsoft.rewrite.config.Log;
import org.ocpsoft.rewrite.servlet.config.HttpConfigurationProvider;

@RewriteConfiguration
public class ApplicationConfigurationProvider extends HttpConfigurationProvider {

  @Override
  public Configuration getConfiguration(ServletContext context) {
    return ConfigurationBuilder.begin();
      //.addRule().
//      .perform(Log.message(Level.INFO, "Rewrite is active."));
  }

  @Override
  public int priority() {
    return 0;
  }
}
