package abhishekint.com.mapprrgithub.module;

import android.content.Context;

import javax.inject.Named;

import abhishekint.com.mapprrgithub.R;
import dagger.Module;
import dagger.Provides;

@Module
public class BaseUrlModule {

    @Provides
    @Named("top_head_url")
    public String getBaseUrlRepoSearch(Context applicationContext) {
        return applicationContext.getString(R.string.base_url_repo_search);
    }
}
