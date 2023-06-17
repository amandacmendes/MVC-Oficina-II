package edu.ifmt.mvcoficinaver1.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Avaliador {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "avaliador_sequence")
	@SequenceGenerator(name="avaliador_sequence", sequenceName = "avaliador_sequence", allocationSize = 1, initialValue= 1)
	private Long id_avaliador;
	
	private String nome;
	
	
	public Long getId_avaliador() {
		return id_avaliador;
	}
	public void setId_avaliador(Long id_avaliador) {
		this.id_avaliador = id_avaliador;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id_avaliador, nome);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Avaliador other = (Avaliador) obj;
		return Objects.equals(id_avaliador, other.id_avaliador) && Objects.equals(nome, other.nome);
	}
	
}
