package jp.co.rakus.Akihiko_Customer_Management_System.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import jp.co.rakus.Akihiko_Customer_Management_System.domain.Customer;

@Repository
public class CustomerRepository {

	@Autowired
	NamedParameterJdbcTemplate template;

	private static final RowMapper<Customer> customerRowMapper = (rs, i) -> {
		Customer customer = new Customer();
		customer.setId(rs.getInt("id"));
		customer.setFirstName(rs.getString("first_name"));
		customer.setLastName(rs.getString("last_name"));
		return customer;
	};

	/**
	 * idで1件検索
	 * @param id
	 * @return 検索結果
	 */
	public Customer findById(Integer id) {
		String sql = "SELECT id, first_name, last_name FROM customers WHERE id = :id;";
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
		Customer customer = template.queryForObject(sql, param, customerRowMapper);
		return customer;

	}

}