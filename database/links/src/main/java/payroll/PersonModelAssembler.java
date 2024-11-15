package payroll;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

@Component
class PersonModelAssembler implements RepresentationModelAssembler<Person, EntityModel<Person>> {

	@Override
	public EntityModel<Person> toModel(Person person) {

		return EntityModel.of(person, 
				linkTo(methodOn(PersonController.class).one(person.getId())).withSelfRel(),
				linkTo(methodOn(PersonController.class).all()).withRel("persons"));
	}
}

@Component
class GasStationModelAssembler implements RepresentationModelAssembler<GasStation, EntityModel<GasStation>> {

	@Override
	public EntityModel<GasStation> toModel(GasStation gasStation) {
		return EntityModel.of(gasStation,
				linkTo(methodOn(GasStationController.class).one(gasStation.getId())).withSelfRel(),
				linkTo(methodOn(GasStationController.class).all()).withRel("gasStations"));
	}
}

@Component
class PriceModelAssembler implements RepresentationModelAssembler<Price, EntityModel<Price>> {

	@Override
	public EntityModel<Price> toModel(Price price) {
		return EntityModel.of(price,
				linkTo(methodOn(PriceController.class).one(price.getPriceID())).withSelfRel(),
				linkTo(methodOn(PriceController.class).all()).withRel("prices"));
	}
}

@Component
class StockModelAssembler implements RepresentationModelAssembler<Stock, EntityModel<Stock>> {

	@Override
	public EntityModel<Stock> toModel(Stock stock) {
		return EntityModel.of(stock,
				linkTo(methodOn(StockController.class).one(stock.getStockID())).withSelfRel(),
				linkTo(methodOn(StockController.class).all()).withRel("stocks"));
	}
}
