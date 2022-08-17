package strategy1.step2;
// Robot�� ��ӹ��� Ŭ����: SuperRobot, StandardRobot, LowRobot
public class Robot {
	public void actionWalk() {
		System.out.println("���� �� �ֽ��ϴ�.");
	}
	public void actionRun() {
		System.out.println("�� �� �ֽ��ϴ�.");
	}
	public void shape() {
		String className = getClass().getName(); // strategy1.step2.SuperRobot
		int idx = className.lastIndexOf('.'); // �� ������ '.' �� �ִ� ��ġ�� idx�� �־���
		String name = className.substring(idx+1); // substring �� idx+1��° �۾����� ������ name�� �־���
		System.out.println(name +"�Դϴ�. ������ ��, �ٸ�, ����, �Ӹ��� �ֽ��ϴ�.");
	}

}
