package strategy2.modularization;

import strategy2.interfaces.IEngine;
import strategy2.interfaces.IFuel;
import strategy2.interfaces.IKm;

// 3가지 부품 변수
// 생성자 X
// drive(일반메소드), shape(추상메소드), engine(일반), km(일반), fuel(일반),setter
public abstract class Car {
	private IEngine engine;
	private IKm km;
	private IFuel fuel;

	public void drive() {
		System.out.println("드라이브 할 수 있습니다.");
	}

	public abstract void shape();

	public void engine() {
		engine.engine();
	}

	public void km() {
		km.Km();
	}

	public void fuel() {
		fuel.fuel();
	}

	public void setEngine(IEngine engine) {
		this.engine = engine;
	}

	public void setKm(IKm km) {
		this.km = km;
	}

	public void setFuel(IFuel fuel) {
		this.fuel = fuel;
	}

}
