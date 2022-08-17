package com.lec.ex10_robot;
// RobotOrder order = new RobotOrder();
// order.action(sing형, draw형, dance형 );

public class RobotOrder {
	public void action(IRobot robot) {
		if(robot instanceof SingRobot) {
			((SingRobot) robot).sing();
		} else if(robot instanceof DanceRobot) {
			((DanceRobot) robot).dance();
		} else if(robot instanceof DrawRobot) {
			((DrawRobot) robot).draw();
		} else {
			System.out.println("확장된 로봇이면 이곳에 구현하세요");
		}
	}
	
}
