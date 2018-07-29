package abhishekint.com.mapprrgithub.app.ContributorDetails.Interacter;

import android.util.Log;

import java.util.List;

import abhishekint.com.mapprrgithub.app.Home.Model.RepoSearchModel;
import abhishekint.com.mapprrgithub.app.RepoDetails.Model.ContributorListModel;
import io.reactivex.Observable;

public class ContributorDetailHit {

    ContributorDetailClient contributorDetailClient;

    public ContributorDetailHit(ContributorDetailClient contributorDetailClient) {
        this.contributorDetailClient = contributorDetailClient;
    }

    public Observable<List<RepoSearchModel.InnerItem>> hitRepoList(String url)
    {
        Log.e("inisde hi tmeth","inisde hit meth");
        return contributorDetailClient.getRepoList(url);
    }
}
