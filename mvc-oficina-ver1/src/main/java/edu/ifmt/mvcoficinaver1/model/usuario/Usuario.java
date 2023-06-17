package edu.ifmt.mvcoficinaver1.model.usuario;

import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import edu.ifmt.mvcoficinaver1.model.Aluno;

@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id_usuario;
	
	private String loginValue;
	private String senha;
	
	@ManyToMany
	private List<Role> userRoles;
	
	public void setUserWithAlunoValues(Aluno aluno) {
		this.loginValue = aluno.getEmail();
		this.senha = aluno.getSenha();
	}
	
	public Long getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(Long id_usuario) {
		this.id_usuario = id_usuario;
	}
	public String getLogin() {
		return loginValue;
	}
	public void setLogin(String login) {
		this.loginValue = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public List<Role> getUserRoles() {
		return userRoles;
	}
	public void setUserRoles(List<Role> userRoles) {
		this.userRoles = userRoles;
	}
	
	public void addRole(Role role) {
		this.userRoles.add(role);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id_usuario, loginValue, senha, userRoles);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(id_usuario, other.id_usuario) && Objects.equals(loginValue, other.loginValue)
				&& Objects.equals(senha, other.senha) && Objects.equals(userRoles, other.userRoles);
	}
	
}
