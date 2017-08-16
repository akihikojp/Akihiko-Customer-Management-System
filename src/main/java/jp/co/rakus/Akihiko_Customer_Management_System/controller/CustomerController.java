package jp.co.rakus.Akihiko_Customer_Management_System.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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
	 * 1件検索をしたのち、編集jspへフォワード
	 * 
	 * @return 編集jspへフォワード
	 */
	@RequestMapping("/rename")
	public String rename(Integer id, Model model) {
		Customer renameCustomer = service.load(id);
		model.addAttribute("renameCustomer", renameCustomer);
		return "rename";
	}

	/**
	 * 作成および更新後の初期画面の表示
	 * 
	 * @param customer
	 * @param model
	 * @return
	 */
	@RequestMapping("/save")
	public String save(@Validated CustomerForm form, BindingResult result, Model model) {

		if (result.hasErrors()) {
			return "redirect:/";
		}

		Customer customer = new Customer();
		customer.setFirstName(form.getFirstName());
		customer.setLastName(form.getLastName());
		service.save(customer);
		return "redirect:/";
	}

	/**
	 * 1件削除メソッド
	 * 
	 * @param id
	 * @param model
	 * @return 削除後に全件表示
	 */
	@RequestMapping("/delete")
	public String delete(Integer id, Model model) {
		service.delete(id);
		return "redirect:/";
	}

}
