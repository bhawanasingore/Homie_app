package com.google.firebase.auth.internal;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.internal.firebase_auth.zzbg;
import com.google.android.gms.internal.firebase_auth.zzfy;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/* compiled from: com.google.firebase:firebase-auth@@19.3.1 */
public final class zzau {
    private static long zza = 3600000;
    private static final zzbg<String> zzb = zzbg.zza("firebaseAppName", "firebaseUserUid", "operation", "tenantId", "verifyAssertionRequest", "statusCode", "statusMessage", "timestamp");
    private static final zzau zzc = new zzau();
    private Task<AuthResult> zzd;
    private long zze = 0;

    private zzau() {
    }

    public static zzau zza() {
        return zzc;
    }

    public static void zza(Context context, FirebaseAuth firebaseAuth) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(firebaseAuth);
        SharedPreferences.Editor edit = context.getSharedPreferences("com.google.firebase.auth.internal.ProcessDeathHelper", 0).edit();
        edit.putString("firebaseAppName", firebaseAuth.zzb().getName());
        edit.commit();
    }

    public static void zza(Context context, FirebaseAuth firebaseAuth, FirebaseUser firebaseUser) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(firebaseAuth);
        Preconditions.checkNotNull(firebaseUser);
        SharedPreferences.Editor edit = context.getSharedPreferences("com.google.firebase.auth.internal.ProcessDeathHelper", 0).edit();
        edit.putString("firebaseAppName", firebaseAuth.zzb().getName());
        edit.putString("firebaseUserUid", firebaseUser.getUid());
        edit.commit();
    }

    public static void zza(Context context, zzfy zzfy, String str, String str2) {
        SharedPreferences.Editor edit = context.getSharedPreferences("com.google.firebase.auth.internal.ProcessDeathHelper", 0).edit();
        edit.putString("verifyAssertionRequest", SafeParcelableSerializer.serializeToString(zzfy));
        edit.putString("operation", str);
        edit.putString("tenantId", str2);
        edit.putLong("timestamp", DefaultClock.getInstance().currentTimeMillis());
        edit.commit();
    }

    public static void zza(Context context, Status status) {
        SharedPreferences.Editor edit = context.getSharedPreferences("com.google.firebase.auth.internal.ProcessDeathHelper", 0).edit();
        edit.putInt("statusCode", status.getStatusCode());
        edit.putString("statusMessage", status.getStatusMessage());
        edit.putLong("timestamp", DefaultClock.getInstance().currentTimeMillis());
        edit.commit();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0081, code lost:
        if (r4.equals("com.google.firebase.auth.internal.SIGN_IN") == false) goto L_0x0098;
     */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00e4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(com.google.firebase.auth.FirebaseAuth r12) {
        /*
            r11 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r12)
            com.google.firebase.FirebaseApp r0 = r12.zzb()
            android.content.Context r0 = r0.getApplicationContext()
            java.lang.String r1 = "com.google.firebase.auth.internal.ProcessDeathHelper"
            r2 = 0
            android.content.SharedPreferences r0 = r0.getSharedPreferences(r1, r2)
            java.lang.String r1 = "firebaseAppName"
            java.lang.String r3 = ""
            java.lang.String r1 = r0.getString(r1, r3)
            com.google.firebase.FirebaseApp r4 = r12.zzb()
            java.lang.String r4 = r4.getName()
            boolean r1 = r4.equals(r1)
            if (r1 != 0) goto L_0x002a
            return
        L_0x002a:
            java.lang.String r1 = "verifyAssertionRequest"
            boolean r4 = r0.contains(r1)
            r5 = 0
            java.lang.String r7 = "timestamp"
            if (r4 == 0) goto L_0x00f4
            java.lang.String r1 = r0.getString(r1, r3)
            android.os.Parcelable$Creator<com.google.android.gms.internal.firebase_auth.zzfy> r4 = com.google.android.gms.internal.firebase_auth.zzfy.CREATOR
            com.google.android.gms.common.internal.safeparcel.SafeParcelable r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer.deserializeFromString(r1, r4)
            com.google.android.gms.internal.firebase_auth.zzfy r1 = (com.google.android.gms.internal.firebase_auth.zzfy) r1
            java.lang.String r4 = "operation"
            java.lang.String r4 = r0.getString(r4, r3)
            java.lang.String r8 = "tenantId"
            r9 = 0
            java.lang.String r8 = r0.getString(r8, r9)
            java.lang.String r10 = "firebaseUserUid"
            java.lang.String r3 = r0.getString(r10, r3)
            long r5 = r0.getLong(r7, r5)
            r11.zze = r5
            if (r8 == 0) goto L_0x0064
            r12.zza((java.lang.String) r8)
            r1.zzb((java.lang.String) r8)
        L_0x0064:
            r5 = -1
            int r6 = r4.hashCode()
            r7 = -1843829902(0xffffffff92196372, float:-4.8400863E-28)
            r8 = 2
            r10 = 1
            if (r6 == r7) goto L_0x008e
            r7 = -286760092(0xffffffffeee86364, float:-3.596034E28)
            if (r6 == r7) goto L_0x0084
            r7 = 1731327805(0x6731f73d, float:8.404196E23)
            if (r6 == r7) goto L_0x007b
        L_0x007a:
            goto L_0x0098
        L_0x007b:
            java.lang.String r6 = "com.google.firebase.auth.internal.SIGN_IN"
            boolean r4 = r4.equals(r6)
            if (r4 == 0) goto L_0x007a
            goto L_0x0099
        L_0x0084:
            java.lang.String r2 = "com.google.firebase.auth.internal.LINK"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x007a
            r2 = r10
            goto L_0x0099
        L_0x008e:
            java.lang.String r2 = "com.google.firebase.auth.internal.REAUTHENTICATE"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x007a
            r2 = r8
            goto L_0x0099
        L_0x0098:
            r2 = r5
        L_0x0099:
            if (r2 == 0) goto L_0x00e4
            if (r2 == r10) goto L_0x00c3
            if (r2 == r8) goto L_0x00a2
            r11.zzd = r9
            goto L_0x00f0
        L_0x00a2:
            com.google.firebase.auth.FirebaseUser r2 = r12.getCurrentUser()
            java.lang.String r2 = r2.getUid()
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x00c0
            com.google.firebase.auth.FirebaseUser r12 = r12.getCurrentUser()
            com.google.firebase.auth.zzc r1 = com.google.firebase.auth.zzc.zza(r1)
            com.google.android.gms.tasks.Task r12 = r12.reauthenticateAndRetrieveData(r1)
            r11.zzd = r12
            goto L_0x00f0
        L_0x00c0:
            r11.zzd = r9
            goto L_0x00f0
        L_0x00c3:
            com.google.firebase.auth.FirebaseUser r2 = r12.getCurrentUser()
            java.lang.String r2 = r2.getUid()
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x00e1
            com.google.firebase.auth.FirebaseUser r12 = r12.getCurrentUser()
            com.google.firebase.auth.zzc r1 = com.google.firebase.auth.zzc.zza(r1)
            com.google.android.gms.tasks.Task r12 = r12.linkWithCredential(r1)
            r11.zzd = r12
            goto L_0x00f0
        L_0x00e1:
            r11.zzd = r9
            goto L_0x00f0
        L_0x00e4:
            com.google.firebase.auth.zzc r1 = com.google.firebase.auth.zzc.zza(r1)
            com.google.android.gms.tasks.Task r12 = r12.signInWithCredential(r1)
            r11.zzd = r12
        L_0x00f0:
            zza((android.content.SharedPreferences) r0)
            return
        L_0x00f4:
            java.lang.String r12 = "statusCode"
            boolean r1 = r0.contains(r12)
            if (r1 == 0) goto L_0x0122
            r1 = 17062(0x42a6, float:2.3909E-41)
            int r12 = r0.getInt(r12, r1)
            java.lang.String r1 = "statusMessage"
            java.lang.String r1 = r0.getString(r1, r3)
            com.google.android.gms.common.api.Status r2 = new com.google.android.gms.common.api.Status
            r2.<init>(r12, r1)
            long r3 = r0.getLong(r7, r5)
            r11.zze = r3
            zza((android.content.SharedPreferences) r0)
            com.google.firebase.FirebaseException r12 = com.google.firebase.auth.api.internal.zzeh.zza((com.google.android.gms.common.api.Status) r2)
            com.google.android.gms.tasks.Task r12 = com.google.android.gms.tasks.Tasks.forException(r12)
            r11.zzd = r12
            return
        L_0x0122:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.auth.internal.zzau.zza(com.google.firebase.auth.FirebaseAuth):void");
    }

    public final Task<AuthResult> zzb() {
        if (DefaultClock.getInstance().currentTimeMillis() - this.zze < zza) {
            return this.zzd;
        }
        return null;
    }

    public final void zza(Context context) {
        Preconditions.checkNotNull(context);
        zza(context.getSharedPreferences("com.google.firebase.auth.internal.ProcessDeathHelper", 0));
        this.zzd = null;
        this.zze = 0;
    }

    private static void zza(SharedPreferences sharedPreferences) {
        SharedPreferences.Editor edit = sharedPreferences.edit();
        zzbg zzbg = zzb;
        int size = zzbg.size();
        int i = 0;
        while (i < size) {
            Object obj = zzbg.get(i);
            i++;
            edit.remove((String) obj);
        }
        edit.commit();
    }
}
