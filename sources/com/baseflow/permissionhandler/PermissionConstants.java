package com.baseflow.permissionhandler;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

final class PermissionConstants {
    static final String LOG_TAG = "permissions_handler";
    static final int PERMISSION_CODE = 24;
    static final int PERMISSION_CODE_IGNORE_BATTERY_OPTIMIZATIONS = 5672353;
    static final int PERMISSION_GROUP_ACCESS_MEDIA_LOCATION = 17;
    static final int PERMISSION_GROUP_ACTIVITY_RECOGNITION = 18;
    static final int PERMISSION_GROUP_CALENDAR = 0;
    static final int PERMISSION_GROUP_CAMERA = 1;
    static final int PERMISSION_GROUP_CONTACTS = 2;
    static final int PERMISSION_GROUP_IGNORE_BATTERY_OPTIMIZATIONS = 15;
    static final int PERMISSION_GROUP_LOCATION = 3;
    static final int PERMISSION_GROUP_LOCATION_ALWAYS = 4;
    static final int PERMISSION_GROUP_LOCATION_WHEN_IN_USE = 5;
    static final int PERMISSION_GROUP_MEDIA_LIBRARY = 6;
    static final int PERMISSION_GROUP_MICROPHONE = 7;
    static final int PERMISSION_GROUP_NOTIFICATION = 16;
    static final int PERMISSION_GROUP_PHONE = 8;
    static final int PERMISSION_GROUP_PHOTOS = 9;
    static final int PERMISSION_GROUP_REMINDERS = 10;
    static final int PERMISSION_GROUP_SENSORS = 11;
    static final int PERMISSION_GROUP_SMS = 12;
    static final int PERMISSION_GROUP_SPEECH = 13;
    static final int PERMISSION_GROUP_STORAGE = 14;
    static final int PERMISSION_GROUP_UNKNOWN = 19;
    static final int PERMISSION_STATUS_DENIED = 0;
    static final int PERMISSION_STATUS_GRANTED = 1;
    static final int PERMISSION_STATUS_NEVER_ASK_AGAIN = 4;
    static final int PERMISSION_STATUS_NOT_DETERMINED = 3;
    static final int PERMISSION_STATUS_RESTRICTED = 2;
    static final int SERVICE_STATUS_DISABLED = 0;
    static final int SERVICE_STATUS_ENABLED = 1;
    static final int SERVICE_STATUS_NOT_APPLICABLE = 2;

    @Retention(RetentionPolicy.SOURCE)
    @interface PermissionGroup {
    }

    @Retention(RetentionPolicy.SOURCE)
    @interface PermissionStatus {
    }

    @Retention(RetentionPolicy.SOURCE)
    @interface ServiceStatus {
    }

    PermissionConstants() {
    }
}
