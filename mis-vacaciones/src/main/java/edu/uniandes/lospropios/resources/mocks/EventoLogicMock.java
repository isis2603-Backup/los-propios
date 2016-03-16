/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.lospropios.resources.mocks;

import edu.uniandes.lospropios.resources.dtos.CiudadDTO;
import edu.uniandes.lospropios.resources.dtos.EventoDTO;
import edu.uniandes.lospropios.resources.exceptions.EventoLogicException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

/**
 *
 * @author js.gomez14
 */
@Named
@ApplicationScoped
public class EventoLogicMock {

    // objeto para presentar logs de las operaciones
    private final static Logger logger = Logger.getLogger(EventoLogicMock.class.getName());

    // listado de ciudades
    private static ArrayList<EventoDTO> eventos;

    public EventoLogicMock() {

    	if (eventos == null) {
            eventos = new ArrayList<>();
            eventos.add(new EventoDTO(1L, "evento1", "A", "COL", new Date(), 2000, "http://UrlImg.com", EventoDTO.EVENTO));
            eventos.add(new EventoDTO(2L, "evento2", "B", "COL", new Date(), 2001, "http://UrlImg2.com", EventoDTO.SITIO_INTERES));
            eventos.add(new EventoDTO(3L, "evento3", "C", "CHILE", new Date(), 30000, "http://UrlImg3.com", EventoDTO.EVENTO));
        }

    	// indica que se muestren todos los mensajes
    	logger.setLevel(Level.INFO);

    	// muestra información
    	logger.info("Inicializa la lista de ciudades");
    	logger.info("ciudades" + eventos );


    }

    public List<EventoDTO> getEventos() throws EventoLogicException {
        if (eventos == null) {
    		logger.severe("Error interno: lista de ciudades no existe.");
    		throw new EventoLogicException("Error interno: lista de ciudades no existe.");
    	}

    	logger.info("retornando todas las ciudades");
    	return eventos;

    }

    public EventoDTO createEvento(EventoDTO evento) throws EventoLogicException {

            	logger.info("recibiendo solicitud de agregar ciudad " + evento);

    	// el nuevo evento tiene id ?
    	if ( evento.getId() != null ) {
	    	// busca el vento con el id suministrado
	        for (EventoDTO actual : eventos) {
	        	// si existe un evento con ese id
	            if (Objects.equals(actual.getId(), evento.getId())){
	            	logger.severe("Ya existe un evento con ese id");
	                throw new EventoLogicException("Ya existe un evento con ese id");
	            }
	        }

	    // el nuevo evento no tiene id ?
    	} else {

    		// genera un id para el evento
    		logger.info("Generando id para el nuevo evento");
    		long newId = 1;
	        for (EventoDTO actual : eventos) {
	            if (newId <= actual.getId()){
	                newId =  actual.getId() + 1;
	            }
	        }
	        evento.setId(newId);
    	}

        // agrega el evento
    	logger.info("agregando evento " + evento);
        eventos.add(evento);
        return evento;

    }

    public void deleteEvento(Long id) throws EventoLogicException {

            	logger.info("recibiendo solictud de eliminar evento con id " + id);

    	// busca el evento con el id suministrado
        for (EventoDTO actual : eventos) {
            if (Objects.equals(actual.getId(), id)) {

            	// elimina el evento
            	logger.info("eliminando evento " + actual);
                eventos.remove(actual);
                return;
            }
        }

        // no encontró el evento con ese id ?
        logger.severe("No existe un evento con ese id");
        throw new EventoLogicException("No existe un evento con ese id");
    }

    public EventoDTO updateEvento(Long id, EventoDTO evento) throws EventoLogicException {

        logger.info("recibiendo solictud de modificar evento " + evento);

    	// busca el evento con el id suministrado
        for (EventoDTO actual : eventos) {
            if (Objects.equals(actual.getId(), id)) {

            	// modifica el evento
            	actual.setId(evento.getId());
                actual.setNombre(evento.getNombre());

                // retorna el evento modificada
            	logger.info("Modificando evento " + actual);
                return actual;
            }
        }

        // no encontró el evento con ese id ?
        logger.severe("No existe un evento con ese id");
        throw new EventoLogicException("No existe un evento con ese id");
    }
}