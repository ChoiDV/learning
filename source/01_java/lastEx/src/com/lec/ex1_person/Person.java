package com.lec.ex1_person;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Person {
	/*
	 * 1�� ������ ������ �Է� �̸�, ����, ����, ����, ���������� �Է¹޾� ������ ���̽��� ��ȣ�� �����Ͽ� �Է��Ѵ�. ��ȣ�� ��������
	 * �̿��Ͽ� ���������� �Է��Ѵ�. �����ͺ��̽��� ������ ������ ����
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
				+ "    FROM (SELECT PNAME||'(' ||PNO ||'��)' PNAME, JNAME, KOR, ENG, MAT, KOR+ENG+MAT SUM"
				+ "    FROM PERSON P, JOB J" + "        WHERE P.JNO = J.JNO AND JNAME = ? "
				+ "            ORDER BY SUM DESC) A";

		String sql3 = "SELECT ROWNUM RANK, A.*\r\n"
				+ "    FROM (SELECT PNAME||'(' ||PNO ||'��)' PNAME, JNAME, KOR, ENG, MAT, KOR+ENG+MAT \"SUM\"\r\n"
				+ "    FROM PERSON P, JOB J\r\n" + "        WHERE P.JNO = J.JNO\r\n"
				+ "            ORDER BY SUM DESC) A";

		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");

			do {
				System.out.print("������ �Ͻðڽ��ϱ� ? (1:���������Է� | 2:������ ��ȸ | 3:��ü ��ȸ 4: ����) : ");
				int answer = sc.nextInt();
				switch (answer) {
				case 1:
					pstmt = conn.prepareStatement(sql1);
					System.out.print("�̸��� �Է��ϼ��� : ");
					pstmt.setString(1, sc.next());
					System.out.print("������ �Է��ϼ��� : ");
					pstmt.setString(2, sc.next().toUpperCase());
					System.out.print("���� ������ �Է��ϼ��� : ");
					pstmt.setInt(3, sc.nextInt());
					System.out.print("���� ������ �Է��ϼ��� : ");
					pstmt.setInt(4, sc.nextInt());
					System.out.print("���� ������ �Է��ϼ��� : ");
					pstmt.setInt(5, sc.nextInt());
					int result = pstmt.executeUpdate();
					System.out.println(result > 0 ? "�Է¿Ϸ�" : "�Է½���");
					continue;
				case 2:
					/*
					 * 2�� ������ ���ϴ� ������ �Է¹޾� ������ ��ȸ�� ������ �߰��Ͽ� ������ ���� ������ �̸�(��ȣ)�� ���
					 */
					pstmt = conn.prepareStatement(sql2);

					System.out.println("������ �Է��ϼ��� : ");
					pstmt.setString(1, sc.next());
					rs = pstmt.executeQuery();
					if (rs.next()) {
						System.out.println("���\t�̸�(��ȣ)\t����\t����\t����\t����\t����");
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
						System.out.println("�ش� ������ ����� �����ͺ��̽��� �����ϴ�.");
					}
					continue;
				case 3:
					/*
					 * 3�� ������ �ͺ��̽��� �Էµ� ��� ��ü�� ��ȸ �� ������ �߰��Ͽ� ������ ���� ������ ����Ѵ�
					 */
					pstmt = conn.prepareStatement(sql3);
					rs = pstmt.executeQuery();
					System.out.println("��ü ����մϴ�.");
					System.out.println("���\t�̸�(��ȣ)\t����\t����\t����\t����\t����");
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
					System.out.println("���� �Ǿ����ϴ�.");
					break;
				default:
					System.out.println("�ùٸ� ��ȣ�� ��������!");
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
