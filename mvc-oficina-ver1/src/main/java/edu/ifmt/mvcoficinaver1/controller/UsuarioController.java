package edu.ifmt.mvcoficinaver1.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.ifmt.mvcoficinaver1.model.usuario.Role;
import edu.ifmt.mvcoficinaver1.model.usuario.Usuario;
import edu.ifmt.mvcoficinaver1.repository.Roles;
import edu.ifmt.mvcoficinaver1.repository.Usuarios;

@Controller
public class UsuarioController {

	@Autowired
	private Usuarios users;

	@Autowired
	private Roles roles;

	public List<Usuario> getAllUsers(){
		return users.findAll();
	}
	
	@RequestMapping(path = "/user", method = RequestMethod.POST)
	public Usuario createUser(Usuario usuario) {

		List<Usuario> existsUser = users.findByloginValue(usuario.getLogin());
		List<Role> userRoles = new ArrayList<>();
		Usuario createdUser;

		// Checks if user exists // if there's more than one user with the same LoginValue(email)
		if (existsUser.isEmpty() || existsUser.size() > 1) {
			throw new Error("Usuario já cadastrado.");
		} else {

			createdUser = existsUser.get(0);

			userRoles = roles.findAll();
			createdUser.addRole(userRoles.get(0));
			createdUser = users.save(usuario);
		}

		return createdUser;
	}
	
	@RequestMapping(path = "/role", method = RequestMethod.GET)
	public List<Role> returnAllRoles(){
		return roles.findAll();
	}

	@RequestMapping(path = "/role", method = RequestMethod.POST)
	public Role createRole(Role role) {
		return roles.save(role);
	}

}
