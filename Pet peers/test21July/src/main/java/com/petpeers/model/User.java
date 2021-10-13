package com.petpeers.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({ @NamedQuery(name = "findUserByUsername", query = "from User u where u.userName = :userName") })
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	@Column(unique = true)
	private String userName;
	private String userPassword;
	private String confirmPassword;

	

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		System.out.println("SSSSSSSSSSSSSSSSSSSSSS");
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public String toString() {
		return "Signup [userId=" + userId + ", userName=" + userName + ", userPassword=" + userPassword
				+ ", confirmPassword=" + confirmPassword + "]";
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

}
