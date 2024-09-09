package org.example;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Domicilio implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombreCalle;

    private int numero;

    @OneToOne(mappedBy = "domicilio")
    private Cliente cliente;
}
