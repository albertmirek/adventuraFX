/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package eu.pedu.adv19s._4_1245.mira04_mirek.game;


import eu.pedu.adv19s._4_1245.mira04_mirek.game.T12_NotVisited.*;

import java.util.Collection;
import eu.pedu.adv19s_fw.game_txt.IPlace;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;



/*******************************************************************************
 * Instance třídy {@code EmptyPlace} představují prostory ve hře.
 * Dosažení prostoru si můžeme představovat jako částečný cíl,
 * kterého se hráč ve hře snaží dosáhnout.
 * Prostory mohou být místnosti, planety, životní etapy atd.
 * Prostory mohou obsahovat různé objekty,
 * které mohou hráči pomoci v dosažení cíle hry.
 * Každý prostor zná své aktuální bezprostřední sousedy
 * a ví, jaké objekty se v něm v daném okamžiku nacházejí.
 * Sousedé daného prostoru i v něm se nacházející objekty
 * se mohou v průběhu hry měnit.
 * <p>
 * V tomto programu jsou prostory ...
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 2018-Winter
 */
public   class Room
       extends AItemContainer
    implements IPlace
{
//\CC== CLASS CONSTANTS (CONSTANT CLASS/STATIC ATTRIBUTES/FIELDS) ==============
//\CV== CLASS VARIABLES (VARIABLE CLASS/STATIC ATTRIBUTES/FIELDS) ==============



//##############################################################################
//\CI== CLASS (STATIC) INITIALIZER (CLASS CONSTRUCTOR) =========================
//\CF== CLASS (STATIC) FACTORY METHODS =========================================
//\CG== CLASS (STATIC) GETTERS AND SETTERS =====================================
//\CM== CLASS (STATIC) REMAINING NON-PRIVATE METHODS ===========================
//\CP== CLASS (STATIC) PRIVATE AND AUXILIARY METHODS ===========================



//##############################################################################
//\IC== INSTANCE CONSTANTS (CONSTANT INSTANCE ATTRIBUTES/FIELDS) ===============
    /** Názvy sousedů prostoru na počátku hry. */
    private final String[] neighborNames;

    /** Aktuální sousedé daného prostoru. */
    private final Collection<Room> neighbors;

     /** Nezměnitelná kolekce aktuálních sousedů daného prostoru,
     * která však průběžně mapuje obsah kolekce {@link #neighbors}. */
    private final Collection<Room> exportedNeighbors;
    
    




//\IV== INSTANCE VARIABLES (VARIABLE INSTANCE ATTRIBUTES/FIELDS) ===============



//##############################################################################
//\II== INSTANCE INITIALIZERS (CONSTRUCTORS) ===================================

    /***************************************************************************
     /**************************************************************************
          * Vytvoří nový prostor se zadaným názvem a
         * zadanými názvy jeho počátečních sousedů a h-objektů.
         *
         * @param name          Název daného prostoru
         * @param neighborNames Názvy sousedů prostoru na počátku hry
         * @param itemNames     Názvy h-objektů v prostoru na počátku hry
     */
    Room(String name, String[] neighborNames, String... itemNames)
    {
        super(name, itemNames);
        this.neighborNames = neighborNames;
        this.neighbors = new ArrayList<>();
        this.exportedNeighbors= Collections.unmodifiableCollection(neighbors);


    }



//\IA== INSTANCE ABSTRACT METHODS ==============================================
//\IG== INSTANCE GETTERS AND SETTERS ===========================================

    /***************************************************************************
     * Vrátí kolekci sousedů daného prostoru, tj. kolekci prostorů,
     * do nichž je možno se z tohoto prostoru přesunout příkazem typu
     * {@link eu.pedu.adv19s_fw.scenario.TypeOfStep#tsMOVE
     * TypeOfStep.tsMOVE}.
     *
     * @return Kolekce sousedů
     */
    @Override
    public Collection<Room> getNeighbors()
    {
        return exportedNeighbors;
    }
    
        






//\IM== INSTANCE REMAINING NON-PRIVATE METHODS =================================
    
    /***************************************************************************
     * Metoda inicializující daný prostor.
     * Na základě konstruktorem zapamatovaných jmen
     * inicializuje sousedy daného prostoru a přítomné předměty.
     */
    void initialize()
    {
        initializeItems();
        initializeNeighbors();
    }
    

    /***************************************************************************
     * Vyčistí kolekci {@link #neighbors} a uloží do ní předměty reprezentující
     * prostory sousedící s daným prostorem na počátku hry.
     */
    private void initializeNeighbors()
    {
        SpaceShip spaceship = SpaceShip.getInstance();
        neighbors.clear();
        Arrays.stream(neighborNames)
                .map(spaceship::getORoom)
                .map(Optional<Room>::get)
                .forEach(neighbors::add);
    }
    




//\IP== INSTANCE PRIVATE AND AUXILIARY METHODS =================================



//##############################################################################
//\NT== NESTED DATA TYPES ======================================================

}
