package com.hotel_review.service;

import java.util.List;

import com.hotel_review.entity.HotelReview;

public interface HotelReviewServiceI {

	List<HotelReview> getAllHotelInfos();

	HotelReview getHotelReviewsById(int id);

	HotelReview addHotelReview(HotelReview hotelReview);

	HotelReview modifyBookReview(int id, HotelReview hotelReview);

	void deleteHotelReview(int id);

	List<HotelReview> getAllHotelReviewsByInfoId(int infoId);

}
