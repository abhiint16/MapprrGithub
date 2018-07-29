package abhishekint.com.mapprrgithub.app.ContributorDetails.PresentationLayer;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import javax.inject.Inject;

import abhishekint.com.mapprrgithub.MapprrGitHubApplication;
import abhishekint.com.mapprrgithub.R;
import abhishekint.com.mapprrgithub.schedulers.AppSchedulerProvider;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class ContributorDetailsActivity extends AppCompatActivity {
    @BindView(R.id.activity_repodetails_recyclerview)
    RecyclerView recyclerView;
    @BindView(R.id.activity_repodetails_avatar)
    ImageView activity_repodetails_avatar;
    @BindView(R.id.activity_repodetails_collapsingtoolbar)
    CollapsingToolbarLayout activity_repodetails_collapsingtoolbar;
    @Inject
    public AppSchedulerProvider appSchedulerProvider;

    Unbinder unbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repodetails);

        initializeDaggerAndButter();
    }

    private void initializeDaggerAndButter() {
        ((MapprrGitHubApplication) getApplicationContext()).getMapprrAppComponent().contributorsDetail(this);
        unbinder = ButterKnife.bind(this);
    }
}
