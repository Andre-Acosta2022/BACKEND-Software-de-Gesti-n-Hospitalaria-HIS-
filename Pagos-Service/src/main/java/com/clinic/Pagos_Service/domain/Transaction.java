package com.clinic.Pagos_Service.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "tbl_transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column (name="id")
    private Long id;

    @Column (name = "numero_transaccion")
    private String numeroDeTransaccion;

    @Column (name = "codigo_transaccion")
    private String codigoDeTransaccion;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "payment_id", nullable = false)
    private Payment payment;
}