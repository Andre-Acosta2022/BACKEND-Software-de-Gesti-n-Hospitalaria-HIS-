package com.clinic.Pagos_Service.DTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CitaRequest {
    private Long montoServicio;  // El monto asociado a un servicio o tratamiento médico
    private Long cantidad;       // La cantidad de servicios o consultas
    private String nombreServicio;  // El nombre del servicio o tratamiento
    private String moneda;       // La moneda en la que se realiza el pago (ej. "S/", "USD")
}
