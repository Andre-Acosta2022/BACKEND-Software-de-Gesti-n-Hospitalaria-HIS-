package com.clinic.Pagos_Service.DTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StripeResponse {
    private Long amount;
    private Long quantity;
    private String name ;
    private String currency;
}