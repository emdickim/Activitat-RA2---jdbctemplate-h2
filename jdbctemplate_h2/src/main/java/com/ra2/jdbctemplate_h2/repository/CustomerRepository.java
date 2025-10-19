package com.ra2.jdbctemplate_h2.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.ra2.jdbctemplate_h2.model.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CustomerRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	//RowMapper per mapejar resultats de la base de dades a objectes Customer
	private static final class CustomerRowMapper implements RowMapper<Customer> {
		@Override
		public Customer mapRow(ResultSet rs, int rowNum) throws SQLException { //mapejar cada linea de dada en el resultat
			Customer customer = new Customer();
			customer.setId(rs.getLong("id"));
			customer.setFirstName(rs.getString("f_name"));
			customer.setLastName(rs.getString("l_name"));
			return customer;
		}
	}
	
	//Crear taula Customers
	public void createTableCustomers() {
		jdbcTemplate.execute("DROP TABLE Customers if EXISTS");
		jdbcTemplate.execute("CREATE TABLE Customers (id SERIAL, f_name VARCHAR(255), L_name VARCHAR(255");
	}
	
	//inserir dades cada vegada que executem projecte (es millorará a mysql)
	public void insertSampleData() {
		jdbcTemplate.update("INSERT INTO Customers (f_name, l_name) VALUES (?, ?)", "Jhon", "Doe");
		jdbcTemplate.update("INSERT INTO Customers (f_name, l_name) VALUES (?, ?)", "Jane", "Smith");
		jdbcTemplate.update("INSERT INTO Customers (f_name, l_name) VALUES (?, ?)", "Bob", "Johnson");		
	}
	
	//Buscar dades tots els registres de customers
	public List<Customer> findAll() {
		return jdbcTemplate.query("SELECT id, fname, l_name FROM customers", new CustomerRowMapper());
	}
	
}