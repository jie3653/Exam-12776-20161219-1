package pojo;

import java.io.Serializable;
import java.sql.Timestamp;

public class Film  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer film_id;
	private String title;
	private String description;
	private String release_year;
	private Integer language_id;
	private Integer original_language_id;
	private Integer rental_duration;
	private double rental_rate;
	private long length;
	private double replacement_cost;
	private String rating;
	private String special_features;
	private java.sql.Timestamp  last_update;
	
	

	public Film() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Film(Integer film_id, String title, String description, String release_year, Integer language_id,
			Integer original_language_id, Integer rental_duration, double rental_rate, long length,
			double replacement_cost, String rating, String special_features, Timestamp last_update) {
		super();
		this.film_id = film_id;
		this.title = title;
		this.description = description;
		this.release_year = release_year;
		this.language_id = language_id;
		this.original_language_id = original_language_id;
		this.rental_duration = rental_duration;
		this.rental_rate = rental_rate;
		this.length = length;
		this.replacement_cost = replacement_cost;
		this.rating = rating;
		this.special_features = special_features;
		this.last_update = last_update;
	}

	
	public Integer getFilm_id() {
		return film_id;
	}


	public void setFilm_id(Integer film_id) {
		this.film_id = film_id;
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


	public String getRelease_year() {
		return release_year;
	}


	public void setRelease_year(String release_year) {
		this.release_year = release_year;
	}


	public Integer getLanguage_id() {
		return language_id;
	}


	public void setLanguage_id(Integer language_id) {
		this.language_id = language_id;
	}


	public Integer getOriginal_language_id() {
		return original_language_id;
	}


	public void setOriginal_language_id(Integer original_language_id) {
		this.original_language_id = original_language_id;
	}


	public Integer getRental_duration() {
		return rental_duration;
	}


	public void setRental_duration(Integer rental_duration) {
		this.rental_duration = rental_duration;
	}


	public double getRental_rate() {
		return rental_rate;
	}


	public void setRental_rate(double rental_rate) {
		this.rental_rate = rental_rate;
	}


	public long getLength() {
		return length;
	}


	public void setLength(long length) {
		this.length = length;
	}


	public double getReplacement_cost() {
		return replacement_cost;
	}


	public void setReplacement_cost(double replacement_cost) {
		this.replacement_cost = replacement_cost;
	}


	public String getRating() {
		return rating;
	}


	public void setRating(String rating) {
		this.rating = rating;
	}


	public String getSpecial_features() {
		return special_features;
	}


	public void setSpecial_features(String special_features) {
		this.special_features = special_features;
	}


	public java.sql.Timestamp getLast_update() {
		return last_update;
	}


	public void setLast_update(java.sql.Timestamp last_update) {
		this.last_update = last_update;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public boolean equals(Object arg0) {
		// TODO Auto-generated method stub
		return super.equals(arg0);
	}
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	
	
}
