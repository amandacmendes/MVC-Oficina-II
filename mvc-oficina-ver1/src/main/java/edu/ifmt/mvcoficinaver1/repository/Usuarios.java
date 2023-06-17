package edu.ifmt.mvcoficinaver1.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.ifmt.mvcoficinaver1.model.usuario.Usuario;

public interface Usuarios extends JpaRepository<Usuario, Long>{
	
	public List<Usuario> findByloginValue(String loginValue);
	
}
