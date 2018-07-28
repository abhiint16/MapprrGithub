package abhishekint.com.mapprrgithub.schedulers;


import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

// AppSchedulerProvider exposes scheduler implementations to be used by the app

public class AppSchedulerProvider implements SchedulerProvider {
    @Override
    public Scheduler ui() {
        return AndroidSchedulers.mainThread();   //provided by RxAndroid
    }

    @Override
    public Scheduler io() {
        return Schedulers.io();
    }
}
