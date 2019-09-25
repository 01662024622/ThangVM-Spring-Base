package edu.topica.DAO;

import java.sql.SQLException;

import edu.topica.DAO.abstracts.IDAO;
import edu.topica.entity.Student;

public class StudentDAO extends IDAO<Student> {

	public StudentDAO() throws ClassNotFoundException, SQLException {
		super(Student.class);
		// TODO Auto-generated constructor stub
	}

}
