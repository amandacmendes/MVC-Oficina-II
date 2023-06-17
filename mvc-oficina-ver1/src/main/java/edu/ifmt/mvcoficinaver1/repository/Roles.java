package edu.ifmt.mvcoficinaver1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.ifmt.mvcoficinaver1.model.usuario.Role;

public interface Roles extends JpaRepository<Role, Long> {

}
