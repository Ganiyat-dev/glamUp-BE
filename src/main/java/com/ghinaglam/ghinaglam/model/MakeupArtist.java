package com.ghinaglam.ghinaglam.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor

public class MakeupArtist extends BaseEntity{
   private String firstName;
   private String lastName;
   private String email;
   private String password;
}
