package payroll;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
class StockController {

	private final StockRepository stockRepository;
	private final StockModelAssembler assembler;

	StockController(StockRepository stockRepository, StockModelAssembler assembler) {
		this.stockRepository = stockRepository;
		this.assembler = assembler;
	}

	@GetMapping("/stocks")
	CollectionModel<EntityModel<Stock>> all() {
		List<EntityModel<Stock>> stocks = stockRepository.findAll().stream()
				.map(assembler::toModel)
				.collect(Collectors.toList());

		return CollectionModel.of(stocks, 
				linkTo(methodOn(StockController.class).all()).withSelfRel());
	}

	@GetMapping("/stocks/{id}")
	EntityModel<Stock> one(@PathVariable Long id) {
		Stock stock = stockRepository.findById(id)
				.orElseThrow(() -> new StockNotFoundException(id));

		return assembler.toModel(stock);
	}
}
