package model.core.dbtables;

import beans.LocaleBean;
import gs.common.hibernate_funcs;
import gs.common.jsf.bundle_funcs;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.*;
import org.hibernate.annotations.Proxy;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import gs.common.model.db.Abstract_Entity;
import java.util.List;
import managers.core.dbtables.*;
import model.core.dbutil.CoreSessionFactoryUtil;
import org.hibernate.Session;
import others.CustomLogger;

@Entity
@Table(name = "c_usr_review")
@Proxy(lazy = false)
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)

public class C_Usr_Review extends Abstract_Entity {

  //fields
  private Integer c_usr_review;
  private Long c_usr;
  private Integer c_tbl;
  private Long rec_id;
  private String name;
  private String title;
  private String comments;
  private Integer rating;
  private Date ins_dt;
  private Integer helpful_cnt;
  private String advantages;
  private String disadvantages;
  private Integer c_lang;
  private Boolean is_deleted;
  private Integer total_helpful_cnt;
  private Double helpful_percent;
  private Boolean is_anonymous;
  private Integer ref_id;
  private Boolean is_published;
  private Date publish_dt;

  //transient fields
  private C_Usr c_usr_t = null;
  private C_Tbl c_tbl_t = null;
  private C_Lang c_lang_t = null;
  private String comments_translation;
  private String advantages_translation;
  private String disadvantages_translation;
  private String calc_review_in_html;
  private String calc_review_translation_in_html;
  private String calc_helpful_translation;
  private C_Usr_Review_Helpful c_usr_review_helpful;
  private C_Usr_Review ref_id_t = null;
  private List<C_Usr_Review_Img> c_usr_review_img_list;
  private Integer active_c_usr_review_img_index;
  private C_Usr_Review_Answer first_c_usr_review_answer;
  private C_Usr_Review_Addition first_c_usr_review_addition;

  public C_Usr_Review() {

  }

  //fields getter and setter methods
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "c_usr_review", unique = true, nullable = false)
  public Integer getC_usr_review() {
    return this.c_usr_review;
  }

  public void setC_usr_review(Integer c_usr_review) {
    this.c_usr_review = c_usr_review;
  }

  @Column(name = "c_usr", nullable = false)
  public Long getC_usr() {
    return this.c_usr;
  }

  public void setC_usr(Long c_usr) {
    this.c_usr = c_usr;
  }

  @Column(name = "c_tbl", nullable = false)
  public Integer getC_tbl() {
    return this.c_tbl;
  }

  public void setC_tbl(Integer c_tbl) {
    this.c_tbl = c_tbl;
  }

  @Column(name = "rec_id", nullable = false)
  public Long getRec_id() {
    return this.rec_id;
  }

  public void setRec_id(Long rec_id) {
    this.rec_id = rec_id;
  }

  
  @Column(name = "name", nullable = true)
  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  
  @Column(name = "title", nullable = true)
  public String getTitle() {
    return this.title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  
  @Column(name = "comments", nullable = true)
  public String getComments() {
    return this.comments;
  }

  public void setComments(String comments) {
    this.comments = comments;
  }

  @Column(name = "rating", nullable = false)
  public Integer getRating() {
    return this.rating;
  }

  public void setRating(Integer rating) {
    this.rating = rating;
  }

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "ins_dt", nullable = false, length = 19, columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
  public Date getIns_dt() {
    return this.ins_dt;
  }

  public void setIns_dt(Date ins_dt) {
    this.ins_dt = ins_dt;
  }

  @Column(name = "helpful_cnt", nullable = false)
  public Integer getHelpful_cnt() {
    return this.helpful_cnt;
  }

  public void setHelpful_cnt(Integer helpful_cnt) {
    this.helpful_cnt = helpful_cnt;
  }

  
  @Column(name = "advantages")
  public String getAdvantages() {
    return this.advantages;
  }

  public void setAdvantages(String advantages) {
    this.advantages = advantages;
  }

  
  @Column(name = "disadvantages")
  public String getDisadvantages() {
    return this.disadvantages;
  }

  public void setDisadvantages(String disadvantages) {
    this.disadvantages = disadvantages;
  }

  @Column(name = "c_lang", nullable = false)
  public Integer getC_lang() {
    return this.c_lang;
  }

  public void setC_lang(Integer c_lang) {
    this.c_lang = c_lang;
  }

  @Column(name = "is_deleted", nullable = false)
  public Boolean getIs_deleted() {
    return this.is_deleted;
  }

  public void setIs_deleted(Boolean is_deleted) {
    this.is_deleted = is_deleted;
  }

  @Column(name = "total_helpful_cnt", nullable = false)
  public Integer getTotal_helpful_cnt() {
    return this.total_helpful_cnt;
  }

  public void setTotal_helpful_cnt(Integer total_helpful_cnt) {
    this.total_helpful_cnt = total_helpful_cnt;
  }

  @Column(name = "helpful_percent", nullable = false)
  public Double getHelpful_percent() {
    return this.helpful_percent;
  }

  public void setHelpful_percent(Double helpful_percent) {
    this.helpful_percent = helpful_percent;
  }

  @Column(name = "is_anonymous", nullable = false)
  public Boolean getIs_anonymous() {
    return this.is_anonymous;
  }

  public void setIs_anonymous(Boolean is_anonymous) {
    this.is_anonymous = is_anonymous;
  }

  @Column(name = "ref_id")
  public Integer getRef_id() {
    return this.ref_id;
  }

  public void setRef_id(Integer ref_id) {
    this.ref_id = ref_id;
  }

  @Column(name = "is_published", nullable = false)
  public Boolean getIs_published() {
    return this.is_published;
  }

  public void setIs_published(Boolean is_published) {
    this.is_published = is_published;
  }

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "publish_dt", length = 19, columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
  public Date getPublish_dt() {
    return this.publish_dt;
  }

  public void setPublish_dt(Date publish_dt) {
    this.publish_dt = publish_dt;
  }

  @Transient
  public C_Usr getC_usr_t() {
    if (this.c_usr_t == null && this.getC_usr() != null) {
      this.c_usr_t = C_Usr_Manager.getCI().get_rec(this.getC_usr());
    }
    return this.c_usr_t;
  }

  @Transient
  public C_Usr getC_usr_t_2(Session session_) {
    if (this.c_usr_t == null && this.getC_usr() != null) {
      this.c_usr_t = C_Usr_Manager.getCI().get_rec(session_, this.getC_usr());
    }
    return this.c_usr_t;
  }

  public void setC_usr_t(C_Usr c_usr_t) {
    this.c_usr_t = c_usr_t;
    this.c_usr = (this.c_usr_t != null ? this.c_usr_t.getC_usr() : null);
  }

  @Transient
  public C_Tbl getC_tbl_t() {
    if (this.c_tbl_t == null && this.getC_tbl() != null) {
      this.c_tbl_t = C_Tbl_Manager.getCI().get_rec(this.getC_tbl());
    }
    return this.c_tbl_t;
  }

  @Transient
  public C_Tbl getC_tbl_t_2(Session session_) {
    if (this.c_tbl_t == null && this.getC_tbl() != null) {
      this.c_tbl_t = C_Tbl_Manager.getCI().get_rec(session_, this.getC_tbl());
    }
    return this.c_tbl_t;
  }

  public void setC_tbl_t(C_Tbl c_tbl_t) {
    this.c_tbl_t = c_tbl_t;
    this.c_tbl = (this.c_tbl_t != null ? this.c_tbl_t.getC_tbl() : null);
  }

  @Transient
  public C_Lang getC_lang_t() {
    if (this.c_lang_t == null && this.getC_lang() != null) {
      this.c_lang_t = C_Lang_Manager.getCI().get_rec(this.getC_lang());
    }
    return this.c_lang_t;
  }

  @Transient
  public C_Lang getC_lang_t_2(Session session_) {
    if (this.c_lang_t == null && this.getC_lang() != null) {
      this.c_lang_t = C_Lang_Manager.getCI().get_rec(session_, this.getC_lang());
    }
    return this.c_lang_t;
  }

  public void setC_lang_t(C_Lang c_lang_t) {
    this.c_lang_t = c_lang_t;
    this.c_lang = (this.c_lang_t != null ? this.c_lang_t.getC_lang() : null);
  }

  @Transient
  public String getComments_translation() {
    if (comments_translation == null) {
      Session session_ = CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
      try {
        session_.beginTransaction();
        comments_translation = getComments_translation_3(session_, LocaleBean.getCurrentBean().getLanguageTag());
        hibernate_funcs.commitAndClose(session_);
      } catch (Exception e) {
        CustomLogger.error(e);
        hibernate_funcs.rollbackAndClose(session_);
        throw e;
      }
    }
    return comments_translation;
  }

  public String getComments_translation_2(Session session_) {
    return getComments_translation_3(session_, LocaleBean.getCurrentBean().getLanguageTag());
  }

  public String getComments_translation_3(Session session_, String lang_) {
    if (comments_translation == null) {
      if (lang_.equals(getC_lang_t_2(session_).getCode())) {
        comments_translation = getComments();
      } else {
        comments_translation = I_Tbl_Fld_Trans_Multi_Manager.multi_get_tbl_fld_translation(session_, this.getClass().getSimpleName(), (Integer) getEntity_id(), "comments", lang_, getComments(), getC_lang_t_2(session_).getCode());
      }
    }
    return comments_translation;
  }

  @Transient
  public String getAdvantages_translation() {
    if (advantages_translation == null) {
      Session session_ = CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
      try {
        session_.beginTransaction();
        advantages_translation = getAdvantages_translation_3(session_, LocaleBean.getCurrentBean().getLanguageTag());
        hibernate_funcs.commitAndClose(session_);
      } catch (Exception e) {
        CustomLogger.error(e);
        hibernate_funcs.rollbackAndClose(session_);
        throw e;
      }
    }
    return advantages_translation;
  }

  public String getAdvantages_translation_2(Session session_) {
    return getAdvantages_translation_3(session_, LocaleBean.getCurrentBean().getLanguageTag());
  }

  public String getAdvantages_translation_3(Session session_, String lang_) {
    if (advantages_translation == null) {
      if (lang_.equals(getC_lang_t_2(session_).getCode())) {
        advantages_translation = getAdvantages();
      } else {
        advantages_translation = I_Tbl_Fld_Trans_Multi_Manager.multi_get_tbl_fld_translation(session_, this.getClass().getSimpleName(), (Integer) getEntity_id(), "advantages", lang_, getAdvantages(), getC_lang_t_2(session_).getCode());
      }
    }
    return advantages_translation;
  }

  @Transient
  public String getDisadvantages_translation() {
    if (disadvantages_translation == null) {
      Session session_ = CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
      try {
        session_.beginTransaction();
        disadvantages_translation = getDisadvantages_translation_3(session_, LocaleBean.getCurrentBean().getLanguageTag());
        hibernate_funcs.commitAndClose(session_);
      } catch (Exception e) {
        CustomLogger.error(e);
        hibernate_funcs.rollbackAndClose(session_);
        throw e;
      }
    }
    return disadvantages_translation;
  }

  public String getDisadvantages_translation_2(Session session_) {
    return getDisadvantages_translation_3(session_, LocaleBean.getCurrentBean().getLanguageTag());
  }

  public String getDisadvantages_translation_3(Session session_, String lang_) {
    if (disadvantages_translation == null) {
      if (lang_.equals(getC_lang_t_2(session_).getCode())) {
        disadvantages_translation = getDisadvantages();
      } else {
        disadvantages_translation = I_Tbl_Fld_Trans_Multi_Manager.multi_get_tbl_fld_translation(session_, this.getClass().getSimpleName(), (Integer) getEntity_id(), "disadvantages", lang_, getDisadvantages(), getC_lang_t_2(session_).getCode());
      }
    }
    return disadvantages_translation;
  }

  @Transient
  public String getCalc_review_in_html() {
    if (calc_review_in_html == null) {
      calc_review_in_html = "";
      if (getAdvantages() != null && !getAdvantages().trim().isEmpty()) {
        calc_review_in_html = calc_review_in_html + "<b>" + bundle_funcs.getBundleValue("Dostoinstva") + ":</b> " + getAdvantages() + "<br/>";
      }
      if (getDisadvantages() != null && !getDisadvantages().trim().isEmpty()) {
        calc_review_in_html = calc_review_in_html + "<b>" + bundle_funcs.getBundleValue("Nedostatki") + ":</b> " + getDisadvantages() + "<br/>";
      }
      if (getComments() != null && !getComments().trim().isEmpty()) {
        calc_review_in_html = calc_review_in_html + "<b>" + bundle_funcs.getBundleValue("Kommentariy") + ":</b> " + getComments() + "<br/>";
      }
    }
    return calc_review_in_html;
  }

  public void setCalc_review_in_html(String calc_review_in_html) {
    this.calc_review_in_html = calc_review_in_html;
  }

  @Transient
  public String getCalc_review_translation_in_html() {
    if (calc_review_translation_in_html == null) {
      Session session_ = CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
      try {
        session_.beginTransaction();
        calc_review_translation_in_html = getCalc_review_translation_in_html_3(session_, LocaleBean.getCurrentBean().getLanguageTag());
        hibernate_funcs.commitAndClose(session_);
      } catch (Exception e) {
        CustomLogger.error(e);
        hibernate_funcs.rollbackAndClose(session_);
        throw e;
      }
    }
    return calc_review_translation_in_html;
  }

  public String getCalc_review_translation_in_html_2(Session session_) {
    return getCalc_review_translation_in_html_3(session_, LocaleBean.getCurrentBean().getLanguageTag());
  }

  public String getCalc_review_translation_in_html_3(Session session_, String lang_) {
    if (calc_review_translation_in_html == null) {
      calc_review_translation_in_html = "";
      if (getAdvantages_translation_3(session_, lang_) != null && !getAdvantages_translation_3(session_, lang_).trim().isEmpty()) {
        calc_review_translation_in_html = calc_review_translation_in_html + "<b>" + bundle_funcs.getBundleValue("Dostoinstva") + ":</b> " + getAdvantages_translation_3(session_, lang_) + "<br/>";
      }
      if (getDisadvantages_translation_3(session_, lang_) != null && !getDisadvantages_translation_3(session_, lang_).trim().isEmpty()) {
        calc_review_translation_in_html = calc_review_translation_in_html + "<b>" + bundle_funcs.getBundleValue("Nedostatki") + ":</b> " + getDisadvantages_translation_3(session_, lang_) + "<br/>";
      }
      if (getComments_translation_3(session_, lang_) != null && !getComments_translation_3(session_, lang_).trim().isEmpty()) {
        calc_review_translation_in_html = calc_review_translation_in_html + "<b>" + bundle_funcs.getBundleValue("Kommentariy") + ":</b> " + getComments_translation_3(session_, lang_) + "<br/>";
      }
    }
    return calc_review_translation_in_html;
  }

  @Transient
  public String getCalc_helpful_translation() {
    if (calc_helpful_translation == null) {
      Session session_ = CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
      try {
        session_.beginTransaction();
        calc_helpful_translation = getCalc_helpful_translation_3(session_, LocaleBean.getCurrentBean().getLanguageTag());
        hibernate_funcs.commitAndClose(session_);
      } catch (Exception e) {
        CustomLogger.error(e);
        hibernate_funcs.rollbackAndClose(session_);
        throw e;
      }
    }
    return calc_helpful_translation;
  }

  public String getCalc_helpful_translation_2(Session session_) {
    return getCalc_helpful_translation_3(session_, LocaleBean.getCurrentBean().getLanguageTag());
  }

  public String getCalc_helpful_translation_3(Session session_, String lang_) {
    if (calc_helpful_translation == null) {
      calc_helpful_translation = getHelpful_cnt() + " " + bundle_funcs.getBundleValue("iz") + " " + getTotal_helpful_cnt() + " " + bundle_funcs.getBundleValue("chelovek") + " "
        + bundle_funcs.getBundleValue("poschitali_otzyv_poleznym");
    }
    return calc_helpful_translation;
  }

  public void setCalc_helpful_translation(String calc_helpful_translation) {
    this.calc_helpful_translation = calc_helpful_translation;
  }

  @Transient
  public C_Usr_Review_Helpful getC_usr_review_helpful() {
    return c_usr_review_helpful;
  }

  public void setC_usr_review_helpful(C_Usr_Review_Helpful c_usr_review_helpful) {
    this.c_usr_review_helpful = c_usr_review_helpful;
  }

  @Transient
  public C_Usr_Review getRef_id_t() {
    if (this.ref_id_t == null && this.getRef_id() != null) {
      this.ref_id_t = C_Usr_Review_Manager.getCI().get_rec(this.getRef_id());
    }
    return this.ref_id_t;
  }

  @Transient
  public C_Usr_Review getRef_id_t_2(Session session_) {
    if (this.ref_id_t == null && this.getRef_id() != null) {
      this.ref_id_t = C_Usr_Review_Manager.getCI().get_rec(session_, this.getRef_id());
    }
    return this.ref_id_t;
  }

  public void setRef_id_t(C_Usr_Review ref_id_t) {
    this.ref_id_t = ref_id_t;
    this.ref_id = (this.ref_id_t != null ? this.ref_id_t.getC_usr_review() : null);
  }

  @Transient
  public List<C_Usr_Review_Img> getC_usr_review_img_list() {
    return c_usr_review_img_list;
  }

  public void setC_usr_review_img_list(List<C_Usr_Review_Img> c_usr_review_img_list) {
    this.c_usr_review_img_list = c_usr_review_img_list;
  }

  @Transient
  public Integer getActive_c_usr_review_img_index() {
    return active_c_usr_review_img_index;
  }

  public void setActive_c_usr_review_img_index(Integer active_c_usr_review_img_index) {
    this.active_c_usr_review_img_index = active_c_usr_review_img_index;
  }

  @Transient
  public C_Usr_Review_Answer getFirst_c_usr_review_answer() {
    return first_c_usr_review_answer;
  }

  public void setFirst_c_usr_review_answer(C_Usr_Review_Answer first_c_usr_review_answer) {
    this.first_c_usr_review_answer = first_c_usr_review_answer;
  }

  @Transient
  public C_Usr_Review_Addition getFirst_c_usr_review_addition() {
    return first_c_usr_review_addition;
  }

  public void setFirst_c_usr_review_addition(C_Usr_Review_Addition first_c_usr_review_addition) {
    this.first_c_usr_review_addition = first_c_usr_review_addition;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 89 * hash + Objects.hashCode(this.getC_usr_review());
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
    final C_Usr_Review other = (C_Usr_Review) obj;
    if (!Objects.equals(this.getC_usr_review(), other.getC_usr_review())) {
      return false;
    }
    return true;
  }

  @Transient
  @Override
  public Serializable getEntity_id() {
    return getC_usr_review();
  }

  public void refresh_first_c_usr_review_answer(Session session_) {
    this.setFirst_c_usr_review_answer(C_Usr_Review_Answer_Manager.getCI().get_first_row(session_, this.getC_usr_review()));
  }
  
  public void refresh_first_c_usr_review_addition(Session session_) {
    this.setFirst_c_usr_review_addition(C_Usr_Review_Addition_Manager.getCI().get_first_row(session_, this.getC_usr_review()));
  }
  
}
