package FlightControl.ui;

import FlightControl.domain.Flight;

import java.util.Scanner;

import FlightControl.domain.Airplane;
import FlightControl.domain.Place;
import FlightControl.logic.FlightControl;


public class TextUI {

    private FlightControl flightControl;
    private Scanner scanner;

    public TextUI(FlightControl flightControl, Scanner scanner) {
        this.flightControl = flightControl;
        this.scanner = scanner;
    }

    public void start() {
        System.out.println("Airport Asset Control");
        startAssetControl();
        System.out.println();
        System.out.println("Flight Control");
        startFlightControl();
    }

    private void startAssetControl() {
        
        while (true) {
            System.out.println("Choose an action:");
            System.out.println("[1] Add an airplane");
            System.out.println("[2] Add a flight");
            System.out.println("[x] Exit Airport Asset Control");
            System.out.print("> ");

            String input = scanner.nextLine();

            if (input.equals("1")) {
            
                addAirplane();
            
            } else if (input.equals("2")) {
                
                addFlight();
            
            } else if (input.equals("x")) {
                break;
            
            } else {
                continue;
            }
        }
    }

    private void addAirplane() {
        System.out.print("Give the airplane id: ");
        String id = scanner.nextLine();
        
        System.out.print("Give the airplane capacity: ");
        int capacity = Integer.valueOf(scanner.nextLine());

        this.flightControl.addAirplane(id, capacity);
    }

    private void addFlight() {
        System.out.print("Give the airplane id: ");
        String airplaneId = scanner.nextLine();

        System.out.print("Give the departure airport id: ");
        String departureId = scanner.nextLine();

        System.out.print("Give the target airport id: ");
        String targetId = scanner.nextLine();

        Airplane plane = this.flightControl.getAirplane(airplaneId);
        this.flightControl.addFlight(plane, departureId, targetId);
    }


    private void startFlightControl() {

        while (true) {
            System.out.println("Choose an action:");
            System.out.println("[1] Print airplanes");
            System.out.println("[2] Print flights");
            System.out.println("[3] Print airplane details");
            System.out.println("[x] Quit");
            System.out.print("> ");

            String input = scanner.nextLine();

            if (input.equals("1")) {
                
                printAirplanes();
            
            } else if (input.equals("2")) {
                
                printFlights();
            
            } else if (input.equals("3")) {
                
                printAirplaneDetails();
            
            } else if (input.equals("x")) {
                break;
            
            } else {
                continue;
            }
        }
    }

    private void printAirplanes() {
        for (Airplane plane : flightControl.getAirplanes()) {
            System.out.println(plane);
        }
    }

    private void printFlights() {
        for (Flight flight: flightControl.getFlights()) {
            System.out.println(flight);
        }
    }

    private void printAirplaneDetails() {
        System.out.print("Give the airplane id: ");
        String input = scanner.nextLine();

        Airplane plane = this.flightControl.getAirplane(input);

        System.out.println(plane);
    }



}
