package com.samp.airways.response;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import java.util.HashMap;
import java.util.Map;

public class Response {

    public ResponseEntity<Object> get(Map<String, Object> data, HttpStatus status_code){
        Map<String, Object> map = new HashMap<>();
        map.put("status", true);
        map.put("data", data);

        return new ResponseEntity<>(map,status_code);
    }

    public ResponseEntity<Object> error(String error, HttpStatus status_code){
        Map<String, Object> map = new HashMap<>();
        map.put("status", false);
        map.put("error", error);

        return new ResponseEntity<>(map,status_code);
    }

}
