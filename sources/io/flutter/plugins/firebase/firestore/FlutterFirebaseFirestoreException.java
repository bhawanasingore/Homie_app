package io.flutter.plugins.firebase.firestore;

import com.google.firebase.firestore.FirebaseFirestoreException;

class FlutterFirebaseFirestoreException extends Exception {
    private static final String ERROR_ABORTED = "The operation was aborted, typically due to a concurrency issue like transaction aborts, etc.";
    private static final String ERROR_ALREADY_EXISTS = "Some document that we attempted to create already exists.";
    private static final String ERROR_CANCELLED = "The operation was cancelled (typically by the caller).";
    private static final String ERROR_DATA_LOSS = "Unrecoverable data loss or corruption.";
    private static final String ERROR_DEADLINE_EXCEEDED = "Deadline expired before operation could complete. For operations that change the state of the system, this error may be returned even if the operation has completed successfully. For example, a successful response from a server could have been delayed long enough for the deadline to expire.";
    private static final String ERROR_FAILED_PRECONDITION = "Operation was rejected because the system is not in a state required for the operation's execution. If performing a query, ensure it has been indexed via the Firebase console.";
    private static final String ERROR_INTERNAL = "Internal errors. Means some invariants expected by underlying system has been broken. If you see one of these errors, something is very broken.";
    private static final String ERROR_INVALID_ARGUMENT = "Client specified an invalid argument. Note that this differs from failed-precondition. invalid-argument indicates arguments that are problematic regardless of the state of the system (e.g., an invalid field name).";
    private static final String ERROR_NOT_FOUND = "Some requested document was not found.";
    private static final String ERROR_OUT_OF_RANGE = "Operation was attempted past the valid range.";
    private static final String ERROR_PERMISSION_DENIED = "The caller does not have permission to execute the specified operation.";
    private static final String ERROR_RESOURCE_EXHAUSTED = "Some resource has been exhausted, perhaps a per-user quota, or perhaps the entire file system is out of space.";
    private static final String ERROR_UNAUTHENTICATED = "The request does not have valid authentication credentials for the operation.";
    private static final String ERROR_UNAVAILABLE = "The service is currently unavailable. This is a most likely a transient condition and may be corrected by retrying with a backoff.";
    private static final String ERROR_UNIMPLEMENTED = "Operation is not implemented or not supported/enabled.";
    private static final String ERROR_UNKNOWN = "Operation is not implemented or not supported/enabled.";
    private final String code;
    private final String message;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0066, code lost:
        if (r6.equals("ALREADY_EXISTS") != false) goto L_0x0103;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    FlutterFirebaseFirestoreException(com.google.firebase.firestore.FirebaseFirestoreException r12, java.lang.Throwable r13) {
        /*
            r11 = this;
            if (r12 == 0) goto L_0x0007
            java.lang.String r0 = r12.getMessage()
            goto L_0x0009
        L_0x0007:
            java.lang.String r0 = ""
        L_0x0009:
            r11.<init>(r0, r13)
            r0 = 0
            r1 = 0
            java.lang.String r2 = "query requires an index"
            if (r13 == 0) goto L_0x015e
            java.lang.String r3 = r13.getMessage()
            if (r3 == 0) goto L_0x015e
            java.lang.String r3 = r13.getMessage()
            java.lang.String r4 = ":"
            boolean r3 = r3.contains(r4)
            if (r3 == 0) goto L_0x015e
            java.lang.String r3 = r13.getMessage()
            java.lang.String r4 = "([A-Z_]{3,25}):\\s(.*)"
            java.util.regex.Pattern r4 = java.util.regex.Pattern.compile(r4)
            java.util.regex.Matcher r4 = r4.matcher(r3)
            boolean r5 = r4.find()
            if (r5 == 0) goto L_0x015e
            r5 = 1
            java.lang.String r6 = r4.group(r5)
            java.lang.String r6 = r6.trim()
            r7 = 2
            java.lang.String r8 = r4.group(r7)
            java.lang.String r8 = r8.trim()
            r9 = -1
            int r10 = r6.hashCode()
            switch(r10) {
                case -1842427240: goto L_0x00f8;
                case -1711692763: goto L_0x00ee;
                case -1416305653: goto L_0x00e3;
                case -1031784143: goto L_0x00d9;
                case -1025686472: goto L_0x00ce;
                case -849706474: goto L_0x00c3;
                case -476794961: goto L_0x00b9;
                case -376214182: goto L_0x00af;
                case 433141802: goto L_0x00a4;
                case 695165606: goto L_0x0098;
                case 979228314: goto L_0x008d;
                case 1023286998: goto L_0x0081;
                case 1353037501: goto L_0x0076;
                case 1487498288: goto L_0x006a;
                case 1661336131: goto L_0x0060;
                case 1854913705: goto L_0x0054;
                default: goto L_0x0052;
            }
        L_0x0052:
            goto L_0x0102
        L_0x0054:
            java.lang.String r5 = "UNIMPLEMENTED"
            boolean r5 = r6.equals(r5)
            if (r5 == 0) goto L_0x0052
            r5 = 14
            goto L_0x0103
        L_0x0060:
            java.lang.String r7 = "ALREADY_EXISTS"
            boolean r7 = r6.equals(r7)
            if (r7 == 0) goto L_0x0052
            goto L_0x0103
        L_0x006a:
            java.lang.String r5 = "UNAVAILABLE"
            boolean r5 = r6.equals(r5)
            if (r5 == 0) goto L_0x0052
            r5 = 13
            goto L_0x0103
        L_0x0076:
            java.lang.String r5 = "INTERNAL"
            boolean r5 = r6.equals(r5)
            if (r5 == 0) goto L_0x0052
            r5 = 6
            goto L_0x0103
        L_0x0081:
            java.lang.String r5 = "NOT_FOUND"
            boolean r5 = r6.equals(r5)
            if (r5 == 0) goto L_0x0052
            r5 = 8
            goto L_0x0103
        L_0x008d:
            java.lang.String r5 = "FAILED_PRECONDITION"
            boolean r5 = r6.equals(r5)
            if (r5 == 0) goto L_0x0052
            r5 = 5
            goto L_0x0103
        L_0x0098:
            java.lang.String r5 = "OUT_OF_RANGE"
            boolean r5 = r6.equals(r5)
            if (r5 == 0) goto L_0x0052
            r5 = 9
            goto L_0x0103
        L_0x00a4:
            java.lang.String r5 = "UNKNOWN"
            boolean r5 = r6.equals(r5)
            if (r5 == 0) goto L_0x0052
            r5 = 15
            goto L_0x0103
        L_0x00af:
            java.lang.String r5 = "DEADLINE_EXCEEDED"
            boolean r5 = r6.equals(r5)
            if (r5 == 0) goto L_0x0052
            r5 = 4
            goto L_0x0103
        L_0x00b9:
            java.lang.String r5 = "ABORTED"
            boolean r5 = r6.equals(r5)
            if (r5 == 0) goto L_0x0052
            r5 = 0
            goto L_0x0103
        L_0x00c3:
            java.lang.String r5 = "UNAUTHENTICATED"
            boolean r5 = r6.equals(r5)
            if (r5 == 0) goto L_0x0052
            r5 = 12
            goto L_0x0103
        L_0x00ce:
            java.lang.String r5 = "RESOURCE_EXHAUSTED"
            boolean r5 = r6.equals(r5)
            if (r5 == 0) goto L_0x0052
            r5 = 11
            goto L_0x0103
        L_0x00d9:
            java.lang.String r5 = "CANCELLED"
            boolean r5 = r6.equals(r5)
            if (r5 == 0) goto L_0x0052
            r5 = r7
            goto L_0x0103
        L_0x00e3:
            java.lang.String r5 = "PERMISSION_DENIED"
            boolean r5 = r6.equals(r5)
            if (r5 == 0) goto L_0x0052
            r5 = 10
            goto L_0x0103
        L_0x00ee:
            java.lang.String r5 = "INVALID_ARGUMENT"
            boolean r5 = r6.equals(r5)
            if (r5 == 0) goto L_0x0052
            r5 = 7
            goto L_0x0103
        L_0x00f8:
            java.lang.String r5 = "DATA_LOSS"
            boolean r5 = r6.equals(r5)
            if (r5 == 0) goto L_0x0052
            r5 = 3
            goto L_0x0103
        L_0x0102:
            r5 = r9
        L_0x0103:
            switch(r5) {
                case 0: goto L_0x015a;
                case 1: goto L_0x0155;
                case 2: goto L_0x0150;
                case 3: goto L_0x014b;
                case 4: goto L_0x0146;
                case 5: goto L_0x0139;
                case 6: goto L_0x0134;
                case 7: goto L_0x012f;
                case 8: goto L_0x012a;
                case 9: goto L_0x0125;
                case 10: goto L_0x0120;
                case 11: goto L_0x011b;
                case 12: goto L_0x0116;
                case 13: goto L_0x0111;
                case 14: goto L_0x010c;
                case 15: goto L_0x0107;
                default: goto L_0x0106;
            }
        L_0x0106:
            goto L_0x015e
        L_0x0107:
            java.lang.String r0 = "unknown"
            java.lang.String r1 = "Operation is not implemented or not supported/enabled."
            goto L_0x015e
        L_0x010c:
            java.lang.String r0 = "unimplemented"
            java.lang.String r1 = "Operation is not implemented or not supported/enabled."
            goto L_0x015e
        L_0x0111:
            java.lang.String r0 = "unavailable"
            java.lang.String r1 = "The service is currently unavailable. This is a most likely a transient condition and may be corrected by retrying with a backoff."
            goto L_0x015e
        L_0x0116:
            java.lang.String r0 = "unauthenticated"
            java.lang.String r1 = "The request does not have valid authentication credentials for the operation."
            goto L_0x015e
        L_0x011b:
            java.lang.String r0 = "resource-exhausted"
            java.lang.String r1 = "Some resource has been exhausted, perhaps a per-user quota, or perhaps the entire file system is out of space."
            goto L_0x015e
        L_0x0120:
            java.lang.String r0 = "permission-denied"
            java.lang.String r1 = "The caller does not have permission to execute the specified operation."
            goto L_0x015e
        L_0x0125:
            java.lang.String r0 = "out-of-range"
            java.lang.String r1 = "Operation was attempted past the valid range."
            goto L_0x015e
        L_0x012a:
            java.lang.String r0 = "not-found"
            java.lang.String r1 = "Some requested document was not found."
            goto L_0x015e
        L_0x012f:
            java.lang.String r0 = "invalid-argument"
            java.lang.String r1 = "Client specified an invalid argument. Note that this differs from failed-precondition. invalid-argument indicates arguments that are problematic regardless of the state of the system (e.g., an invalid field name)."
            goto L_0x015e
        L_0x0134:
            java.lang.String r0 = "internal"
            java.lang.String r1 = "Internal errors. Means some invariants expected by underlying system has been broken. If you see one of these errors, something is very broken."
            goto L_0x015e
        L_0x0139:
            java.lang.String r0 = "failed-precondition"
            boolean r5 = r8.contains(r2)
            if (r5 == 0) goto L_0x0143
            r1 = r8
            goto L_0x015e
        L_0x0143:
            java.lang.String r1 = "Operation was rejected because the system is not in a state required for the operation's execution. If performing a query, ensure it has been indexed via the Firebase console."
            goto L_0x015e
        L_0x0146:
            java.lang.String r0 = "deadline-exceeded"
            java.lang.String r1 = "Deadline expired before operation could complete. For operations that change the state of the system, this error may be returned even if the operation has completed successfully. For example, a successful response from a server could have been delayed long enough for the deadline to expire."
            goto L_0x015e
        L_0x014b:
            java.lang.String r0 = "data-loss"
            java.lang.String r1 = "Unrecoverable data loss or corruption."
            goto L_0x015e
        L_0x0150:
            java.lang.String r0 = "cancelled"
            java.lang.String r1 = "The operation was cancelled (typically by the caller)."
            goto L_0x015e
        L_0x0155:
            java.lang.String r0 = "already-exists"
            java.lang.String r1 = "Some document that we attempted to create already exists."
            goto L_0x015e
        L_0x015a:
            java.lang.String r0 = "aborted"
            java.lang.String r1 = "The operation was aborted, typically due to a concurrency issue like transaction aborts, etc."
        L_0x015e:
            if (r0 != 0) goto L_0x01dc
            if (r12 == 0) goto L_0x01dc
            int[] r3 = io.flutter.plugins.firebase.firestore.FlutterFirebaseFirestoreException.AnonymousClass1.$SwitchMap$com$google$firebase$firestore$FirebaseFirestoreException$Code
            com.google.firebase.firestore.FirebaseFirestoreException$Code r4 = r12.getCode()
            int r4 = r4.ordinal()
            r3 = r3[r4]
            switch(r3) {
                case 1: goto L_0x01d8;
                case 2: goto L_0x01d3;
                case 3: goto L_0x01ce;
                case 4: goto L_0x01c9;
                case 5: goto L_0x01c4;
                case 6: goto L_0x01aa;
                case 7: goto L_0x01a5;
                case 8: goto L_0x01a0;
                case 9: goto L_0x019b;
                case 10: goto L_0x0196;
                case 11: goto L_0x0191;
                case 12: goto L_0x018c;
                case 13: goto L_0x0187;
                case 14: goto L_0x0182;
                case 15: goto L_0x017d;
                case 16: goto L_0x0177;
                default: goto L_0x0171;
            }
        L_0x0171:
            java.lang.String r0 = "unknown"
            java.lang.String r1 = "An unknown error occurred"
            goto L_0x01dc
        L_0x0177:
            java.lang.String r0 = "unknown"
            java.lang.String r1 = "Unknown error or an error from a different error domain."
            goto L_0x01dc
        L_0x017d:
            java.lang.String r0 = "unimplemented"
            java.lang.String r1 = "Operation is not implemented or not supported/enabled."
            goto L_0x01dc
        L_0x0182:
            java.lang.String r0 = "unavailable"
            java.lang.String r1 = "The service is currently unavailable. This is a most likely a transient condition and may be corrected by retrying with a backoff."
            goto L_0x01dc
        L_0x0187:
            java.lang.String r0 = "unauthenticated"
            java.lang.String r1 = "The request does not have valid authentication credentials for the operation."
            goto L_0x01dc
        L_0x018c:
            java.lang.String r0 = "resource-exhausted"
            java.lang.String r1 = "Some resource has been exhausted, perhaps a per-user quota, or perhaps the entire file system is out of space."
            goto L_0x01dc
        L_0x0191:
            java.lang.String r0 = "permission-denied"
            java.lang.String r1 = "The caller does not have permission to execute the specified operation."
            goto L_0x01dc
        L_0x0196:
            java.lang.String r0 = "out-of-range"
            java.lang.String r1 = "Operation was attempted past the valid range."
            goto L_0x01dc
        L_0x019b:
            java.lang.String r0 = "not-found"
            java.lang.String r1 = "Some requested document was not found."
            goto L_0x01dc
        L_0x01a0:
            java.lang.String r0 = "invalid-argument"
            java.lang.String r1 = "Client specified an invalid argument. Note that this differs from failed-precondition. invalid-argument indicates arguments that are problematic regardless of the state of the system (e.g., an invalid field name)."
            goto L_0x01dc
        L_0x01a5:
            java.lang.String r0 = "internal"
            java.lang.String r1 = "Internal errors. Means some invariants expected by underlying system has been broken. If you see one of these errors, something is very broken."
            goto L_0x01dc
        L_0x01aa:
            java.lang.String r0 = "failed-precondition"
            java.lang.String r3 = r12.getMessage()
            if (r3 == 0) goto L_0x01c1
            java.lang.String r3 = r12.getMessage()
            boolean r2 = r3.contains(r2)
            if (r2 == 0) goto L_0x01c1
            java.lang.String r1 = r12.getMessage()
            goto L_0x01dc
        L_0x01c1:
            java.lang.String r1 = "Operation was rejected because the system is not in a state required for the operation's execution. If performing a query, ensure it has been indexed via the Firebase console."
            goto L_0x01dc
        L_0x01c4:
            java.lang.String r0 = "deadline-exceeded"
            java.lang.String r1 = "Deadline expired before operation could complete. For operations that change the state of the system, this error may be returned even if the operation has completed successfully. For example, a successful response from a server could have been delayed long enough for the deadline to expire."
            goto L_0x01dc
        L_0x01c9:
            java.lang.String r0 = "data-loss"
            java.lang.String r1 = "Unrecoverable data loss or corruption."
            goto L_0x01dc
        L_0x01ce:
            java.lang.String r0 = "cancelled"
            java.lang.String r1 = "The operation was cancelled (typically by the caller)."
            goto L_0x01dc
        L_0x01d3:
            java.lang.String r0 = "already-exists"
            java.lang.String r1 = "Some document that we attempted to create already exists."
            goto L_0x01dc
        L_0x01d8:
            java.lang.String r0 = "aborted"
            java.lang.String r1 = "The operation was aborted, typically due to a concurrency issue like transaction aborts, etc."
        L_0x01dc:
            r11.code = r0
            r11.message = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.plugins.firebase.firestore.FlutterFirebaseFirestoreException.<init>(com.google.firebase.firestore.FirebaseFirestoreException, java.lang.Throwable):void");
    }

    /* renamed from: io.flutter.plugins.firebase.firestore.FlutterFirebaseFirestoreException$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$firebase$firestore$FirebaseFirestoreException$Code;

        static {
            int[] iArr = new int[FirebaseFirestoreException.Code.values().length];
            $SwitchMap$com$google$firebase$firestore$FirebaseFirestoreException$Code = iArr;
            try {
                iArr[FirebaseFirestoreException.Code.ABORTED.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$google$firebase$firestore$FirebaseFirestoreException$Code[FirebaseFirestoreException.Code.ALREADY_EXISTS.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$google$firebase$firestore$FirebaseFirestoreException$Code[FirebaseFirestoreException.Code.CANCELLED.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$com$google$firebase$firestore$FirebaseFirestoreException$Code[FirebaseFirestoreException.Code.DATA_LOSS.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$com$google$firebase$firestore$FirebaseFirestoreException$Code[FirebaseFirestoreException.Code.DEADLINE_EXCEEDED.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$com$google$firebase$firestore$FirebaseFirestoreException$Code[FirebaseFirestoreException.Code.FAILED_PRECONDITION.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$com$google$firebase$firestore$FirebaseFirestoreException$Code[FirebaseFirestoreException.Code.INTERNAL.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                $SwitchMap$com$google$firebase$firestore$FirebaseFirestoreException$Code[FirebaseFirestoreException.Code.INVALID_ARGUMENT.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                $SwitchMap$com$google$firebase$firestore$FirebaseFirestoreException$Code[FirebaseFirestoreException.Code.NOT_FOUND.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                $SwitchMap$com$google$firebase$firestore$FirebaseFirestoreException$Code[FirebaseFirestoreException.Code.OUT_OF_RANGE.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
            try {
                $SwitchMap$com$google$firebase$firestore$FirebaseFirestoreException$Code[FirebaseFirestoreException.Code.PERMISSION_DENIED.ordinal()] = 11;
            } catch (NoSuchFieldError e11) {
            }
            try {
                $SwitchMap$com$google$firebase$firestore$FirebaseFirestoreException$Code[FirebaseFirestoreException.Code.RESOURCE_EXHAUSTED.ordinal()] = 12;
            } catch (NoSuchFieldError e12) {
            }
            try {
                $SwitchMap$com$google$firebase$firestore$FirebaseFirestoreException$Code[FirebaseFirestoreException.Code.UNAUTHENTICATED.ordinal()] = 13;
            } catch (NoSuchFieldError e13) {
            }
            try {
                $SwitchMap$com$google$firebase$firestore$FirebaseFirestoreException$Code[FirebaseFirestoreException.Code.UNAVAILABLE.ordinal()] = 14;
            } catch (NoSuchFieldError e14) {
            }
            try {
                $SwitchMap$com$google$firebase$firestore$FirebaseFirestoreException$Code[FirebaseFirestoreException.Code.UNIMPLEMENTED.ordinal()] = 15;
            } catch (NoSuchFieldError e15) {
            }
            try {
                $SwitchMap$com$google$firebase$firestore$FirebaseFirestoreException$Code[FirebaseFirestoreException.Code.UNKNOWN.ordinal()] = 16;
            } catch (NoSuchFieldError e16) {
            }
        }
    }

    public String getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }
}
