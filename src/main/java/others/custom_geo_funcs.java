package others;

import com.vividsolutions.jts.geom.*;
import com.vividsolutions.jts.util.GeometricShapeFactory;
import gs.common.gis.gis_funcs;

public class custom_geo_funcs {

  private static GeometryFactory WGS84GeometryFactory = null;

  public static GeometryFactory getWGS84GeometryFactory() {
    if (WGS84GeometryFactory == null) {
      WGS84GeometryFactory = new GeometryFactory(new PrecisionModel(PrecisionModel.FIXED), 4326 /* WGS84 */);
    }
    return WGS84GeometryFactory;
  }

  public static boolean isPointInPolygon(Point point_, Polygon polygon_) {
    return polygon_.contains(point_);
  }

  public static boolean isPointInPolygon(Point point_, Coordinate[] polygon_coordinate_arr_) {
    Polygon polygon = createPolygon(polygon_coordinate_arr_);
    return polygon.contains(point_);
  }

  public static boolean isPointInCircle(Point point_, Geometry geometry_) {
    return geometry_.contains(point_);
  }

  public static boolean isPointInCircle(double circle_center_lat_, double circle_center_lon_, double circle_radius_in_m_, double lat_, double lon_) {
    double d_ = gis_funcs.distance_in_meters(circle_center_lat_, circle_center_lon_, lat_, lon_);
    return d_ < circle_radius_in_m_;
  }

  public static boolean isPointInGeometry(Point point_, Geometry geometry_) {
    return geometry_.contains(point_);
  }

  public static Point createPoint(double x, double y) {
    return getWGS84GeometryFactory().createPoint(new Coordinate(x, y));
  }

  public static Geometry createCircle(double x, double y, final double radius_in_degrees_) {
    //GeometryFactory geometryFactory = getGeometryFactory();
    GeometricShapeFactory shapeFactory = new GeometricShapeFactory(getWGS84GeometryFactory());
    final int SIDES = 32 + 16 * ((int) Math.ceil(radius_in_degrees_ / 40) / 5);
    shapeFactory.setNumPoints(SIDES);
    shapeFactory.setCentre(new Coordinate(x, y));
    shapeFactory.setSize(radius_in_degrees_ * 2);
    return shapeFactory.createCircle();
  }

  public static Polygon createPolygon(Coordinate[] coordinate_arr_) {
    //GeometryFactory geometryFactory = getGeometryFactory();
    return getWGS84GeometryFactory().createPolygon(coordinate_arr_);
  }

  /*
  private static Geometry create3DCircle(double lng, double lat, double radiusNm) {
    GeodeticCalculator calc = new GeodeticCalculator(DefaultEllipsoid.WGS84);
    calc.setStartingGeographicPoint(lng, lat);
    final int SIDES = 32 + 16 * ((int) Math.ceil(radiusNm / 40) / 5);       // Fairly random.

    double distance = radiusNm * 1852;              // Convert to metres.
    double baseAzimuth = 360.0 / SIDES;
    Coordinate coords[] = new Coordinate[SIDES + 1];
    for (int i = 0; i < SIDES; i++) {
      double azimuth = 180 - (i * baseAzimuth);
      calc.setDirection(azimuth, distance);
      Point2D point = calc.getDestinationGeographicPoint();
      coords[i] = new Coordinate(point.getX(), point.getY());
    }
    coords[SIDES] = coords[0];

    LinearRing ring = GEOMETRY_FACTORY.createLinearRing(coords);
    Polygon polygon = GEOMETRY_FACTORY.createPolygon(ring, null);

    return polygon;
  }
   */
 /*
  public static Polygon createCircle(Point point, double radius_in_meters_) {
    GeodeticCalculator calc = new GeodeticCalculator(DefaultGeographicCRS.WGS84);
    calc.setStartingGeographicPoint(point.getX(), point.getY());
    calc.setDirection(0.0, radius_in_meters_);
    Point2D p2 = calc.getDestinationGeographicPoint();
    calc.setDirection(90.0, radius_in_meters_);
    Point2D p3 = calc.getDestinationGeographicPoint();

    double dy = p2.getY() - point.getY();
    double dx = p3.getX() - point.getX();
    double distance = (dy + dx) / 2.0;
    Polygon p1 = (Polygon) point.buffer(distance);
    return p1;
  }

  public static void test1() throws FactoryException {
    GeodeticCalculator gc = new GeodeticCalculator(DefaultGeographicCRS.WGS84);

  }
   */
}
