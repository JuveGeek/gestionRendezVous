package gestion.pkg.gestionRendezVous.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import gestion.pkg.gestionRendezVous.model.Clinique;

public interface CliniqueRepo extends JpaRepository<Clinique, Long> {

}
