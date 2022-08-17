package strategy2.modularization;

import strategy2.interfaces.IEngine;
import strategy2.interfaces.IFuel;
import strategy2.interfaces.IKm;

// 3���� ��ǰ ����
// ������ X
// drive(�Ϲݸ޼ҵ�), shape(�߻�޼ҵ�), engine(�Ϲ�), km(�Ϲ�), fuel(�Ϲ�),setter
public abstract class Car {
	private IEngine engine;
	private IKm km;
	private IFuel fuel;

	public void drive() {
		System.out.println("����̺� �� �� �ֽ��ϴ�.");
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
