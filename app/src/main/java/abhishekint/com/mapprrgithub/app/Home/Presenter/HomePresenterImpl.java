package abhishekint.com.mapprrgithub.app.Home.Presenter;

import java.util.Observable;

import abhishekint.com.mapprrgithub.app.Home.Adapter.AdapterViewLayer;
import abhishekint.com.mapprrgithub.app.Home.Interacter.RepoSearchHit;
import abhishekint.com.mapprrgithub.app.Home.Model.RepoSearchModel;
import abhishekint.com.mapprrgithub.app.Home.PresentationLayer.HomeActivityView;
import abhishekint.com.mapprrgithub.schedulers.AppSchedulerProvider;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;

public class HomePresenterImpl implements HomePresenter {

    RepoSearchHit repoSearchHit;
    HomeActivityView homeActivityView;
    AppSchedulerProvider appSchedulerProvider;

    public HomePresenterImpl(HomeActivityView homeActivityView, RepoSearchHit repoSearchHit, AppSchedulerProvider appSchedulerProvider) {
        this.homeActivityView = homeActivityView;
        this.repoSearchHit = repoSearchHit;
        this.appSchedulerProvider = appSchedulerProvider;
    }


    @Override
    public void getHomeFeed(final AdapterViewLayer adapterViewLayer, String q, int page, int pageSize, String sort, String order) {
        repoSearchHit.hitRepoSearch(q,page,pageSize,sort,order)
                .subscribeOn(appSchedulerProvider.io())
                .observeOn(appSchedulerProvider.ui())
                .subscribe(new Observer<RepoSearchModel>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(RepoSearchModel repoSearchModel) {
                        adapterViewLayer.updateRepoSearchData(repoSearchModel);
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
