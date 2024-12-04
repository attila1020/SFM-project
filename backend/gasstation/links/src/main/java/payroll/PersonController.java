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
class PersonController {

	private final PersonRepository personRepository;
	private final ModelAssemblers assembler;

	PersonController(PersonRepository personRepository, ModelAssemblers assembler) {
		this.personRepository = personRepository;
		this.assembler = assembler;
	}

	@GetMapping("/persons")
	CollectionModel<EntityModel<Person>> all() {
		List<EntityModel<Person>> persons = personRepository.findAll().stream()
				.map(assembler::toModel)
				.collect(Collectors.toList());

		return CollectionModel.of(persons, 
				linkTo(methodOn(PersonController.class).all()).withSelfRel());
	}

	@GetMapping("/persons/{id}")
	EntityModel<Person> one(@PathVariable Long id) {
		Person person = personRepository.findById(id)
				.orElseThrow(() -> new NotFoundException(id));

		return assembler.toModel(person);
	}
}
