package edu.ifmt.mvcoficinaver1.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;



@Entity
public class Atividade {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "atividade_sequence")
	@SequenceGenerator(name="atividade_sequence", sequenceName = "atividade_sequence", allocationSize = 1, initialValue= 1)
	private Long id_ativ_complementar;
	
	private String descricao_atividade;
	private int carga_horaria;
	private String instituicao;

	@Column(columnDefinition = "int4 default 2023")
	private int ano_conclusao;
	private String observacao;

	@Column(columnDefinition = "varchar(30) default 'PENDENTE' ")
	private StatusAtividade status;
	
	@ManyToOne
	private Aluno aluno;
	
	@ManyToOne
	private Avaliador avaliador;
	
	@ManyToOne
	private TipoAtividade tipo_atividade;
	
	
	public Long getId_ativ_complementar() {
		return id_ativ_complementar;
	}
	public void setId_ativ_complementar(Long id_ativ_complementar) {
		this.id_ativ_complementar = id_ativ_complementar;
	}
	
	public String getDescricao_atividade() {
		return descricao_atividade;
	}
	public void setDescricao_atividade(String descricao_atividade) {
		this.descricao_atividade = descricao_atividade;
	}
	
	public int getCarga_horaria() {
		return carga_horaria;
	}
	public void setCarga_horaria(int carga_horaria) {
		this.carga_horaria = carga_horaria;
	}
	
	public String getInstituicao() {
		return instituicao;
	}
	public void setInstituicao(String instituicao) {
		this.instituicao = instituicao;
	}
	
	public int getAno_conclusao() {
		return ano_conclusao;
	}
	public void setAno_conclusao(int ano_conclusao) {
		this.ano_conclusao = ano_conclusao;
	}
	
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	
	public StatusAtividade getStatus() {
		return status;
	}
	public void setStatus(StatusAtividade status) {
		this.status = status;
	}
	
	public Avaliador getAvaliador() {
		return avaliador;
	}
	public void setAvaliador(Avaliador avaliador) {
		this.avaliador = avaliador;
	}
	
	public Aluno getAluno() {
		return aluno;
	}
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public TipoAtividade getTipo_atividade() {
		return tipo_atividade;
	}
	public void setTipo_atividade(TipoAtividade tipo_atividade) {
		this.tipo_atividade = tipo_atividade;
	}

	@Override
	public int hashCode() {
		return Objects.hash(aluno, ano_conclusao, avaliador, carga_horaria, descricao_atividade, id_ativ_complementar,
				instituicao, observacao, status, tipo_atividade);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Atividade other = (Atividade) obj;
		return Objects.equals(aluno, other.aluno) && ano_conclusao == other.ano_conclusao
				&& Objects.equals(avaliador, other.avaliador) && carga_horaria == other.carga_horaria
				&& Objects.equals(descricao_atividade, other.descricao_atividade)
				&& Objects.equals(id_ativ_complementar, other.id_ativ_complementar)
				&& Objects.equals(instituicao, other.instituicao) && Objects.equals(observacao, other.observacao)
				&& status == other.status && Objects.equals(tipo_atividade, other.tipo_atividade);
	}

}
