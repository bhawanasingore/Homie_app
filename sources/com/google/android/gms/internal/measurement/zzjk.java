package com.google.android.gms.internal.measurement;

import com.google.firebase.firestore.util.ExponentialBackoff;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
public final class zzjk implements zzjl {
    private static final zzcq<Long> zza;
    private static final zzcq<Long> zzaa;
    private static final zzcq<Long> zzab;
    private static final zzcq<Long> zzac;
    private static final zzcq<Long> zzad;
    private static final zzcq<Long> zzae;
    private static final zzcq<Long> zzaf;
    private static final zzcq<Long> zzag;
    private static final zzcq<Long> zzah;
    private static final zzcq<String> zzai;
    private static final zzcq<Long> zzaj;
    private static final zzcq<Long> zzb;
    private static final zzcq<String> zzc;
    private static final zzcq<String> zzd;
    private static final zzcq<String> zze;
    private static final zzcq<Long> zzf;
    private static final zzcq<Long> zzg;
    private static final zzcq<Long> zzh;
    private static final zzcq<Long> zzi;
    private static final zzcq<Long> zzj;
    private static final zzcq<Long> zzk;
    private static final zzcq<Long> zzl;
    private static final zzcq<Long> zzm;
    private static final zzcq<Long> zzn;
    private static final zzcq<Long> zzo;
    private static final zzcq<Long> zzp;
    private static final zzcq<Long> zzq;
    private static final zzcq<String> zzr;
    private static final zzcq<Long> zzs;
    private static final zzcq<Long> zzt;
    private static final zzcq<Long> zzu;
    private static final zzcq<Long> zzv;
    private static final zzcq<Long> zzw;
    private static final zzcq<Long> zzx;
    private static final zzcq<Long> zzy;
    private static final zzcq<Long> zzz;

    public final long zza() {
        return zza.zzc().longValue();
    }

    public final long zzb() {
        return zzb.zzc().longValue();
    }

    public final String zzc() {
        return zzd.zzc();
    }

    public final String zzd() {
        return zze.zzc();
    }

    public final long zze() {
        return zzf.zzc().longValue();
    }

    public final long zzf() {
        return zzg.zzc().longValue();
    }

    public final long zzg() {
        return zzh.zzc().longValue();
    }

    public final long zzh() {
        return zzi.zzc().longValue();
    }

    public final long zzi() {
        return zzj.zzc().longValue();
    }

    public final long zzj() {
        return zzk.zzc().longValue();
    }

    public final long zzk() {
        return zzl.zzc().longValue();
    }

    public final long zzl() {
        return zzm.zzc().longValue();
    }

    public final long zzm() {
        return zzn.zzc().longValue();
    }

    public final long zzn() {
        return zzo.zzc().longValue();
    }

    public final long zzo() {
        return zzq.zzc().longValue();
    }

    public final long zzp() {
        return zzs.zzc().longValue();
    }

    public final long zzq() {
        return zzt.zzc().longValue();
    }

    public final long zzr() {
        return zzu.zzc().longValue();
    }

    public final long zzs() {
        return zzv.zzc().longValue();
    }

    public final long zzt() {
        return zzw.zzc().longValue();
    }

    public final long zzu() {
        return zzx.zzc().longValue();
    }

    public final long zzv() {
        return zzy.zzc().longValue();
    }

    public final long zzw() {
        return zzz.zzc().longValue();
    }

    public final long zzx() {
        return zzaa.zzc().longValue();
    }

    public final long zzy() {
        return zzab.zzc().longValue();
    }

    public final long zzz() {
        return zzac.zzc().longValue();
    }

    public final long zzaa() {
        return zzad.zzc().longValue();
    }

    public final long zzab() {
        return zzae.zzc().longValue();
    }

    public final long zzac() {
        return zzaf.zzc().longValue();
    }

    public final long zzad() {
        return zzag.zzc().longValue();
    }

    public final long zzae() {
        return zzah.zzc().longValue();
    }

    public final String zzaf() {
        return zzai.zzc();
    }

    public final long zzag() {
        return zzaj.zzc().longValue();
    }

    static {
        zzcw zzcw = new zzcw(zzcr.zza("com.google.android.gms.measurement"));
        zza = zzcw.zza("measurement.ad_id_cache_time", 10000);
        zzb = zzcw.zza("measurement.config.cache_time", 86400000);
        zzc = zzcw.zza("measurement.log_tag", "FA");
        zzd = zzcw.zza("measurement.config.url_authority", "app-measurement.com");
        zze = zzcw.zza("measurement.config.url_scheme", "https");
        zzf = zzcw.zza("measurement.upload.debug_upload_interval", 1000);
        zzg = zzcw.zza("measurement.lifetimevalue.max_currency_tracked", 4);
        zzh = zzcw.zza("measurement.store.max_stored_events_per_app", 100000);
        zzi = zzcw.zza("measurement.experiment.max_ids", 50);
        zzj = zzcw.zza("measurement.audience.filter_result_max_count", 200);
        zzk = zzcw.zza("measurement.alarm_manager.minimum_interval", (long) ExponentialBackoff.DEFAULT_BACKOFF_MAX_DELAY_MS);
        zzl = zzcw.zza("measurement.upload.minimum_delay", 500);
        zzm = zzcw.zza("measurement.monitoring.sample_period_millis", 86400000);
        zzn = zzcw.zza("measurement.upload.realtime_upload_interval", 10000);
        zzo = zzcw.zza("measurement.upload.refresh_blacklisted_config_interval", 604800000);
        zzp = zzcw.zza("measurement.config.cache_time.service", 3600000);
        zzq = zzcw.zza("measurement.service_client.idle_disconnect_millis", 5000);
        zzr = zzcw.zza("measurement.log_tag.service", "FA-SVC");
        zzs = zzcw.zza("measurement.upload.stale_data_deletion_interval", 86400000);
        zzt = zzcw.zza("measurement.upload.backoff_period", 43200000);
        zzu = zzcw.zza("measurement.upload.initial_upload_delay_time", 15000);
        zzv = zzcw.zza("measurement.upload.interval", 3600000);
        zzw = zzcw.zza("measurement.upload.max_bundle_size", 65536);
        zzx = zzcw.zza("measurement.upload.max_bundles", 100);
        zzy = zzcw.zza("measurement.upload.max_conversions_per_day", 500);
        zzz = zzcw.zza("measurement.upload.max_error_events_per_day", 1000);
        zzaa = zzcw.zza("measurement.upload.max_events_per_bundle", 1000);
        zzab = zzcw.zza("measurement.upload.max_events_per_day", 100000);
        zzac = zzcw.zza("measurement.upload.max_public_events_per_day", 50000);
        zzad = zzcw.zza("measurement.upload.max_queue_time", 2419200000L);
        zzae = zzcw.zza("measurement.upload.max_realtime_events_per_day", 10);
        zzaf = zzcw.zza("measurement.upload.max_batch_size", 65536);
        zzag = zzcw.zza("measurement.upload.retry_count", 6);
        zzah = zzcw.zza("measurement.upload.retry_time", 1800000);
        zzai = zzcw.zza("measurement.upload.url", "https://app-measurement.com/a");
        zzaj = zzcw.zza("measurement.upload.window_interval", 3600000);
    }
}
