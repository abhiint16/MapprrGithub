package abhishekint.com.mapprrgithub.app.ContributorDetails.Interacter;

import java.util.List;

import abhishekint.com.mapprrgithub.app.Home.Model.RepoSearchModel;
import abhishekint.com.mapprrgithub.app.RepoDetails.Model.ContributorListModel;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface ContributorDetailClient {
    @GET
    Observable<List<RepoSearchModel.InnerItem>> getRepoList(@Url String url);
}
