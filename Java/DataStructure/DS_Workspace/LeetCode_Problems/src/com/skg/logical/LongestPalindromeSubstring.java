package com.skg.logical;

public class LongestPalindromeSubstring {

	public static void main(String[] args) {
		System.out.println(LongestPalindrome("kadbabdg"));
	}

	static String LongestPalindrome(String str) {

		int N = str.length();
		int palindrome_begins_at = 0;
		int palindrome_length = 1;

		boolean ispalindrome_table[][] = new boolean[N][N];

		// Base case: Every character in a string is a palindrome.
		for (int i = 0; i < N; i++) {
			ispalindrome_table[i][i] = true;
		}

		// Base case: Same adjacent characters in a string make a palindrome.
		for (int i = 0; i < N - 1; i++) {
			if (str.charAt(i) == str.charAt(i + 1)) {
				ispalindrome_table[i][i + 1] = true;
				palindrome_begins_at = i;
				palindrome_length = 2;
			}
		}

		// Loop from string length of size 3 upto the N
		for (int len = 3; len <= N; len++) {
			for (int i = 0; i < N - len + 1; i++) {
				int j = i + len - 1;
				if (str.charAt(i) == str.charAt(j) && ispalindrome_table[i + 1][j - 1] == true) {
					ispalindrome_table[i][j] = true;
					if (len > palindrome_length) {
						palindrome_begins_at = i;
						palindrome_length = len;
					}
				}
			}
		}

		return str.substring(palindrome_begins_at, palindrome_begins_at + palindrome_length);
	}

	public static boolean checkPalindrome(String s) {
		boolean isPalindrome = true;

		char[] stringarray = s.toLowerCase().toCharArray();
		for (int i = 0; i < stringarray.length / 2; i++) {
			if (s.charAt(i) != s.charAt(stringarray.length - i - 1)) {
				isPalindrome = false;
				break;
			}
		}

		return isPalindrome;

	}
}
