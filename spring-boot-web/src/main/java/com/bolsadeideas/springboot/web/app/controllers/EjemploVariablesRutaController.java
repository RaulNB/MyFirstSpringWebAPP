package com.bolsadeideas.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/variables")
public class EjemploVariablesRutaController {

	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("titulo", "Enviar parámetros variables");
		return "variables/index";
	}
	
	@GetMapping("/var/{texto}")
	public String variables(@PathVariable String texto, Model model) {
		model.addAttribute("titulo", "Recibir parámetro de la ruta (@PathVariable)");
		model.addAttribute("resultado", "El texto enviado en la ruta es: " + texto);
		return "variables/ver";
	}
	
	@GetMapping("/var/{texto}/{numero}")
	public String variables(@PathVariable String texto, @PathVariable int numero, Model model) {
		model.addAttribute("titulo", "Recibir varios parámetros de la ruta (@PathVariable)");
		model.addAttribute("resultado", "El texto es '" + texto + "' y el número es " + numero);
		return "variables/ver";
	}
	
}
