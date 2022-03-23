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
			System.out.println("TV 볼륨을 1 올려 현재 볼륨 : " + volumeLevel);
		} else {
			System.out.println("TV 볼륨이 현재 최대 입니다.");
		}
	}

	@Override
	public void volumeUp(int level) {
		if (volumeLevel + level < TV_MAX_VOLUME) {
			volumeLevel += level;
			System.out.println("TV 볼륨이 " + level + " 올려 현재 볼륨 : " + volumeLevel);
		} else { // level 만큼 못 올릴 경우 ex. 현재볼륨 45  level 10 일경우 볼륨은 =>볼륨 50이 되려면 몇만큼 올릴지 계산
			int tempLevel = TV_MAX_VOLUME - volumeLevel;
			volumeLevel = TV_MAX_VOLUME;
			System.out.println("TV 볼륨을 "+ level+" 만큼 못 올리고 "+tempLevel+" 만큼 올려 현재 볼륨 "+TV_MAX_VOLUME);
		}
	}

	@Override
	public void volumeDown() {
		if(volumeLevel > TV_MIN_VOLUME) {
			volumeLevel--;
			System.out.println("TV 볼륨을 1 내려 현재 볼륨 : "+volumeLevel);			
		} else {
			System.out.println("TV 볼륨이 현재 최저 입니다.");
		}
	}

	@Override
	public void volumeDown(int level) {
		if(volumeLevel - level > TV_MIN_VOLUME) {
			volumeLevel -= level;
			System.out.println("TV 볼륨이 "+ level+ " 내려 현재 볼륨 : "+volumeLevel);
		} else {
			int tempLevel = volumeLevel;
			volumeLevel = TV_MIN_VOLUME;
			System.out.println("TV 볼륨을 "+ level +" 만큼 못 내리고 "+tempLevel+" 만큼 내려 현재 볼륨 : "+TV_MIN_VOLUME);
		}
	}

}
