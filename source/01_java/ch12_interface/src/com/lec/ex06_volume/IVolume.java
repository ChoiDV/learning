package com.lec.ex06_volume;

public interface IVolume {
	public void volumeUp();  // ���� �Ѱ� �ø��� �޼ҵ�
	public void volumeUp(int level); // ���� level ��ŭ �ø��� �޼ҵ�
	public void volumeDown(); // ���� �Ѱ� ������ �޼ҵ�
	public void volumeDown(int level); // ���� level ��ŭ ������ �޼ҵ�
	
	public default void setMute(boolean mute) { // �������̽��� �߻�Ŭ����ó�� �߻�޼ҵ�� �Ϲݸ޼ҵ带 �Բ� ����ϴ¹�.
		if(mute) {								// default ����ϸ� ������.
			System.out.println("���� ó���մϴ�.");
		} else {
			System.out.println("���� �����մϴ�.");
		}
	}
}
