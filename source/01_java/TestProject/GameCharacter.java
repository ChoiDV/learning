import java.util.ArrayList;

public class GameCharacter {

	private class GameItem {
		String name;
		int type;
		int price;
		
		int getPrice() { return price;}

		@Override
		public String toString() {
			return "GameItem [name=" + name + ", type=" + type + ", price=" + price + "]";
		}
	
		
} 			// ArrayList <>는 list라는 배열안에 GameItem 을 집어넣는것임
	private ArrayList<GameItem> list = new ArrayList<>();
	
	public void add(String name, int type, int price) {
		GameItem item = new GameItem();
		item.name = name;
		item.type = type;
		item.price = price;
		list.add(item);
		
		
	}
	public void print() {
		int total = 0;
		for (GameItem item : list) {
			System.out.println(item);
			total += item.getPrice();
		}
		System.out.println(total);
	}
}
