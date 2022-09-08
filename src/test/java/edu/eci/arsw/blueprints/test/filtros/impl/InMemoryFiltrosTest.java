package edu.eci.arsw.blueprints.test.filtros.impl;

import edu.eci.arsw.blueprints.filtros.impl.InMemoryBlueprintPersistenceFilter;
import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.model.Point;
import edu.eci.arsw.blueprints.persistence.BlueprintNotFoundException;
import edu.eci.arsw.blueprints.persistence.BlueprintPersistenceException;
import edu.eci.arsw.blueprints.persistence.impl.InMemoryBlueprintPersistence;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Medina-Ruiz
 */
public class InMemoryFiltrosTest {

    @Test
    public void aplicarFiltroA() {
        InMemoryBlueprintPersistenceFilter ibppF=new InMemoryBlueprintPersistenceFilter();
        ArrayList<Blueprint> bpsA = new ArrayList<>();
        Point[] pts=new Point[]{new Point(0, 0),new Point(10, 10),new Point(10, 10),new Point(45, 67),new Point(56, 90),new Point(56, 90)};
        Blueprint bp=new Blueprint("john", "thepaint",pts);
        bpsA.add(bp);
        for(Blueprint b : ibppF.filtrarPuntosB(bpsA)){
            assertEquals(3,b.getPoints().size());
        }
    }

    @Test
    public void aplicarFiltroB() {
        InMemoryBlueprintPersistenceFilter ibppF=new InMemoryBlueprintPersistenceFilter();
        ArrayList<Blueprint> bpsB = new ArrayList<>();
        Point[] pts=new Point[]{new Point(0, 0),new Point(10, 10),new Point(10, 10),new Point(45, 67),new Point(56, 90),new Point(56, 90),new Point(160, 10)};
        Blueprint bp=new Blueprint("john", "thepaint",pts);
        bpsB.add(bp);
        for(Blueprint b : ibppF.filtrarPuntosB(bpsB)){
            assertEquals(4,b.getPoints().size());
        }

    }

}
