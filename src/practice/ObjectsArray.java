package practice;

public class ObjectsArray {

	String model;
	String colour;
	
	static ObjectsArray array[] = new ObjectsArray[100];
	
	static {
	array[0] = new ObjectsArray("model1", "red");
	array[1] = new ObjectsArray("model2", "red");
	}
	
	ObjectsArray(String model, String colour){
		this.model = model;
		this.colour = colour;
		
	}
	
	ObjectsArray(){
		
	}
	
	public static void main(String[] args) {
		ObjectsArray obj = new ObjectsArray();
		
		
	}
	
	
}
