package com.xproject.master.app.dataprovider.repositories.persistent;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "TB_CLIENT")
public class ClientPO implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Basic
    @Column
    private String name;

    @Basic
    @Column
    private String phone;
}
