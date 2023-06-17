package edu.ifmt.mvcoficinaver1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.ifmt.mvcoficinaver1.model.Aluno;
import edu.ifmt.mvcoficinaver1.model.Atividade;
import edu.ifmt.mvcoficinaver1.model.usuario.Usuario;
import edu.ifmt.mvcoficinaver1.repository.Alunos;
import edu.ifmt.mvcoficinaver1.repository.Usuarios;

@Controller
public class AlunoController {

	@Autowired
	Alunos alunos;

	UsuarioController uc = new UsuarioController();

	@Autowired
	Usuarios usuarios;

	@RequestMapping("/login")
	public ModelAndView loginPage() {
		ModelAndView mnv = new ModelAndView("Login");
		return mnv;
	}

	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public String entrar(String email, String senha, RedirectAttributes attributes) {

		Aluno a = null;

		ModelAndView mv = null;

		List<Aluno> foundAluno = alunos.findByEmail(email);
		if (foundAluno.size() > 0) {
			a = foundAluno.get(0);
			if (passwordEncoder().matches(senha, a.getSenha())) {

				attributes.addFlashAttribute("mensagem", "Realizando login...");
				return "redirect:/atividade";

				// mv = new ModelAndView("MinhasAtividades");
				// mv.addObject(a);
			} else {

				attributes.addFlashAttribute("mensagem", "E-mail ou senha incorretos.");
				return "redirect:/login";

				// mv = loginPage();
				// mv.addObject("mensagem", "E-mail ou senha incorretos.");
			}
		} else {
			attributes.addFlashAttribute("mensagem", "Aluno não encontrado.");
			return "redirect:/login";

			// mv = loginPage();
			// mv.addObject("mensagem", "Aluno não encontrado.");
		}

		// return mv;
	}

	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@RequestMapping(path = "/n/aluno", method = RequestMethod.POST)
	public ModelAndView createAluno(Aluno aluno) {
		String encryptSenha = passwordEncoder().encode(aluno.getSenha());
		aluno.setSenha(encryptSenha);
		alunos.save(aluno);
		ModelAndView mv = new ModelAndView("CadastroAluno");
		mv.addObject("mensagem", "Aluno cadastrado com sucesso");
		return mv;
	}

	@RequestMapping(path = "/create/aluno", method = RequestMethod.POST)
	public ResponseEntity<String> createAlunoJSON(@RequestBody Aluno aluno) {

		String encryptSenha = passwordEncoder().encode(aluno.getSenha());
		aluno.setSenha(encryptSenha);
		Aluno createdAluno = alunos.save(aluno);

		Usuario user = new Usuario();
		user.setUserWithAlunoValues(createdAluno);
		usuarios.save(user);
		
		return new ResponseEntity<>("Salvo.", HttpStatus.OK);

	}

	@RequestMapping(path = "/aluno", method = RequestMethod.GET)
	public List<Aluno> getAllAlunos() {

		System.out.println("\n\n\n  AAAAAA ");
		List<Aluno> listAlunos = alunos.findAll();
		return listAlunos;
		
	}
	

}
