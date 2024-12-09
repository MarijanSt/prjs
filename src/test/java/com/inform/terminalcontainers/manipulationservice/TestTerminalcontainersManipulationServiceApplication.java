package com.inform.terminalcontainers.manipulationservice;

import org.springframework.boot.SpringApplication;

public class TestTerminalcontainersManipulationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.from(TerminalContainersManipulationServiceApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
