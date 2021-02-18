package edu.eci.arsw.blueprints.filters;

import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.persistence.BlueprintPersistenceException;
import org.springframework.stereotype.Service;

@Service
public interface BluePrintFilter {
    /**
     * Aplica el filtro que esté definido al blueprint que se envía.
     * @param bluePrint Plano al que se quiere aplicar el filtro.
     * @return Un nuevo blueprint con el filtro aplicado.
     * @throws BlueprintPersistenceException
     */
    Blueprint filter(Blueprint bluePrint) throws BlueprintPersistenceException;
}