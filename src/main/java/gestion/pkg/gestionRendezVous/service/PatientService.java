package gestion.pkg.gestionRendezVous.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gestion.pkg.gestionRendezVous.exception.PatientNotFoundException;
import gestion.pkg.gestionRendezVous.model.Patient;
import gestion.pkg.gestionRendezVous.repo.PatientRepo;

@Service
public class PatientService {
	
	private final PatientRepo patientRepo;
	
	@Autowired
	public PatientService(PatientRepo patientRepo) {
		this.patientRepo=patientRepo;
	}
 	

	public Patient addPatient(Patient patient) {
		
		return patientRepo.save(patient);
	}
	
	public List<Patient> findAllPatients(){
		return patientRepo.findAll();
	}
	
	public Patient updatePatient(Patient patient) {
		return patientRepo.save(patient);
	}
	
	
	public Patient findPatientById(long id){
		return patientRepo.findById(id)
				.orElseThrow(()-> new PatientNotFoundException("Patient by id"+id+"was not found"));
	}
	
	public void deletePatient(Long id) {
		
		patientRepo.deleteById(id);
	}

}
