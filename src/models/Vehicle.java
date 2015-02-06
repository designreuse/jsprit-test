package models;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class Vehicle {
	
	private String description;
	
	private String license;
	
	private Double startingAddressLatitude;
	
	private Double startingAddressLongitude;
	
	private Double finalAddressLatitude;
	
	private Double finalAddressLongitude;
	
	private Double constraintLoadWeightCapacity;
	
	private Double constraintLoadVolumeCapacity;
	
	private LocalTime constraintStartingTime;
	
	private LocalTime constraintArrivalTime;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLicense() {
		return license;
	}

	public void setLicense(String license) {
		this.license = license;
	}

	public Double getStartingAddressLatitude() {
		return startingAddressLatitude;
	}

	public void setStartingAddressLatitude(Double startingAddressLatitude) {
		this.startingAddressLatitude = startingAddressLatitude;
	}

	public Double getStartingAddressLongitude() {
		return startingAddressLongitude;
	}

	public void setStartingAddressLongitude(Double startingAddressLongitude) {
		this.startingAddressLongitude = startingAddressLongitude;
	}

	public Double getFinalAddressLatitude() {
		return finalAddressLatitude;
	}

	public void setFinalAddressLatitude(Double finalAddressLatitude) {
		this.finalAddressLatitude = finalAddressLatitude;
	}

	public Double getFinalAddressLongitude() {
		return finalAddressLongitude;
	}

	public void setFinalAddressLongitude(Double finalAddressLongitude) {
		this.finalAddressLongitude = finalAddressLongitude;
	}

	public Double getConstraintLoadWeightCapacity() {
		return constraintLoadWeightCapacity;
	}

	public void setConstraintLoadWeightCapacity(Double constraintLoadWeightCapacity) {
		this.constraintLoadWeightCapacity = constraintLoadWeightCapacity;
	}

	public Double getConstraintLoadVolumeCapacity() {
		return constraintLoadVolumeCapacity;
	}

	public void setConstraintLoadVolumeCapacity(Double constraintLoadVolumeCapacity) {
		this.constraintLoadVolumeCapacity = constraintLoadVolumeCapacity;
	}

	public LocalTime getConstraintStartingTime() {
		return constraintStartingTime;
	}

	public void setConstraintStartingTime(LocalTime constraintStartingTime) {
		this.constraintStartingTime = constraintStartingTime;
	}

	public LocalTime getConstraintArrivalTime() {
		return constraintArrivalTime;
	}

	public void setConstraintArrivalTime(LocalTime constraintArrivalTime) {
		this.constraintArrivalTime = constraintArrivalTime;
	}
}
