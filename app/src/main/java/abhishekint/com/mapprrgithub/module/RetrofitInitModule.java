package abhishekint.com.mapprrgithub.module;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class RetrofitInitModule {

    @Provides
    @Named("repo_search_retrofit")
    public Retrofit getRepoSearchRetrofit(@Named("repo_search_url") String baseURL, OkHttpClient okHttpClient)
    {
        return  getClient(baseURL, okHttpClient);
    }

    @Provides
    public Retrofit getClient(String baseURL,OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl(baseURL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
