package br.edu.ufop.web.ticket.sales.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.edu.ufop.web.ticket.sales.converter.EventConverter;
import br.edu.ufop.web.ticket.sales.converter.SalesConverter;
import br.edu.ufop.web.ticket.sales.domain.EventDomain;
import br.edu.ufop.web.ticket.sales.domain.SaleDomain;
import br.edu.ufop.web.ticket.sales.domain.usecases.sales.CreateSaleUseCase;
import br.edu.ufop.web.ticket.sales.dtos.sales.CreateSaleDTO;
import br.edu.ufop.web.ticket.sales.dtos.sales.SaleDTO;
import br.edu.ufop.web.ticket.sales.model.EventModel;
import br.edu.ufop.web.ticket.sales.model.SaleModel;
import br.edu.ufop.web.ticket.sales.repositories.IEventRepository;
import br.edu.ufop.web.ticket.sales.repositories.ISalesRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SaleService {
    
    private ISalesRepository salesRepository;
    private IEventRepository eventRepository;

    public List<SaleDTO> getAll() {
        return salesRepository.findAll()
                .stream().map(SalesConverter::toSaleDTO)
                .toList();
    }

    public SaleDTO create(CreateSaleDTO createSaleDTO) {

        Optional<EventModel> opt = eventRepository.findById(createSaleDTO.getEventId());

        if (opt.isEmpty()) {
            return null;
        }

        SaleDomain saleDomain = SalesConverter.toSaleDomain(createSaleDTO);
        
        CreateSaleUseCase createEventUseCase = new CreateSaleUseCase(saleDomain);
        createEventUseCase.validate();

        SaleModel saleModel = SalesConverter.toSaleModel(saleDomain);
        saleModel.setEventModel(opt.get());

        return SalesConverter.toSaleDTO(salesRepository.save(saleModel));

    }

}
