package com.lec.ex06_volume;

public class TestMain {

	public static void main(String[] args) {
		IVolume[] volumes = { new TV(3), new Speaker(5), new TV(10), new Speaker(7) };

		for (IVolume temp : volumes) {
			temp.volumeUp(10);
			temp.volumeUp(45);
			temp.volumeDown(10);
			temp.volumeDown(20);
		}

	}

}
