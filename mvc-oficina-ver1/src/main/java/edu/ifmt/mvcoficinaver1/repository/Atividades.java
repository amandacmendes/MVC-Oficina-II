package edu.ifmt.mvcoficinaver1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.ifmt.mvcoficinaver1.model.Aluno;
import edu.ifmt.mvcoficinaver1.model.Atividade;

public interface Atividades extends JpaRepository<Atividade, Long> {
	
	List<Atividade> findAllByAluno(Aluno aluno);

}
