package model.core.dbtables;

import gs.common.hibernate_funcs;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.*;
import org.hibernate.annotations.Proxy;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import gs.common.model.db.Abstract_Entity;
import java.io.ByteArrayInputStream;
import managers.core.dbtables.*;
import org.hibernate.Session;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.file.UploadedFile;
import others.CustomLogger;

@Entity
@Table(name = "c_file")
@Proxy(lazy = false)
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class C_File extends Abstract_Entity {

  //fields
  private Long c_file;
  private Integer c_file_type;
  private String file_name;
  private Integer version;
  private Long size;
  private String content_type;
  private Long c_bin_file_body;
  private Boolean is_deleted;

  //transient fields
  private C_File_Type c_file_type_t = null;
  private C_Bin_File_Body c_bin_file_body_t = null;

  public C_File() {

  }

  //fields getter and setter methods
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "c_file", unique = true, nullable = false)
  public Long getC_file() {
    return this.c_file;
  }

  public void setC_file(Long c_file) {
    this.c_file = c_file;
  }

  @Column(name = "c_file_type", nullable = false)
  public Integer getC_file_type() {
    return this.c_file_type;
  }

  public void setC_file_type(Integer file_type) {
    this.c_file_type = file_type;
  }

  
  @Column(name = "file_name", nullable = false)
  public String getFile_name() {
    return this.file_name;
  }

  public void setFile_name(String file_name) {
    this.file_name = file_name;
  }

  @Column(name = "version", nullable = false)
  public Integer getVersion() {
    return this.version;
  }

  public void setVersion(Integer version) {
    this.version = version;
  }

  @Column(name = "size")
  public Long getSize() {
    return size;
  }

  public void setSize(Long size) {
    this.size = size;
  }

  
  @Column(name = "content_type")
  public String getContent_type() {
    return content_type;
  }

  public void setContent_type(String content_type) {
    this.content_type = content_type;
  }

  @Column(name = "c_bin_file_body", nullable = false)
  public Long getC_bin_file_body() {
    return this.c_bin_file_body;
  }

  public void setC_bin_file_body(Long c_bin_file_body) {
    this.c_bin_file_body = c_bin_file_body;
  }

  @Column(name = "is_deleted", nullable = false)
  public Boolean getIs_deleted() {
    return this.is_deleted;
  }

  public void setIs_deleted(Boolean is_deleted) {
    this.is_deleted = is_deleted;
  }

  @Transient
  public C_File_Type getFile_type_t() {
    if (this.c_file_type_t == null && this.getC_file_type() != null) {
      this.c_file_type_t = File_Type_Manager.getCI().get_rec(this.getC_file_type());
    }
    return this.c_file_type_t;
  }

  @Transient
  public C_File_Type getFile_type_t_2(Session session_) {
    if (this.c_file_type_t == null && this.getC_file_type() != null) {
      this.c_file_type_t = File_Type_Manager.getCI().get_rec(session_, this.getC_file_type());
    }
    return this.c_file_type_t;
  }

  public void setFile_type_t(C_File_Type file_type_t) {
    this.c_file_type_t = file_type_t;
    this.c_file_type = (this.c_file_type_t != null ? this.c_file_type_t.getC_file_type() : null);
  }

  @Transient
  public C_Bin_File_Body getC_bin_file_body_t() {
    if (this.c_bin_file_body_t == null && this.getC_bin_file_body() != null) {
      this.c_bin_file_body_t = C_Bin_File_Body_Manager.getCI().get_rec(this.getC_bin_file_body());
    }
    return this.c_bin_file_body_t;
  }

  @Transient
  public C_Bin_File_Body getC_bin_file_body_t_2(Session session_) {
    if (this.c_bin_file_body_t == null && this.getC_bin_file_body() != null) {
      this.c_bin_file_body_t = C_Bin_File_Body_Manager.getCI().get_rec(session_, this.getC_bin_file_body());
    }
    return this.c_bin_file_body_t;
  }

  public void setC_bin_file_body_t(C_Bin_File_Body bin_file_body_t) {
    this.c_bin_file_body_t = bin_file_body_t;
    this.c_bin_file_body = (this.c_bin_file_body_t != null ? this.c_bin_file_body_t.getC_bin_file_body() : null);
  }

  @Transient
  public String getShort_file_name(int max_char_cnt_) {
    String res = getFile_name();
    if (res == null) {
      return null;
    }
    if (res.length() > max_char_cnt_) {
      res = res.substring(0, max_char_cnt_);
    }
    return res;
  }

  @Transient
  public StreamedContent getFile_body_image() {
    //CustomLogger.log("getFile_body_image() getFile_body()=" + getFile_body());
    StreamedContent res = null;
    if (getC_bin_file_body_t() == null || getC_bin_file_body_t().getFile_body() == null) {
      return null;
    }
    //res = new DefaultStreamedContent(new ByteArrayInputStream(getFile_body()));
    //CustomLogger.log("res=" + res);
    res = DefaultStreamedContent.builder()
      .contentType(getContent_type())
      .stream(() -> {
        try {
          return new ByteArrayInputStream(getC_bin_file_body_t().getFile_body());
        } catch (Exception e) {
          e.printStackTrace();
          return null;
        }
      })
      .build();
    return res;
  }

  public void handleFileUpload(FileUploadEvent event) {
    UploadedFile uploadedFile = event.getFile();
    //CustomLogger.log("uploadedFile.getFileName()=" + uploadedFile.getFileName());
    //CustomLogger.log("uploadedFile.getContents()=" + event.getFile().getContents());
    setFile_name(uploadedFile.getFileName());
    if (getC_bin_file_body_t() == null) {
      setC_bin_file_body_t(new C_Bin_File_Body());
    }
    getC_bin_file_body_t().setFile_body(uploadedFile.getContent());
    setSize(uploadedFile.getSize());
    setContent_type(uploadedFile.getContentType());
    //CustomLogger.log("getFile_body()=" + getFile_body());
  }

  public C_File getCreatedFile(Session session_) {
    if (getC_bin_file_body_t_2(session_) != null && getC_bin_file_body_t_2(session_).getFile_body() != null && getC_bin_file_body_t_2(session_).getFile_body().length > 0) {
      C_File file_;
      if (getC_file() != null && C_File_Manager.is_file_exists(session_, getC_file())) {
        file_ = (C_File) session_.load(C_File.class, getC_file());
      } else {
        file_ = new C_File();
      }

      C_Bin_File_Body bin_file_body_;
      if (file_.getC_bin_file_body() != null) {
        bin_file_body_ = (C_Bin_File_Body) session_.load(C_Bin_File_Body.class, file_.getC_bin_file_body());
        bin_file_body_.setFile_body(getC_bin_file_body_t_2(session_).getFile_body());
        session_.merge(bin_file_body_);
      } else {
        bin_file_body_ = new C_Bin_File_Body();
        bin_file_body_.setFile_body(getC_bin_file_body_t_2(session_).getFile_body());
        session_.save(bin_file_body_);
      }

      file_.setC_bin_file_body(bin_file_body_.getC_bin_file_body());
      file_.setFile_name(getFile_name());
      file_.setSize(getSize());
      file_.setContent_type(getContent_type());
      if (file_.getVersion() == null) {
        file_.setVersion(1);
      } else {
        file_.setVersion(file_.getVersion() + 1);
      }
      if (getC_file_type() == null) {
        file_.setFile_type_t(File_Type_Manager.getCI().get_rec_by_code(session_, "custom"));
      } else {
        file_.setC_file_type(getC_file_type());
      }
      session_.save(file_);

      return file_;
    } else {
      return new C_File();
    }
  }

  public C_File updateAndReturnFile(Session session_) {
    if (getC_bin_file_body_t_2(session_) != null && getC_bin_file_body_t_2(session_).getFile_body() != null && getC_bin_file_body_t_2(session_).getFile_body().length > 0) {
      C_File file_;
      if (getC_file() != null) {
        file_ = (C_File) session_.load(C_File.class, getC_file());
      } else {
        file_ = new C_File();
      }

      C_Bin_File_Body bin_file_body_;
      if (file_.getC_bin_file_body() != null) {
        bin_file_body_ = (C_Bin_File_Body) session_.load(C_Bin_File_Body.class, file_.getC_bin_file_body());
        bin_file_body_.setFile_body(getC_bin_file_body_t_2(session_).getFile_body());
        session_.merge(bin_file_body_);
      } else {
        bin_file_body_ = new C_Bin_File_Body();
        bin_file_body_.setFile_body(getC_bin_file_body_t_2(session_).getFile_body());
        session_.save(bin_file_body_);
      }

      file_.setC_bin_file_body(bin_file_body_.getC_bin_file_body());
      file_.setFile_name(getFile_name());
      file_.setSize(getSize());
      file_.setContent_type(getContent_type());
      if (file_.getVersion() == null) {
        file_.setVersion(1);
      } else {
        file_.setVersion(file_.getVersion() + 1);
      }
      if (getC_file_type() == null) {
        file_.setFile_type_t(File_Type_Manager.getCI().get_rec_by_code(session_, "custom"));
      } else {
        file_.setC_file_type(getC_file_type());
      }
      session_.save(file_);

      return file_;
    } else {
      return null;
    }

  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 89 * hash + Objects.hashCode(this.getC_file());
    return hash;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final C_File other = (C_File) obj;
    if (!Objects.equals(this.getC_file(), other.getC_file())) {
      return false;
    }
    return true;
  }

  @Transient
  @Override
  public Serializable getEntity_id() {
    return getC_file();
  }

  @Override
  public String toString() {
    return "File{" + "file=" + c_file + ", file_type=" + c_file_type + ", file_name=" + file_name + ", version=" + version + ", size=" + size + ", content_type=" + content_type + '}';
  }

  public void removeFilebody() {
    if (getC_bin_file_body_t() != null) {
      getC_bin_file_body_t().setFile_body(null);
    }

  }

  public void handleFileUploadWithSaveToDB(FileUploadEvent event) {
    // we should create new file always, because user can replace file and don't save it, then new file will be replaced, it's not correct
    C_Usr c_usr_ = (C_Usr) event.getComponent().getAttributes().get("c_usr");
    UploadedFile uploadedFile = event.getFile();
    Session session_ = model.core.dbutil.CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      session_.beginTransaction();
      C_File file_;
      file_ = new C_File();

      C_Bin_File_Body bin_file_body_;
      bin_file_body_ = new C_Bin_File_Body();
      bin_file_body_.setFile_body(uploadedFile.getContent());
      session_.save(bin_file_body_);

      file_.setC_bin_file_body(bin_file_body_.getC_bin_file_body());
      file_.setFile_name(uploadedFile.getFileName());
      file_.setSize(uploadedFile.getSize());
      file_.setContent_type(uploadedFile.getContentType());
      file_.setVersion(1);
      file_.setFile_type_t(File_Type_Manager.getCI().get_rec_by_code(session_, "custom"));
      session_.save(file_);
      setC_file(file_.getC_file());
      C_Tbl_Oper_Manager.insert_object_his_for_ins(session_, "c_file", file_.getC_file(), file_.toString(), c_usr_);
      hibernate_funcs.commitAndClose(session_);
    } catch (Exception e) {
      CustomLogger.error(e);
      hibernate_funcs.rollbackAndClose(session_);
      throw e;
    }
  }

  public void removeId() {
    setC_file(null);
  }
}
