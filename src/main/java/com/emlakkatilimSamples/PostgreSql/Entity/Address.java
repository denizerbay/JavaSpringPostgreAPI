package com.emlakkatilimSamples.PostgreSql.Entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ADDRESS")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
@ToString
public class Address implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_address", allocationSize = 1)
    @GeneratedValue(generator = "seq_address", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(length = 500, name = "addressContent")
    private String addressContent;

    @Enumerated
    private AddressType addressType;
    private Boolean isActive;

    @ManyToOne
    @JoinColumn(name = "kisi_adres_id")
    private Person person;

    public enum AddressType{
        HOME,
        WORK,
        OTHER
    }



}
