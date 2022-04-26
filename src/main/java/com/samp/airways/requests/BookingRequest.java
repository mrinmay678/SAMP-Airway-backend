package com.samp.airways.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingRequest {
    private String username;
    private Long trip;
    private Long flight;
    private Long total_fare;
    private List<HashMap<String, Object>> passengers;
}
