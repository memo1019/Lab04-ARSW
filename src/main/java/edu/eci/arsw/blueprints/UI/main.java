package edu.eci.arsw.blueprints.UI;

import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.model.Point;
import edu.eci.arsw.blueprints.persistence.BlueprintNotFoundException;
import edu.eci.arsw.blueprints.persistence.BlueprintPersistenceException;
import edu.eci.arsw.blueprints.services.BlueprintsServices;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class main {
    public static void main(String []args) throws BlueprintPersistenceException, BlueprintNotFoundException {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.println();
        System.out.println();
        System.out.println("------------------Registrar planos------------------");

        BlueprintsServices cs = ac.getBean(BlueprintsServices.class);
        Point[] punto1=new Point[]{new Point(0, 0),new Point(1, 1)};
        Point[] punto2=new Point[]{new Point(7, 7),new Point(10, 10)};
        Point[] punto3=new Point[]{new Point(14, 17),new Point(11, 12)};
        cs.addNewBlueprint(new Blueprint("memo", "casitaMemo",punto1));
        cs.addNewBlueprint(new Blueprint("Fede", "casitaFede",punto2));
        cs.addNewBlueprint(new Blueprint("Fede", "Ciego",punto3));



        System.out.println();
        System.out.println();
        System.out.println("------------------Consultar todos los planos------------------");

        System.out.println();
        for (Blueprint i:cs.getAllBlueprints()){
            System.out.println(i.toString());
        }
        System.out.println();
        System.out.println("------------------Consultar Un Plano espefecifico------------------");
        System.out.println();
        System.out.println(cs.getBlueprint("memo","casitaMemo").toString());
        System.out.println();
        System.out.println("------------------Consultar Un Plano espefecifico por autor------------------");
        System.out.println();
        System.out.println(cs.getBlueprintsByAuthor("Fede").toString());

    }

}
