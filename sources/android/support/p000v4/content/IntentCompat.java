package android.support.p000v4.content;

import android.content.Intent;
import android.os.Build.VERSION;

/* renamed from: android.support.v4.content.IntentCompat */
public final class IntentCompat {
    public static final String CATEGORY_LEANBACK_LAUNCHER = "android.intent.category.LEANBACK_LAUNCHER";
    public static final String EXTRA_HTML_TEXT = "android.intent.extra.HTML_TEXT";
    public static final String EXTRA_START_PLAYBACK = "android.intent.extra.START_PLAYBACK";

    private IntentCompat() {
    }

    public static Intent makeMainSelectorActivity(String selectorAction, String selectorCategory) {
        if (VERSION.SDK_INT >= 15) {
            return Intent.makeMainSelectorActivity(selectorAction, selectorCategory);
        }
        Intent intent = new Intent(selectorAction);
        intent.addCategory(selectorCategory);
        return intent;
    }
}
