package model.core.dbtables;

import gs.common.MyException;
import java.io.ByteArrayInputStream;
import java.io.Serializable;
import gs.common.model.db.Abstract_Entity;
import java.util.Objects;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import javax.persistence.*;
import managers.core.dbtables.C_Img_Converted_By_Max_Wh_Manager;
import managers.core.dbtables.C_Img_Converted_Color_Manager;
import managers.core.dbtables.C_Img_Converted_Manager;
import managers.core.dbtables.C_Img_Manager;
import org.hibernate.Session;
import gs.common.hibernate_funcs;
import gs.common.image.image_funcs;
import gs.common.jsf.bundle_funcs;
import gs.common.jsf.jsf_funcs;
import managers.core.dbtables.C_Bin_File_Body_Manager;
import managers.core.dbtables.C_Tbl_Oper_Manager;
import managers.core.dbtables.File_Type_Manager;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Proxy;
import org.hibernate.annotations.Type;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.file.UploadedFile;
import others.CustomLogger;

@Entity
@Table(name = "c_img")
@Proxy(lazy = false)
@DynamicUpdate
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class C_Img extends Abstract_Entity {

  //fields
  private Long c_img;
  private String file_name;
  private Integer version;
  private Integer width;
  private Integer height;
  private Long size;
  private String content_type;
  private Long c_bin_file_body;
  private Boolean is_deleted;

  // transient fields  
  private C_Bin_File_Body c_bin_file_body_t = null;

  public C_Img() {

  }

  //fields getter and setter methods
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "c_img", unique = true, nullable = false)
  public Long getC_img() {
    return this.c_img;
  }

  public void setC_img(Long img) {
    this.c_img = img;
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

  @Column(name = "width")
  public Integer getWidth() {
    return this.width;
  }

  public void setWidth(Integer width) {
    this.width = width;
  }

  @Column(name = "height")
  public Integer getHeight() {
    return this.height;
  }

  public void setHeight(Integer height) {
    this.height = height;
  }

  @Column(name = "size")
  public Long getSize() {
    return this.size;
  }

  public void setSize(Long size) {
    this.size = size;
  }

  
  @Column(name = "content_type")
  public String getContent_type() {
    return this.content_type;
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

  public void setBin_file_body_t(C_Bin_File_Body bin_file_body_t) {
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

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 89 * hash + Objects.hashCode(this.getC_img());
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
    final C_Img other = (C_Img) obj;
    if (!Objects.equals(this.getC_img(), other.getC_img())) {
      return false;
    }
    return true;
  }

  @Transient
  @Override
  public Serializable getEntity_id() {
    return getC_img();
  }

  @Transient
  public StreamedContent getFile_body_image() {
    //CustomLogger.log("getFile_body_image() getFile_body()=" + getFile_body());
    //StreamedContent res = null;
    FacesContext context = FacesContext.getCurrentInstance();
    if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
      // So, we're rendering the view. Return a stub StreamedContent so that it will generate right URL.
      return new DefaultStreamedContent();
    } else {
      if (getC_bin_file_body_t() == null || getC_bin_file_body_t().getFile_body() == null) {
        return null;
      }
      return new DefaultStreamedContent(new ByteArrayInputStream(getC_bin_file_body_t().getFile_body()), getContent_type());
    }

    /*
    res = DefaultStreamedContent.builder()
      .contentType(getContent_type())
      .stream(() -> {
        try {
          return new ByteArrayInputStream(getBin_file_body_t().getFile_body());
        } catch (Exception e) {
          e.printStackTrace();
          return null;
        }
      })
      .build();
     */
    //CustomLogger.log("res=" + res);
    //return res;
  }

  public void handleFileUpload(FileUploadEvent event) {
    UploadedFile uploadedFile = event.getFile();
    //CustomLogger.log("uploadedFile.getFileName()=" + uploadedFile.getFileName());
    //CustomLogger.log("uploadedFile.getContents()=" + event.getFile().getContents());
    setFile_name(uploadedFile.getFileName());
    if (getC_bin_file_body_t() == null) {
      setBin_file_body_t(new C_Bin_File_Body());
    }
    getC_bin_file_body_t().setFile_body(uploadedFile.getContent());
    setSize(uploadedFile.getSize());
    setContent_type(uploadedFile.getContentType());
    //CustomLogger.log("getFile_body()=" + getFile_body());
  }

  public C_Img getCreatedImg(Session session_) throws Exception {
    if (getC_bin_file_body_t_2(session_) != null && getC_bin_file_body_t_2(session_).getFile_body() != null && getC_bin_file_body_t_2(session_).getFile_body().length > 0) {
      C_Img img_;
      if (getC_img() != null && C_Img_Manager.is_img_exists(session_, getC_img())) {
        img_ = (C_Img) session_.load(C_Img.class, getC_img());
        C_Img_Converted_Manager.delete_img_converted_by_img_id(session_, getC_img());
        C_Img_Converted_Color_Manager.delete_img_converted_color_by_img_id(session_, getC_img());
        C_Img_Converted_By_Max_Wh_Manager.delete_img_converted_max_wh_by_img_id(session_, getC_img());
      } else {
        img_ = new C_Img();
      }

      C_Bin_File_Body bin_file_body_;
      if (img_.getC_bin_file_body() != null) {
        bin_file_body_ = (C_Bin_File_Body) session_.load(C_Bin_File_Body.class, img_.getC_bin_file_body());
        bin_file_body_.setFile_body(getC_bin_file_body_t_2(session_).getFile_body());
        session_.merge(bin_file_body_);
      } else {
        bin_file_body_ = new C_Bin_File_Body();
        bin_file_body_.setFile_body(getC_bin_file_body_t_2(session_).getFile_body());
        session_.save(bin_file_body_);
      }

      img_.setC_bin_file_body(bin_file_body_.getC_bin_file_body());
      img_.setFile_name(getFile_name());
      img_.setWidth(image_funcs.getImageWidth(bin_file_body_.getFile_body()));
      img_.setHeight(image_funcs.getImageHeight(bin_file_body_.getFile_body()));
      img_.setSize(getSize());
      img_.setContent_type(getContent_type());
      if (img_.getVersion() == null) {
        img_.setVersion(1);
      } else {
        img_.setVersion(img_.getVersion() + 1);
      }
      session_.save(img_);

      return img_;
    } else {
      return new C_Img();
    }
  }

  @Override
  public String toString() {
    return "Img{" + "img=" + c_img + ", file_name=" + file_name + ", version=" + version + ", width=" + width + ", height=" + height + ", size=" + size + ", content_type=" + content_type + '}';
  }

  public C_Img updateAndReturnImg(Session session_) throws Exception {
    if (getC_bin_file_body_t_2(session_) != null && getC_bin_file_body_t_2(session_).getFile_body() != null && getC_bin_file_body_t_2(session_).getFile_body().length > 0) {
      C_Img img_;
      if (getC_img() != null) {
        img_ = (C_Img) session_.load(C_Img.class, getC_img());
        C_Img_Converted_Manager.delete_img_converted_by_img_id(session_, getC_img());
        C_Img_Converted_Color_Manager.delete_img_converted_color_by_img_id(session_, getC_img());
        C_Img_Converted_By_Max_Wh_Manager.delete_img_converted_max_wh_by_img_id(session_, getC_img());
      } else {
        img_ = new C_Img();
      }

      C_Bin_File_Body bin_file_body_;
      if (img_.getC_bin_file_body() != null) {
        bin_file_body_ = (C_Bin_File_Body) session_.load(C_Bin_File_Body.class, img_.getC_bin_file_body());
        bin_file_body_.setFile_body(getC_bin_file_body_t_2(session_).getFile_body());
        session_.merge(bin_file_body_);
      } else {
        bin_file_body_ = new C_Bin_File_Body();
        bin_file_body_.setFile_body(getC_bin_file_body_t_2(session_).getFile_body());
        session_.save(bin_file_body_);
      }

      img_.setC_bin_file_body(bin_file_body_.getC_bin_file_body());
      img_.setFile_name(getFile_name());
      img_.setWidth(image_funcs.getImageWidth(bin_file_body_.getFile_body()));
      img_.setHeight(image_funcs.getImageHeight(bin_file_body_.getFile_body()));
      img_.setSize(getSize());
      img_.setContent_type(getContent_type());
      if (img_.getVersion() == null) {
        img_.setVersion(1);
      } else {
        img_.setVersion(img_.getVersion() + 1);
      }
      session_.save(img_);

      return img_;
    } else {
      return null;
    }

  }

  public void removeFilebody() {
    if (getC_bin_file_body_t() != null) {
      getC_bin_file_body_t().setFile_body(null);
    }
  }

  public void handleFileUploadWithSaveToDB(FileUploadEvent event) throws Exception {
    // we should create new file always, because user can replace file and don't save it, then new file will be replaced, it's not correct
    C_Usr c_usr_ = (C_Usr) event.getComponent().getAttributes().get("c_usr");
    UploadedFile uploadedFile = event.getFile();
    if (!image_funcs.isImage(uploadedFile.getContent())) {
      throw new MyException(bundle_funcs.getBundleValue("Fayl_ne_podderzhivayetsya_sistemoy"));
    }
    Session session_ = model.core.dbutil.CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      session_.beginTransaction();
      C_Img img_ = new C_Img();

      C_Bin_File_Body bin_file_body_;
      bin_file_body_ = new C_Bin_File_Body();
      bin_file_body_.setFile_body(uploadedFile.getContent());
      session_.save(bin_file_body_);

      img_.setC_bin_file_body(bin_file_body_.getC_bin_file_body());
      img_.setFile_name(uploadedFile.getFileName());
      img_.setWidth(image_funcs.getImageWidth(bin_file_body_.getFile_body()));
      img_.setHeight(image_funcs.getImageHeight(bin_file_body_.getFile_body()));
      img_.setSize(uploadedFile.getSize());
      img_.setContent_type(uploadedFile.getContentType());
      img_.setVersion(1);
      session_.save(img_);
      setC_img(img_.getC_img());
      C_Tbl_Oper_Manager.insert_object_his_for_ins(session_, "c_img", img_.getC_img(), img_.toString(), c_usr_);
      hibernate_funcs.commitAndClose(session_);
    } catch (Exception e) {
      CustomLogger.error(e);
      hibernate_funcs.rollbackAndClose(session_);
      throw e;
    }
  }

  public void removeId() {
    setC_img(null);
  }

}
