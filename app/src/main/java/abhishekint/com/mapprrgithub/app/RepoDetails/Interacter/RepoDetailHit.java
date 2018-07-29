package abhishekint.com.mapprrgithub.app.RepoDetails.Interacter;

import abhishekint.com.mapprrgithub.app.Home.Model.RepoSearchModel;
import io.reactivex.Observable;

public class RepoDetailHit {

    RepoDetailClient repoDetailClient;

    public RepoDetailHit(RepoDetailClient repoDetailClient) {
        this.repoDetailClient = repoDetailClient;
    }

    public Observable<RepoSearchModel> hitRepoDetail(String q,int page, int pageSize,String sort, String order)
    {
        return repoDetailClient.getHomeRepoSearch(q,page,pageSize,sort,order);
    }
}
