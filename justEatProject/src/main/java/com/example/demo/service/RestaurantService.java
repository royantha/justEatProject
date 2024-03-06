package com.example.demo.service;

import com.example.demo.model.Restaurant;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Service class responsible for fetching restaurant data from an external API based on postcode.
 */
@Service
public class RestaurantService {

        private final RestTemplate restTemplate;

        /**
         * Constructor to inject RestTemplate dependency.
         *
         * @param restTemplate RestTemplate instance
         */
        @Autowired
        public RestaurantService(RestTemplate restTemplate) {
                this.restTemplate = restTemplate;
        }

        /**
         * Fetches a list of restaurants based on the given postcode.
         *
         * @param postcode The postcode to search for restaurants
         * @return A list of Restaurant objects
         */
        public List<Restaurant> getRestaurantsByPostcode(String postcode) {
                String url = "https://uk.api.just-eat.io/discovery/uk/restaurants/enriched/bypostcode/" + postcode;


                try {
                        // Fetch the response as a JsonNode
                        JsonNode response = restTemplate.getForObject(url, JsonNode.class);

                        if (response != null && response.has("restaurants")) {
                                JsonNode restaurantsNode = response.get("restaurants");

                                ObjectMapper mapper = new ObjectMapper();
                                List<Restaurant> restaurants = new ArrayList<>();

                                // Iterate over the "restaurants" JsonNode if it's an array
                                for (JsonNode restaurantNode : restaurantsNode) {
                                        // Extract the required fields, handle missing or null fields gracefully
                                        String name = restaurantNode.has("name") ? restaurantNode.get("name").asText() : "Name Not Available";
                                        List<String> cuisines = restaurantNode.has("cuisines") ?
                                                mapper.readValue(restaurantNode.get("cuisines").toString(), List.class) :
                                                new ArrayList<>();
                                        double rating = restaurantNode.has("rating") ? restaurantNode.get("rating").asDouble() : 0.0;
                                        String address = restaurantNode.has("address") ? restaurantNode.get("address").asText() : "Address Not Available";

                                        // Add the restaurant to the list
                                        restaurants.add(new Restaurant(name, cuisines, rating, address));
                                }

                                // Truncate the list to the first 10 restaurants
                                return restaurants.subList(0, Math.min(restaurants.size(), 10));
                        } else {
                                System.out.println("No restaurants found for the given postcode.");
                        }
                } catch (IOException e) {
                        // Log the exception (for real-world applications, do proper exception handling)
                        e.printStackTrace();
                }

                return new ArrayList<>();
        }
}

