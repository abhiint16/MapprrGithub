package abhishekint.com.mapprrgithub.app.Home.Interacter;

import abhishekint.com.mapprrgithub.app.Home.Model.RepoSearchModel;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RepoSearchClient {
    @GET
    Observable<RepoSearchModel> getHomeRepoSearch(@Query("q") String search, @Query("page") int page,
                                                  @Query("per_page") int pageSize, @Query("sort") String sort,
                                                  @Query("order") String order);
}
