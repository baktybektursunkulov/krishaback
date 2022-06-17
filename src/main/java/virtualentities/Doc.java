package virtualentities;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Transient;
import model.core.dbtables.Dc_Doc_Cont_Row;

public class Doc implements Serializable, Comparable<Doc> {

  private String name;
  private String url;
  private String content_txt;
  private String content_txt_for_search;
  private Dc_Doc_Cont_Row dc_doc_cont_row;

  //private String size;
  //private String type;
/*
  public Doc(String name, String size, String type) {
    this.name = name;
    this.size = size;
    this.type = type;
  }
   */
  public Doc(String name, String url) {
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

  public String getContent_txt() {
    return content_txt;
  }

  public void setContent_txt(String content_txt) {
    this.content_txt = content_txt;
  }

  public String getContent_txt_for_search() {
    return content_txt_for_search;
  }

  public void setContent_txt_for_search(String content_txt_for_search) {
    this.content_txt_for_search = content_txt_for_search;
  }

  public Dc_Doc_Cont_Row getDc_doc_cont_row() {
    return dc_doc_cont_row;
  }

  public void setDc_doc_cont_row(Dc_Doc_Cont_Row dc_doc_cont_row) {
    this.dc_doc_cont_row = dc_doc_cont_row;
  }

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

  public int compareTo(Doc document) {
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
    final Doc other = (Doc) obj;
    if (!Objects.equals(this.name, other.name)) {
      return false;
    }
    if (!Objects.equals(this.url, other.url)) {
      return false;
    }
    return true;
  }

}
