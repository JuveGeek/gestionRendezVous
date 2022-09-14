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

import gestion.pkg.gestionRendezVous.model.Clinique;
import gestion.pkg.gestionRendezVous.service.CliniqueService;

@RestController
@RequestMapping("/cliniques")
public class CliniqueRessource {
private final CliniqueService cliniqueService;
	
	public CliniqueRessource(CliniqueService cliniqueService) {
		this.cliniqueService = cliniqueService;
		
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Clinique>> getAllMedecins(){
		List<Clinique> clinique= cliniqueService.findAllCliniques();
		
		return new ResponseEntity<>(clinique, HttpStatus.OK);
		
		
	}
	
	
	@GetMapping("/find/{id}")
	public ResponseEntity<Clinique> getMedecinById(@PathVariable("id") Long id){
		Clinique clinique= cliniqueService.findCliniqueById(id);
		
		return new ResponseEntity<>(clinique, HttpStatus.OK);
		
		
	}
	
	
	@PostMapping("/add")
	public ResponseEntity<Clinique> addClinique(@RequestBody Clinique clinique){
		Clinique newClinique= cliniqueService.addClinique(clinique);
		
		return new ResponseEntity<>(newClinique, HttpStatus.CREATED);

	}
	
	@PutMapping("/update")
	public ResponseEntity<Clinique> updateConsultation(@RequestBody Clinique clinique){
		Clinique updateClinique= cliniqueService.updateClinique(clinique);
		
		return new ResponseEntity<>(updateClinique, HttpStatus.OK);

	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteMedecin(@PathVariable("id") Long id){
		cliniqueService.deleteClinique(id);
		
		return new ResponseEntity<>(HttpStatus.OK);

	}  

}
