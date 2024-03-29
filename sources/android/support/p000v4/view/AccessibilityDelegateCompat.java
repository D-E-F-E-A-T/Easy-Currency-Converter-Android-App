package android.support.p000v4.view;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.p000v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.p000v4.view.accessibility.AccessibilityNodeProviderCompat;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;

/* renamed from: android.support.v4.view.AccessibilityDelegateCompat */
public class AccessibilityDelegateCompat {
    private static final AccessibilityDelegate DEFAULT_DELEGATE = new AccessibilityDelegate();
    private final AccessibilityDelegate mBridge = new AccessibilityDelegateAdapter(this);

    /* renamed from: android.support.v4.view.AccessibilityDelegateCompat$AccessibilityDelegateAdapter */
    private static final class AccessibilityDelegateAdapter extends AccessibilityDelegate {
        private final AccessibilityDelegateCompat mCompat;

        AccessibilityDelegateAdapter(AccessibilityDelegateCompat compat) {
            this.mCompat = compat;
        }

        public boolean dispatchPopulateAccessibilityEvent(View host, AccessibilityEvent event) {
            return this.mCompat.dispatchPopulateAccessibilityEvent(host, event);
        }

        public void onInitializeAccessibilityEvent(View host, AccessibilityEvent event) {
            this.mCompat.onInitializeAccessibilityEvent(host, event);
        }

        public void onInitializeAccessibilityNodeInfo(View host, AccessibilityNodeInfo info) {
            this.mCompat.onInitializeAccessibilityNodeInfo(host, AccessibilityNodeInfoCompat.wrap(info));
        }

        public void onPopulateAccessibilityEvent(View host, AccessibilityEvent event) {
            this.mCompat.onPopulateAccessibilityEvent(host, event);
        }

        public boolean onRequestSendAccessibilityEvent(ViewGroup host, View child, AccessibilityEvent event) {
            return this.mCompat.onRequestSendAccessibilityEvent(host, child, event);
        }

        public void sendAccessibilityEvent(View host, int eventType) {
            this.mCompat.sendAccessibilityEvent(host, eventType);
        }

        public void sendAccessibilityEventUnchecked(View host, AccessibilityEvent event) {
            this.mCompat.sendAccessibilityEventUnchecked(host, event);
        }

        public AccessibilityNodeProvider getAccessibilityNodeProvider(View host) {
            AccessibilityNodeProviderCompat provider = this.mCompat.getAccessibilityNodeProvider(host);
            if (provider != null) {
                return (AccessibilityNodeProvider) provider.getProvider();
            }
            return null;
        }

        public boolean performAccessibilityAction(View host, int action, Bundle args) {
            return this.mCompat.performAccessibilityAction(host, action, args);
        }
    }

    /* access modifiers changed from: 0000 */
    public AccessibilityDelegate getBridge() {
        return this.mBridge;
    }

    public void sendAccessibilityEvent(View host, int eventType) {
        DEFAULT_DELEGATE.sendAccessibilityEvent(host, eventType);
    }

    public void sendAccessibilityEventUnchecked(View host, AccessibilityEvent event) {
        DEFAULT_DELEGATE.sendAccessibilityEventUnchecked(host, event);
    }

    public boolean dispatchPopulateAccessibilityEvent(View host, AccessibilityEvent event) {
        return DEFAULT_DELEGATE.dispatchPopulateAccessibilityEvent(host, event);
    }

    public void onPopulateAccessibilityEvent(View host, AccessibilityEvent event) {
        DEFAULT_DELEGATE.onPopulateAccessibilityEvent(host, event);
    }

    public void onInitializeAccessibilityEvent(View host, AccessibilityEvent event) {
        DEFAULT_DELEGATE.onInitializeAccessibilityEvent(host, event);
    }

    public void onInitializeAccessibilityNodeInfo(View host, AccessibilityNodeInfoCompat info) {
        DEFAULT_DELEGATE.onInitializeAccessibilityNodeInfo(host, info.unwrap());
    }

    public boolean onRequestSendAccessibilityEvent(ViewGroup host, View child, AccessibilityEvent event) {
        return DEFAULT_DELEGATE.onRequestSendAccessibilityEvent(host, child, event);
    }

    public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View host) {
        if (VERSION.SDK_INT >= 16) {
            Object provider = DEFAULT_DELEGATE.getAccessibilityNodeProvider(host);
            if (provider != null) {
                return new AccessibilityNodeProviderCompat(provider);
            }
        }
        return null;
    }

    public boolean performAccessibilityAction(View host, int action, Bundle args) {
        if (VERSION.SDK_INT >= 16) {
            return DEFAULT_DELEGATE.performAccessibilityAction(host, action, args);
        }
        return false;
    }
}
