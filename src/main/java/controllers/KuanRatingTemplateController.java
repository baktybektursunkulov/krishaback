package controllers;

import gs.common.jsf.jsf_funcs;
import gs.common.other_funcs;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class KuanRatingTemplateController implements Serializable {

  private Integer rating_in_percent;
  private Boolean is_show_rating = false;
  private Double rating = null;

  public Integer getRating_in_percent() {
    return rating_in_percent;
  }

  public void setRating_in_percent(Integer rating_in_percent) {
    this.rating_in_percent = rating_in_percent;
  }

  public Boolean getIs_show_rating() {
    return is_show_rating;
  }

  public void setIs_show_rating(Boolean is_show_rating) {
    this.is_show_rating = is_show_rating;
  }

  public Double getRating() {
    return rating;
  }

  public void setRating(Double rating) {
    this.rating = rating;
  }

  public static KuanRatingTemplateController getCurrentBean() {
    return jsf_funcs.findBean(other_funcs.getBeanName(KuanRatingTemplateController.class));
  }

  public KuanRatingTemplateController(Integer rating_in_percent) {
    this.rating_in_percent = rating_in_percent;
  }

  public KuanRatingTemplateController(Integer rating_in_percent, Boolean is_show_rating, Double rating) {
    this.rating_in_percent = rating_in_percent;
    this.is_show_rating = is_show_rating;
    this.rating = rating;
  }
}
