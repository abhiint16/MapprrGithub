package abhishekint.com.mapprrgithub.app.Home.Presenter;

import abhishekint.com.mapprrgithub.app.Home.Adapter.AdapterViewLayer;

public interface HomePresenter {

    void getHomeFeed(AdapterViewLayer adapterViewLayer,String q,int page, int pageSize,String sort, String order);
}
