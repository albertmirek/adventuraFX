/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package eu.pedu.adv19s._4_1245.mira04_mirek.game;

import java.util.Collection;
import eu.pedu.adv19s_fw.game_txt.IWorld;

import java.util.ArrayList;
import java.util.Collections;
import static eu.pedu.adv19s._4_1245.mira04_mirek.game.Texts.*;
import static eu.pedu.adv19s._4_1245.mira04_mirek.game.HObjekty.*;

import java.util.Optional;
import eu.pedu.adv19s_fw.game_txt.INamed;



/*******************************************************************************
 * Instance třídy {@code EmptyWorld} reprezentuje svět hry.
 * V dané hře musí být definována jako jedináček.
 * Má na starosti uspořádání jednotlivých prostorů a udržuje informaci o tom,
 * ve kterém z nich se hráč právě nachází.
 * Vzájemné uspořádání prostorů se může v průběhu hry měnit –
 * prostory mohou v průběhu hry získávat a ztrácet sousedy.
 * <p>
 * V této hře je světem hry ...
 * a jednotlivé prostory jsou ....
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 2018-Winter
 */
public   class SpaceShip
    implements  IWorld
{
//\CC== CLASS CONSTANTS (CONSTANT CLASS/STATIC ATTRIBUTES/FIELDS) ==============

    /** Odkaz na jedinou instanci (jedináčka) této hry. */
    private static final SpaceShip SINGLETON = new SpaceShip();

   /** Místnost, v níž hra začíná. */
    private final Room startingRoom;



//\CV== CLASS VARIABLES (VARIABLE CLASS/STATIC ATTRIBUTES/FIELDS) ==============



//##############################################################################
//\CI== CLASS (STATIC) INITIALIZER (CLASS CONSTRUCTOR) =========================
//\CF== CLASS (STATIC) FACTORY METHODS =========================================

    /***************************************************************************
     * Tovární metoda vracející odkaz na jedninou existující instanci dané hry.
     *
     * @return Instance dané hry
     */
    static SpaceShip getInstance()
    {
        return SINGLETON;
    }



//\CG== CLASS (STATIC) GETTERS AND SETTERS =====================================
//\CM== CLASS (STATIC) REMAINING NON-PRIVATE METHODS ===========================



//\CP== CLASS (STATIC) PRIVATE AND AUXILIARY METHODS ===========================




//##############################################################################
//\IC== INSTANCE CONSTANTS (CONSTANT INSTANCE ATTRIBUTES/FIELDS) ===============
   
    /** Aktuální sousedé daného prostoru. */
    private final Collection<Room> rooms;

    /** Nezměnitelná kolekce aktuálních sousedů daného prostoru,
     * která však průběžně mapuje obsah kolekce {@link #neighbors}. */
    private final Collection<Room> exportedRooms;
//\IV== INSTANCE VARIABLES (VARIABLE INSTANCE ATTRIBUTES/FIELDS) ===============

    /** */
    private Room currentArea;


//##############################################################################
//\II== INSTANCE INITIALIZERS (CONSTRUCTORS) ===================================

    /***************************************************************************
     * Soukromý konstruktor definující jedinou instanci.
     * Protože je soukromý, musí být definován, i když má prázdné tělo.
     */
    private SpaceShip()
    {
        rooms = new ArrayList<>();
        exportedRooms = Collections.unmodifiableCollection(rooms);

        startingRoom = new Room(KRYO_ODDĚLENÍ,
                new String[]{ŠATNA, KONTROLNÍ_STANICE},
                NOT_MOVABLE + TERMINAL_STANICE);
        rooms.add(startingRoom);
        rooms.add(new Room(ŠATNA,
                new String[] {KRYO_ODDĚLENÍ},
                POCKET+ID_KARTA));

        rooms.add(new Room(KONTROLNÍ_STANICE,
                new String[] {CHODBA,SKLAD,KRYO_ODDĚLENÍ},
                STANDARD +PROPISKA, STANDARD+BLOK, DOUBLE_HAND+SEKERA));

        rooms.add(new Room(CHODBA,
                new String[] {BIO_LABORATOŘ,VZLETOVÁ_RAMPA,KONTROLNÍ_STANICE},
                NOT_MOVABLE+BARIKÁDA_BIO));

        rooms.add(new Room(BIO_LABORATOŘ,
                new String[] {CHODBA},
                POCKET +SEMÍNKA_ROSTLIN,STANDARD + CIGARETY));

        rooms.add(new Room(VZLETOVÁ_RAMPA,
                new String[] {CHODBA, LETOVÝ_MODUL}));

        rooms.add(new Room(LETOVÝ_MODUL,
                new String[] {VZLETOVÁ_RAMPA, VESMÍR},
                NOT_MOVABLE+TERMINAL_MODULU));

        rooms.add(new Room(VESMÍR,
                new String[] {VZLETOVÁ_RAMPA, ZEMĚ,MARS}));

        rooms.add(new Room(ZEMĚ,
                new String[] {VESMÍR,MARS}));

        rooms.add(new Room(MARS,
                new String[] {VESMÍR,ZEMĚ}));

        rooms.add(new Room(SKLAD,
                new String[] {KONTROLNÍ_STANICE}));

    }



//\IA== INSTANCE ABSTRACT METHODS ==============================================
//\IG== INSTANCE GETTERS AND SETTERS ===========================================

    /***************************************************************************
     * Vrátí kolekci odkazů na všechny prostory vystupující ve hře.
     *
     * @return Kolekce odkazů na všechny prostory vystupující ve hře
     */
    @Override
    public Collection<Room> getAllPlaces()
    {
        return exportedRooms;
    }


    /***************************************************************************
     * Vrátí odkaz na aktuální prostor,
     * tj. na prostor, v němž se hráč pravé nachází.
     *
     * @return Prostor, v němž se hráč pravé nachází
     */
    @Override
    public Room getCurrentPlace()
    {
        return currentArea;
    }
    
    public Room getStartingRoom()
    {
        return startingRoom;
    }

    /***************************************************************************
     * Nastaví zadaný prostor jako aktuální,
     * tj. jako prostor, v němž se hráč právě nachází.
     *
     * @param destinationRoom Nastavovaný prostor
     */
    void setCurrentArea(Room destinationRoom)
    {
        currentArea = destinationRoom;
    }



//\IM== INSTANCE REMAINING NON-PRIVATE METHODS =================================

    /***************************************************************************
    * Metoda inicializující svět hry.
    * Nejprve inicializuje všechny prostory
    * a pak nastaví výchozí aktuální prostor.
    */
    void initialize()
    {
        rooms.forEach(Room::initialize);
        currentArea = startingRoom;
    }


    /***************************************************************************
    * Vrátí prostor se zadaným názvem zabalený v objektu typu {@link Optional}.
    *
    * @param name Název požadovaného prostoru
    * @return Zabalený prostor se zadaným názvem
    */
    public Optional<Room> getORoom(String name)
    {
        Optional<Room> result = INamed.getO(name, rooms);
        return result;
    }



//\IP== INSTANCE PRIVATE AND AUXILIARY METHODS =================================



//##############################################################################
//\NT== NESTED DATA TYPES ======================================================


}
