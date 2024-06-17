package com.api.sx.view.initial;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/initializer")
public class ControllerInitial {
	@GetMapping("/")
	public String init() {
		return "<h1> Seja bem vindo a ShooesExperience </h1>";
	}
	
}