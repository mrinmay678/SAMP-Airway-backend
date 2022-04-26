package com.samp.airways.models;

import java.util.Date;

import javax.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "trips")
@NoArgsConstructor
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


}
