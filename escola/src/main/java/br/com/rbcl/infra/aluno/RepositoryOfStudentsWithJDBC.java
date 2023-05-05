package br.com.rbcl.infra.aluno;

import br.com.rbcl.domain.aluno.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RepositoryOfStudentsWithJDBC implements RepositoryOfStudents {
    private final Connection connection;

    public RepositoryOfStudentsWithJDBC(Connection connection){
        this.connection = connection;
    }
    public void register(Student student) {
        String sql = "INSERT INTO STUDENT VALUES(?, ?, ?)";
        try {
            PreparedStatement ps = connection.prepareStatement((sql));
            ps.setString(1, student.getCpf());
            ps.setString(2, student.getName());
            ps.setString(3, student.getEmail());
            ps.execute();

            sql="INSERT INTO PHONES VALUES(?)";
            ps = connection.prepareStatement(sql);
            for (Phone phone: student.getPhones()) {
                ps.setString(1, phone.getNumber());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Student searchByCPF(CPF cpf) {
        try {
            String sql = "SELECT id, name, email FROM STUDENT WHERE cpf = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, cpf.getNumber());

            ResultSet rs = ps.executeQuery();
            boolean finded = rs.next();
            if (!finded) {
                throw new StudentNotFound(cpf);
            }

            String name = rs.getString("name");
            Email email = new Email(rs.getString("email"));
            Student found = new Student(cpf, name, email);

            Long id = rs.getLong("id");
            sql = "SELECT number FROM PHONES WHERE student_id = ?";
            ps = connection.prepareStatement(sql);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                String number = rs.getString("number");
                found.addPhone(new Phone(number));
            }

            return found;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Student> listAllRegisteredStudents() {
        try {
            String sql = "SELECT id, cpf, name, email FROM STUDENT";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Student> students = new ArrayList<Student>();
            while (rs.next()) {
                CPF cpf = new CPF(rs.getString("cpf"));
                String name = rs.getString("name");
                Email email = new Email(rs.getString("email"));
                Student student = new Student(cpf, name, email);

                Long id = rs.getLong("id");
                sql = "SELECT number FROM PHONES WHERE student_id = ?";
                PreparedStatement psPhone = connection.prepareStatement(sql);
                psPhone.setLong(1, id);
                ResultSet rsPhone = psPhone.executeQuery();
                while (rsPhone.next()) {
                    String number = rsPhone.getString("number");
                    student.addPhone(new Phone(number));
                }

                students.add(student);
            }

            return students;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
