package strategy1.step4.modularization;

public class TestMain {
	public static void main(String[] args) {

		Robot robot = new SuperRobot();
		robot.shape();
		robot.actionWalk();
		robot.actionRun();
		robot.actionFly();
		robot.actionMissile();
		robot.actionKnife();
		// robot.setFly(new FlyNo); �ϴ°� 5�ܰ�

	}
}
