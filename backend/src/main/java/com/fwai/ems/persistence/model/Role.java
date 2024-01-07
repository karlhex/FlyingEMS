package com.fwai.ems.persistence.model;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.CascadeType;

/**
 * Role
 */
@Entity
@Data
@NoArgsConstructor
@Table(name = "roles")
public class Role {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer id;

		private String name;
		private String description;

		@ManyToOne(cascade = CascadeType.ALL)
		@JoinColumn(name = "user_id")
		private User user;
}
