package com.samp.airways.models;

import javax.persistence.*;

@Entity
@Table(name = "locations")
public class Location {

   @Id
   private String id;
   
   private String city;
   private String country_code;

   public Location() {
   }
   
   public String getId() {
      return id;
   }

   public void setId(String id) {
      this.id = id;
   }

   public String getCity() {
      return city;
   }

   public void setCountry_code(String country_code) {
      this.country_code = country_code;
   }

   public String getCountry_code() {
      return country_code;
   }

   public void setCity(String city) {
      this.city = city;
   }


}
