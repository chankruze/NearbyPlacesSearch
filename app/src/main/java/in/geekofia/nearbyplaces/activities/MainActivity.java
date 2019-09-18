package in.geekofia.nearbyplaces.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.WindowManager;

import in.geekofia.nearbyplaces.R;
import in.geekofia.nearbyplaces.fragments.HomeFragment;

public class MainActivity extends AppCompatActivity {


    private String KEY = "AIzaSyAFgy4WxcBnNafvHsC7uGPUCNTMr79gJNk";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // For full screen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            HomeFragment homeFragment = new HomeFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, homeFragment).commit();
        }
    }
}
