/**
 * Created by lukir on 17.12.16.
 */
import java.sql.Statement;
import java.sql.SQLException;

public class User {
    static String __table__ = "USERS";
    public static Statement statement;
    int ID;
    String Name;
    String Password;
    double x;//position
    double y;

    public User(int ID, String Name, String Password, double x, double y){
        this.ID = ID;
        this.Name = Name;
        this.Password = Password;
        this.x = x;
        this.y = y;
        try {
            this.statement.execute("CREATE TABLE IF NOT EXISTS USERS (ID INTEGER PRIMARY KEY, Name VARCHAR(40), Password VARCHAR(40), x FLOAT(8,4), y FLOAT(8,4));");
        }catch(SQLException e){
            System.err.println(e);
        }
    }

    String convertToString() {
        return "'"+this.ID+"', '"+this.Name +"', '"+ this.Password + "', '"+this.x+ "', '"+this.y+"'";
    }

    void insert(){
        try {
            this.statement.execute("INSERT INTO " + this.__table__ + " VALUES(" + this.convertToString() + ");");
        }catch(SQLException e){
            System.err.println(e);
        }
    }

//    public static User getUserFromDatabase(String name,String password){
//        User u = User.statement.executeQuery("SELECT * FROM "+User.__table__+" WHERE Name = "+name+", Password = "+password);
//        return u;
//    }

    public static void main(String[] args) {
        User u1 = new User(100, "name", "pass", 2, 3);
        System.out.println(u1.convertToString());
    }
}