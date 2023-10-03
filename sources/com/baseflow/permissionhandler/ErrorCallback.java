package com.baseflow.permissionhandler;

@FunctionalInterface
interface ErrorCallback {
    void onError(String str, String str2);
}
