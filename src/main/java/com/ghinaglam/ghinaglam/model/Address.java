package com.ghinaglam.ghinaglam.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Address extends BaseEntity{
    private int houseNumber;
    private String street;
    private String city;
    private String state;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "makeup_artist_id")
    private MakeupArtist makeupArtist;
}
