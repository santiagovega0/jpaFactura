package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("example-unit");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            //
            entityManager.getTransaction().begin();

            Categoria perecedero = Categoria.builder()
                    .denominacion("Perecederos")
                    .build();

            Categoria lacteo = Categoria.builder()
                    .denominacion("Lacteos")
                    .build();

            Categoria limpieza = Categoria.builder()
                    .denominacion("Limpieza")
                    .build();

            Articulo yogurChocolate = Articulo.builder()
                    .cantidad(3)
                    .denominacion("Yogur Chocolate")
                    .precio(2000)
                    .build();

            Articulo yogurFrutilla = Articulo.builder()
                    .cantidad(3)
                    .denominacion("Yogur Frutilla")
                    .precio(1800)
                    .build();

            Articulo yogurVainilla = Articulo.builder()
                    .cantidad(3)
                    .denominacion("Yogur Vainilla")
                    .precio(1900)
                    .build();

            Articulo detergente = Articulo.builder()
                    .cantidad(4)
                    .denominacion("detergente")
                    .precio(500)
                    .build();

            Cliente cliente = Cliente.builder()
                    .nombre("Santiago")
                    .apellido("Vega")
                    .dni(45257691)
                    .build();

            Domicilio domicilio = Domicilio.builder()
                    .nombreCalle("Carril Gomez")
                    .numero(3039)
                    .build();

            DetalleFactura det1 = DetalleFactura.builder()
                    .build();

            DetalleFactura det2 = DetalleFactura.builder()
                    .build();

            DetalleFactura det3 = DetalleFactura.builder()
                    .build();

            DetalleFactura det4 = DetalleFactura.builder()
                    .build();

            cliente.setDomicilio(domicilio);

            lacteo.setArticulos(List.of(yogurChocolate,yogurFrutilla,yogurVainilla));
            perecedero.setArticulos(List.of(yogurChocolate,yogurFrutilla,yogurVainilla));
            limpieza.setArticulos(List.of(detergente));

            det1.setArticulo(yogurChocolate);
            det1.setCantidad(5);
            det1.setSubtotal(yogurChocolate.getPrecio()* det1.getCantidad());

            det2.setArticulo(yogurVainilla);
            det2.setCantidad(5);
            det2.setSubtotal(yogurVainilla.getPrecio()* det2.getCantidad());

            det3.setArticulo(detergente);
            det3.setCantidad(1);
            det3.setSubtotal(detergente.getPrecio()*det3.getCantidad());

            det4.setArticulo(yogurFrutilla);
            det4.setCantidad(6);
            det4.setSubtotal(yogurFrutilla.getPrecio()*det4.getCantidad());

            Factura fac1 = Factura.builder()
                    .fecha("21/10/2024")
                    .build();

            Factura fac2 = Factura.builder()
                    .fecha("01/10/2024")
                    .build();

            fac1.setDetalleFacturas(List.of(det1,det2));
            fac1.setCliente(cliente);
            fac1.setTotal(det1.getSubtotal()+det2.getSubtotal());

            fac2.setDetalleFacturas(List.of(det3,det4));
            fac2.setCliente(cliente);
            fac2.setTotal(det3.getSubtotal()+det4.getSubtotal());

            entityManager.persist(perecedero);
            entityManager.persist(lacteo);
            entityManager.persist(limpieza);
            entityManager.persist(yogurChocolate);
            entityManager.persist(yogurVainilla);
            entityManager.persist(yogurFrutilla);
            entityManager.persist(detergente);
            entityManager.persist(fac1);
            entityManager.persist(fac2);
            entityManager.persist(cliente);
            entityManager.persist(domicilio);
            entityManager.persist(det1);
            entityManager.persist(det2);
            entityManager.persist(det3);
            entityManager.persist(det4);

            entityManager.flush();

            entityManager.getTransaction().commit();

        }catch (Exception e){

            entityManager.getTransaction().rollback();

        }

        entityManager.close();
        entityManagerFactory.close();
    }
}
