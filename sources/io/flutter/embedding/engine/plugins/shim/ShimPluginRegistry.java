package io.flutter.embedding.engine.plugins.shim;

import io.flutter.Log;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.PluginRegistry;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ShimPluginRegistry implements PluginRegistry {
    private static final String TAG = "ShimPluginRegistry";
    private final FlutterEngine flutterEngine;
    private final Map<String, Object> pluginMap = new HashMap();
    private final ShimRegistrarAggregate shimRegistrarAggregate;

    public ShimPluginRegistry(FlutterEngine flutterEngine2) {
        this.flutterEngine = flutterEngine2;
        this.shimRegistrarAggregate = new ShimRegistrarAggregate();
        this.flutterEngine.getPlugins().add((FlutterPlugin) this.shimRegistrarAggregate);
    }

    public PluginRegistry.Registrar registrarFor(String pluginKey) {
        Log.v(TAG, "Creating plugin Registrar for '" + pluginKey + "'");
        if (!this.pluginMap.containsKey(pluginKey)) {
            this.pluginMap.put(pluginKey, (Object) null);
            ShimRegistrar registrar = new ShimRegistrar(pluginKey, this.pluginMap);
            this.shimRegistrarAggregate.addPlugin(registrar);
            return registrar;
        }
        throw new IllegalStateException("Plugin key " + pluginKey + " is already in use");
    }

    public boolean hasPlugin(String pluginKey) {
        return this.pluginMap.containsKey(pluginKey);
    }

    public <T> T valuePublishedByPlugin(String pluginKey) {
        return this.pluginMap.get(pluginKey);
    }

    private static class ShimRegistrarAggregate implements FlutterPlugin, ActivityAware {
        private ActivityPluginBinding activityPluginBinding;
        private FlutterPlugin.FlutterPluginBinding flutterPluginBinding;
        private final Set<ShimRegistrar> shimRegistrars;

        private ShimRegistrarAggregate() {
            this.shimRegistrars = new HashSet();
        }

        public void addPlugin(ShimRegistrar shimRegistrar) {
            this.shimRegistrars.add(shimRegistrar);
            FlutterPlugin.FlutterPluginBinding flutterPluginBinding2 = this.flutterPluginBinding;
            if (flutterPluginBinding2 != null) {
                shimRegistrar.onAttachedToEngine(flutterPluginBinding2);
            }
            ActivityPluginBinding activityPluginBinding2 = this.activityPluginBinding;
            if (activityPluginBinding2 != null) {
                shimRegistrar.onAttachedToActivity(activityPluginBinding2);
            }
        }

        public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding binding) {
            this.flutterPluginBinding = binding;
            for (ShimRegistrar shimRegistrar : this.shimRegistrars) {
                shimRegistrar.onAttachedToEngine(binding);
            }
        }

        public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding binding) {
            for (ShimRegistrar shimRegistrar : this.shimRegistrars) {
                shimRegistrar.onDetachedFromEngine(binding);
            }
            this.flutterPluginBinding = null;
            this.activityPluginBinding = null;
        }

        public void onAttachedToActivity(ActivityPluginBinding binding) {
            this.activityPluginBinding = binding;
            for (ShimRegistrar shimRegistrar : this.shimRegistrars) {
                shimRegistrar.onAttachedToActivity(binding);
            }
        }

        public void onDetachedFromActivityForConfigChanges() {
            for (ShimRegistrar shimRegistrar : this.shimRegistrars) {
                shimRegistrar.onDetachedFromActivity();
            }
            this.activityPluginBinding = null;
        }

        public void onReattachedToActivityForConfigChanges(ActivityPluginBinding binding) {
            this.activityPluginBinding = binding;
            for (ShimRegistrar shimRegistrar : this.shimRegistrars) {
                shimRegistrar.onReattachedToActivityForConfigChanges(binding);
            }
        }

        public void onDetachedFromActivity() {
            for (ShimRegistrar shimRegistrar : this.shimRegistrars) {
                shimRegistrar.onDetachedFromActivity();
            }
            this.activityPluginBinding = null;
        }
    }
}
