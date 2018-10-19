import java.lang.IllegalStateException;

public class ArrayList implements List{
	private int size = 0;
	private Object[] arr = new Object[10];

	public void add(Object obj){
		if(size == arr.length){
			growArr();
		}
		arr[size] = obj;
		size++;
	}
	public void add(int pos, Object obj){
		if(pos < 0 || pos > size){
			throw new IllegalStateException("Position too far");
		}
		if(arr.length == size){
			growArr();
		}
		for(int i = size; i > pos; i--){
			arr[i] = arr[i-1];
		}size++;
		arr[pos] = obj;
	}
	public Object get(int pos){
		if(size == 0 || pos > size || pos < 0){
			throw new IllegalStateException("Nothing there");
		}return arr[pos];

	}
	public Object remove(int pos){
		if(pos < 0 || pos >= size){
			throw new IllegalStateException("Nah nothing to remove");
		}
		Object obj = arr[pos];
		for(int i = pos; i < size - 1; i++){
			arr[i] = arr[i+1];
		}
		--size;
		return obj;

	}
	public int size(){
		return size;

	}
	private void growArr(){
		int longer_arr_len = arr.length * 2;
		Object[] arr_longer = new Object[longer_arr_len];
		
		for(int i = 0; i < arr.length; i++){
			arr_longer[i] = arr[i];
		}
		arr = arr_longer;
	}
}