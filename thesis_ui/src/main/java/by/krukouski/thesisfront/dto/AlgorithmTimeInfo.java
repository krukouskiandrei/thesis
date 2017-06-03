package by.krukouski.thesisfront.dto;

public class AlgorithmTimeInfo {

	private String name;
	private Long duration;
	
	public AlgorithmTimeInfo() {}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	
	public void setDuration(Long duration) {
		this.duration = duration;
	}
	public Long getDuration() {
		return duration;
	}
	
}
