package com.google.android.gms.measurement.internal;

import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
final class zzq extends zzkd {
    private String zzb;
    private Set<Integer> zzc;
    private Map<Integer, zzs> zzd;
    private Long zze;
    private Long zzf;

    zzq(zzkg zzkg) {
        super(zzkg);
    }

    /* access modifiers changed from: protected */
    public final boolean zze() {
        return false;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x02d9  */
    /* JADX WARNING: Removed duplicated region for block: B:259:0x02e0 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.google.android.gms.internal.measurement.zzbw.zza> zza(java.lang.String r47, java.util.List<com.google.android.gms.internal.measurement.zzbw.zzc> r48, java.util.List<com.google.android.gms.internal.measurement.zzbw.zzk> r49, java.lang.Long r50, java.lang.Long r51) {
        /*
            r46 = this;
            r10 = r46
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r47)
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r48)
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r49)
            r0 = r47
            r10.zzb = r0
            java.util.HashSet r0 = new java.util.HashSet
            r0.<init>()
            r10.zzc = r0
            androidx.collection.ArrayMap r0 = new androidx.collection.ArrayMap
            r0.<init>()
            r10.zzd = r0
            r0 = r50
            r10.zze = r0
            r0 = r51
            r10.zzf = r0
            java.util.Iterator r0 = r48.iterator()
        L_0x002a:
            boolean r1 = r0.hasNext()
            r11 = 0
            r12 = 1
            if (r1 == 0) goto L_0x0047
            java.lang.Object r1 = r0.next()
            com.google.android.gms.internal.measurement.zzbw$zzc r1 = (com.google.android.gms.internal.measurement.zzbw.zzc) r1
            java.lang.String r1 = r1.zzc()
            java.lang.String r2 = "_s"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L_0x0046
            r1 = r12
            goto L_0x0048
        L_0x0046:
            goto L_0x002a
        L_0x0047:
            r1 = r11
        L_0x0048:
            boolean r0 = com.google.android.gms.internal.measurement.zzkf.zzb()
            if (r0 == 0) goto L_0x0060
            com.google.android.gms.measurement.internal.zzaa r0 = r46.zzt()
            java.lang.String r2 = r10.zzb
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.zzas.zzbg
            boolean r0 = r0.zzd(r2, r3)
            if (r0 == 0) goto L_0x0060
            r13 = r12
            goto L_0x0061
        L_0x0060:
            r13 = r11
        L_0x0061:
            boolean r0 = com.google.android.gms.internal.measurement.zzkf.zzb()
            if (r0 == 0) goto L_0x0077
            com.google.android.gms.measurement.internal.zzaa r0 = r46.zzt()
            java.lang.String r2 = r10.zzb
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.zzas.zzbf
            boolean r0 = r0.zzd(r2, r3)
            if (r0 == 0) goto L_0x0077
            r14 = r12
            goto L_0x0078
        L_0x0077:
            r14 = r11
        L_0x0078:
            if (r1 == 0) goto L_0x00b9
            com.google.android.gms.measurement.internal.zzab r2 = r46.zzi()
            java.lang.String r3 = r10.zzb
            r2.zzak()
            r2.zzd()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r3)
            android.content.ContentValues r0 = new android.content.ContentValues
            r0.<init>()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r11)
            java.lang.String r5 = "current_session_count"
            r0.put(r5, r4)
            android.database.sqlite.SQLiteDatabase r4 = r2.c_()     // Catch:{ SQLiteException -> 0x00a7 }
            java.lang.String r5 = "events"
            java.lang.String r6 = "app_id = ?"
            java.lang.String[] r7 = new java.lang.String[r12]     // Catch:{ SQLiteException -> 0x00a7 }
            r7[r11] = r3     // Catch:{ SQLiteException -> 0x00a7 }
            r4.update(r5, r0, r6, r7)     // Catch:{ SQLiteException -> 0x00a7 }
            goto L_0x00b9
        L_0x00a7:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzet r2 = r2.zzr()
            com.google.android.gms.measurement.internal.zzev r2 = r2.zzf()
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzet.zza((java.lang.String) r3)
            java.lang.String r4 = "Error resetting session-scoped event counts. appId"
            r2.zza(r4, r3, r0)
        L_0x00b9:
            java.util.Map r0 = java.util.Collections.emptyMap()
            if (r14 == 0) goto L_0x00cb
            if (r13 == 0) goto L_0x00cb
            com.google.android.gms.measurement.internal.zzab r0 = r46.zzi()
            java.lang.String r2 = r10.zzb
            java.util.Map r0 = r0.zze(r2)
        L_0x00cb:
            com.google.android.gms.measurement.internal.zzab r2 = r46.zzi()
            java.lang.String r3 = r10.zzb
            java.util.Map r15 = r2.zzg(r3)
            if (r15 == 0) goto L_0x037f
            boolean r2 = r15.isEmpty()
            if (r2 == 0) goto L_0x00e0
            r11 = 0
            goto L_0x0380
        L_0x00e0:
            java.util.HashSet r2 = new java.util.HashSet
            java.util.Set r3 = r15.keySet()
            r2.<init>(r3)
            if (r1 == 0) goto L_0x01d9
            java.lang.String r1 = r10.zzb
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r1)
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r15)
            androidx.collection.ArrayMap r3 = new androidx.collection.ArrayMap
            r3.<init>()
            boolean r4 = r15.isEmpty()
            if (r4 != 0) goto L_0x01d6
            com.google.android.gms.measurement.internal.zzab r4 = r46.zzi()
            java.util.Map r1 = r4.zzf(r1)
            java.util.Set r4 = r15.keySet()
            java.util.Iterator r4 = r4.iterator()
        L_0x0111:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x01d6
            java.lang.Object r5 = r4.next()
            java.lang.Integer r5 = (java.lang.Integer) r5
            int r5 = r5.intValue()
            java.lang.Integer r6 = java.lang.Integer.valueOf(r5)
            java.lang.Object r6 = r15.get(r6)
            com.google.android.gms.internal.measurement.zzbw$zzi r6 = (com.google.android.gms.internal.measurement.zzbw.zzi) r6
            java.lang.Integer r7 = java.lang.Integer.valueOf(r5)
            java.lang.Object r7 = r1.get(r7)
            java.util.List r7 = (java.util.List) r7
            if (r7 == 0) goto L_0x01cc
            boolean r8 = r7.isEmpty()
            if (r8 == 0) goto L_0x013f
            goto L_0x01cc
        L_0x013f:
            com.google.android.gms.measurement.internal.zzkk r8 = r46.zzg()
            java.util.List r9 = r6.zzc()
            java.util.List r8 = r8.zza((java.util.List<java.lang.Long>) r9, (java.util.List<java.lang.Integer>) r7)
            boolean r9 = r8.isEmpty()
            if (r9 != 0) goto L_0x01c9
            com.google.android.gms.internal.measurement.zzfi$zzb r9 = r6.zzbm()
            com.google.android.gms.internal.measurement.zzfi$zzb r9 = (com.google.android.gms.internal.measurement.zzfi.zzb) r9
            com.google.android.gms.internal.measurement.zzbw$zzi$zza r9 = (com.google.android.gms.internal.measurement.zzbw.zzi.zza) r9
            com.google.android.gms.internal.measurement.zzbw$zzi$zza r9 = r9.zzb()
            com.google.android.gms.internal.measurement.zzbw$zzi$zza r8 = r9.zzb((java.lang.Iterable<? extends java.lang.Long>) r8)
            com.google.android.gms.measurement.internal.zzkk r9 = r46.zzg()
            java.util.List r11 = r6.zza()
            java.util.List r9 = r9.zza((java.util.List<java.lang.Long>) r11, (java.util.List<java.lang.Integer>) r7)
            com.google.android.gms.internal.measurement.zzbw$zzi$zza r11 = r8.zza()
            r11.zza((java.lang.Iterable<? extends java.lang.Long>) r9)
            r9 = 0
        L_0x0178:
            int r11 = r6.zzf()
            if (r9 >= r11) goto L_0x0197
            com.google.android.gms.internal.measurement.zzbw$zzb r11 = r6.zza((int) r9)
            int r11 = r11.zzb()
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            boolean r11 = r7.contains(r11)
            if (r11 == 0) goto L_0x0194
            r8.zza((int) r9)
        L_0x0194:
            int r9 = r9 + 1
            goto L_0x0178
        L_0x0197:
            r9 = 0
        L_0x0198:
            int r11 = r6.zzh()
            if (r9 >= r11) goto L_0x01b7
            com.google.android.gms.internal.measurement.zzbw$zzj r11 = r6.zzb((int) r9)
            int r11 = r11.zzb()
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            boolean r11 = r7.contains(r11)
            if (r11 == 0) goto L_0x01b4
            r8.zzb((int) r9)
        L_0x01b4:
            int r9 = r9 + 1
            goto L_0x0198
        L_0x01b7:
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            com.google.android.gms.internal.measurement.zzgt r6 = r8.zzu()
            com.google.android.gms.internal.measurement.zzfi r6 = (com.google.android.gms.internal.measurement.zzfi) r6
            com.google.android.gms.internal.measurement.zzbw$zzi r6 = (com.google.android.gms.internal.measurement.zzbw.zzi) r6
            r3.put(r5, r6)
            r11 = 0
            goto L_0x0111
        L_0x01c9:
            r11 = 0
            goto L_0x0111
        L_0x01cc:
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r3.put(r5, r6)
            r11 = 0
            goto L_0x0111
        L_0x01d6:
            r11 = r3
            goto L_0x01da
        L_0x01d9:
            r11 = r15
        L_0x01da:
            java.util.Iterator r16 = r2.iterator()
        L_0x01de:
            boolean r1 = r16.hasNext()
            if (r1 == 0) goto L_0x037d
            java.lang.Object r1 = r16.next()
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r17 = r1.intValue()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r17)
            java.lang.Object r1 = r11.get(r1)
            com.google.android.gms.internal.measurement.zzbw$zzi r1 = (com.google.android.gms.internal.measurement.zzbw.zzi) r1
            java.util.BitSet r5 = new java.util.BitSet
            r5.<init>()
            java.util.BitSet r6 = new java.util.BitSet
            r6.<init>()
            androidx.collection.ArrayMap r7 = new androidx.collection.ArrayMap
            r7.<init>()
            if (r1 == 0) goto L_0x024a
            int r2 = r1.zzf()
            if (r2 != 0) goto L_0x0212
            goto L_0x024a
        L_0x0212:
            java.util.List r2 = r1.zze()
            java.util.Iterator r2 = r2.iterator()
        L_0x021a:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0249
            java.lang.Object r3 = r2.next()
            com.google.android.gms.internal.measurement.zzbw$zzb r3 = (com.google.android.gms.internal.measurement.zzbw.zzb) r3
            boolean r4 = r3.zza()
            if (r4 == 0) goto L_0x0248
            int r4 = r3.zzb()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            boolean r8 = r3.zzc()
            if (r8 == 0) goto L_0x0244
            long r8 = r3.zzd()
            java.lang.Long r3 = java.lang.Long.valueOf(r8)
            goto L_0x0245
        L_0x0244:
            r3 = 0
        L_0x0245:
            r7.put(r4, r3)
        L_0x0248:
            goto L_0x021a
        L_0x0249:
            goto L_0x024b
        L_0x024a:
        L_0x024b:
            androidx.collection.ArrayMap r8 = new androidx.collection.ArrayMap
            r8.<init>()
            if (r1 == 0) goto L_0x0297
            int r2 = r1.zzh()
            if (r2 != 0) goto L_0x025c
            goto L_0x0297
        L_0x025c:
            java.util.List r2 = r1.zzg()
            java.util.Iterator r2 = r2.iterator()
        L_0x0264:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0296
            java.lang.Object r3 = r2.next()
            com.google.android.gms.internal.measurement.zzbw$zzj r3 = (com.google.android.gms.internal.measurement.zzbw.zzj) r3
            boolean r4 = r3.zza()
            if (r4 == 0) goto L_0x0295
            int r4 = r3.zzd()
            if (r4 <= 0) goto L_0x0295
            int r4 = r3.zzb()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            int r9 = r3.zzd()
            int r9 = r9 - r12
            long r18 = r3.zza((int) r9)
            java.lang.Long r3 = java.lang.Long.valueOf(r18)
            r8.put(r4, r3)
        L_0x0295:
            goto L_0x0264
        L_0x0296:
            goto L_0x0298
        L_0x0297:
        L_0x0298:
            if (r1 == 0) goto L_0x02e4
            r2 = 0
        L_0x029c:
            int r3 = r1.zzb()
            int r3 = r3 << 6
            if (r2 >= r3) goto L_0x02e4
            java.util.List r3 = r1.zza()
            boolean r3 = com.google.android.gms.measurement.internal.zzkk.zza((java.util.List<java.lang.Long>) r3, (int) r2)
            if (r3 == 0) goto L_0x02d6
            com.google.android.gms.measurement.internal.zzet r3 = r46.zzr()
            com.google.android.gms.measurement.internal.zzev r3 = r3.zzx()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r17)
            java.lang.Integer r9 = java.lang.Integer.valueOf(r2)
            java.lang.String r12 = "Filter already evaluated. audience ID, filter ID"
            r3.zza(r12, r4, r9)
            r6.set(r2)
            java.util.List r3 = r1.zzc()
            boolean r3 = com.google.android.gms.measurement.internal.zzkk.zza((java.util.List<java.lang.Long>) r3, (int) r2)
            if (r3 == 0) goto L_0x02d6
            r5.set(r2)
            r3 = 1
            goto L_0x02d7
        L_0x02d6:
            r3 = 0
        L_0x02d7:
            if (r3 != 0) goto L_0x02e0
            java.lang.Integer r3 = java.lang.Integer.valueOf(r2)
            r7.remove(r3)
        L_0x02e0:
            int r2 = r2 + 1
            r12 = 1
            goto L_0x029c
        L_0x02e4:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r17)
            java.lang.Object r1 = r15.get(r1)
            r4 = r1
            com.google.android.gms.internal.measurement.zzbw$zzi r4 = (com.google.android.gms.internal.measurement.zzbw.zzi) r4
            if (r14 == 0) goto L_0x0361
            if (r13 == 0) goto L_0x0361
            java.lang.Integer r1 = java.lang.Integer.valueOf(r17)
            java.lang.Object r1 = r0.get(r1)
            java.util.List r1 = (java.util.List) r1
            if (r1 == 0) goto L_0x0361
            java.lang.Long r2 = r10.zzf
            if (r2 == 0) goto L_0x0361
            java.lang.Long r2 = r10.zze
            if (r2 != 0) goto L_0x030a
            goto L_0x0361
        L_0x030a:
            java.util.Iterator r1 = r1.iterator()
        L_0x030e:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0361
            java.lang.Object r2 = r1.next()
            com.google.android.gms.internal.measurement.zzbo$zzb r2 = (com.google.android.gms.internal.measurement.zzbo.zzb) r2
            int r3 = r2.zzb()
            java.lang.Long r9 = r10.zzf
            long r18 = r9.longValue()
            r20 = 1000(0x3e8, double:4.94E-321)
            long r18 = r18 / r20
            boolean r2 = r2.zzi()
            if (r2 == 0) goto L_0x0336
            java.lang.Long r2 = r10.zze
            long r18 = r2.longValue()
            long r18 = r18 / r20
        L_0x0336:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r3)
            boolean r2 = r7.containsKey(r2)
            if (r2 == 0) goto L_0x034b
            java.lang.Integer r2 = java.lang.Integer.valueOf(r3)
            java.lang.Long r9 = java.lang.Long.valueOf(r18)
            r7.put(r2, r9)
        L_0x034b:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r3)
            boolean r2 = r8.containsKey(r2)
            if (r2 == 0) goto L_0x0360
            java.lang.Integer r2 = java.lang.Integer.valueOf(r3)
            java.lang.Long r3 = java.lang.Long.valueOf(r18)
            r8.put(r2, r3)
        L_0x0360:
            goto L_0x030e
        L_0x0361:
            com.google.android.gms.measurement.internal.zzs r12 = new com.google.android.gms.measurement.internal.zzs
            java.lang.String r3 = r10.zzb
            r9 = 0
            r1 = r12
            r2 = r46
            r18 = r11
            r11 = 0
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9)
            java.util.Map<java.lang.Integer, com.google.android.gms.measurement.internal.zzs> r1 = r10.zzd
            java.lang.Integer r2 = java.lang.Integer.valueOf(r17)
            r1.put(r2, r12)
            r11 = r18
            r12 = 1
            goto L_0x01de
        L_0x037d:
            r11 = 0
            goto L_0x0381
        L_0x037f:
            r11 = 0
        L_0x0380:
        L_0x0381:
            boolean r0 = r48.isEmpty()
            java.lang.String r1 = "Skipping failed audience ID"
            if (r0 != 0) goto L_0x0513
            com.google.android.gms.measurement.internal.zzr r0 = new com.google.android.gms.measurement.internal.zzr
            r0.<init>(r10, r11)
            androidx.collection.ArrayMap r2 = new androidx.collection.ArrayMap
            r2.<init>()
            java.util.Iterator r3 = r48.iterator()
        L_0x0398:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0513
            java.lang.Object r4 = r3.next()
            com.google.android.gms.internal.measurement.zzbw$zzc r4 = (com.google.android.gms.internal.measurement.zzbw.zzc) r4
            java.lang.String r5 = r10.zzb
            com.google.android.gms.internal.measurement.zzbw$zzc r5 = r0.zza(r5, r4)
            if (r5 == 0) goto L_0x050e
            com.google.android.gms.measurement.internal.zzab r6 = r46.zzi()
            java.lang.String r13 = r10.zzb
            java.lang.String r7 = r5.zzc()
            java.lang.String r8 = r4.zzc()
            com.google.android.gms.measurement.internal.zzam r8 = r6.zza((java.lang.String) r13, (java.lang.String) r8)
            if (r8 != 0) goto L_0x03f9
            com.google.android.gms.measurement.internal.zzet r8 = r6.zzr()
            com.google.android.gms.measurement.internal.zzev r8 = r8.zzi()
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzet.zza((java.lang.String) r13)
            com.google.android.gms.measurement.internal.zzer r6 = r6.zzo()
            java.lang.String r6 = r6.zza((java.lang.String) r7)
            java.lang.String r7 = "Event aggregate wasn't created during raw event logging. appId, event"
            r8.zza(r7, r9, r6)
            com.google.android.gms.measurement.internal.zzam r6 = new com.google.android.gms.measurement.internal.zzam
            r12 = r6
            java.lang.String r14 = r4.zzc()
            r15 = 1
            r17 = 1
            r19 = 1
            long r21 = r4.zze()
            r23 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r28 = 0
            r12.<init>(r13, r14, r15, r17, r19, r21, r23, r25, r26, r27, r28)
            goto L_0x0430
        L_0x03f9:
            com.google.android.gms.measurement.internal.zzam r6 = new com.google.android.gms.measurement.internal.zzam
            r29 = r6
            java.lang.String r4 = r8.zza
            r30 = r4
            java.lang.String r4 = r8.zzb
            r31 = r4
            long r12 = r8.zzc
            r14 = 1
            long r32 = r12 + r14
            long r12 = r8.zzd
            long r34 = r12 + r14
            long r12 = r8.zze
            long r36 = r12 + r14
            long r12 = r8.zzf
            r38 = r12
            long r12 = r8.zzg
            r40 = r12
            java.lang.Long r4 = r8.zzh
            r42 = r4
            java.lang.Long r4 = r8.zzi
            r43 = r4
            java.lang.Long r4 = r8.zzj
            r44 = r4
            java.lang.Boolean r4 = r8.zzk
            r45 = r4
            r29.<init>(r30, r31, r32, r34, r36, r38, r40, r42, r43, r44, r45)
        L_0x0430:
            com.google.android.gms.measurement.internal.zzab r4 = r46.zzi()
            r4.zza((com.google.android.gms.measurement.internal.zzam) r6)
            long r7 = r6.zzc
            java.lang.String r4 = r5.zzc()
            java.lang.Object r9 = r2.get(r4)
            java.util.Map r9 = (java.util.Map) r9
            if (r9 != 0) goto L_0x045c
            com.google.android.gms.measurement.internal.zzab r9 = r46.zzi()
            java.lang.String r12 = r10.zzb
            java.util.Map r9 = r9.zzf(r12, r4)
            if (r9 != 0) goto L_0x0459
            androidx.collection.ArrayMap r9 = new androidx.collection.ArrayMap
            r9.<init>()
        L_0x0459:
            r2.put(r4, r9)
        L_0x045c:
            java.util.Set r4 = r9.keySet()
            java.util.Iterator r4 = r4.iterator()
        L_0x0466:
            boolean r12 = r4.hasNext()
            if (r12 == 0) goto L_0x0509
            java.lang.Object r12 = r4.next()
            java.lang.Integer r12 = (java.lang.Integer) r12
            int r15 = r12.intValue()
            java.util.Set<java.lang.Integer> r12 = r10.zzc
            java.lang.Integer r13 = java.lang.Integer.valueOf(r15)
            boolean r12 = r12.contains(r13)
            if (r12 == 0) goto L_0x0492
            com.google.android.gms.measurement.internal.zzet r12 = r46.zzr()
            com.google.android.gms.measurement.internal.zzev r12 = r12.zzx()
            java.lang.Integer r13 = java.lang.Integer.valueOf(r15)
            r12.zza(r1, r13)
            goto L_0x0466
        L_0x0492:
            java.lang.Integer r12 = java.lang.Integer.valueOf(r15)
            java.lang.Object r12 = r9.get(r12)
            java.util.List r12 = (java.util.List) r12
            java.util.Iterator r20 = r12.iterator()
            r12 = 1
        L_0x04a2:
            boolean r13 = r20.hasNext()
            if (r13 == 0) goto L_0x04f6
            java.lang.Object r12 = r20.next()
            com.google.android.gms.internal.measurement.zzbo$zzb r12 = (com.google.android.gms.internal.measurement.zzbo.zzb) r12
            com.google.android.gms.measurement.internal.zzu r14 = new com.google.android.gms.measurement.internal.zzu
            java.lang.String r13 = r10.zzb
            r14.<init>(r10, r13, r15, r12)
            java.lang.Long r13 = r10.zze
            java.lang.Long r11 = r10.zzf
            int r12 = r12.zzb()
            boolean r19 = r10.zza(r15, r12)
            r12 = r14
            r21 = r0
            r0 = r14
            r14 = r11
            r11 = r15
            r15 = r5
            r16 = r7
            r18 = r6
            boolean r12 = r12.zza(r13, r14, r15, r16, r18, r19)
            com.google.android.gms.measurement.internal.zzaa r13 = r46.zzt()
            java.lang.String r14 = r10.zzb
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r15 = com.google.android.gms.measurement.internal.zzas.zzbd
            boolean r13 = r13.zzd(r14, r15)
            if (r13 == 0) goto L_0x04ea
            if (r12 != 0) goto L_0x04ea
            java.util.Set<java.lang.Integer> r0 = r10.zzc
            java.lang.Integer r13 = java.lang.Integer.valueOf(r11)
            r0.add(r13)
            goto L_0x04f9
        L_0x04ea:
            com.google.android.gms.measurement.internal.zzs r13 = r10.zza(r11)
            r13.zza((com.google.android.gms.measurement.internal.zzt) r0)
            r15 = r11
            r0 = r21
            r11 = 0
            goto L_0x04a2
        L_0x04f6:
            r21 = r0
            r11 = r15
        L_0x04f9:
            if (r12 != 0) goto L_0x0504
            java.util.Set<java.lang.Integer> r0 = r10.zzc
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            r0.add(r11)
        L_0x0504:
            r0 = r21
            r11 = 0
            goto L_0x0466
        L_0x0509:
            r21 = r0
            r11 = 0
            goto L_0x0398
        L_0x050e:
            r21 = r0
            r11 = 0
            goto L_0x0398
        L_0x0513:
            boolean r0 = r49.isEmpty()
            if (r0 != 0) goto L_0x0671
            androidx.collection.ArrayMap r0 = new androidx.collection.ArrayMap
            r0.<init>()
            java.util.Iterator r2 = r49.iterator()
        L_0x0523:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0671
            java.lang.Object r3 = r2.next()
            com.google.android.gms.internal.measurement.zzbw$zzk r3 = (com.google.android.gms.internal.measurement.zzbw.zzk) r3
            java.lang.String r4 = r3.zzc()
            java.lang.Object r5 = r0.get(r4)
            java.util.Map r5 = (java.util.Map) r5
            if (r5 != 0) goto L_0x0551
            com.google.android.gms.measurement.internal.zzab r5 = r46.zzi()
            java.lang.String r6 = r10.zzb
            java.util.Map r5 = r5.zzg(r6, r4)
            if (r5 != 0) goto L_0x054e
            androidx.collection.ArrayMap r5 = new androidx.collection.ArrayMap
            r5.<init>()
        L_0x054e:
            r0.put(r4, r5)
        L_0x0551:
            java.util.Set r4 = r5.keySet()
            java.util.Iterator r4 = r4.iterator()
        L_0x055b:
            boolean r6 = r4.hasNext()
            if (r6 == 0) goto L_0x066f
            java.lang.Object r6 = r4.next()
            java.lang.Integer r6 = (java.lang.Integer) r6
            int r6 = r6.intValue()
            java.util.Set<java.lang.Integer> r7 = r10.zzc
            java.lang.Integer r8 = java.lang.Integer.valueOf(r6)
            boolean r7 = r7.contains(r8)
            if (r7 == 0) goto L_0x0587
            com.google.android.gms.measurement.internal.zzet r3 = r46.zzr()
            com.google.android.gms.measurement.internal.zzev r3 = r3.zzx()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r6)
            r3.zza(r1, r4)
            goto L_0x0523
        L_0x0587:
            java.lang.Integer r7 = java.lang.Integer.valueOf(r6)
            java.lang.Object r7 = r5.get(r7)
            java.util.List r7 = (java.util.List) r7
            java.util.Iterator r7 = r7.iterator()
            r8 = 1
        L_0x0597:
            boolean r9 = r7.hasNext()
            if (r9 == 0) goto L_0x0662
            java.lang.Object r8 = r7.next()
            com.google.android.gms.internal.measurement.zzbo$zze r8 = (com.google.android.gms.internal.measurement.zzbo.zze) r8
            com.google.android.gms.measurement.internal.zzet r9 = r46.zzr()
            r11 = 2
            boolean r9 = r9.zza((int) r11)
            if (r9 == 0) goto L_0x05f0
            com.google.android.gms.measurement.internal.zzet r9 = r46.zzr()
            com.google.android.gms.measurement.internal.zzev r9 = r9.zzx()
            java.lang.Integer r11 = java.lang.Integer.valueOf(r6)
            boolean r12 = r8.zza()
            if (r12 == 0) goto L_0x05c9
            int r12 = r8.zzb()
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            goto L_0x05ca
        L_0x05c9:
            r12 = 0
        L_0x05ca:
            com.google.android.gms.measurement.internal.zzer r13 = r46.zzo()
            java.lang.String r14 = r8.zzc()
            java.lang.String r13 = r13.zzc(r14)
            java.lang.String r14 = "Evaluating filter. audience, filter, property"
            r9.zza(r14, r11, r12, r13)
            com.google.android.gms.measurement.internal.zzet r9 = r46.zzr()
            com.google.android.gms.measurement.internal.zzev r9 = r9.zzx()
            com.google.android.gms.measurement.internal.zzkk r11 = r46.zzg()
            java.lang.String r11 = r11.zza((com.google.android.gms.internal.measurement.zzbo.zze) r8)
            java.lang.String r12 = "Filter definition"
            r9.zza(r12, r11)
        L_0x05f0:
            boolean r9 = r8.zza()
            if (r9 == 0) goto L_0x0639
            int r9 = r8.zzb()
            r11 = 256(0x100, float:3.59E-43)
            if (r9 <= r11) goto L_0x05ff
            goto L_0x0639
        L_0x05ff:
            com.google.android.gms.measurement.internal.zzw r9 = new com.google.android.gms.measurement.internal.zzw
            java.lang.String r11 = r10.zzb
            r9.<init>(r10, r11, r6, r8)
            java.lang.Long r11 = r10.zze
            java.lang.Long r12 = r10.zzf
            int r8 = r8.zzb()
            boolean r8 = r10.zza(r6, r8)
            boolean r8 = r9.zza(r11, r12, r3, r8)
            com.google.android.gms.measurement.internal.zzaa r11 = r46.zzt()
            java.lang.String r12 = r10.zzb
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r13 = com.google.android.gms.measurement.internal.zzas.zzbd
            boolean r11 = r11.zzd(r12, r13)
            if (r11 == 0) goto L_0x0630
            if (r8 != 0) goto L_0x0630
            java.util.Set<java.lang.Integer> r7 = r10.zzc
            java.lang.Integer r9 = java.lang.Integer.valueOf(r6)
            r7.add(r9)
            goto L_0x0662
        L_0x0630:
            com.google.android.gms.measurement.internal.zzs r11 = r10.zza(r6)
            r11.zza((com.google.android.gms.measurement.internal.zzt) r9)
            goto L_0x0597
        L_0x0639:
            com.google.android.gms.measurement.internal.zzet r7 = r46.zzr()
            com.google.android.gms.measurement.internal.zzev r7 = r7.zzi()
            java.lang.String r9 = r10.zzb
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzet.zza((java.lang.String) r9)
            boolean r11 = r8.zza()
            if (r11 == 0) goto L_0x0656
            int r8 = r8.zzb()
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            goto L_0x0657
        L_0x0656:
            r8 = 0
        L_0x0657:
            java.lang.String r8 = java.lang.String.valueOf(r8)
            java.lang.String r11 = "Invalid property filter ID. appId, id"
            r7.zza(r11, r9, r8)
            r8 = 0
        L_0x0662:
            if (r8 != 0) goto L_0x066d
            java.util.Set<java.lang.Integer> r7 = r10.zzc
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            r7.add(r6)
        L_0x066d:
            goto L_0x055b
        L_0x066f:
            goto L_0x0523
        L_0x0671:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Map<java.lang.Integer, com.google.android.gms.measurement.internal.zzs> r0 = r10.zzd
            java.util.Set r0 = r0.keySet()
            java.util.Set<java.lang.Integer> r2 = r10.zzc
            r0.removeAll(r2)
            java.util.Iterator r2 = r0.iterator()
        L_0x0688:
            boolean r0 = r2.hasNext()
            if (r0 == 0) goto L_0x0719
            java.lang.Object r0 = r2.next()
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            java.util.Map<java.lang.Integer, com.google.android.gms.measurement.internal.zzs> r3 = r10.zzd
            java.lang.Integer r4 = java.lang.Integer.valueOf(r0)
            java.lang.Object r3 = r3.get(r4)
            com.google.android.gms.measurement.internal.zzs r3 = (com.google.android.gms.measurement.internal.zzs) r3
            com.google.android.gms.internal.measurement.zzbw$zza r3 = r3.zza((int) r0)
            r1.add(r3)
            com.google.android.gms.measurement.internal.zzab r4 = r46.zzi()
            java.lang.String r5 = r10.zzb
            com.google.android.gms.internal.measurement.zzbw$zzi r3 = r3.zzc()
            r4.zzak()
            r4.zzd()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r5)
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r3)
            byte[] r3 = r3.zzbi()
            android.content.ContentValues r6 = new android.content.ContentValues
            r6.<init>()
            java.lang.String r7 = "app_id"
            r6.put(r7, r5)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.String r7 = "audience_id"
            r6.put(r7, r0)
            java.lang.String r0 = "current_results"
            r6.put(r0, r3)
            android.database.sqlite.SQLiteDatabase r0 = r4.c_()     // Catch:{ SQLiteException -> 0x0704 }
            java.lang.String r3 = "audience_filter_values"
            r7 = 5
            r8 = 0
            long r6 = r0.insertWithOnConflict(r3, r8, r6, r7)     // Catch:{ SQLiteException -> 0x0702 }
            r11 = -1
            int r0 = (r6 > r11 ? 1 : (r6 == r11 ? 0 : -1))
            if (r0 != 0) goto L_0x0701
            com.google.android.gms.measurement.internal.zzet r0 = r4.zzr()     // Catch:{ SQLiteException -> 0x0702 }
            com.google.android.gms.measurement.internal.zzev r0 = r0.zzf()     // Catch:{ SQLiteException -> 0x0702 }
            java.lang.String r3 = "Failed to insert filter results (got -1). appId"
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzet.zza((java.lang.String) r5)     // Catch:{ SQLiteException -> 0x0702 }
            r0.zza(r3, r6)     // Catch:{ SQLiteException -> 0x0702 }
        L_0x0701:
            goto L_0x0688
        L_0x0702:
            r0 = move-exception
            goto L_0x0706
        L_0x0704:
            r0 = move-exception
            r8 = 0
        L_0x0706:
            com.google.android.gms.measurement.internal.zzet r3 = r4.zzr()
            com.google.android.gms.measurement.internal.zzev r3 = r3.zzf()
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzet.zza((java.lang.String) r5)
            java.lang.String r5 = "Error storing filter results. appId"
            r3.zza(r5, r4, r0)
            goto L_0x0688
        L_0x0719:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzq.zza(java.lang.String, java.util.List, java.util.List, java.lang.Long, java.lang.Long):java.util.List");
    }

    private final zzs zza(int i) {
        if (this.zzd.containsKey(Integer.valueOf(i))) {
            return this.zzd.get(Integer.valueOf(i));
        }
        zzs zzs = new zzs(this, this.zzb, (zzp) null);
        this.zzd.put(Integer.valueOf(i), zzs);
        return zzs;
    }

    private final boolean zza(int i, int i2) {
        if (this.zzd.get(Integer.valueOf(i)) == null) {
            return false;
        }
        return this.zzd.get(Integer.valueOf(i)).zzd.get(i2);
    }
}
