package controllers;

import beans.CUsrBean;
import beans.VariablesBean;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import managers.core.dbtables.C_Usr_Manager;
import others.CustomLogger;

@ManagedBean
@SessionScoped
public class chooseBeginAndEndDatetimeController implements Serializable {

  private Date begin_dt;
  private Date end_dt;
  private String period_type = "day";
  private Date day;
  private Integer week_year;
  private Integer week_num;
  private Integer month_year;
  private Integer month_num;

  @PostConstruct
  public void postConstruct() {
    refresh();
  }

  public Date getBegin_dt() {
    if (begin_dt == null) {
      begin_dt = C_Usr_Manager.getCI().getLoggedUsrCorrectedNow(CUsrBean.getCurrentBean().getLoggedCUsr());
    }
    return begin_dt;
  }

  public void setBegin_dt(Date begin_dt) {
    this.begin_dt = begin_dt;
  }

  public Date getEnd_dt() {
    if (end_dt == null) {
      end_dt = C_Usr_Manager.getCI().getLoggedUsrCorrectedNow(CUsrBean.getCurrentBean().getLoggedCUsr());
    }
    return end_dt;
  }

  public void setEnd_dt(Date end_dt) {
    this.end_dt = end_dt;
  }

  public String getPeriod_type() {
    if (period_type == null) {
      period_type = "day";
    }
    return period_type;
  }

  public void setPeriod_type(String period_type) {
    this.period_type = period_type;
  }

  public Date getDay() {
    if (day == null) {
      resetDay();
    }
    return day;
  }

  public void setDay(Date day) {
    this.day = day;
  }

  public Integer getWeek_year() {
    if (week_year == null) {
      resetWeek();
    }
    return week_year;
  }

  public void setWeek_year(Integer week_year) {
    this.week_year = week_year;
  }

  public Integer getWeek_num() {
    if (week_num == null) {
      resetWeek();
    }
    return week_num;
  }

  public void setWeek_num(Integer week_num) {
    this.week_num = week_num;
  }

  public Integer getMonth_year() {
    if (month_year == null) {
      Calendar cal = Calendar.getInstance();
      cal.setTime(C_Usr_Manager.getCI().getLoggedUsrCorrectedNow(CUsrBean.getCurrentBean().getLoggedCUsr()));
      month_year = cal.get(Calendar.YEAR);
    }
    return month_year;
  }

  public void setMonth_year(Integer month_year) {
    if (month_year == null) {
      resetMonth();
    }
    this.month_year = month_year;
  }

  public Integer getMonth_num() {
    if (month_num == null) {
      resetMonth();
    }
    return month_num;
  }

  public void setMonth_num(Integer month_num) {
    this.month_num = month_num;
  }

  public void resetDay() {
    setDay(C_Usr_Manager.getCI().getLoggedUsrCorrectedNow(CUsrBean.getCurrentBean().getLoggedCUsr()));
    refresh();
  }

  public void nextDay() {
    Calendar cal1 = Calendar.getInstance();
    cal1.setTime(getDay());
    cal1.add(Calendar.DATE, 1);

    setDay(cal1.getTime());
    refresh();
  }

  public void previousDay() {
    Calendar cal1 = Calendar.getInstance();
    cal1.setTime(getDay());
    cal1.add(Calendar.DATE, -1);

    setDay(cal1.getTime());
    refresh();
  }

  public void resetWeek() {
    Calendar cal1 = Calendar.getInstance();
    cal1.setTime(C_Usr_Manager.getCI().getLoggedUsrCorrectedNow(CUsrBean.getCurrentBean().getLoggedCUsr()));
    setWeek_year(cal1.get(Calendar.YEAR));

    Calendar cal = Calendar.getInstance();
    cal.setTime(C_Usr_Manager.getCI().getLoggedUsrCorrectedNow(CUsrBean.getCurrentBean().getLoggedCUsr()));
    setWeek_num(cal.get(Calendar.WEEK_OF_YEAR));

    refresh();
  }

  public void resetMonth() {
    Calendar cal1 = Calendar.getInstance();
    cal1.setTime(C_Usr_Manager.getCI().getLoggedUsrCorrectedNow(CUsrBean.getCurrentBean().getLoggedCUsr()));
    setMonth_year(cal1.get(Calendar.YEAR));

    Calendar cal = Calendar.getInstance();
    cal.setTime(C_Usr_Manager.getCI().getLoggedUsrCorrectedNow(CUsrBean.getCurrentBean().getLoggedCUsr()));
    setMonth_num(cal.get(Calendar.MONTH));

    refresh();
  }

  public void refresh() {
    CustomLogger.log("chooseBeginAndEndDatetimeController.refresh();");
    CustomLogger.log(getPeriod_type());
    Date new_date_ = null;
    /*
    if (VariablesBean.getCI().getIs_test_mode()) {
      //begin_dt = new java.util.Date(115, 5, 6, 0, 0, 0);
      //end_dt = new java.util.Date(115, 5, 6, 1, 59, 59);
      return;
    }
     */
    if (getPeriod_type().equals("day")) {
      begin_dt = new Date(getDay().getYear(), getDay().getMonth(), getDay().getDate(), 0, 0, 0);
      end_dt = new Date(getDay().getYear(), getDay().getMonth(), getDay().getDate(), 23, 59, 59);
    } else if (getPeriod_type().equals("week")) {
      Calendar cal = Calendar.getInstance();
      cal.clear();
      cal.set(Calendar.WEEK_OF_YEAR, getWeek_num());
      cal.set(Calendar.YEAR, getWeek_year());
      begin_dt = cal.getTime();
      cal.add(Calendar.DATE, 6);
      new_date_ = cal.getTime();
      end_dt = new Date(new_date_.getYear(), new_date_.getMonth(), new_date_.getDate(), 23, 59, 59);
    } else if (getPeriod_type().equals("month")) {
      Calendar cal = Calendar.getInstance();
      cal.clear();
      cal.set(Calendar.MONTH, getMonth_num());
      cal.set(Calendar.YEAR, getMonth_year());
      begin_dt = cal.getTime();

      //new_date_ = cal.getTime();
      end_dt = new Date(begin_dt.getYear(), begin_dt.getMonth(), cal.getActualMaximum(Calendar.DAY_OF_MONTH), 23, 59, 59);
    }
  }
}
