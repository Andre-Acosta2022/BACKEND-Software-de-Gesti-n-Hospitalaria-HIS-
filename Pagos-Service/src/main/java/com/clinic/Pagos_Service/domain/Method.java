package com.clinic.Pagos_Service.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "tbl_method")
public class Method {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column (name = "id")
    private Long id;

    @Column (name = "metodo_de_pago")
    private String metodoDePago;

    @Column(name= "fecha_de_vencimiento")
    private String fechaDeVencimiento;

    @OneToMany(mappedBy = "method", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Payment> payment;
}