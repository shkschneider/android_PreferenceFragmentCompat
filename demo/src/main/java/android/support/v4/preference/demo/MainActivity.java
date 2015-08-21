package android.support.v4.preference.demo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.MenuItem;
import android.widget.Toolbar;

public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setLogo(getResources().getDrawable(R.drawable.ic_launcher, null));
        toolbar.setTitle("Demo");
        toolbar.setSubtitle(getResources().getString(R.string.app_label));
        toolbar.inflateMenu(R.menu.main);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {

            @Override
            public boolean onMenuItemClick(final MenuItem item) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/shkschneider/android_PreferenceFragmentCompat")));
                return true;
            }

        });

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frameLayout, new MainPreferenceFragment())
                .commit();
    }

}
