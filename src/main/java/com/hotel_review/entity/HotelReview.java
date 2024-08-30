package com.hotel_review.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Hotel-review")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class HotelReview {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int reviewId;
	
	@Column(name = "info-id")
	private int infoId;
	
	@Column(name = "reviewer")
	private String reviewer;
	
	@Column(name = "reviewer-comment")
	private String reviewComment;
	
	@Column(name = "reviewer-point")
	private int reviewPoint;

}
