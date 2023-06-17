package edu.ifmt.mvcoficinaver1.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.ifmt.mvcoficinaver1.model.Aluno;
import edu.ifmt.mvcoficinaver1.model.Atividade;
import edu.ifmt.mvcoficinaver1.model.StatusAtividade;
import edu.ifmt.mvcoficinaver1.model.TipoAtividade;
import edu.ifmt.mvcoficinaver1.model.usuario.Usuario;
import edu.ifmt.mvcoficinaver1.repository.Atividades;
import edu.ifmt.mvcoficinaver1.repository.TiposAtividade;

@Controller
@RequestMapping("/atividade")
class AtividadeController {

	@Autowired
	private Atividades atividades;

	@Autowired
	private TiposAtividade tipos;

	@RequestMapping
	public ModelAndView allAtividades(Aluno a) {
		// List<Atividade> listaAtividades = atividades.findAllByAluno(a);
		List<Atividade> listaAtividades = atividades.findAll();

		List<Atividade> listaIterada = new ArrayList<>();

		for (Atividade atividade : listaAtividades) {
			if (!atividade.getStatus().equals(StatusAtividade.DELETADO)) {
				listaIterada.add(atividade);
			}
		}

		ModelAndView mv = new ModelAndView("MinhasAtividades");
		mv.addObject(new Atividade());
		mv.addObject("atividades", listaIterada);
		return mv;
	}

	@RequestMapping(path = "/novo")
	public ModelAndView novo() {
		ModelAndView mnv = new ModelAndView("CadastroAtividade");
		mnv.addObject(new Atividade());

		List<TipoAtividade> allTipos = tipos.findAll();
		mnv.addObject("tipoatividade", allTipos);

		return mnv;
	}

	@RequestMapping(path = "/{id}")
	public ModelAndView edit(@PathVariable("id") Atividade atividade) {
		ModelAndView mnv = new ModelAndView("CadastroAtividade");
		mnv.addObject("atividade", atividade);

		List<TipoAtividade> allTipos = tipos.findAll();
		mnv.addObject("tipoatividade", allTipos);

		System.out.println("\n\n\n ----- " + atividade.getDescricao_atividade());
		System.out.println(atividade.getStatus().getDescricao());

		return mnv;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView salvar(Atividade atividade) {
		System.out.println(atividade.getStatus().getDescricao());
		atividades.save(atividade);
		ModelAndView mnv = new ModelAndView("CadastroAtividade");
		mnv.addObject(new Atividade());
		mnv.addObject("mensagem", "Salvo com sucesso.");
		return mnv;
	}

	@RequestMapping(path = "/delete/{id}", method = RequestMethod.POST)
	public ModelAndView delete(@PathVariable("id") Atividade atividade) {

		System.out.println("\n\n\n" + atividade.getDescricao_atividade());

		atividade.setStatus(StatusAtividade.DELETADO);
		atividades.save(atividade);

		ModelAndView mv = new ModelAndView("redirect:/atividade");
		mv.addObject("atividade", new Atividade());
		mv.addObject(new Atividade());

		return mv;
	}

	@RequestMapping(path = "/{id}/{status}", method = RequestMethod.PUT)
	public ResponseEntity<String> updateStatus(@PathVariable(name = "id") Long id,
			@PathVariable(name = "status") String status) {

		String resposta = "Ok";
		HttpStatus hs = HttpStatus.OK; 
		StatusAtividade st = StatusAtividade.valueOf(status);

		Optional<Atividade> a = atividades.findById(id);
		a.ifPresent((Atividade ativ) -> {
			
			ativ.setStatus(st);
			atividades.save(ativ);
		});
		
		if(!a.isPresent()) {
			hs = HttpStatus.NOT_FOUND;
			resposta = "Id não encontrado";
		}

		return new ResponseEntity<>(resposta, hs);
	}

}
