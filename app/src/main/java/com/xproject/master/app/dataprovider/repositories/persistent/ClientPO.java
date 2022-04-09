package com.xproject.master.app.dataprovider.repositories.persistent;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name = "TB_CLIENT")
public class ClientPO implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String phone;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ClientPO clientPO = (ClientPO) o;
        return id != null && Objects.equals(id, clientPO.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
