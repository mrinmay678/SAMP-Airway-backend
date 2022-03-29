package com.samp.airways.models;

import javax.persistence.*;


@Entity
@Table(name = "users")
public class User {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private String username;
   private String email;
   private String password;
   private Boolean is_admin=false;


   public User() {
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }


   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public Boolean getIs_admin() {
      return is_admin;
   }

   public void setIs_admin(Boolean is_admin) {
      this.is_admin = is_admin;
   }

   

   public void setPassword(String password) {
      this.password = password;
   }

}
