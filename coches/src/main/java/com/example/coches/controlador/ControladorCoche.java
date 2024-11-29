package com.example.coches.controlador;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.coches.entidad.Coche;
import com.example.coches.entidad.FuenteEnergia;
import com.example.coches.entidad.Idioma;
import com.example.coches.servicios.ServicioCoches;

import jakarta.validation.Valid;

@Controller
public class ControladorCoche {
	
	@Autowired
	private ServicioCoches servicioCoches; // Te crea un ServicioCoches
	
	// Cada uno de 
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("mensaje", " DWES :: RA3"); // Introduce atributos al model (entrada y salida)
		model.addAttribute("idiomas", Idioma.values());
		return "index"; // Es cómo se llama la plantilla --> lo manda a index.html
	}

	 @GetMapping("/idioma")
	 public String idioma(@RequestParam String idioma) {
		 if(idioma.equals(Idioma.EN.toString())) {
			 return "redirect:/?lang=en";
		 }else {
			 return "redirect:/?lang=es";
		 }
	 }
	 
	 @GetMapping("/coches")
	 public String coches(Model model) { // Ese parámetro es el idioma
	 	List<Coche> coches = servicioCoches.obtenerTodos();
		model.addAttribute("coches", coches); // Prueba para probar el si la lista está vacía
		// model.addAttribute("idiomas", Idioma.values());
		return "coches"; // Lo manda a coches.html
	 }
	 
}
