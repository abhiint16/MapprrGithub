package abhishekint.com.mapprrgithub.app.Home.Interacter;

import io.reactivex.Observable;
import abhishekint.com.mapprrgithub.app.Home.Model.RepoSearchModel;

public class RepoSearchHit {

    RepoSearchClient repoSearchClient;

    public RepoSearchHit(RepoSearchClient repoSearchClient) {
        this.repoSearchClient = repoSearchClient;
    }

    public Observable<RepoSearchModel> hitRepoSearch(String q,int page, int pageSize,String sort, String order)
    {
        return repoSearchClient.getHomeRepoSearch(q,page,pageSize,sort,order);
    }
}
