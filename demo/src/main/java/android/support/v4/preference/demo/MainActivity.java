package android.support.v4.preference.demo;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportFragmentManager().beginTransaction()
                .replace(android.R.id.content, new MainPreferenceFragment())
                .commit();
    }

}
