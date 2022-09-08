/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.blueprints.services;

import edu.eci.arsw.blueprints.filtros.BluePrintFilter;
import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.persistence.BlueprintNotFoundException;
import edu.eci.arsw.blueprints.persistence.BlueprintPersistenceException;
import edu.eci.arsw.blueprints.persistence.BlueprintsPersistence;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author hcadavid
 */
@Service
public class BlueprintsServices {
   
    @Autowired
    @Qualifier("serviceInMemoryBlueprintPersistence")
    BlueprintsPersistence bpp=null;

    @Autowired
    @Qualifier("serviceInMemoryBlueprintPersistenceFilter")
    BluePrintFilter bppF=null;

    /**
     * Clase que me permite recorrer la lista de BluePrint y aplicar FiltroA
     * @param blueprints ArrayList<BluePrint>
     * @return ArrayList<Blueprint>, La nueva BluePrint con los puntos filtrados.
     */
    public ArrayList<Blueprint> blueprintFiltreA(ArrayList<Blueprint> blueprints){
        return bppF.filtrarPuntosA(blueprints);
    }

    /**
     * Clase que me permite recorrer la lista de BluePrint y aplicar FiltroB
     * @param blueprints ArrayList<BluePrint>
     * @return ArrayList<Blueprint>, La nueva BluePrint con los puntos filtrados.
     */
    public ArrayList<Blueprint> blueprintFiltreB(ArrayList<Blueprint> blueprints){
        return bppF.filtrarPuntosB(blueprints);
    }

    /**
     * Método que me permite agregar un nuevo BluePrint.
     * @param bp
     * @throws BlueprintPersistenceException
     */
    public void addNewBlueprint(Blueprint bp) throws BlueprintPersistenceException {
        bpp.saveBlueprint(bp);
    }

    /**
     * 
     * @param author blueprint's author
     * @param name blueprint's name
     * @return the blueprint of the given name created by the given author
     * @throws BlueprintNotFoundException if there is no such blueprint
     */
    public Blueprint getBlueprint(String author,String name) throws BlueprintNotFoundException{
        return bpp.getBlueprint(author, name);
        //return InMemoryBlueprintPersistence.blueprints.get(new Tuple<>(author, name));
    }
    
    /**
     * 
     * @param author blueprint's author
     * @return all the blueprints of the given author
     * @throws BlueprintNotFoundException if the given author doesn't exist
     */
    public Set<Blueprint> getBlueprintsByAuthor(String author) throws BlueprintNotFoundException{
        return bpp.getBlueprintsByAuthor(author);
//        Set<Blueprint> lista = new HashSet<Blueprint>();
//        for(Map.Entry<Tuple<String, String>,Blueprint> entry : InMemoryBlueprintPersistence.blueprints.entrySet()){
//            if(entry.getKey().getElem1() == author){
//                String name = entry.getKey().getElem2();
//                lista.add(InMemoryBlueprintPersistence.blueprints.get(new Tuple<>(author, name)));
//            }
//
//        }
//        return lista;
        
    }

    /**
     * Método que me retorna todos los BluePrints que hay actualmente.
     * @return Set(Blueprint) - El cual contiene toda la información de los BluePrint
     * @throws BlueprintNotFoundException
     */
    public Set<Blueprint> getAllBlueprints(){
        return bpp.getAllBlueprints();
    }
}
