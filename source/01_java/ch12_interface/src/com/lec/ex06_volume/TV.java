package com.lec.ex06_volume;

// TV tv = new TV(3);
public class TV implements IVolume {
	private int volumeLevel;
	private final int TV_MAX_VOLUME = 50;
	private final int TV_MIN_VOLUME = 0;

	public TV() {

	}

	public TV(int volumeLevel) {
		this.volumeLevel = volumeLevel;
	}

	@Override
	public void volumeUp() {
		if (volumeLevel < TV_MAX_VOLUME) {
			volumeLevel++;
			System.out.println("TV ������ 1 �÷� ���� ���� : " + volumeLevel);
		} else {
			System.out.println("TV ������ ���� �ִ� �Դϴ�.");
		}
	}

	@Override
	public void volumeUp(int level) {
		if (volumeLevel + level < TV_MAX_VOLUME) {
			volumeLevel += level;
			System.out.println("TV ������ " + level + " �÷� ���� ���� : " + volumeLevel);
		} else { // level ��ŭ �� �ø� ��� ex. ���纼�� 45  level 10 �ϰ�� ������ =>���� 50�� �Ƿ��� �ŭ �ø��� ���
			int tempLevel = TV_MAX_VOLUME - volumeLevel;
			volumeLevel = TV_MAX_VOLUME;
			System.out.println("TV ������ "+ level+" ��ŭ �� �ø��� "+tempLevel+" ��ŭ �÷� ���� ���� "+TV_MAX_VOLUME);
		}
	}

	@Override
	public void volumeDown() {
		if(volumeLevel > TV_MIN_VOLUME) {
			volumeLevel--;
			System.out.println("TV ������ 1 ���� ���� ���� : "+volumeLevel);			
		} else {
			System.out.println("TV ������ ���� ���� �Դϴ�.");
		}
	}

	@Override
	public void volumeDown(int level) {
		if(volumeLevel - level > TV_MIN_VOLUME) {
			volumeLevel -= level;
			System.out.println("TV ������ "+ level+ " ���� ���� ���� : "+volumeLevel);
		} else {
			int tempLevel = volumeLevel;
			volumeLevel = TV_MIN_VOLUME;
			System.out.println("TV ������ "+ level +" ��ŭ �� ������ "+tempLevel+" ��ŭ ���� ���� ���� : "+TV_MIN_VOLUME);
		}
	}

}
