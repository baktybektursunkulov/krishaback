package pf;

import java.io.Serializable; import gs.common.model.db.Abstract_Entity;

public class ColumnModel implements Serializable {

  private String header;
  private Object property;

  public ColumnModel() {
  }

  public ColumnModel(String header, Object property) {
    this.header = header;
    this.property = property;
  }

  public String getHeader() {
    return header;
  }

  public void setHeader(String header) {
    this.header = header;
  }

  public Object getProperty() {
    return property;
  }

  public void setProperty(Object property) {
    this.property = property;
  }

}
