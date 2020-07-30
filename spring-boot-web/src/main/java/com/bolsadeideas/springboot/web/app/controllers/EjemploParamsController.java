package com.bolsadeideas.springboot.web.app.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/params")
public class EjemploParamsController {
	
	@GetMapping("/")
	public String index() {
		return "params/index";
	}

	@GetMapping("/string")
	public String param(@RequestParam(required = false, defaultValue = "") String texto, Model model) {
		model.addAttribute("resultado", "El texto es: ".concat(texto));
		return "params/ver";
	}
	
	@GetMapping("/mix-params")
	public String param(@RequestParam String saludo, @RequestParam int numero, Model model) {
		model.addAttribute("resultado", "El saludo es: '" + saludo + "' y el número es " + numero);
		return "params/ver";
	}
	
	@GetMapping("/mix-params-req")
	public String param(HttpServletRequest request, Model model) {
		String saludo = request.getParameter("saludo");
		int numero;
		try {
			numero = Integer.parseInt(request.getParameter("numero"));
		} catch (NumberFormatException e) {
			numero = 0;
		}
		model.addAttribute("resultado", "El saludo es: '" + saludo + "' y el número es " + numero);
		return "params/ver";
	}
}
