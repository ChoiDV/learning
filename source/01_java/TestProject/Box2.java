
public class Box2 {

	int width, length, height;
	int volume;
	
	Box2(int w, int l ,int h){
		width =w;
		length = l;
		height = h;
		
	}
	
	boolean isSameBox(Box2 obj) {
		if((obj.width==width) && (obj.length==length) && (obj.height==height))
			return true;
		
		else
			return false;
	}
	
}
