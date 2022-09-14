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

import gestion.pkg.gestionRendezVous.model.Medecin;
import gestion.pkg.gestionRendezVous.service.MedecinService;

@RestController
@RequestMapping("/medecins")
public class MedecinRessource {
	private final MedecinService medecinService;
	
	public MedecinRessource(MedecinService medecinService) {
		this.medecinService = medecinService;
		
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Medecin>> getAllMedecins(){
		List<Medecin> medecin= medecinService.findAllMedecins();
		
		return new ResponseEntity<>(medecin, HttpStatus.OK);
		
		
	}
	
	
	@GetMapping("/find/{id}")
	public ResponseEntity<Medecin> getMedecinById(@PathVariable("id") Long id){
		Medecin medecin= medecinService.findMedecinById(id);
		
		return new ResponseEntity<>(medecin, HttpStatus.OK);
		
		
	}
	
	
	@PostMapping("/add")
	public ResponseEntity<Medecin> addConsultation(@RequestBody Medecin consultation){
		Medecin newMedecin= medecinService.addMedecin(consultation);
		
		return new ResponseEntity<>(newMedecin, HttpStatus.CREATED);

	}
	
	@PutMapping("/update")
	public ResponseEntity<Medecin> updateConsultation(@RequestBody Medecin medecin){
		Medecin updateMedecin= medecinService.updateMedecin(medecin);
		
		return new ResponseEntity<>(updateMedecin, HttpStatus.OK);

	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteMedecin(@PathVariable("id") Long id){
		medecinService.deleteMedecin(id);
		
		return new ResponseEntity<>(HttpStatus.OK);

	}      /* */
}
