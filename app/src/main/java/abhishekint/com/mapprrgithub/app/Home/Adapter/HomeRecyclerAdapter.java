package abhishekint.com.mapprrgithub.app.Home.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import abhishekint.com.mapprrgithub.R;
import abhishekint.com.mapprrgithub.app.Home.Model.RepoSearchModel;
import abhishekint.com.mapprrgithub.app.Home.Presenter.HomePresenter;

public class HomeRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements AdapterViewLayer{

    HomePresenter homePresenter;
    RepoSearchModel repoSearchModel;

    public HomeRecyclerAdapter(HomePresenter homePresenter) {
        this.homePresenter = homePresenter;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_home,parent,false);
        return new HomeRepoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Log.e("inside bind","inside bind");
        ((HomeRepoViewHolder)holder).item_recycler_home_name.setText(repoSearchModel.getItems().get(position).getName());
        ((HomeRepoViewHolder)holder).item_recycler_home_fullname.setText(repoSearchModel.getItems().get(position).getFull_name());
        ((HomeRepoViewHolder)holder).item_recycler_home_watcher.setText(""+repoSearchModel.getItems().get(position).getWatchers_count());
        ((HomeRepoViewHolder)holder).item_recycler_home_fork.setText(""+repoSearchModel.getItems().get(position).getForks_count());
        ((HomeRepoViewHolder)holder).item_recycler_home_star.setText(""+repoSearchModel.getItems().get(position).getStargazers_count());
    }

    @Override
    public int getItemCount() {
        Log.e("inside count","inside count");
        if (repoSearchModel==null || repoSearchModel.getItems()==null || repoSearchModel.getItems().size()==0)
            return 0;
        return repoSearchModel.getItems().size();
    }

    @Override
    public void updateRepoSearchData(RepoSearchModel repoSearchModel) {
        this.repoSearchModel=repoSearchModel;
        Log.e("inside updaterepo","inside updaterepo");
        notifyDataSetChanged();
    }

    public class HomeRepoViewHolder extends RecyclerView.ViewHolder {
        public TextView item_recycler_home_name,item_recycler_home_fullname,item_recycler_home_fork,item_recycler_home_star,
                item_recycler_home_watcher;
        ImageView item_recycler_home_avatar;

        public HomeRepoViewHolder(View itemView) {
            super(itemView);
            item_recycler_home_name=(TextView)itemView.findViewById(R.id.item_recycler_home_name);
            item_recycler_home_fullname=(TextView)itemView.findViewById(R.id.item_recycler_home_fullname);
            item_recycler_home_fork=(TextView)itemView.findViewById(R.id.item_recycler_home_fork);
            item_recycler_home_star=(TextView)itemView.findViewById(R.id.item_recycler_home_star);
            item_recycler_home_watcher=(TextView)itemView.findViewById(R.id.item_recycler_home_watcher);
            item_recycler_home_avatar=(ImageView)itemView.findViewById(R.id.item_recycler_home_avatar);
        }
    }
}
