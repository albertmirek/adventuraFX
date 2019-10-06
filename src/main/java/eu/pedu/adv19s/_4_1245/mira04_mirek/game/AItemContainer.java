/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.pedu.adv19s._4_1245.mira04_mirek.game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import eu.pedu.adv19s_fw.game_txt.IItemContainer;
import eu.pedu.adv19s_fw.game_txt.INamed;
import java.util.Optional;

/**
 *
 * @author Panda
 */
abstract class AItemContainer
         extends ANamed
        implements IItemContainer
{
    

//##############################################################################
//\IC== INSTANCE CONSTANTS (CONSTANT INSTANCE ATTRIBUTES/FIELDS) ===============
    
    /** Názvy h-objektů v prostoru na počátku hry. */ 
    private final String[] itemNames;
    
      /** Kolekce aktuálních předmětů v prostoru */
    private final Collection<HObjekty> items;
    
    /**Nezměnitelná kolekce aktuálních předmětů daného prostoru */
    private final Collection<HObjekty> exportedItems;
    
    
    
//##############################################################################
//== CONSTUCTORS AND FACTORY METHODS ===========================================
    
    /***************************************************************************
    * Vytvoří rodičovský podobjekt kontejneru h-objektů. 
    * 
    * @param name      Název dceřiného objektu 
    * @param itemNames Názvy h-objektů v prostoru na počátku hry 
    */ 
    AItemContainer(String name, String... itemNames)
    {
        super(name);
        
        this.itemNames = itemNames;
        this.items = new ArrayList<>();
        this.exportedItems = Collections.unmodifiableCollection(items);
    }
    
    
    
    
//##############################################################################
//\IG== INSTANCE GETTERS AND SETTERS ===========================================
    
     /**************************************************************************
     * Vrátí h-objekt se zadaným názvem zabalený do objektu typu  
     * {@link Optional}{@code <}{@link Item}{@code >}. 
     * 
     * @return H-objekt se zadaným názvem zabalený do objektu typu  
     *         {@link Optional}{@code <}{@link Item}{@code >} 
     */
    protected Optional<HObjekty> getOItem(String name)
    {
        return INamed.getO(name,items);
    }
    
    /***************************************************************************
     * Vrátí kolekci objektů nacházejících se v daném prostoru.
     *
     * @return Kolekce objektů nacházejících se v daném prostoru
     */
    @Override
    public Collection<HObjekty> getItems()
    {
        return exportedItems;
    }

    
//##############################################################################
//\IM== INSTANCE REMAINING NON-PRIVATE METHODS =================================
    
    /***************************************************************************
    * Odebere zadaný h-objekt ze své kolekce h-objektů. 
    * 
    * @param item Odebíraný h-objekt 
    */ 
   void removeItem(HObjekty item) 
   { 
       items.remove(item); 
   } 
   
   /*************************************************************************** 
   * Vyčistí kontejner a uloží do něj objekty reprezentující 
   * h-objekty vyskytující se v daném kontejneru na počátku hry. 
   */ 
   protected void initializeItems()
    {
        items.clear();
        Arrays.stream(itemNames)
                .map(HObjekty::new)
                .forEach(items::add);
    }
   
   /*************************************************************************** 
    * Přidá zadaný h-objekt do kontejneru. 
    * 
    * @param item H-objekt, který se má přidat do kontejneru 
    */
   protected void addItem(HObjekty Item)
   {
       items.add(Item);
   }
    

    
    
}
