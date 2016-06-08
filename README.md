DEPRECATED
==========

Use [com.android.support:support-v7](https://developer.android.com/topic/libraries/support-library/features.html#v7-preference) and [com.android.support:preference-v14](https://developer.android.com/topic/libraries/support-library/features.html#v14-preference).

1. Use a `android.support.v7.preference.PreferenceFragmentCompat` as fragment.
2. Set `<item name="preferenceTheme">@style/PreferenceThemeOverlay.v14.Material</item>` in your theme.
3. Set colors `preference_accent` and `preference_fallback_accent_color` to `accentColor`.
4. Create your layout with a `Toolbar` that includes something like:
<pre>&lt;fragment
        android:name="com.example.SettingsActivity$SettingsFragment"
        android:tag="SettingsActivity$SettingsFragment"
        android:layout_width="match_parent"
        android:layout_height="match_parent" /&gt;</pre>
