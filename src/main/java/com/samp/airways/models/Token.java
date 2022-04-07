package com.samp.airways.models;

import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tokens")
@NoArgsConstructor
public class Token {

    @Id
    private String id;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, optional = false)
    private User userid;
    
    private String access_token;
    private String refresh_token;
}
