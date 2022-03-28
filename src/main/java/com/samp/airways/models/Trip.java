package com.samp.airways.models;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "trips")
public class Trip {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   
   @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
   private Location source;

   @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
   private Location destination;

   private Date departure;
   private Date arrival;

   @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
   private Flight flight;

   public Trip() {
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public Location getSource() {
      return source;
   }

   public void setSource(Location source) {
      this.source = source;
   }

   public Location getDestination() {
      return destination;
   }

   public void setDestination(Location destination) {
      this.destination = destination;
   }

   public Date getDeparture() {
      return departure;
   }

   public void setDeparture(Date departure) {
      this.departure = departure;
   }

   public Date getArrival() {
      return arrival;
   }

   public void setArrival(Date arrival) {
      this.arrival = arrival;
   }

   public Flight getFlight() {
      return flight;
   }

   public void setFlight(Flight flight) {
      this.flight = flight;
   }

}
