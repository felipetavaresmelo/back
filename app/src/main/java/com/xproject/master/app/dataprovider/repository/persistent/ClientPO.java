package com.xproject.master.app.dataprovider.repository.persistent;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TB_CLIENT")
public class ClientPO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="firstname")
    private String name;

    @Column(name= "surname")
    private String surname;

    @Column(name="phone")
    private String phone;

    @Column(name="age")
    private int age;

    @Column(name="phoneType")
    private String phoneType;
}
