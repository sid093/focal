package org.persistence;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Embeddable
@Entity
@Table(name = "T_STOP")
@NamedQuery(name = "AllStops", query = "select p from Stop p")
public class Stop {
	
	@Id
	@GeneratedValue
	@Column(name = "stopId")
	private long id;
	@Basic
	private String name;
	@Basic
	private Float longitude;
	@Basic
	private Float latitude;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Float getLongitude() {
		return longitude;
	}
	public void setLongitude(Float longitude) {
		this.longitude = longitude;
	}
	public Float getLatitude() {
		return latitude;
	}
	public void setLatitude(Float latitude) {
		this.latitude = latitude;
	}

}
