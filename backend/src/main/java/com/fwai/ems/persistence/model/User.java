package com.fwai.ems.persistence.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.GenerationType;
import jakarta.persistence.FetchType;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;

@Entity
@Table(name = "users")
@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor
public class User implements UserDetails{
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer id;

		private String name;
		private String password;
		@Column(unique = true)
		private String email;
		private String description;
		
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
				List<GrantedAuthority> authorities
						= new ArrayList<>();
        for (Role role: roles) {
						authorities.add(new SimpleGrantedAuthority(role.getName()));
				}
				return authorities;
    }

		@OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
		private List<Role> roles;

		@Override
		public String getUsername() {
				return email;
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
