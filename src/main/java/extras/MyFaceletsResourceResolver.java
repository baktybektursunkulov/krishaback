package extras;

import java.net.URL;

import javax.faces.view.facelets.ResourceResolver;

public class MyFaceletsResourceResolver extends ResourceResolver {

  private ResourceResolver parent;
  //private String basePath;

  public MyFaceletsResourceResolver(ResourceResolver parent) {
    this.parent = parent;
    //this.basePath = "/META-INF/resources"; // TODO: Make configureable?
  }

  @Override
  public URL resolveUrl(String path) {
    URL url = parent.resolveUrl(path); // Resolves from WAR.

    if (url == null) {
      url = getClass().getResource(path); // Resolves from JAR.
    }

    return url;
  }

}
