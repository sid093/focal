package org.persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "T_ROUTE")
@NamedQuery(name = "AllRoutes", query = "select p from Route p")
public class Route implements Serializable {

	private static final long serialVersionUID = 1L;

	public Route() {
		
	}

	@Id
	@GeneratedValue
	@Column(name = "routeId")
	private long routeId;
	
	@Basic
	private long busId;
	
	@ElementCollection
	@OneToMany
	@JoinColumn(name = "stopId")
	private List<Stop> stop;

	public long getRouteId() {
		return routeId;
	}

	public void setRouteId(long routeId) {
		this.routeId = routeId;
	}

	public long getBusId() {
		return busId;
	}

	public void setBusId(long busId) {
		this.busId = busId;
	}

	public List<Stop> getStop() {
		return stop;
	}

	public void setStop(List<Stop> stop) {
		this.stop = stop;
	}

}