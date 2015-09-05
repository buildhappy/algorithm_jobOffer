package com.buildhappy.swordOffer._004_StringReplaceBlank;

/**
 * 字符串操作
 * @author buildhappy
 *
 */
public class P47ReplaceBlank {
	
	//将字符串中的空格用%20代替
	public static String replaceBlank(String s){
		if(s == null || s.length() == 0){
			return null;
		}
		char[] oldArray = s.toCharArray();
		System.out.println(oldArray.length);
		int blankCount = 0 ,oldCurP = oldArray.length - 1;
		
		for(char a : oldArray){
			if(a == ' '){
				blankCount++;
			}
		}
		if(blankCount == 0){
			return s;
		}
		char[] newArray = new char[oldCurP + blankCount * 2 + 1];
		System.out.println("newArray lenght:" + newArray.length);
		int newCurP = oldCurP + blankCount * 2;
		
		while(oldCurP >= 0 && newCurP >= 0){
			if(oldArray[oldCurP] == ' '){
				newArray[newCurP--] = '0';
				newArray[newCurP--] = '2';
				newArray[newCurP--] = '%';
			}else{
				newArray[newCurP--] = oldArray[oldCurP];
			}
			oldCurP--;
		}
		//System.out.println(new String(newArray).length());
		//System.out.println(new String(newArray));
		return new String(newArray);
	}
	
	
	//有两个升序的数组A1和A2，内存在A1的末尾有足够多的空余空间容纳A2。将A2插入到A1并且保持有序
	public static int[] insertA2ToA1(int[] A1 , int[] A2){
		int lengthA1 = A1.length , lengthA2 = A2.length , elementsA2 = lengthA2;
		int elementsA1;
		for(elementsA1 = 0; elementsA1 < lengthA1 && A1[elementsA1] != -1; elementsA1++){}
		int pA1 = elementsA1 + elementsA2;
		if(pA1 > lengthA1){
			return null;
		}
		
		elementsA1--;
		elementsA2--;
		pA1--;
		while(elementsA1 >= 0 && elementsA2 >= 0){
			if(A2[elementsA2] > A1[elementsA1]){
				A1[pA1] = A2[elementsA2];
				elementsA2--;
				pA1--;
			}else{
				A1[pA1] = A1[elementsA1];
				elementsA1--;
				pA1--;
			}
		}

		while(elementsA2 >= 0){
			A1[pA1] = A2[elementsA2];
			elementsA2--;
			pA1--;
		}
		return A1;
	}
	
	public static void main(String[] args) {
		String s = "we are happy  ";
		System.out.println(replaceBlank(s));
		
		int[] A1 = {1 , 3 , 5 ,-1,-1,-1};
		int[] A2 = {2 , 4};
		int[] A3 = insertA2ToA1(A1 , A2);
		for(int i : A3){
			System.out.print(i + ",");
		}
	}
}
