package fr.aberwag.familytree.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.aberwag.familytree.domain.neo4j.Membre;

@RestController
@RequestMapping("/photos")
public class PhotosManagmentController {

	@Autowired
	private PhotosManagmentController photosManagmentControllermembreManagmentService;

	@RequestMapping(method = RequestMethod.GET, value = "/test")
	public Membre addProfilePhoto(String pseudo, String path) {
		throw new NullPointerException();
	}

	public Membre deleteProfilePhoto(String pseudo, String path) {
		return null;
	}

	public Membre updateProfilePhoto(String pseudo, String newPath) {
		return null;
	}

}
