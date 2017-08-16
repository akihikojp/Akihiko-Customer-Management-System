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
	 * @param model
	 * @return
	 */
	@RequestMapping("/")
	public String index(Model model) {
		List<Customer> customerList = service.findAll();
		model.addAttribute("customerList", customerList);
		return "manage";
	}

}
