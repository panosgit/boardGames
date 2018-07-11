package panos.games.back.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import panos.games.back.model.Taboo;
import panos.games.back.repository.TabooRepository;




@RestController
@RequestMapping(path="/taboogame")
public class TabooController {
    @Autowired
    private TabooRepository tabooRepository;
    @Autowired
    
	
	@GetMapping(path= "/taboo")
	public @ResponseBody Iterable<Taboo> getTaboo() {
		System.out.println("in get taboo");
		return tabooRepository.findAll();	
		}

	@PostMapping(path = "/taboo")
	public ResponseEntity<String> addNewTaboo(@RequestBody Taboo taboo) {
		tabooRepository.save(taboo);
		return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
	}
	


}