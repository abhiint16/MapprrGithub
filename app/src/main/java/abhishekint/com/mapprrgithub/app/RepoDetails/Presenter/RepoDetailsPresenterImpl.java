package abhishekint.com.mapprrgithub.app.RepoDetails.Presenter;

import abhishekint.com.mapprrgithub.app.RepoDetails.Interacter.RepoDetailHit;
import abhishekint.com.mapprrgithub.schedulers.AppSchedulerProvider;

public class RepoDetailsPresenterImpl implements RepoDetailsPresenter {
    RepoDetailHit repoDetailHit;
    AppSchedulerProvider appSchedulerProvider;

    public RepoDetailsPresenterImpl(RepoDetailHit repoDetailHit, AppSchedulerProvider appSchedulerProvider) {
        this.repoDetailHit = repoDetailHit;
        this.appSchedulerProvider = appSchedulerProvider;
    }

    @Override
    public void getContributorFeed() {
        
    }
}
