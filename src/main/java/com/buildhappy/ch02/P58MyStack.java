package com.buildhappy.ch02;

import java.util.Arrays;
import java.util.Collection;
import java.util.EmptyStackException;

public class P58MyStack<E> {
	Object[] elements;
	int elementCount;
	int capacityIncrement = 10;
    /**
     * The maximum size of array to allocate.
     * Some VMs reserve some header words in an array.
     * Attempts to allocate larger arrays may result in
     * OutOfMemoryError: Requested array size exceeds VM limit
     */
	
	private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
	
	/**
	 * 初始化固定大小的栈
	 * @param initSize
	 */
	public P58MyStack(int initSize){
		if(initSize < 0){
			throw new IllegalArgumentException("Illegal capacity" + initSize);
		}
		if(initSize >= MAX_ARRAY_SIZE){
			throw new OutOfMemoryError();
		}
		elements = new Object[initSize];
	}
	public P58MyStack(Collection<? extends E> c){
		elements = c.toArray();
		elementCount = elements.length;
		// c.toArray might (incorrectly) not return Object[] (see 6260652)
		if(Object[].class != elements.getClass()){
			Arrays.copyOf(elements, elementCount, Object[].class);
		}
	}
	//向栈中插入元素
    public E push(E item) {
        //addElement(item);
    	ensureCapacityHelper(elementCount + 1);
    	elements[elementCount++] = item;
        return item;
    }
    
    private void ensureCapacityHelper(int minCapacity){
    	if(minCapacity > elements.length){
    		grow(minCapacity);
    	}
    }
    private void grow(int minCapacity){
    	int oldCapacity = elements.length;
    	int newCapacity = oldCapacity + capacityIncrement;
    	if(newCapacity < minCapacity){
    		newCapacity = minCapacity;
    	}
    	if(newCapacity > MAX_ARRAY_SIZE){
    		throw new OutOfMemoryError();
    	}
    	elements = Arrays.copyOf(elements, newCapacity);
    }
    
    //弹出栈顶元素
    public synchronized E pop() {
        E	obj;
        int	len = elementCount;

        obj = peek();
        removeElementAt(len - 1);
        return obj;
    }
    public synchronized void removeElementAt(int index){
    	if(index >= elementCount){
    		throw new ArrayIndexOutOfBoundsException("index + >= " + elementCount);
    	}else{
    		if(index <= 0){
    			throw new ArrayIndexOutOfBoundsException(index	);
    		}
    	}
    	int j = elementCount - index - 1;//index后的元素个数
    	if(j > 0){
    		//System.arraycopy(src, srcPos, dest, destPos, length);
    		System.arraycopy(elements , index + 1 , elements , index , j);
    	}
    	elementCount--;
    	elements[index] = null;//让垃圾回收器进行回收
    }
    //Looks at the object at the top of this stack without removing it
    public synchronized E peek() {
        int len = elementCount;
        if (len == 0)
            throw new EmptyStackException();
        return (E) elements[len - 1];
    }
    
    
	public static void main(String[] args) {
		String[] a = {"aa" , "bb"};
		String[] b = {"cc" , "dd" , "ee"};
		a = null;
		a = Arrays.copyOf(b, b.length);
		for(String s : a){
			System.out.print(s + ",");
		}
	}

}
