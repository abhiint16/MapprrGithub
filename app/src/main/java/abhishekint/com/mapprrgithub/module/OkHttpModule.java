package abhishekint.com.mapprrgithub.module;

import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

@Module
public class OkHttpModule {

    @Provides
    public OkHttpClient getOkHttp()
    {
        return new OkHttpClient.Builder()
                .connectTimeout(30L, TimeUnit.SECONDS)
                .readTimeout(30L, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .build();
    }
}
