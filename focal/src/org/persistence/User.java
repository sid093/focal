package org.persistence;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "T_USER")
@NamedQuery(name = "AllUsers", query = "select p from User p")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	public User() {
	}

	@Id
	@GeneratedValue
	private long id;
	@Basic
	private String name;
	@Basic
	private String password;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String param) {
		this.name = param;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String param) {
		this.password = param;
	}

}