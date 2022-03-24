package strategy1.step4.modularization;

import strategy1.step4.interfaces.FlyYes;
import strategy1.step4.interfaces.IFly;
import strategy1.step4.interfaces.IKnife;
import strategy1.step4.interfaces.IMissile;
import strategy1.step4.interfaces.KnifeLazer;
import strategy1.step4.interfaces.MissileYes;

public class SuperRobot extends Robot {
	private IFly fly;
	private IMissile missile;
	private IKnife knife;

	public SuperRobot() {
		setFly(new FlyYes()); // 똑같음. 생성자 만들면서 fly를 set해주는것.fly = new FlyYes();
		setMissile(new MissileYes()); // missile = new MissileYes();
		setKnife(new KnifeLazer()); // knife = new KnifeLazer();
	}

	@Override // 부품 뻇다 끼우는 부분
	public void actionFly() {
		fly.fly();
	}

	@Override
	public void actionMissile() {
		missile.missile();
	}

	@Override
	public void actionKnife() {
		knife.knife();
	}

	public void setFly(IFly fly) {
		this.fly = fly;
	}

	public void setMissile(IMissile missile) {
		this.missile = missile;
	}

	public void setKnife(IKnife knife) {
		this.knife = knife;
	}

}
