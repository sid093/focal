package org.persistence;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "T_DRIVER")
@NamedQuery(name = "AllDrivers", query = "select p from Driver p")
public class Driver implements Serializable {
	
	private static final long serialVersionUID = 1L;

	public Driver() {
		
	}

	@Id
	@GeneratedValue
	@Column(name = "driverId")
	private long id;
	@Basic
	private String name;

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

}
