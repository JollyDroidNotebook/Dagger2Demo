package ru.jollydroid.dagger2demo;

import android.app.NotificationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {
    private TextView hello;

    @Inject MyPreferences preferences;
    @Inject NotificationManager notificationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hello = (TextView)findViewById(R.id.hello);

        getAppComponent().inject(this);

        if (preferences.isVisited()) {
            hello.setText("Welcome back!");

        } else {
            hello.setText("Hello, anonymous!");
            preferences.setVisited();
        }
    }

    AppComponent getAppComponent() {
        return ((MyApplication)getApplication()).getAppComponent();
    }
}
