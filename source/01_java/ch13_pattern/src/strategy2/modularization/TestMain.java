package strategy2.modularization;

import strategy2.interfaces.FuelHybrid;
import strategy2.interfaces.Km20;

public class TestMain {

	public static void main(String[] args) {
		Car genesis = new Genesis();
		Car sonata = new Sonata();
		Car accent = new Accent();
		
		Car[] cars = { genesis, sonata, accent};
		
		for( Car c : cars) {
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			c.shape();
			c.engine();
			c.km();
			c.fuel();
			c.drive();
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			
		}
		System.out.println("소나타를 하이브리드로 교체하고 연비를 20km/L로 교체해주세요");
		sonata.setFuel(new FuelHybrid());
		sonata.setKm(new Km20());
		for(int idx =0; idx < cars.length ; idx++) {	
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			cars[idx].shape();
			cars[idx].engine();
			cars[idx].km();
			cars[idx].fuel();
			cars[idx].drive();
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		}
		

	}

}
