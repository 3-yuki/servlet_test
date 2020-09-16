package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FindCommentDAO {

    public List<Board> findcomment() {

        // id,name,commentを格納するリスト
        List<Board> list = new ArrayList<>();

        final String url = "jdbc:mysql://localhost:3306/DB_keiji?serverTimezone=JST";
        final String user = "root";
        final String pw = "****";

        Connection con = null;

        try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			//データベースと接続する(コネクションを取ってくる)
			//第1引数→接続先URL
			//第2引数→ユーザ名
			//第3引数→パスワード
			con = DriverManager.getConnection(url, user, pw);


            System.out.println("Connected....");

            try {
                Statement st = con.createStatement();
                String sql = "select * from keiji";

                try {
                    // sqlを送信
                    ResultSet rs = st.executeQuery(sql);

                    while (rs.next()) {
                        // DBから取り出したid,name,commentをJavaBeansにset
                        Board bo = new Board();
                        bo.setName(rs.getString("name"));
                        bo.setName(rs.getString("mail"));
                        bo.setComment(rs.getString("comment"));
                        bo.setTime(rs.getTimestamp("time"));

                        // リストに1個ずつ格納。末尾に要素が追加されていく。
                        list.add(bo);
                    }

                    rs.close();
                    st.close();

                } catch (SQLException e) {
                    e.printStackTrace();
                }

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
            return null;
        }
        return list;

    }

}

