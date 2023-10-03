package io.flutter.plugins.firebase.auth;

import androidx.annotation.NonNull;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import java.util.HashMap;
import java.util.Map;

public class FlutterFirebaseAuthPluginException extends Exception {
    private Map<String, Object> additionalData = new HashMap();
    private final String code;
    private final String message;

    FlutterFirebaseAuthPluginException(@NonNull String code2, @NonNull String message2) {
        super(message2, (Throwable) null);
        this.code = code2;
        this.message = message2;
    }

    FlutterFirebaseAuthPluginException(@NonNull Exception nativeException, Throwable cause) {
        super(nativeException.getMessage(), cause);
        String code2 = "UNKNOWN";
        String message2 = nativeException.getMessage();
        Map<String, Object> additionalData2 = new HashMap<>();
        code2 = nativeException instanceof FirebaseAuthException ? ((FirebaseAuthException) nativeException).getErrorCode() : code2;
        message2 = nativeException instanceof FirebaseAuthWeakPasswordException ? ((FirebaseAuthWeakPasswordException) nativeException).getReason() : message2;
        if (nativeException instanceof FirebaseAuthUserCollisionException) {
            String email = ((FirebaseAuthUserCollisionException) nativeException).getEmail();
            if (email != null) {
                additionalData2.put("email", email);
            }
            AuthCredential authCredential = ((FirebaseAuthUserCollisionException) nativeException).getUpdatedCredential();
            if (authCredential != null) {
                additionalData2.put(Constants.AUTH_CREDENTIAL, FlutterFirebaseAuthPlugin.parseAuthCredential(authCredential));
            }
        }
        this.code = code2;
        this.message = message2;
        this.additionalData = additionalData2;
    }

    static FlutterFirebaseAuthPluginException noUser() {
        return new FlutterFirebaseAuthPluginException("NO_CURRENT_USER", "No user currently signed in.");
    }

    static FlutterFirebaseAuthPluginException invalidCredential() {
        return new FlutterFirebaseAuthPluginException("INVALID_CREDENTIAL", "The supplied auth credential is malformed, has expired or is not currently supported.");
    }

    static FlutterFirebaseAuthPluginException noSuchProvider() {
        return new FlutterFirebaseAuthPluginException("NO_SUCH_PROVIDER", "User was not linked to an account with the given provider.");
    }

    public String getCode() {
        return this.code.toLowerCase().replace("error_", "").replace("_", "-");
    }

    public String getMessage() {
        return this.message;
    }

    public Map<String, Object> getAdditionalData() {
        return this.additionalData;
    }
}
