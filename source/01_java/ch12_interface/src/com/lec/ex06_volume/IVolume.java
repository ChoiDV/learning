package com.lec.ex06_volume;

public interface IVolume {
	public void volumeUp();  // 볼륨 한개 올리는 메소드
	public void volumeUp(int level); // 볼륨 level 만큼 올리는 메소드
	public void volumeDown(); // 볼륨 한개 내리는 메소드
	public void volumeDown(int level); // 볼륨 level 만큼 내리는 메소드
	
	public default void setMute(boolean mute) { // 인터페이스를 추상클래스처럼 추상메소드와 일반메소드를 함께 사용하는법.
		if(mute) {								// default 사용하면 가능함.
			System.out.println("무음 처리합니다.");
		} else {
			System.out.println("무음 해제합니다.");
		}
	}
}
