package ifam.edu.dra.chat.controller;

import java.util.ArrayList;
import java.util.List;

import ifam.edu.dra.chat.service.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ifam.edu.dra.chat.model.Contato;

@RequestMapping("/contato")
@RestController
public class ContatoController {
	
	ArrayList<Contato> contatos = new ArrayList<Contato>();

	@Autowired
	ContatoService contatoService;


	@GetMapping
	ResponseEntity<List<Contato>> getContatos(){
		if(contatos.isEmpty()) {
			return ResponseEntity.badRequest().body(null);
		}
		return ResponseEntity.ok(contatoService.getContatos());
	}
	
	@GetMapping("/id")
	ResponseEntity<Contato> getContato(@PathVariable int id){
		try {
			return ResponseEntity.ok(contatos.get(id));
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Contato());
		}
		
	}
	
	@PostMapping
	ResponseEntity<Contato> setContact(@RequestBody Contato contato) {
		try {
			contatos.add(contato);
			return ResponseEntity.created(null).body(contato);
		}
		catch(Exception ex) {
			return ResponseEntity.internalServerError().body(null);
		}
		
		
	}
	
	@PutMapping("/{id}")
	Contato setContato(@RequestBody Contato contato) {
		return null;
	}
	
	@DeleteMapping("/{id}")
	void deleteContato(@PathVariable Long id) {
		
	}
	
}