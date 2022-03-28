package com.samp.airways.models;

import java.sql.Date;
import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "user_details")
public class UserDetail {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   
   @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, optional = false)
   private User userid;

   @OneToMany(targetEntity = Booking.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
   private List<Booking> bookings;

   private String first_name;
   private String last_name;
   private String profile_pic;
   private Date dob;
   private String country_code;
   private String phone_number;

   public UserDetail() {
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public User getUserId() {
      return userid;
   }

   public void setUserId(User user_id) {
      this.userid = user_id;
   }

   public String getFirst_name() {
      return first_name;
   }

   public void setFirst_name(String first_name) {
      this.first_name = first_name;
   }

   public String getLast_name() {
      return last_name;
   }

   public void setLast_name(String last_name) {
      this.last_name = last_name;
   }

   public String getProfile_pic() {
      return profile_pic;
   }

   public void setProfile_pic(String profile_pic) {
      this.profile_pic = profile_pic;
   }

   public Date getDob() {
      return dob;
   }

   public void setDob(Date dob) {
      this.dob = dob;
   }

   public String getCountry_code() {
      return country_code;
   }

   public void setCountry_code(String country_code) {
      this.country_code = country_code;
   }

   public String getPhone_number() {
      return phone_number;
   }

   public void setPhone_number(String phone_number) {
      this.phone_number = phone_number;
   }

}
