package com.inform.terminalcontainers.manipulationservice.outbound.db.configuration;

import com.inform.terminalcontainers.manipulationservice.outbound.db.repository.MongoContainerRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackageClasses = MongoContainerRepository.class)
public class MongoConfiguration {
}
