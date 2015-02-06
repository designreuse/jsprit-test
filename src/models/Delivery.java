package models;

import java.time.LocalTime;

public class Delivery {
	
	private String description;
	
	private Double latitude;
	
	private Double longitude;
	
	private LocalTime windowStart;
	
	private LocalTime windowEnd;
	
	private Integer unloadingDuration;
	
	private Double loadWeight;
	
	private Double loadVolume;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public LocalTime getWindowStart() {
		return windowStart;
	}

	public void setWindowStart(LocalTime windowStart) {
		this.windowStart = windowStart;
	}

	public LocalTime getWindowEnd() {
		return windowEnd;
	}

	public void setWindowEnd(LocalTime windowEnd) {
		this.windowEnd = windowEnd;
	}

	public Integer getUnloadingDuration() {
		return unloadingDuration;
	}

	public void setUnloadingDuration(Integer unloadingDuration) {
		this.unloadingDuration = unloadingDuration;
	}

	public Double getLoadWeight() {
		return loadWeight;
	}

	public void setLoadWeight(Double loadWeight) {
		this.loadWeight = loadWeight;
	}

	public Double getLoadVolume() {
		return loadVolume;
	}

	public void setLoadVolume(Double loadVolume) {
		this.loadVolume = loadVolume;
	}
	
}
