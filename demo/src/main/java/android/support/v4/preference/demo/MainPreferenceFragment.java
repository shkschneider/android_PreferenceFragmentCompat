package android.support.v4.preference.demo;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.preference.PreferenceFragmentCompat;

public class MainPreferenceFragment extends PreferenceFragmentCompat {

    @Override
    public void onCreate(final Bundle paramBundle) {
        super.onCreate(paramBundle);
        addPreferencesFromResource(R.xml.preferences);

        final Context context = getActivity();
        if (context == null) {
            return ;
        }
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
