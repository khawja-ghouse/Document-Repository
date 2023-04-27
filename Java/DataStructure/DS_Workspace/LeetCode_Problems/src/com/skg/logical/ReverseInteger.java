package com.skg.logical;

public class ReverseInteger {

	public static void main(String[] args) {
		System.out.println(reverse(1563847412));
	}

	public static int reverse(int x) {
		long reverse = 0;
		while (x != 0) {
			reverse = (reverse * 10 + (x % 10));
			x = x / 10;
		}
		if (reverse > Integer.MAX_VALUE || reverse < Integer.MIN_VALUE) {
			return 0;
		}
		if (x < 0) {
			return (int) (-1 * reverse);
		} else
			return (int) reverse;

		/*
		 * long ans = 0; while(x != 0){ int r = x % 10; ans += r; ans *= 10; x /= 10; }
		 * ans /= 10; if(ans > Integer.MAX_VALUE || ans < Integer.MIN_VALUE){ return 0;
		 * } return (int)ans;
		 */
	}

}
