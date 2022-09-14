package gestion.pkg.gestionRendezVous.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import gestion.pkg.gestionRendezVous.model.RendezVous;

public interface RendezVousRepo extends JpaRepository<RendezVous, Long> {

}
