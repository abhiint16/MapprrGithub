package abhishekint.com.mapprrgithub.app.RepoDetails.Interacter;

import java.util.List;

import abhishekint.com.mapprrgithub.app.Home.Model.RepoSearchModel;
import abhishekint.com.mapprrgithub.app.RepoDetails.Model.ContributorListModel;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface RepoDetailClient {
    @GET
    Observable<List<ContributorListModel>> getContributorList(@Url String url);
}
