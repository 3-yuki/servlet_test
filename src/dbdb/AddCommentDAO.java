
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddCommentDAO {

    // DBにid,name,commentを加えるメソッド
    public AddCommentDAO(Board bo) {
		Connection con = null;
		PreparedStatement ps = null;

        if(bo.getName().isEmpty()) {
            bo.setName( "名無し");
        }
        if(bo.getComment().isEmpty()) {
            bo.setComment( "コメント無し");
        }

        final String url = "jdbc:mysql://localhost:3306/DB_keiji?serverTimezone=JST";
        final String user = "root";
        final String pw = "****";


        try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			//データベースと接続する(コネクションを取ってくる)
			//第1引数→接続先URL
			//第2引数→ユーザ名
			//第3引数→パスワード
			con = DriverManager.getConnection(url, user, pw);

            System.out.println("Connected....");

            try {

    			String sql = "INSERT INTO keiji(name,mail,naiyo) VALUES(?,?,?)";
    			ps = con.prepareStatement(sql);

    			ps = con.prepareStatement(sql);


                ps.setString(1, bo.getName());
                ps.setString(2, bo.getMail());
                ps.setString(3, bo.getComment());

                // ひな形を送信
                int r = ps.executeUpdate();

                if (r != 0) {
                    System.out.println(r + "件の書き込みを追加しました。");
                } else {
                    System.out.println("書き込みできませんでした。");
                }

                ps.close();

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                // データベース接続の切断
                if (con != null) {
                    try {
                        con.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (SQLException | ClassNotFoundException e) {

            e.printStackTrace();
            System.out.println("Connection Failed.");

        }

    }

}
