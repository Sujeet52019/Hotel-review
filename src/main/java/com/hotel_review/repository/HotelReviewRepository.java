package com.hotel_review.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotel_review.entity.HotelReview;

@Repository
public interface HotelReviewRepository extends JpaRepository<HotelReview, Integer>{

	List<HotelReview> findAllByInfoId(int infoId);


}
