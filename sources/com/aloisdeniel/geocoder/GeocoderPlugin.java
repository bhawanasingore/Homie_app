package com.aloisdeniel.geocoder;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.PluginRegistry;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GeocoderPlugin implements MethodChannel.MethodCallHandler {
    /* access modifiers changed from: private */
    public Geocoder geocoder;

    public GeocoderPlugin(Context context) {
        this.geocoder = new Geocoder(context);
    }

    public static void registerWith(PluginRegistry.Registrar registrar) {
        new MethodChannel(registrar.messenger(), "github.com/aloisdeniel/geocoder").setMethodCallHandler(new GeocoderPlugin(registrar.context()));
    }

    private static class MethodResultWrapper implements MethodChannel.Result {
        private Handler handler = new Handler(Looper.getMainLooper());
        /* access modifiers changed from: private */
        public MethodChannel.Result methodResult;

        MethodResultWrapper(MethodChannel.Result result) {
            this.methodResult = result;
        }

        public void success(final Object result) {
            this.handler.post(new Runnable() {
                public void run() {
                    MethodResultWrapper.this.methodResult.success(result);
                }
            });
        }

        public void error(final String errorCode, final String errorMessage, final Object errorDetails) {
            this.handler.post(new Runnable() {
                public void run() {
                    MethodResultWrapper.this.methodResult.error(errorCode, errorMessage, errorDetails);
                }
            });
        }

        public void notImplemented() {
            this.handler.post(new Runnable() {
                public void run() {
                    MethodResultWrapper.this.methodResult.notImplemented();
                }
            });
        }
    }

    public void onMethodCall(MethodCall call, MethodChannel.Result rawResult) {
        MethodChannel.Result result = new MethodResultWrapper(rawResult);
        if (call.method.equals("findAddressesFromQuery")) {
            findAddressesFromQuery((String) call.argument("address"), result);
        } else if (call.method.equals("findAddressesFromCoordinates")) {
            findAddressesFromCoordinates(((Number) call.argument("latitude")).floatValue(), ((Number) call.argument("longitude")).floatValue(), result);
        } else {
            result.notImplemented();
        }
    }

    /* access modifiers changed from: private */
    public void assertPresent() throws NotAvailableException {
        if (!Geocoder.isPresent()) {
            throw new NotAvailableException();
        }
    }

    private void findAddressesFromQuery(final String address, final MethodChannel.Result result) {
        new AsyncTask<Void, Void, List<Address>>() {
            /* access modifiers changed from: protected */
            public List<Address> doInBackground(Void... params) {
                try {
                    this.assertPresent();
                    return GeocoderPlugin.this.geocoder.getFromLocationName(address, 20);
                } catch (IOException e) {
                    return null;
                } catch (NotAvailableException e2) {
                    return new ArrayList();
                }
            }

            /* access modifiers changed from: protected */
            public void onPostExecute(List<Address> addresses) {
                if (addresses == null) {
                    result.error("failed", "Failed", (Object) null);
                } else if (addresses.isEmpty()) {
                    result.error("not_available", "Empty", (Object) null);
                } else {
                    result.success(GeocoderPlugin.this.createAddressMapList(addresses));
                }
            }
        }.execute(new Void[0]);
    }

    private void findAddressesFromCoordinates(float latitude, float longitude, MethodChannel.Result result) {
        final float f = latitude;
        final float f2 = longitude;
        final MethodChannel.Result result2 = result;
        new AsyncTask<Void, Void, List<Address>>() {
            /* access modifiers changed from: protected */
            public List<Address> doInBackground(Void... params) {
                try {
                    this.assertPresent();
                    return GeocoderPlugin.this.geocoder.getFromLocation((double) f, (double) f2, 20);
                } catch (IOException e) {
                    return null;
                } catch (NotAvailableException e2) {
                    return new ArrayList();
                }
            }

            /* access modifiers changed from: protected */
            public void onPostExecute(List<Address> addresses) {
                if (addresses == null) {
                    result2.error("failed", "Failed", (Object) null);
                } else if (addresses.isEmpty()) {
                    result2.error("not_available", "Empty", (Object) null);
                } else {
                    result2.success(GeocoderPlugin.this.createAddressMapList(addresses));
                }
            }
        }.execute(new Void[0]);
    }

    private Map<String, Object> createCoordinatesMap(Address address) {
        if (address == null) {
            return null;
        }
        Map<String, Object> result = new HashMap<>();
        result.put("latitude", Double.valueOf(address.getLatitude()));
        result.put("longitude", Double.valueOf(address.getLongitude()));
        return result;
    }

    private Map<String, Object> createAddressMap(Address address) {
        if (address == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= address.getMaxAddressLineIndex(); i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(address.getAddressLine(i));
        }
        Map<String, Object> result = new HashMap<>();
        result.put("coordinates", createCoordinatesMap(address));
        result.put("featureName", address.getFeatureName());
        result.put("countryName", address.getCountryName());
        result.put("countryCode", address.getCountryCode());
        result.put("locality", address.getLocality());
        result.put("subLocality", address.getSubLocality());
        result.put("thoroughfare", address.getThoroughfare());
        result.put("subThoroughfare", address.getSubThoroughfare());
        result.put("adminArea", address.getAdminArea());
        result.put("subAdminArea", address.getSubAdminArea());
        result.put("addressLine", sb.toString());
        result.put("postalCode", address.getPostalCode());
        return result;
    }

    /* access modifiers changed from: private */
    public List<Map<String, Object>> createAddressMapList(List<Address> addresses) {
        if (addresses == null) {
            return new ArrayList();
        }
        List<Map<String, Object>> result = new ArrayList<>(addresses.size());
        for (Address address : addresses) {
            result.add(createAddressMap(address));
        }
        return result;
    }
}
