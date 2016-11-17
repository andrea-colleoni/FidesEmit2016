package it.emit.java.sakila;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Language {

	@Column(name="language_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	int id;	
	
	String name;
	
	@Column(name="last_update")
	@Temporal(TemporalType.TIMESTAMP)
	Date lastUpdate;
	
	@OneToMany(mappedBy="language")
	List<Film> filmInLanguage;
	
	@OneToMany(mappedBy="originalLanguage")
	List<Film> filmInOriginalLanguage;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public List<Film> getFilmInLanguage() {
		return filmInLanguage;
	}

	public void setFilmInLanguage(List<Film> filmInLanguage) {
		this.filmInLanguage = filmInLanguage;
	}

	public List<Film> getFilmInOriginalLanguage() {
		return filmInOriginalLanguage;
	}

	public void setFilmInOriginalLanguage(List<Film> filmInOriginalLanguage) {
		this.filmInOriginalLanguage = filmInOriginalLanguage;
	}
	
	
}
