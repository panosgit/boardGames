/**
 * <p><b>Executive summary:</b> </p>
 * <p><b>OS/Hardware Dependencies:</b> N/A</p>
 * <p><b>References to any External Specifications:</b> N/A</p>
 */
package panos.games.back.model;

import java.util.List;

import javax.persistence.*;

/**
 * @author nipan
 *
 */
@Entity
@Table(name = "taboo")
public class Taboo {

	@Id
    @GeneratedValue
    private Long id;
    String card;
    String taboo;
    @ElementCollection(targetClass=String.class)
    List<String> words;
    Integer plays;
    String added;
    String language;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCard() {
		return card;
	}
	public void setCard(String card) {
		this.card = card;
	}
	public String getTaboo() {
		return taboo;
	}
	public void setTaboo(String taboo) {
		this.taboo = taboo;
	}
	public Integer getPlays() {
		return plays;
	}
	public void setPlays(Integer plays) {
		this.plays = plays;
	}
	public String getAdded() {
		return added;
	}
	public void setAdded(String added) {
		this.added = added;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public List<String> getWords() {
		return words;
	}
	public void setWords(List<String> words) {
		this.words = words;
	}


	
	
}
