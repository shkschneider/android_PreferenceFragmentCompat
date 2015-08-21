PreferenceFragmentCompat [![JitPack](https://img.shields.io/github/tag/shkschneider/android_PreferenceFragmentCompat.svg?label=JitPack)](https://jitpack.io/#shkschneider/android_PreferenceFragmentCompat/1.0.0)
========================

- Unofficial PreferenceFragment compatibility layer for Android **API-4 and UP**.
- Provided as an **AAR** file, propulsed by [JitPack](http://jitpack.io).
- Licensed under [Apache 2.0](https://github.com/shkschneider/android_PreferenceFragmentCompat/blob/master/LICENSE).

Code renewed from [kolavar's](https://github.com/kolavar/android-support-v4-preferencefragment) (because of [issue#13](https://github.com/kolavar/android-support-v4-preferencefragment/issues/13)) with updated *dimens.xml* from AOSP as of [Lollipop_MR1](https://github.com/android/platform_frameworks_base/tree/lollipop-mr1-release).

[SCREENSHOT](https://github.com/shkschneider/android_PreferenceFragmentCompat/blob/master/screenshot.png)

How to add to your Gradle project
---------------------------------

Add JitPack to top-level build.gradle file (if not done already):

<pre>allprojects {
    repositories {
        jcenter()
        maven {
            url "https://jitpack.io" // add this
        }
    }
}</pre>

See [build.gradle](https://github.com/shkschneider/android_PreferenceFragmentCompat/blob/master/build.gradle).

Add this library dependency:

<pre>dependencies {
    // ...
    compile 'com.github.shkschneider:android_PreferenceFragmentCompat:1.0.0@aar'
}</pre>

See [demo/build.gradle](https://github.com/shkschneider/android_PreferenceFragmentCompat/blob/master/demo/build.gradle).

Usage
-----

From your *Activity*:

<pre>getSupportFragmentManager().beginTransaction()
    .replace(android.R.id.content, new MyPreferenceFragment())
    .commit();</pre>

Your (**now Compat**) *PreferenceFragment*:

<pre>public class MyPreferenceFragment extends PreferenceFragmentCompat {

    @Override
    public void onCreate(final Bundle paramBundle) {
        super.onCreate(paramBundle);
        addPreferencesFromResource(R.xml.mypreferences);
        
        // findPreference()...
    }

}</pre>

API is the same as [android.preference.PreferenceFragment](https://developer.android.com/reference/android/preference/PreferenceFragment.html) except it (**now Compat**) extends [android.support.v4.app.Fragment](https://developer.android.com/reference/android/support/v4/app/Fragment.html), hence PreferenceFragment**Compat**.

Hope you enjoy!
