/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package eu.pedu.adv19s._4_1245.mira04_mirek.game;

import static eu.pedu.adv19s_fw.scenario.TypeOfStep.tsHELP;
import eu.pedu.adv19s_fw.utilities.UncompletedMethodException;
import java.util.Collection;
import java.util.stream.Collectors;
import static eu.pedu.adv19s._4_1245.mira04_mirek.game.Texts.*;
import eu.pedu.adv19s_fw.game_txt.INamed;
import java.util.Optional;



/*******************************************************************************
 * Instance třídy {@code EmptyAction} zpracovávají příkazy, které
 * ???.
 * <p>
 * Instance tříd akcí jsou efektivně jedináčci,
 * ale není třeba to v definici třídy explicitně zabezpečovat, protože vytvoření
 * a následnou správu všech akcí má starosti k tomu definovaný správce,
 * který zabezpečí, aby od každé třídy akce vznikla pouze jediná instance.
 * </p>
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 2018-Winter
 */
public class ActionPlant
     extends AAction
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
//\IV== INSTANCE VARIABLES (VARIABLE INSTANCE ATTRIBUTES/FIELDS) ===============



//##############################################################################
//\II== INSTANCE INITIALIZERS (CONSTRUCTORS) ===================================

    /***************************************************************************
     * Vytvoří novou instanci akce pro přesunutí hráče 
     * z aktuálního prostoru do zadaného sousedního prostoru.
     */
    ActionPlant()
    {
        super (pZASAĎ,
         "Metoda ověří, zda jsme zdali správný počet argumentů,\n"
        + " zjistí, zda jsme na správném místě pro zasazení semínek\n"
        + " a zda semínka máme u sebe.");
    }



//\IA== INSTANCE ABSTRACT METHODS ==============================================
//\IG== INSTANCE GETTERS AND SETTERS ===========================================
//\IM== INSTANCE REMAINING NON-PRIVATE METHODS =================================

    /***************************************************************************
     * Metoda realizující reakci hry na zadání daného příkazu.
     * Počet parametrů je závislý na konkrétním příkazu,
     * např. příkazy <i>konec</i> a <i>nápověda</i> nemají parametry,
     * příkazy <i>jdi</i> a <i>seber</i> mají jeden parametr
     * příkaz <i>použij</i> muže mít dva parametry atd.
     *
     * @param arguments Parametry příkazu;
     *                  jejich počet muže byt pro každý příkaz jiný
     * @return Text zprávy vypsané po provedeni příkazu
     */
    @Override
    public String execute(String... arguments)
    {
        if (arguments.length < 2)
        {
            return Texts.zH_OBJEKT_NEZADAN;
        }
        
        String itemName = arguments[1];
        
        SpaceShip spaceship = SpaceShip.getInstance();
        Room currentRoom = spaceship.getCurrentPlace();
        
        Hands hands = (Hands) MirSpaceGame.getInstance().getBag();
        Optional<HObjekty> oItem = hands.getOItem(itemName);
        if(!oItem.isPresent()){
            return Texts.zNENÍ_V_BATOHU;
        }
        if(!Texts.SEMÍNKA_ROSTLIN.equalsIgnoreCase(itemName)){
            return Texts.zTOTO_NELZE_ZASADIT;
        }
        
        if(!currentRoom.toString().equalsIgnoreCase(Texts.ZEMĚ)){
            return Texts.zNEZASAZENO;
        }

        return Texts.zZASADIL;
        
    }
    



//\IP== INSTANCE PRIVATE AND AUXILIARY METHODS =================================



//##############################################################################
//\NT== NESTED DATA TYPES ======================================================
}
