package com.lec.ex10_aorb;

public class TestMain {

	public static void main(String[] args) {
		A a = new A();
		B b = new B();
		// �������̽�   ��ǰ�� ���Ƴ��ﶧ  �� �԰ݿ� �´� ��ǰ���� ���Ʋ�����  �԰��� �ȸ����� ���Ƴ��� ���ϴµ�
		// �׷���  �������̽��� �� �԰��� �����شٰ� �����ϸ� �ɵ�.
		// User ������ �Ű������� �������̽� Ÿ���� �޴´�. �׷��� ���Ƴ������ I�� ������ �ֵ鸸 ���ü��ִ°��̴�.
		
		User user = new User();
		//user.use(a);
		user.use(b);
	}

}
