package strategy1.step4.modularization;

public class TestMain2 {

	public static void main(String[] args) {
		SuperRobot superR = new SuperRobot();
		StandardRobot standardR = new StandardRobot();
		LowRobot lowR = new LowRobot();
		
		Robot[] robots = {superR, standardR, lowR};
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
