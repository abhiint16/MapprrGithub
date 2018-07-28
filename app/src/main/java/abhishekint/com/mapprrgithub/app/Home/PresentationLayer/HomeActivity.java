package abhishekint.com.mapprrgithub.app.Home.PresentationLayer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import abhishekint.com.mapprrgithub.MapprrGitHubApplication;
import abhishekint.com.mapprrgithub.R;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class HomeActivity extends AppCompatActivity implements HomeActivityView{

    Unbinder unbinder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initializeDaggerAndButter();
    }

    private void initializeDaggerAndButter() {
        ((MapprrGitHubApplication) getApplicationContext()).getMapprrAppComponent().home(this);
        unbinder = ButterKnife.bind(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
