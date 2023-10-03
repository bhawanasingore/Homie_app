package com.google.firebase.firestore;

import android.content.Context;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.internal.InternalAuthProvider;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.firestore.remote.FirebaseClientGrpcMetadataProvider;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import com.google.firebase.platforminfo.UserAgentPublisher;
import java.util.Arrays;
import java.util.List;

/* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
public class FirestoreRegistrar implements ComponentRegistrar {
    public List<Component<?>> getComponents() {
        return Arrays.asList(new Component[]{Component.builder(FirestoreMultiDbComponent.class).add(Dependency.required(FirebaseApp.class)).add(Dependency.required(Context.class)).add(Dependency.optionalProvider(HeartBeatInfo.class)).add(Dependency.optionalProvider(UserAgentPublisher.class)).add(Dependency.optional(InternalAuthProvider.class)).factory(FirestoreRegistrar$$Lambda$1.lambdaFactory$()).build(), LibraryVersionComponent.create("fire-fst", BuildConfig.VERSION_NAME)});
    }

    static /* synthetic */ FirestoreMultiDbComponent lambda$getComponents$0(ComponentContainer c) {
        return new FirestoreMultiDbComponent((Context) c.get(Context.class), (FirebaseApp) c.get(FirebaseApp.class), (InternalAuthProvider) c.get(InternalAuthProvider.class), new FirebaseClientGrpcMetadataProvider(c.getProvider(UserAgentPublisher.class), c.getProvider(HeartBeatInfo.class)));
    }
}
