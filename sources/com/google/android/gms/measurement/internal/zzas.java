package com.google.android.gms.measurement.internal;

import android.content.Context;
import com.google.android.gms.internal.measurement.zzcc;
import com.google.android.gms.internal.measurement.zzcr;
import com.google.android.gms.internal.measurement.zzji;
import com.google.firebase.firestore.util.ExponentialBackoff;
import com.google.logging.type.LogSeverity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
public final class zzas {
    public static zzem<Long> zza = zza("measurement.ad_id_cache_time", 10000L, 10000L, zzar.zza);
    public static zzem<Long> zzaa = zza("measurement.upload.retry_time", 1800000L, 1800000L, zzbm.zza);
    public static zzem<Integer> zzab = zza("measurement.upload.retry_count", 6, 6, zzbl.zza);
    public static zzem<Long> zzac = zza("measurement.upload.max_queue_time", 2419200000L, 2419200000L, zzbo.zza);
    public static zzem<Integer> zzad = zza("measurement.lifetimevalue.max_currency_tracked", 4, 4, zzbn.zza);
    public static zzem<Integer> zzae = zza("measurement.audience.filter_result_max_count", 200, 200, zzbp.zza);
    public static zzem<Integer> zzaf = zza("measurement.upload.max_public_user_properties", 25, 25, (zzek) null);
    public static zzem<Integer> zzag;
    public static zzem<Integer> zzah = zza("measurement.upload.max_public_event_params", 25, 25, (zzek) null);
    public static zzem<Long> zzai = zza("measurement.service_client.idle_disconnect_millis", 5000L, 5000L, zzbs.zza);
    public static zzem<Boolean> zzaj = zza("measurement.test.boolean_flag", false, false, zzbr.zza);
    public static zzem<String> zzak = zza("measurement.test.string_flag", "---", "---", zzbu.zza);
    public static zzem<Long> zzal = zza("measurement.test.long_flag", -1L, -1L, zzbt.zza);
    public static zzem<Integer> zzam = zza("measurement.test.int_flag", -2, -2, zzbw.zza);
    public static zzem<Double> zzan;
    public static zzem<Integer> zzao = zza("measurement.experiment.max_ids", 50, 50, zzby.zza);
    public static zzem<Integer> zzap = zza("measurement.max_bundles_per_iteration", 2, 2, zzbx.zza);
    public static zzem<Boolean> zzaq = zza("measurement.validation.internal_limits_internal_event_params", false, false, zzca.zza);
    public static zzem<Boolean> zzar = zza("measurement.referrer.enable_logging_install_referrer_cmp_from_apk", true, true, zzcc.zza);
    public static zzem<Boolean> zzas = zza("measurement.collection.firebase_global_collection_flag_enabled", true, true, zzcb.zza);
    public static zzem<Boolean> zzat = zza("measurement.collection.efficient_engagement_reporting_enabled_2", true, true, zzce.zza);
    public static zzem<Boolean> zzau = zza("measurement.collection.redundant_engagement_removal_enabled", false, false, zzcd.zza);
    public static zzem<Boolean> zzav = zza("measurement.client.freeride_engagement_fix", true, true, zzcg.zza);
    public static zzem<Boolean> zzaw = zza("measurement.experiment.enable_experiment_reporting", true, true, zzcf.zza);
    public static zzem<Boolean> zzax = zza("measurement.collection.log_event_and_bundle_v2", true, true, zzci.zza);
    public static zzem<Boolean> zzay = zza("measurement.quality.checksum", false, false, (zzek) null);
    public static zzem<Boolean> zzaz = zza("measurement.sdk.dynamite.use_dynamite3", true, true, zzch.zza);
    public static zzem<Long> zzb = zza("measurement.monitoring.sample_period_millis", 86400000L, 86400000L, zzau.zza);
    public static zzem<Boolean> zzba = zza("measurement.sdk.dynamite.allow_remote_dynamite", false, false, zzck.zza);
    public static zzem<Boolean> zzbb = zza("measurement.sdk.collection.validate_param_names_alphabetical", true, true, zzcj.zza);
    public static zzem<Boolean> zzbc = zza("measurement.collection.event_safelist", true, true, zzcl.zza);
    public static zzem<Boolean> zzbd = zza("measurement.service.audience.fix_skip_audience_with_failed_filters", true, true, zzcn.zza);
    public static zzem<Boolean> zzbe = zza("measurement.audience.use_bundle_end_timestamp_for_non_sequence_property_filters", false, false, zzcq.zza);
    public static zzem<Boolean> zzbf = zza("measurement.audience.refresh_event_count_filters_timestamp", false, false, zzcp.zza);
    public static zzem<Boolean> zzbg = zza("measurement.audience.use_bundle_timestamp_for_event_count_filters", false, false, zzcs.zza);
    public static zzem<Boolean> zzbh = zza("measurement.sdk.collection.retrieve_deeplink_from_bow_2", true, true, zzcr.zza);
    public static zzem<Boolean> zzbi = zza("measurement.sdk.collection.last_deep_link_referrer2", true, true, zzcu.zza);
    public static zzem<Boolean> zzbj = zza("measurement.sdk.collection.last_deep_link_referrer_campaign2", false, false, zzct.zza);
    public static zzem<Boolean> zzbk = zza("measurement.sdk.collection.last_gclid_from_referrer2", false, false, zzcw.zza);
    public static zzem<Boolean> zzbl = zza("measurement.sdk.collection.enable_extend_user_property_size", true, true, zzcy.zza);
    public static zzem<Boolean> zzbm = zza("measurement.upload.file_lock_state_check", false, false, zzcx.zza);
    public static zzem<Boolean> zzbn = zza("measurement.sampling.calculate_bundle_timestamp_before_sampling", true, true, zzda.zza);
    public static zzem<Boolean> zzbo = zza("measurement.ga.ga_app_id", false, false, zzcz.zza);
    public static zzem<Boolean> zzbp = zza("measurement.lifecycle.app_backgrounded_tracking", true, true, zzdc.zza);
    public static zzem<Boolean> zzbq = zza("measurement.lifecycle.app_in_background_parameter", false, false, zzdb.zza);
    public static zzem<Boolean> zzbr = zza("measurement.integration.disable_firebase_instance_id", false, false, zzde.zza);
    public static zzem<Boolean> zzbs = zza("measurement.lifecycle.app_backgrounded_engagement", false, false, zzdd.zza);
    public static zzem<Boolean> zzbt = zza("measurement.collection.service.update_with_analytics_fix", false, false, zzdg.zza);
    public static zzem<Boolean> zzbu = zza("measurement.service.use_appinfo_modified", false, false, zzdf.zza);
    public static zzem<Boolean> zzbv = zza("measurement.client.firebase_feature_rollout.v1.enable", true, true, zzdh.zza);
    public static zzem<Boolean> zzbw = zza("measurement.client.sessions.check_on_reset_and_enable2", true, true, zzdk.zza);
    public static zzem<Boolean> zzbx = zza("measurement.config.string.always_update_disk_on_set", true, true, zzdj.zza);
    public static zzem<Boolean> zzby = zza("measurement.scheduler.task_thread.cleanup_on_exit", false, false, zzdm.zza);
    public static zzem<Boolean> zzbz = zza("measurement.upload.file_truncate_fix", false, false, zzdl.zza);
    public static zzem<Long> zzc = zza("measurement.config.cache_time", 86400000L, 3600000L, zzbd.zza);
    public static zzem<Boolean> zzca = zza("measurement.engagement_time_main_thread", true, true, zzdo.zza);
    public static zzem<Boolean> zzcb = zza("measurement.sdk.referrer.delayed_install_referrer_api", false, false, zzdn.zza);
    public static zzem<Boolean> zzcc = zza("measurement.sdk.screen.disabling_automatic_reporting", true, true, zzdq.zza);
    public static zzem<Boolean> zzcd = zza("measurement.sdk.screen.manual_screen_view_logging", true, true, zzdp.zza);
    public static zzem<Boolean> zzce = zza("measurement.gold.enhanced_ecommerce.format_logs", false, false, zzds.zza);
    public static zzem<Boolean> zzcf = zza("measurement.gold.enhanced_ecommerce.nested_param_daily_event_count", false, false, zzdu.zza);
    public static zzem<Boolean> zzcg = zza("measurement.gold.enhanced_ecommerce.upload_nested_complex_events", false, false, zzdt.zza);
    public static zzem<Boolean> zzch = zza("measurement.gold.enhanced_ecommerce.log_nested_complex_events", false, false, zzdw.zza);
    public static zzem<Boolean> zzci = zza("measurement.gold.enhanced_ecommerce.updated_schema.client", false, false, zzdv.zza);
    public static zzem<Boolean> zzcj = zza("measurement.gold.enhanced_ecommerce.updated_schema.service", false, false, zzdy.zza);
    public static zzem<Boolean> zzck = zza("measurement.service.configurable_service_limits", false, false, zzea.zza);
    public static zzem<Boolean> zzcl = zza("measurement.client.configurable_service_limits", false, false, zzdz.zza);
    public static zzem<Boolean> zzcm = zza("measurement.androidId.delete_feature", true, true, zzec.zza);
    public static zzem<Boolean> zzcn = zza("measurement.client.global_params.dev", false, false, zzeb.zza);
    public static zzem<Boolean> zzco = zza("measurement.client.string_reader", true, true, zzeg.zza);
    public static zzem<Boolean> zzcp = zza("measurement.sdk.attribution.cache", true, true, zzef.zza);
    public static zzem<Long> zzcq = zza("measurement.sdk.attribution.cache.ttl", 604800000L, 604800000L, zzei.zza);
    /* access modifiers changed from: private */
    public static List<zzem<?>> zzcr = Collections.synchronizedList(new ArrayList());
    private static Set<zzem<?>> zzcs = Collections.synchronizedSet(new HashSet());
    private static zzem<Boolean> zzct = zza("measurement.service.audience.invalidate_config_cache_after_app_unisntall", true, true, zzco.zza);
    private static zzem<Boolean> zzcu = zza("measurement.collection.synthetic_data_mitigation", false, false, zzdx.zza);
    private static zzem<Boolean> zzcv = zza("measurement.service.global_params", false, false, zzed.zza);
    public static zzem<String> zzd = zza("measurement.config.url_scheme", "https", "https", zzbq.zza);
    public static zzem<String> zze = zza("measurement.config.url_authority", "app-measurement.com", "app-measurement.com", zzbz.zza);
    public static zzem<Integer> zzf = zza("measurement.upload.max_bundles", 100, 100, zzcm.zza);
    public static zzem<Integer> zzg = zza("measurement.upload.max_batch_size", 65536, 65536, zzcv.zza);
    public static zzem<Integer> zzh = zza("measurement.upload.max_bundle_size", 65536, 65536, zzdi.zza);
    public static zzem<Integer> zzi = zza("measurement.upload.max_events_per_bundle", 1000, 1000, zzdr.zza);
    public static zzem<Integer> zzj = zza("measurement.upload.max_events_per_day", 100000, 100000, zzee.zza);
    public static zzem<Integer> zzk = zza("measurement.upload.max_error_events_per_day", 1000, 1000, zzat.zza);
    public static zzem<Integer> zzl = zza("measurement.upload.max_public_events_per_day", 50000, 50000, zzaw.zza);
    public static zzem<Integer> zzm = zza("measurement.upload.max_conversions_per_day", 10000, 10000, zzav.zza);
    public static zzem<Integer> zzn = zza("measurement.upload.max_realtime_events_per_day", 10, 10, zzay.zza);
    public static zzem<Integer> zzo = zza("measurement.store.max_stored_events_per_app", 100000, 100000, zzax.zza);
    public static zzem<String> zzp = zza("measurement.upload.url", "https://app-measurement.com/a", "https://app-measurement.com/a", zzba.zza);
    public static zzem<Long> zzq = zza("measurement.upload.backoff_period", 43200000L, 43200000L, zzaz.zza);
    public static zzem<Long> zzr = zza("measurement.upload.window_interval", 3600000L, 3600000L, zzbc.zza);
    public static zzem<Long> zzs = zza("measurement.upload.interval", 3600000L, 3600000L, zzbb.zza);
    public static zzem<Long> zzt = zza("measurement.upload.realtime_upload_interval", 10000L, 10000L, zzbe.zza);
    public static zzem<Long> zzu = zza("measurement.upload.debug_upload_interval", 1000L, 1000L, zzbg.zza);
    public static zzem<Long> zzv = zza("measurement.upload.minimum_delay", 500L, 500L, zzbf.zza);
    public static zzem<Long> zzw;
    public static zzem<Long> zzx = zza("measurement.upload.stale_data_deletion_interval", 86400000L, 86400000L, zzbh.zza);
    public static zzem<Long> zzy = zza("measurement.upload.refresh_blacklisted_config_interval", 604800000L, 604800000L, zzbk.zza);
    public static zzem<Long> zzz = zza("measurement.upload.initial_upload_delay_time", 15000L, 15000L, zzbj.zza);

    public static Map<String, String> zza(Context context) {
        zzcc zza2 = zzcc.zza(context.getContentResolver(), zzcr.zza("com.google.android.gms.measurement"));
        return zza2 == null ? Collections.emptyMap() : zza2.zza();
    }

    private static <V> zzem<V> zza(String str, V v, V v2, zzek<V> zzek) {
        zzem zzem = new zzem(str, v, v2, zzek);
        zzcr.add(zzem);
        return zzem;
    }

    static final /* synthetic */ Long zzcn() {
        if (zzej.zza != null) {
            zzv zzv2 = zzej.zza;
        }
        return Long.valueOf(zzji.zzc());
    }

    static {
        Long valueOf = Long.valueOf(ExponentialBackoff.DEFAULT_BACKOFF_MAX_DELAY_MS);
        zzw = zza("measurement.alarm_manager.minimum_interval", valueOf, valueOf, zzbi.zza);
        Integer valueOf2 = Integer.valueOf(LogSeverity.ERROR_VALUE);
        zzag = zza("measurement.upload.max_event_name_cardinality", valueOf2, valueOf2, (zzek) null);
        Double valueOf3 = Double.valueOf(-3.0d);
        zzan = zza("measurement.test.double_flag", valueOf3, valueOf3, zzbv.zza);
    }
}
