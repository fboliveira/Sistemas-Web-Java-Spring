package br.edu.ufop.web.ticket.sales.domain.usecases.sales;

import java.time.LocalDateTime;

import br.edu.ufop.web.ticket.sales.domain.SaleDomain;
import br.edu.ufop.web.ticket.sales.enums.EnumSaleStatusType;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@AllArgsConstructor
public class CreateSaleUseCase {
    
    private SaleDomain saleDomain;

        public void validate() {
            validateSaleDate();
            validateStatus();
        }

        public void validateSaleDate() {

            if (saleDomain.getSaleDate() == null) {
                saleDomain.setSaleDate(LocalDateTime.now());
            }

        }

        public void validateStatus() {
            if (saleDomain.getSaleStatus() == null) {
                saleDomain.setSaleStatus(EnumSaleStatusType.EM_ABERTO);
            }
        }

}
