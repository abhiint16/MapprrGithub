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

import abhishekint.com.mapprrgithub.MapprrGitHubApplication;
import abhishekint.com.mapprrgithub.R;
import abhishekint.com.mapprrgithub.app.RepoDetails.Adapter.RepoDetailsRecyclerAdapter;
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

    Unbinder unbinder;
    RepoDetailsRecyclerAdapter repoDetailsRecyclerAdapter;
    RecyclerView.LayoutManager layoutManager;

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
        repoDetailsRecyclerAdapter=new RepoDetailsRecyclerAdapter(homePresenter,this);
        layoutManager=new GridLayoutManager(this, 3, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(repoDetailsRecyclerAdapter);
    }

    private void initializePresenter() {
    }

    private void inflateIntentData() {
        activity_repodetails_collapsingtoolbar.setTitle(getIntent().getStringExtra("name"));
        Glide.with(this)
                .load(getIntent().getStringExtra("avatar"))
                .into(activity_repodetails_avatar);
    }

    private void initializeDaggerAndButter() {
        unbinder = ButterKnife.bind(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
