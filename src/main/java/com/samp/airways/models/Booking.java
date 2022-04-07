package com.samp.airways.models;

import java.util.List;

import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "bookings")
@NoArgsConstructor
public class Booking {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   
   @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, optional = false)
   private User userid;
   
   @OneToOne
   private Trip trip;

   @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
   private Flight flight;

   private Long total_fare;

   private List<Object> passengers;

}
