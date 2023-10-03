package io.flutter.plugins;

import com.aloisdeniel.geocoder.GeocoderPlugin;
import com.baseflow.geolocator.GeolocatorPlugin;
import com.baseflow.permissionhandler.PermissionHandlerPlugin;
import com.lyokone.location.LocationPlugin;
import com.mr.flutter.plugin.filepicker.FilePickerPlugin;
import com.noeatsleepdev.geoflutterfire.GeoflutterfirePlugin;
import com.vitanov.multiimagepicker.MultiImagePickerPlugin;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.shim.ShimPluginRegistry;
import io.flutter.plugins.firebase.auth.FlutterFirebaseAuthPlugin;
import io.flutter.plugins.firebase.core.FlutterFirebaseCorePlugin;
import io.flutter.plugins.firebase.database.FirebaseDatabasePlugin;
import io.flutter.plugins.firebase.firestore.FlutterFirebaseFirestorePlugin;
import io.flutter.plugins.firebase.storage.FirebaseStoragePlugin;
import io.flutter.plugins.flutter_plugin_android_lifecycle.FlutterAndroidLifecyclePlugin;
import io.flutter.plugins.googlemaps.GoogleMapsPlugin;
import io.flutter.plugins.imagepicker.ImagePickerPlugin;
import io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin;
import io.flutter.plugins.urllauncher.UrlLauncherPlugin;

public final class GeneratedPluginRegistrant {
    public static void registerWith(FlutterEngine flutterEngine) {
        ShimPluginRegistry shimPluginRegistry = new ShimPluginRegistry(flutterEngine);
        flutterEngine.getPlugins().add((FlutterPlugin) new FlutterFirebaseFirestorePlugin());
        flutterEngine.getPlugins().add((FlutterPlugin) new FilePickerPlugin());
        flutterEngine.getPlugins().add((FlutterPlugin) new FlutterFirebaseAuthPlugin());
        flutterEngine.getPlugins().add((FlutterPlugin) new FlutterFirebaseCorePlugin());
        flutterEngine.getPlugins().add((FlutterPlugin) new FirebaseDatabasePlugin());
        flutterEngine.getPlugins().add((FlutterPlugin) new FirebaseStoragePlugin());
        flutterEngine.getPlugins().add((FlutterPlugin) new FlutterAndroidLifecyclePlugin());
        GeocoderPlugin.registerWith(shimPluginRegistry.registrarFor("com.aloisdeniel.geocoder.GeocoderPlugin"));
        GeoflutterfirePlugin.registerWith(shimPluginRegistry.registrarFor("com.noeatsleepdev.geoflutterfire.GeoflutterfirePlugin"));
        flutterEngine.getPlugins().add((FlutterPlugin) new GeolocatorPlugin());
        flutterEngine.getPlugins().add((FlutterPlugin) new GoogleMapsPlugin());
        flutterEngine.getPlugins().add((FlutterPlugin) new ImagePickerPlugin());
        flutterEngine.getPlugins().add((FlutterPlugin) new LocationPlugin());
        flutterEngine.getPlugins().add((FlutterPlugin) new MultiImagePickerPlugin());
        flutterEngine.getPlugins().add((FlutterPlugin) new PermissionHandlerPlugin());
        flutterEngine.getPlugins().add((FlutterPlugin) new SharedPreferencesPlugin());
        flutterEngine.getPlugins().add((FlutterPlugin) new UrlLauncherPlugin());
    }
}
