package edu.eci.arsw.blueprints.filters;

import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.model.Point;
import edu.eci.arsw.blueprints.persistence.BlueprintPersistenceException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Service("RedundanciaFiltro")
public class filtroRedundancia implements BluePrintFilter{
    /**
     * Elimina los puntos repetidos de un plano.
     * @param blueprint El plano que se revisará.
     * @return Un nuevo plano con el filtro aplicado.
     */
    @Override
    public Blueprint filter(Blueprint blueprint) {
        System.out.println("Filtro de redundancia aplicado: ");
        ArrayList<Point> points = blueprint.getPoints();
        ArrayList<Point> repeatedPoints = new ArrayList<>();
        Point lastPoint = points.get(0);
        for (int i = 1; i < points.size(); i++) {
            Point p = points.get(i);
            if (lastPoint.compare(p)) {
                repeatedPoints.add(p);
            } else {
                lastPoint = p;
            }
        }
        for (Point p : repeatedPoints) {
            points.remove(p);
        }
        return new Blueprint(blueprint.getAuthor(), blueprint.getName(), points);
    }

    public Set<Blueprint> multiFilter(Set<Blueprint> blueprints) {
        for (Blueprint blueprint : blueprints) {
            filter(blueprint);
        }
        return blueprints;
    }
}
