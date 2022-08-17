package com.lec.ex10_robot;
// RobotOrder order = new RobotOrder();
// order.action(sing��, draw��, dance�� );

public class RobotOrder {
	public void action(IRobot robot) {
		if(robot instanceof SingRobot) {
			((SingRobot) robot).sing();
		} else if(robot instanceof DanceRobot) {
			((DanceRobot) robot).dance();
		} else if(robot instanceof DrawRobot) {
			((DrawRobot) robot).draw();
		} else {
			System.out.println("Ȯ��� �κ��̸� �̰��� �����ϼ���");
		}
	}
	
}
