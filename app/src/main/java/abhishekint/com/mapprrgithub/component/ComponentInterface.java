package abhishekint.com.mapprrgithub.component;


import abhishekint.com.mapprrgithub.app.Home.PresentationLayer.HomeActivity;
import abhishekint.com.mapprrgithub.module.ApplicationContextModule;
import abhishekint.com.mapprrgithub.module.BaseUrlModule;
import abhishekint.com.mapprrgithub.module.NetworkModule;
import abhishekint.com.mapprrgithub.module.OkHttpModule;
import abhishekint.com.mapprrgithub.module.RetrofitInitModule;
import abhishekint.com.mapprrgithub.module.SchedulerModule;
import dagger.Component;

@Component(modules = {ApplicationContextModule.class, RetrofitInitModule.class,
        BaseUrlModule.class, OkHttpModule.class, NetworkModule.class, SchedulerModule.class})
public interface ComponentInterface {
    void home(HomeActivity homeActivity);
}
