package fr.aberwag.familytree.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.aberwag.familytree.domain.neo4j.Membre;
import fr.aberwag.familytree.repository.neo4j.MembreRepository;

@Service
public class PereRelationmanagmenetService {

	@Autowired
	private MembreRepository membreRepository;

	public Membre addFather(Membre child, Membre father) {
		child = membreRepository.findOneByPseudo(child.getPseudo());
		father = membreRepository.findOneByPseudo(father.getPseudo());
		if (child == null || father == null) {
			throw new RuntimeException();
		}
		child.setPere(father);
		return membreRepository.save(child);
	}

	public Membre deleteFather(Membre child, Membre father) {
		child = membreRepository.findOneByPseudo(child.getPseudo());
		father = membreRepository.findOneByPseudo(father.getPseudo());

		if (child == null || father == null) {
			throw new RuntimeException("le fils et le pere doivent etre present dans la base de données");
		}

		if (!child.getPere().getPseudo().equals(father.getPseudo())) {
			throw new RuntimeException("Il n'y a pas de relation pere-fils entre les personnes choisis");
		}
		child.setPere(null);
		return membreRepository.save(child);
	}

	public Membre addFather(String childPseudo, String fatherPseudo) {
		Membre child = membreRepository.findOneByPseudo(childPseudo);
		Membre father = membreRepository.findOneByPseudo(fatherPseudo);
		if (child == null || father == null) {
			throw new RuntimeException();
		}
		child.setPere(father);
		return membreRepository.save(child);
	}

	public Membre deleteFather(String childPseudo, String fatherPseudo) {
		Membre child = membreRepository.findOneByPseudo(childPseudo);
		Membre father = membreRepository.findOneByPseudo(fatherPseudo);

		if (child == null || father == null) {
			throw new RuntimeException();
		}

		if (!child.getPere().getPseudo().equals(father.getPseudo())) {
			throw new RuntimeException();
		}
		child.setPere(father);
		return membreRepository.save(child);
	}
}
