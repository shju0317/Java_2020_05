package com.biz.hello;

import java.util.Random;

public class Var_05 {
	public static void main(String[] args) {
		Random rnd = new Random();
		int num = rnd.nextInt(100) + 1;

		int index = 0;

		for (index = 2; index < num; index++) { // num와 index(2~num-1)값을 나누어 
			if (num % index == 0) { // 나머지가 0인 경우가 있는지 검사하고 있으면 for문 중단
				break;
			}
		}
		System.out.println("num: " + num);
		System.out.println("index: " + index);
		/*
		 * num % index == 0 인 조건이 한번도 없으면
		 * for 반복문은 모두 정상수행될 것이고
		 * num와 index 값은 같은 값이 될 것이다.
		 * 
		 * num % index == 0 인 조건이 한번이라도 있다면
		 * for 반복문은 중단(break)될 것이고
		 * index값은 num 보다 반드시 작을 것이다.
		 * 
		 * 이러한 성질을 이용하여
		 * for 반복문이 끝난 다음 index와 num값을 비교하여
		 * num가 소수인지, 아닌지 알 수 있다.
		 */

		if (num > index) {
			System.out.println(num+"는(은) 소수가 아님");
		}else {
			System.out.println(num+"는(은) 소수");
		}
	}
}
