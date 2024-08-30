package com.hotel_review.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel_review.entity.HotelReview;
import com.hotel_review.exception.HotelReviewException;
import com.hotel_review.service.HotelReviewServiceI;

@RestController
@RequestMapping("/v1")
public class HotelReviewController {
	
	@Autowired
	private HotelReviewServiceI hotelReviewService;
	
	@GetMapping("/hotel-review")
	public ResponseEntity<List<HotelReview>> getAllBookReviews(){
		
		return new ResponseEntity<List<HotelReview>>( hotelReviewService.getAllHotelInfos(), HttpStatus.OK);
	}
	
	@GetMapping("/hotel-review/{id}")
	public ResponseEntity<Object> getBookReviewsById(@PathVariable("id") int id){
		HotelReview bookReview = hotelReviewService.getHotelReviewsById(id);
		if(bookReview != null) {
			return new ResponseEntity<Object>( bookReview, HttpStatus.OK);
		}else {
			return new ResponseEntity<Object>( new HotelReviewException("No person available for id :"+id), HttpStatus.OK);
		}
	}
	
	@PostMapping("/hotel-review")
	public ResponseEntity<HotelReview> addBookReview(@RequestBody HotelReview hotelReview){
		
		return new ResponseEntity<HotelReview>(hotelReviewService.addHotelReview(hotelReview), HttpStatus.CREATED);
	}
	
	@PutMapping("/hotel-review/{id}")
	public ResponseEntity<HotelReview> modifyBookReview(
			@PathVariable("id") int id,
			@RequestBody HotelReview hotelReview){
		
		return new ResponseEntity<HotelReview>(hotelReviewService.modifyBookReview(id, hotelReview), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/hotel-review/{id}")
	public ResponseEntity<Void> deleteBookReview(@PathVariable("id") int id){
		hotelReviewService.deleteHotelReview(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/hotel-review/info/{info-id}")
	public ResponseEntity<List<HotelReview>> getAllBookReviewsByInfoId(@PathVariable("info-id") int infoId){
		
		return new ResponseEntity<List<HotelReview>>( hotelReviewService.getAllHotelReviewsByInfoId(infoId), HttpStatus.OK);
	}

}
