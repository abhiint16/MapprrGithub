package abhishekint.com.mapprrgithub.module;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationContextModule {

    private Context applicationContext;

    public ApplicationContextModule(Context applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Provides
    public Context getApplicationContext() {
        return applicationContext;
    }

}
