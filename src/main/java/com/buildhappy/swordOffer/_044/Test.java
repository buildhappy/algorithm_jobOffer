package com.buildhappy.swordOffer._044;

public class Test {

	public static void main(String[] args) {
		int[] data = {1 , 2 , 3 , 5 , 8 , 13};
		find(data);
	}

	public static void find(int[] data){
		for(int n = data.length - 1; n >= 0; n--){
			int low = 0 , high = n;
			while(low < high){
				if(data[low] + data[high] == data[n]){
					System.out.println(data[low++] + "+" +  data[high--] + "=" + data[n]);
				}else if(data[low] + data[high] > data[n]){
					high--;
				}else{
					low++;
				}
			}
		}
	}
}
