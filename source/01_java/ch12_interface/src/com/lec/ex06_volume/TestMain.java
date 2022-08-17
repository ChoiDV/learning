package com.lec.ex06_volume;

public class TestMain {

	public static void main(String[] args) {
		IVolume[] volumes = { new TV(3), new Speaker(5), new TV(10), new Speaker(7) };

		for (IVolume temp : volumes) {
			temp.volumeUp(10);
			temp.volumeUp(45);
			temp.volumeDown(10);
			temp.volumeDown(20);
			temp.setMute(true); // 인터페이스를 추상클래스처럼 만들어주는거 default 사용해서 
		}

	}

}
