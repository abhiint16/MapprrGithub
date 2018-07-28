package abhishekint.com.mapprrgithub.schedulers;

import io.reactivex.Scheduler;

// SchedulerProvider exposes a contract to strategically choose an appropriate scheduler

public interface SchedulerProvider {
    Scheduler ui();

    Scheduler io();
}
