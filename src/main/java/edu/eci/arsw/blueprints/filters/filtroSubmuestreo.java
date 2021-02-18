package edu.eci.arsw.blueprints.filters;

import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.model.Point;
import edu.eci.arsw.blueprints.persistence.BlueprintPersistenceException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service("SubmuestreoFiltro")
public class filtroSubmuestreo implements BluePrintFilter{

    @Override
    public Set<Blueprint> filter(Set<Blueprint> bluePrints) throws BlueprintPersistenceException {
        for (Blueprint bl : bluePrints) {
            filterBlueprint(bl);
        }
        return bluePrints;
    }
    public Blueprint filterBlueprint(Blueprint blueprint) {
        List<Point> blueprintPoints = blueprint.getPoints();
        for (int i = blueprintPoints.size() - 1; i >= 0; i--) {
            if (i % 2 == 0) {
                blueprintPoints.remove(i);
            }
        }
        Point[] points = (Point[]) blueprintPoints.toArray();
        return new Blueprint(blueprint.getAuthor(), blueprint.getName(), points);


    }

}
