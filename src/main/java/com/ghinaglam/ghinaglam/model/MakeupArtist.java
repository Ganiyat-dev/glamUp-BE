package com.ghinaglam.ghinaglam.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.util.*;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class MakeupArtist extends BaseEntity{
   private String license;
   private int yearsOfExperience;
   private double salary;

   @OneToOne
   private User user;
}
