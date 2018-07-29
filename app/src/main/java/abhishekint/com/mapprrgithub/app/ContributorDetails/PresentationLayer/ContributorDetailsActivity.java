package abhishekint.com.mapprrgithub.app.ContributorDetails.PresentationLayer;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import javax.inject.Inject;

import abhishekint.com.mapprrgithub.MapprrGitHubApplication;
import abhishekint.com.mapprrgithub.R;
import abhishekint.com.mapprrgithub.app.ContributorDetails.Adapter.ContributorDetailsRecyclerAdapter;
import abhishekint.com.mapprrgithub.app.ContributorDetails.Interacter.ContributorDetailHit;
import abhishekint.com.mapprrgithub.app.ContributorDetails.Presenter.ContributorDetailsPresenter;
import abhishekint.com.mapprrgithub.app.ContributorDetails.Presenter.ContributorDetailsPresenterImpl;
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
    @Inject
    ContributorDetailHit contributorDetailHit;

    Unbinder unbinder;
    ContributorDetailsRecyclerAdapter repoDetailsRecyclerAdapter;
    RecyclerView.LayoutManager layoutManager;
    ContributorDetailsPresenter contributorDetailsPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repodetails);

        initializeDaggerAndButter();
        inflateIntentData();
        initializePresenter();
        initializeRest();
    }

    private void initializeRest() {
        repoDetailsRecyclerAdapter=new ContributorDetailsRecyclerAdapter(contributorDetailsPresenter,this,getIntent().getStringExtra("repo_url") );
        layoutManager=new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(repoDetailsRecyclerAdapter);
    }

    private void initializePresenter() {
        contributorDetailsPresenter=new ContributorDetailsPresenterImpl(contributorDetailHit,appSchedulerProvider);
    }

    private void initializeDaggerAndButter() {
        ((MapprrGitHubApplication) getApplicationContext()).getMapprrAppComponent().contributorsDetail(this);
        unbinder = ButterKnife.bind(this);
    }

    private void inflateIntentData() {
        activity_repodetails_collapsingtoolbar.setTitle(getIntent().getStringExtra("name"));
        Glide.with(this)
                .load(getIntent().getStringExtra("avatar"))
                .into(activity_repodetails_avatar);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
