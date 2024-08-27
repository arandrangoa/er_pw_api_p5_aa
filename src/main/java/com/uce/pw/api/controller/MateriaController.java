package com.uce.pw.api.controller;

import java.awt.PageAttributes.MediaType;
import java.net.http.HttpClient;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uce.pw.api.service.IMateriaService;
import com.uce.pw.api.service.to.MateriaCompletaTO;
import com.uce.pw.api.service.to.MateriaTO;

@Controller
@CrossOrigin
@RequestMapping(path = "/materias")
public class MateriaController {
	
	@Autowired
	private IMateriaService iMateriaService;
	
	//http://localhost:8082/API/v1.0/Matricula/materias
	@PostMapping(produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE, consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<MateriaCompletaTO> guardar(@RequestBody MateriaCompletaTO materia){
		this.iMateriaService.insertar(materia);
		return ResponseEntity.status(HttpStatus.OK).body(materia);
	}
	
	@GetMapping(produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<MateriaTO>> buscarTodos(){
		List<MateriaTO> lista=this.iMateriaService.buscarTodos();
		for(MateriaTO m:lista) {
			Link link=linkTo(methodOn(MateriaController.class)
					.buscarPorCodigo(m.getCodigo()))
					.withSelfRel();
			m.add(link);
			
		}
		return ResponseEntity.status(HttpStatus.OK).body(lista);
	}
	
	@GetMapping(path = "/{codigo}", produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<MateriaCompletaTO> buscarPorCodigo(@PathVariable String codigo){
		MateriaCompletaTO m=this.iMateriaService.buscarPorCodigo(codigo);
		
		return ResponseEntity.status(HttpStatus.OK).body(m);
	}
	
	@DeleteMapping(path = "/{codigo}", produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> borrar(@PathVariable String codigo){
		this.iMateriaService.eliminar(codigo);
		return ResponseEntity.status(HttpStatus.OK).body("BORRADO");
	}
	
	@PutMapping(path = "/{codigo}", produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE, consumes =  org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<MateriaCompletaTO> actualizar(@RequestBody MateriaCompletaTO materia,@PathVariable String codigo){
		materia.setCodigo(codigo);
		this.iMateriaService.actualizar(materia);
		return ResponseEntity.status(HttpStatus.OK).body(materia);
	}
	

}
