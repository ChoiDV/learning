package com.lec.ex1_person;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Person {
	/*
	 * 1을 누르면 데이터 입력 이름, 직업, 국어, 영어, 수학점수를 입력받아 데이터 베이스에 번호를 포함하여 입력한다. 번호는 시퀀스를
	 * 이용하여 순차적으로 입력한다. 데이터베이스의 내용은 다음과 같다
	 */
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner sc = new Scanner(System.in);
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql1 = "INSERT INTO PERSON VALUES(PERSON_NO_SQ.NEXTVAL,?,(SELECT jNO FROM JOB WHERE jNAME=?),?,?,?)";

		String sql2 = "SELECT ROWNUM RANK, A.*"
				+ "    FROM (SELECT PNAME||'(' ||PNO ||'번)' PNAME, JNAME, KOR, ENG, MAT, KOR+ENG+MAT SUM"
				+ "    FROM PERSON P, JOB J" + "        WHERE P.JNO = J.JNO AND JNAME = ? "
				+ "            ORDER BY SUM DESC) A";

		String sql3 = "SELECT ROWNUM RANK, A.*\r\n"
				+ "    FROM (SELECT PNAME||'(' ||PNO ||'번)' PNAME, JNAME, KOR, ENG, MAT, KOR+ENG+MAT \"SUM\"\r\n"
				+ "    FROM PERSON P, JOB J\r\n" + "        WHERE P.JNO = J.JNO\r\n"
				+ "            ORDER BY SUM DESC) A";

		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");

			do {
				System.out.print("무엇을 하시겠습니까 ? (1:개인정보입력 | 2:직업별 조회 | 3:전체 조회 4: 종료) : ");
				int answer = sc.nextInt();
				switch (answer) {
				case 1:
					pstmt = conn.prepareStatement(sql1);
					System.out.print("이름을 입력하세요 : ");
					pstmt.setString(1, sc.next());
					System.out.print("직업을 입력하세요 : ");
					pstmt.setString(2, sc.next().toUpperCase());
					System.out.print("국어 점수를 입력하세요 : ");
					pstmt.setInt(3, sc.nextInt());
					System.out.print("영어 점수를 입력하세요 : ");
					pstmt.setInt(4, sc.nextInt());
					System.out.print("수학 점수를 입력하세요 : ");
					pstmt.setInt(5, sc.nextInt());
					int result = pstmt.executeUpdate();
					System.out.println(result > 0 ? "입력완료" : "입력실패");
					continue;
				case 2:
					/*
					 * 2를 누르면 원하는 직업을 입력받아 직업별 조회후 총점을 추가하여 총점이 높은 순으로 이름(번호)로 출력
					 */
					pstmt = conn.prepareStatement(sql2);

					System.out.println("직업을 입력하세요 : ");
					pstmt.setString(1, sc.next());
					rs = pstmt.executeQuery();
					if (rs.next()) {
						System.out.println("등수\t이름(번호)\t직업\t국어\t영어\t수학\t총점");
						while (rs.next()) {
							int rank = rs.getInt("rank");
							String pname = rs.getString("pname");
							String jname = rs.getString("jname");
							int kor = rs.getInt("kor");
							int eng = rs.getInt("eng");
							int mat = rs.getInt("mat");
							int sum = rs.getInt("sum");
							if(pname.length() >= 7) {
								System.out.println(rank + "\t" + pname + "\t" + jname + "\t" + kor + "\t" + eng + "\t" + mat
									+ "\t" + sum);
							} else {
								System.out.println(rank + "\t" + pname + "\t\t" + jname + "\t" + kor + "\t" + eng + "\t" + mat
										+ "\t" + sum);
							}
						}
					} else {
						System.out.println("해당 직업의 사람이 데이터베이스에 없습니다.");
					}
					continue;
				case 3:
					/*
					 * 3을 누르면 터베이스에 입력된 사람 전체를 조회 후 총점을 추가하여 총점이 높은 순으로 출력한다
					 */
					pstmt = conn.prepareStatement(sql3);
					rs = pstmt.executeQuery();
					System.out.println("전체 출력합니다.");
					System.out.println("등수\t이름(번호)\t직업\t국어\t영어\t수학\t총점");
					while (rs.next()) {
						int rank = rs.getInt("rank");
						String pname = rs.getString("pname");
						String jname = rs.getString("jname");
						int kor = rs.getInt("kor");
						int eng = rs.getInt("eng");
						int mat = rs.getInt("mat");
						int sum = rs.getInt("sum");
						if (pname.length() >= 7) {
							System.out.println(rank + "\t" + pname + "\t" + jname + "\t" + kor + "\t" + eng + "\t" + mat
									+ "\t" + sum);
						} else {
							System.out.println(rank + "\t" + pname + "\t\t" + jname + "\t" + kor + "\t" + eng + "\t"
									+ mat + "\t" + sum);
						}
					}
					continue;
				case 4:
					System.out.println("종료 되었습니다.");
					break;
				default:
					System.out.println("올바른 번호를 누르세요!");
					continue;
				}
				sc.close();
				break;

			} while (true);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}

		}

	}

}
