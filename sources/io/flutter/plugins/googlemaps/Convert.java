package io.flutter.plugins.googlemaps;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Convert {
    Convert() {
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x001e, code lost:
        if (r2.equals("defaultMarker") != false) goto L_0x0040;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.android.gms.maps.model.BitmapDescriptor toBitmapDescriptor(java.lang.Object r7) {
        /*
            java.util.List r0 = toList(r7)
            r1 = 0
            java.lang.Object r2 = r0.get(r1)
            java.lang.String r2 = toString(r2)
            int r3 = r2.hashCode()
            r4 = 3
            r5 = 2
            r6 = 1
            switch(r3) {
                case -458749035: goto L_0x0035;
                case 52960614: goto L_0x002b;
                case 54063841: goto L_0x0021;
                case 784458203: goto L_0x0018;
                default: goto L_0x0017;
            }
        L_0x0017:
            goto L_0x003f
        L_0x0018:
            java.lang.String r3 = "defaultMarker"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x0017
            goto L_0x0040
        L_0x0021:
            java.lang.String r1 = "fromBytes"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L_0x0017
            r1 = r4
            goto L_0x0040
        L_0x002b:
            java.lang.String r1 = "fromAsset"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L_0x0017
            r1 = r6
            goto L_0x0040
        L_0x0035:
            java.lang.String r1 = "fromAssetImage"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L_0x0017
            r1 = r5
            goto L_0x0040
        L_0x003f:
            r1 = -1
        L_0x0040:
            if (r1 == 0) goto L_0x00ce
            if (r1 == r6) goto L_0x009c
            if (r1 == r5) goto L_0x0069
            if (r1 != r4) goto L_0x004d
            com.google.android.gms.maps.model.BitmapDescriptor r1 = getBitmapFromBytes(r0)
            return r1
        L_0x004d:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Cannot interpret "
            r2.append(r3)
            r2.append(r7)
            java.lang.String r3 = " as BitmapDescriptor"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x0069:
            int r1 = r0.size()
            if (r1 != r4) goto L_0x0081
            java.lang.Object r1 = r0.get(r6)
            java.lang.String r1 = toString(r1)
            java.lang.String r1 = io.flutter.view.FlutterMain.getLookupKeyForAsset(r1)
            com.google.android.gms.maps.model.BitmapDescriptor r1 = com.google.android.gms.maps.model.BitmapDescriptorFactory.fromAsset(r1)
            return r1
        L_0x0081:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "'fromAssetImage' Expected exactly 3 arguments, got: "
            r2.append(r3)
            int r3 = r0.size()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x009c:
            int r1 = r0.size()
            if (r1 != r5) goto L_0x00b4
            java.lang.Object r1 = r0.get(r6)
            java.lang.String r1 = toString(r1)
            java.lang.String r1 = io.flutter.view.FlutterMain.getLookupKeyForAsset(r1)
            com.google.android.gms.maps.model.BitmapDescriptor r1 = com.google.android.gms.maps.model.BitmapDescriptorFactory.fromAsset(r1)
            return r1
        L_0x00b4:
            java.lang.Object r1 = r0.get(r6)
            java.lang.String r1 = toString(r1)
            java.lang.Object r2 = r0.get(r5)
            java.lang.String r2 = toString(r2)
            java.lang.String r1 = io.flutter.view.FlutterMain.getLookupKeyForAsset(r1, r2)
            com.google.android.gms.maps.model.BitmapDescriptor r1 = com.google.android.gms.maps.model.BitmapDescriptorFactory.fromAsset(r1)
            return r1
        L_0x00ce:
            int r1 = r0.size()
            if (r1 != r6) goto L_0x00d9
            com.google.android.gms.maps.model.BitmapDescriptor r1 = com.google.android.gms.maps.model.BitmapDescriptorFactory.defaultMarker()
            return r1
        L_0x00d9:
            java.lang.Object r1 = r0.get(r6)
            float r1 = toFloat(r1)
            com.google.android.gms.maps.model.BitmapDescriptor r1 = com.google.android.gms.maps.model.BitmapDescriptorFactory.defaultMarker(r1)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.plugins.googlemaps.Convert.toBitmapDescriptor(java.lang.Object):com.google.android.gms.maps.model.BitmapDescriptor");
    }

    private static BitmapDescriptor getBitmapFromBytes(List<?> data) {
        if (data.size() == 2) {
            try {
                return BitmapDescriptorFactory.fromBitmap(toBitmap(data.get(1)));
            } catch (Exception e) {
                throw new IllegalArgumentException("Unable to interpret bytes as a valid image.", e);
            }
        } else {
            throw new IllegalArgumentException("fromBytes should have exactly one argument, the bytes. Got: " + data.size());
        }
    }

    private static boolean toBoolean(Object o) {
        return ((Boolean) o).booleanValue();
    }

    static CameraPosition toCameraPosition(Object o) {
        Map<?, ?> data = toMap(o);
        CameraPosition.Builder builder = CameraPosition.builder();
        builder.bearing(toFloat(data.get("bearing")));
        builder.target(toLatLng(data.get("target")));
        builder.tilt(toFloat(data.get("tilt")));
        builder.zoom(toFloat(data.get("zoom")));
        return builder.build();
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0027, code lost:
        if (r2.equals("newCameraPosition") != false) goto L_0x0072;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static com.google.android.gms.maps.CameraUpdate toCameraUpdate(java.lang.Object r6, float r7) {
        /*
            java.util.List r0 = toList(r6)
            r1 = 0
            java.lang.Object r2 = r0.get(r1)
            java.lang.String r2 = toString(r2)
            int r3 = r2.hashCode()
            r4 = 2
            r5 = 1
            switch(r3) {
                case -813625658: goto L_0x0067;
                case -696286326: goto L_0x005d;
                case -696286120: goto L_0x0053;
                case -696285778: goto L_0x0048;
                case -402165756: goto L_0x003e;
                case -145042503: goto L_0x0034;
                case -110027141: goto L_0x002a;
                case 354871598: goto L_0x0021;
                case 1661158683: goto L_0x0017;
                default: goto L_0x0016;
            }
        L_0x0016:
            goto L_0x0071
        L_0x0017:
            java.lang.String r1 = "newLatLngBounds"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L_0x0016
            r1 = r4
            goto L_0x0072
        L_0x0021:
            java.lang.String r3 = "newCameraPosition"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x0016
            goto L_0x0072
        L_0x002a:
            java.lang.String r1 = "zoomOut"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L_0x0016
            r1 = 7
            goto L_0x0072
        L_0x0034:
            java.lang.String r1 = "newLatLngZoom"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L_0x0016
            r1 = 3
            goto L_0x0072
        L_0x003e:
            java.lang.String r1 = "scrollBy"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L_0x0016
            r1 = 4
            goto L_0x0072
        L_0x0048:
            java.lang.String r1 = "zoomTo"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L_0x0016
            r1 = 8
            goto L_0x0072
        L_0x0053:
            java.lang.String r1 = "zoomIn"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L_0x0016
            r1 = 6
            goto L_0x0072
        L_0x005d:
            java.lang.String r1 = "zoomBy"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L_0x0016
            r1 = 5
            goto L_0x0072
        L_0x0067:
            java.lang.String r1 = "newLatLng"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L_0x0016
            r1 = r5
            goto L_0x0072
        L_0x0071:
            r1 = -1
        L_0x0072:
            switch(r1) {
                case 0: goto L_0x011e;
                case 1: goto L_0x0111;
                case 2: goto L_0x00fb;
                case 3: goto L_0x00e6;
                case 4: goto L_0x00d0;
                case 5: goto L_0x00a8;
                case 6: goto L_0x00a3;
                case 7: goto L_0x009e;
                case 8: goto L_0x0091;
                default: goto L_0x0075;
            }
        L_0x0075:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Cannot interpret "
            r2.append(r3)
            r2.append(r6)
            java.lang.String r3 = " as CameraUpdate"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x0091:
            java.lang.Object r1 = r0.get(r5)
            float r1 = toFloat(r1)
            com.google.android.gms.maps.CameraUpdate r1 = com.google.android.gms.maps.CameraUpdateFactory.zoomTo(r1)
            return r1
        L_0x009e:
            com.google.android.gms.maps.CameraUpdate r1 = com.google.android.gms.maps.CameraUpdateFactory.zoomOut()
            return r1
        L_0x00a3:
            com.google.android.gms.maps.CameraUpdate r1 = com.google.android.gms.maps.CameraUpdateFactory.zoomIn()
            return r1
        L_0x00a8:
            int r1 = r0.size()
            if (r1 != r4) goto L_0x00bb
            java.lang.Object r1 = r0.get(r5)
            float r1 = toFloat(r1)
            com.google.android.gms.maps.CameraUpdate r1 = com.google.android.gms.maps.CameraUpdateFactory.zoomBy(r1)
            return r1
        L_0x00bb:
            java.lang.Object r1 = r0.get(r5)
            float r1 = toFloat(r1)
            java.lang.Object r2 = r0.get(r4)
            android.graphics.Point r2 = toPoint(r2, r7)
            com.google.android.gms.maps.CameraUpdate r1 = com.google.android.gms.maps.CameraUpdateFactory.zoomBy(r1, r2)
            return r1
        L_0x00d0:
            java.lang.Object r1 = r0.get(r5)
            float r1 = toFractionalPixels(r1, r7)
            java.lang.Object r2 = r0.get(r4)
            float r2 = toFractionalPixels(r2, r7)
            com.google.android.gms.maps.CameraUpdate r1 = com.google.android.gms.maps.CameraUpdateFactory.scrollBy(r1, r2)
            return r1
        L_0x00e6:
            java.lang.Object r1 = r0.get(r5)
            com.google.android.gms.maps.model.LatLng r1 = toLatLng(r1)
            java.lang.Object r2 = r0.get(r4)
            float r2 = toFloat(r2)
            com.google.android.gms.maps.CameraUpdate r1 = com.google.android.gms.maps.CameraUpdateFactory.newLatLngZoom(r1, r2)
            return r1
        L_0x00fb:
            java.lang.Object r1 = r0.get(r5)
            com.google.android.gms.maps.model.LatLngBounds r1 = toLatLngBounds(r1)
            java.lang.Object r2 = r0.get(r4)
            int r2 = toPixels(r2, r7)
            com.google.android.gms.maps.CameraUpdate r1 = com.google.android.gms.maps.CameraUpdateFactory.newLatLngBounds(r1, r2)
            return r1
        L_0x0111:
            java.lang.Object r1 = r0.get(r5)
            com.google.android.gms.maps.model.LatLng r1 = toLatLng(r1)
            com.google.android.gms.maps.CameraUpdate r1 = com.google.android.gms.maps.CameraUpdateFactory.newLatLng(r1)
            return r1
        L_0x011e:
            java.lang.Object r1 = r0.get(r5)
            com.google.android.gms.maps.model.CameraPosition r1 = toCameraPosition(r1)
            com.google.android.gms.maps.CameraUpdate r1 = com.google.android.gms.maps.CameraUpdateFactory.newCameraPosition(r1)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.plugins.googlemaps.Convert.toCameraUpdate(java.lang.Object, float):com.google.android.gms.maps.CameraUpdate");
    }

    private static double toDouble(Object o) {
        return ((Number) o).doubleValue();
    }

    private static float toFloat(Object o) {
        return ((Number) o).floatValue();
    }

    private static Float toFloatWrapper(Object o) {
        if (o == null) {
            return null;
        }
        return Float.valueOf(toFloat(o));
    }

    private static int toInt(Object o) {
        return ((Number) o).intValue();
    }

    static Object cameraPositionToJson(CameraPosition position) {
        if (position == null) {
            return null;
        }
        Map<String, Object> data = new HashMap<>();
        data.put("bearing", Float.valueOf(position.bearing));
        data.put("target", latLngToJson(position.target));
        data.put("tilt", Float.valueOf(position.tilt));
        data.put("zoom", Float.valueOf(position.zoom));
        return data;
    }

    static Object latlngBoundsToJson(LatLngBounds latLngBounds) {
        Map<String, Object> arguments = new HashMap<>(2);
        arguments.put("southwest", latLngToJson(latLngBounds.southwest));
        arguments.put("northeast", latLngToJson(latLngBounds.northeast));
        return arguments;
    }

    static Object markerIdToJson(String markerId) {
        if (markerId == null) {
            return null;
        }
        Map<String, Object> data = new HashMap<>(1);
        data.put("markerId", markerId);
        return data;
    }

    static Object polygonIdToJson(String polygonId) {
        if (polygonId == null) {
            return null;
        }
        Map<String, Object> data = new HashMap<>(1);
        data.put("polygonId", polygonId);
        return data;
    }

    static Object polylineIdToJson(String polylineId) {
        if (polylineId == null) {
            return null;
        }
        Map<String, Object> data = new HashMap<>(1);
        data.put("polylineId", polylineId);
        return data;
    }

    static Object circleIdToJson(String circleId) {
        if (circleId == null) {
            return null;
        }
        Map<String, Object> data = new HashMap<>(1);
        data.put("circleId", circleId);
        return data;
    }

    static Object latLngToJson(LatLng latLng) {
        return Arrays.asList(new Double[]{Double.valueOf(latLng.latitude), Double.valueOf(latLng.longitude)});
    }

    static LatLng toLatLng(Object o) {
        List<?> data = toList(o);
        return new LatLng(toDouble(data.get(0)), toDouble(data.get(1)));
    }

    static Point toPoint(Object o) {
        Map<String, Integer> screenCoordinate = (Map) o;
        return new Point(screenCoordinate.get("x").intValue(), screenCoordinate.get("y").intValue());
    }

    static Map<String, Integer> pointToJson(Point point) {
        Map<String, Integer> data = new HashMap<>(2);
        data.put("x", Integer.valueOf(point.x));
        data.put("y", Integer.valueOf(point.y));
        return data;
    }

    private static LatLngBounds toLatLngBounds(Object o) {
        if (o == null) {
            return null;
        }
        List<?> data = toList(o);
        return new LatLngBounds(toLatLng(data.get(0)), toLatLng(data.get(1)));
    }

    private static List<?> toList(Object o) {
        return (List) o;
    }

    private static Map<?, ?> toMap(Object o) {
        return (Map) o;
    }

    private static float toFractionalPixels(Object o, float density) {
        return toFloat(o) * density;
    }

    private static int toPixels(Object o, float density) {
        return (int) toFractionalPixels(o, density);
    }

    private static Bitmap toBitmap(Object o) {
        byte[] bmpData = (byte[]) o;
        Bitmap bitmap = BitmapFactory.decodeByteArray(bmpData, 0, bmpData.length);
        if (bitmap != null) {
            return bitmap;
        }
        throw new IllegalArgumentException("Unable to decode bytes as a valid bitmap.");
    }

    private static Point toPoint(Object o, float density) {
        List<?> data = toList(o);
        return new Point(toPixels(data.get(0), density), toPixels(data.get(1), density));
    }

    private static String toString(Object o) {
        return (String) o;
    }

    static void interpretGoogleMapOptions(Object o, GoogleMapOptionsSink sink) {
        GoogleMapOptionsSink googleMapOptionsSink = sink;
        Map<?, ?> data = toMap(o);
        Object obj = data.get("cameraTargetBounds");
        if (obj != null) {
            googleMapOptionsSink.setCameraTargetBounds(toLatLngBounds(toList(obj).get(0)));
        }
        Object compassEnabled = data.get("compassEnabled");
        if (compassEnabled != null) {
            googleMapOptionsSink.setCompassEnabled(toBoolean(compassEnabled));
        }
        Object mapToolbarEnabled = data.get("mapToolbarEnabled");
        if (mapToolbarEnabled != null) {
            googleMapOptionsSink.setMapToolbarEnabled(toBoolean(mapToolbarEnabled));
        }
        Object mapType = data.get("mapType");
        if (mapType != null) {
            googleMapOptionsSink.setMapType(toInt(mapType));
        }
        Object minMaxZoomPreference = data.get("minMaxZoomPreference");
        if (minMaxZoomPreference != null) {
            List<?> zoomPreferenceData = toList(minMaxZoomPreference);
            googleMapOptionsSink.setMinMaxZoomPreference(toFloatWrapper(zoomPreferenceData.get(0)), toFloatWrapper(zoomPreferenceData.get(1)));
        }
        Object padding = data.get("padding");
        if (padding != null) {
            List<?> paddingData = toList(padding);
            googleMapOptionsSink.setPadding(toFloat(paddingData.get(0)), toFloat(paddingData.get(1)), toFloat(paddingData.get(2)), toFloat(paddingData.get(3)));
        }
        Object obj2 = data.get("rotateGesturesEnabled");
        if (obj2 != null) {
            googleMapOptionsSink.setRotateGesturesEnabled(toBoolean(obj2));
        }
        Object scrollGesturesEnabled = data.get("scrollGesturesEnabled");
        if (scrollGesturesEnabled != null) {
            googleMapOptionsSink.setScrollGesturesEnabled(toBoolean(scrollGesturesEnabled));
        }
        Object tiltGesturesEnabled = data.get("tiltGesturesEnabled");
        if (tiltGesturesEnabled != null) {
            googleMapOptionsSink.setTiltGesturesEnabled(toBoolean(tiltGesturesEnabled));
        }
        Object trackCameraPosition = data.get("trackCameraPosition");
        if (trackCameraPosition != null) {
            googleMapOptionsSink.setTrackCameraPosition(toBoolean(trackCameraPosition));
        }
        Object zoomGesturesEnabled = data.get("zoomGesturesEnabled");
        if (zoomGesturesEnabled != null) {
            googleMapOptionsSink.setZoomGesturesEnabled(toBoolean(zoomGesturesEnabled));
        }
        Object liteModeEnabled = data.get("liteModeEnabled");
        if (liteModeEnabled != null) {
            googleMapOptionsSink.setLiteModeEnabled(toBoolean(liteModeEnabled));
        }
        Object myLocationEnabled = data.get("myLocationEnabled");
        if (myLocationEnabled != null) {
            googleMapOptionsSink.setMyLocationEnabled(toBoolean(myLocationEnabled));
        }
        Object zoomControlsEnabled = data.get("zoomControlsEnabled");
        if (zoomControlsEnabled != null) {
            Object obj3 = obj;
            googleMapOptionsSink.setZoomControlsEnabled(toBoolean(zoomControlsEnabled));
        } else {
            Object cameraTargetBounds = obj;
        }
        Object obj4 = data.get("myLocationButtonEnabled");
        if (obj4 != null) {
            Object obj5 = obj2;
            googleMapOptionsSink.setMyLocationButtonEnabled(toBoolean(obj4));
        } else {
            Object rotateGesturesEnabled = obj2;
        }
        Object obj6 = data.get("indoorEnabled");
        if (obj6 != null) {
            Object obj7 = obj4;
            googleMapOptionsSink.setIndoorEnabled(toBoolean(obj6));
        } else {
            Object myLocationButtonEnabled = obj4;
        }
        Object trafficEnabled = data.get("trafficEnabled");
        if (trafficEnabled != null) {
            Object obj8 = obj6;
            googleMapOptionsSink.setTrafficEnabled(toBoolean(trafficEnabled));
        } else {
            Object indoorEnabled = obj6;
        }
        Object buildingsEnabled = data.get("buildingsEnabled");
        if (buildingsEnabled != null) {
            Map<?, ?> map = data;
            googleMapOptionsSink.setBuildingsEnabled(toBoolean(buildingsEnabled));
            return;
        }
    }

    static String interpretMarkerOptions(Object o, MarkerOptionsSink sink) {
        MarkerOptionsSink markerOptionsSink = sink;
        Map<?, ?> data = toMap(o);
        Object alpha = data.get("alpha");
        if (alpha != null) {
            markerOptionsSink.setAlpha(toFloat(alpha));
        }
        Object anchor = data.get("anchor");
        if (anchor != null) {
            List<?> anchorData = toList(anchor);
            markerOptionsSink.setAnchor(toFloat(anchorData.get(0)), toFloat(anchorData.get(1)));
        }
        Object consumeTapEvents = data.get("consumeTapEvents");
        if (consumeTapEvents != null) {
            markerOptionsSink.setConsumeTapEvents(toBoolean(consumeTapEvents));
        }
        Object draggable = data.get("draggable");
        if (draggable != null) {
            markerOptionsSink.setDraggable(toBoolean(draggable));
        }
        Object flat = data.get("flat");
        if (flat != null) {
            markerOptionsSink.setFlat(toBoolean(flat));
        }
        Object icon = data.get("icon");
        if (icon != null) {
            markerOptionsSink.setIcon(toBitmapDescriptor(icon));
        }
        Object infoWindow = data.get("infoWindow");
        if (infoWindow != null) {
            interpretInfoWindowOptions(markerOptionsSink, (Map) infoWindow);
        }
        Object position = data.get("position");
        if (position != null) {
            markerOptionsSink.setPosition(toLatLng(position));
        }
        Object rotation = data.get("rotation");
        if (rotation != null) {
            markerOptionsSink.setRotation(toFloat(rotation));
        }
        Object visible = data.get("visible");
        if (visible != null) {
            markerOptionsSink.setVisible(toBoolean(visible));
        }
        Object zIndex = data.get("zIndex");
        if (zIndex != null) {
            markerOptionsSink.setZIndex(toFloat(zIndex));
        }
        String markerId = (String) data.get("markerId");
        if (markerId != null) {
            return markerId;
        }
        throw new IllegalArgumentException("markerId was null");
    }

    private static void interpretInfoWindowOptions(MarkerOptionsSink sink, Map<String, Object> infoWindow) {
        String title = (String) infoWindow.get("title");
        String snippet = (String) infoWindow.get("snippet");
        if (title != null) {
            sink.setInfoWindowText(title, snippet);
        }
        Object infoWindowAnchor = infoWindow.get("anchor");
        if (infoWindowAnchor != null) {
            List<?> anchorData = toList(infoWindowAnchor);
            sink.setInfoWindowAnchor(toFloat(anchorData.get(0)), toFloat(anchorData.get(1)));
        }
    }

    static String interpretPolygonOptions(Object o, PolygonOptionsSink sink) {
        Map<?, ?> data = toMap(o);
        Object consumeTapEvents = data.get("consumeTapEvents");
        if (consumeTapEvents != null) {
            sink.setConsumeTapEvents(toBoolean(consumeTapEvents));
        }
        Object geodesic = data.get("geodesic");
        if (geodesic != null) {
            sink.setGeodesic(toBoolean(geodesic));
        }
        Object visible = data.get("visible");
        if (visible != null) {
            sink.setVisible(toBoolean(visible));
        }
        Object fillColor = data.get("fillColor");
        if (fillColor != null) {
            sink.setFillColor(toInt(fillColor));
        }
        Object strokeColor = data.get("strokeColor");
        if (strokeColor != null) {
            sink.setStrokeColor(toInt(strokeColor));
        }
        Object strokeWidth = data.get("strokeWidth");
        if (strokeWidth != null) {
            sink.setStrokeWidth((float) toInt(strokeWidth));
        }
        Object zIndex = data.get("zIndex");
        if (zIndex != null) {
            sink.setZIndex(toFloat(zIndex));
        }
        Object points = data.get("points");
        if (points != null) {
            sink.setPoints(toPoints(points));
        }
        String polygonId = (String) data.get("polygonId");
        if (polygonId != null) {
            return polygonId;
        }
        throw new IllegalArgumentException("polygonId was null");
    }

    static String interpretPolylineOptions(Object o, PolylineOptionsSink sink) {
        PolylineOptionsSink polylineOptionsSink = sink;
        Map<?, ?> data = toMap(o);
        Object consumeTapEvents = data.get("consumeTapEvents");
        if (consumeTapEvents != null) {
            polylineOptionsSink.setConsumeTapEvents(toBoolean(consumeTapEvents));
        }
        Object color = data.get("color");
        if (color != null) {
            polylineOptionsSink.setColor(toInt(color));
        }
        Object endCap = data.get("endCap");
        if (endCap != null) {
            polylineOptionsSink.setEndCap(toCap(endCap));
        }
        Object geodesic = data.get("geodesic");
        if (geodesic != null) {
            polylineOptionsSink.setGeodesic(toBoolean(geodesic));
        }
        Object jointType = data.get("jointType");
        if (jointType != null) {
            polylineOptionsSink.setJointType(toInt(jointType));
        }
        Object startCap = data.get("startCap");
        if (startCap != null) {
            polylineOptionsSink.setStartCap(toCap(startCap));
        }
        Object visible = data.get("visible");
        if (visible != null) {
            polylineOptionsSink.setVisible(toBoolean(visible));
        }
        Object width = data.get("width");
        if (width != null) {
            polylineOptionsSink.setWidth((float) toInt(width));
        }
        Object zIndex = data.get("zIndex");
        if (zIndex != null) {
            polylineOptionsSink.setZIndex(toFloat(zIndex));
        }
        Object points = data.get("points");
        if (points != null) {
            polylineOptionsSink.setPoints(toPoints(points));
        }
        Object pattern = data.get("pattern");
        if (pattern != null) {
            polylineOptionsSink.setPattern(toPattern(pattern));
        }
        String polylineId = (String) data.get("polylineId");
        if (polylineId != null) {
            return polylineId;
        }
        throw new IllegalArgumentException("polylineId was null");
    }

    static String interpretCircleOptions(Object o, CircleOptionsSink sink) {
        Map<?, ?> data = toMap(o);
        Object consumeTapEvents = data.get("consumeTapEvents");
        if (consumeTapEvents != null) {
            sink.setConsumeTapEvents(toBoolean(consumeTapEvents));
        }
        Object fillColor = data.get("fillColor");
        if (fillColor != null) {
            sink.setFillColor(toInt(fillColor));
        }
        Object strokeColor = data.get("strokeColor");
        if (strokeColor != null) {
            sink.setStrokeColor(toInt(strokeColor));
        }
        Object visible = data.get("visible");
        if (visible != null) {
            sink.setVisible(toBoolean(visible));
        }
        Object strokeWidth = data.get("strokeWidth");
        if (strokeWidth != null) {
            sink.setStrokeWidth((float) toInt(strokeWidth));
        }
        Object zIndex = data.get("zIndex");
        if (zIndex != null) {
            sink.setZIndex(toFloat(zIndex));
        }
        Object center = data.get("center");
        if (center != null) {
            sink.setCenter(toLatLng(center));
        }
        Object radius = data.get("radius");
        if (radius != null) {
            sink.setRadius(toDouble(radius));
        }
        String circleId = (String) data.get("circleId");
        if (circleId != null) {
            return circleId;
        }
        throw new IllegalArgumentException("circleId was null");
    }

    private static List<LatLng> toPoints(Object o) {
        List<?> data = toList(o);
        List<LatLng> points = new ArrayList<>(data.size());
        for (Object ob : data) {
            List<?> point = toList(ob);
            points.add(new LatLng((double) toFloat(point.get(0)), (double) toFloat(point.get(1))));
        }
        return points;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0061, code lost:
        if (r6.equals("dot") != false) goto L_0x0065;
     */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00a9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.List<com.google.android.gms.maps.model.PatternItem> toPattern(java.lang.Object r12) {
        /*
            java.util.List r0 = toList(r12)
            boolean r1 = r0.isEmpty()
            if (r1 == 0) goto L_0x000c
            r1 = 0
            return r1
        L_0x000c:
            java.util.ArrayList r1 = new java.util.ArrayList
            int r2 = r0.size()
            r1.<init>(r2)
            java.util.Iterator r2 = r0.iterator()
        L_0x0019:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x00b4
            java.lang.Object r3 = r2.next()
            java.util.List r4 = toList(r3)
            r5 = 0
            java.lang.Object r6 = r4.get(r5)
            java.lang.String r6 = toString(r6)
            r7 = -1
            int r8 = r6.hashCode()
            r9 = 99657(0x18549, float:1.39649E-40)
            r10 = 2
            r11 = 1
            if (r8 == r9) goto L_0x005b
            r5 = 102102(0x18ed6, float:1.43075E-40)
            if (r8 == r5) goto L_0x0051
            r5 = 3075986(0x2eef92, float:4.310374E-39)
            if (r8 == r5) goto L_0x0047
        L_0x0046:
            goto L_0x0064
        L_0x0047:
            java.lang.String r5 = "dash"
            boolean r5 = r6.equals(r5)
            if (r5 == 0) goto L_0x0046
            r5 = r11
            goto L_0x0065
        L_0x0051:
            java.lang.String r5 = "gap"
            boolean r5 = r6.equals(r5)
            if (r5 == 0) goto L_0x0046
            r5 = r10
            goto L_0x0065
        L_0x005b:
            java.lang.String r8 = "dot"
            boolean r6 = r6.equals(r8)
            if (r6 == 0) goto L_0x0046
            goto L_0x0065
        L_0x0064:
            r5 = r7
        L_0x0065:
            if (r5 == 0) goto L_0x00a9
            if (r5 == r11) goto L_0x0098
            if (r5 != r10) goto L_0x007c
            com.google.android.gms.maps.model.Gap r5 = new com.google.android.gms.maps.model.Gap
            java.lang.Object r6 = r4.get(r11)
            float r6 = toFloat(r6)
            r5.<init>(r6)
            r1.add(r5)
            goto L_0x00b2
        L_0x007c:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "Cannot interpret "
            r5.append(r6)
            r5.append(r1)
            java.lang.String r6 = " as PatternItem"
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            r2.<init>(r5)
            throw r2
        L_0x0098:
            com.google.android.gms.maps.model.Dash r5 = new com.google.android.gms.maps.model.Dash
            java.lang.Object r6 = r4.get(r11)
            float r6 = toFloat(r6)
            r5.<init>(r6)
            r1.add(r5)
            goto L_0x00b2
        L_0x00a9:
            com.google.android.gms.maps.model.Dot r5 = new com.google.android.gms.maps.model.Dot
            r5.<init>()
            r1.add(r5)
        L_0x00b2:
            goto L_0x0019
        L_0x00b4:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.plugins.googlemaps.Convert.toPattern(java.lang.Object):java.util.List");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0032, code lost:
        if (r2.equals("buttCap") != false) goto L_0x0040;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.android.gms.maps.model.Cap toCap(java.lang.Object r7) {
        /*
            java.util.List r0 = toList(r7)
            r1 = 0
            java.lang.Object r2 = r0.get(r1)
            java.lang.String r2 = toString(r2)
            int r3 = r2.hashCode()
            r4 = 3
            r5 = 2
            r6 = 1
            switch(r3) {
                case -179356: goto L_0x0035;
                case 241309887: goto L_0x002c;
                case 1314340213: goto L_0x0022;
                case 1611528865: goto L_0x0018;
                default: goto L_0x0017;
            }
        L_0x0017:
            goto L_0x003f
        L_0x0018:
            java.lang.String r1 = "customCap"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L_0x0017
            r1 = r4
            goto L_0x0040
        L_0x0022:
            java.lang.String r1 = "squareCap"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L_0x0017
            r1 = r5
            goto L_0x0040
        L_0x002c:
            java.lang.String r3 = "buttCap"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x0017
            goto L_0x0040
        L_0x0035:
            java.lang.String r1 = "roundCap"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L_0x0017
            r1 = r6
            goto L_0x0040
        L_0x003f:
            r1 = -1
        L_0x0040:
            if (r1 == 0) goto L_0x009a
            if (r1 == r6) goto L_0x0094
            if (r1 == r5) goto L_0x008e
            if (r1 != r4) goto L_0x0072
            int r1 = r0.size()
            if (r1 != r5) goto L_0x005c
            com.google.android.gms.maps.model.CustomCap r1 = new com.google.android.gms.maps.model.CustomCap
            java.lang.Object r2 = r0.get(r6)
            com.google.android.gms.maps.model.BitmapDescriptor r2 = toBitmapDescriptor(r2)
            r1.<init>(r2)
            return r1
        L_0x005c:
            com.google.android.gms.maps.model.CustomCap r1 = new com.google.android.gms.maps.model.CustomCap
            java.lang.Object r2 = r0.get(r6)
            com.google.android.gms.maps.model.BitmapDescriptor r2 = toBitmapDescriptor(r2)
            java.lang.Object r3 = r0.get(r5)
            float r3 = toFloat(r3)
            r1.<init>(r2, r3)
            return r1
        L_0x0072:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Cannot interpret "
            r2.append(r3)
            r2.append(r7)
            java.lang.String r3 = " as Cap"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x008e:
            com.google.android.gms.maps.model.SquareCap r1 = new com.google.android.gms.maps.model.SquareCap
            r1.<init>()
            return r1
        L_0x0094:
            com.google.android.gms.maps.model.RoundCap r1 = new com.google.android.gms.maps.model.RoundCap
            r1.<init>()
            return r1
        L_0x009a:
            com.google.android.gms.maps.model.ButtCap r1 = new com.google.android.gms.maps.model.ButtCap
            r1.<init>()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.plugins.googlemaps.Convert.toCap(java.lang.Object):com.google.android.gms.maps.model.Cap");
    }
}
