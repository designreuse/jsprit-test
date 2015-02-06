package main;

import java.io.FileReader;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import jsprit.core.algorithm.VehicleRoutingAlgorithm;
import jsprit.core.algorithm.box.SchrimpfFactory;
import jsprit.core.problem.VehicleRoutingProblem;
import jsprit.core.problem.VehicleRoutingProblem.FleetSize;
import jsprit.core.problem.job.Service;
import jsprit.core.problem.solution.VehicleRoutingProblemSolution;
import jsprit.core.reporting.SolutionPrinter;
import jsprit.core.util.Solutions;
import models.Delivery;
import models.Vehicle;

import org.supercsv.cellprocessor.ParseDouble;
import org.supercsv.cellprocessor.ParseInt;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanReader;
import org.supercsv.io.ICsvBeanReader;
import org.supercsv.prefs.CsvPreference;

import converters.DeliveryConverter;
import converters.VehicleConverter;
import processors.ParseLocalTime;

public class EntryPoint {
	
	static final String VEHICLES = "input/vehicles.csv";
	static final String DELIVERIES = "input/deliveries.csv";
	
	static private List<Vehicle> getVehicles() throws Exception {
		final CellProcessor parseDouble = new ParseDouble();
		final CellProcessor parseLocalTime = new ParseLocalTime(DateTimeFormatter.ofPattern("hh:mm:ss a"));
		
		ICsvBeanReader beanReader = null;
		List<Vehicle> vehicles = new ArrayList<Vehicle>();
		
		CellProcessor[] processors = new CellProcessor[] {
				null,
				null,
				parseDouble,
				parseDouble,
				parseDouble,
				parseDouble,
				parseDouble,
				parseDouble,
				parseLocalTime,
				parseLocalTime
		};
				
		try {
			beanReader = new CsvBeanReader(new FileReader(VEHICLES), CsvPreference.STANDARD_PREFERENCE);

			final String[] header = beanReader.getHeader(true);

			Vehicle vehicle;
			while( (vehicle = beanReader.read(Vehicle.class, header, processors)) != null ) {
				vehicles.add(vehicle);
			}                
		}
		finally {
			if( beanReader != null ) {
				beanReader.close();
			}
		}
		
		return vehicles;
		
	}
	
	private static List<Delivery> getDeliveries() throws Exception {
		final CellProcessor parseDouble = new ParseDouble();
		final CellProcessor parseLocalTime = new ParseLocalTime(DateTimeFormatter.ofPattern("HH:mm:ss"));
		
		ICsvBeanReader beanReader = null;
		List<Delivery> deliveries = new ArrayList<Delivery>();
		
		CellProcessor[] processors = new CellProcessor[] {
				null,
				parseDouble,
				parseDouble,
				parseLocalTime,
				parseLocalTime,
				new ParseInt(),
				parseDouble,
				parseDouble
		};
				
		try {
			beanReader = new CsvBeanReader(new FileReader(DELIVERIES), CsvPreference.STANDARD_PREFERENCE);

			final String[] header = beanReader.getHeader(true);

			Delivery delivery;
			while( (delivery = beanReader.read(Delivery.class, header, processors)) != null ) {
				deliveries.add(delivery);
			}                
		}
		finally {
			if( beanReader != null ) {
				beanReader.close();
			}
		}
		
		return deliveries;
	}

	public static void main(String[] args) throws Exception {
		
		List<Vehicle> vehicles = getVehicles();
		List<Delivery> deliveries = getDeliveries();
		VehicleRoutingProblem.Builder vrpBuilder =  VehicleRoutingProblem.Builder.newInstance();
		
		
		vrpBuilder.addAllJobs(
			deliveries.stream().map(new DeliveryConverter()).collect(Collectors.toList())
		);
		
		vrpBuilder.addAllVehicles(
			vehicles.stream().map(new VehicleConverter()).collect(Collectors.toList())
		);
		
		
		vrpBuilder.setFleetSize(FleetSize.FINITE);
		VehicleRoutingProblem problem =  vrpBuilder.build();
		
		VehicleRoutingAlgorithm algorithm = new SchrimpfFactory().createAlgorithm(problem);
		
		// search solutions
		Collection<VehicleRoutingProblemSolution> solutions = algorithm.searchSolutions();
		// get best
		VehicleRoutingProblemSolution bestSolution = Solutions.bestOf(solutions);
		
		SolutionPrinter.print(problem, bestSolution, SolutionPrinter.Print.VERBOSE);
	}
}
