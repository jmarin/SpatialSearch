package org.geo.spatialsearch.util;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;


public final class GeometryUtil {

    public static Point getPoint(double longitude, double latitude, int srid) {
        GeometryFactory geometryFactory = new GeometryFactory();
        Coordinate coordinate = new Coordinate();
        coordinate.x = longitude;
        coordinate.y = latitude;
        Point point = geometryFactory.createPoint(coordinate);
        point.setSRID(srid);
        return point;
    }
}
