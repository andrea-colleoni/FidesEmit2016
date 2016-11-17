package it.emit.java.sakila;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Film {

	@Column(name="film_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	int id;
	
	String title;
	String description;
	
	@Column(name="release_year")
	int releaseYear;
	
	@ManyToOne
	@JoinColumn(name="language_id")
	Language language;
	
	@ManyToOne
	@JoinColumn(name="original_language_id")
	Language originalLanguage;
	
	@Column(name="rental_duration")
	int rentalDuration;
	
	@Column(name="rental_rate")
	float rentalRate;
	
	int length;
	
	@Column(name="replacement_cost")
	float replacementCost;
	
	String rating;
	
	@Column(name="special_features")
	String specialFeatures;
	
	@Column(name="last_update")
	@Temporal(TemporalType.TIMESTAMP)
	Date lastUpdate;
	
	@ManyToMany
	@JoinTable(name="film_actor",
				joinColumns=@JoinColumn(name="film_id"),
				inverseJoinColumns=@JoinColumn(name="actor_id"))
	List<Actor> cast;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	public Language getOriginalLanguage() {
		return originalLanguage;
	}

	public void setOriginalLanguage(Language originalLanguage) {
		this.originalLanguage = originalLanguage;
	}

	public int getRentalDuration() {
		return rentalDuration;
	}

	public void setRentalDuration(int rentalDuration) {
		this.rentalDuration = rentalDuration;
	}

	public float getRentalRate() {
		return rentalRate;
	}

	public void setRentalRate(float rentalRate) {
		this.rentalRate = rentalRate;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public float getReplacementCost() {
		return replacementCost;
	}

	public void setReplacementCost(float replacementCost) {
		this.replacementCost = replacementCost;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getSpecialFeatures() {
		return specialFeatures;
	}

	public void setSpecialFeatures(String specialFeatures) {
		this.specialFeatures = specialFeatures;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public List<Actor> getCast() {
		return cast;
	}

	public void setCast(List<Actor> cast) {
		this.cast = cast;
	}
	
}
