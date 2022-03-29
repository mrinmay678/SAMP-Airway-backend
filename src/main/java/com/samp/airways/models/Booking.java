package com.samp.airways.models;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "bookings")
public class Booking {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   
   @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, optional = false)
   private User userid;

   @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, optional = false)
   private List<Passenger> passengers;

   @OneToOne
   private Trip trip;

   @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
   private Flight flight;

   private Long total_fare;

   public Booking() {}

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public User getUser_id() {
      return userid;
   }

   public void setUser_id(User user_id) {
      this.userid = user_id;
   }
   public Flight getFlight() {
      return flight;
   }

   public void setFlight(Flight flight) {
      this.flight = flight;
   }

   public Long getTotal_fare() {
      return total_fare;
   }

   public void setTotal_fare(Long total_fare) {
      this.total_fare = total_fare;
   }

   public List<Passenger> getPassengers() {
      return passengers;
   }

   public void setPassengers(List<Passenger> passengers) {
      this.passengers = passengers;
   }

}
