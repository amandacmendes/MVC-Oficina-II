package edu.ifmt.mvcoficinaver1.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class TipoAtividade {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tipo_atividade_sequence")
	@SequenceGenerator(name = "tipo_atividade_sequence", sequenceName = "tipo_atividade_sequence", allocationSize = 1, initialValue= 1)
	private Long id_tipo_atividade;
	private String descricao;
	private String status;

	public Long getId_tipo_atividade() {
		return id_tipo_atividade;
	}

	public void setId_tipo_atividade(Long id_tipo_atividade) {
		this.id_tipo_atividade = id_tipo_atividade;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		return Objects.hash(descricao, id_tipo_atividade, status);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TipoAtividade other = (TipoAtividade) obj;
		return Objects.equals(descricao, other.descricao) && Objects.equals(id_tipo_atividade, other.id_tipo_atividade)
				&& Objects.equals(status, other.status);
	}

}
