package com.skg.stackdemo;

import java.util.Stack;

public class ValidSymbolPattern {
	
	public static void main(String[] args) {
		System.out.println(isValidSymbolPattern("{[()]"));
	}

	public static boolean isValidSymbolPattern(String s) {
		Stack<Character> stack = new Stack<>();

		if (s == null || s.length() == 0)
			return true;

		for (int i = 0; i < s.length(); i++) {

			if (s.charAt(i) == ')') {
				if (!stack.isEmpty() && stack.peek() == '(')
					stack.pop();
				else
					return false;
			} else if (s.charAt(i) == ']') {
				if (!stack.isEmpty() && stack.peek() == '[')
					stack.pop();
				else
					return false;
			} else if (s.charAt(i) == '}') {
				if (!stack.isEmpty() && stack.peek() == '{')
					stack.pop();
				else
					return false;
			} else {
				stack.push(s.charAt(i));
			}
		}

		if (stack.isEmpty())
			return true;
		else
			return false;
	}

}
