package com.emlakkatilimSamples.PostgreSql.Entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "PERSON")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
@ToString
public class Person {
    @Id
    @SequenceGenerator(name = "seq_person", allocationSize = 1)
    @GeneratedValue(generator = "seq_person", strategy = GenerationType.SEQUENCE)
    private  Long id;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "surname")
    private  String surname;

    @OneToMany
    @JoinColumn(name = "kisi_adres_id")
    private List<Address> addresses;
}
