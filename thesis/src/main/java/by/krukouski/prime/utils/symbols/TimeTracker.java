package by.krukouski.prime.utils.symbols;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class TimeTracker {

	private static volatile TimeTracker INSTANCE;
	
	private Map<String, Long> tracker;
	private LocalDateTime start;
	private LocalDateTime finish;
	
	public static TimeTracker getInstance() {
		TimeTracker localInstance = INSTANCE;
		if(localInstance == null){
			synchronized (TimeTracker.class) {
				
				localInstance = INSTANCE;
				if(localInstance == null){
					INSTANCE = localInstance = new TimeTracker();
				}
				
			}
		}
		return localInstance;
	}
	
	private TimeTracker() {
		tracker = new HashMap<String, Long>();		
	}
	
	public void start() {
		start = LocalDateTime.now();
	}
	
	public void stop(String methodName) {
		finish = LocalDateTime.now();
		Duration duration = Duration.between(start, finish);
		tracker.put(methodName, duration.toMillis());
	}
	
	public Map<String, Long> getTracker() {
		return tracker;
	}
	
	
	
	
	
	
}
