package additional_classes;

import extras.I18NControl;
import gs.common.Consts;
import gs.common.date_time_funcs;
import gs.common.jsf.bundle_funcs;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.sql.Time;
import java.text.ParseException;
import java.util.Locale;
import java.util.ResourceBundle;
import others.core_custom_funcs;

public class Shift_Interval implements Serializable {

  String name;
  Date begin_dt;
  Date end_dt;

  public Shift_Interval() {

  }

  public Shift_Interval(String name, Date begin_dt, Date end_dt) {
    this.name = name;
    this.begin_dt = begin_dt;
    this.end_dt = end_dt;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Date getBegin_dt() {
    return begin_dt;
  }

  public void setBegin_dt(Date begin_dt) {
    this.begin_dt = begin_dt;
  }

  public Date getEnd_dt() {
    return end_dt;
  }

  public void setEnd_dt(Date end_dt) {
    this.end_dt = end_dt;
  }

  @Override
  public String toString() {
    return "Shift_Interval{" + "name=" + name + ", begin_dt=" + begin_dt + ", end_dt=" + end_dt + '}';
  }

  public static List<Shift_Interval> get_shift_interval_list(ResourceBundle bundle_, Date begin_dt_, Date end_dt_, Time shift_begin_time_, Time shift_end_time_, boolean is_add_second_shift_,
    boolean is_include_next_day_for_second_shift_) {
    List<Shift_Interval> res = new ArrayList();

    Time new_shift_begin_time_ = shift_begin_time_;
    if (new_shift_begin_time_ == null) {
      new_shift_begin_time_ = new Time(0, 0, 0);
    }
    Time new_shift_end_time_ = shift_end_time_;
    if (new_shift_end_time_ == null) {
      new_shift_end_time_ = new Time(23, 59, 59);
    }

    Date new_begin_dt_ = begin_dt_;
    Date new_end_dt_ = end_dt_;
    Date new_begin_dt_2_;
    Date new_end_dt_2_;
    while (new_begin_dt_.before(end_dt_)) {
      new_end_dt_ = date_time_funcs.get_end_of_the_day(new_begin_dt_);
      if (new_end_dt_.after(end_dt_)) {
        new_end_dt_ = end_dt_;
      }

      new_begin_dt_2_ = new Date(new_begin_dt_.getTime());
      new_end_dt_2_ = new Date(new_end_dt_.getTime());
      if (core_custom_funcs.get_time(new_begin_dt_2_).before(new_shift_begin_time_)) {
        new_begin_dt_2_ = date_time_funcs.get_time_from_date(new_begin_dt_2_, new_shift_begin_time_);
      }
      if (core_custom_funcs.get_time(new_end_dt_2_).after(new_shift_end_time_)) {
        new_end_dt_2_ = date_time_funcs.get_time_from_date(new_end_dt_2_, new_shift_end_time_);
      }

      res.add(new Shift_Interval(bundle_funcs.getBundleValue(bundle_, "Smena") + " 1", new_begin_dt_2_, new_end_dt_2_));
      if (is_add_second_shift_) {
        if (is_include_next_day_for_second_shift_) {
          Date temp_end_dt_ = date_time_funcs.add_seconds(date_time_funcs.add_day(new_begin_dt_2_, 1), -1);
          res.add(new Shift_Interval(bundle_funcs.getBundleValue(bundle_, "Smena") + " 2", date_time_funcs.add_seconds(new_end_dt_2_, 1), temp_end_dt_));
        }
      }

      new_begin_dt_ = date_time_funcs.add_seconds(new_end_dt_, 1);
    }
 
    return res;
  }

  public static void main(String[] params) throws ParseException {
    ResourceBundle rb_ = ResourceBundle.getBundle("bundle", new Locale("ru"), new I18NControl());
    List<Shift_Interval> shift_interval_list_ = get_shift_interval_list(rb_, Consts.sdfddMMyyyyHHmmss().parse("20.06.2019 09:00:00"),
      Consts.sdfddMMyyyyHHmmss().parse("23.06.2019 15:00:00"),
      core_custom_funcs.get_time(Consts.sdfHHmmss().parse("07:00:00")),
      core_custom_funcs.get_time(Consts.sdfHHmmss().parse("19:00:00")), true, true);
    for (Shift_Interval shift_Interval : shift_interval_list_) {
      System.out.println(shift_Interval);
    }
    //System.err.println(shift_interval_list_);
  }
}
