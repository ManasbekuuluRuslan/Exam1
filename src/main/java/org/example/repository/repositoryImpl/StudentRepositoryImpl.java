package org.example.repository.repositoryImpl;

import org.example.config.Config;
import org.example.jdbc.Student;
import org.example.repository.StudentRepository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentRepositoryImpl implements StudentRepository {
    @Override
    public String createTable() {

        String sql = "create table if not exists students(" +
                "id serial primary key," +
                "student_name varchar," +
                "age int," +
                "email varchar," +
                "phone_number numeric)";
        try(Connection connection = Config
                .getConnection();
            Statement statement = connection.createStatement()){
            statement.executeUpdate(sql);
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return "Students tables is created...";
    }

    @Override
    public List<Student> getAllStudents() {
        String sql = "select * from students";
        List<Student> students = new ArrayList<>();
        try(Connection connection = Config.getConnection();
        Statement statement = connection.createStatement()){
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                 students.add(new Student(
                         resultSet.getLong("id"),
                resultSet.getString("studentName"),
                resultSet.getInt("age"),
                resultSet.getString("email"),
                resultSet.getInt("phoneNumber")));
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return students;
    }
}
