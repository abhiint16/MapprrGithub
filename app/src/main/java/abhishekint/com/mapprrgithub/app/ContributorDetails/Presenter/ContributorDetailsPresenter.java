package abhishekint.com.mapprrgithub.app.ContributorDetails.Presenter;

import abhishekint.com.mapprrgithub.app.ContributorDetails.Adapter.ContributorDetailsAdapterViewLayer;
import abhishekint.com.mapprrgithub.app.RepoDetails.Adapter.AdapterRepoDetailsViewLayer;

public interface ContributorDetailsPresenter {
    void getRepoFeed(String url, ContributorDetailsAdapterViewLayer contributorDetailsAdapterViewLayer);
}
