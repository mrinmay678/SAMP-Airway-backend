package com.samp.airways.models;

import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "locations")
@NoArgsConstructor
public class Location {

   @Id
   private String id;
   
   private String city;
   private String country;

}
