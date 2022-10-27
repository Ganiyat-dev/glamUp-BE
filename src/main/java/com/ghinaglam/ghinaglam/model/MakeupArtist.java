package com.ghinaglam.ghinaglam.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.util.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor

public class MakeupArtist extends BaseEntity{
   private String license;
   private int yearsOfExperience;
   private double salary;

   @OneToOne
   private User user;
}
