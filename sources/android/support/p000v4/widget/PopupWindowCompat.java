package android.support.p000v4.widget;

import android.os.Build.VERSION;
import android.support.p000v4.view.GravityCompat;
import android.support.p000v4.view.ViewCompat;
import android.util.Log;
import android.view.View;
import android.widget.PopupWindow;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* renamed from: android.support.v4.widget.PopupWindowCompat */
public final class PopupWindowCompat {
    private static final String TAG = "PopupWindowCompatApi21";
    private static Method sGetWindowLayoutTypeMethod;
    private static boolean sGetWindowLayoutTypeMethodAttempted;
    private static Field sOverlapAnchorField;
    private static boolean sOverlapAnchorFieldAttempted;
    private static Method sSetWindowLayoutTypeMethod;
    private static boolean sSetWindowLayoutTypeMethodAttempted;

    private PopupWindowCompat() {
    }

    public static void showAsDropDown(PopupWindow popup, View anchor, int xoff, int yoff, int gravity) {
        if (VERSION.SDK_INT >= 19) {
            popup.showAsDropDown(anchor, xoff, yoff, gravity);
            return;
        }
        int xoff1 = xoff;
        if ((GravityCompat.getAbsoluteGravity(gravity, ViewCompat.getLayoutDirection(anchor)) & 7) == 5) {
            xoff1 -= popup.getWidth() - anchor.getWidth();
        }
        popup.showAsDropDown(anchor, xoff1, yoff);
    }

    public static void setOverlapAnchor(PopupWindow popupWindow, boolean overlapAnchor) {
        if (VERSION.SDK_INT >= 23) {
            popupWindow.setOverlapAnchor(overlapAnchor);
        } else if (VERSION.SDK_INT >= 21) {
            boolean z = sOverlapAnchorFieldAttempted;
            String str = TAG;
            if (!z) {
                try {
                    sOverlapAnchorField = PopupWindow.class.getDeclaredField("mOverlapAnchor");
                    sOverlapAnchorField.setAccessible(true);
                } catch (NoSuchFieldException e) {
                    Log.i(str, "Could not fetch mOverlapAnchor field from PopupWindow", e);
                }
                sOverlapAnchorFieldAttempted = true;
            }
            Field field = sOverlapAnchorField;
            if (field != null) {
                try {
                    field.set(popupWindow, Boolean.valueOf(overlapAnchor));
                } catch (IllegalAccessException e2) {
                    Log.i(str, "Could not set overlap anchor field in PopupWindow", e2);
                }
            }
        }
    }

    public static boolean getOverlapAnchor(PopupWindow popupWindow) {
        if (VERSION.SDK_INT >= 23) {
            return popupWindow.getOverlapAnchor();
        }
        if (VERSION.SDK_INT >= 21) {
            boolean z = sOverlapAnchorFieldAttempted;
            String str = TAG;
            if (!z) {
                try {
                    sOverlapAnchorField = PopupWindow.class.getDeclaredField("mOverlapAnchor");
                    sOverlapAnchorField.setAccessible(true);
                } catch (NoSuchFieldException e) {
                    Log.i(str, "Could not fetch mOverlapAnchor field from PopupWindow", e);
                }
                sOverlapAnchorFieldAttempted = true;
            }
            Field field = sOverlapAnchorField;
            if (field != null) {
                try {
                    return ((Boolean) field.get(popupWindow)).booleanValue();
                } catch (IllegalAccessException e2) {
                    Log.i(str, "Could not get overlap anchor field in PopupWindow", e2);
                }
            }
        }
        return false;
    }

    public static void setWindowLayoutType(PopupWindow popupWindow, int layoutType) {
        if (VERSION.SDK_INT >= 23) {
            popupWindow.setWindowLayoutType(layoutType);
            return;
        }
        if (!sSetWindowLayoutTypeMethodAttempted) {
            try {
                sSetWindowLayoutTypeMethod = PopupWindow.class.getDeclaredMethod("setWindowLayoutType", new Class[]{Integer.TYPE});
                sSetWindowLayoutTypeMethod.setAccessible(true);
            } catch (Exception e) {
            }
            sSetWindowLayoutTypeMethodAttempted = true;
        }
        Method method = sSetWindowLayoutTypeMethod;
        if (method != null) {
            try {
                method.invoke(popupWindow, new Object[]{Integer.valueOf(layoutType)});
            } catch (Exception e2) {
            }
        }
    }

    public static int getWindowLayoutType(PopupWindow popupWindow) {
        if (VERSION.SDK_INT >= 23) {
            return popupWindow.getWindowLayoutType();
        }
        if (!sGetWindowLayoutTypeMethodAttempted) {
            try {
                sGetWindowLayoutTypeMethod = PopupWindow.class.getDeclaredMethod("getWindowLayoutType", new Class[0]);
                sGetWindowLayoutTypeMethod.setAccessible(true);
            } catch (Exception e) {
            }
            sGetWindowLayoutTypeMethodAttempted = true;
        }
        Method method = sGetWindowLayoutTypeMethod;
        if (method != null) {
            try {
                return ((Integer) method.invoke(popupWindow, new Object[0])).intValue();
            } catch (Exception e2) {
            }
        }
        return 0;
    }
}
