/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package gs.payload.response.horesponse;

import java.io.File;

/**
 *
 * @author User
 */
public class Offer_previewResponse {
  private Integer id;
  private Integer imgUrl;
  private String title;
  private Double price;
  private String cityName;
  private int photoCount;
  private String address;

  public Offer_previewResponse(Integer id, Integer imgUrl, String title, Double price, String cityName, int photoCount, String address) {
    this.id = id;
    this.imgUrl = imgUrl;
    this.title = title;
    this.price = price;
    this.cityName = cityName;
    this.photoCount = photoCount;
    this.address = address;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getimgUrl() {
    return imgUrl;
  }

  public void setimgUrl(Integer file) {
    this.imgUrl = file;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public String getCityName() {
    return cityName;
  }

  public void setCityName(String cityName) {
    this.cityName = cityName;
  }

  public int getPhotoCount() {
    return photoCount;
  }

  public void setPhotoCount(int photoCount) {
    this.photoCount = photoCount;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }
  
}
