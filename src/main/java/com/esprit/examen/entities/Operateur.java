package com.esprit.examen.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Operateur implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idOperateur;
	private String nom;
	private String prenom;

	private String password;
	@OneToMany
	@JsonIgnore
	private Set<Facture> factures;

	public Operateur(String nom, String prenom, String password) {
		this.nom = nom;
		this.prenom = prenom;
		this.password = password;
	}
}