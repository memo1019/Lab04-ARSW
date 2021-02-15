/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.blueprints.test.persistence.impl;

import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.model.Point;
import edu.eci.arsw.blueprints.persistence.BlueprintNotFoundException;
import edu.eci.arsw.blueprints.persistence.BlueprintPersistenceException;
import edu.eci.arsw.blueprints.persistence.impl.InMemoryBlueprintPersistence;

import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author hcadavid
 */
public class InMemoryPersistenceTest {
    
    @Test
    public void saveNewAndLoadTest() throws BlueprintPersistenceException, BlueprintNotFoundException{
        InMemoryBlueprintPersistence ibpp=new InMemoryBlueprintPersistence();

        Point[] pts0=new Point[]{new Point(40, 40),new Point(15, 15)};
        Blueprint bp0=new Blueprint("mack", "mypaint",pts0);
        
        ibpp.saveBlueprint(bp0);
        
        Point[] pts=new Point[]{new Point(0, 0),new Point(10, 10)};
        Blueprint bp=new Blueprint("john", "thepaint",pts);
        
        ibpp.saveBlueprint(bp);
        
        assertNotNull("Loading a previously stored blueprint returned null.",ibpp.getBlueprint(bp.getAuthor(), bp.getName()));
        
        assertEquals("Loading a previously stored blueprint returned a different blueprint.",ibpp.getBlueprint(bp.getAuthor(), bp.getName()), bp);
        
    }


    @Test
    public void saveExistingBpTest() {
        InMemoryBlueprintPersistence ibpp=new InMemoryBlueprintPersistence();
        
        Point[] pts=new Point[]{new Point(0, 0),new Point(10, 10)};
        Blueprint bp=new Blueprint("john", "thepaint",pts);
        
        try {
            ibpp.saveBlueprint(bp);
        } catch (BlueprintPersistenceException ex) {
            fail("Blueprint persistence failed inserting the first blueprint.");
        }
        
        Point[] pts2=new Point[]{new Point(10, 10),new Point(20, 20)};
        Blueprint bp2=new Blueprint("john", "thepaint",pts2);

        try{
            ibpp.saveBlueprint(bp2);
            fail("An exception was expected after saving a second blueprint with the same name and autor");
        }
        catch (BlueprintPersistenceException ex){
            
        }


    }
    @Test
    public void getBluePrintText() {

    }

    @Test
    public void getBlueprintsByAuthorTest(){
        InMemoryBlueprintPersistence persistencia=new InMemoryBlueprintPersistence();

        Point[] punto1=new Point[]{new Point(0, 0),new Point(1, 1)};
        Blueprint bp1=new Blueprint("memo", "casitaMemo",punto1);
        Point[] punto2=new Point[]{new Point(3, 3),new Point(5, 5)};
        Blueprint bp2=new Blueprint("Fede", "elRancho",punto2);
        Point[] punto3=new Point[]{new Point(7, 7),new Point(10, 10)};
        Blueprint bp3=new Blueprint("Fede", "Castro",punto3);
        Point[] punto4=new Point[]{new Point(12, 12),new Point(16, 16)};
        Blueprint bp4=new Blueprint("Fabian", "ciego",punto4);
        Set<Blueprint> ans= null;
        try {
            persistencia.saveBlueprint(bp1);
            persistencia.saveBlueprint(bp2);
            persistencia.saveBlueprint(bp3);
            persistencia.saveBlueprint(bp4);
        } catch (BlueprintPersistenceException e) {
            e.printStackTrace();
        }
        Set<Blueprint> aux = new HashSet<>();
        aux.add(bp1);

        try {
            ans = persistencia.getBlueprintsByAuthor("memo");
        } catch (BlueprintNotFoundException e) {
            e.printStackTrace();
        }
        assertEquals(aux,ans);




    }
}
