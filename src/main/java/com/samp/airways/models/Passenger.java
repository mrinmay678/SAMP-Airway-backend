package com.samp.airways.models;

import java.sql.Date;
import javax.persistence.*;
import java.util.*;

import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "passengers")
@NoArgsConstructor
@AllArgsConstructor
public class Passenger {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   
   private String first_name;
   private String last_name;
   private String email;
   private String phone;
   private Integer age;
   private Long booking;

   public Passenger(String first_name, String last_name, String email, String phone, Integer age, Long booking) {
      this.first_name = first_name;
      this.last_name = last_name;
      this.email = email;
      this.phone = phone;
      this.age = age;
      this.booking = booking;
   }

}
