package com.biz.word.exec;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.biz.word.domain.WordVO;
import com.biz.word.statics.SplitPositon;

public class WordEx_01 {
	public static void main(String[] args) {
		String wordFile = "src/com/biz/word/exec/word.txt";
		List<WordVO> wordList = new ArrayList<WordVO>();
		
		// 파일을 open하기 위한 객체
		FileReader fileReader = null;
		
		// fileReader와 연동하여 파일을 읽어올 때
		// 효율적으로 가져오기 위한 Helper class
		BufferedReader buffer = null;
		
		// fileReader를 사용하여 wordFile을 읽기 용도로 open
		// 운영체제와 통신을 하여 파일을 open하는 과정에서
		// 갑자기 문제가 발생하여 파일을 open할 수 없는 경우가
		// 발생할 가능성이 매우 높으므로
		// 이 코드는 반드시 try-catch문으로 묶어서 예외처리를 해야한다.
		try {
			fileReader = new FileReader(wordFile);
			
			// buffer는 파일을 읽어서 임시 버퍼영역에 보관한다.
			buffer = new BufferedReader(fileReader);
			
			// buffer로부터 readLine() method를 호출하여
			// 한줄씩 데이터를 읽어온다.
			// 이때 데이터의 라인수가 몇개인지 알 수 없으므로
			// while반복문으로 무한반복 실행하여
			// 계속 한줄씩 읽도록 수행한다.
			
			String reader = "";
			while(true) {
				// 반드시 try-catch를 수행해야 한다.
				// 이미 try로 묶인 코드 내부이므로
				// 별도로 try를 설정하지 않고 catch 추가하여 처리한다.
				reader = buffer.readLine();
				
				if(reader == null) {
					break;
				}
				
				// 읽어들인 데이터를 콜론(:)을 기준으로
				// 문자열 분해를 하여 words배열에 담아달라
				String[] words = reader.split(":");
				
				WordVO wVO = new WordVO();
				wVO.setEng(words[SplitPositon.WORD_ENG]); // words[0]
				wVO.setKor(words[SplitPositon.WORD_KOR]); // words[1]
				wordList.add(wVO);
			}
			buffer.close();
			fileReader.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Random rnd = new Random();
		int size = wordList.size();
		Scanner scan = new Scanner(System.in);
		
		int count = 0;
		int game = 0;
		
		while(true) {
			int index = rnd.nextInt(size); // 0~size-1(1619-1) 사이의 한 수
			System.out.println("다음에 해당하는 영어단어는?!(END:종료)");
			System.out.print(wordList.get(index).getKor() + ">> ");
			String strEng = scan.nextLine();
			
			if(strEng.equalsIgnoreCase("종료")) {
				break;
			}
			
			game++;
			if(strEng.equalsIgnoreCase(wordList.get(index).getEng())) {
				System.out.println("올 맞아용");
				count++;
			}else {
				System.out.println("아니얌ㅠㅠ");
				System.out.println("정답은 [ " + wordList.get(index).getEng() + " ] 입니다!");
			}
		}
		System.out.println("GAME OVER!");
		System.out.printf("%d 중 %d 번 맞췄습니당!",game, count);
		
	}
}
