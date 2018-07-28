package abhishekint.com.mapprrgithub.module;

import abhishekint.com.mapprrgithub.schedulers.AppSchedulerProvider;
import dagger.Module;
import dagger.Provides;

@Module
public class SchedulerModule {

    @Provides
    public AppSchedulerProvider providesApplicationSchedulerProvider() {
        return new AppSchedulerProvider();
    }
}
