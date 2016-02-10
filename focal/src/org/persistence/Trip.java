package org.persistence;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "T_TRIP")
@NamedQuery(name = "AllTrips", query = "select p from Trip p")
public class Trip {
	
	@Id
	@GeneratedValue
	@Column(name = "tripId")
	private long tripID;
	
	@Basic
	@OneToOne
	@JoinColumn(name = "routeId")
	private Route route;
	
	@Basic
	@OneToOne
	@JoinColumn(name = "busId")
	private Bus bus;
	
	@Basic
	private Date startTime;
	
	public long getTripID() {
		return tripID;
	}
	public void setTripID(long tripID) {
		this.tripID = tripID;
	}
	public Route getRoute() {
		return route;
	}
	public void setRouteId(Route route) {
		this.route = route;
	}
	public Bus getBus() {
		return bus;
	}
	public void setBusId(Bus bus) {
		this.bus = bus;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

}
