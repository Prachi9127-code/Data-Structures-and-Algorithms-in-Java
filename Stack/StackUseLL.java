package com.linkedlist;

import com.codingninjas.StackEmptyException;
import com.codingninjas.StackFullException;
//import com.codingninjas.StackUsingArray;

public class StackUseLL {

	public static void main(String[] args) throws StackFullException{
		StackUsingLL<Integer> stack = new StackUsingLL<>();
		for(int i=1; i<=5; i++) {
			stack.push(i);
		}
        while(!stack.isEmpty()) {
        	try {
				System.out.println(stack.pop());
			} catch (StackEmptyException e) {
				// Never reach here
			}
        }
	}
	
}
