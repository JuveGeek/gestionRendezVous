package gestion.pkg.gestionRendezVous.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gestion.pkg.gestionRendezVous.exception.CliniqueNotFoundException;
import gestion.pkg.gestionRendezVous.model.Clinique;
import gestion.pkg.gestionRendezVous.repo.CliniqueRepo;

@Service
public class CliniqueService {
private final CliniqueRepo cliniqueRepo ;
	
	@Autowired
	public CliniqueService(CliniqueRepo cliniqueRepo) {
		this.cliniqueRepo = cliniqueRepo;
	}
 	

	public Clinique addClinique(Clinique clinique) {
		
		return cliniqueRepo.save(clinique);
	}
	
	public List<Clinique> findAllCliniques(){
		return cliniqueRepo.findAll();
	}
	
	public Clinique updateClinique(Clinique clinique) {
		return cliniqueRepo.save(clinique);
	}
	
	
	public Clinique findCliniqueById(Long id){
		return cliniqueRepo.findById(id)
				.orElseThrow(()-> new CliniqueNotFoundException("RendezVous by id"+id+"was not found"));
	}
	
	public void deleteClinique(Long id) {
		
		cliniqueRepo.deleteById(id);
	}
}
