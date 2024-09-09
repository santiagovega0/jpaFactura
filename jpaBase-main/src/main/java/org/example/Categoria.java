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

public class Categoria implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String denominacion;

    @ManyToMany(mappedBy = "categorias")
    private List<Articulo> articulos = new ArrayList<>();
}
