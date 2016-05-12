package android.support.v4.preference.demo;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setBackgroundColor(Color.parseColor("#2ecc71"));
        toolbar.setLogo(ContextCompat.getDrawable(MainActivity.this, R.drawable.ic_launcher));
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
