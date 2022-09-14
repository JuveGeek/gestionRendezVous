package gestion.pkg.gestionRendezVous.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import gestion.pkg.gestionRendezVous.model.Patient;

public interface PatientRepo extends JpaRepository<Patient, Long> {

}
