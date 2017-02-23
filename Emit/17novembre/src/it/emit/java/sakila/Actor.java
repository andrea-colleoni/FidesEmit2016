package it.emit.java.sakila;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Actor {

	@Column(name="actor_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	int id;
	
	@Column(name="first_name")
	String firstName;
	
	@Column(name="last_name")
	String lastName;
	
	@Column(name="last_update")
	@Temporal(TemporalType.TIMESTAMP)
	Date lastUpdate;
	
	@ManyToMany(mappedBy="cast")
	List<Film> filmInCuiRecita;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public List<Film> getFilmInCuiRecita() {
		return filmInCuiRecita;
	}

	public void setFilmInCuiRecita(List<Film> filmInCuiRecita) {
		this.filmInCuiRecita = filmInCuiRecita;
	}
}
