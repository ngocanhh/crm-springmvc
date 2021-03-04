package com.myclass.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "fullname")
	private String fullName;
	
	@Column(name = "avatar")
	private String avatar;
	
	@Column(name = "role_id")
	private int roleId;
	
	@ManyToOne() // nếu để chế độ LAZY thì ko lấy được thông tin của role
	@JoinColumn(name = "role_id", insertable=false, updatable=false)
	private Role role;
	
	@OneToMany(mappedBy = "createUser", fetch = FetchType.LAZY)
	private List<Project> projects;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<Task> tasksImpl;
	
	@OneToMany(mappedBy = "createUser", fetch = FetchType.LAZY)
	private List<Task> tasksManager;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	
}
