package test;

import gs.common.additional_classes.GoogleGeocodeResult;
import gs.common.google_geocode_funcs;

public class test_geocode {

  public static void main(String[] args) {
    GoogleGeocodeResult geocodeResult = google_geocode_funcs.geocode("Нур-Султан(Астана)");
    System.out.println(geocodeResult.getResponse_lat() + ", " + geocodeResult.getResponse_lon());
  }
}
