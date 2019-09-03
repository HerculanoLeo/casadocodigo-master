package br.com.casadocodigo.loja.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.casadocodigo.loja.dao.RoleDAO;
import br.com.casadocodigo.loja.dao.UsuarioDAO;
import br.com.casadocodigo.loja.models.Usuario;
import br.com.casadocodigo.loja.validation.UsuarioValidation;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioDAO usuarioDAO;

	@Autowired
	private RoleDAO roleDAO;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(new UsuarioValidation());
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView cadastraUsuario(@Valid Usuario usuario, BindingResult result,
			RedirectAttributes redirectAttributes) {

		if (result.hasErrors()) {
			return form(usuario);
		}
		if (usuarioDAO.testaEmail(usuario.getEmail())) {
			return form(usuario, "Erro: E-mail já Cadastrado!");
		}
		usuario.encriptaSenha();
		usuarioDAO.gravar(usuario);
		redirectAttributes.addFlashAttribute("message", "Usuario cadastrado com sucesso");
		return new ModelAndView("redirect:/usuarios");
	}

	@RequestMapping("/formUsuario")
	private ModelAndView form(Usuario usuario) {
		ModelAndView modelAndView = new ModelAndView("usuarios/formUsuario");
		return modelAndView;
	}

	private ModelAndView form(Usuario usuario, String message) {
		ModelAndView modelAndView = new ModelAndView("usuarios/formUsuario");
		modelAndView.addObject("message", message);
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.GET)
	private ModelAndView listarUsuario() {
		ModelAndView modelAndView = new ModelAndView("usuarios/listaUsuario");
		modelAndView.addObject("usuarios", usuarioDAO.listarUsuarios());
		return modelAndView;
	}

	@RequestMapping("/deletar")
	public ModelAndView deletar(String email) {
		ModelAndView modelAndView = new ModelAndView("redirect:/usuarios");
		usuarioDAO.deletar(email);
		return modelAndView;
	}

	@RequestMapping("/adicionarRole")
	public ModelAndView adicionarRole(String email) {
		ModelAndView modelAndView = new ModelAndView("usuarios/adicionarRole");
		modelAndView.addObject("usuario", usuarioDAO.buscaEmail(email));
		modelAndView.addObject("listaRole" ,roleDAO.listarRole());
		return modelAndView;
	}
	
	@RequestMapping("/atualizarRole")
	public ModelAndView atualizarRole(Usuario usuarioDoFormulario, RedirectAttributes redirectAttributes) {
		Usuario usuarioParaPersistir = usuarioDAO.buscaEmail(usuarioDoFormulario.getEmail());
		usuarioParaPersistir.setRoles(usuarioDoFormulario.getRoles());
		usuarioDAO.gravar(usuarioParaPersistir);
		redirectAttributes.addFlashAttribute("message", "Permissões alteradas com sucesso");
		return new ModelAndView("redirect:/usuarios");
	}
	
}
