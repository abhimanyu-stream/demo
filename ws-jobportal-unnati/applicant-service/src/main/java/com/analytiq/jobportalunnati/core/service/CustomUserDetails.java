package com.analytiq.jobportalunnati.core.service;


import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.analytiq.jobportalunnati.core.model.Role;
import com.analytiq.jobportalunnati.core.model.User;
import com.fasterxml.jackson.annotation.JsonIgnore;



public class CustomUserDetails implements UserDetails{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7988705266588148217L;
	/*
	 * private User user;
	 * 
	 * private List<Role> authorities = new ArrayList<>();
	 * 
	 * public CustomUserDetails(User user, List<Role> authorities) { this.user =
	 * user; this.authorities = authorities; }
	 * 
	 * @Override public Collection<? extends GrantedAuthority> getAuthorities() {
	 * List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
	 * 
	 * //Set<Role> roleSet = user.getRoles(); //roleSet.stream().map(role ->
	 * role.toString()).collect(Collectors.toList()); //Set<Role> roleSet =
	 * authorities.getName(); for (GrantedAuthority role : authorities) {
	 * authorities.add(new SimpleGrantedAuthority(role.getAuthority())); }
	 * System.out.println("Inside CustomUserDetails " + user);
	 * System.out.println("Inside CustomUserDetails " + authorities); return
	 * authorities; }
	 */

	private Long id;
	private String username;
	private String email;
	@JsonIgnore
	private String password;
	private Collection<? extends GrantedAuthority> authorities;
	//private User user;
	public CustomUserDetails() {}
	public CustomUserDetails(User user, List<Role> authorities) {}
	public CustomUserDetails(User user, Collection<? extends GrantedAuthority> authorities) {}
	public CustomUserDetails(User user) {
		
		List<GrantedAuthority> authorities = user.getRoles().stream().map(role -> new SimpleGrantedAuthority(role.getName().name())).collect(Collectors.toList());
		
		this.id = user.getId();
		this.username = user.getUsername();
		this.email = user.getEmail();
		this.password = user.getPassword();
		this.authorities = authorities;
		//this.user = user;
		
		
		
	}
	public CustomUserDetails(Long id, String username, String email, String password,
			Collection<? extends GrantedAuthority> authorities) {
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.authorities = authorities;
	}
	public static CustomUserDetails build(User user) {
		List<GrantedAuthority> authorities = user.getRoles().stream().map(role -> new SimpleGrantedAuthority(role.getName().name())).collect(Collectors.toList());
		return new CustomUserDetails(user.getId(), user.getUsername(), user.getEmail(),user.getPassword(), authorities);
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}
	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
	}
	public long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public boolean isAccountNonExpired() {
		
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		
		return true;
	}
	@Override
	public boolean isEnabled() {
		
		return true;
	}
	
	
	

}
