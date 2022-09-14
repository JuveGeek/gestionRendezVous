package gestion.pkg.gestionRendezVous.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gestion.pkg.gestionRendezVous.exception.RendezVousNotFoundException;
import gestion.pkg.gestionRendezVous.model.RendezVous;
import gestion.pkg.gestionRendezVous.repo.RendezVousRepo;

@Service
public class RendezVousService {
private final RendezVousRepo rendezVousRepo;
	
	@Autowired
	public RendezVousService(RendezVousRepo rendezVousRepo) {
		this.rendezVousRepo=rendezVousRepo;
	}
 	

	public RendezVous addRendezVous(RendezVous rendezVous) {
		
		return rendezVousRepo.save(rendezVous);
	}
	
	public List<RendezVous> findAllRendezVous(){
		return rendezVousRepo.findAll();
	}
	
	public RendezVous updateRendezVous(RendezVous rendezVous) {
		return rendezVousRepo.save(rendezVous);
	}
	
	
	public RendezVous findRendezVousById(Long id){
		return rendezVousRepo.findById(id)
				.orElseThrow(()-> new RendezVousNotFoundException("RendezVous by id"+id+"was not found"));
	}
	
	public void deleteRendezVous(Long id) {
		
		rendezVousRepo.deleteById(id);
	}

}
