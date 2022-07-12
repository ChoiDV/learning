package com.lec.ex06_volume;


public class Speaker implements IVolume {
	private int volumeLevel;
	private final int SPEAKER_MAX_VOLUME = 100;
	private final int SPEAKER_MIN_VOLUME = 0;

	public Speaker() {

	}

	public Speaker(int volumeLevel) {
		this.volumeLevel = volumeLevel;
	}

	@Override
	public void volumeUp() {
		if (volumeLevel < SPEAKER_MAX_VOLUME) {
			volumeLevel++;
			System.out.println("����Ŀ ������ 1 �÷� ���� ���� : " + volumeLevel);
		} else {
			System.out.println("����Ŀ ������ ���� �ִ� �Դϴ�.");
		}
	}

	@Override
	public void volumeUp(int level) {
		if (volumeLevel + level < SPEAKER_MAX_VOLUME) {
			volumeLevel += level;
			System.out.println("����Ŀ ������ " + level + " �÷� ���� ���� : " + volumeLevel);
		} else { // level ��ŭ �� �ø� ��� ex. ���纼�� 45  level 10 �ϰ�� ������ =>���� 50�� �Ƿ��� �ŭ �ø��� ���
			int tempLevel = SPEAKER_MAX_VOLUME - volumeLevel;
			volumeLevel = SPEAKER_MAX_VOLUME;
			System.out.println("����Ŀ ������ "+ level+" ��ŭ �� �ø��� "+tempLevel+" ��ŭ �÷� ���� ���� "+SPEAKER_MAX_VOLUME);
		}
	}

	@Override
	public void volumeDown() {
		if(volumeLevel > SPEAKER_MIN_VOLUME) {
			volumeLevel--;
			System.out.println("����Ŀ ������ 1 ���� ���� ���� : "+volumeLevel);			
		} else {
			System.out.println("����Ŀ ������ ���� ���� �Դϴ�.");
		}
	}

	@Override
	public void volumeDown(int level) {
		if(volumeLevel - level > SPEAKER_MIN_VOLUME) {
			volumeLevel -= level;
			System.out.println("����Ŀ ������ "+ level+ " ���� ���� ���� : "+volumeLevel);
		} else {
			int tempLevel = volumeLevel;
			volumeLevel = SPEAKER_MIN_VOLUME;
			System.out.println("����Ŀ ������ "+ level +" ��ŭ �� ������ "+tempLevel+" ��ŭ ���� ���� ���� : "+SPEAKER_MIN_VOLUME);
		}
	}

}
