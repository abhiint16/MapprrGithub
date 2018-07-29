package abhishekint.com.mapprrgithub.app.Home.PresentationLayer;

import android.graphics.Color;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

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

public class HomeActivity extends AppCompatActivity implements HomeActivityView, View.OnClickListener {

    @BindView(R.id.home_recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.home_searchview)
    SearchView searchView;
    @BindView(R.id.home_filter)
    ImageButton home_filter;
    @Inject
    RepoSearchHit repoSearchHit;
    @Inject
    public AppSchedulerProvider appSchedulerProvider;

    Unbinder unbinder;
    HomePresenter homePresenter;
    RecyclerView.LayoutManager layoutManager;
    HomeRecyclerAdapter homeRecyclerAdapter;
    BottomSheetDialog bottomSheetDialog;

    String searchText="google";
    int page=1;
    int pageSize=10;
    String sort="stars";
    String order="desc";
    Button stars,forks,updated,asc,desc,apply;
    String temp_sort,temp_order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initializeDaggerAndButter();
        initializePresenter();
        initializeRest();
        getHomeFeed(searchText,page,pageSize,sort,order);
        initSearchView();
        initFilter();
    }

    private void initFilter() {
        bottomSheetDialog=new BottomSheetDialog(this);
        View sheetView = getLayoutInflater().inflate(R.layout.dialog_filter, null);
        bottomSheetDialog.setContentView(sheetView);
        stars = (Button) sheetView.findViewById(R.id.stars);
        forks = (Button) sheetView.findViewById(R.id.forks);
        updated = (Button) sheetView.findViewById(R.id.updated);
        asc = (Button) sheetView.findViewById(R.id.asc);
        desc = (Button) sheetView.findViewById(R.id.desc);
        apply=(Button)sheetView.findViewById(R.id.apply);
        apply.setOnClickListener(this);
        stars.setOnClickListener(this);
        forks.setOnClickListener(this);
        updated.setOnClickListener(this);
        asc.setOnClickListener(this);
        desc.setOnClickListener(this);
        home_filter.setOnClickListener(this);
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

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.home_filter)
        bottomSheetDialog.show();
        else if (v.getId()==R.id.stars)
        {
            stars.setTextColor(Color.GREEN);
            forks.setTextColor(Color.BLACK);
            updated.setTextColor(Color.BLACK);
            temp_sort="stars";
        }
        else if (v.getId()==R.id.forks)
        {
            stars.setTextColor(Color.BLACK);
            forks.setTextColor(Color.GREEN);
            updated.setTextColor(Color.BLACK);
            temp_sort="forks";
        }
        else if (v.getId()==R.id.updated)
        {
            stars.setTextColor(Color.BLACK);
            forks.setTextColor(Color.BLACK);
            updated.setTextColor(Color.GREEN);
            temp_sort="updated";
        }
        else if (v.getId()==R.id.asc)
        {
            asc.setTextColor(Color.GREEN);
            desc.setTextColor(Color.BLACK);
            temp_order="asc";
        }
        else if (v.getId()==R.id.desc)
        {
            asc.setTextColor(Color.BLACK);
            desc.setTextColor(Color.GREEN);
            temp_order="desc";
        }
        else if (v.getId()==R.id.apply)
        {
                sort=temp_sort;
                order=temp_order;
                getHomeFeed(searchText,page,pageSize,sort,order);
                bottomSheetDialog.dismiss();
        }
    }
}
