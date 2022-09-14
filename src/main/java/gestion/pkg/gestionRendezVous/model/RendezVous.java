package gestion.pkg.gestionRendezVous.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data 
public class RendezVous implements Serializable{
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private Date dateRendezVous;
	private String status;
	private String rapportConsultation;
	@ManyToOne
	private Medecin medecin;
	@ManyToOne
	private Patient patient;
	@OneToOne
	private Clinique clinique;
	
	public Date getDateRendezVous() {
		return dateRendezVous;
	}
	public void setDateRendezVous(Date dateRendezVous) {
		this.dateRendezVous = dateRendezVous;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRapportConsultation() {
		return rapportConsultation;
	}
	public void setRapportConsultation(String rapportConsultation) {
		this.rapportConsultation = rapportConsultation;
	}

}
