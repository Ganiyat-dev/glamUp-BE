package com.ghinaglam.ghinaglam.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.*;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "makeup_artists")
public class MakeupArtist extends BaseEntity {
    private String firstName;
    private String lastName;
    private String email;
    //    @Column(unique = true)
    private String phoneNumber;
    private String password;
    private String gender;
    private String license;
    private int yearsOfExperience;
    private double salary;
    private Category category = Category.MAKEUP_ARTIST;

    private Boolean isApproved = false;
//    @ManyToMany
//    @JoinTable(name= "user_category", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
//    public Set<Category> getCategory() {
//        return categories;
//    }

    @OneToMany(mappedBy = "makeupArtist")
    private List<AppointmentAssigned> appointmentAssigned;

}
