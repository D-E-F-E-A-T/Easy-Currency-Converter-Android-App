package android.support.p000v4.text;

import android.os.Build.VERSION;
import android.text.Html;
import android.text.Html.ImageGetter;
import android.text.Html.TagHandler;
import android.text.Spanned;

/* renamed from: android.support.v4.text.HtmlCompat */
public final class HtmlCompat {
    public static final int FROM_HTML_MODE_COMPACT = 63;
    public static final int FROM_HTML_MODE_LEGACY = 0;
    public static final int FROM_HTML_OPTION_USE_CSS_COLORS = 256;
    public static final int FROM_HTML_SEPARATOR_LINE_BREAK_BLOCKQUOTE = 32;
    public static final int FROM_HTML_SEPARATOR_LINE_BREAK_DIV = 16;
    public static final int FROM_HTML_SEPARATOR_LINE_BREAK_HEADING = 2;
    public static final int FROM_HTML_SEPARATOR_LINE_BREAK_LIST = 8;
    public static final int FROM_HTML_SEPARATOR_LINE_BREAK_LIST_ITEM = 4;
    public static final int FROM_HTML_SEPARATOR_LINE_BREAK_PARAGRAPH = 1;
    public static final int TO_HTML_PARAGRAPH_LINES_CONSECUTIVE = 0;
    public static final int TO_HTML_PARAGRAPH_LINES_INDIVIDUAL = 1;

    public static Spanned fromHtml(String source, int flags) {
        if (VERSION.SDK_INT >= 24) {
            return Html.fromHtml(source, flags);
        }
        return Html.fromHtml(source);
    }

    public static Spanned fromHtml(String source, int flags, ImageGetter imageGetter, TagHandler tagHandler) {
        if (VERSION.SDK_INT >= 24) {
            return Html.fromHtml(source, flags, imageGetter, tagHandler);
        }
        return Html.fromHtml(source, imageGetter, tagHandler);
    }

    public static String toHtml(Spanned text, int options) {
        if (VERSION.SDK_INT >= 24) {
            return Html.toHtml(text, options);
        }
        return Html.toHtml(text);
    }

    private HtmlCompat() {
    }
}
