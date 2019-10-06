/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package eu.pedu.adv19s._4_1245.mira04_mirek.game;

import eu.pedu.adv19s_fw.game_txt.IBag;



/*******************************************************************************
 * Instance třídy {@code EmptyBag} představuje úložiště,
 * do nějž hráči ukládají objekty sebrané v jednotlivých prostorech,
 * aby je mohli přenést do jiných prostorů a/nebo použít.
 * Úložiště má konečnou kapacitu definující maximální povolený
 * součet vah objektů vyskytujících se v úložišti.
 * <p>
 * V této hře je tímto úložištěm ...
 * s kapacitou ...
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 2018-Winter
 */
public class Hands
    extends AItemContainer
    implements IBag
{
//\CC== CLASS CONSTANTS (CONSTANT CLASS/STATIC ATTRIBUTES/FIELDS) ==============

    /** Jediná instance batohu ve hře. */
    private static final Hands SINGLETON = new Hands();
    
    /** Kapacita batohu. */
    public static final int CAPACITY = 2;
    
    
    




//\CV== CLASS VARIABLES (VARIABLE CLASS/STATIC ATTRIBUTES/FIELDS) ==============

    /** Volná kapacit batohu. */
    private int remains;

//##############################################################################
//\CI== CLASS (STATIC) INITIALIZER (CLASS CONSTRUCTOR) =========================
//\CF== CLASS (STATIC) FACTORY METHODS =========================================

    /***************************************************************************
     * Tovární metoda vracející odkaz na jedninou existující instanci dané hry.
     *
     * @return Instance dané hry
     */
    static Hands getInstance()
    {
        return SINGLETON;
    }




//\CG== CLASS (STATIC) GETTERS AND SETTERS =====================================
//\CM== CLASS (STATIC) REMAINING NON-PRIVATE METHODS ===========================

//\CP== CLASS (STATIC) PRIVATE AND AUXILIARY METHODS ===========================




//##############################################################################
//\IC== INSTANCE CONSTANTS (CONSTANT INSTANCE ATTRIBUTES/FIELDS) ===============
//\IV== INSTANCE VARIABLES (VARIABLE INSTANCE ATTRIBUTES/FIELDS) ===============



//##############################################################################
//\II== INSTANCE INITIALIZERS (CONSTRUCTORS) ===================================

    /***************************************************************************
     */
    Hands()
    {
        super("Batoh_Ruce");
        
    }



//\IA== INSTANCE ABSTRACT METHODS ==============================================
//\IG== INSTANCE GETTERS AND SETTERS ===========================================

    /***************************************************************************
     * Vrátí kapacitu batohu, tj. maximální povolený součet vah objektů,
     * které je možno současně uložit do batohu.
     *
     * @return Kapacita batohu
     */
    @Override
    public int getCapacity()
    {
        return CAPACITY;
    }
    
     /**************************************************************************
    * Metoda inicializující batoh. 
    * Protože v této hře má hráč na počátku hry prázdný batoh, 
    * stačí pouze vyčistit kolekci {@link #items}. 
    */    
    void initialize()
    {
        initializeItems();
        remains = CAPACITY;
    }

    /***************************************************************************
    * Odebere zadaný h-objekt ze své kolekce h-objektů. 
    * 
    * @param item Odebíraný h-objekt 
    */ 
    void removeItem(HObjekty item) 
    { 
       super.removeItem(item);
       remains += item.getWeight();
    } 

//\IM== INSTANCE REMAINING NON-PRIVATE METHODS =================================
//\IP== INSTANCE PRIVATE AND AUXILIARY METHODS =================================
    /***************************************************************************
    * Vejde-li se zadaný h-objekt do batohu, přidá jej; 
    * poté vrátí zprávu o výsledku. 
    * 
    * @param item H-objekt, který se má přidat do batohu 
    * @return Zpráva o výsledku: {@code true} = byl přidán, 
    *         {@code false} = nebyl přidán 
    */
    boolean tryAddItem(HObjekty item)
    {
        if (item.getWeight() > remains){
            return false;}
        addItem(item);
        remains -= item.getWeight();
        return true;
    }


//##############################################################################
//\NT== NESTED DATA TYPES ======================================================
}
