package com.ghinaglam.ghinaglam.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "clients")
public class Client extends BaseEntity{
    private String firstName;
    private String lastName;
    //    @Column(name = "email", unique = true)
    private String email;
    //    @Column(unique = true)
    private String phoneNumber;
    private String password;
    private int age;

//    @ManyToMany
//    @JoinTable(name= "user_category", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
//    public Set<Category> getCategory() {
//        return categories;
//    }

    @OneToMany(mappedBy = "client")
    private List<Appointment> appointments;
}
