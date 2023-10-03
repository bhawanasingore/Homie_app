package io.flutter.plugins.firebase.firestore;

import android.util.Log;
import com.google.firebase.FirebaseApp;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.Blob;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FieldPath;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreSettings;
import com.google.firebase.firestore.GeoPoint;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.SnapshotMetadata;
import io.flutter.plugin.common.StandardMessageCodec;
import io.flutter.plugins.firebase.auth.Constants;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

class FlutterFirebaseFirestoreMessageCodec extends StandardMessageCodec {
    private static final byte DATA_TYPE_ARRAY_REMOVE = -123;
    private static final byte DATA_TYPE_ARRAY_UNION = -124;
    private static final byte DATA_TYPE_BLOB = -125;
    private static final byte DATA_TYPE_DATE_TIME = Byte.MIN_VALUE;
    private static final byte DATA_TYPE_DELETE = -122;
    private static final byte DATA_TYPE_DOCUMENT_ID = -117;
    private static final byte DATA_TYPE_DOCUMENT_REFERENCE = -126;
    private static final byte DATA_TYPE_FIELD_PATH = -116;
    private static final byte DATA_TYPE_FIRESTORE_INSTANCE = -112;
    private static final byte DATA_TYPE_FIRESTORE_QUERY = -111;
    private static final byte DATA_TYPE_FIRESTORE_SETTINGS = -110;
    private static final byte DATA_TYPE_GEO_POINT = -127;
    private static final byte DATA_TYPE_INCREMENT_DOUBLE = -119;
    private static final byte DATA_TYPE_INCREMENT_INTEGER = -118;
    private static final byte DATA_TYPE_INFINITY = -114;
    private static final byte DATA_TYPE_NAN = -115;
    private static final byte DATA_TYPE_NEGATIVE_INFINITY = -113;
    private static final byte DATA_TYPE_SERVER_TIMESTAMP = -121;
    private static final byte DATA_TYPE_TIMESTAMP = -120;
    public static final FlutterFirebaseFirestoreMessageCodec INSTANCE = new FlutterFirebaseFirestoreMessageCodec();

    FlutterFirebaseFirestoreMessageCodec() {
    }

    /* access modifiers changed from: protected */
    public void writeValue(ByteArrayOutputStream stream, Object value) {
        if (value instanceof Date) {
            stream.write(-128);
            writeLong(stream, ((Date) value).getTime());
        } else if (value instanceof Timestamp) {
            stream.write(-120);
            writeLong(stream, ((Timestamp) value).getSeconds());
            writeInt(stream, ((Timestamp) value).getNanoseconds());
        } else if (value instanceof GeoPoint) {
            stream.write(-127);
            writeAlignment(stream, 8);
            writeDouble(stream, ((GeoPoint) value).getLatitude());
            writeDouble(stream, ((GeoPoint) value).getLongitude());
        } else if (value instanceof DocumentReference) {
            stream.write(-126);
            writeValue(stream, ((DocumentReference) value).getFirestore().getApp().getName());
            writeValue(stream, ((DocumentReference) value).getPath());
        } else if (value instanceof DocumentSnapshot) {
            writeDocumentSnapshot(stream, (DocumentSnapshot) value);
        } else if (value instanceof QuerySnapshot) {
            writeQuerySnapshot(stream, (QuerySnapshot) value);
        } else if (value instanceof DocumentChange) {
            writeDocumentChange(stream, (DocumentChange) value);
        } else if (value instanceof SnapshotMetadata) {
            writeSnapshotMetadata(stream, (SnapshotMetadata) value);
        } else if (value instanceof Blob) {
            stream.write(-125);
            writeBytes(stream, ((Blob) value).toBytes());
        } else if (value instanceof Double) {
            Double doubleValue = (Double) value;
            if (Double.isNaN(doubleValue.doubleValue())) {
                stream.write(-115);
            } else if (doubleValue.equals(Double.valueOf(Double.NEGATIVE_INFINITY))) {
                stream.write(-113);
            } else if (doubleValue.equals(Double.valueOf(Double.POSITIVE_INFINITY))) {
                stream.write(-114);
            } else {
                super.writeValue(stream, value);
            }
        } else {
            super.writeValue(stream, value);
        }
    }

    private void writeSnapshotMetadata(ByteArrayOutputStream stream, SnapshotMetadata value) {
        Map<String, Boolean> metadataMap = new HashMap<>();
        metadataMap.put("hasPendingWrites", Boolean.valueOf(value.hasPendingWrites()));
        metadataMap.put("isFromCache", Boolean.valueOf(value.isFromCache()));
        writeValue(stream, metadataMap);
    }

    private void writeDocumentChange(ByteArrayOutputStream stream, DocumentChange value) {
        Map<String, Object> changeMap = new HashMap<>();
        String type = null;
        int i = AnonymousClass1.$SwitchMap$com$google$firebase$firestore$DocumentChange$Type[value.getType().ordinal()];
        if (i == 1) {
            type = "DocumentChangeType.added";
        } else if (i == 2) {
            type = "DocumentChangeType.modified";
        } else if (i == 3) {
            type = "DocumentChangeType.removed";
        }
        changeMap.put("type", type);
        changeMap.put("data", value.getDocument().getData());
        changeMap.put("path", value.getDocument().getReference().getPath());
        changeMap.put("oldIndex", Integer.valueOf(value.getOldIndex()));
        changeMap.put("newIndex", Integer.valueOf(value.getNewIndex()));
        changeMap.put(Constants.METADATA, value.getDocument().getMetadata());
        writeValue(stream, changeMap);
    }

    /* renamed from: io.flutter.plugins.firebase.firestore.FlutterFirebaseFirestoreMessageCodec$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$firebase$firestore$DocumentChange$Type;

        static {
            int[] iArr = new int[DocumentChange.Type.values().length];
            $SwitchMap$com$google$firebase$firestore$DocumentChange$Type = iArr;
            try {
                iArr[DocumentChange.Type.ADDED.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$google$firebase$firestore$DocumentChange$Type[DocumentChange.Type.MODIFIED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$google$firebase$firestore$DocumentChange$Type[DocumentChange.Type.REMOVED.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    private void writeQuerySnapshot(ByteArrayOutputStream stream, QuerySnapshot value) {
        List<String> paths = new ArrayList<>();
        Map<String, Object> querySnapshotMap = new HashMap<>();
        List<Map<String, Object>> documents = new ArrayList<>();
        List<SnapshotMetadata> metadatas = new ArrayList<>();
        for (DocumentSnapshot document : value.getDocuments()) {
            paths.add(document.getReference().getPath());
            documents.add(document.getData());
            metadatas.add(document.getMetadata());
        }
        querySnapshotMap.put("paths", paths);
        querySnapshotMap.put("documents", documents);
        querySnapshotMap.put("metadatas", metadatas);
        querySnapshotMap.put("documentChanges", value.getDocumentChanges());
        querySnapshotMap.put(Constants.METADATA, value.getMetadata());
        writeValue(stream, querySnapshotMap);
    }

    private void writeDocumentSnapshot(ByteArrayOutputStream stream, DocumentSnapshot value) {
        Map<String, Object> snapshotMap = new HashMap<>();
        snapshotMap.put("path", value.getReference().getPath());
        if (value.exists()) {
            snapshotMap.put("data", value.getData());
        } else {
            snapshotMap.put("data", (Object) null);
        }
        snapshotMap.put(Constants.METADATA, value.getMetadata());
        writeValue(stream, snapshotMap);
    }

    /* access modifiers changed from: protected */
    public Object readValueOfType(byte type, ByteBuffer buffer) {
        switch (type) {
            case Byte.MIN_VALUE:
                return new Date(buffer.getLong());
            case -127:
                readAlignment(buffer, 8);
                return new GeoPoint(buffer.getDouble(), buffer.getDouble());
            case -126:
                return ((FirebaseFirestore) readValue(buffer)).document((String) readValue(buffer));
            case -125:
                return Blob.fromBytes(readBytes(buffer));
            case -124:
                return FieldValue.arrayUnion(toArray(readValue(buffer)));
            case -123:
                return FieldValue.arrayRemove(toArray(readValue(buffer)));
            case -122:
                return FieldValue.delete();
            case -121:
                return FieldValue.serverTimestamp();
            case -120:
                return new Timestamp(buffer.getLong(), buffer.getInt());
            case -119:
                return FieldValue.increment(((Number) readValue(buffer)).doubleValue());
            case -118:
                return FieldValue.increment((long) ((Number) readValue(buffer)).intValue());
            case -117:
                return FieldPath.documentId();
            case -116:
                int size = readSize(buffer);
                List<Object> list = new ArrayList<>(size);
                for (int i = 0; i < size; i++) {
                    list.add(readValue(buffer));
                }
                return FieldPath.of((String[]) list.toArray(new String[0]));
            case -115:
                return Double.valueOf(Double.NaN);
            case -114:
                return Double.valueOf(Double.POSITIVE_INFINITY);
            case -113:
                return Double.valueOf(Double.NEGATIVE_INFINITY);
            case -112:
                return readFirestoreInstance(buffer);
            case -111:
                return readFirestoreQuery(buffer);
            case -110:
                return readFirestoreSettings(buffer);
            default:
                return super.readValueOfType(type, buffer);
        }
    }

    private FirebaseFirestore readFirestoreInstance(ByteBuffer buffer) {
        String appName = (String) readValue(buffer);
        FirebaseFirestoreSettings settings = (FirebaseFirestoreSettings) readValue(buffer);
        synchronized (FlutterFirebaseFirestorePlugin.firestoreInstanceCache) {
            if (FlutterFirebaseFirestorePlugin.getCachedFirebaseFirestoreInstanceForKey(appName) != null) {
                FirebaseFirestore cachedFirebaseFirestoreInstanceForKey = FlutterFirebaseFirestorePlugin.getCachedFirebaseFirestoreInstanceForKey(appName);
                return cachedFirebaseFirestoreInstanceForKey;
            }
            FirebaseFirestore firestore = FirebaseFirestore.getInstance(FirebaseApp.getInstance(appName));
            firestore.setFirestoreSettings(settings);
            FlutterFirebaseFirestorePlugin.setCachedFirebaseFirestoreInstanceForKey(firestore, appName);
            return firestore;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v5, resolved type: java.lang.Integer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v7, resolved type: java.lang.Long} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.google.firebase.firestore.FirebaseFirestoreSettings readFirestoreSettings(java.nio.ByteBuffer r9) {
        /*
            r8 = this;
            java.lang.Object r0 = r8.readValue(r9)
            java.util.Map r0 = (java.util.Map) r0
            com.google.firebase.firestore.FirebaseFirestoreSettings$Builder r1 = new com.google.firebase.firestore.FirebaseFirestoreSettings$Builder
            r1.<init>()
            java.lang.String r2 = "persistenceEnabled"
            java.lang.Object r3 = r0.get(r2)
            if (r3 == 0) goto L_0x0025
            java.lang.Object r2 = r0.get(r2)
            java.lang.Object r2 = java.util.Objects.requireNonNull(r2)
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            r1.setPersistenceEnabled(r2)
        L_0x0025:
            java.lang.String r2 = "host"
            java.lang.Object r3 = r0.get(r2)
            if (r3 == 0) goto L_0x0054
            java.lang.Object r2 = r0.get(r2)
            java.lang.Object r2 = java.util.Objects.requireNonNull(r2)
            java.lang.String r2 = (java.lang.String) r2
            r1.setHost(r2)
            java.lang.String r2 = "sslEnabled"
            java.lang.Object r3 = r0.get(r2)
            if (r3 == 0) goto L_0x0054
            java.lang.Object r2 = r0.get(r2)
            java.lang.Object r2 = java.util.Objects.requireNonNull(r2)
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            r1.setSslEnabled(r2)
        L_0x0054:
            java.lang.String r2 = "cacheSizeBytes"
            java.lang.Object r3 = r0.get(r2)
            if (r3 == 0) goto L_0x0094
            r3 = 104857600(0x6400000, double:5.1806538E-316)
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            java.lang.Object r2 = r0.get(r2)
            boolean r4 = r2 instanceof java.lang.Long
            if (r4 == 0) goto L_0x006f
            r3 = r2
            java.lang.Long r3 = (java.lang.Long) r3
            goto L_0x007f
        L_0x006f:
            boolean r4 = r2 instanceof java.lang.Integer
            if (r4 == 0) goto L_0x007f
            r4 = r2
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r4 = r4.intValue()
            long r4 = (long) r4
            java.lang.Long r3 = java.lang.Long.valueOf(r4)
        L_0x007f:
            long r4 = r3.longValue()
            r6 = -1
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 != 0) goto L_0x008d
            r1.setCacheSizeBytes(r6)
            goto L_0x0094
        L_0x008d:
            long r4 = r3.longValue()
            r1.setCacheSizeBytes(r4)
        L_0x0094:
            com.google.firebase.firestore.FirebaseFirestoreSettings r2 = r1.build()
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.plugins.firebase.firestore.FlutterFirebaseFirestoreMessageCodec.readFirestoreSettings(java.nio.ByteBuffer):com.google.firebase.firestore.FirebaseFirestoreSettings");
    }

    private Query readFirestoreQuery(ByteBuffer buffer) {
        Query query;
        int i;
        try {
            Map<String, Object> values = (Map) readValue(buffer);
            FirebaseFirestore firestore = (FirebaseFirestore) Objects.requireNonNull(values.get("firestore"));
            String path = (String) Objects.requireNonNull(values.get("path"));
            boolean isCollectionGroup = ((Boolean) values.get("isCollectionGroup")).booleanValue();
            Map<String, Object> parameters = (Map) values.get("parameters");
            if (isCollectionGroup) {
                query = firestore.collectionGroup(path);
            } else {
                query = firestore.collection(path);
            }
            if (parameters == null) {
                return query;
            }
            Iterator<List<Object>> it = ((List) Objects.requireNonNull(parameters.get("where"))).iterator();
            while (true) {
                i = 1;
                if (!it.hasNext()) {
                    break;
                }
                List<Object> condition = it.next();
                FieldPath fieldPath = (FieldPath) condition.get(0);
                String operator = (String) condition.get(1);
                Object value = condition.get(2);
                if ("==".equals(operator)) {
                    query = query.whereEqualTo(fieldPath, value);
                } else if ("<".equals(operator)) {
                    query = query.whereLessThan(fieldPath, value);
                } else if ("<=".equals(operator)) {
                    query = query.whereLessThanOrEqualTo(fieldPath, value);
                } else if (">".equals(operator)) {
                    query = query.whereGreaterThan(fieldPath, value);
                } else if (">=".equals(operator)) {
                    query = query.whereGreaterThanOrEqualTo(fieldPath, value);
                } else if ("array-contains".equals(operator)) {
                    query = query.whereArrayContains(fieldPath, value);
                } else if ("array-contains-any".equals(operator)) {
                    query = query.whereArrayContainsAny(fieldPath, (List<? extends Object>) (List) value);
                } else if ("in".equals(operator)) {
                    query = query.whereIn(fieldPath, (List<? extends Object>) (List) value);
                } else {
                    Log.w("FLTFirestoreMsgCodec", "An invalid query operator " + operator + " was received but not handled.");
                }
            }
            Number limit = (Number) parameters.get("limit");
            if (limit != null) {
                query = query.limit(limit.longValue());
            }
            Number limitToLast = (Number) parameters.get("limitToLast");
            if (limitToLast != null) {
                query = query.limitToLast(limitToLast.longValue());
            }
            List<List<Object>> orderBy = (List) parameters.get("orderBy");
            if (orderBy == null) {
                return query;
            }
            for (List<Object> order : orderBy) {
                query = query.orderBy((FieldPath) order.get(0), ((Boolean) order.get(i)).booleanValue() ? Query.Direction.DESCENDING : Query.Direction.ASCENDING);
                i = 1;
            }
            List<Object> startAt = (List) parameters.get("startAt");
            if (startAt != null) {
                query = query.startAt((Object[]) Objects.requireNonNull(startAt.toArray()));
            }
            List<Object> startAfter = (List) parameters.get("startAfter");
            if (startAfter != null) {
                query = query.startAfter((Object[]) Objects.requireNonNull(startAfter.toArray()));
            }
            List<Object> endAt = (List) parameters.get("endAt");
            if (endAt != null) {
                query = query.endAt((Object[]) Objects.requireNonNull(endAt.toArray()));
            }
            List<Object> endBefore = (List) parameters.get("endBefore");
            if (endBefore != null) {
                return query.endBefore((Object[]) Objects.requireNonNull(endBefore.toArray()));
            }
            return query;
        } catch (Exception exception) {
            Log.e("FLTFirestoreMsgCodec", "An error occurred while parsing query arguments, this is most likely an error with this SDK.", exception);
            return null;
        }
    }

    private Object[] toArray(Object source) {
        if (source instanceof List) {
            return ((List) source).toArray();
        }
        if (source == null) {
            return new ArrayList().toArray();
        }
        throw new IllegalArgumentException(String.format("java.util.List was expected, unable to convert '%s' to an object array", new Object[]{source.getClass().getCanonicalName()}));
    }
}
