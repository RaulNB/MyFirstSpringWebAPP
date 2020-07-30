package com.bolsadeideas.springboot.web.app.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bolsadeideas.springboot.web.app.models.Usuario;

@Controller
@RequestMapping("/app")
public class IndexController {

	@Value(value = "${texto.indexcontroller.index.titulo}")
	private String tituloIndex;
	
	@Value(value = "${texto.indexcontroller.perfil.titulo}")
	private String tituloPerfil;
	
	@Value(value = "${texto.indexcontroller.listar.titulo}")
	private String tituloListar;
	
	@GetMapping({ "", "/", "/index", "/home" })
	public String index(Model model) {
		model.addAttribute("titulo", tituloIndex);
		return "index";
	}

	@GetMapping("/perfil")
	public String perfil(Model model) {
		Usuario usuario = new Usuario();
		usuario.setNombre("Raúl");
		usuario.setApellido("Nájera");
		usuario.setEmail("raul.nb.elda@gmail.com");

		model.addAttribute("titulo", tituloPerfil.concat(usuario.getNombre()));
		model.addAttribute("usuario", usuario);

		return "perfil";
	}

	@GetMapping("/listar")
	public String listar(Model model) {
		model.addAttribute("titulo", tituloListar);

		return "listar";
	}
	
	@ModelAttribute("usuarios")
	public List<Usuario> cargarUsuarios() {
		return Arrays.asList(
				new Usuario("Raúl", "Nájera", "raul.nb.elda@gmail.com"),
				new Usuario("Pedro", "Fernández", "pedro.ff@gmail.com"),
				new Usuario("Laura", "Jiménez", "laura.jj@gmail.com"));
	}

}
