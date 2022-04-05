package strategy1.step5.modularization;

import strategy1.step4.interfaces.FlyHigh;

// 5�ܰ� : ����� ��ǰȭ -> ���������� �����ϰ�

public class TestMain2 {

	public static void main(String[] args) {
		Robot superR = new SuperRobot();
		Robot standardR = new StandardRobot();
		Robot lowR = new LowRobot();
		
		Robot[] robots = {superR, standardR, lowR};
//		for(Robot robot : robots) {
//			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");
//			robot.shape();
//			robot.actionWalk();
//			robot.actionRun();
//			robot.actionFly();
//			robot.actionMissile();
//			robot.actionKnife();
//			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");
//		}
		// lowR.setFly(new FlyYes);  ���� �̷��� ����
		// SuperRobot ���׷��̵� ��û : ���� �ֽ��ϴ� -> ���� ��������մϴ�.
		// ��������ϴ� ��ǰ ����� setFly�� ȣ�� �ϸ� ��
		// 5�ܰ��� ����
		
		superR.setFly(new FlyHigh());
		for(Robot robot : robots) {
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			robot.shape();
			robot.actionWalk();
			robot.actionRun();
			robot.actionFly();
			robot.actionMissile();
			robot.actionKnife();
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		}
		

	}

}
