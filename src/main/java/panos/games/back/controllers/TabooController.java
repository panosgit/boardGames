package panos.games.back.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
    
    @Value("${taboofile}")
    private String tabooFilePath;
    
    
    
	@GetMapping(path= "/renew")
	public @ResponseBody Iterable<Taboo> renewTabooCards() {
		System.out.println("in renewTabooCards ");

//	    File file = new File(tabooFilePath);
	    
	   
	    String st;
	    try {
	    	InputStream in = this.getClass().getClassLoader().getResourceAsStream(tabooFilePath);
		    BufferedReader br = new BufferedReader(new InputStreamReader(in, "UTF-8"));
		    List<String> tabooList = null;
		    List<List<String>> fullTabooList = new ArrayList<List<String>>();
			while ((st = br.readLine()) != null) {
				tabooList=Arrays.asList(st.split(","));
				fullTabooList.add(tabooList);
			}
			for(List<String> list:fullTabooList) {
				Taboo taboo=new Taboo();
				for(String string :list) {
					String[] bla = string.split("@");
					if(bla.length==2) {
						taboo.setTaboo(bla[0]);
						string = bla[1];
					}
					if(taboo.getWords()==null) {
						taboo.setWords(new ArrayList<String>());
					}
					taboo.getWords().add(string);
					System.out.println(string);
				}
				tabooRepository.save(taboo);
				
			}
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tabooRepository.findAll();	
	}

    
	
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