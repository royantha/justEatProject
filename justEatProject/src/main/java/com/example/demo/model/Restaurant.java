package com.example.demo.model;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 * The Restaurant class represents a restaurant entity.
 * It contains the restaurant name, cuisines offered, rating, and address.
 */

public class Restaurant {
        private String name;

        @JsonProperty("cuisine_types")
        private List<String> cuisineTypes;
        private double rating;
        private String address;

        /**
         * Default constructor required for Jackson deserialization.
         */
        public Restaurant() {
        }

        /**
         * Constructs a new Restaurant object with the specified attributes.
         *
         * @param name         The name of the restaurant.
         * @param cuisineTypes The types of cuisines offered by the restaurant.
         * @param rating       The rating of the restaurant.
         * @param address      The address of the restaurant.
         */
        public Restaurant(String name, List<String> cuisineTypes, double rating, String address) {
                this.name = name;
                this.cuisineTypes = cuisineTypes;
                this.rating = rating;
                this.address = address;
        }

        // Getters and setters
        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public List<String> getCuisineTypes() {
                return cuisineTypes;
        }

        public void setCuisineTypes(List<String> cuisineTypes) {
                this.cuisineTypes = cuisineTypes;
        }

        public double getRating() {
                return rating;
        }

        public void setRating(double rating) {
                this.rating = rating;
        }

        public String getAddress() {
                return address;
        }

        public void setAddress(String address) {
                this.address = address;
        }
}
