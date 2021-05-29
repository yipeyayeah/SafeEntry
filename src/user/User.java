package user;

import java.time.LocalDateTime;

import org.bson.types.ObjectId;


public class User {


	private ObjectId id;
	private String name, nric, location;
	private LocalDateTime checkInTime, checkOutTime;
	
	public User(String name, String nric, String location, LocalDateTime checkInTime, LocalDateTime checkOutTime) {
		this.name = name;
		this.nric = nric;
		this.location = location;
		this.checkInTime = checkInTime;
		this.checkOutTime = checkOutTime;
	}
	
	public User(String name, String nric, String location) {
		this.name = name;
		this.nric = nric;
		this.location = location;
	}
	
	public User() {

	}
	

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNric() {
		return nric;
	}
	public void setNric(String nric) {
		this.nric = nric;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public LocalDateTime getCheckInTime() {
		return checkInTime;
	}
	public void setCheckInTime(LocalDateTime checkInTime) {
		this.checkInTime = checkInTime;
	}
	public LocalDateTime getCheckOutTime() {
		return checkOutTime;
	}
	public void setCheckOutTime(LocalDateTime checkOutTime) {
		this.checkOutTime = checkOutTime;
	}	
	public ObjectId getId() {
		return id;
	}
	public void setId(ObjectId id) {
		this.id = id;
	}

}
