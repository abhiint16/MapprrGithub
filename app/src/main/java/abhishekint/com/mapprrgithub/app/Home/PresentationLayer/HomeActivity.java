package abhishekint.com.mapprrgithub.app.Home.PresentationLayer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;

import javax.inject.Inject;

import abhishekint.com.mapprrgithub.MapprrGitHubApplication;
import abhishekint.com.mapprrgithub.R;
import abhishekint.com.mapprrgithub.app.Home.Interater.RepoSearchHit;
import abhishekint.com.mapprrgithub.app.Home.Presenter.HomePresenter;
import abhishekint.com.mapprrgithub.app.Home.Presenter.HomePresenterImpl;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class HomeActivity extends AppCompatActivity implements HomeActivityView{

    @BindView(R.id.home_recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.home_searchview)
    SearchView searchView;
    @Inject
    RepoSearchHit repoSearchHit;

    Unbinder unbinder;
    HomePresenter homePresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initializeDaggerAndButter();
        initializePresenter();
    }

    private void initializePresenter() {
        homePresenter=new HomePresenterImpl(this,repoSearchHit);
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
