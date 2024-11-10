package org.example.listexpendeces;

import jakarta.persistence.*;

@Entity
@Table
public class Categoria {

    @Id
    @GeneratedValue
    Long id;

    @Column
    String name;

    public Categoria(String name) {
        this.name = name;
    }
}
