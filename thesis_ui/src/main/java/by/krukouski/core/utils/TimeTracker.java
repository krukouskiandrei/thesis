package by.krukouski.core.utils;

import java.time.Duration;
import java.time.LocalDateTime;

public class TimeTracker {

	private static volatile TimeTracker INSTANCE;
	
	private LocalDateTime start;
	private LocalDateTime finish;
	private Duration duration;
	
	private TimeTracker() {}
	
	public static TimeTracker getInstance() {
		TimeTracker localInstance = INSTANCE;
		if(localInstance == null) {
			synchronized (TimeTracker.class) {
				localInstance = INSTANCE;
				if(localInstance == null) {
					INSTANCE = localInstance = new TimeTracker();
				}
			}
		}
		
		return localInstance;
	}
	
	public void start() {
		this.start = LocalDateTime.now();
	}
	
	public void stop() {
		this.finish = LocalDateTime.now();
		this.duration = Duration.between(start, finish);		
	}
	
	public Duration getDuration() {
		return duration;
	}
	
}
