/**
 * <p><b>Executive summary:</b> </p>
 * <p><b>OS/Hardware Dependencies:</b> N/A</p>
 * <p><b>References to any External Specifications:</b> N/A</p>
 */
package panos.games.back.repository;

import org.springframework.data.repository.CrudRepository;

import panos.games.back.model.Taboo;


/**
 * @author nipan
 *
 */

public interface TabooRepository extends CrudRepository<Taboo, Long> {



	
}
