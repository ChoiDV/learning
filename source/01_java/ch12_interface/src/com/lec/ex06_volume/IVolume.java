package com.lec.ex06_volume;

public interface IVolume {
	public void volumeUp();  // 볼륨 한개 올리는 메소드
	public void volumeUp(int level); // 볼륨 level 만큼 올리는 메소드
	public void volumeDown(); // 볼륨 한개 내리는 메소드
	public void volumeDown(int level); // 볼륨 level 만큼 내리는 메소드
	
}
