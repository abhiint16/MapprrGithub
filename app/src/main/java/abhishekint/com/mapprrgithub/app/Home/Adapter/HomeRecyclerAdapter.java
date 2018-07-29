package abhishekint.com.mapprrgithub.app.Home.Adapter;

import android.content.Context;
import android.content.Intent;
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
import abhishekint.com.mapprrgithub.app.RepoDetails.PresentationLayer.RepoDetailActivity;

public class HomeRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements AdapterViewLayer {

    HomePresenter homePresenter;
    RepoSearchModel repoSearchModel;
    Context context;

    public HomeRecyclerAdapter(HomePresenter homePresenter, Context context) {
        this.homePresenter = homePresenter;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 1) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_blank, parent, false);
            return new HomeRepoViewHolder1(view);
        } else {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_home, parent, false);
            return new HomeRepoViewHolder2(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Log.e("inside bind", "inside bind");
        if (holder.getItemViewType() == 2) {
            ((HomeRepoViewHolder2) holder).item_recycler_home_name.setText(repoSearchModel.getItems().get(position-1).getName());
            ((HomeRepoViewHolder2) holder).item_recycler_home_fullname.setText(repoSearchModel.getItems().get(position-1).getFull_name());
            ((HomeRepoViewHolder2) holder).item_recycler_home_watcher.setText("" + repoSearchModel.getItems().get(position-1).getWatchers_count());
            Glide.with(context)
                    .load(repoSearchModel.getItems().get(position-1).getOwner().getAvatar_url()).asBitmap()
                    .into(((HomeRepoViewHolder2) holder).item_recycler_home_avatar);
        }
    }

    @Override
    public int getItemCount() {
        Log.e("inside count", "inside count");
        if (repoSearchModel == null || repoSearchModel.getItems() == null || repoSearchModel.getItems().size() == 0)
            return 0;
        return repoSearchModel.getItems().size()+1;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0)
            return 1;
        else return 2;
    }

    @Override
    public void updateRepoSearchData(RepoSearchModel repoSearchModel) {
        this.repoSearchModel = repoSearchModel;
        Log.e("inside updaterepo", "inside updaterepo");
        notifyDataSetChanged();
    }

    public class HomeRepoViewHolder2 extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView item_recycler_home_name, item_recycler_home_fullname,
                item_recycler_home_watcher;
        ImageView item_recycler_home_avatar;

        public HomeRepoViewHolder2(View itemView) {
            super(itemView);
            item_recycler_home_name = (TextView) itemView.findViewById(R.id.item_recycler_home_name);
            item_recycler_home_fullname = (TextView) itemView.findViewById(R.id.item_recycler_home_fullname);
            item_recycler_home_watcher = (TextView) itemView.findViewById(R.id.item_recycler_home_watcher);
            item_recycler_home_avatar = (ImageView) itemView.findViewById(R.id.item_recycler_home_avatar);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Intent intent=new Intent(context, RepoDetailActivity.class);
            intent.putExtra("avatar",repoSearchModel.getItems().get(getAdapterPosition()-1).getOwner().getAvatar_url());
            intent.putExtra("description",repoSearchModel.getItems().get(getAdapterPosition()-1).getDescription());
            intent.putExtra("link",repoSearchModel.getItems().get(getAdapterPosition()-1).getHtml_url());
            intent.putExtra("name",repoSearchModel.getItems().get(getAdapterPosition()-1).getName());
            intent.putExtra("contributor_link",repoSearchModel.getItems().get(getAdapterPosition()-1).getContributors_url());
            context.startActivity(intent);
        }
    }

    public class HomeRepoViewHolder1 extends RecyclerView.ViewHolder {
        public HomeRepoViewHolder1(View itemView) {
            super(itemView);
        }
    }
}
