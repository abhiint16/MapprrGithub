package abhishekint.com.mapprrgithub;


import abhishekint.com.mapprrgithub.module.ApplicationContextModule;
import abhishekint.com.mapprrgithub.module.BaseUrlModule;
import abhishekint.com.mapprrgithub.module.NetworkModule;
import abhishekint.com.mapprrgithub.module.OkHttpModule;
import abhishekint.com.mapprrgithub.module.RetrofitInitModule;
import dagger.Component;

@Component(modules = {ApplicationContextModule.class, RetrofitInitModule.class,
        BaseUrlModule.class, OkHttpModule.class, NetworkModule.class})
public interface ComponentInterface {
}
