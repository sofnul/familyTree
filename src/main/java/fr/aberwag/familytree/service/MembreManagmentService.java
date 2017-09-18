package fr.aberwag.familytree.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.aberwag.familytree.Utils;
import fr.aberwag.familytree.domain.neo4j.Membre;
import fr.aberwag.familytree.exception.FamilyBusinessException;
import fr.aberwag.familytree.repository.neo4j.MembreRepository;

@Service
public class MembreManagmentService {

	private static final Logger log = LoggerFactory.getLogger(MembreManagmentService.class);

	@Autowired
	private MembreRepository membreRepository;

	public Membre addMembre(Membre membre) {
		if (membreRepository.findOneByPseudo(membre.getPseudo()) != null)
			throw new FamilyBusinessException("L'utilisateur existe déja");
		return membreRepository.save(membre);
	}

	public Membre deleteMembre(String pseudo) {
		// return membreRepository.save(membre);
		Membre m = membreRepository.findOneByPseudo(pseudo);
		if (m == null) {
			throw new RuntimeException();
		}
		m.setActif(false);
		return membreRepository.save(m);
	}

	public Membre updateMembre(Membre membre) {
		Membre m = membreRepository.findOneByPseudo(membre.getPseudo());
		if (m == null) {
			throw new RuntimeException();
		}

		m = Utils.mapper(m, membre);
		return membreRepository.save(m);
	}

	public Membre getMembre(String pseudo) {
		return membreRepository.findOneByPseudo(pseudo);
	}

	public List<Membre> getAllActifMembre() {
		return membreRepository.findByActifTrue();
	}

}
