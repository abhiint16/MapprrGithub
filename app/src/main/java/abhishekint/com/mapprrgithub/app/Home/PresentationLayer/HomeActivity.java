package abhishekint.com.mapprrgithub.app.Home.PresentationLayer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;

import javax.inject.Inject;

import abhishekint.com.mapprrgithub.MapprrGitHubApplication;
import abhishekint.com.mapprrgithub.R;
import abhishekint.com.mapprrgithub.app.Home.Adapter.HomeRecyclerAdapter;
import abhishekint.com.mapprrgithub.app.Home.Interacter.RepoSearchHit;
import abhishekint.com.mapprrgithub.app.Home.Presenter.HomePresenter;
import abhishekint.com.mapprrgithub.app.Home.Presenter.HomePresenterImpl;
import abhishekint.com.mapprrgithub.schedulers.AppSchedulerProvider;
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
    @Inject
    public AppSchedulerProvider appSchedulerProvider;

    Unbinder unbinder;
    HomePresenter homePresenter;
    RecyclerView.LayoutManager layoutManager;
    HomeRecyclerAdapter homeRecyclerAdapter;

    String searchText="google";
    int page=1;
    int pageSize=10;
    String sort="stars";
    String order="desc";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initializeDaggerAndButter();
        initializePresenter();
        initializeRest();
        getHomeFeed(searchText,page,pageSize,sort,order);
        initSearchView();
    }

    private void initSearchView() {
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                searchText=query;
                getHomeFeed(query,page,pageSize,sort,order);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }

    private void getHomeFeed(String query,int page,int pageSize,String sort, String order) {
        homePresenter.getHomeFeed(homeRecyclerAdapter,query,page,pageSize,sort,order);
    }

    private void initializeRest() {
        homeRecyclerAdapter=new HomeRecyclerAdapter(homePresenter,this);
        layoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(homeRecyclerAdapter);
    }

    private void initializePresenter() {
        homePresenter=new HomePresenterImpl(this,repoSearchHit,appSchedulerProvider);
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
