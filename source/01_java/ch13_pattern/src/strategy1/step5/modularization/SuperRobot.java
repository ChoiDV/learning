package strategy1.step5.modularization;

import strategy1.step4.interfaces.FlyYes;
import strategy1.step4.interfaces.IFly;
import strategy1.step4.interfaces.IKnife;
import strategy1.step4.interfaces.IMissile;
import strategy1.step4.interfaces.KnifeLazer;
import strategy1.step4.interfaces.MissileYes;

public class SuperRobot extends Robot {

	public SuperRobot() {
		setFly(new FlyYes()); // �Ȱ���. ������ ����鼭 fly�� set���ִ°�.fly = new FlyYes();
		setMissile(new MissileYes()); // missile = new MissileYes();
		setKnife(new KnifeLazer()); // knife = new KnifeLazer();
	}

}
