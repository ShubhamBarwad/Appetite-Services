package com.rm.restaurantmanagement.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rm.restaurantmanagement.model.Dish;
import com.rm.restaurantmanagement.repository.DishEntityRepository;
import com.rm.restaurantmanagement.services.DishServices;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/v1/dish")
public class DishController {
	
	@Autowired
	DishEntityRepository dishEntityRepository;
	
	@Autowired
	DishServices dishServices;
	
	public DishController(DishServices dishServices) {
		this.dishServices = dishServices;
	}
	
	@PostMapping
	public Dish addDish(@RequestParam Map<String, String> param) {
		System.out.println("Add Dish Endpoint hit");
		String name = param.get("name");
		String description = param.get("description");
		String price = param.get("price");
		String cuisine = param.get("cuisine");
		String photo = param.get("photo");
		String rating = String.valueOf(Math.round(Math.random())*3+ 2);
		String time = param.get("time");
		Dish dish = new Dish();
		dish = Dish.builder()
				.name(name)
				.description(description)
				.photo(photo)
				.price(price)
				.cuisine(cuisine)
				.rating(rating)
				.time(time)
				.build();
		dish = dishServices.createDish(dish);
		System.out.println(dish);
		
		return dish;
	}
}
