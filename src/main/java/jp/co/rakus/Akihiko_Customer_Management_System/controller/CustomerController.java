package jp.co.rakus.Akihiko_Customer_Management_System.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.rakus.Akihiko_Customer_Management_System.domain.Customer;
import jp.co.rakus.Akihiko_Customer_Management_System.service.CustomerService;

@Controller
@RequestMapping("")
public class CustomerController {

	@Autowired
	CustomerService service;

	@ModelAttribute
	public CustomerForm setUpForm() {
		return new CustomerForm();
	}

	/**
	 * 初期画面表示(全件検索後)
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/")
	public String index(Model model) {
		List<Customer> customerList = service.findAll();
		model.addAttribute("customerList", customerList);
		return "manage";
	}

	/**
	 * 作成および更新後の初期画面の表示
	 * @param customer
	 * @param model
	 * @return
	 */
	@RequestMapping("/save")
	public String save(Customer customer, Model model) {
		service.save(customer);
		return "redirect:/";

	}

}
