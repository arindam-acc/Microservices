package com.rating.service.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ratings")
public class Rating {
	@Id
	@Column(name = "rating_id")
	private String ratingId;
	@Column(name = "hotel_id")
	private String hotelId;
	@Column(name = "user_id")
	private String userId;
	@Column(name = "rating")
	private int rating;
	@Column(name = "feedback")
	private String feedback;

}
