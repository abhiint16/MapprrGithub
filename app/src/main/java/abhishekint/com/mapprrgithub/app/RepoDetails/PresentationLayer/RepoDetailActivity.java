package abhishekint.com.mapprrgithub.app.RepoDetails.PresentationLayer;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import javax.inject.Inject;

import abhishekint.com.mapprrgithub.MapprrGitHubApplication;
import abhishekint.com.mapprrgithub.R;
import abhishekint.com.mapprrgithub.app.RepoDetails.Adapter.RepoDetailsRecyclerAdapter;
import abhishekint.com.mapprrgithub.app.RepoDetails.Interacter.RepoDetailHit;
import abhishekint.com.mapprrgithub.app.RepoDetails.Presenter.RepoDetailsPresenter;
import abhishekint.com.mapprrgithub.app.RepoDetails.Presenter.RepoDetailsPresenterImpl;
import abhishekint.com.mapprrgithub.schedulers.AppSchedulerProvider;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class RepoDetailActivity extends AppCompatActivity {
    @BindView(R.id.activity_repodetails_recyclerview)
    RecyclerView recyclerView;
    @BindView(R.id.activity_repodetails_avatar)
    ImageView activity_repodetails_avatar;
    @BindView(R.id.activity_repodetails_collapsingtoolbar)
    CollapsingToolbarLayout activity_repodetails_collapsingtoolbar;
    @Inject
    RepoDetailHit repoDetailHit;
    @Inject
    public AppSchedulerProvider appSchedulerProvider;


    Unbinder unbinder;
    RepoDetailsRecyclerAdapter repoDetailsRecyclerAdapter;
    GridLayoutManager layoutManager;
    RepoDetailsPresenter repoDetailsPresenter;
    String url;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repodetails);

        initializeDaggerAndButter();
        inflateIntentData();
        initializePresenter();
        createUrl();
        initializeRest();
    }

    private void createUrl() {
        this.url="https://api.github.com/repos/"+getIntent().getStringExtra("fullname")+"/contributors";

    }

    private void initializeRest() {
        repoDetailsRecyclerAdapter=new RepoDetailsRecyclerAdapter(repoDetailsPresenter,this,url,
                getIntent().getStringExtra("link"),getIntent().getStringExtra("description"));
        layoutManager=new GridLayoutManager(this, 3, LinearLayoutManager.VERTICAL, false);
        layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if (position==0||position==1||position==2||position==3)
                    return 3;
                else return 1;
            }
        });
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(repoDetailsRecyclerAdapter);
    }

    private void initializePresenter() {
        repoDetailsPresenter=new RepoDetailsPresenterImpl(repoDetailHit,appSchedulerProvider);
    }

    private void inflateIntentData() {
        activity_repodetails_collapsingtoolbar.setTitle(getIntent().getStringExtra("name"));
        Glide.with(this)
                .load(getIntent().getStringExtra("avatar"))
                .into(activity_repodetails_avatar);
    }

    private void initializeDaggerAndButter() {
        ((MapprrGitHubApplication) getApplicationContext()).getMapprrAppComponent().repoDetails(this);
        unbinder = ButterKnife.bind(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
