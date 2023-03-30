package com.rm.restaurantmanagement.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rm.restaurantmanagement.entity.DishEntity;
import com.rm.restaurantmanagement.model.Dish;
import com.rm.restaurantmanagement.repository.DishEntityRepository;

@Service
public class DishServicesImpl implements DishServices{
	
	@Autowired
	DishEntityRepository dishEntityRepository;
	
	public DishServicesImpl(DishEntityRepository dishEntityRepository) {
		this.dishEntityRepository = dishEntityRepository;
	}

	@Override
	public Dish createDish(Dish dish) {
		DishEntity dishEntity = new DishEntity();
		BeanUtils.copyProperties(dish, dishEntity);
		dishEntity = dishEntityRepository.save(dishEntity);
		dish = Dish.builder()
				.id(dishEntity.getId())
				.name(dishEntity.getName())
				.description(dishEntity.getDescription())
				.price(dishEntity.getPrice())
				.cuisine(dishEntity.getCuisine())
				.photo(dishEntity.getPhoto())
				.rating(dishEntity.getRating())
				.time(dishEntity.getTime())
				.build();
		
		return dish;
	}

}
