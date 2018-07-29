package abhishekint.com.mapprrgithub.app.RepoDetails.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import abhishekint.com.mapprrgithub.app.RepoDetails.Presenter.RepoDetailsPresenter;

public class RepoDetailsRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    RepoDetailsPresenter repoDetailsPresenter;
    Context context;

    public RepoDetailsRecyclerAdapter(RepoDetailsPresenter repoDetailsPresenter, Context context) {
        this.repoDetailsPresenter = repoDetailsPresenter;
        this.context = context;
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
}
