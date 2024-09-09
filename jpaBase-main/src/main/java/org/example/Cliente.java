package org.example;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private int dni;

    private String nombre;

    private String apellido;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_domicilio")
    private Domicilio domicilio;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.PERSIST)
    @Builder.Default
    private List<Factura> facturas = new ArrayList<>();
}
