package edu.ifmt.mvcoficinaver1.model.usuario;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Role {

	@Id
	@GeneratedValue
	private UUID id;
	
	private String name;

	public Role(UUID id) {
		this.id = id;
	}
}
