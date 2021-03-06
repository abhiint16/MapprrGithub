package abhishekint.com.mapprrgithub.app.ContributorDetails.Adapter;

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

import java.util.List;

import abhishekint.com.mapprrgithub.R;
import abhishekint.com.mapprrgithub.app.ContributorDetails.Presenter.ContributorDetailsPresenter;
import abhishekint.com.mapprrgithub.app.Home.Model.RepoSearchModel;
import abhishekint.com.mapprrgithub.app.RepoDetails.PresentationLayer.RepoDetailActivity;

public class ContributorDetailsRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements ContributorDetailsAdapterViewLayer{
    ContributorDetailsPresenter contributorDetailsPresenter;
    String repo_url;
    Context context;
    List<RepoSearchModel.InnerItem> innerItems;

    public ContributorDetailsRecyclerAdapter(ContributorDetailsPresenter contributorDetailsPresenter, Context context ,String repo_url) {
        this.contributorDetailsPresenter = contributorDetailsPresenter;
        this.repo_url = repo_url;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType==0)
        {
            View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_repodetails_contributors_title,parent,false);
            return new ViewHolder0(view);
        }
        else if (viewType==1)
        {
            View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_repodetails_load,parent,false);
            return new ViewHolder1(view);
        }
        else
        {
            View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_home,parent,false);
            return new ViewHolder2(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder.getItemViewType()==0)
        {
            ((ViewHolder0)holder).item_common_title.setText("Repository List");
        }
        else if (holder.getItemViewType()==1)
        {
            Log.e("inisde position 1","inisde pos 1");
            contributorDetailsPresenter.getRepoFeed(repo_url,this);
        }
        else if (holder.getItemViewType()==2)
        {Log.e("inisde position 2","inisde pos 2");
            ((ViewHolder2) holder).item_recycler_home_name.setText(innerItems.get(position-1).getName());
            ((ViewHolder2) holder).item_recycler_home_fullname.setText(innerItems.get(position-1).getFull_name());
            ((ViewHolder2) holder).item_recycler_home_watcher.setText("" + innerItems.get(position-1).getWatchers_count());
            Glide.with(context)
                    .load(innerItems.get(position-1).getOwner().getAvatar_url()).asBitmap()
                    .into(((ViewHolder2) holder).item_recycler_home_avatar);
        }
    }

    @Override
    public int getItemCount() {
        if (innerItems==null||innerItems.size()==0)
            return 2;
        else
            return innerItems.size()+1;
    }

    @Override
    public int getItemViewType(int position) {
        if (innerItems==null||innerItems.size()==0)
        {
            if (position==0)
                return 0;
            else
                return 1;
        }
        else
        {
            if (position==0)
                return 0;
            else
                return 2;
        }
    }

    @Override
    public void updateContributorDetailRepoData(List<RepoSearchModel.InnerItem> innerItems) {
        this.innerItems=innerItems;
        notifyDataSetChanged();
    }

    public class ViewHolder0 extends RecyclerView.ViewHolder {
        TextView item_common_title;
        public ViewHolder0(View itemView) {
            super(itemView);
            item_common_title=(TextView)itemView.findViewById(R.id.item_common_title);
        }
    }

    public class ViewHolder1 extends RecyclerView.ViewHolder {
        public ViewHolder1(View itemView) {
            super(itemView);
        }
    }

    public class ViewHolder2 extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView item_recycler_home_name, item_recycler_home_fullname,
                item_recycler_home_watcher;
        ImageView item_recycler_home_avatar;
        public ViewHolder2(View itemView) {
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
            intent.putExtra("avatar",innerItems.get(getAdapterPosition()).getOwner().getAvatar_url());
            intent.putExtra("description",innerItems.get(getAdapterPosition()).getDescription());
            intent.putExtra("link",innerItems.get(getAdapterPosition()).getHtml_url());
            intent.putExtra("name",innerItems.get(getAdapterPosition()).getName());
            intent.putExtra("contributor_link",innerItems.get(getAdapterPosition()).getContributors_url());
            context.startActivity(intent);
        }
    }
}
