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
class PriceController {

	private final PriceRepository priceRepository;
	private final PriceModelAssembler assembler;

	PriceController(PriceRepository priceRepository, PriceModelAssembler assembler) {
		this.priceRepository = priceRepository;
		this.assembler = assembler;
	}

	@GetMapping("/prices")
	CollectionModel<EntityModel<Price>> all() {
		List<EntityModel<Price>> prices = priceRepository.findAll().stream()
				.map(assembler::toModel)
				.collect(Collectors.toList());

		return CollectionModel.of(prices, 
				linkTo(methodOn(PriceController.class).all()).withSelfRel());
	}

	@GetMapping("/prices/{id}")
	EntityModel<Price> one(@PathVariable Long id) {
		Price price = priceRepository.findById(id)
				.orElseThrow(() -> new PriceNotFoundException(id));

		return assembler.toModel(price);
	}
}
