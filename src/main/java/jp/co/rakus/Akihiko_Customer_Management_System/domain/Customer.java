package jp.co.rakus.Akihiko_Customer_Management_System.domain;

/**
 * 顧客管理リストのクラス
 * 
 * @author akihiko.yahiro
 *
 */
public class Customer {
	/** id */
	private Integer id;
	/** 姓 */
	private String firstName;
	/** 名 */
	private String lastName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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
