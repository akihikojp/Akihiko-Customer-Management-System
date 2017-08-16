package jp.co.rakus.Akihiko_Customer_Management_System.controller;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 顧客管理リストのフォーム
 * 
 * @author akihiko.yahiro
 *
 */
public class CustomerForm {
	/** id */
	private String id;
	/** 姓 */
	@NotBlank(message="姓を入力してください")
	private String firstName;
	/** 名 */
	@NotBlank(message="名を入力してください")
	private String lastName;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
