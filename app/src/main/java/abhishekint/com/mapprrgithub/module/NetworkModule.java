package abhishekint.com.mapprrgithub.module;

import javax.inject.Named;

import abhishekint.com.mapprrgithub.app.ContributorDetails.Interacter.ContributorDetailClient;
import abhishekint.com.mapprrgithub.app.ContributorDetails.Interacter.ContributorDetailHit;
import abhishekint.com.mapprrgithub.app.Home.Interacter.RepoSearchClient;
import abhishekint.com.mapprrgithub.app.Home.Interacter.RepoSearchHit;
import abhishekint.com.mapprrgithub.app.RepoDetails.Interacter.RepoDetailClient;
import abhishekint.com.mapprrgithub.app.RepoDetails.Interacter.RepoDetailHit;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class NetworkModule {

    @Provides
    public RepoSearchClient providesRepoSearchApiClient(@Named("repo_search_retrofit") Retrofit retrofit) {
        return retrofit.create(RepoSearchClient.class);
    }

    @Provides
    public RepoDetailClient providesRepoDetailApiClient(@Named("repo_search_retrofit") Retrofit retrofit) {
        return retrofit.create(RepoDetailClient.class);
    }

    @Provides
    public ContributorDetailClient providesContributorDetailApiClient(@Named("repo_search_retrofit") Retrofit retrofit) {
        return retrofit.create(ContributorDetailClient.class);
    }

    @Provides
    public RepoSearchHit providesRepoSearchFeed(RepoSearchClient repoSearchClient) {
        return new RepoSearchHit(repoSearchClient);
    }

    @Provides
    public RepoDetailHit providesRepoDetailFeed(RepoDetailClient repoDetailClient) {
        return new RepoDetailHit(repoDetailClient);
    }

    @Provides
    public ContributorDetailHit providesContributorDetailFeed(ContributorDetailClient contributorDetailClient) {
        return new ContributorDetailHit(contributorDetailClient);
    }
}
