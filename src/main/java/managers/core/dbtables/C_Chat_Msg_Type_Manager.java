package managers.core.dbtables;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import model.core.dbtables.*;
import gs.common.managers.My_Abstract_Controller_Manager;
import gs.common.model.db.*;
import org.hibernate.*;
import others.CustomLogger;
import gs.common.hibernate_funcs;
import java.util.*;
import java.text.*;

@ManagedBean
@ApplicationScoped
public class C_Chat_Msg_Type_Manager extends Abstract_Controller_Manager<C_Chat_Msg_Type> {

  private static C_Chat_Msg_Type_Manager currentInstance = null;
  private Integer c_id__text = 1;// Текст
  private Integer c_id__image = 2;// Картинка
  private Integer c_id__audio = 3;// Аудио
  private Integer c_id__video = 4;// Видео
  private Integer c_id__contact_card = 5;// Карточка контакта
  private Integer c_id__geo_position = 6;// Геопозиция

  public static C_Chat_Msg_Type_Manager getCI() {
    if (currentInstance == null) {
      currentInstance = new C_Chat_Msg_Type_Manager();
    }
    return currentInstance;
  }

  public Integer getC_id__text() {
    return c_id__text;
  }

  public void setC_id__text(Integer c_id__text) {
    this.c_id__text = c_id__text;
  }

  public Integer getC_id__image() {
    return c_id__image;
  }

  public void setC_id__image(Integer c_id__image) {
    this.c_id__image = c_id__image;
  }

  public Integer getC_id__audio() {
    return c_id__audio;
  }

  public void setC_id__audio(Integer c_id__audio) {
    this.c_id__audio = c_id__audio;
  }

  public Integer getC_id__video() {
    return c_id__video;
  }

  public void setC_id__video(Integer c_id__video) {
    this.c_id__video = c_id__video;
  }

  public Integer getC_id__contact_card() {
    return c_id__contact_card;
  }

  public void setC_id__contact_card(Integer c_id__contact_card) {
    this.c_id__contact_card = c_id__contact_card;
  }

  public Integer getC_id__geo_position() {
    return c_id__geo_position;
  }

  public void setC_id__geo_position(Integer c_id__geo_position) {
    this.c_id__geo_position = c_id__geo_position;
  }

  public C_Chat_Msg_Type_Manager() {
    super(C_Chat_Msg_Type.class);
  }

}
