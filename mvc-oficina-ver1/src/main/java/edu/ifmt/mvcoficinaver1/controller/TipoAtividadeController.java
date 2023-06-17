package edu.ifmt.mvcoficinaver1.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.ifmt.mvcoficinaver1.model.TipoAtividade;
import edu.ifmt.mvcoficinaver1.repository.TiposAtividade;

@Controller
public class TipoAtividadeController {

	@Autowired
	private TiposAtividade tipos;

	@RequestMapping
	public ModelAndView getAllTiposAtividade() {
		List<TipoAtividade> allTipos = tipos.findAll();
		ModelAndView mnv = new ModelAndView("PesquisaTipoAtividade");
		mnv.addObject("listatipoatividade", allTipos);
		return mnv;
	}

	@RequestMapping(path = "/tipoatividade")
	public ModelAndView listAllTipos() {
		List<TipoAtividade> allTipos = tipos.findAll();
		List<TipoAtividade> iterableTipos = new ArrayList<>();

		for (TipoAtividade tipoAtividade : allTipos) {
			if (tipoAtividade.getStatus().equals("ACTIVE")) {
				iterableTipos.add(tipoAtividade);
			}
		}

		ModelAndView mnv = new ModelAndView("TipoAtividade");
		mnv.addObject("listatipoatividade", iterableTipos);
		// mnv.addObject(new TipoAtividade());
		mnv.addObject("tipo", new TipoAtividade());
		return mnv;
	}

	@RequestMapping(path = "/tipoatividade/novo")
	public ModelAndView cadastroTipoPage() {
		ModelAndView mnv = new ModelAndView("CadastroTipoAtividade");
		mnv.addObject("tipo", new TipoAtividade());
		return mnv;
	}

	@RequestMapping(path = "/tipoatividade/novo", method = RequestMethod.POST)
	public ModelAndView addTipo(TipoAtividade tipo) {
		tipos.save(tipo);
		ModelAndView mnv = new ModelAndView("CadastroTipoAtividade");
		mnv.addObject("tipo", new TipoAtividade());

		if (tipo.getId_tipo_atividade() != null) {
			mnv.addObject("mensagem", "Tipo de atividade atualizado com sucesso.");
		} else {
			mnv.addObject("mensagem", "Novo tipo de atividade cadastrado com sucesso.");
		}

		return mnv;
	}

	@RequestMapping(path = "/tipoatividade/{id}")
	public ModelAndView editTipo(@PathVariable("id") TipoAtividade tipoAtividade) {

		ModelAndView mnv = new ModelAndView("CadastroTipoAtividade");
		mnv.addObject("tipo", tipoAtividade);
		return mnv;
	}

	@RequestMapping(path = "/tipoatividade/delete/{id}", method = RequestMethod.POST)
	public ModelAndView deleteTipo(@PathVariable("id") TipoAtividade tipoAtividade) {
		tipoAtividade.setStatus("INACTIVE");
		tipos.save(tipoAtividade);

		ModelAndView mnv = new ModelAndView("redirect:/tipoatividade");
		//mnv.addObject("mensagem", "Tipo de atividade excluido com sucesso.");
		mnv.addObject("tipo", new TipoAtividade());

		return mnv;
	}

}
