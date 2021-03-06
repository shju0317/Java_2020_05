package com.biz.student.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.biz.student.domain.StudentVO;

/*
 * student.txt 파일을 읽어서 studentList에 저장하고
 * student_list.txt 파일에 학생명부 출력
 * 
 * inputStudent method를 변경하여
 * 전공이 컴퓨터공학인 학생들만 리스트를 추출하시오. 
 */

public class StudentServiceImplV5 extends StudentServiceImplV2{
	// List<StudentVO> studentList;
	
	public StudentServiceImplV5() {
	outPut = System.out;
	}
	
	
	@Override
	public List<StudentVO> getStudentList() {
		// 필드변수로 선언되어 있는 studentList를 외부에서 사용할 수 있도록
		// getter 수행
		return this.studentList;
	}


	@Override
	public boolean inputStudent() {
		String studentFile = "src/com/biz/student/exec/student.txt";
		
		FileReader fileReader = null;
		BufferedReader buffer = null;
		
		try {
			fileReader = new FileReader(studentFile);
			buffer = new BufferedReader(fileReader);
			
			String reader = "";		
			
			while(true) {
				reader = buffer.readLine();
				if(reader == null) {
					break;
				}
				
				String[] students = reader.split(":");
				StudentVO sVO = new StudentVO();
				sVO.setNum(students[0]);
				sVO.setName(students[1]);
				sVO.setGrade(Integer.valueOf(students[2]));
				sVO.setDept(students[4]);
				
				if (sVO.getDept().equals("컴퓨터공학")) {
					studentList.add(sVO);
				}
			}
			
//			System.out.println("==================================================");
//			System.out.println("컴퓨터공학 전공 학생 리스트");
//			System.out.println("--------------------------------------------------");
//			System.out.println("학번\t이름\t학년\t학과");
//			System.out.println("--------------------------------------------------");
//			
//			
//			for (StudentVO sVO : studentList) {
//				String str = sVO.getDept();
//				if (sVO.getDept().equals("컴퓨터공학")) {
//					outPut.print(sVO.getNum() + "\t");
//					outPut.print(sVO.getName() + "\t");
//					outPut.print(sVO.getGrade() + "\t");
//					outPut.println(sVO.getDept());
//				}
//			}
//			
//			System.out.println("==================================================");

			buffer.close();
			fileReader.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

}
