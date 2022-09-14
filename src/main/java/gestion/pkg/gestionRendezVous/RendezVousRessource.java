package gestion.pkg.gestionRendezVous;

import java.util.List;

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

import gestion.pkg.gestionRendezVous.model.RendezVous;
import gestion.pkg.gestionRendezVous.service.RendezVousService;



@RestController
@RequestMapping("/rendezVous")
public class RendezVousRessource {
	private final RendezVousService rendezVousService;
	
	public RendezVousRessource(RendezVousService rendezVousService) {
		this.rendezVousService = rendezVousService;
		
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<RendezVous>> getAllConsultations(){
		List<RendezVous> rendezVous= rendezVousService.findAllRendezVous();
		
		return new ResponseEntity<>(rendezVous, HttpStatus.OK);
		
		
	}
	
	
	@GetMapping("/find/{id}")
	public ResponseEntity<RendezVous> getRendezVousById(@PathVariable("id") Long id){
		RendezVous rendezVous= rendezVousService.findRendezVousById(id);
		
		return new ResponseEntity<>(rendezVous, HttpStatus.OK);
		
		
	}
	
	
	@PostMapping("/add")
	public ResponseEntity<RendezVous> addRendezVous(@RequestBody RendezVous rendezVous){
		RendezVous newRendezVous= rendezVousService.addRendezVous(rendezVous);
		
		return new ResponseEntity<>(newRendezVous, HttpStatus.CREATED);

	}
	
	@PutMapping("/update")
	public ResponseEntity<RendezVous> updateRendezVous(@RequestBody RendezVous rendezVous){
		RendezVous updateRendezVous= rendezVousService.updateRendezVous(rendezVous);
		
		return new ResponseEntity<>(updateRendezVous, HttpStatus.OK);

	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteRendezVous(@PathVariable("id") Long id){
		rendezVousService.deleteRendezVous(id);
		
		return new ResponseEntity<>(HttpStatus.OK);

	}   
}
