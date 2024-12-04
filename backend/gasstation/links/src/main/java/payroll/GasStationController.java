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
class GasStationController {

	private final GasStationRepository gasStationRepository;
	private final GasStationModelAssembler assembler;

	GasStationController(GasStationRepository gasStationRepository, GasStationModelAssembler assembler) {
		this.gasStationRepository = gasStationRepository;
		this.assembler = assembler;
	}

	@GetMapping("/gasStations")
	CollectionModel<EntityModel<GasStation>> all() {
		List<EntityModel<GasStation>> gasStations = gasStationRepository.findAll().stream()
				.map(assembler::toModel)
				.collect(Collectors.toList());

		return CollectionModel.of(gasStations, 
				linkTo(methodOn(GasStationController.class).all()).withSelfRel());
	}

	@GetMapping("/gasStations/{id}")
	EntityModel<GasStation> one(@PathVariable Long id) {
		GasStation gasStation = gasStationRepository.findById(id)
				.orElseThrow(() -> new GasStationNotFoundException(id));

		return assembler.toModel(gasStation);
	}
}
