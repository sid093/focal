package org.persistence;

import java.io.Serializable;
import javax.persistence.*;


@Entity 
@Table(name = "T_BUS")
@NamedQuery(name = "AllBuss", query = "select p from Bus p")
public class Bus implements Serializable {

	private static final long serialVersionUID = 1L;
	public Bus() {

	}
	
	@Id 
	@GeneratedValue
	@Column(name = "busId")
	private long id;
	
	@Basic
	private long deviceId;
	
	@Basic
	@OneToOne
	@JoinColumn(name = "driverId")
	private Driver driver;


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(long deviceId) {
		this.deviceId = deviceId;
	}

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

}