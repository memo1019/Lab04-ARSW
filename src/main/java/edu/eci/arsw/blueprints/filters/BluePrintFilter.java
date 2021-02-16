package edu.eci.arsw.blueprints.filters;

import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.persistence.BlueprintPersistenceException;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface BluePrintFilter {
    public Set<Blueprint> filter(Set<Blueprint> bluePrints) throws BlueprintPersistenceException;
}