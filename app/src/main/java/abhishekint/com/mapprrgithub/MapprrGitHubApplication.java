package abhishekint.com.mapprrgithub;

import android.app.Application;

/**
 * Created by abhishek on 14-03-2018.
 */

public class MapprrGitHubApplication extends Application {

    ComponentInterface componentInterface;
    @Override
    public void onCreate() {
        super.onCreate();
        componentInterface=DaggerComponentInterface.builder().build();
    }
}
