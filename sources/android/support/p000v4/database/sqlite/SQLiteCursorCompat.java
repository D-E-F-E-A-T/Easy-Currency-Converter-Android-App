package android.support.p000v4.database.sqlite;

import android.database.sqlite.SQLiteCursor;
import android.os.Build.VERSION;

/* renamed from: android.support.v4.database.sqlite.SQLiteCursorCompat */
public final class SQLiteCursorCompat {
    private SQLiteCursorCompat() {
    }

    public static void setFillWindowForwardOnly(SQLiteCursor cursor, boolean fillWindowForwardOnly) {
        if (VERSION.SDK_INT >= 28) {
            cursor.setFillWindowForwardOnly(fillWindowForwardOnly);
        }
    }
}
