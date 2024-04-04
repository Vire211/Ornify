package ornify;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLDatabase
{
  public SQLDatabase() {
    try {
    Connection con = DriverManager.getConnection("jdbc:mysql://new", "root", "root");
    Statement st = con.createStatement();
    String query = "select * from login";
    ResultSet rs = st.executeQuery(query);
    while(rs.next()) {
      System.out.println(rs.getString(1)+" "+rs.getString(2));
    }
    con.close();
  } catch (SQLException e) {
    System.out.println("SQL Error");
  } catch (Exception e) {
    e.printStackTrace();
  }
  }
}
