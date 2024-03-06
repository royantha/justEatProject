package com.example.demo.controller;

import com.example.demo.model.Restaurant;
import com.example.demo.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.stream.Collectors;


import java.util.List;

/**
 * Controller class responsible for handling HTTP requests.
 */
@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

        private final RestaurantService restaurantService;

        /**
         * Constructor to inject RestaurantService dependency.
         *
         * @param restaurantService RestaurantService instance
         */
        @Autowired
        public RestaurantController(RestaurantService restaurantService) {
                this.restaurantService = restaurantService;
        }


        /**
         * Retrieves a list of restaurants based on the given postcode.
         *
         * @param postcode The postcode to search for restaurants
         * @return ResponseEntity containing a list of Restaurant objects
         */
        @GetMapping("/{postcode}")
        public ResponseEntity<List<Restaurant>> getRestaurantsByPostcode(@PathVariable String postcode) {
                List<Restaurant> restaurants = restaurantService.getRestaurantsByPostcode(postcode);
                // Truncate the list to 10 items before returning
                return ResponseEntity.ok(restaurants.stream().limit(10).collect(Collectors.toList()));
        }
}

//https://uk.api.just-eat.io/discovery/uk/restaurants/enriched/bypostcode/IG26AD