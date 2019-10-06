/* Saved in UTF-8 codepage: Příliš žluťoučký kůň úpěl ďábelské ódy. ÷ × ¤
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package eu.pedu.adv19s._4_1245.mira04_mirek.game;

import eu.pedu.adv19s._4_1245.mira04_mirek.AdvGSMFactory;
import eu.pedu.adv19s._4_1245.mira04_mirek.game.MirSpaceGame;
import eu.pedu.adv19s._4_1245.mira04_mirek.game.Room;
import eu.pedu.adv19s_fw.game_txt.IGSMFactory;
import eu.pedu.adv19s_fw.game_txt.IPlace;

import eu.pedu.adv19s_fw.scenario.Scenario;
import eu.pedu.adv19s_fw.scenario.ScenarioStep;
import eu.pedu.adv19s_fw.scenario.TypeOfStep;

import eu.pedu.adv19s_fw.test_util.common.TestException;
import eu.pedu.adv19s_fw.test_util.game_txt_test.ScenarioSummary;
import eu.pedu.adv19s_fw.test_util.game_txt_test.ATestVisitor;
import eu.pedu.adv19s_fw.test_util.game_txt_test.ASolutionTester;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;



/*******************************************************************************
 * Instance třídy {@code T19s02_Tester} testují správné zapracování<br>
 * modifikace s kódem <b>19s02</b>, požadující upravit odevzdaný program<br>
 * následovně:<br>
 * <br>
 * Na konec zprávy vypisované jako odpověď hry na zadání příkazu<br>
 * přidat řádek s textem:<br><br>
 * <b><tt>
 * §Not visited: [Name1, Name2, Name3, ..., NameN]
 * </tt></b><br>
 * <br>
 * Kde v hranatých závorkách bude abecedně seřazený seznam<br>
 * čárkami oddělených názvů prostorů testované hry,<br>
 * které hráč během aktuální hry ještě <b>nenavštívil</b>.<br>
 * Názvy <b>Name1</b>, <b>Name2</b> atd. ve výše  uvedeném textu<br>
 * zastupují názvy prostorů testované hry.<br>
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 2018-Winter
 */
public class T12_NotVisited
     extends ASolutionTester
{
//\CC== CLASS CONSTANTS (CONSTANT CLASS/STATIC ATTRIBUTES/FIELDS) ==============

    /** Identifikátor testovaného zadání. */
    public static final String TEST_ID = "19s02";

    /** Požadovaný tvar začátku posledního řádku. */
    protected final static String START = "Not visited: [";

    /** Požadovaný oddělovač názvů. */
    protected final static String SEPARATOR = ", ";

    /** Požadovaný ukončovací řetězec. */
    protected final static String END = "]";

    /** Seznam výsledků provedených testů. */
    private static final List<ScenarioSummary> INFOS = new ArrayList<>();
    
    
    //protected static Set<String> nenavstiveno;



//\CV== CLASS VARIABLES (VARIABLE CLASS/STATIC ATTRIBUTES/FIELDS) ==============



//##############################################################################
//\CI== CLASS (STATIC) INITIALIZER (CLASS CONSTRUCTOR) =========================
//\CF== CLASS (STATIC) FACTORY METHODS =========================================
//\CG== CLASS (STATIC) GETTERS AND SETTERS =====================================

    /***************************************************************************
     * Vrátí tovární objekt testované aplikace.
     * Objekt se zadá před překladem vhodným odkomentováním správných řádků.
     *
     * @return Tovární objekt testované aplikace
     */
    public static IGSMFactory Txx_GSM_Factory_get()
    {
        IGSMFactory factory = new AdvGSMFactory();
        return factory;
    }
    

   


//\CM== CLASS (STATIC) REMAINING NON-PRIVATE METHODS ===========================
//\CP== CLASS (STATIC) PRIVATE AND AUXILIARY METHODS ===========================



//##############################################################################
//\IC== INSTANCE CONSTANTS (CONSTANT INSTANCE ATTRIBUTES/FIELDS) ===============
//\IV== INSTANCE VARIABLES (VARIABLE INSTANCE ATTRIBUTES/FIELDS) ===============



//##############################################################################
//\II== INSTANCE INITIALIZERS (CONSTRUCTORS) ===================================

    /***************************************************************************
     * Vytvoří tester prověřující řešení zadání specifikovaného
     * v dokumentačním komentáři třídy.
     */
    public T12_NotVisited()
    {
        super(TEST_ID, "", Visitor19s02::new);
    }



//\IA== INSTANCE ABSTRACT METHODS ==============================================
//\IG== INSTANCE GETTERS AND SETTERS ===========================================
    

        
//\IM== INSTANCE REMAINING NON-PRIVATE METHODS =================================
//\IP== INSTANCE PRIVATE AND AUXILIARY METHODS =================================



//##############################################################################
//\NT== NESTED DATA TYPES ======================================================

////////////////////////////////////////////////////////////////////////////////
//\N1C /////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////

    /***************************************************************************
     * Instance třídy {@code Visitor19s02} představují návštěvníky prověřující
     * splnění zadání definovaného v dokumentačním komentáři vnější třídy.
     */
    private static class Visitor19s02
                 extends ATestVisitor
    {
    //\CC== CLASS CONSTANTS (CONSTANT CLASS/STATIC ATTRIBUTES/FIELDS) ==========
    //\CV== CLASS VARIABLES (VARIABLE CLASS/STATIC ATTRIBUTES/FIELDS) ==========


    
    //##########################################################################
    //\CI== CLASS (STATIC) INITIALIZER (CLASS CONSTRUCTOR) =====================
    //\CF== CLASS (STATIC) FACTORY METHODS =====================================
    //\CG== CLASS (STATIC) GETTERS AND SETTERS =================================
//        public void NotVisited(Set<String> string)
//        {
//            nenavstiveno = string;
//            
//        }
        
        
        
//    public static Collection<Room> setNotVisited()
//    {
//        return notVisited;
//    }
    //\CM== CLASS (STATIC) REMAINING NON-PRIVATE METHODS =======================
    //\CP== CLASS (STATIC) PRIVATE AND AUXILIARY METHODS =======================



    //##########################################################################
    //\IC== INSTANCE CONSTANTS (CONSTANT INSTANCE ATTRIBUTES/FIELDS) ===========

        /** Množina doposud nenavštívených místností dané hry. */
        public final Set<String> notVisited = new HashSet<>();



    //\IV== INSTANCE VARIABLES (VARIABLE INSTANCE ATTRIBUTES/FIELDS) ===========



    //##########################################################################
    //\II== INSTANCE INITIALIZERS (CONSTRUCTORS) ===============================

        /***********************************************************************
         * Vytvoří návštěvníka metod testujících fungování hry podle
         * modifikovaného zadání definovaného v konstantě {@link #DESCRIPTION}.
         *
         * @param myTest  Zadavatel požadující vyřešení zadání
         *                definovaného v konstantě {@link #DESCRIPTION}
         * @param factory Tovární objekt poskytující základní objekty
         *                prověřované aplikace
         */
        Visitor19s02(ASolutionTester myTest, IGSMFactory factory)
        {
            super(myTest, factory);
        }



    //\IA== INSTANCE ABSTRACT METHODS ==========================================
    //\IG== INSTANCE GETTERS AND SETTERS =======================================

        /***********************************************************************
         * Vrátí sdružený tester, jehož zadání prověřuje.
         *
         * @return Sdružený tester
         */
        @Override
        public ASolutionTester getTester()
        {
            return myTest;
        }



    //\IM== INSTANCE REMAINING NON-PRIVATE METHODS =============================

        /***********************************************************************
         * Akce, která se má provést po spuštění hry před testem prvního kroku:
         * zapamatuje si názvy všech prostorů hry převedené na malá písmena.
         *
         * @param scenario  Scénář definující proces testování
         */
        @Override
        public void afterGameStart(Scenario scenario)
        {
            notVisited.clear();
            Collection<? extends IPlace> allPlaces;
            allPlaces = game.getWorld().getAllPlaces();
            for (IPlace iPlace : allPlaces) {
                String name = iPlace.getName().toLowerCase();
                notVisited.add(name);
            }
            //NotVisited(notVisited);
            
        }


        /***********************************************************************
         * Akce, která se má provést po testu aktuálního kroku:
         * odebere z kolekce název aktuálního prostoru
         * a zkontroluje poslední řádek zprávy.
         *
         * @param step      Aktuálně testovaný krok scénáře
         * @param message   Zpráva vrácená hrou v daném kroku
         */
        @Override
        public void afterStepTest(ScenarioStep step, String message)
        {
            String itemName = getGame().getWorld()
                                       .getCurrentPlace()
                                       .getName()
                                       .toLowerCase();
           
            notVisited.remove(itemName);
            //NotVisited(notVisited);

            //Najde a zkontroluje poslední řádek
            String[] parts  = message.split("§");
            int      number = parts.length;
            if (number < 2) {
                throw new TestException(
                        "\nChybí požadovaný závěrečný řádek");
            }
            if (number > 2) {
                throw new TestException(
                        "\nNečekaný znak § v závěrečné zprávě");
            }
            String line = parts[1];
            if (! line.startsWith(START)) {
                throw new TestException(
                        "\nZávěrečný řádek nemá požadovaný začátek");
            }
            line = line.trim();
            if (! line.endsWith(END)) {
                throw new TestException(
                        "\nZávěrečný řádek nemá požadovaný konec");
            }
            if (step.typeOfStep == TypeOfStep.tsNOT_START) {
                return;
            }
            String answer = line.substring(START.length(),
                                           line.length() - END.length()).trim();
            String[] nameArr;
            if (answer.isEmpty()) {
                nameArr = new String[0];
            }
            else {
                nameArr = answer.split(SEPARATOR);
            }
            Set<String> names = new HashSet<>(Arrays.asList(nameArr));

            if (notVisited.size() != names.size()) {
                throw new TestException(
                       "\nNesouhlasí počet uvedených nenavštívených místností");
            }
            for (Iterator<String> it = names.iterator(); it.hasNext();) {
                String name   = it.next();
                String tested = name.toLowerCase();
                if (notVisited.contains(tested)) {
                    it.remove();
                }
                else {
                    throw new TestException(
                        "\nChybně uvedený nenavštívěný prostor: " + name);
                }
            }
        }


        /***********************************************************************
         * Akce, která se má provést po testu posledního kroku.
         *
         * @param summary Přepravka s kompletními informacemi o průběhu hry
         */
        @Override
        public void afterGameEnd(Throwable exception, String verboseMessage)
        {
            super.afterGameEnd(exception, verboseMessage);
        }



    //\IP== INSTANCE PRIVATE AND AUXILIARY METHODS =============================



    //##########################################################################
    //\NT== NESTED DATA TYPES ==================================================
    }



//##############################################################################
//\MM== MAIN METHOD ============================================================

    /***************************************************************************
     * Metoda spouštějící celou aplikaci.
     *
     * @param args Parametry příkazového řádku
     */
    public static void main(String[] args)
    {
        T12_NotVisited tester = new T12_NotVisited();
        IGSMFactory factory = Txx_GSM_Factory_get();
        tester.test(factory);
        System.exit(0);
    }
}
