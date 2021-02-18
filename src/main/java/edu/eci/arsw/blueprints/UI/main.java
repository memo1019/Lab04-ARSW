package edu.eci.arsw.blueprints.UI;

import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.model.Point;
import edu.eci.arsw.blueprints.persistence.BlueprintNotFoundException;
import edu.eci.arsw.blueprints.persistence.BlueprintPersistenceException;
import edu.eci.arsw.blueprints.services.BlueprintsServices;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;

public class main {
    public static void main(String []args) throws BlueprintPersistenceException, BlueprintNotFoundException {
        //Definición del archivo de contexto para Spring.
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        //Creación de la instancia de la clase de servicios.
        BlueprintsServices cs = ac.getBean(BlueprintsServices.class);
        //Creación de los puntos para cada plano.
        ArrayList<Point> punto1 = new ArrayList<>(Arrays.asList(new Point(0, 0),new Point(0, 0),new Point(11, 12),new Point(50, 32),new Point(1, 1),new Point(1, 1)));
        ArrayList<Point> punto2 = new ArrayList<>(Arrays.asList(new Point(7, 7),new Point(10, 10)));
        ArrayList<Point> punto3 = new ArrayList<>(Arrays.asList(new Point(14, 17),new Point(11, 12)));
        //Registro de planos.
        System.out.println("=================================Registrar planos=================================");
        cs.addNewBlueprint(new Blueprint("memo", "casitaMemo",punto1));
        cs.addNewBlueprint(new Blueprint("Fede", "casitaFede",punto2));
        cs.addNewBlueprint(new Blueprint("Fede", "Ciego",punto3));
        System.out.println("Los planos se han registrado satisfactoriamente:");
        System.out.println("==================================================================================");
        System.out.println();
        System.out.println();
        //Consulta de planos.
        System.out.println("============================Consultar todos los planos============================");
        for (Blueprint i:cs.getAllBlueprints()){
            System.out.println(i.toString());
        }
        System.out.println("==================================================================================");
        System.out.println();
        System.out.println();
        //Consulta de un plano específico.
        System.out.println("===========================Consultar Un Plano específico==========================");
        System.out.println(cs.getBlueprint("memo","casitaMemo").toString());
        System.out.println("==================================================================================");
        System.out.println();
        System.out.println();
        //Consulta de un plano por un autor.
        System.out.println("======================Consultar Un Plano específico por autor=====================");
        System.out.println(cs.getBlueprintsByAuthor("Fede").toString());
        System.out.println("==================================================================================");
        System.out.println();
        System.out.println();
        //Filtro aplicado a un plano.
        System.out.println("==============================Aplicación del filtro===============================");
        System.out.println(cs.getBlueprint("memo","casitaMemo").toString());
        System.out.println("- Puntos originales: "+cs.getBlueprint("memo","casitaMemo").getPoints().toString());
        System.out.println("- Puntos filtrados: "+cs.getFilteredBlueprints(cs.getBlueprint("memo","casitaMemo")).getPoints().toString());
        System.out.println("==================================================================================");
    }
}
