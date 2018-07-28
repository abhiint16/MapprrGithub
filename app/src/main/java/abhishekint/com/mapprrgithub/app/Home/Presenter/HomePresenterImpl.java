package abhishekint.com.mapprrgithub.app.Home.Presenter;

import abhishekint.com.mapprrgithub.app.Home.Adapter.AdapterViewLayer;
import abhishekint.com.mapprrgithub.app.Home.Interacter.RepoSearchHit;
import abhishekint.com.mapprrgithub.app.Home.PresentationLayer.HomeActivityView;

public class HomePresenterImpl implements HomePresenter {

    RepoSearchHit repoSearchHit;
    HomeActivityView homeActivityView;

    public HomePresenterImpl(HomeActivityView homeActivityView, RepoSearchHit repoSearchHit) {
        this.homeActivityView = homeActivityView;
        this.repoSearchHit = repoSearchHit;
    }


    @Override
    public void getHomeFeed(AdapterViewLayer adapterViewLayer) {

    }
}
