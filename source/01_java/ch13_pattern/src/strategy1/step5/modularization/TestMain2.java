package strategy1.step5.modularization;

import strategy1.step4.interfaces.FlyHigh;

// 5단계 : 기능을 부품화 -> 유지보수를 간편하게

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
		// lowR.setFly(new FlyYes);  이제 이런거 가능
		// SuperRobot 업그레이드 요청 : 날수 있습니다 -> 높이 고공비행합니다.
		// 고공비행하는 부품 만들어 setFly만 호출 하면 끝
		// 5단계의 장점
		
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
