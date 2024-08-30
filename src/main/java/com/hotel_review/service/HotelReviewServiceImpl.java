package com.hotel_review.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel_review.entity.HotelReview;
import com.hotel_review.repository.HotelReviewRepository;

@Service
public class HotelReviewServiceImpl implements HotelReviewServiceI {
	
	@Autowired
	private HotelReviewRepository hotelReviewRepository;

	@Override
	public List<HotelReview> getAllHotelInfos() {
		return hotelReviewRepository.findAll();
	}

	@Override
	public HotelReview getHotelReviewsById(int id) {		
		return hotelReviewRepository.findById(id).orElse(null);
	}

	@Override
	public HotelReview addHotelReview(HotelReview hotelReview) {
		return hotelReviewRepository.save(hotelReview);
	}

	@Override
	public HotelReview modifyBookReview(int id, HotelReview hotelReview) {
		HotelReview oldBookReview = hotelReviewRepository.findById(id).get();
		
		oldBookReview.setInfoId(hotelReview.getInfoId());
		oldBookReview.setReviewComment(hotelReview.getReviewComment());
		oldBookReview.setReviewer(hotelReview.getReviewer());
		oldBookReview.setReviewPoint(hotelReview.getReviewPoint());
		return hotelReviewRepository.save(oldBookReview);
	}

	@Override
	public void deleteHotelReview(int id) {
		hotelReviewRepository.deleteById(id);		
	}

	@Override
	public List<HotelReview> getAllHotelReviewsByInfoId(int infoId) {
		// TODO Auto-generated method stub
		return hotelReviewRepository.findAllByInfoId(infoId);
	}

}
