package abhishekint.com.mapprrgithub.app.Home.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import abhishekint.com.mapprrgithub.app.Home.Model.RepoSearchModel;
import abhishekint.com.mapprrgithub.app.Home.Presenter.HomePresenter;

public class HomeRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements AdapterViewLayer{

    HomePresenter homePresenter;

    public HomeRecyclerAdapter(HomePresenter homePresenter) {
        this.homePresenter = homePresenter;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    @Override
    public void updateRepoSearchData(RepoSearchModel repoSearchModel) {

    }
}
