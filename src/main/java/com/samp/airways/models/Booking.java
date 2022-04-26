package com.samp.airways.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "bookings")
@AllArgsConstructor
@NoArgsConstructor
public class Booking {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   
   @Column(name = "userid")
   private Long user_id;
   
   @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, optional = false)
   private AppUser userid;
   
   @Column(name = "trip")
   private Long trip_id;

   @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
   private Trip trip;

   @Column(name = "flight")
   private Long flight_id;

   @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
   private Flight flight;

   private Long total_fare;

   public Booking(AppUser userid, Trip trip, Flight flight, Long total_fare) {
      super();
      this.userid = userid;
      this.user_id = userid.getId();
      this.trip = trip;
      this.trip_id = trip.getId();
      this.flight = flight;
      this.flight_id = flight.getId();
      this.total_fare = total_fare;
   }

}
