package gestion.pkg.gestionRendezVous.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gestion.pkg.gestionRendezVous.exception.MedecinNotFoundException;
import gestion.pkg.gestionRendezVous.model.Medecin;
import gestion.pkg.gestionRendezVous.repo.MedecinRepo;

@Service
public class MedecinService {
private final MedecinRepo medecinRepo;
	
	@Autowired
	public MedecinService(MedecinRepo medecinRepo) {
		this.medecinRepo=medecinRepo;
	}
 	

	public Medecin addMedecin(Medecin medecin) {
		
		return medecinRepo.save(medecin);
	}
	
	public List<Medecin> findAllMedecins(){
		return medecinRepo.findAll();
	}
	
	public Medecin updateMedecin(Medecin medecin) {
		return medecinRepo.save(medecin);
	}
	
	
	public Medecin findMedecinById(Long id){
		return medecinRepo.findById(id)
				.orElseThrow(()->new MedecinNotFoundException("medecin by id"+id+"was not found"));
	}
	
	public void deleteMedecin(Long id) {
		
		medecinRepo.deleteById(id);
	}
}
