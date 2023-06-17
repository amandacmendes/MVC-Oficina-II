package edu.ifmt.mvcoficinaver1.model;

public enum StatusAtividade {

	PENDENTE("Pendente"), DEFERIDO("Deferido"), INDEFERIDO("Indeferido"), DELETADO("Deletado");

	private String descricao;

	private StatusAtividade(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}
