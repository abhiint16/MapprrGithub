package abhishekint.com.mapprrgithub.app.Home.PresentationLayer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import abhishekint.com.mapprrgithub.R;

public class HomeActivity extends AppCompatActivity implements HomeActivityView{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }
}
