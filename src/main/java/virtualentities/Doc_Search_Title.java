package virtualentities;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Transient;

public class Doc_Search_Title implements Serializable, Comparable<Doc_Search_Title> {

  private String name;
  private String url;
  //private String content_txt;

  //private String size;
  //private String type;
/*
  public Doc(String name, String size, String type) {
    this.name = name;
    this.size = size;
    this.type = type;
  }
   */
  public Doc_Search_Title(String name, String url) {
    this.name = name;
    this.url = url;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }
/*
  public String getContent_txt() {
    return content_txt;
  }

  public void setContent_txt(String content_txt) {
    this.content_txt = content_txt;
  }
*/
  /*
  public String getSize() {
    return size;
  }

  public void setSize(String size) {
    this.size = size;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }
   */
  @Override
  public String toString() {
    return name;
  }

  public int compareTo(Doc_Search_Title document) {
    return this.getName().compareTo(document.getName());
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 41 * hash + Objects.hashCode(this.name);
    hash = 41 * hash + Objects.hashCode(this.url);
    return hash;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final Doc_Search_Title other = (Doc_Search_Title) obj;
    if (!Objects.equals(this.name, other.name)) {
      return false;
    }
    if (!Objects.equals(this.url, other.url)) {
      return false;
    }
    return true;
  }

}
