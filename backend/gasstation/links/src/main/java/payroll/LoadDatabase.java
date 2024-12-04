package payroll;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
class LoadDatabase {

	private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
	@Bean
	CommandLineRunner initDatabase(
			PersonRepository personRepository, 
			GasStationRepository gasStationRepository, 
			StockRepository stockRepository,
			PriceRepository priceRepository,
			AvgRepository avgRepository) {

		return args -> {
			Random rand = new Random(500);


			List<String> firstNames = Arrays.asList("János", "Eszter", "László", "Anna", "Béla", "Katalin", "Gábor", "Péter", "Zsófia", "Miklós",
													"Lili", "Tibor", "Réka", "Márton", "Krisztina", "Dávid", "Éva", "Zoltán", "László");
			List<String> lastNames = Arrays.asList("Varga", "Kovács", "Nagy", "Tóth", "Szabó", "Horváth", "Farkas", "Molnár", "Kiss", "Papp",
												"Takács", "Rózsa", "Németh", "Gábor", "Sipos", "Fekete", "Varga", "Kocsis", "Sipos");
			List<String> gas_station_name = Arrays.asList("Shell", "MOL", "OMV", "Lukoil","BP");
			for (int i = 0; i < 20; i++) {
				String firstName = firstNames.get(rand.nextInt(firstNames.size()));
				String lastName = lastNames.get(rand.nextInt(lastNames.size()));
				String name = firstName + " " + lastName;
				String email = firstName.toLowerCase() + "." + lastName.toLowerCase() + (100 + rand.nextInt(999)) + "@gmail.com";
				String phoneNumber = "+36" + (rand.nextInt(3) == 0 ? "20" : (rand.nextInt(2) == 0 ? "30" : "70")) + rand.nextInt(10000000);
				int level = rand.nextInt(5);
				int points = 0;
				if (level == 0) {
					points = rand.nextInt(100);	
				}
				if (level == 1) {
					points = 100 + rand.nextInt(151);
				}
				if (level == 2) {
					points = 250 + rand.nextInt(251);
				}
				if (level == 3) {
					points = 500 + rand.nextInt(501);
				}
				if (level == 4) {
					points = 1000 + rand.nextInt(1001);
				}
				boolean isStaff = rand.nextBoolean();
				Person person = new Person(name, email, phoneNumber, level, points, isStaff);
				int id_number = 1 + rand.nextInt(6);
				person.setGasStationID(id_number);
				personRepository.save(person);
			}

			log.info("Preloaded People:");
			personRepository.findAll().forEach(person -> log.info(person.toString()));

		
			gasStationRepository.findAll().forEach(gasStation -> log.info("Preloaded GasStation: " + gasStation));

			for (int month = 1; month <= 6; month++) {
				String date = String.format("2024.%02d.01", month);
				float gasolinePrice = 550 + (rand.nextFloat() * 50);
				float dieselPrice = 500 + (rand.nextFloat() * 40);
				float windowCleanerPrice = 800 + (rand.nextFloat() * 200);
				float engineOilPrice = 4000 + (rand.nextFloat() * 1000);
				float coolantPrice = 3000 + (rand.nextFloat() * 500);
				float antiFreezePrice = 2500 + (rand.nextFloat() * 500);

				Price price = new Price(
						gasolinePrice,
						dieselPrice,
						windowCleanerPrice,
						engineOilPrice,
						coolantPrice,
						antiFreezePrice
				);
				price.setCreatedAt(date);
				Price savedPrice = priceRepository.save(price);  

				log.info("Preloaded Price for {}: {}", date, savedPrice);

				if (savedPrice != null && savedPrice.getPriceID() != null) {
					Stock stock = new Stock(
							savedPrice.getPriceID(),  
							rand.nextInt(1000),       
							rand.nextInt(1000),
							rand.nextInt(500),
							rand.nextInt(300),
							rand.nextInt(200),
							rand.nextInt(150)
					);
					stock.setCreatedAt(date);
					stockRepository.save(stock);
					String station_name =  gas_station_name.get(rand.nextInt(gas_station_name.size()));
					GasStation gasStation = new GasStation(station_name);
					gasStation.setStockID(month);
					gasStationRepository.save(gasStation);
					log.info("Preloaded Stock for PriceID {}: {}", savedPrice.getPriceID(), stock);
				} else {
					log.error("Failed to save Price or retrieve PriceID for date: {}", date);
				}
				
			}
			for (int month = 1; month <= 6; month++) {
				String date = String.format("2024.%02d.01", month);
				int gasolineSales = 100 + rand.nextInt(500);
				int dieselSales = 100 + rand.nextInt(500);
				int windowCleanerSales = 50 + rand.nextInt(30);
				int engineOilSales = 35 + rand.nextInt(25);
				int coolantSales = 45 + rand.nextInt(75);
				int antiFreezeSales = 25 + rand.nextInt(100);

				Avg avg = new Avg(
						gasolineSales,
						dieselSales,
						windowCleanerSales,
						engineOilSales,
						coolantSales,
						antiFreezeSales
				);
				avg.setCreatedAt(date);
				avgRepository.save(avg); 
			}
		};
	}
}