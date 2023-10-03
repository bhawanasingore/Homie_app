package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.measurement.zzaa;
import com.google.android.gms.internal.measurement.zzq;
import com.google.android.gms.internal.measurement.zzs;
import com.google.android.gms.internal.measurement.zzx;
import com.google.android.gms.internal.measurement.zzy;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-sdk@@17.4.1 */
public class AppMeasurementDynamiteService extends zzq {
    zzfx zza = null;
    private Map<Integer, zzha> zzb = new ArrayMap();

    /* compiled from: com.google.android.gms:play-services-measurement-sdk@@17.4.1 */
    class zza implements zzgx {
        private zzx zza;

        zza(zzx zzx) {
            this.zza = zzx;
        }

        public final void interceptEvent(String str, String str2, Bundle bundle, long j) {
            try {
                this.zza.zza(str, str2, bundle, j);
            } catch (RemoteException e) {
                AppMeasurementDynamiteService.this.zza.zzr().zzi().zza("Event interceptor threw exception", e);
            }
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement-sdk@@17.4.1 */
    class zzb implements zzha {
        private zzx zza;

        zzb(zzx zzx) {
            this.zza = zzx;
        }

        public final void onEvent(String str, String str2, Bundle bundle, long j) {
            try {
                this.zza.zza(str, str2, bundle, j);
            } catch (RemoteException e) {
                AppMeasurementDynamiteService.this.zza.zzr().zzi().zza("Event listener threw exception", e);
            }
        }
    }

    private final void zza() {
        if (this.zza == null) {
            throw new IllegalStateException("Attempting to perform action before initialize.");
        }
    }

    public void initialize(IObjectWrapper iObjectWrapper, zzaa zzaa, long j) throws RemoteException {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzfx zzfx = this.zza;
        if (zzfx == null) {
            this.zza = zzfx.zza(context, zzaa, Long.valueOf(j));
        } else {
            zzfx.zzr().zzi().zza("Attempting to initialize multiple times");
        }
    }

    public void logEvent(String str, String str2, Bundle bundle, boolean z, boolean z2, long j) throws RemoteException {
        zza();
        this.zza.zzh().zza(str, str2, bundle, z, z2, j);
    }

    public void setUserProperty(String str, String str2, IObjectWrapper iObjectWrapper, boolean z, long j) throws RemoteException {
        zza();
        this.zza.zzh().zza(str, str2, ObjectWrapper.unwrap(iObjectWrapper), z, j);
    }

    public void setUserId(String str, long j) throws RemoteException {
        zza();
        this.zza.zzh().zza((String) null, "_id", str, true, j);
    }

    public void setCurrentScreen(IObjectWrapper iObjectWrapper, String str, String str2, long j) throws RemoteException {
        zza();
        this.zza.zzv().zza((Activity) ObjectWrapper.unwrap(iObjectWrapper), str, str2);
    }

    public void setMeasurementEnabled(boolean z, long j) throws RemoteException {
        zza();
        this.zza.zzh().zza(z);
    }

    public void resetAnalyticsData(long j) throws RemoteException {
        zza();
        this.zza.zzh().zzd(j);
    }

    public void setMinimumSessionDuration(long j) throws RemoteException {
        zza();
        this.zza.zzh().zza(j);
    }

    public void setSessionTimeoutDuration(long j) throws RemoteException {
        zza();
        this.zza.zzh().zzb(j);
    }

    public void getMaxUserProperties(String str, zzs zzs) throws RemoteException {
        zza();
        this.zza.zzh();
        Preconditions.checkNotEmpty(str);
        this.zza.zzi().zza(zzs, 25);
    }

    public void getCurrentScreenName(zzs zzs) throws RemoteException {
        zza();
        zza(zzs, this.zza.zzh().zzaj());
    }

    public void getCurrentScreenClass(zzs zzs) throws RemoteException {
        zza();
        zza(zzs, this.zza.zzh().zzak());
    }

    public void getCachedAppInstanceId(zzs zzs) throws RemoteException {
        zza();
        zza(zzs, this.zza.zzh().zzah());
    }

    public void getAppInstanceId(zzs zzs) throws RemoteException {
        zza();
        this.zza.zzq().zza((Runnable) new zzi(this, zzs));
    }

    public void getGmpAppId(zzs zzs) throws RemoteException {
        zza();
        zza(zzs, this.zza.zzh().zzal());
    }

    public void generateEventId(zzs zzs) throws RemoteException {
        zza();
        this.zza.zzi().zza(zzs, this.zza.zzi().zzg());
    }

    public void beginAdUnitExposure(String str, long j) throws RemoteException {
        zza();
        this.zza.zzz().zza(str, j);
    }

    public void endAdUnitExposure(String str, long j) throws RemoteException {
        zza();
        this.zza.zzz().zzb(str, j);
    }

    public void initForTests(Map map) throws RemoteException {
        zza();
    }

    public void logEventAndBundle(String str, String str2, Bundle bundle, zzs zzs, long j) throws RemoteException {
        Bundle bundle2;
        zza();
        Preconditions.checkNotEmpty(str2);
        if (bundle == null) {
            bundle2 = new Bundle();
        }
        bundle2.putString("_o", "app");
        this.zza.zzq().zza((Runnable) new zzh(this, zzs, new zzaq(str2, new zzal(bundle), "app", j), str));
    }

    public void onActivityStarted(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        zza();
        zzhx zzhx = this.zza.zzh().zza;
        if (zzhx != null) {
            this.zza.zzh().zzab();
            zzhx.onActivityStarted((Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    public void onActivityStopped(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        zza();
        zzhx zzhx = this.zza.zzh().zza;
        if (zzhx != null) {
            this.zza.zzh().zzab();
            zzhx.onActivityStopped((Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    public void onActivityCreated(IObjectWrapper iObjectWrapper, Bundle bundle, long j) throws RemoteException {
        zza();
        zzhx zzhx = this.zza.zzh().zza;
        if (zzhx != null) {
            this.zza.zzh().zzab();
            zzhx.onActivityCreated((Activity) ObjectWrapper.unwrap(iObjectWrapper), bundle);
        }
    }

    public void onActivityDestroyed(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        zza();
        zzhx zzhx = this.zza.zzh().zza;
        if (zzhx != null) {
            this.zza.zzh().zzab();
            zzhx.onActivityDestroyed((Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    public void onActivityPaused(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        zza();
        zzhx zzhx = this.zza.zzh().zza;
        if (zzhx != null) {
            this.zza.zzh().zzab();
            zzhx.onActivityPaused((Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    public void onActivityResumed(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        zza();
        zzhx zzhx = this.zza.zzh().zza;
        if (zzhx != null) {
            this.zza.zzh().zzab();
            zzhx.onActivityResumed((Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    public void onActivitySaveInstanceState(IObjectWrapper iObjectWrapper, zzs zzs, long j) throws RemoteException {
        zza();
        zzhx zzhx = this.zza.zzh().zza;
        Bundle bundle = new Bundle();
        if (zzhx != null) {
            this.zza.zzh().zzab();
            zzhx.onActivitySaveInstanceState((Activity) ObjectWrapper.unwrap(iObjectWrapper), bundle);
        }
        try {
            zzs.zza(bundle);
        } catch (RemoteException e) {
            this.zza.zzr().zzi().zza("Error returning bundle value to wrapper", e);
        }
    }

    public void performAction(Bundle bundle, zzs zzs, long j) throws RemoteException {
        zza();
        zzs.zza((Bundle) null);
    }

    public void getUserProperties(String str, String str2, boolean z, zzs zzs) throws RemoteException {
        zza();
        this.zza.zzq().zza((Runnable) new zzk(this, zzs, str, str2, z));
    }

    public void logHealthData(int i, String str, IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) throws RemoteException {
        zza();
        Object obj = null;
        Object unwrap = iObjectWrapper == null ? null : ObjectWrapper.unwrap(iObjectWrapper);
        Object unwrap2 = iObjectWrapper2 == null ? null : ObjectWrapper.unwrap(iObjectWrapper2);
        if (iObjectWrapper3 != null) {
            obj = ObjectWrapper.unwrap(iObjectWrapper3);
        }
        this.zza.zzr().zza(i, true, false, str, unwrap, unwrap2, obj);
    }

    public void setEventInterceptor(zzx zzx) throws RemoteException {
        zza();
        zzhc zzh = this.zza.zzh();
        zza zza2 = new zza(zzx);
        zzh.zzb();
        zzh.zzw();
        zzh.zzq().zza((Runnable) new zzhm(zzh, zza2));
    }

    public void registerOnMeasurementEventListener(zzx zzx) throws RemoteException {
        zza();
        zzha zzha = this.zzb.get(Integer.valueOf(zzx.zza()));
        if (zzha == null) {
            zzha = new zzb(zzx);
            this.zzb.put(Integer.valueOf(zzx.zza()), zzha);
        }
        this.zza.zzh().zza(zzha);
    }

    public void unregisterOnMeasurementEventListener(zzx zzx) throws RemoteException {
        zza();
        zzha remove = this.zzb.remove(Integer.valueOf(zzx.zza()));
        if (remove == null) {
            remove = new zzb(zzx);
        }
        this.zza.zzh().zzb(remove);
    }

    public void setInstanceIdProvider(zzy zzy) throws RemoteException {
        zza();
    }

    public void setConditionalUserProperty(Bundle bundle, long j) throws RemoteException {
        zza();
        if (bundle == null) {
            this.zza.zzr().zzf().zza("Conditional user property must not be null");
        } else {
            this.zza.zzh().zza(bundle, j);
        }
    }

    public void clearConditionalUserProperty(String str, String str2, Bundle bundle) throws RemoteException {
        zza();
        this.zza.zzh().zzc(str, str2, bundle);
    }

    public void getConditionalUserProperties(String str, String str2, zzs zzs) throws RemoteException {
        zza();
        this.zza.zzq().zza((Runnable) new zzj(this, zzs, str, str2));
    }

    public void getTestFlag(zzs zzs, int i) throws RemoteException {
        zza();
        if (i == 0) {
            this.zza.zzi().zza(zzs, this.zza.zzh().zzad());
        } else if (i == 1) {
            this.zza.zzi().zza(zzs, this.zza.zzh().zzae().longValue());
        } else if (i == 2) {
            zzko zzi = this.zza.zzi();
            double doubleValue = this.zza.zzh().zzag().doubleValue();
            Bundle bundle = new Bundle();
            bundle.putDouble("r", doubleValue);
            try {
                zzs.zza(bundle);
            } catch (RemoteException e) {
                zzi.zzz.zzr().zzi().zza("Error returning double value to wrapper", e);
            }
        } else if (i == 3) {
            this.zza.zzi().zza(zzs, this.zza.zzh().zzaf().intValue());
        } else if (i == 4) {
            this.zza.zzi().zza(zzs, this.zza.zzh().zzac().booleanValue());
        }
    }

    private final void zza(zzs zzs, String str) {
        this.zza.zzi().zza(zzs, str);
    }

    public void setDataCollectionEnabled(boolean z) throws RemoteException {
        zza();
        this.zza.zzh().zzb(z);
    }

    public void isDataCollectionEnabled(zzs zzs) throws RemoteException {
        zza();
        this.zza.zzq().zza((Runnable) new zzl(this, zzs));
    }

    public void setDefaultEventParameters(Bundle bundle) {
        zza();
        zzhc zzh = this.zza.zzh();
        zzh.zzq().zza((Runnable) new zzhb(zzh, bundle == null ? null : new Bundle(bundle)));
    }
}
