package d_array;

public class ArrayExercise07 {

	ArrayExercise07(){
		int max = 0;
		int[] array = {5,7,2,6,1,5};
		
		for(int i = 0; i<array.length; i++) {
			if(array[i]>max) {
				max = array[i];
			}
		}
		System.out.println(max);
	}
	
	public static void main(String[] args) {
		new ArrayExercise07();
	}

}
