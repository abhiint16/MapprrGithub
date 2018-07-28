package abhishekint.com.mapprrgithub.module;

import javax.inject.Named;

import abhishekint.com.mapprrgithub.app.Home.Interater.RepoSearchClient;
import abhishekint.com.mapprrgithub.app.Home.Interater.RepoSearchHit;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class NetworkModule {

    @Provides
    public RepoSearchClient providesTopHeadApiClient(@Named("repo_search_retrofit") Retrofit retrofit) {
        return retrofit.create(RepoSearchClient.class);
    }

    @Provides
    public RepoSearchHit providesRepoSearchFeed(RepoSearchClient repoSearchClient) {
        return new RepoSearchHit(repoSearchClient);
    }
}
