package abhishekint.com.mapprrgithub.app.RepoDetails.Adapter;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import abhishekint.com.mapprrgithub.R;
import abhishekint.com.mapprrgithub.app.ContributorDetails.PresentationLayer.ContributorDetailsActivity;
import abhishekint.com.mapprrgithub.app.RepoDetails.Model.ContributorListModel;
import abhishekint.com.mapprrgithub.app.RepoDetails.Presenter.RepoDetailsPresenter;

public class RepoDetailsRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements AdapterRepoDetailsViewLayer{
    RepoDetailsPresenter repoDetailsPresenter;
    Context context;
    String url,description,link;
    List<ContributorListModel> contributorListModel;

    public RepoDetailsRecyclerAdapter(RepoDetailsPresenter repoDetailsPresenter, Context context, String url,
                                      String link, String description) {
        this.repoDetailsPresenter = repoDetailsPresenter;
        this.context = context;
        this.url = url;
        this.link=link;
        this.description=description;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 0) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_repodetails_link, parent, false);
            return new ViewHolder0(view);
        } else if (viewType == 1) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_repodetails_link, parent, false);
            return new ViewHolder1(view);
        } else if (viewType == 2) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_repodetails_contributors_title, parent, false);
            return new ViewHolder2(view);
        } else if (viewType == 3) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_repodetails_load, parent, false);
            return new ViewHolder3(view);
        }
        else if (viewType == 5) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_repodetails_contributors_title, parent, false);
            return new ViewHolder5(view);
        } else {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_repodetails_contributor_item, parent, false);
            return new ViewHolder4(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder.getItemViewType()==0)
        {
            ((ViewHolder0)holder).item_repodetails_link_title.setText("Project Link");
            ((ViewHolder0)holder).item_repodetails_link_desc.setText(link);
        }
        else if (holder.getItemViewType()==1)
        {
            ((ViewHolder1)holder).item_repodetails_link_title.setText("Description");
            ((ViewHolder1)holder).item_repodetails_link_desc.setText(description);
        }
        else if (holder.getItemViewType()==2)
        {
        }
        else if (holder.getItemViewType()==3)
        {
            repoDetailsPresenter.getContributorFeed(url,this);
        }
        else if (holder.getItemViewType()==4)
        {
            ((ViewHolder4)holder).item_repodetails_contributors_name.setText(contributorListModel.get(position-4).getLogin());
            Glide.with(context).load(contributorListModel.get(position-4).getAvatar_url())
                    .into(((ViewHolder4)holder).item_repodetails_contributors_avatar);
        }
    }

    @Override
    public int getItemCount() {
        if (contributorListModel == null || contributorListModel.size() == 0)
            return 4;
        else
            return contributorListModel.size() + 4;
    }

    @Override
    public int getItemViewType(int position) {
        if (contributorListModel == null || contributorListModel.size() == 0) {
            if (position == 0)
                return 0;
            else if (position == 1)
                return 1;
            else if (position == 2)
                return 2;
            else
                return 3;
        } else {
            if (position == 0)
                return 0;
            else if (position == 1)
                return 1;
            else if (position == 2)
                return 2;
            else if (position == 3)
                return 5;
            else
                return 4;
        }
    }

    @Override
    public void updateRepoDetailContributorData(List<ContributorListModel> contributorListModel) {
        this.contributorListModel=contributorListModel;
        notifyDataSetChanged();
    }

    public class ViewHolder0 extends RecyclerView.ViewHolder {
        TextView item_repodetails_link_title,item_repodetails_link_desc;
        public ViewHolder0(View itemView) {
            super(itemView);
            item_repodetails_link_title=(TextView)itemView.findViewById(R.id.item_repodetails_link_title);
            item_repodetails_link_desc=(TextView)itemView.findViewById(R.id.item_repodetails_link_desc);
        }
    }

    public class ViewHolder1 extends RecyclerView.ViewHolder {
        TextView item_repodetails_link_title,item_repodetails_link_desc;
        public ViewHolder1(View itemView) {
            super(itemView);
            item_repodetails_link_title=(TextView)itemView.findViewById(R.id.item_repodetails_link_title);
            item_repodetails_link_desc=(TextView)itemView.findViewById(R.id.item_repodetails_link_desc);
        }
    }

    public class ViewHolder2 extends RecyclerView.ViewHolder {
        public ViewHolder2(View itemView) {
            super(itemView);
        }
    }

    public class ViewHolder3 extends RecyclerView.ViewHolder {
        public ViewHolder3(View itemView) {
            super(itemView);
        }
    }

    public class ViewHolder5 extends RecyclerView.ViewHolder {
        public ViewHolder5(View itemView) {
            super(itemView);
        }
    }


    public class ViewHolder4 extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView item_repodetails_contributors_name;
        ImageView item_repodetails_contributors_avatar;
        public ViewHolder4(View itemView) {
            super(itemView);
            item_repodetails_contributors_name=(TextView)itemView.findViewById(R.id.item_repodetails_contributors_name);
            item_repodetails_contributors_avatar=(ImageView)itemView.findViewById(R.id.item_repodetails_contributors_avatar);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Intent intent=new Intent(context, ContributorDetailsActivity.class);
            intent.putExtra("name",contributorListModel.get(getAdapterPosition()-4).getLogin());
            intent.putExtra("avatar",contributorListModel.get(getAdapterPosition()-4).getAvatar_url());
            intent.putExtra("repo_url",contributorListModel.get(getAdapterPosition()-4).getRepos_url());
            context.startActivity(intent);
        }
    }

}
