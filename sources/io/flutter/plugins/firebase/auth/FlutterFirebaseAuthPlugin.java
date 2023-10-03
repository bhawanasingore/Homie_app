package io.flutter.plugins.firebase.auth;

import android.app.Activity;
import android.net.Uri;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.android.tools.r8.annotations.SynthesizedClassMap;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApiNotAvailableException;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseException;
import com.google.firebase.FirebaseNetworkException;
import com.google.firebase.FirebaseTooManyRequestsException;
import com.google.firebase.auth.ActionCodeEmailInfo;
import com.google.firebase.auth.ActionCodeInfo;
import com.google.firebase.auth.ActionCodeResult;
import com.google.firebase.auth.AdditionalUserInfo;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseAuthProvider;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GetTokenResult;
import com.google.firebase.auth.GithubAuthProvider;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.auth.OAuthProvider;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.auth.SignInMethodQueryResult;
import com.google.firebase.auth.TwitterAuthProvider;
import com.google.firebase.auth.UserInfo;
import com.google.firebase.auth.UserProfileChangeRequest;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.PluginRegistry;
import io.flutter.plugins.firebase.core.FlutterFirebasePlugin;
import io.flutter.plugins.firebase.core.FlutterFirebasePluginRegistry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

@SynthesizedClassMap({$$Lambda$FlutterFirebaseAuthPlugin$0ixSA3omSpPD54s7DQO3jxlbg.class, $$Lambda$FlutterFirebaseAuthPlugin$1DoXR48WpAI58SYCbtBEeVE8T2w.class, $$Lambda$FlutterFirebaseAuthPlugin$2MuYRvEGswnjQuillBu90b4LLds.class, $$Lambda$FlutterFirebaseAuthPlugin$8CFpMzptIpJbtwihYQLu9nCaJxk.class, $$Lambda$FlutterFirebaseAuthPlugin$AZMZar8NXruQzGOSFF84C0F1YE.class, $$Lambda$FlutterFirebaseAuthPlugin$Aztk8n6jG2PCP8nycOSAt60TiDE.class, $$Lambda$FlutterFirebaseAuthPlugin$BLHHozZUti3faidf3h67FNBoyWs.class, $$Lambda$FlutterFirebaseAuthPlugin$BpqQeIqcn4FCMUD825DftEAjLJ8.class, $$Lambda$FlutterFirebaseAuthPlugin$Ct7IavKAnZl0D4Jts7Cjq4_lx0I.class, $$Lambda$FlutterFirebaseAuthPlugin$FKP6HA5V2iIbxOhcCp1dnRAxpk.class, $$Lambda$FlutterFirebaseAuthPlugin$HzQD9st35_oUTNr7WxBSmIiotrQ.class, $$Lambda$FlutterFirebaseAuthPlugin$JV0Kzi0EYbXh5XRQMCSNUpeAUUE.class, $$Lambda$FlutterFirebaseAuthPlugin$JcABGM0GEXwODTN22EOt5GJ_6vo.class, $$Lambda$FlutterFirebaseAuthPlugin$N340kh6BajZ4YFvAsbxf7vx14XU.class, $$Lambda$FlutterFirebaseAuthPlugin$O2im_R9kDkdxSXhzUcjhWkeVjtk.class, $$Lambda$FlutterFirebaseAuthPlugin$QAUjEc_LD4kDgq6j2876OtBGNY.class, $$Lambda$FlutterFirebaseAuthPlugin$Qz3OWWNLoyif3UTWgJ0B2p6YKE.class, $$Lambda$FlutterFirebaseAuthPlugin$SQAGnfsVv7byAY7rk65tey1yNTg.class, $$Lambda$FlutterFirebaseAuthPlugin$aqemNu3a4VEV9DIrBxISm6y92RQ.class, $$Lambda$FlutterFirebaseAuthPlugin$cttTmkr0dufI9FSxhEsXTfNslHE.class, $$Lambda$FlutterFirebaseAuthPlugin$dR7Gw61X5AEmQOMPwBmfHYqA9nM.class, $$Lambda$FlutterFirebaseAuthPlugin$euFUehvGwns3Amg5Ed44REveBMI.class, $$Lambda$FlutterFirebaseAuthPlugin$gOhawOZGFprrkxbBRvXBjS2LfP4.class, $$Lambda$FlutterFirebaseAuthPlugin$h8gJlxlNQr9nkzxGae8hK3mls8.class, $$Lambda$FlutterFirebaseAuthPlugin$hAxG7uWwNQcMqwsQ7ur2Eik_hjo.class, $$Lambda$FlutterFirebaseAuthPlugin$hFbcqaftP_cIRauOroBb2EQmyxQ.class, $$Lambda$FlutterFirebaseAuthPlugin$jJyx7xsOlfrtyvdYqx6xeMSCI8.class, $$Lambda$FlutterFirebaseAuthPlugin$lKMVrDZqzPSYl3M3yXbt2WNbY1k.class, $$Lambda$FlutterFirebaseAuthPlugin$oF430640USFX4syEbc20qyTYUC0.class, $$Lambda$FlutterFirebaseAuthPlugin$tJgXKU3nRTDqQf18pH7BvmaC7eE.class, $$Lambda$FlutterFirebaseAuthPlugin$tWHRqndMAmD1Pw4Ghd6GrEh3DA.class, $$Lambda$FlutterFirebaseAuthPlugin$tqnMfQk4vWgbVtzo49TiEe4aDE.class, $$Lambda$FlutterFirebaseAuthPlugin$vx1Eua3fXU6VurKrK1l4Bafqroc.class, $$Lambda$FlutterFirebaseAuthPlugin$yVKOMbKaa5fLlghgU1mq9EBdYi8.class, $$Lambda$FlutterFirebaseAuthPlugin$zvCx3nuMXHizMQSyQ40X01qF_8.class})
public class FlutterFirebaseAuthPlugin implements FlutterFirebasePlugin, MethodChannel.MethodCallHandler, FlutterPlugin, ActivityAware {
    static final HashMap<Integer, AuthCredential> authCredentials = new HashMap<>();
    private static final HashMap<String, FirebaseAuth.AuthStateListener> authListeners = new HashMap<>();
    /* access modifiers changed from: private */
    public static final HashMap<Integer, PhoneAuthProvider.ForceResendingToken> forceResendingTokens = new HashMap<>();
    private static final HashMap<String, FirebaseAuth.IdTokenListener> idTokenListeners = new HashMap<>();
    private Activity activity;
    /* access modifiers changed from: private */
    public MethodChannel channel;
    private PluginRegistry.Registrar registrar;

    public static void registerWith(PluginRegistry.Registrar registrar2) {
        FlutterFirebaseAuthPlugin instance = new FlutterFirebaseAuthPlugin();
        instance.registrar = registrar2;
        instance.initInstance(registrar2.messenger());
    }

    static Map<String, Object> parseAuthCredential(AuthCredential authCredential) {
        if (authCredential == null) {
            return null;
        }
        int authCredentialHashCode = authCredential.hashCode();
        authCredentials.put(Integer.valueOf(authCredentialHashCode), authCredential);
        Map<String, Object> output = new HashMap<>();
        output.put(Constants.PROVIDER_ID, authCredential.getProvider());
        output.put(Constants.SIGN_IN_METHOD, authCredential.getSignInMethod());
        output.put(Constants.TOKEN, Integer.valueOf(authCredentialHashCode));
        return output;
    }

    private void initInstance(BinaryMessenger messenger) {
        FlutterFirebasePluginRegistry.registerPlugin("plugins.flutter.io/firebase_auth", this);
        MethodChannel methodChannel = new MethodChannel(messenger, "plugins.flutter.io/firebase_auth");
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(this);
    }

    public void onAttachedToEngine(@NonNull FlutterPlugin.FlutterPluginBinding binding) {
        initInstance(binding.getBinaryMessenger());
    }

    public void onDetachedFromEngine(@NonNull FlutterPlugin.FlutterPluginBinding binding) {
        removeEventListeners();
        this.channel.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
        this.channel = null;
    }

    public void onAttachedToActivity(ActivityPluginBinding activityPluginBinding) {
        this.activity = activityPluginBinding.getActivity();
    }

    public void onDetachedFromActivityForConfigChanges() {
        this.activity = null;
    }

    public void onReattachedToActivityForConfigChanges(ActivityPluginBinding activityPluginBinding) {
        this.activity = activityPluginBinding.getActivity();
    }

    public void onDetachedFromActivity() {
        this.activity = null;
    }

    private void removeEventListeners() {
        Iterator<Map.Entry<String, FirebaseAuth.AuthStateListener>> it = authListeners.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<?, ?> pair = it.next();
            FirebaseAuth.getInstance(FirebaseApp.getInstance((String) pair.getKey())).removeAuthStateListener((FirebaseAuth.AuthStateListener) pair.getValue());
            it.remove();
        }
        Iterator<Map.Entry<String, FirebaseAuth.IdTokenListener>> it2 = idTokenListeners.entrySet().iterator();
        while (it2.hasNext()) {
            Map.Entry<?, ?> pair2 = it2.next();
            FirebaseAuth.getInstance(FirebaseApp.getInstance((String) pair2.getKey())).removeIdTokenListener((FirebaseAuth.IdTokenListener) pair2.getValue());
            it2.remove();
        }
    }

    private Activity getActivity() {
        PluginRegistry.Registrar registrar2 = this.registrar;
        return registrar2 != null ? registrar2.activity() : this.activity;
    }

    private FirebaseAuth getAuth(Map<String, Object> arguments) {
        return FirebaseAuth.getInstance(FirebaseApp.getInstance((String) Objects.requireNonNull(arguments.get(Constants.APP_NAME))));
    }

    /* access modifiers changed from: private */
    public MethodChannel.Result getMethodChannelResultHandler(final String method) {
        return new MethodChannel.Result() {
            public void success(@Nullable Object result) {
            }

            public void error(String errorCode, @Nullable String errorMessage, @Nullable Object errorDetails) {
                Log.e(Constants.TAG, method + " error (" + errorCode + "): " + errorMessage);
            }

            public void notImplemented() {
                Log.e(Constants.TAG, method + " has not been implemented");
            }
        };
    }

    private FirebaseUser getCurrentUser(Map<String, Object> arguments) {
        return FirebaseAuth.getInstance(FirebaseApp.getInstance((String) Objects.requireNonNull(arguments.get(Constants.APP_NAME)))).getCurrentUser();
    }

    private AuthCredential getCredential(Map<String, Object> arguments) throws FlutterFirebaseAuthPluginException {
        Map<String, Object> credentialMap = (Map) Objects.requireNonNull(arguments.get(Constants.CREDENTIAL));
        if (credentialMap.get(Constants.TOKEN) != null) {
            AuthCredential credential = authCredentials.get(Integer.valueOf(((Integer) credentialMap.get(Constants.TOKEN)).intValue()));
            if (credential != null) {
                return credential;
            }
            throw FlutterFirebaseAuthPluginException.invalidCredential();
        }
        String signInMethod = (String) Objects.requireNonNull(credentialMap.get(Constants.SIGN_IN_METHOD));
        String secret = (String) credentialMap.get(Constants.SECRET);
        String idToken = (String) credentialMap.get(Constants.ID_TOKEN);
        String accessToken = (String) credentialMap.get(Constants.ACCESS_TOKEN);
        String rawNonce = (String) credentialMap.get(Constants.RAW_NONCE);
        char c = 65535;
        switch (signInMethod.hashCode()) {
            case -1830313082:
                if (signInMethod.equals("twitter.com")) {
                    c = 4;
                    break;
                }
                break;
            case -1536293812:
                if (signInMethod.equals("google.com")) {
                    c = 3;
                    break;
                }
                break;
            case -364826023:
                if (signInMethod.equals("facebook.com")) {
                    c = 2;
                    break;
                }
                break;
            case 105516695:
                if (signInMethod.equals(Constants.SIGN_IN_METHOD_OAUTH)) {
                    c = 7;
                    break;
                }
                break;
            case 106642798:
                if (signInMethod.equals("phone")) {
                    c = 6;
                    break;
                }
                break;
            case 1216985755:
                if (signInMethod.equals("password")) {
                    c = 0;
                    break;
                }
                break;
            case 1985010934:
                if (signInMethod.equals("github.com")) {
                    c = 5;
                    break;
                }
                break;
            case 2120171958:
                if (signInMethod.equals("emailLink")) {
                    c = 1;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return EmailAuthProvider.getCredential((String) Objects.requireNonNull(credentialMap.get("email")), (String) Objects.requireNonNull(secret));
            case 1:
                return EmailAuthProvider.getCredentialWithLink((String) Objects.requireNonNull(credentialMap.get("email")), (String) Objects.requireNonNull(credentialMap.get("emailLink")));
            case 2:
                return FacebookAuthProvider.getCredential((String) Objects.requireNonNull(accessToken));
            case 3:
                return GoogleAuthProvider.getCredential(idToken, accessToken);
            case 4:
                return TwitterAuthProvider.getCredential((String) Objects.requireNonNull(accessToken), (String) Objects.requireNonNull(secret));
            case 5:
                return GithubAuthProvider.getCredential((String) Objects.requireNonNull(accessToken));
            case 6:
                return PhoneAuthProvider.getCredential((String) Objects.requireNonNull(credentialMap.get(Constants.VERIFICATION_ID)), (String) Objects.requireNonNull(credentialMap.get(Constants.SMS_CODE)));
            case 7:
                OAuthProvider.CredentialBuilder builder = OAuthProvider.newCredentialBuilder((String) Objects.requireNonNull(credentialMap.get(Constants.PROVIDER_ID)));
                builder.setAccessToken((String) Objects.requireNonNull(accessToken));
                if (rawNonce == null) {
                    builder.setIdToken((String) Objects.requireNonNull(idToken));
                } else {
                    builder.setIdTokenWithRawNonce((String) Objects.requireNonNull(idToken), rawNonce);
                }
                return builder.build();
            default:
                return null;
        }
    }

    private Map<String, Object> parseActionCodeResult(@NonNull ActionCodeResult actionCodeResult) {
        Map<String, Object> output = new HashMap<>();
        Map<String, Object> data = new HashMap<>();
        int operation = actionCodeResult.getOperation();
        if (operation == 0) {
            output.put("operation", 1);
        } else if (operation == 1) {
            output.put("operation", 2);
        } else if (operation == 2) {
            output.put("operation", 3);
        } else if (operation == 4) {
            output.put("operation", 4);
        } else if (operation == 5) {
            output.put("operation", 5);
        } else if (operation != 6) {
            output.put("operation", 0);
        } else {
            output.put("operation", 6);
        }
        ActionCodeInfo actionCodeInfo = actionCodeResult.getInfo();
        if ((actionCodeInfo != null && operation == 1) || operation == 0) {
            data.put("email", actionCodeInfo.getEmail());
            data.put(Constants.PREVIOUS_EMAIL, (Object) null);
        } else if (operation == 6) {
            data.put("email", (Object) null);
            data.put(Constants.PREVIOUS_EMAIL, (Object) null);
        } else if (operation == 2 || operation == 5) {
            ActionCodeEmailInfo actionCodeEmailInfo = (ActionCodeEmailInfo) Objects.requireNonNull(actionCodeInfo);
            data.put("email", actionCodeEmailInfo.getEmail());
            data.put(Constants.PREVIOUS_EMAIL, actionCodeEmailInfo.getPreviousEmail());
        }
        output.put("data", data);
        return output;
    }

    private Map<String, Object> parseAuthResult(@NonNull AuthResult authResult) {
        Map<String, Object> output = new HashMap<>();
        output.put(Constants.ADDITIONAL_USER_INFO, parseAdditionalUserInfo(authResult.getAdditionalUserInfo()));
        output.put(Constants.AUTH_CREDENTIAL, parseAuthCredential(authResult.getCredential()));
        output.put(Constants.USER, parseFirebaseUser(authResult.getUser()));
        return output;
    }

    private Map<String, Object> parseAdditionalUserInfo(AdditionalUserInfo additionalUserInfo) {
        if (additionalUserInfo == null) {
            return null;
        }
        Map<String, Object> output = new HashMap<>();
        output.put(Constants.IS_NEW_USER, Boolean.valueOf(additionalUserInfo.isNewUser()));
        output.put("profile", additionalUserInfo.getProfile());
        output.put(Constants.PROVIDER_ID, additionalUserInfo.getProviderId());
        output.put(Constants.USERNAME, additionalUserInfo.getUsername());
        return output;
    }

    private Map<String, Object> parseFirebaseUser(FirebaseUser firebaseUser) {
        if (firebaseUser == null) {
            return null;
        }
        Map<String, Object> output = new HashMap<>();
        Map<String, Object> metadata = new HashMap<>();
        output.put(Constants.DISPLAY_NAME, firebaseUser.getDisplayName());
        output.put("email", firebaseUser.getEmail());
        output.put(Constants.EMAIL_VERIFIED, Boolean.valueOf(firebaseUser.isEmailVerified()));
        output.put(Constants.IS_ANONYMOUS, Boolean.valueOf(firebaseUser.isAnonymous()));
        metadata.put(Constants.CREATION_TIME, Long.valueOf(firebaseUser.getMetadata().getCreationTimestamp()));
        metadata.put(Constants.LAST_SIGN_IN_TIME, Long.valueOf(firebaseUser.getMetadata().getLastSignInTimestamp()));
        output.put(Constants.METADATA, metadata);
        output.put(Constants.PHONE_NUMBER, firebaseUser.getPhoneNumber());
        output.put(Constants.PHOTO_URL, parsePhotoUrl(firebaseUser.getPhotoUrl()));
        output.put(Constants.PROVIDER_DATA, parseUserInfoList(firebaseUser.getProviderData()));
        output.put(Constants.REFRESH_TOKEN, "");
        output.put(Constants.UID, firebaseUser.getUid());
        return output;
    }

    private List<Map<String, Object>> parseUserInfoList(List<? extends UserInfo> userInfoList) {
        List<Map<String, Object>> output = new ArrayList<>();
        for (UserInfo userInfo : userInfoList) {
            if (!FirebaseAuthProvider.PROVIDER_ID.equals(userInfo.getProviderId())) {
                output.add(parseUserInfo(userInfo));
            }
        }
        return output;
    }

    private Map<String, Object> parseUserInfo(@NonNull UserInfo userInfo) {
        Map<String, Object> output = new HashMap<>();
        output.put(Constants.DISPLAY_NAME, userInfo.getDisplayName());
        output.put("email", userInfo.getEmail());
        output.put(Constants.PHONE_NUMBER, userInfo.getPhoneNumber());
        output.put(Constants.PHOTO_URL, parsePhotoUrl(userInfo.getPhotoUrl()));
        output.put(Constants.PROVIDER_ID, userInfo.getProviderId());
        output.put(Constants.UID, userInfo.getUid());
        return output;
    }

    private String parsePhotoUrl(Uri photoUri) {
        if (photoUri == null) {
            return null;
        }
        String photoUrl = photoUri.toString();
        if ("".equals(photoUrl)) {
            return null;
        }
        return photoUrl;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.google.firebase.auth.ActionCodeSettings getActionCodeSettings(@androidx.annotation.NonNull java.util.Map<java.lang.String, java.lang.Object> r7) {
        /*
            r6 = this;
            com.google.firebase.auth.ActionCodeSettings$Builder r0 = com.google.firebase.auth.ActionCodeSettings.newBuilder()
            java.lang.String r1 = "url"
            java.lang.Object r1 = r7.get(r1)
            java.lang.Object r1 = java.util.Objects.requireNonNull(r1)
            java.lang.String r1 = (java.lang.String) r1
            r0.setUrl(r1)
            java.lang.String r1 = "dynamicLinkDomain"
            java.lang.Object r2 = r7.get(r1)
            if (r2 == 0) goto L_0x0029
            java.lang.Object r1 = r7.get(r1)
            java.lang.Object r1 = java.util.Objects.requireNonNull(r1)
            java.lang.String r1 = (java.lang.String) r1
            r0.setDynamicLinkDomain(r1)
        L_0x0029:
            java.lang.String r1 = "handleCodeInApp"
            java.lang.Object r2 = r7.get(r1)
            if (r2 == 0) goto L_0x0043
            java.lang.Object r1 = r7.get(r1)
            java.lang.Object r1 = java.util.Objects.requireNonNull(r1)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            r0.setHandleCodeInApp(r1)
        L_0x0043:
            java.lang.String r1 = "android"
            java.lang.Object r2 = r7.get(r1)
            if (r2 == 0) goto L_0x008e
            java.lang.Object r1 = r7.get(r1)
            java.lang.Object r1 = java.util.Objects.requireNonNull(r1)
            java.util.Map r1 = (java.util.Map) r1
            r2 = 0
            java.lang.String r3 = "installApp"
            java.lang.Object r4 = r1.get(r3)
            if (r4 == 0) goto L_0x006e
            java.lang.Object r3 = r1.get(r3)
            java.lang.Object r3 = java.util.Objects.requireNonNull(r3)
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r2 = r3.booleanValue()
        L_0x006e:
            r3 = 0
            java.lang.String r4 = "minimumVersion"
            java.lang.Object r5 = r1.get(r4)
            if (r5 == 0) goto L_0x007e
            java.lang.Object r4 = r1.get(r4)
            r3 = r4
            java.lang.String r3 = (java.lang.String) r3
        L_0x007e:
            java.lang.String r4 = "packageName"
            java.lang.Object r4 = r1.get(r4)
            java.lang.Object r4 = java.util.Objects.requireNonNull(r4)
            java.lang.String r4 = (java.lang.String) r4
            r0.setAndroidPackageName(r4, r2, r3)
        L_0x008e:
            java.lang.String r1 = "iOS"
            java.lang.Object r2 = r7.get(r1)
            if (r2 == 0) goto L_0x00b0
            java.lang.Object r1 = r7.get(r1)
            java.lang.Object r1 = java.util.Objects.requireNonNull(r1)
            java.util.Map r1 = (java.util.Map) r1
            java.lang.String r2 = "bundleId"
            java.lang.Object r2 = r1.get(r2)
            java.lang.Object r2 = java.util.Objects.requireNonNull(r2)
            java.lang.String r2 = (java.lang.String) r2
            r0.setIOSBundleId(r2)
        L_0x00b0:
            com.google.firebase.auth.ActionCodeSettings r1 = r0.build()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.plugins.firebase.auth.FlutterFirebaseAuthPlugin.getActionCodeSettings(java.util.Map):com.google.firebase.auth.ActionCodeSettings");
    }

    private Map<String, Object> parseTokenResult(@NonNull GetTokenResult tokenResult) {
        Map<String, Object> output = new HashMap<>();
        output.put(Constants.AUTH_TIMESTAMP, Long.valueOf(tokenResult.getAuthTimestamp() * 1000));
        output.put(Constants.CLAIMS, tokenResult.getClaims());
        output.put(Constants.EXPIRATION_TIMESTAMP, Long.valueOf(tokenResult.getExpirationTimestamp() * 1000));
        output.put(Constants.ISSUED_AT_TIMESTAMP, Long.valueOf(tokenResult.getIssuedAtTimestamp() * 1000));
        output.put(Constants.SIGN_IN_PROVIDER, tokenResult.getSignInProvider());
        output.put(Constants.SIGN_IN_SECOND_FACTOR, tokenResult.getSignInSecondFactor());
        output.put(Constants.TOKEN, tokenResult.getToken());
        return output;
    }

    private Task<Void> registerChangeListeners(Map<String, Object> arguments) {
        return Tasks.call(cachedThreadPool, new Callable(arguments) {
            public final /* synthetic */ Map f$1;

            {
                this.f$1 = r2;
            }

            public final Object call() {
                return FlutterFirebaseAuthPlugin.this.lambda$registerChangeListeners$2$FlutterFirebaseAuthPlugin(this.f$1);
            }
        });
    }

    public /* synthetic */ Void lambda$registerChangeListeners$2$FlutterFirebaseAuthPlugin(Map arguments) throws Exception {
        String appName = (String) Objects.requireNonNull(arguments.get(Constants.APP_NAME));
        FirebaseAuth firebaseAuth = getAuth(arguments);
        FirebaseAuth.AuthStateListener authStateListener = authListeners.get(appName);
        FirebaseAuth.IdTokenListener idTokenListener = idTokenListeners.get(appName);
        Map<String, Object> event = new HashMap<>();
        event.put(Constants.APP_NAME, appName);
        if (authStateListener == null) {
            FirebaseAuth.AuthStateListener newAuthStateListener = new FirebaseAuth.AuthStateListener(event) {
                public final /* synthetic */ Map f$1;

                {
                    this.f$1 = r2;
                }

                public final void onAuthStateChanged(FirebaseAuth firebaseAuth) {
                    FlutterFirebaseAuthPlugin.this.lambda$null$0$FlutterFirebaseAuthPlugin(this.f$1, firebaseAuth);
                }
            };
            firebaseAuth.addAuthStateListener(newAuthStateListener);
            authListeners.put(appName, newAuthStateListener);
        }
        if (idTokenListener != null) {
            return null;
        }
        FirebaseAuth.IdTokenListener newIdTokenChangeListener = new FirebaseAuth.IdTokenListener(event) {
            public final /* synthetic */ Map f$1;

            {
                this.f$1 = r2;
            }

            public final void onIdTokenChanged(FirebaseAuth firebaseAuth) {
                FlutterFirebaseAuthPlugin.this.lambda$null$1$FlutterFirebaseAuthPlugin(this.f$1, firebaseAuth);
            }
        };
        firebaseAuth.addIdTokenListener(newIdTokenChangeListener);
        idTokenListeners.put(appName, newIdTokenChangeListener);
        return null;
    }

    public /* synthetic */ void lambda$null$0$FlutterFirebaseAuthPlugin(Map event, FirebaseAuth auth) {
        FirebaseUser user = auth.getCurrentUser();
        if (user == null) {
            event.put(Constants.USER, (Object) null);
        } else {
            event.put(Constants.USER, parseFirebaseUser(user));
        }
        this.channel.invokeMethod("Auth#authStateChanges", event, getMethodChannelResultHandler("Auth#authStateChanges"));
    }

    public /* synthetic */ void lambda$null$1$FlutterFirebaseAuthPlugin(Map event, FirebaseAuth auth) {
        FirebaseUser user = auth.getCurrentUser();
        if (user == null) {
            event.put(Constants.USER, (Object) null);
        } else {
            event.put(Constants.USER, parseFirebaseUser(user));
        }
        this.channel.invokeMethod("Auth#idTokenChanges", event, getMethodChannelResultHandler("Auth#idTokenChanges"));
    }

    private Task<Void> applyActionCode(Map<String, Object> arguments) {
        return Tasks.call(cachedThreadPool, new Callable(arguments) {
            public final /* synthetic */ Map f$1;

            {
                this.f$1 = r2;
            }

            public final Object call() {
                return FlutterFirebaseAuthPlugin.this.lambda$applyActionCode$3$FlutterFirebaseAuthPlugin(this.f$1);
            }
        });
    }

    public /* synthetic */ Void lambda$applyActionCode$3$FlutterFirebaseAuthPlugin(Map arguments) throws Exception {
        return (Void) Tasks.await(getAuth(arguments).applyActionCode((String) Objects.requireNonNull(arguments.get(Constants.CODE))));
    }

    private Task<Map<String, Object>> checkActionCode(Map<String, Object> arguments) {
        return Tasks.call(cachedThreadPool, new Callable(arguments) {
            public final /* synthetic */ Map f$1;

            {
                this.f$1 = r2;
            }

            public final Object call() {
                return FlutterFirebaseAuthPlugin.this.lambda$checkActionCode$4$FlutterFirebaseAuthPlugin(this.f$1);
            }
        });
    }

    public /* synthetic */ Map lambda$checkActionCode$4$FlutterFirebaseAuthPlugin(Map arguments) throws Exception {
        return parseActionCodeResult((ActionCodeResult) Tasks.await(getAuth(arguments).checkActionCode((String) Objects.requireNonNull(arguments.get(Constants.CODE)))));
    }

    private Task<Void> confirmPasswordReset(Map<String, Object> arguments) {
        return Tasks.call(cachedThreadPool, new Callable(arguments) {
            public final /* synthetic */ Map f$1;

            {
                this.f$1 = r2;
            }

            public final Object call() {
                return FlutterFirebaseAuthPlugin.this.lambda$confirmPasswordReset$5$FlutterFirebaseAuthPlugin(this.f$1);
            }
        });
    }

    public /* synthetic */ Void lambda$confirmPasswordReset$5$FlutterFirebaseAuthPlugin(Map arguments) throws Exception {
        return (Void) Tasks.await(getAuth(arguments).confirmPasswordReset((String) Objects.requireNonNull(arguments.get(Constants.CODE)), (String) Objects.requireNonNull(arguments.get(Constants.NEW_PASSWORD))));
    }

    private Task<Map<String, Object>> createUserWithEmailAndPassword(Map<String, Object> arguments) {
        return Tasks.call(cachedThreadPool, new Callable(arguments) {
            public final /* synthetic */ Map f$1;

            {
                this.f$1 = r2;
            }

            public final Object call() {
                return FlutterFirebaseAuthPlugin.this.lambda$createUserWithEmailAndPassword$6$FlutterFirebaseAuthPlugin(this.f$1);
            }
        });
    }

    public /* synthetic */ Map lambda$createUserWithEmailAndPassword$6$FlutterFirebaseAuthPlugin(Map arguments) throws Exception {
        return parseAuthResult((AuthResult) Tasks.await(getAuth(arguments).createUserWithEmailAndPassword((String) Objects.requireNonNull(arguments.get("email")), (String) Objects.requireNonNull(arguments.get("password")))));
    }

    private Task<Map<String, Object>> fetchSignInMethodsForEmail(Map<String, Object> arguments) {
        return Tasks.call(cachedThreadPool, new Callable(arguments) {
            public final /* synthetic */ Map f$1;

            {
                this.f$1 = r2;
            }

            public final Object call() {
                return FlutterFirebaseAuthPlugin.this.lambda$fetchSignInMethodsForEmail$7$FlutterFirebaseAuthPlugin(this.f$1);
            }
        });
    }

    public /* synthetic */ Map lambda$fetchSignInMethodsForEmail$7$FlutterFirebaseAuthPlugin(Map arguments) throws Exception {
        Map<String, Object> output = new HashMap<>();
        output.put(Constants.PROVIDERS, ((SignInMethodQueryResult) Tasks.await(getAuth(arguments).fetchSignInMethodsForEmail((String) Objects.requireNonNull(arguments.get("email"))))).getSignInMethods());
        return output;
    }

    private Task<Void> sendPasswordResetEmail(Map<String, Object> arguments) {
        return Tasks.call(cachedThreadPool, new Callable(arguments) {
            public final /* synthetic */ Map f$1;

            {
                this.f$1 = r2;
            }

            public final Object call() {
                return FlutterFirebaseAuthPlugin.this.lambda$sendPasswordResetEmail$8$FlutterFirebaseAuthPlugin(this.f$1);
            }
        });
    }

    public /* synthetic */ Void lambda$sendPasswordResetEmail$8$FlutterFirebaseAuthPlugin(Map arguments) throws Exception {
        FirebaseAuth firebaseAuth = getAuth(arguments);
        String email = (String) Objects.requireNonNull(arguments.get("email"));
        Object rawActionCodeSettings = arguments.get(Constants.ACTION_CODE_SETTINGS);
        if (rawActionCodeSettings == null) {
            return (Void) Tasks.await(firebaseAuth.sendPasswordResetEmail(email));
        }
        return (Void) Tasks.await(firebaseAuth.sendPasswordResetEmail(email, getActionCodeSettings((Map) rawActionCodeSettings)));
    }

    private Task<Void> sendSignInLinkToEmail(Map<String, Object> arguments) {
        return Tasks.call(cachedThreadPool, new Callable(arguments) {
            public final /* synthetic */ Map f$1;

            {
                this.f$1 = r2;
            }

            public final Object call() {
                return FlutterFirebaseAuthPlugin.this.lambda$sendSignInLinkToEmail$9$FlutterFirebaseAuthPlugin(this.f$1);
            }
        });
    }

    public /* synthetic */ Void lambda$sendSignInLinkToEmail$9$FlutterFirebaseAuthPlugin(Map arguments) throws Exception {
        return (Void) Tasks.await(getAuth(arguments).sendSignInLinkToEmail((String) Objects.requireNonNull(arguments.get("email")), getActionCodeSettings((Map) Objects.requireNonNull(arguments.get(Constants.ACTION_CODE_SETTINGS)))));
    }

    private Task<Map<String, Object>> setLanguageCode(Map<String, Object> arguments) {
        return Tasks.call(cachedThreadPool, new Callable(arguments) {
            public final /* synthetic */ Map f$1;

            {
                this.f$1 = r2;
            }

            public final Object call() {
                return FlutterFirebaseAuthPlugin.this.lambda$setLanguageCode$10$FlutterFirebaseAuthPlugin(this.f$1);
            }
        });
    }

    public /* synthetic */ Map lambda$setLanguageCode$10$FlutterFirebaseAuthPlugin(Map arguments) throws Exception {
        final FirebaseAuth firebaseAuth = getAuth(arguments);
        String languageCode = (String) arguments.get(Constants.LANGUAGE_CODE);
        if (languageCode == null) {
            firebaseAuth.useAppLanguage();
        } else {
            firebaseAuth.setLanguageCode(languageCode);
        }
        return new HashMap<String, Object>() {
            {
                put(Constants.LANGUAGE_CODE, firebaseAuth.getLanguageCode());
            }
        };
    }

    static /* synthetic */ Void lambda$setSettings$11() throws Exception {
        return null;
    }

    private Task<Void> setSettings() {
        return Tasks.call(cachedThreadPool, $$Lambda$FlutterFirebaseAuthPlugin$Ct7IavKAnZl0D4Jts7Cjq4_lx0I.INSTANCE);
    }

    private Task<Map<String, Object>> signInAnonymously(Map<String, Object> arguments) {
        return Tasks.call(cachedThreadPool, new Callable(arguments) {
            public final /* synthetic */ Map f$1;

            {
                this.f$1 = r2;
            }

            public final Object call() {
                return FlutterFirebaseAuthPlugin.this.lambda$signInAnonymously$12$FlutterFirebaseAuthPlugin(this.f$1);
            }
        });
    }

    public /* synthetic */ Map lambda$signInAnonymously$12$FlutterFirebaseAuthPlugin(Map arguments) throws Exception {
        return parseAuthResult((AuthResult) Tasks.await(getAuth(arguments).signInAnonymously()));
    }

    private Task<Map<String, Object>> signInWithCredential(Map<String, Object> arguments) {
        return Tasks.call(cachedThreadPool, new Callable(arguments) {
            public final /* synthetic */ Map f$1;

            {
                this.f$1 = r2;
            }

            public final Object call() {
                return FlutterFirebaseAuthPlugin.this.lambda$signInWithCredential$13$FlutterFirebaseAuthPlugin(this.f$1);
            }
        });
    }

    public /* synthetic */ Map lambda$signInWithCredential$13$FlutterFirebaseAuthPlugin(Map arguments) throws Exception {
        FirebaseAuth firebaseAuth = getAuth(arguments);
        AuthCredential credential = getCredential(arguments);
        if (credential != null) {
            return parseAuthResult((AuthResult) Tasks.await(firebaseAuth.signInWithCredential(credential)));
        }
        throw FlutterFirebaseAuthPluginException.invalidCredential();
    }

    private Task<Map<String, Object>> signInWithCustomToken(Map<String, Object> arguments) {
        return Tasks.call(cachedThreadPool, new Callable(arguments) {
            public final /* synthetic */ Map f$1;

            {
                this.f$1 = r2;
            }

            public final Object call() {
                return FlutterFirebaseAuthPlugin.this.lambda$signInWithCustomToken$14$FlutterFirebaseAuthPlugin(this.f$1);
            }
        });
    }

    public /* synthetic */ Map lambda$signInWithCustomToken$14$FlutterFirebaseAuthPlugin(Map arguments) throws Exception {
        return parseAuthResult((AuthResult) Tasks.await(getAuth(arguments).signInWithCustomToken((String) Objects.requireNonNull(arguments.get(Constants.TOKEN)))));
    }

    private Task<Map<String, Object>> signInWithEmailAndPassword(Map<String, Object> arguments) {
        return Tasks.call(cachedThreadPool, new Callable(arguments) {
            public final /* synthetic */ Map f$1;

            {
                this.f$1 = r2;
            }

            public final Object call() {
                return FlutterFirebaseAuthPlugin.this.lambda$signInWithEmailAndPassword$15$FlutterFirebaseAuthPlugin(this.f$1);
            }
        });
    }

    public /* synthetic */ Map lambda$signInWithEmailAndPassword$15$FlutterFirebaseAuthPlugin(Map arguments) throws Exception {
        return parseAuthResult((AuthResult) Tasks.await(getAuth(arguments).signInWithEmailAndPassword((String) Objects.requireNonNull(arguments.get("email")), (String) Objects.requireNonNull(arguments.get("password")))));
    }

    private Task<Map<String, Object>> signInWithEmailLink(Map<String, Object> arguments) {
        return Tasks.call(cachedThreadPool, new Callable(arguments) {
            public final /* synthetic */ Map f$1;

            {
                this.f$1 = r2;
            }

            public final Object call() {
                return FlutterFirebaseAuthPlugin.this.lambda$signInWithEmailLink$16$FlutterFirebaseAuthPlugin(this.f$1);
            }
        });
    }

    public /* synthetic */ Map lambda$signInWithEmailLink$16$FlutterFirebaseAuthPlugin(Map arguments) throws Exception {
        return parseAuthResult((AuthResult) Tasks.await(getAuth(arguments).signInWithEmailLink((String) Objects.requireNonNull(arguments.get("email")), (String) Objects.requireNonNull(arguments.get("emailLink")))));
    }

    private Task<Void> signOut(Map<String, Object> arguments) {
        return Tasks.call(cachedThreadPool, new Callable(arguments) {
            public final /* synthetic */ Map f$1;

            {
                this.f$1 = r2;
            }

            public final Object call() {
                return FlutterFirebaseAuthPlugin.this.lambda$signOut$17$FlutterFirebaseAuthPlugin(this.f$1);
            }
        });
    }

    public /* synthetic */ Void lambda$signOut$17$FlutterFirebaseAuthPlugin(Map arguments) throws Exception {
        getAuth(arguments).signOut();
        return null;
    }

    private Task<Map<String, Object>> verifyPasswordResetCode(Map<String, Object> arguments) {
        return Tasks.call(cachedThreadPool, new Callable(arguments) {
            public final /* synthetic */ Map f$1;

            {
                this.f$1 = r2;
            }

            public final Object call() {
                return FlutterFirebaseAuthPlugin.this.lambda$verifyPasswordResetCode$18$FlutterFirebaseAuthPlugin(this.f$1);
            }
        });
    }

    public /* synthetic */ Map lambda$verifyPasswordResetCode$18$FlutterFirebaseAuthPlugin(Map arguments) throws Exception {
        Map<String, Object> output = new HashMap<>();
        output.put("email", Tasks.await(getAuth(arguments).verifyPasswordResetCode((String) Objects.requireNonNull(arguments.get(Constants.CODE)))));
        return output;
    }

    private Task<Void> verifyPhoneNumber(Map<String, Object> arguments) {
        return Tasks.call(cachedThreadPool, new Callable(arguments) {
            public final /* synthetic */ Map f$1;

            {
                this.f$1 = r2;
            }

            public final Object call() {
                return FlutterFirebaseAuthPlugin.this.lambda$verifyPhoneNumber$19$FlutterFirebaseAuthPlugin(this.f$1);
            }
        });
    }

    public /* synthetic */ Void lambda$verifyPhoneNumber$19$FlutterFirebaseAuthPlugin(Map arguments) throws Exception {
        FirebaseAuth firebaseAuth = getAuth(arguments);
        String phoneNumber = (String) Objects.requireNonNull(arguments.get(Constants.PHONE_NUMBER));
        int handle = ((Integer) Objects.requireNonNull(arguments.get(Constants.HANDLE))).intValue();
        int timeout = ((Integer) Objects.requireNonNull(arguments.get(Constants.TIMEOUT))).intValue();
        final Map<String, Object> event = new HashMap<>();
        event.put(Constants.HANDLE, Integer.valueOf(handle));
        PhoneAuthProvider.OnVerificationStateChangedCallbacks callbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                int phoneAuthCredentialHashCode = phoneAuthCredential.hashCode();
                FlutterFirebaseAuthPlugin.authCredentials.put(Integer.valueOf(phoneAuthCredentialHashCode), phoneAuthCredential);
                event.put(Constants.TOKEN, Integer.valueOf(phoneAuthCredentialHashCode));
                if (phoneAuthCredential.getSmsCode() != null) {
                    event.put(Constants.SMS_CODE, phoneAuthCredential.getSmsCode());
                }
                FlutterFirebaseAuthPlugin.this.channel.invokeMethod("Auth#phoneVerificationCompleted", event, FlutterFirebaseAuthPlugin.this.getMethodChannelResultHandler("Auth#phoneVerificationCompleted"));
            }

            public void onVerificationFailed(@NonNull FirebaseException e) {
                Map error = new HashMap();
                error.put("message", e.getLocalizedMessage());
                error.put("details", FlutterFirebaseAuthPlugin.this.getExceptionDetails(e));
                event.put("error", error);
                FlutterFirebaseAuthPlugin.this.channel.invokeMethod("Auth#phoneVerificationFailed", event, FlutterFirebaseAuthPlugin.this.getMethodChannelResultHandler("Auth#phoneVerificationFailed"));
            }

            public void onCodeSent(@NonNull String verificationId, @NonNull PhoneAuthProvider.ForceResendingToken token) {
                int forceResendingTokenHashCode = token.hashCode();
                FlutterFirebaseAuthPlugin.forceResendingTokens.put(Integer.valueOf(forceResendingTokenHashCode), token);
                event.put(Constants.VERIFICATION_ID, verificationId);
                event.put(Constants.FORCE_RESENDING_TOKEN, Integer.valueOf(forceResendingTokenHashCode));
                FlutterFirebaseAuthPlugin.this.channel.invokeMethod("Auth#phoneCodeSent", event, FlutterFirebaseAuthPlugin.this.getMethodChannelResultHandler("Auth#phoneCodeSent"));
            }

            public void onCodeAutoRetrievalTimeOut(@NonNull String verificationId) {
                event.put(Constants.VERIFICATION_ID, verificationId);
                FlutterFirebaseAuthPlugin.this.channel.invokeMethod("Auth#phoneCodeAutoRetrievalTimeout", event, FlutterFirebaseAuthPlugin.this.getMethodChannelResultHandler("Auth#phoneCodeAutoRetrievalTimeout"));
            }
        };
        if (arguments.get(Constants.AUTO_RETRIEVED_SMS_CODE_FOR_TESTING) != null) {
            firebaseAuth.getFirebaseAuthSettings().setAutoRetrievedSmsCodeForPhoneNumber(phoneNumber, (String) Objects.requireNonNull(arguments.get(Constants.AUTO_RETRIEVED_SMS_CODE_FOR_TESTING)));
        }
        PhoneAuthOptions.Builder phoneAuthOptionsBuilder = new PhoneAuthOptions.Builder(firebaseAuth);
        phoneAuthOptionsBuilder.setActivity(getActivity());
        phoneAuthOptionsBuilder.setPhoneNumber(phoneNumber);
        phoneAuthOptionsBuilder.setCallbacks(callbacks);
        phoneAuthOptionsBuilder.setTimeout(Long.valueOf((long) timeout), TimeUnit.MILLISECONDS);
        if (arguments.get(Constants.FORCE_RESENDING_TOKEN) != null) {
            PhoneAuthProvider.ForceResendingToken forceResendingToken = forceResendingTokens.get(Integer.valueOf(((Integer) Objects.requireNonNull(arguments.get(Constants.FORCE_RESENDING_TOKEN))).intValue()));
            if (forceResendingToken != null) {
                phoneAuthOptionsBuilder.setForceResendingToken(forceResendingToken);
            }
        }
        PhoneAuthProvider.verifyPhoneNumber(phoneAuthOptionsBuilder.build());
        return null;
    }

    private Task<Void> deleteUser(Map<String, Object> arguments) {
        return Tasks.call(cachedThreadPool, new Callable(arguments) {
            public final /* synthetic */ Map f$1;

            {
                this.f$1 = r2;
            }

            public final Object call() {
                return FlutterFirebaseAuthPlugin.this.lambda$deleteUser$20$FlutterFirebaseAuthPlugin(this.f$1);
            }
        });
    }

    public /* synthetic */ Void lambda$deleteUser$20$FlutterFirebaseAuthPlugin(Map arguments) throws Exception {
        FirebaseUser firebaseUser = getCurrentUser(arguments);
        if (firebaseUser != null) {
            return (Void) Tasks.await(firebaseUser.delete());
        }
        throw FlutterFirebaseAuthPluginException.noUser();
    }

    private Task<Map<String, Object>> getIdToken(Map<String, Object> arguments) {
        return Tasks.call(cachedThreadPool, new Callable(arguments) {
            public final /* synthetic */ Map f$1;

            {
                this.f$1 = r2;
            }

            public final Object call() {
                return FlutterFirebaseAuthPlugin.this.lambda$getIdToken$21$FlutterFirebaseAuthPlugin(this.f$1);
            }
        });
    }

    public /* synthetic */ Map lambda$getIdToken$21$FlutterFirebaseAuthPlugin(Map arguments) throws Exception {
        FirebaseUser firebaseUser = getCurrentUser(arguments);
        Boolean forceRefresh = (Boolean) Objects.requireNonNull(arguments.get(Constants.FORCE_REFRESH));
        Boolean tokenOnly = (Boolean) Objects.requireNonNull(arguments.get(Constants.TOKEN_ONLY));
        if (firebaseUser != null) {
            GetTokenResult tokenResult = (GetTokenResult) Tasks.await(firebaseUser.getIdToken(forceRefresh.booleanValue()));
            if (!tokenOnly.booleanValue()) {
                return parseTokenResult(tokenResult);
            }
            Map<String, Object> output = new HashMap<>();
            output.put(Constants.TOKEN, tokenResult.getToken());
            return output;
        }
        throw FlutterFirebaseAuthPluginException.noUser();
    }

    private Task<Map<String, Object>> linkUserWithCredential(Map<String, Object> arguments) {
        return Tasks.call(cachedThreadPool, new Callable(arguments) {
            public final /* synthetic */ Map f$1;

            {
                this.f$1 = r2;
            }

            public final Object call() {
                return FlutterFirebaseAuthPlugin.this.lambda$linkUserWithCredential$22$FlutterFirebaseAuthPlugin(this.f$1);
            }
        });
    }

    public /* synthetic */ Map lambda$linkUserWithCredential$22$FlutterFirebaseAuthPlugin(Map arguments) throws Exception {
        FirebaseUser firebaseUser = getCurrentUser(arguments);
        AuthCredential credential = getCredential(arguments);
        if (firebaseUser == null) {
            throw FlutterFirebaseAuthPluginException.noUser();
        } else if (credential != null) {
            return parseAuthResult((AuthResult) Tasks.await(firebaseUser.linkWithCredential(credential)));
        } else {
            throw FlutterFirebaseAuthPluginException.invalidCredential();
        }
    }

    private Task<Map<String, Object>> reauthenticateUserWithCredential(Map<String, Object> arguments) {
        return Tasks.call(cachedThreadPool, new Callable(arguments) {
            public final /* synthetic */ Map f$1;

            {
                this.f$1 = r2;
            }

            public final Object call() {
                return FlutterFirebaseAuthPlugin.this.lambda$reauthenticateUserWithCredential$23$FlutterFirebaseAuthPlugin(this.f$1);
            }
        });
    }

    public /* synthetic */ Map lambda$reauthenticateUserWithCredential$23$FlutterFirebaseAuthPlugin(Map arguments) throws Exception {
        FirebaseUser firebaseUser = getCurrentUser(arguments);
        AuthCredential credential = getCredential(arguments);
        if (firebaseUser == null) {
            throw FlutterFirebaseAuthPluginException.noUser();
        } else if (credential != null) {
            return parseAuthResult((AuthResult) Tasks.await(firebaseUser.reauthenticateAndRetrieveData(credential)));
        } else {
            throw FlutterFirebaseAuthPluginException.invalidCredential();
        }
    }

    private Task<Map<String, Object>> reloadUser(Map<String, Object> arguments) {
        return Tasks.call(cachedThreadPool, new Callable(arguments) {
            public final /* synthetic */ Map f$1;

            {
                this.f$1 = r2;
            }

            public final Object call() {
                return FlutterFirebaseAuthPlugin.this.lambda$reloadUser$24$FlutterFirebaseAuthPlugin(this.f$1);
            }
        });
    }

    public /* synthetic */ Map lambda$reloadUser$24$FlutterFirebaseAuthPlugin(Map arguments) throws Exception {
        FirebaseUser firebaseUser = getCurrentUser(arguments);
        if (firebaseUser != null) {
            Tasks.await(firebaseUser.reload());
            return parseFirebaseUser(getCurrentUser(arguments));
        }
        throw FlutterFirebaseAuthPluginException.noUser();
    }

    private Task<Void> sendEmailVerification(Map<String, Object> arguments) {
        return Tasks.call(cachedThreadPool, new Callable(arguments) {
            public final /* synthetic */ Map f$1;

            {
                this.f$1 = r2;
            }

            public final Object call() {
                return FlutterFirebaseAuthPlugin.this.lambda$sendEmailVerification$25$FlutterFirebaseAuthPlugin(this.f$1);
            }
        });
    }

    public /* synthetic */ Void lambda$sendEmailVerification$25$FlutterFirebaseAuthPlugin(Map arguments) throws Exception {
        FirebaseUser firebaseUser = getCurrentUser(arguments);
        if (firebaseUser != null) {
            Object rawActionCodeSettings = arguments.get(Constants.ACTION_CODE_SETTINGS);
            if (rawActionCodeSettings == null) {
                return (Void) Tasks.await(firebaseUser.sendEmailVerification());
            }
            return (Void) Tasks.await(firebaseUser.sendEmailVerification(getActionCodeSettings((Map) rawActionCodeSettings)));
        }
        throw FlutterFirebaseAuthPluginException.noUser();
    }

    private Task<Map<String, Object>> unlinkUserProvider(Map<String, Object> arguments) {
        return Tasks.call(cachedThreadPool, new Callable(arguments) {
            public final /* synthetic */ Map f$1;

            {
                this.f$1 = r2;
            }

            public final Object call() {
                return FlutterFirebaseAuthPlugin.this.lambda$unlinkUserProvider$26$FlutterFirebaseAuthPlugin(this.f$1);
            }
        });
    }

    public /* synthetic */ Map lambda$unlinkUserProvider$26$FlutterFirebaseAuthPlugin(Map arguments) throws Exception {
        FirebaseUser firebaseUser = getCurrentUser(arguments);
        if (firebaseUser != null) {
            try {
                return parseAuthResult((AuthResult) Tasks.await(firebaseUser.unlink((String) Objects.requireNonNull(arguments.get(Constants.PROVIDER_ID)))));
            } catch (ExecutionException e) {
                throw FlutterFirebaseAuthPluginException.noSuchProvider();
            }
        } else {
            throw FlutterFirebaseAuthPluginException.noUser();
        }
    }

    private Task<Map<String, Object>> updateEmail(Map<String, Object> arguments) {
        return Tasks.call(cachedThreadPool, new Callable(arguments) {
            public final /* synthetic */ Map f$1;

            {
                this.f$1 = r2;
            }

            public final Object call() {
                return FlutterFirebaseAuthPlugin.this.lambda$updateEmail$27$FlutterFirebaseAuthPlugin(this.f$1);
            }
        });
    }

    public /* synthetic */ Map lambda$updateEmail$27$FlutterFirebaseAuthPlugin(Map arguments) throws Exception {
        FirebaseUser firebaseUser = getCurrentUser(arguments);
        if (firebaseUser != null) {
            Tasks.await(firebaseUser.updateEmail((String) Objects.requireNonNull(arguments.get(Constants.NEW_EMAIL))));
            Tasks.await(firebaseUser.reload());
            return parseFirebaseUser(firebaseUser);
        }
        throw FlutterFirebaseAuthPluginException.noUser();
    }

    private Task<Map<String, Object>> updatePassword(Map<String, Object> arguments) {
        return Tasks.call(cachedThreadPool, new Callable(arguments) {
            public final /* synthetic */ Map f$1;

            {
                this.f$1 = r2;
            }

            public final Object call() {
                return FlutterFirebaseAuthPlugin.this.lambda$updatePassword$28$FlutterFirebaseAuthPlugin(this.f$1);
            }
        });
    }

    public /* synthetic */ Map lambda$updatePassword$28$FlutterFirebaseAuthPlugin(Map arguments) throws Exception {
        FirebaseUser firebaseUser = getCurrentUser(arguments);
        if (firebaseUser != null) {
            Tasks.await(firebaseUser.updatePassword((String) Objects.requireNonNull(arguments.get(Constants.NEW_PASSWORD))));
            Tasks.await(firebaseUser.reload());
            return parseFirebaseUser(firebaseUser);
        }
        throw FlutterFirebaseAuthPluginException.noUser();
    }

    private Task<Map<String, Object>> updatePhoneNumber(Map<String, Object> arguments) {
        return Tasks.call(cachedThreadPool, new Callable(arguments) {
            public final /* synthetic */ Map f$1;

            {
                this.f$1 = r2;
            }

            public final Object call() {
                return FlutterFirebaseAuthPlugin.this.lambda$updatePhoneNumber$29$FlutterFirebaseAuthPlugin(this.f$1);
            }
        });
    }

    public /* synthetic */ Map lambda$updatePhoneNumber$29$FlutterFirebaseAuthPlugin(Map arguments) throws Exception {
        FirebaseUser firebaseUser = getCurrentUser(arguments);
        if (firebaseUser != null) {
            PhoneAuthCredential phoneAuthCredential = (PhoneAuthCredential) getCredential(arguments);
            if (phoneAuthCredential != null) {
                Tasks.await(firebaseUser.updatePhoneNumber(phoneAuthCredential));
                Tasks.await(firebaseUser.reload());
                return parseFirebaseUser(firebaseUser);
            }
            throw FlutterFirebaseAuthPluginException.invalidCredential();
        }
        throw FlutterFirebaseAuthPluginException.noUser();
    }

    private Task<Map<String, Object>> updateProfile(Map<String, Object> arguments) {
        return Tasks.call(cachedThreadPool, new Callable(arguments) {
            public final /* synthetic */ Map f$1;

            {
                this.f$1 = r2;
            }

            public final Object call() {
                return FlutterFirebaseAuthPlugin.this.lambda$updateProfile$30$FlutterFirebaseAuthPlugin(this.f$1);
            }
        });
    }

    public /* synthetic */ Map lambda$updateProfile$30$FlutterFirebaseAuthPlugin(Map arguments) throws Exception {
        FirebaseUser firebaseUser = getCurrentUser(arguments);
        if (firebaseUser != null) {
            Map<String, String> profile = (Map) Objects.requireNonNull(arguments.get("profile"));
            UserProfileChangeRequest.Builder builder = new UserProfileChangeRequest.Builder();
            if (profile.get(Constants.DISPLAY_NAME) != null) {
                builder.setDisplayName(profile.get(Constants.DISPLAY_NAME));
            }
            if (profile.get(Constants.PHOTO_URL) != null) {
                builder.setPhotoUri(Uri.parse(profile.get(Constants.PHOTO_URL)));
            }
            Tasks.await(firebaseUser.updateProfile(builder.build()));
            Tasks.await(firebaseUser.reload());
            return parseFirebaseUser(firebaseUser);
        }
        throw FlutterFirebaseAuthPluginException.noUser();
    }

    private Task<Void> verifyBeforeUpdateEmail(Map<String, Object> arguments) {
        return Tasks.call(cachedThreadPool, new Callable(arguments) {
            public final /* synthetic */ Map f$1;

            {
                this.f$1 = r2;
            }

            public final Object call() {
                return FlutterFirebaseAuthPlugin.this.lambda$verifyBeforeUpdateEmail$31$FlutterFirebaseAuthPlugin(this.f$1);
            }
        });
    }

    public /* synthetic */ Void lambda$verifyBeforeUpdateEmail$31$FlutterFirebaseAuthPlugin(Map arguments) throws Exception {
        FirebaseUser firebaseUser = getCurrentUser(arguments);
        if (firebaseUser != null) {
            String newEmail = (String) Objects.requireNonNull(arguments.get(Constants.NEW_EMAIL));
            Object rawActionCodeSettings = arguments.get(Constants.ACTION_CODE_SETTINGS);
            if (rawActionCodeSettings == null) {
                return (Void) Tasks.await(firebaseUser.verifyBeforeUpdateEmail(newEmail));
            }
            return (Void) Tasks.await(firebaseUser.verifyBeforeUpdateEmail(newEmail, getActionCodeSettings((Map) rawActionCodeSettings)));
        }
        throw FlutterFirebaseAuthPluginException.noUser();
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMethodCall(@androidx.annotation.NonNull io.flutter.plugin.common.MethodCall r3, @androidx.annotation.NonNull io.flutter.plugin.common.MethodChannel.Result r4) {
        /*
            r2 = this;
            java.lang.String r0 = r3.method
            int r1 = r0.hashCode()
            switch(r1) {
                case -2057012413: goto L_0x0157;
                case -1780708429: goto L_0x014c;
                case -1752633812: goto L_0x0141;
                case -1684941144: goto L_0x0136;
                case -1644801898: goto L_0x012b;
                case -1598142666: goto L_0x0120;
                case -1568968164: goto L_0x0115;
                case -1529680830: goto L_0x010b;
                case -1451942929: goto L_0x0100;
                case -1390537327: goto L_0x00f5;
                case -1351623174: goto L_0x00e9;
                case -1292431612: goto L_0x00de;
                case -1230437447: goto L_0x00d2;
                case -1027441723: goto L_0x00c6;
                case -834572032: goto L_0x00ba;
                case -695049397: goto L_0x00af;
                case -684675433: goto L_0x00a3;
                case -636251837: goto L_0x0097;
                case -396665309: goto L_0x008b;
                case -290623266: goto L_0x0080;
                case -235434703: goto L_0x0074;
                case -141240917: goto L_0x0068;
                case -122200568: goto L_0x005c;
                case 116859805: goto L_0x0050;
                case 281593967: goto L_0x0045;
                case 857654192: goto L_0x003a;
                case 934812310: goto L_0x002f;
                case 1852431466: goto L_0x0023;
                case 1953611341: goto L_0x0017;
                case 2139270075: goto L_0x000b;
                default: goto L_0x0009;
            }
        L_0x0009:
            goto L_0x0162
        L_0x000b:
            java.lang.String r1 = "User#updateEmail"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0009
            r0 = 25
            goto L_0x0163
        L_0x0017:
            java.lang.String r1 = "Auth#verifyPasswordResetCode"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0009
            r0 = 16
            goto L_0x0163
        L_0x0023:
            java.lang.String r1 = "Auth#setSettings"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0009
            r0 = 10
            goto L_0x0163
        L_0x002f:
            java.lang.String r1 = "Auth#applyActionCode"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0009
            r0 = 1
            goto L_0x0163
        L_0x003a:
            java.lang.String r1 = "Auth#checkActionCode"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0009
            r0 = 2
            goto L_0x0163
        L_0x0045:
            java.lang.String r1 = "Auth#confirmPasswordReset"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0009
            r0 = 3
            goto L_0x0163
        L_0x0050:
            java.lang.String r1 = "Auth#signInAnonymously"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0009
            r0 = 11
            goto L_0x0163
        L_0x005c:
            java.lang.String r1 = "User#updateProfile"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0009
            r0 = 28
            goto L_0x0163
        L_0x0068:
            java.lang.String r1 = "User#unlink"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0009
            r0 = 24
            goto L_0x0163
        L_0x0074:
            java.lang.String r1 = "User#reload"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0009
            r0 = 22
            goto L_0x0163
        L_0x0080:
            java.lang.String r1 = "Auth#createUserWithEmailAndPassword"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0009
            r0 = 4
            goto L_0x0163
        L_0x008b:
            java.lang.String r1 = "Auth#verifyPhoneNumber"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0009
            r0 = 17
            goto L_0x0163
        L_0x0097:
            java.lang.String r1 = "User#delete"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0009
            r0 = 18
            goto L_0x0163
        L_0x00a3:
            java.lang.String r1 = "User#sendEmailVerification"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0009
            r0 = 23
            goto L_0x0163
        L_0x00af:
            java.lang.String r1 = "Auth#sendPasswordResetEmail"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0009
            r0 = 6
            goto L_0x0163
        L_0x00ba:
            java.lang.String r1 = "User#getIdToken"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0009
            r0 = 19
            goto L_0x0163
        L_0x00c6:
            java.lang.String r1 = "Auth#signInWithCustomToken"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0009
            r0 = 12
            goto L_0x0163
        L_0x00d2:
            java.lang.String r1 = "Auth#signInWithEmailAndPassword"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0009
            r0 = 13
            goto L_0x0163
        L_0x00de:
            java.lang.String r1 = "Auth#fetchSignInMethodsForEmail"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0009
            r0 = 5
            goto L_0x0163
        L_0x00e9:
            java.lang.String r1 = "Auth#signInWithCredential"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0009
            r0 = 8
            goto L_0x0163
        L_0x00f5:
            java.lang.String r1 = "Auth#registerChangeListeners"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0009
            r0 = 0
            goto L_0x0163
        L_0x0100:
            java.lang.String r1 = "User#linkWithCredential"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0009
            r0 = 20
            goto L_0x0163
        L_0x010b:
            java.lang.String r1 = "Auth#sendSignInLinkToEmail"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0009
            r0 = 7
            goto L_0x0163
        L_0x0115:
            java.lang.String r1 = "User#updatePassword"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0009
            r0 = 26
            goto L_0x0163
        L_0x0120:
            java.lang.String r1 = "User#updatePhoneNumber"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0009
            r0 = 27
            goto L_0x0163
        L_0x012b:
            java.lang.String r1 = "Auth#signOut"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0009
            r0 = 15
            goto L_0x0163
        L_0x0136:
            java.lang.String r1 = "User#reauthenticateUserWithCredential"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0009
            r0 = 21
            goto L_0x0163
        L_0x0141:
            java.lang.String r1 = "Auth#setLanguageCode"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0009
            r0 = 9
            goto L_0x0163
        L_0x014c:
            java.lang.String r1 = "Auth#signInWithEmailLink"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0009
            r0 = 14
            goto L_0x0163
        L_0x0157:
            java.lang.String r1 = "User#verifyBeforeUpdateEmail"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0009
            r0 = 29
            goto L_0x0163
        L_0x0162:
            r0 = -1
        L_0x0163:
            switch(r0) {
                case 0: goto L_0x02b7;
                case 1: goto L_0x02ac;
                case 2: goto L_0x02a1;
                case 3: goto L_0x0296;
                case 4: goto L_0x028b;
                case 5: goto L_0x0280;
                case 6: goto L_0x0275;
                case 7: goto L_0x026a;
                case 8: goto L_0x025f;
                case 9: goto L_0x0254;
                case 10: goto L_0x024e;
                case 11: goto L_0x0242;
                case 12: goto L_0x0236;
                case 13: goto L_0x022a;
                case 14: goto L_0x021e;
                case 15: goto L_0x0212;
                case 16: goto L_0x0206;
                case 17: goto L_0x01fa;
                case 18: goto L_0x01ee;
                case 19: goto L_0x01e2;
                case 20: goto L_0x01d6;
                case 21: goto L_0x01ca;
                case 22: goto L_0x01be;
                case 23: goto L_0x01b2;
                case 24: goto L_0x01a6;
                case 25: goto L_0x019a;
                case 26: goto L_0x018e;
                case 27: goto L_0x0182;
                case 28: goto L_0x0176;
                case 29: goto L_0x016a;
                default: goto L_0x0166;
            }
        L_0x0166:
            r4.notImplemented()
            return
        L_0x016a:
            java.lang.Object r0 = r3.arguments()
            java.util.Map r0 = (java.util.Map) r0
            com.google.android.gms.tasks.Task r0 = r2.verifyBeforeUpdateEmail(r0)
            goto L_0x02c2
        L_0x0176:
            java.lang.Object r0 = r3.arguments()
            java.util.Map r0 = (java.util.Map) r0
            com.google.android.gms.tasks.Task r0 = r2.updateProfile(r0)
            goto L_0x02c2
        L_0x0182:
            java.lang.Object r0 = r3.arguments()
            java.util.Map r0 = (java.util.Map) r0
            com.google.android.gms.tasks.Task r0 = r2.updatePhoneNumber(r0)
            goto L_0x02c2
        L_0x018e:
            java.lang.Object r0 = r3.arguments()
            java.util.Map r0 = (java.util.Map) r0
            com.google.android.gms.tasks.Task r0 = r2.updatePassword(r0)
            goto L_0x02c2
        L_0x019a:
            java.lang.Object r0 = r3.arguments()
            java.util.Map r0 = (java.util.Map) r0
            com.google.android.gms.tasks.Task r0 = r2.updateEmail(r0)
            goto L_0x02c2
        L_0x01a6:
            java.lang.Object r0 = r3.arguments()
            java.util.Map r0 = (java.util.Map) r0
            com.google.android.gms.tasks.Task r0 = r2.unlinkUserProvider(r0)
            goto L_0x02c2
        L_0x01b2:
            java.lang.Object r0 = r3.arguments()
            java.util.Map r0 = (java.util.Map) r0
            com.google.android.gms.tasks.Task r0 = r2.sendEmailVerification(r0)
            goto L_0x02c2
        L_0x01be:
            java.lang.Object r0 = r3.arguments()
            java.util.Map r0 = (java.util.Map) r0
            com.google.android.gms.tasks.Task r0 = r2.reloadUser(r0)
            goto L_0x02c2
        L_0x01ca:
            java.lang.Object r0 = r3.arguments()
            java.util.Map r0 = (java.util.Map) r0
            com.google.android.gms.tasks.Task r0 = r2.reauthenticateUserWithCredential(r0)
            goto L_0x02c2
        L_0x01d6:
            java.lang.Object r0 = r3.arguments()
            java.util.Map r0 = (java.util.Map) r0
            com.google.android.gms.tasks.Task r0 = r2.linkUserWithCredential(r0)
            goto L_0x02c2
        L_0x01e2:
            java.lang.Object r0 = r3.arguments()
            java.util.Map r0 = (java.util.Map) r0
            com.google.android.gms.tasks.Task r0 = r2.getIdToken(r0)
            goto L_0x02c2
        L_0x01ee:
            java.lang.Object r0 = r3.arguments()
            java.util.Map r0 = (java.util.Map) r0
            com.google.android.gms.tasks.Task r0 = r2.deleteUser(r0)
            goto L_0x02c2
        L_0x01fa:
            java.lang.Object r0 = r3.arguments()
            java.util.Map r0 = (java.util.Map) r0
            com.google.android.gms.tasks.Task r0 = r2.verifyPhoneNumber(r0)
            goto L_0x02c2
        L_0x0206:
            java.lang.Object r0 = r3.arguments()
            java.util.Map r0 = (java.util.Map) r0
            com.google.android.gms.tasks.Task r0 = r2.verifyPasswordResetCode(r0)
            goto L_0x02c2
        L_0x0212:
            java.lang.Object r0 = r3.arguments()
            java.util.Map r0 = (java.util.Map) r0
            com.google.android.gms.tasks.Task r0 = r2.signOut(r0)
            goto L_0x02c2
        L_0x021e:
            java.lang.Object r0 = r3.arguments()
            java.util.Map r0 = (java.util.Map) r0
            com.google.android.gms.tasks.Task r0 = r2.signInWithEmailLink(r0)
            goto L_0x02c2
        L_0x022a:
            java.lang.Object r0 = r3.arguments()
            java.util.Map r0 = (java.util.Map) r0
            com.google.android.gms.tasks.Task r0 = r2.signInWithEmailAndPassword(r0)
            goto L_0x02c2
        L_0x0236:
            java.lang.Object r0 = r3.arguments()
            java.util.Map r0 = (java.util.Map) r0
            com.google.android.gms.tasks.Task r0 = r2.signInWithCustomToken(r0)
            goto L_0x02c2
        L_0x0242:
            java.lang.Object r0 = r3.arguments()
            java.util.Map r0 = (java.util.Map) r0
            com.google.android.gms.tasks.Task r0 = r2.signInAnonymously(r0)
            goto L_0x02c2
        L_0x024e:
            com.google.android.gms.tasks.Task r0 = r2.setSettings()
            goto L_0x02c2
        L_0x0254:
            java.lang.Object r0 = r3.arguments()
            java.util.Map r0 = (java.util.Map) r0
            com.google.android.gms.tasks.Task r0 = r2.setLanguageCode(r0)
            goto L_0x02c2
        L_0x025f:
            java.lang.Object r0 = r3.arguments()
            java.util.Map r0 = (java.util.Map) r0
            com.google.android.gms.tasks.Task r0 = r2.signInWithCredential(r0)
            goto L_0x02c2
        L_0x026a:
            java.lang.Object r0 = r3.arguments()
            java.util.Map r0 = (java.util.Map) r0
            com.google.android.gms.tasks.Task r0 = r2.sendSignInLinkToEmail(r0)
            goto L_0x02c2
        L_0x0275:
            java.lang.Object r0 = r3.arguments()
            java.util.Map r0 = (java.util.Map) r0
            com.google.android.gms.tasks.Task r0 = r2.sendPasswordResetEmail(r0)
            goto L_0x02c2
        L_0x0280:
            java.lang.Object r0 = r3.arguments()
            java.util.Map r0 = (java.util.Map) r0
            com.google.android.gms.tasks.Task r0 = r2.fetchSignInMethodsForEmail(r0)
            goto L_0x02c2
        L_0x028b:
            java.lang.Object r0 = r3.arguments()
            java.util.Map r0 = (java.util.Map) r0
            com.google.android.gms.tasks.Task r0 = r2.createUserWithEmailAndPassword(r0)
            goto L_0x02c2
        L_0x0296:
            java.lang.Object r0 = r3.arguments()
            java.util.Map r0 = (java.util.Map) r0
            com.google.android.gms.tasks.Task r0 = r2.confirmPasswordReset(r0)
            goto L_0x02c2
        L_0x02a1:
            java.lang.Object r0 = r3.arguments()
            java.util.Map r0 = (java.util.Map) r0
            com.google.android.gms.tasks.Task r0 = r2.checkActionCode(r0)
            goto L_0x02c2
        L_0x02ac:
            java.lang.Object r0 = r3.arguments()
            java.util.Map r0 = (java.util.Map) r0
            com.google.android.gms.tasks.Task r0 = r2.applyActionCode(r0)
            goto L_0x02c2
        L_0x02b7:
            java.lang.Object r0 = r3.arguments()
            java.util.Map r0 = (java.util.Map) r0
            com.google.android.gms.tasks.Task r0 = r2.registerChangeListeners(r0)
        L_0x02c2:
            io.flutter.plugins.firebase.auth.-$$Lambda$FlutterFirebaseAuthPlugin$Aztk8n6jG2PCP8nycOSAt60TiDE r1 = new io.flutter.plugins.firebase.auth.-$$Lambda$FlutterFirebaseAuthPlugin$Aztk8n6jG2PCP8nycOSAt60TiDE
            r1.<init>(r4)
            r0.addOnCompleteListener(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.plugins.firebase.auth.FlutterFirebaseAuthPlugin.onMethodCall(io.flutter.plugin.common.MethodCall, io.flutter.plugin.common.MethodChannel$Result):void");
    }

    public /* synthetic */ void lambda$onMethodCall$32$FlutterFirebaseAuthPlugin(MethodChannel.Result result, Task task) {
        if (task.isSuccessful()) {
            result.success(task.getResult());
            return;
        }
        Exception exception = task.getException();
        result.error("firebase_auth", exception != null ? exception.getMessage() : null, getExceptionDetails(exception));
    }

    public Task<Map<String, Object>> getPluginConstantsForFirebaseApp(FirebaseApp firebaseApp) {
        return Tasks.call(cachedThreadPool, new Callable(firebaseApp) {
            public final /* synthetic */ FirebaseApp f$1;

            {
                this.f$1 = r2;
            }

            public final Object call() {
                return FlutterFirebaseAuthPlugin.this.lambda$getPluginConstantsForFirebaseApp$33$FlutterFirebaseAuthPlugin(this.f$1);
            }
        });
    }

    public /* synthetic */ Map lambda$getPluginConstantsForFirebaseApp$33$FlutterFirebaseAuthPlugin(FirebaseApp firebaseApp) throws Exception {
        Map<String, Object> constants = new HashMap<>();
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance(firebaseApp);
        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
        String languageCode = firebaseAuth.getLanguageCode();
        Map<String, Object> user = firebaseUser == null ? null : parseFirebaseUser(firebaseUser);
        if (languageCode != null) {
            constants.put("APP_LANGUAGE_CODE", languageCode);
        }
        if (user != null) {
            constants.put("APP_CURRENT_USER", user);
        }
        return constants;
    }

    /* access modifiers changed from: private */
    public Map<String, Object> getExceptionDetails(Exception exception) {
        Throwable th;
        Map<String, Object> details = new HashMap<>();
        if (exception == null) {
            return details;
        }
        FlutterFirebaseAuthPluginException authException = null;
        if (exception instanceof FirebaseAuthException) {
            authException = new FlutterFirebaseAuthPluginException(exception, exception.getCause());
        } else if (exception.getCause() != null && (exception.getCause() instanceof FirebaseAuthException)) {
            FirebaseAuthException firebaseAuthException = (FirebaseAuthException) exception.getCause();
            if (exception.getCause().getCause() != null) {
                th = exception.getCause().getCause();
            } else {
                th = exception.getCause();
            }
            authException = new FlutterFirebaseAuthPluginException((Exception) firebaseAuthException, th);
        } else if (exception instanceof FlutterFirebaseAuthPluginException) {
            authException = (FlutterFirebaseAuthPluginException) exception;
        }
        if (authException != null) {
            details.put(Constants.CODE, authException.getCode());
            details.put("message", authException.getMessage());
            details.put("additionalData", authException.getAdditionalData());
            return details;
        } else if ((exception instanceof FirebaseNetworkException) || (exception.getCause() != null && (exception.getCause() instanceof FirebaseNetworkException))) {
            details.put(Constants.CODE, "network-request-failed");
            details.put("message", "A network error (such as timeout, interrupted connection or unreachable host) has occurred.");
            details.put("additionalData", new HashMap());
            return details;
        } else if ((exception instanceof FirebaseApiNotAvailableException) || (exception.getCause() != null && (exception.getCause() instanceof FirebaseApiNotAvailableException))) {
            details.put(Constants.CODE, "api-not-available");
            details.put("message", "The requested API is not available.");
            details.put("additionalData", new HashMap());
            return details;
        } else if ((exception instanceof FirebaseTooManyRequestsException) || (exception.getCause() != null && (exception.getCause() instanceof FirebaseTooManyRequestsException))) {
            details.put(Constants.CODE, "too-many-requests");
            details.put("message", "We have blocked all requests from this device due to unusual activity. Try again later.");
            details.put("additionalData", new HashMap());
            return details;
        } else if (exception.getMessage() == null || !exception.getMessage().startsWith("Cannot create PhoneAuthCredential without either verificationProof")) {
            return details;
        } else {
            details.put(Constants.CODE, "invalid-verification-id");
            details.put("message", "The verification ID used to create the phone auth credential is invalid.");
            details.put("additionalData", new HashMap());
            return details;
        }
    }

    public Task<Void> didReinitializeFirebaseCore() {
        return Tasks.call(cachedThreadPool, new Callable() {
            public final Object call() {
                return FlutterFirebaseAuthPlugin.this.lambda$didReinitializeFirebaseCore$34$FlutterFirebaseAuthPlugin();
            }
        });
    }

    public /* synthetic */ Void lambda$didReinitializeFirebaseCore$34$FlutterFirebaseAuthPlugin() throws Exception {
        removeEventListeners();
        authCredentials.clear();
        forceResendingTokens.clear();
        return null;
    }
}
