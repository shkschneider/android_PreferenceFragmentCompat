package android.support.v4.preference.demo;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Bundle;
import android.preference.Preference;
import android.support.v4.preference.PreferenceFragmentCompat;
import android.text.TextUtils;
import android.widget.Toast;

public class MainPreferenceFragment extends PreferenceFragmentCompat {

    @Override
    public void onCreate(final Bundle paramBundle) {
        super.onCreate(paramBundle);
        addPreferencesFromResource(R.xml.preferences);

        final Context context = getActivity();
        if (context == null) {
            return ;
        }
        findPreference("preference").setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {

            @Override
            public boolean onPreferenceClick(final Preference preference) {
                Toast.makeText(context, getResources().getString(R.string.app_label), Toast.LENGTH_SHORT).show();
                return true;
            }

        });
        findPreference("editText").setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {

            @Override
            public boolean onPreferenceChange(final Preference preference, final Object newValue) {
                if (newValue == null) {
                    return false;
                }
                final String string = newValue.toString();
                if (TextUtils.isEmpty(string)) {
                    return false;
                }
                Toast.makeText(context, string, Toast.LENGTH_SHORT).show();
                return true;
            }

        });
        try {
            final PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            findPreference("app_packageName").setSummary(packageInfo.packageName);
            findPreference("app_versionName").setSummary(packageInfo.versionName);
            findPreference("app_versionCode").setSummary(String.valueOf(packageInfo.versionCode));
        }
        catch (final Exception e) {
            e.printStackTrace();
        }
        findPreference("app_debug").setSummary(String.valueOf(Boolean.TRUE));
        findPreference("os_version").setSummary(String.valueOf(Build.VERSION.RELEASE));
        findPreference("os_api").setSummary(String.valueOf(Build.VERSION.SDK_INT));
    }

}
