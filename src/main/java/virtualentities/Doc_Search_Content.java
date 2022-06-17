package virtualentities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Doc_Search_Content implements Serializable, Comparable<Doc_Search_Content> {

  private String name;
  private String url;
  private List<String> content_txt_list = new ArrayList<>();

  public Doc_Search_Content(String name, String url) {
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

  public List<String> getContent_txt_list() {
    return content_txt_list;
  }

  public void setContent_txt_list(List<String> content_txt_list) {
    this.content_txt_list = content_txt_list;
  }

  @Override
  public String toString() {
    return name;
  }

  public int compareTo(Doc_Search_Content document) {
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
    final Doc_Search_Content other = (Doc_Search_Content) obj;
    if (!Objects.equals(this.name, other.name)) {
      return false;
    }
    if (!Objects.equals(this.url, other.url)) {
      return false;
    }
    return true;
  }

  public static void main(String[] args) {
    //System.out.println(CustomFuncs.html2text("<span class=\"L-shaped-icon\">345345</span><br><B>I don't want this to be bold</B> &lt;script&gt;"));
    String[] words = "и е,d".split(" ");
    for (int i = 0; i < words.length; i++) {
      System.out.println(words[i]);
    }
  }
}
