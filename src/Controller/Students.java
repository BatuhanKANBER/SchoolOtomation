package Controller;
import Database.DbConnecter;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Students {
    private Statement statement = null;
    private String query = null;
    private DbConnecter dbConnecter;

    public Students() throws SQLException{
        dbConnecter = new DbConnecter();
        statement = dbConnecter.connection.createStatement();
    }
    public void listStudents(){
        query = "SELECT * FROM students";

        try {
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                int student_id = resultSet.getInt("student_id");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                Date birthday = resultSet.getDate("birthday");
                String email = resultSet.getString("email");

                System.out.println("Öğrenci No: " + student_id + ", Adı: " + name + ", Soyadı: " + surname + ", Doğum Tarihi: " + birthday + ", Email: " + email);
            }
        }catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }

    public void createStudent(int student_id, String name, String surname, String birthday, String email){
        query = "INSERT INTO `students` (`student_id`, `name`, `surname`, `birthday`, `email`) VALUES ('"+ student_id +"', '"+ name +"', '"+ surname +"', '"+ birthday +"', '"+ email +"')";
        try {
            statement.executeUpdate(query);
            System.out.println(student_id + " numaralı öğrenci sisteme kaydedildi.");
        }catch (SQLException exception){
            System.out.println(exception);
        }
    }
    public void removeStudent(int student_id){
        query = "DELETE FROM students WHERE `students`.`student_id` = "+ student_id +"";
        try {
            statement.executeUpdate(query);
            System.out.println(student_id + " numaralı öğrenci sistemden kaldırıldı.");
        }catch (SQLException exception){
            System.out.println(exception);
        }
    }
    public void updateEmail(int student_id, String email){
        query = "UPDATE `students` SET `email` = '"+ email +"' WHERE `students`.`student_id` = "+ student_id +"";
        try {
            statement.executeUpdate(query);
            System.out.println(student_id + " öğrenci numaralı emaili " + email + " olarak değiştirildi.");
        }catch (SQLException exception){
            System.out.println(exception);
        }
    }
}
