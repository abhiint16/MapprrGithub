package abhishekint.com.mapprrgithub.app.RepoDetails.Interacter;

import java.util.List;

import abhishekint.com.mapprrgithub.app.Home.Model.RepoSearchModel;
import abhishekint.com.mapprrgithub.app.RepoDetails.Model.ContributorListModel;
import io.reactivex.Observable;

public class RepoDetailHit {

    RepoDetailClient repoDetailClient;

    public RepoDetailHit(RepoDetailClient repoDetailClient) {
        this.repoDetailClient = repoDetailClient;
    }

    public Observable<List<ContributorListModel>> hitContributorList(String url)
    {
        return repoDetailClient.getContributorList(url);
    }
}
