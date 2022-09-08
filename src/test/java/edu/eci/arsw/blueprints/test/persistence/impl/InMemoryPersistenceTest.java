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
    public void getBluePrintTest() throws BlueprintNotFoundException {
        InMemoryBlueprintPersistence ibpp = new InMemoryBlueprintPersistence();
        Point[] pts = new Point[]{new Point(5,5),new Point(3,3)};
        Blueprint bp = new Blueprint("Deivid", "PruebaUno", pts);
        try {
            ibpp.saveBlueprint(bp);
        }catch (BlueprintPersistenceException ex){
            fail("Blueprint persistence failed inserting the first blueprint.");
        }
        Blueprint rest = ibpp.getBlueprint("Deivid","PruebaUno");
        assertEquals(bp,rest);
    }

    @Test
    public void getBlueprintsByAuthor() throws BlueprintNotFoundException {
        InMemoryBlueprintPersistence ibpp = new InMemoryBlueprintPersistence();
        Point[] pts = new Point[]{new Point(5,5),new Point(3,3)};
        Blueprint bp = new Blueprint("Cristian", "PruebaDos", pts);
        Point[] pts2 = new Point[]{new Point(5,5),new Point(3,3)};
        Blueprint bp2 = new Blueprint("Cristian", "PruebaTres", pts2);
        try {
            ibpp.saveBlueprint(bp);
            ibpp.saveBlueprint(bp2);
        }catch (BlueprintPersistenceException ex){
            fail("Blueprint persistence failed inserting the first blueprint.");
        }
        assertEquals(2,ibpp.getBlueprintsByAuthor("Cristian").size());
    }
}
