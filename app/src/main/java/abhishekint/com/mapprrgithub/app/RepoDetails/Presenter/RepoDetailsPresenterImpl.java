package abhishekint.com.mapprrgithub.app.RepoDetails.Presenter;

import java.util.List;

import abhishekint.com.mapprrgithub.app.RepoDetails.Adapter.AdapterRepoDetailsViewLayer;
import abhishekint.com.mapprrgithub.app.RepoDetails.Interacter.RepoDetailHit;
import abhishekint.com.mapprrgithub.app.RepoDetails.Model.ContributorListModel;
import abhishekint.com.mapprrgithub.schedulers.AppSchedulerProvider;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class RepoDetailsPresenterImpl implements RepoDetailsPresenter {
    RepoDetailHit repoDetailHit;
    AppSchedulerProvider appSchedulerProvider;

    public RepoDetailsPresenterImpl(RepoDetailHit repoDetailHit, AppSchedulerProvider appSchedulerProvider) {
        this.repoDetailHit = repoDetailHit;
        this.appSchedulerProvider = appSchedulerProvider;
    }

    @Override
    public void getContributorFeed(String url, final AdapterRepoDetailsViewLayer adapterRepoDetailsViewLayer) {
        repoDetailHit.hitContributorList(url)
                .subscribeOn(appSchedulerProvider.io())
                .observeOn(appSchedulerProvider.ui())
                .subscribe(new Observer<List<ContributorListModel>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<ContributorListModel> contributorListModel) {
                        adapterRepoDetailsViewLayer.updateRepoDetailContributorData(contributorListModel);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
