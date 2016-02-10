package org.persistence;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "T_REACHTIMEMORNING")
@NamedQuery(name = "AllReachTimeMornings", query = "select p from ReachTimeMorning p")
public class ReachTimeMorning {
	
	@Id
	@GeneratedValue
	private long ReachTimeMorningId;
	
	@Basic
	@ManyToOne
	@JoinColumn(name = "tripId")
	private Trip trip;
	
	@Basic
	@ManyToOne
	@JoinColumn(name = "stopId")
	private Stop stop;
	
	@Basic
	private Date timestamp;
	
	public long getReachTimeMorningId() {
		return ReachTimeMorningId;
	}
	public void setReachTimeMorningId(long reachTimeMorningId) {
		ReachTimeMorningId = reachTimeMorningId;
	}
	public Trip getTripId() {
		return trip;
	}
	public void setTripId(Trip trip) {
		this.trip = trip;
	}
	public Stop getStop() {
		return stop;
	}
	public void setStop(Stop stop) {
		this.stop = stop;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	
}
