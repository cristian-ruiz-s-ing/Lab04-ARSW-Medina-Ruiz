package edu.eci.arsw.blueprints.services;

import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.model.Point;
import edu.eci.arsw.blueprints.persistence.BlueprintNotFoundException;
import edu.eci.arsw.blueprints.persistence.BlueprintPersistenceException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String arg[]) throws BlueprintPersistenceException, BlueprintNotFoundException {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        BlueprintsServices bps = ac.getBean(BlueprintsServices.class);

        Point[] pts = new Point[]{new Point(2,2),new Point(31,31)};
        Blueprint bp = new Blueprint("Deivid", "PruebaUno", pts);
        Point[] pts2 = new Point[]{new Point(5,5),new Point(3,3)};
        Blueprint bp2 = new Blueprint("Cristian", "PruebaDos", pts2);
        Point[] pts3 = new Point[]{new Point(25,55),new Point(31,37)};
        Blueprint bp3 = new Blueprint("Cristian", "PruebaTres", pts2);
        Point[] pts4 = new Point[]{new Point(65,23),new Point(67,98)};
        Blueprint bp4 = new Blueprint("Pepito", "PruebaCuatro", pts2);

        bps.addNewBlueprint(bp);
        bps.addNewBlueprint(bp2);
        bps.addNewBlueprint(bp3);
        bps.addNewBlueprint(bp4);
        System.out.println(bps.getAllBlueprints());
        System.out.println(bps.getBlueprint("Deivid","PruebaUno"));
        System.out.println(bps.getBlueprintsByAuthor("Cristian"));
    }
}
