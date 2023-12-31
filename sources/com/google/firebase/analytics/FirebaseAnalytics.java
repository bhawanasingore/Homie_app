package com.google.firebase.analytics;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.internal.measurement.zzaa;
import com.google.android.gms.internal.measurement.zzac;
import com.google.android.gms.measurement.internal.zzfx;
import com.google.android.gms.measurement.internal.zzhz;
import com.google.android.gms.measurement.internal.zzv;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.iid.FirebaseInstanceId;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-measurement-api@@17.4.1 */
public final class FirebaseAnalytics {
    private static volatile FirebaseAnalytics zza;
    /* access modifiers changed from: private */
    public final zzfx zzb;
    /* access modifiers changed from: private */
    public final zzac zzc;
    /* access modifiers changed from: private */
    public final boolean zzd;
    private String zze;
    private long zzf;
    private final Object zzg;
    private ExecutorService zzh;

    /* compiled from: com.google.android.gms:play-services-measurement-api@@17.4.1 */
    public static class Event {
        public static final String ADD_PAYMENT_INFO = "add_payment_info";
        public static final String ADD_SHIPPING_INFO = "add_shipping_info";
        public static final String ADD_TO_CART = "add_to_cart";
        public static final String ADD_TO_WISHLIST = "add_to_wishlist";
        public static final String APP_OPEN = "app_open";
        public static final String BEGIN_CHECKOUT = "begin_checkout";
        public static final String CAMPAIGN_DETAILS = "campaign_details";
        @Deprecated
        public static final String CHECKOUT_PROGRESS = "checkout_progress";
        public static final String EARN_VIRTUAL_CURRENCY = "earn_virtual_currency";
        @Deprecated
        public static final String ECOMMERCE_PURCHASE = "ecommerce_purchase";
        public static final String GENERATE_LEAD = "generate_lead";
        public static final String JOIN_GROUP = "join_group";
        public static final String LEVEL_END = "level_end";
        public static final String LEVEL_START = "level_start";
        public static final String LEVEL_UP = "level_up";
        public static final String LOGIN = "login";
        public static final String POST_SCORE = "post_score";
        @Deprecated
        public static final String PRESENT_OFFER = "present_offer";
        public static final String PURCHASE = "purchase";
        @Deprecated
        public static final String PURCHASE_REFUND = "purchase_refund";
        public static final String REFUND = "refund";
        public static final String REMOVE_FROM_CART = "remove_from_cart";
        public static final String SEARCH = "search";
        public static final String SELECT_CONTENT = "select_content";
        public static final String SELECT_ITEM = "select_item";
        public static final String SELECT_PROMOTION = "select_promotion";
        @Deprecated
        public static final String SET_CHECKOUT_OPTION = "set_checkout_option";
        public static final String SHARE = "share";
        public static final String SIGN_UP = "sign_up";
        public static final String SPEND_VIRTUAL_CURRENCY = "spend_virtual_currency";
        public static final String TUTORIAL_BEGIN = "tutorial_begin";
        public static final String TUTORIAL_COMPLETE = "tutorial_complete";
        public static final String UNLOCK_ACHIEVEMENT = "unlock_achievement";
        public static final String VIEW_CART = "view_cart";
        public static final String VIEW_ITEM = "view_item";
        public static final String VIEW_ITEM_LIST = "view_item_list";
        public static final String VIEW_PROMOTION = "view_promotion";
        @Deprecated
        public static final String VIEW_SEARCH_RESULTS = "view_search_results";

        protected Event() {
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement-api@@17.4.1 */
    public static class Param {
        public static final String ACHIEVEMENT_ID = "achievement_id";
        public static final String ACLID = "aclid";
        public static final String AFFILIATION = "affiliation";
        public static final String CAMPAIGN = "campaign";
        public static final String CHARACTER = "character";
        @Deprecated
        public static final String CHECKOUT_OPTION = "checkout_option";
        @Deprecated
        public static final String CHECKOUT_STEP = "checkout_step";
        public static final String CONTENT = "content";
        public static final String CONTENT_TYPE = "content_type";
        public static final String COUPON = "coupon";
        public static final String CP1 = "cp1";
        public static final String CREATIVE_NAME = "creative_name";
        public static final String CREATIVE_SLOT = "creative_slot";
        public static final String CURRENCY = "currency";
        public static final String DESTINATION = "destination";
        public static final String DISCOUNT = "discount";
        public static final String END_DATE = "end_date";
        public static final String EXTEND_SESSION = "extend_session";
        public static final String FLIGHT_NUMBER = "flight_number";
        public static final String GROUP_ID = "group_id";
        public static final String INDEX = "index";
        public static final String ITEMS = "items";
        public static final String ITEM_BRAND = "item_brand";
        public static final String ITEM_CATEGORY = "item_category";
        public static final String ITEM_CATEGORY2 = "item_category2";
        public static final String ITEM_CATEGORY3 = "item_category3";
        public static final String ITEM_CATEGORY4 = "item_category4";
        public static final String ITEM_CATEGORY5 = "item_category5";
        public static final String ITEM_ID = "item_id";
        @Deprecated
        public static final String ITEM_LIST = "item_list";
        public static final String ITEM_LIST_ID = "item_list_id";
        public static final String ITEM_LIST_NAME = "item_list_name";
        @Deprecated
        public static final String ITEM_LOCATION_ID = "item_location_id";
        public static final String ITEM_NAME = "item_name";
        public static final String ITEM_VARIANT = "item_variant";
        public static final String LEVEL = "level";
        public static final String LEVEL_NAME = "level_name";
        public static final String LOCATION = "location";
        public static final String LOCATION_ID = "location_id";
        public static final String MEDIUM = "medium";
        public static final String METHOD = "method";
        public static final String NUMBER_OF_NIGHTS = "number_of_nights";
        public static final String NUMBER_OF_PASSENGERS = "number_of_passengers";
        public static final String NUMBER_OF_ROOMS = "number_of_rooms";
        public static final String ORIGIN = "origin";
        public static final String PAYMENT_TYPE = "payment_type";
        public static final String PRICE = "price";
        public static final String PROMOTION_ID = "promotion_id";
        public static final String PROMOTION_NAME = "promotion_name";
        public static final String QUANTITY = "quantity";
        public static final String SCORE = "score";
        public static final String SEARCH_TERM = "search_term";
        public static final String SHIPPING = "shipping";
        public static final String SHIPPING_TIER = "shipping_tier";
        @Deprecated
        public static final String SIGN_UP_METHOD = "sign_up_method";
        public static final String SOURCE = "source";
        public static final String START_DATE = "start_date";
        public static final String SUCCESS = "success";
        public static final String TAX = "tax";
        public static final String TERM = "term";
        public static final String TRANSACTION_ID = "transaction_id";
        public static final String TRAVEL_CLASS = "travel_class";
        public static final String VALUE = "value";
        public static final String VIRTUAL_CURRENCY_NAME = "virtual_currency_name";

        protected Param() {
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement-api@@17.4.1 */
    public static class UserProperty {
        public static final String ALLOW_AD_PERSONALIZATION_SIGNALS = "allow_personalized_ads";
        public static final String SIGN_UP_METHOD = "sign_up_method";

        protected UserProperty() {
        }
    }

    public static FirebaseAnalytics getInstance(Context context) {
        if (zza == null) {
            synchronized (FirebaseAnalytics.class) {
                if (zza == null) {
                    if (zzac.zzb(context)) {
                        zza = new FirebaseAnalytics(zzac.zza(context));
                    } else {
                        zza = new FirebaseAnalytics(zzfx.zza(context, (zzaa) null, (Long) null));
                    }
                }
            }
        }
        return zza;
    }

    public final void logEvent(String str, Bundle bundle) {
        if (this.zzd) {
            this.zzc.zza(str, bundle);
        } else {
            this.zzb.zzh().zza("app", str, bundle, true);
        }
    }

    public final void setUserProperty(String str, String str2) {
        if (this.zzd) {
            this.zzc.zza(str, str2);
        } else {
            this.zzb.zzh().zza("app", str, (Object) str2, false);
        }
    }

    public final void setCurrentScreen(Activity activity, String str, String str2) {
        if (this.zzd) {
            this.zzc.zza(activity, str, str2);
        } else if (!zzv.zza()) {
            this.zzb.zzr().zzi().zza("setCurrentScreen must be called from the main thread");
        } else {
            this.zzb.zzv().zza(activity, str, str2);
        }
    }

    public final void setAnalyticsCollectionEnabled(boolean z) {
        if (this.zzd) {
            this.zzc.zza(z);
        } else {
            this.zzb.zzh().zza(z);
        }
    }

    public final void setUserId(String str) {
        if (this.zzd) {
            this.zzc.zza(str);
        } else {
            this.zzb.zzh().zza("app", "_id", (Object) str, true);
        }
    }

    @Deprecated
    public final void setMinimumSessionDuration(long j) {
        if (this.zzd) {
            this.zzc.zza(j);
        } else {
            this.zzb.zzh().zza(j);
        }
    }

    public final void setSessionTimeoutDuration(long j) {
        if (this.zzd) {
            this.zzc.zzb(j);
        } else {
            this.zzb.zzh().zzb(j);
        }
    }

    private final ExecutorService zza() {
        ExecutorService executorService;
        synchronized (FirebaseAnalytics.class) {
            if (this.zzh == null) {
                this.zzh = new ThreadPoolExecutor(0, 1, 30, TimeUnit.SECONDS, new ArrayBlockingQueue(100));
            }
            executorService = this.zzh;
        }
        return executorService;
    }

    public final Task<String> getAppInstanceId() {
        try {
            String zzb2 = zzb();
            if (zzb2 != null) {
                return Tasks.forResult(zzb2);
            }
            return Tasks.call(zza(), new zzb(this));
        } catch (Exception e) {
            if (this.zzd) {
                this.zzc.zza(5, "Failed to schedule task for getAppInstanceId", (Object) null, (Object) null, (Object) null);
            } else {
                this.zzb.zzr().zzi().zza("Failed to schedule task for getAppInstanceId");
            }
            return Tasks.forException(e);
        }
    }

    private FirebaseAnalytics(zzfx zzfx) {
        Preconditions.checkNotNull(zzfx);
        this.zzb = zzfx;
        this.zzc = null;
        this.zzd = false;
        this.zzg = new Object();
    }

    private FirebaseAnalytics(zzac zzac) {
        Preconditions.checkNotNull(zzac);
        this.zzb = null;
        this.zzc = zzac;
        this.zzd = true;
        this.zzg = new Object();
    }

    public final void resetAnalyticsData() {
        zza((String) null);
        if (this.zzd) {
            this.zzc.zzb();
        } else {
            this.zzb.zzh().zzd(this.zzb.zzm().currentTimeMillis());
        }
    }

    public final String getFirebaseInstanceId() {
        return FirebaseInstanceId.getInstance().getId();
    }

    /* access modifiers changed from: private */
    public final void zza(String str) {
        synchronized (this.zzg) {
            this.zze = str;
            if (this.zzd) {
                this.zzf = DefaultClock.getInstance().elapsedRealtime();
            } else {
                this.zzf = this.zzb.zzm().elapsedRealtime();
            }
        }
    }

    /* access modifiers changed from: private */
    public final String zzb() {
        long j;
        synchronized (this.zzg) {
            if (this.zzd) {
                j = DefaultClock.getInstance().elapsedRealtime();
            } else {
                j = this.zzb.zzm().elapsedRealtime();
            }
            if (Math.abs(j - this.zzf) >= 1000) {
                return null;
            }
            String str = this.zze;
            return str;
        }
    }

    public static zzhz getScionFrontendApiImplementation(Context context, Bundle bundle) {
        zzac zza2;
        if (zzac.zzb(context) && (zza2 = zzac.zza(context, (String) null, (String) null, (String) null, bundle)) != null) {
            return new zza(zza2);
        }
        return null;
    }
}
