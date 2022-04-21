package com.lec.ex1selectall;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

public class SelectAllOracle {
	// ����Ŭ�� MySQL �� driver�� url�� �ٸ��� �� �Ȱ���.
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Connection conn = null; // DB ���� ��ü ����
		Statement stmt = null; // SQL ���� ��ü ����
		ResultSet rs = null; // SELECT�� ��� �޴� ��ü ���� select �������� ���
		// select�� - ����� ������
		// insert, update, delete�� - ����� ����
		String query = "SELECT * FROM EMP";
		try {
			// (1) ����̹� �ε� 
			Class.forName(driver);
			// (2) DB ����
			conn = DriverManager.getConnection(url, "scott", "tiger");
			//  (3)SQL�� ���� ��ü ����
			stmt = conn.createStatement();  
			// (4) SQL ���� + (5) rs�� SQL���� ��� �ޱ�
			rs = stmt.executeQuery(query);
			// (6) ��� �޾� ���ϴ� ���� ����
			System.out.println("���\t�̸�\t��å\t\t�����\t�Ի���\t�޿�\t��\t�μ���ȣ");
			while(rs.next()) {   // rs.next() : ���� ���� �޾ƿ��ٰ� ���� �Ǽ� ������ �޾ƿð��� ������ false return;
				//  rs.getInt("����") ���� ���̺��� Ÿ��Ʋ�� ���°�
				//  rs.getString("����") �� ��������
				int empno = rs.getInt("empno");  // ���������� �������� 
				//String empno = rs.getString("empno"); // ���ڿ��� �������� 
				String ename = rs.getString("ename");  // varchar2 �� String���� �ޱ�
				String job = rs.getString("job");
				int mgr = rs.getInt("mgr");
//				String hiredate = rs.getString("hiredate");  // date���� date�� �޾Ƶ��ǰ� ���ڿ��� �޾Ƶ��ǰ� Timestamp�� �޾Ƶ���
				Date hiredate = rs.getDate("hiredate");   // import sql�� �ϱ�
//				Timestamp hiredate = rs.getTimestamp("hiredate");  // import sql�� �ϱ�
				int sal = rs.getInt("sal");
				int comm = rs.getInt("comm");
				int deptno = rs.getInt("deptno");			
				if(job.length() < 8) {
					System.out.println(empno+"\t"+ename+"\t"+job+"\t\t"+mgr+"\t"+hiredate+"\t"+sal+"\t"+comm+"\t"+deptno);
//					System.out.printf("%d\t%s\t%s\t\t%d\t%TF\t%d\t%d\t%d\n",
//					empno,ename,job,mgr,hiredate,sal,comm,deptno);
				} else {
					System.out.println(empno+"\t"+ename+"\t"+job+"\t"+mgr+"\t"+hiredate+"\t"+sal+"\t"+comm+"\t"+deptno);
//					System.out.printf("%d \t %s \t %s \t %d \t %TF \t %d \t %d \t %d\n",
//					empno,ename,job,mgr,hiredate,sal,comm,deptno);
					
				}

			}
		} catch (ClassNotFoundException e ) {
			System.out.println(e.getMessage()); // driver �ε� ����
		} catch (SQLException e) {
			System.out.println(e.getMessage()); // DB ���� ����
		} finally {
			// (7) ��������
			try {        //  �����Ҷ� ������� �ݴ��  
				// ������� : conn > stmt > rs
				// �ݴ¼��� : rs > stmt > conn 
				if (rs != null) {
					rs.close();
				}
				if( stmt != null) {
					stmt.close();
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
