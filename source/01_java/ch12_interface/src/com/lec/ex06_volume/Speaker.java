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
			System.out.println("스피커 볼륨을 1 올려 현재 볼륨 : " + volumeLevel);
		} else {
			System.out.println("스피커 볼륨이 현재 최대 입니다.");
		}
	}

	@Override
	public void volumeUp(int level) {
		if (volumeLevel + level < SPEAKER_MAX_VOLUME) {
			volumeLevel += level;
			System.out.println("스피커 볼륨이 " + level + " 올려 현재 볼륨 : " + volumeLevel);
		} else { // level 만큼 못 올릴 경우 ex. 현재볼륨 45  level 10 일경우 볼륨은 =>볼륨 50이 되려면 몇만큼 올릴지 계산
			int tempLevel = SPEAKER_MAX_VOLUME - volumeLevel;
			volumeLevel = SPEAKER_MAX_VOLUME;
			System.out.println("스피커 볼륨을 "+ level+" 만큼 못 올리고 "+tempLevel+" 만큼 올려 현재 볼륨 "+SPEAKER_MAX_VOLUME);
		}
	}

	@Override
	public void volumeDown() {
		if(volumeLevel > SPEAKER_MIN_VOLUME) {
			volumeLevel--;
			System.out.println("스피커 볼륨을 1 내려 현재 볼륨 : "+volumeLevel);			
		} else {
			System.out.println("스피커 볼륨이 현재 최저 입니다.");
		}
	}

	@Override
	public void volumeDown(int level) {
		if(volumeLevel - level > SPEAKER_MIN_VOLUME) {
			volumeLevel -= level;
			System.out.println("스피커 볼륨이 "+ level+ " 내려 현재 볼륨 : "+volumeLevel);
		} else {
			int tempLevel = volumeLevel;
			volumeLevel = SPEAKER_MIN_VOLUME;
			System.out.println("스피커 볼륨을 "+ level +" 만큼 못 내리고 "+tempLevel+" 만큼 내려 현재 볼륨 : "+SPEAKER_MIN_VOLUME);
		}
	}

}
