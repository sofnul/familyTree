package fr.aberwag.familytree.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.aberwag.familytree.domain.neo4j.Membre;
import fr.aberwag.familytree.repository.neo4j.MembreRepository;

@Service
public class ConjointRelationManagmentService {

	private static final Logger log = LoggerFactory.getLogger(ConjointRelationManagmentService.class);

	@Autowired
	private MembreRepository membreRepository;

	public Membre addConjoint(Membre membre, Membre conjoint) {
		membre.setConjoint(conjoint);
		return membreRepository.save(membre);
	}

	public Membre deleteConjoint(Membre membre, Membre conjoint) {
		membre = membreRepository.findOneByPseudo(membre.getPseudo());
		conjoint = membreRepository.findOneByPseudo(conjoint.getPseudo());

		if (membre == null || conjoint == null) {
			throw new RuntimeException();
		}

		if (!membre.getConjoint().getPseudo().equals(conjoint.getPseudo())) {
			throw new RuntimeException();
		}
		membre.setConjoint(null);
		return membreRepository.save(membre);
	}

	public Membre addConjoint(String membrePseudo, String conjointPseudo) {
		Membre membre = membreRepository.findOneByPseudo(membrePseudo);
		Membre conjoint = membreRepository.findOneByPseudo(conjointPseudo);
		if (membre == null || conjoint == null) {
			throw new RuntimeException();
		}
		membre.setConjoint(conjoint);
		return membreRepository.save(membre);
	}

	public Membre deleteConjoint(String membrePseudo, String conjointPseudo) {
		Membre membre = membreRepository.findOneByPseudo(membrePseudo);
		Membre conjoint = membreRepository.findOneByPseudo(conjointPseudo);

		if (membre == null || conjoint == null) {
			throw new RuntimeException();
		}

		if (!membre.getConjoint().getPseudo().equals(conjoint.getPseudo())) {
			throw new RuntimeException();
		}
		membre.setConjoint(conjoint);
		return membreRepository.save(membre);
	}
}
