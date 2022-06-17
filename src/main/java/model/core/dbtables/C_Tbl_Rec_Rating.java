package model.core.dbtables;

import controllers.KuanRatingTemplateController;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.*;
import org.hibernate.annotations.Proxy;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import gs.common.model.db.Abstract_Entity;
import gs.common.other_funcs;
import managers.core.dbtables.*;
import org.hibernate.Session;

@Entity
@Table(name = "c_tbl_rec_rating")
@Proxy(lazy = false)
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)

public class C_Tbl_Rec_Rating extends Abstract_Entity {

  //fields
  private Integer c_tbl_rec_rating;
  private Integer c_tbl;
  private Long rec_id;
  private Integer c_usr_review_kind;
  private Double rating;
  private Boolean is_deleted;
  private Integer review_cnt;
  private Integer star_1_review_cnt;
  private Integer star_2_review_cnt;
  private Integer star_3_review_cnt;
  private Integer star_4_review_cnt;
  private Integer star_5_review_cnt;
  private Integer star_1_review_percent;
  private Integer star_2_review_percent;
  private Integer star_3_review_percent;
  private Integer star_4_review_percent;
  private Integer star_5_review_percent;

  //transient fields
  private C_Tbl c_tbl_t = null;
  private C_Usr_Review_Kind c_usr_review_kind_t = null;
  private KuanRatingTemplateController kuanRatingTemplateController;

  private Integer rating_in_percent;

  public C_Tbl_Rec_Rating() {

  }

  //fields getter and setter methods
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "c_tbl_rec_rating", unique = true, nullable = false)
  public Integer getC_tbl_rec_rating() {
    return this.c_tbl_rec_rating;
  }

  public void setC_tbl_rec_rating(Integer c_tbl_rec_rating) {
    this.c_tbl_rec_rating = c_tbl_rec_rating;
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

  @Column(name = "c_usr_review_kind", nullable = false)
  public Integer getC_usr_review_kind() {
    return this.c_usr_review_kind;
  }

  public void setC_usr_review_kind(Integer c_usr_review_kind) {
    this.c_usr_review_kind = c_usr_review_kind;
  }

  @Column(name = "rating", nullable = true)
  public Double getRating() {
    return this.rating;
  }

  public void setRating(Double rating) {
    this.rating = rating;
  }

  @Column(name = "is_deleted", nullable = false)
  public Boolean getIs_deleted() {
    return this.is_deleted;
  }

  public void setIs_deleted(Boolean is_deleted) {
    this.is_deleted = is_deleted;
  }

  @Column(name = "review_cnt", nullable = false)
  public Integer getReview_cnt() {
    return this.review_cnt;
  }

  public void setReview_cnt(Integer review_cnt) {
    this.review_cnt = review_cnt;
  }

  @Column(name = "star_1_review_cnt", nullable = false)
  public Integer getStar_1_review_cnt() {
    return this.star_1_review_cnt;
  }

  public void setStar_1_review_cnt(Integer star_1_review_cnt) {
    this.star_1_review_cnt = star_1_review_cnt;
  }

  @Column(name = "star_2_review_cnt", nullable = false)
  public Integer getStar_2_review_cnt() {
    return this.star_2_review_cnt;
  }

  public void setStar_2_review_cnt(Integer star_2_review_cnt) {
    this.star_2_review_cnt = star_2_review_cnt;
  }

  @Column(name = "star_3_review_cnt", nullable = false)
  public Integer getStar_3_review_cnt() {
    return this.star_3_review_cnt;
  }

  public void setStar_3_review_cnt(Integer star_3_review_cnt) {
    this.star_3_review_cnt = star_3_review_cnt;
  }

  @Column(name = "star_4_review_cnt", nullable = false)
  public Integer getStar_4_review_cnt() {
    return this.star_4_review_cnt;
  }

  public void setStar_4_review_cnt(Integer star_4_review_cnt) {
    this.star_4_review_cnt = star_4_review_cnt;
  }

  @Column(name = "star_5_review_cnt", nullable = false)
  public Integer getStar_5_review_cnt() {
    return this.star_5_review_cnt;
  }

  public void setStar_5_review_cnt(Integer star_5_review_cnt) {
    this.star_5_review_cnt = star_5_review_cnt;
  }

  @Column(name = "star_1_review_percent", nullable = false)
  public Integer getStar_1_review_percent() {
    return this.star_1_review_percent;
  }

  public void setStar_1_review_percent(Integer star_1_review_percent) {
    this.star_1_review_percent = star_1_review_percent;
  }

  @Column(name = "star_2_review_percent", nullable = false)
  public Integer getStar_2_review_percent() {
    return this.star_2_review_percent;
  }

  public void setStar_2_review_percent(Integer star_2_review_percent) {
    this.star_2_review_percent = star_2_review_percent;
  }

  @Column(name = "star_3_review_percent", nullable = false)
  public Integer getStar_3_review_percent() {
    return this.star_3_review_percent;
  }

  public void setStar_3_review_percent(Integer star_3_review_percent) {
    this.star_3_review_percent = star_3_review_percent;
  }

  @Column(name = "star_4_review_percent", nullable = false)
  public Integer getStar_4_review_percent() {
    return this.star_4_review_percent;
  }

  public void setStar_4_review_percent(Integer star_4_review_percent) {
    this.star_4_review_percent = star_4_review_percent;
  }

  @Column(name = "star_5_review_percent", nullable = false)
  public Integer getStar_5_review_percent() {
    return this.star_5_review_percent;
  }

  public void setStar_5_review_percent(Integer star_5_review_percent) {
    this.star_5_review_percent = star_5_review_percent;
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
  public C_Usr_Review_Kind getC_usr_review_kind_t() {
    if (this.c_usr_review_kind_t == null && this.getC_usr_review_kind() != null) {
      this.c_usr_review_kind_t = C_Usr_Review_Kind_Manager.getCI().get_rec(this.getC_usr_review_kind());
    }
    return this.c_usr_review_kind_t;
  }

  @Transient
  public C_Usr_Review_Kind getC_usr_review_kind_t_2(Session session_) {
    if (this.c_usr_review_kind_t == null && this.getC_usr_review_kind() != null) {
      this.c_usr_review_kind_t = C_Usr_Review_Kind_Manager.getCI().get_rec(session_, this.getC_usr_review_kind());
    }
    return this.c_usr_review_kind_t;
  }

  public void setC_usr_review_kind_t(C_Usr_Review_Kind c_usr_review_kind_t) {
    this.c_usr_review_kind_t = c_usr_review_kind_t;
    this.c_usr_review_kind = (this.c_usr_review_kind_t != null ? this.c_usr_review_kind_t.getC_usr_review_kind() : null);
  }

  @Transient
  public KuanRatingTemplateController getKuanRatingTemplateController() {
    if (kuanRatingTemplateController == null) {
      kuanRatingTemplateController = new KuanRatingTemplateController(getRating_in_percent(), true, getRatingWithDecimalPlaces(1));
    }
    return kuanRatingTemplateController;
  }

  public void setKuanRatingTemplateController(KuanRatingTemplateController kuanRatingTemplateController) {
    this.kuanRatingTemplateController = kuanRatingTemplateController;
  }

  @Transient
  public Double getRatingWithDecimalPlaces(int decimal_places_) {
    if (rating == null) {
      return null;
    }
    return other_funcs.round(rating, decimal_places_);
  }

  @Transient
  public Integer getRating_in_percent() {
    if (rating_in_percent == null) {
      if (rating == null) {
        rating_in_percent = null;
      } else {
        rating_in_percent = other_funcs.roundToIntV2(rating / 5.0 * 100.0);
      }
    }
    return rating_in_percent;
  }

  public void setRating_in_percent(Integer rating_in_percent) {
    this.rating_in_percent = rating_in_percent;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 89 * hash + Objects.hashCode(this.getC_tbl_rec_rating());
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
    final C_Tbl_Rec_Rating other = (C_Tbl_Rec_Rating) obj;
    if (!Objects.equals(this.getC_tbl_rec_rating(), other.getC_tbl_rec_rating())) {
      return false;
    }
    return true;
  }

  @Transient
  @Override
  public Serializable getEntity_id() {
    return getC_tbl_rec_rating();
  }

}
