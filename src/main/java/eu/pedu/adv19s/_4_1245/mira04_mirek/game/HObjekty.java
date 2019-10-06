/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package eu.pedu.adv19s._4_1245.mira04_mirek.game;

import eu.pedu.adv19s_fw.game_txt.IItem;




/*******************************************************************************
 * Instance třídy {@code EmptyItem} přestavují objekty v prostorech.
 * Objekty mohou být jak věci, tak i osoby či jiné skutečnosti (vůně,
 * světlo, fluidum, ...).
 * <p>
 * Některé z objektů mohou charakterizovat stav prostoru (např. je rozsvíceno),
 * jiné mohou být určeny k tomu, aby je hráč "zvednul" a získal tím nějakou
 * schopnost či možnost projít nějakým kritickým místem hry
 * (např. klíč k odemknutí dveří).
 * <p>
 * Rozhodnete-li se použít ve hře objekty, které budou obsahovat jiné objekty,
 * (truhla, stůl, ...), můžete je definovat paralelně jako zvláštní druh
 * prostoru, do kterého se "vstupuje" např. příkazem "<i>prozkoumej truhlu</i>"
 * a který se opouští např. příkazem "<i>zavři truhlu</i>".
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 2018-Winter
 */
public   class HObjekty
       extends ANamed
    implements IItem
{
//\CC== CLASS CONSTANTS (CONSTANT CLASS/STATIC ATTRIBUTES/FIELDS) ==============
    
    /** Váha nepřenositelných h-objektů. */
    private static final int HEAVY = Hands.CAPACITY +1;
    
    /** Příznak h-objektu, který je malý tudíž nevyžaduje držení rukou*/
    static final char POCKET = '0';
    
     /** Příznak standardního přenositelného h-objektu. */ 
    static final char STANDARD = '1';
    
    /** Příznak nutnosti použít ke zvednutí h-objektu obě ruce. */
    static final char DOUBLE_HAND = '2';
    
    /** Příznak nepřenositelnosti h-objektu. */ 
    static final char NOT_MOVABLE = '#'; 
    
//\CV== CLASS VARIABLES (VARIABLE CLASS/STATIC ATTRIBUTES/FIELDS) ==============



//##############################################################################
//\CI== CLASS (STATIC) INITIALIZER (CLASS CONSTRUCTOR) =========================
//\CF== CLASS (STATIC) FACTORY METHODS =========================================
//\CG== CLASS (STATIC) GETTERS AND SETTERS =====================================
//\CM== CLASS (STATIC) REMAINING NON-PRIVATE METHODS ===========================
//\CP== CLASS (STATIC) PRIVATE AND AUXILIARY METHODS ===========================



//##############################################################################
//\IC== INSTANCE CONSTANTS (CONSTANT INSTANCE ATTRIBUTES/FIELDS) ===============
     /** Váha h-objektu. */ 
     private final int weight;
    
//\IV== INSTANCE VARIABLES (VARIABLE INSTANCE ATTRIBUTES/FIELDS) ===============



//##############################################################################
//\II== INSTANCE INITIALIZERS (CONSTRUCTORS) ===================================

    /***************************************************************************
     * Vytvoří objekt se zadaným názvem a dalšími zadanými vlastnostmi.
     * Tyto dodatečné vlastnosti se zadávají prostřednictvím předpony
     * vkládané před vlastní název objektu
     *
     * @param name Název vytvářeného objektu
     */
    HObjekty(String name)
    {
        super(name.substring(1));
        
        int estimatedWeight = 0;
        char prefix = name.charAt(0);
        switch(prefix)
        {
            case POCKET: break;
                
            case STANDARD: estimatedWeight=1; break;
                
            case DOUBLE_HAND: estimatedWeight = 2; break;
                
            case NOT_MOVABLE: estimatedWeight = HEAVY; break;
                
            default: throw new RuntimeException("\n Neznáma hodnota prefixu: "
                    +  prefix);
                       
        }
        weight = estimatedWeight;
    }



//\IA== INSTANCE ABSTRACT METHODS ==============================================
//\IG== INSTANCE GETTERS AND SETTERS ===========================================

    /***************************************************************************
     * Vrátí váhu předmětu, resp. charakteristiku jí odpovídající.
     * Objekty, které není možno zvednout,
     * mají váhu větší, než je kapacita batohu.
     *
     * @return Váha objektu
     */
    @Override
    public int getWeight()
    {
        return weight;
    }



//\IM== INSTANCE REMAINING NON-PRIVATE METHODS =================================
//\IP== INSTANCE PRIVATE AND AUXILIARY METHODS =================================



//##############################################################################
//\NT== NESTED DATA TYPES ======================================================
}
