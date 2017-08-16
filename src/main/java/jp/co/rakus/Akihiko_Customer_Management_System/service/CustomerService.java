package jp.co.rakus.Akihiko_Customer_Management_System.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.rakus.Akihiko_Customer_Management_System.domain.Customer;
import jp.co.rakus.Akihiko_Customer_Management_System.repository.CustomerRepository;

@Service
@Transactional
public class CustomerService {

	@Autowired
	CustomerRepository repository;

	/**
	 * 1件検索
	 * 
	 * @param id
	 * @return
	 */
	public Customer findById(Integer id) {
		return repository.findById(id);
	}

	/**
	 * 全件検索
	 * 
	 * @return
	 */
	public List<Customer> findAll() {
		return repository.findAll();
	}

	/**
	 * Insert及びUpdateメソッド
	 * 
	 * @param customer
	 */
	public void save(Customer customer) {
		repository.save(customer);
	}

	/**
	 * １件削除メソッド
	 * 
	 * @param id
	 */
	public void delete(Integer id) {
		repository.delete(id);
	}
}
