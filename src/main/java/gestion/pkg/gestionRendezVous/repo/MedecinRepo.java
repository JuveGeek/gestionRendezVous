package gestion.pkg.gestionRendezVous.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import gestion.pkg.gestionRendezVous.model.Medecin;

public interface MedecinRepo extends JpaRepository<Medecin, Long> {

}
