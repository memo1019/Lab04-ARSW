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

    @Override
    public Set<Blueprint> filter(Set<Blueprint> bluePrints) throws BlueprintPersistenceException {
        ArrayList<Integer> x= new ArrayList<>();
        for(Blueprint bp:bluePrints){
            List<Point> points = bp.getPoints();
            for (int i = 0; i < points.size(); i++) {
                for (int k = i + 1; k < points.size(); k++) {
                    System.out.println(points.get(i).compare(points.get(k)));
                    if (points.get(i).compare(points.get(k))) {
                        x.add(k);
                        //points.remove(i);
                    }
                }
            }
            for(Integer i:x){
                points.remove(i);
            }
        }

        return bluePrints;
    }

}
