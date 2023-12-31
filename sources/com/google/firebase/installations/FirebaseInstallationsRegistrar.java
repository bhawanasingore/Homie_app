package com.google.firebase.installations;

import com.google.firebase.FirebaseApp;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import com.google.firebase.platforminfo.UserAgentPublisher;
import java.util.Arrays;
import java.util.List;

/* compiled from: com.google.firebase:firebase-installations@@16.2.1 */
public class FirebaseInstallationsRegistrar implements ComponentRegistrar {
    public List<Component<?>> getComponents() {
        return Arrays.asList(new Component[]{Component.builder(FirebaseInstallationsApi.class).add(Dependency.required(FirebaseApp.class)).add(Dependency.required(HeartBeatInfo.class)).add(Dependency.required(UserAgentPublisher.class)).factory(FirebaseInstallationsRegistrar$$Lambda$1.lambdaFactory$()).build(), LibraryVersionComponent.create("fire-installations", BuildConfig.VERSION_NAME)});
    }

    static /* synthetic */ FirebaseInstallationsApi lambda$getComponents$0(ComponentContainer c) {
        return new FirebaseInstallations((FirebaseApp) c.get(FirebaseApp.class), (UserAgentPublisher) c.get(UserAgentPublisher.class), (HeartBeatInfo) c.get(HeartBeatInfo.class));
    }
}
