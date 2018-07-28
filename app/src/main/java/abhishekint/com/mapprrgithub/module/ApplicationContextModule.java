package abhishekint.com.mapprrgithub.module;

import android.content.Context;

import dagger.Module;

@Module
public class ApplicationContextModule {

    private Context applicationContext;

    public ApplicationContextModule(Context applicationContext) {
        this.applicationContext = applicationContext;
    }
}
