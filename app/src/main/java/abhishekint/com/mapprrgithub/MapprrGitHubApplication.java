package abhishekint.com.mapprrgithub;

import android.app.Application;

import abhishekint.com.mapprrgithub.component.ComponentInterface;
import abhishekint.com.mapprrgithub.component.DaggerComponentInterface;
import abhishekint.com.mapprrgithub.module.ApplicationContextModule;

/**
 * Created by abhishek on 14-03-2018.
 */

public class MapprrGitHubApplication extends Application {

    ComponentInterface componentInterface;
    @Override
    public void onCreate() {
        super.onCreate();
        componentInterface= DaggerComponentInterface.builder()
                .applicationContextModule(new ApplicationContextModule(this))
                .build();
    }

    public ComponentInterface getMapprrAppComponent() {
        return componentInterface;
    }
}
