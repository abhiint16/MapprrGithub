package abhishekint.com.mapprrgithub.app.ContributorDetails.Presenter;

import android.util.Log;

import java.util.List;

import abhishekint.com.mapprrgithub.app.ContributorDetails.Adapter.ContributorDetailsAdapterViewLayer;
import abhishekint.com.mapprrgithub.app.ContributorDetails.Interacter.ContributorDetailHit;
import abhishekint.com.mapprrgithub.app.Home.Model.RepoSearchModel;
import abhishekint.com.mapprrgithub.app.RepoDetails.Adapter.AdapterRepoDetailsViewLayer;
import abhishekint.com.mapprrgithub.app.RepoDetails.Interacter.RepoDetailHit;
import abhishekint.com.mapprrgithub.app.RepoDetails.Model.ContributorListModel;
import abhishekint.com.mapprrgithub.schedulers.AppSchedulerProvider;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class ContributorDetailsPresenterImpl implements ContributorDetailsPresenter {
    ContributorDetailHit contributorDetailHit;
    AppSchedulerProvider appSchedulerProvider;

    public ContributorDetailsPresenterImpl(ContributorDetailHit contributorDetailHit, AppSchedulerProvider appSchedulerProvider) {
        this.contributorDetailHit = contributorDetailHit;
        this.appSchedulerProvider = appSchedulerProvider;
    }

    @Override
    public void getRepoFeed(String url, final ContributorDetailsAdapterViewLayer contributorDetailsAdapterViewLayer) {
        Log.e("inisde presenter meth","inisde presnetr meth");
        contributorDetailHit.hitRepoList(url)
                .subscribeOn(appSchedulerProvider.io())
                .observeOn(appSchedulerProvider.ui())
                .subscribe(new Observer<List<RepoSearchModel.InnerItem>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<RepoSearchModel.InnerItem> innerItems) {
                        Log.e("inisde onnext","inisde onnext");
                        contributorDetailsAdapterViewLayer.updateContributorDetailRepoData(innerItems);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("inisde onerr","inisde onerr"+e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
