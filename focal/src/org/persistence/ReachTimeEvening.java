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
@Table(name = "T_REACHTIMEEVENING")
@NamedQuery(name = "AllReachTimeEvenings", query = "select p from ReachTimeEvening p")
public class ReachTimeEvening {
	
	@Id
	@GeneratedValue
	private long ReachTimeEveningId;
	
	@Basic
	@ManyToOne
	@JoinColumn(name = "tridId")
	private Trip trip;
	
	@Basic
	@ManyToOne
	@JoinColumn(name = "stopId")
	private Stop stop;
	
	@Basic
	private Date timestamp;

	public long getReachTimeEveningId() {
		return ReachTimeEveningId;
	}

	public void setReachTimeEveningId(long reachTimeEveningId) {
		ReachTimeEveningId = reachTimeEveningId;
	}

	public Trip getTrip() {
		return trip;
	}

	public void setTrip(Trip trip) {
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
