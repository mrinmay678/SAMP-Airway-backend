package com.samp.airways.models;

import javax.persistence.*;

@Entity
@Table(name = "flights")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String flight_name;
    private Long fare;
    private Integer current_capacity;
    private Integer max_capacity;

    public Flight() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFlight_name() {
        return flight_name;
    }

    public void setFlight_name(String flight_name) {
        this.flight_name = flight_name;
    }

    public Long getFare() {
        return fare;
    }

    public void setFare(Long fare) {
        this.fare = fare;
    }

    public Integer getCurrent_capacity() {
        return current_capacity;
    }
    public Integer getMax_capacity() {
        return max_capacity;
    }

    public void setCurrent_capacity(Integer capacity) {
        this.current_capacity = capacity;
    }
    public void setMax_capacity(Integer capacity) {
        this.max_capacity = capacity;
    }

}
