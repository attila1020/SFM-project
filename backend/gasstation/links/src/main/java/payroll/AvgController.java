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
class AvgController {

	private final AvgRepository avgRepository;
	private final AvgModelAssembler assembler;

	AvgController(AvgRepository avgRepository, AvgModelAssembler assembler) {
		this.avgRepository = avgRepository;
		this.assembler = assembler;
	}

	@GetMapping("/averages")
	CollectionModel<EntityModel<Avg>> all() {
		List<EntityModel<Avg>> averages = avgRepository.findAll().stream()
				.map(assembler::toModel)
				.collect(Collectors.toList());

		return CollectionModel.of(averages, 
				linkTo(methodOn(AvgController.class).all()).withSelfRel());
	}

	@GetMapping("/averages/{id}")
	EntityModel<Avg> one(@PathVariable Long id) {
		Avg avg = avgRepository.findById(id)
				.orElseThrow(() -> new AvgNotFoundException(id));

		return assembler.toModel(avg);
	}
}
