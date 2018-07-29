package abhishekint.com.mapprrgithub.app.RepoDetails.Presenter;

import abhishekint.com.mapprrgithub.app.RepoDetails.Adapter.AdapterRepoDetailsViewLayer;

public interface RepoDetailsPresenter {
    void getContributorFeed(String url, AdapterRepoDetailsViewLayer adapterRepoDetailsViewLayer);
}
