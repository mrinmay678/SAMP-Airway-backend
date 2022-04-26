package com.samp.airways.models;

import java.sql.Date;
import javax.persistence.*;
import java.util.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "user_details")
@NoArgsConstructor
public class UserDetail {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   
   @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, optional = false)
   private AppUser userid;

   @OneToMany(targetEntity = Booking.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
   private List<Booking> bookings;

   private String first_name;
   private String last_name;
   private String profile_pic;
   private Date dob;
   private String country_code;
   private String phone_number;

}
