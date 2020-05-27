package com.biz.control;

import java.util.Random;

public class If_04 {
	public static void main(String[] args) {
		Random rnd = new Random();

		int num1 = rnd.nextInt(100) + 1;
		
		/*
		 * if(조건1){
		 * 
		 * }
		 * if(조건2){
		 * 
		 * }
		 * if(조건1 != true && 조건2 != true){
		 * 
		 * }
		 * 
		 *  여러가지 조건 중에서 조건이 true인 모든 경우를 검사하기 위한 코드
		 *  단, 여러조건 중에 1가지의 조건이 true이더라도
		 *  나머지 조건을 모두 검사해야한다.
		 *  필요한 경우 사용하기도 하며, 여러 조건 중 1가지만 검사하고자 한다면
		 *  비효율적인 코드가 될 수도 있다.
		 *  
		 */

		if (num1 % 5 == 0) {
			System.out.printf("%d 는(은) 5의 배수\n", num1);
		}
		if (num1 % 4 == 0) {
			System.out.printf("%d 는(은) 4의 배수\n", num1);
		}
		if (num1 % 3 == 0) {
			System.out.printf("%d 는(은) 3의 배수\n", num1);
		}
		if (num1 % 2 == 0) {
			System.out.printf("%d 는(은) 2의 배수\n", num1);
		}
		if (num1 % 5 != 0 && num1 % 4 != 0 && num1 % 3 != 0 && num1 % 2 != 0) {
			System.out.printf("%d 는(은) 5,4,3,2의 배수가 아님\n", num1);
		}
	}
}