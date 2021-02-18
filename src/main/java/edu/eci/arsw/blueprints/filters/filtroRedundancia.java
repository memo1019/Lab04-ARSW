package edu.eci.arsw.blueprints.filters;

import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.model.Point;
import edu.eci.arsw.blueprints.persistence.BlueprintPersistenceException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service("RedundanciaFiltro")
public class filtroRedundancia implements BluePrintFilter{

    public Blueprint filterBlueprint(Blueprint blueprint) {
        List<Point> listPoint = blueprint.getPoints();
        List<Point> update = new ArrayList<Point>();
        update.add(listPoint.get(0));
        for (int i = 1; i < listPoint.size(); i++) {
            Point point = listPoint.get(i - 1);
            if (!(point.getX() == listPoint.get(i).getX() && point.getY() == listPoint.get(i).getY())) {
                update.add(listPoint.get(i));
            }
        }

        blueprint.updatePoint(update);
        return blueprint;
    }

    public Set<Blueprint> multiFilter(Set<Blueprint> blueprints) {
        for (Blueprint blueprint : blueprints) {
            filterBlueprint(blueprint);
        }
        return blueprints;
    }

    @Override
    public Set<Blueprint> filter(Set<Blueprint> bluePrints) throws BlueprintPersistenceException {
        for (Blueprint blueprint : bluePrints) {
            filterBlueprint(blueprint);
        }
        return bluePrints;
    }
}
