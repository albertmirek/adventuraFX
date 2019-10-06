/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package eu.pedu.adv19s._4_1245.mira04_mirek.game;

import eu.pedu.adv19s._4_1245.mira04_mirek.AdvGSMFactory;
import static eu.pedu.adv19s._4_1245.mira04_mirek.game.Texts.*;
import eu.pedu.adv19s_fw.game_txt.IGSMFactory;
import eu.pedu.adv19s_fw.scenario.AScenarioManager;
import eu.pedu.adv19s_fw.scenario.ScenarioStep;
import eu.pedu.adv19s_fw.scenario.TypeOfScenario;

import static eu.pedu.adv19s_fw.scenario.TypeOfStep.*;



/*******************************************************************************
 * Instance třídy {@code EmptyScenarioManager} slouží jako
 * šablona (nebo chcete-li kostra) správce scénářů, jejichž prostřednictvím
 * budou testovací programy prověřovat správnou funkci plánované hry.
 * <p>
 * Každý správce musí definovat:
 * <ul>
 *   <li><b>Základní úspěšný scénář</b> nazvaný <b><code>_HAPPY_"</code></b>
 *     definující některý z úspěšných postupů jak dosáhnout cíle hry.
 *   </li>
 *   <li><b>Základní chybový scénář</b> nazvaný <b><code>_MISTAKE_</code></b>
 *     definující reakce hry na typické chyby při zadávání příkazů.
 *   </li>
 * </ul>
 * <p>
 * Jednotlivé spravované scénáře se musí lišit svým názvem,
 * přičemž názvy základního úspěšného a základního chybového scénáře
 * jsou předem pevně dány a není je možno změnit.
 * <p>
 * Jednotlivé scénáře jsou iterovatelné a "streamovatelné" posloupností kroků
 * specifikovaných instancemi třídy
 * {@link eu.pedu.adv19s_fw.scenario.ScenarioStep}
 * z frameworku, do nějž je třeba vyvíjenou hru hra začlenit.
 * <p>
 * Správce scénářů je jedináček, který má na starosti všechny scénáře
 * týkající se s ním sdružené hry.
 * <p>
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 2018-Winter
 */
public   class AdvScenarioManager
       extends AScenarioManager
    implements IAuthorAM
{
//\CC== CLASS CONSTANTS (CONSTANT CLASS/STATIC ATTRIBUTES/FIELDS) =============

    
    /** Tovární třída, jejíž instancemi jsou tovární objekty poskytující
     *  instanci správce scénářů i hry, jejíž scénáře daný správce spravuje. */
    private final static Class<? extends IGSMFactory> FACTORY_CLASS =
                                                    AdvGSMFactory.class;

    
    /** Název scénáře s kroky pro otestování povinně definovaných akcí. */
    private static final String REQUIRED_STEPS_SCENARIO_NAME = "REQUIRED";



    /**************************************************************************
     * Počáteční krok hry, který je pro všechny scénáře shodný.
     * <p>
     * Konstruktor plnohodnotné instance třídy {@link ScenarioStep}
     * vyžaduje následující parametry:
     <pre> {@code
TypeOfStep typeOfStep; //Typ daného kroku scénáře
String     command;    //Příkaz realizující tento krok scénáře
String     message;    //Zpráva vypsaná po zadání příkazu
String     place;      //Prostor, v němž skončí hráč po zadání příkazu
String[]   neighbors;  //Sousedé aktuálního prostoru (= východy)
String[]   items;      //Objekty vyskytující se v daném prostoru
String[]   bag;        //Aktuální obsah batohu
     }</pre>
    =======================================================================<br>
     * Kroky scénáře musejí navíc vyhovovat následujícím požadavkům:
     * <ul>
     *   <li>Žádná z položek nesmí obsahovat prázdný odkaz.</li>
     *   <li>S výjimkou položky {@code command} nesmí být žádný řetězec
     *     prázdný (tj. {@code ""})</li>
     *   <li>Prázdný řetězec se nesmí objevit ani jako položka některého
     *     z polí {@code neighbors}, {@code items} či {@code bag}</li>
     * </ul>
     * <br>
    **************************************************************************/
     public static final ScenarioStep START_STEP =
    new ScenarioStep(0, tsSTART, "", //Název spouštěcího příkazu = ""
            zUVÍTÁNÍ
            ,
            KRYO_ODDĚLENÍ,
            new String[] { ŠATNA, KONTROLNÍ_STANICE },
            new String[] { TERMINAL_STANICE },
            new String[] { }
        );


/***************************************************************************
     * Kroky základního úspěšného scénáře
     * popisující očekávatelný úspěšný průběh hry.
     * Z těchto kroků sestavený scénář nemusí být nutně nejkratším možným
     * (takže to vlastně ani nemusí být základní úspěšný scénář),
     * ale musí vyhovovat všem okrajovým podmínkám zadání,
     * tj. musí obsahovat minimální počet kroků,
     * projít požadovaný.minimální počet prostorů
     * a demonstrovat použití všech požadovaných příkazů.
     */
    private static final ScenarioStep[] HAPPY_SCENARIO_STEPS =
    {
        START_STEP,

        new ScenarioStep(tsMOVE, pJDI + " " + ŠATNA,
            zPŘESUN + ŠATNA
            ,
            ŠATNA,
            new String[] { KRYO_ODDĚLENÍ },
            new String[] { ID_KARTA},
            new String[] {  }
        ),

        new ScenarioStep(tsTAKE, pVEZMI + " " + ID_KARTA,
            zZVEDNUTO + "" +ID_KARTA
            ,
            ŠATNA,
            new String[] { KRYO_ODDĚLENÍ },
            new String[] { },
            new String[] { ID_KARTA }
        ),

        new ScenarioStep(tsMOVE, pJDI + " " + KRYO_ODDĚLENÍ,
            zPŘESUN + "" +KRYO_ODDĚLENÍ
            ,
            KRYO_ODDĚLENÍ,
            new String[] { ŠATNA, KONTROLNÍ_STANICE },
            new String[] {  TERMINAL_STANICE},
            new String[] { ID_KARTA }
        ),

        new ScenarioStep(tsNON_STANDARD2, pNACTI + " " + ID_KARTA+ " "
                +TERMINAL_STANICE,
            zOVERIL + TERMINAL_STANICE
            ,
            KRYO_ODDĚLENÍ,
            new String[] { ŠATNA, KONTROLNÍ_STANICE },
            new String[] { TERMINAL_STANICE},
            new String[] { ID_KARTA }
        ),

        new ScenarioStep(tsMOVE, pJDI + " " + KONTROLNÍ_STANICE,
            zPŘESUN + "" + KONTROLNÍ_STANICE
            ,
            KONTROLNÍ_STANICE,
            new String[] { CHODBA,SKLAD,KRYO_ODDĚLENÍ},
            new String[] { PROPISKA, BLOK, SEKERA},
            new String[] { ID_KARTA }
        ),

        new ScenarioStep(tsTAKE, pVEZMI + " " + SEKERA,
            zZVEDNUTO + "" + SEKERA
            ,
            KONTROLNÍ_STANICE,
            new String[] { CHODBA,SKLAD,KRYO_ODDĚLENÍ},
            new String[] { PROPISKA, BLOK},
            new String[] { ID_KARTA, SEKERA }
        ),

        new ScenarioStep(tsMOVE, pJDI + " " + CHODBA,
            zPŘESUN +"" +CHODBA
            ,
            CHODBA,
            new String[] {BIO_LABORATOŘ,VZLETOVÁ_RAMPA,KONTROLNÍ_STANICE},
            new String[] { BARIKÁDA_BIO},
            new String[] { ID_KARTA, SEKERA }
        ),

        new ScenarioStep(tsNON_STANDARD1, pROZSEKEJ +" "+ BARIKÁDA_BIO,
                zROZSEKANO  + BIO_LABORATOŘ
            ,
            CHODBA,
            new String[] {BIO_LABORATOŘ,VZLETOVÁ_RAMPA,KONTROLNÍ_STANICE},
            new String[] { BARIKÁDA_BIO},
            new String[] { ID_KARTA, SEKERA }
        ),

        new ScenarioStep(tsMOVE, pJDI + " " + BIO_LABORATOŘ,
            zPŘESUN + "" + BIO_LABORATOŘ
            ,
            BIO_LABORATOŘ,
            new String[] {CHODBA },
            new String[] { SEMÍNKA_ROSTLIN,CIGARETY},
            new String[] { ID_KARTA, SEKERA }
        ),

        new ScenarioStep(tsPUT_DOWN, pPOLOŽ + " " + SEKERA,
            zPOLOŽENO + "" + SEKERA
            ,
            BIO_LABORATOŘ,
            new String[] { CHODBA},
            new String[] { SEMÍNKA_ROSTLIN,CIGARETY,SEKERA},
            new String[] { ID_KARTA }
        ),

        new ScenarioStep(tsTAKE, pVEZMI + " " + SEMÍNKA_ROSTLIN,
            zZVEDNUTO + "" + SEMÍNKA_ROSTLIN
            ,
            BIO_LABORATOŘ,
            new String[] {CHODBA },
            new String[] { CIGARETY,SEKERA},
            new String[] { ID_KARTA,SEMÍNKA_ROSTLIN }
        ),

        new ScenarioStep(tsMOVE, pJDI + " " + CHODBA,
            zPŘESUN + "" + CHODBA
            ,
            CHODBA,
            new String[] {BIO_LABORATOŘ,VZLETOVÁ_RAMPA,KONTROLNÍ_STANICE},
            new String[] { BARIKÁDA_BIO},
            new String[] { ID_KARTA,SEMÍNKA_ROSTLIN }
        ),

        new ScenarioStep(tsMOVE, pJDI + " " + VZLETOVÁ_RAMPA,
            zPŘESUN + "" + VZLETOVÁ_RAMPA
            ,
            VZLETOVÁ_RAMPA,
            new String[] { CHODBA, LETOVÝ_MODUL},
            new String[] { },
            new String[] { ID_KARTA,SEMÍNKA_ROSTLIN }
        ),

        new ScenarioStep(tsMOVE, pJDI + " " + LETOVÝ_MODUL,
            zPŘESUN + "" + LETOVÝ_MODUL
            ,
            LETOVÝ_MODUL,
            new String[] { VZLETOVÁ_RAMPA, VESMÍR},
            new String[] { TERMINAL_MODULU },
            new String[] { ID_KARTA,SEMÍNKA_ROSTLIN }
        ),

        new ScenarioStep(tsNON_STANDARD1, pZAPNI + " " + TERMINAL_MODULU,
            zNASTARTOVAN
            ,
            LETOVÝ_MODUL,
            new String[] { VZLETOVÁ_RAMPA, VESMÍR},
            new String[] { TERMINAL_MODULU},
            new String[] { ID_KARTA,SEMÍNKA_ROSTLIN }
        ),

        new ScenarioStep(tsNON_STANDARD2, pNACTI +" "+ ID_KARTA+" "+
                TERMINAL_MODULU,
            zOVERIL + TERMINAL_MODULU
            ,
            LETOVÝ_MODUL,
            new String[] { VZLETOVÁ_RAMPA, VESMÍR},
            new String[] { TERMINAL_MODULU},
            new String[] { ID_KARTA,SEMÍNKA_ROSTLIN }
        ),

        new ScenarioStep(tsMOVE, pJDI + " " + VESMÍR,
            zPŘESUN + "" + VESMÍR
            ,
            VESMÍR,
            new String[] { VZLETOVÁ_RAMPA, ZEMĚ,MARS},
            new String[] { },
            new String[] { ID_KARTA,SEMÍNKA_ROSTLIN }
        ),

        new ScenarioStep(tsMOVE, pJDI + " " + ZEMĚ,
            zPŘESUN + "" + ZEMĚ
            ,
            ZEMĚ,
            new String[] { VESMÍR,MARS},
            new String[] { },
            new String[] { ID_KARTA,SEMÍNKA_ROSTLIN }
        ),

        new ScenarioStep(tsNON_STANDARD1, pZASAĎ + " " + SEMÍNKA_ROSTLIN,
            zZASADIL
            ,
            ZEMĚ,
            new String[] { VESMÍR, MARS},
            new String[] { },
            new String[] { ID_KARTA,SEMÍNKA_ROSTLIN }
        ),

        new ScenarioStep(tsEND, pEND,
            zKONEC
            ,
            ZEMĚ,
            new String[] { VESMÍR,MARS},
            new String[] { },
            new String[] { ID_KARTA,SEMÍNKA_ROSTLIN }
        ),





    };


    /** Krok testující špatné spuštění hry je definován zvlášť,
     *  aby bylo možno správně nastavit indexy následujících kroků. */
    private static final ScenarioStep WRONG_START =
    new ScenarioStep(-1,
            tsNOT_START, "Start",
            "\nPrvním příkazem není startovací příkaz." +
            "\nHru, která neběží, lze spustit pouze startovacím příkazem.\n"
            ,
            " ",
            new String[] {},
            new String[] {},
            new String[] {}
        );


    static { ScenarioStep.setIndex(1); }


/***************************************************************************
     * Základní chybový scénář definující reakce
     * na povinnou sadu typů chybně zadaných příkazů.
     */
    private static final ScenarioStep[] MISTAKE_SCENARIO_STEPS =
    {
        WRONG_START,

        START_STEP,

//        new ScenarioStep(tsNOT_SET, "příkaz",
//            "Zpráva_vypsaná_v_reakci_na_příkaz"
//            ,
//            "Aktuální_prostor_po_vykonání_příkazu",
//            new String[] { "Soused1", "Soused2" },
//            new String[] { "Objekt_v_prostoru", "Objekt_v_prostoru" },
//            new String[] {  }
//        ),
         new ScenarioStep(tsEMPTY, "",
            zPRÁZDNÝ_PŘÍKAZ
            ,
            KRYO_ODDĚLENÍ,
            new String[] { ŠATNA, KONTROLNÍ_STANICE },
            new String[] {  TERMINAL_STANICE},
            new String[] { }
        ),

         new ScenarioStep(tsUNKNOWN, "udeř",
            zNEZNÁMÝ_PŘÍKAZ
            ,
            KRYO_ODDĚLENÍ,
            new String[] { ŠATNA, KONTROLNÍ_STANICE },
            new String[] {  TERMINAL_STANICE},
            new String[] { }
        ),

         new ScenarioStep(tsMOVE_WA, pJDI + " " ,
            zCIL_NEZADAN
            ,
            KRYO_ODDĚLENÍ,
            new String[] { ŠATNA, KONTROLNÍ_STANICE },
            new String[] {  TERMINAL_STANICE},
            new String[] { }
        ),

         new ScenarioStep(tsTAKE_WA, pVEZMI + " " ,
            zH_OBJEKT_NEZADAN
            ,
            KRYO_ODDĚLENÍ,
            new String[] { ŠATNA, KONTROLNÍ_STANICE },
            new String[] {  TERMINAL_STANICE},
            new String[] { }
        ),

         new ScenarioStep(tsPUT_DOWN_WA, pPOLOŽ + " ",
            zH_OBJEKT_NEZADAN
            ,
            KRYO_ODDĚLENÍ,
            new String[] { ŠATNA, KONTROLNÍ_STANICE },
            new String[] { TERMINAL_STANICE},
            new String[] {  }
        ),

          new ScenarioStep(tsBAD_NEIGHBOR, pJDI + " " + CHODBA,
            zNENÍ_CIL
            ,
            KRYO_ODDĚLENÍ,
            new String[] { ŠATNA, KONTROLNÍ_STANICE },
            new String[] { TERMINAL_STANICE},
            new String[] {  }
        ),

         new ScenarioStep(tsBAD_ITEM, pVEZMI + " větrák",
            zNENÍ_H_OBJEKT
            ,
           KRYO_ODDĚLENÍ,
            new String[] { ŠATNA, KONTROLNÍ_STANICE },
            new String[] { TERMINAL_STANICE},
            new String[] {  }
        ),

          new ScenarioStep(tsUNMOVABLE, pVEZMI + " " + TERMINAL_STANICE,
            zTĚŽKÝ_H_OBJEKT
            ,
            KRYO_ODDĚLENÍ,
            new String[] { ŠATNA, KONTROLNÍ_STANICE },
            new String[] { TERMINAL_STANICE },
            new String[] { }
        ),
          new ScenarioStep(tsMOVE, pJDI + " " + ŠATNA,
            zPŘESUN + "" + ŠATNA
            ,
            ŠATNA,
            new String[] { KRYO_ODDĚLENÍ },
            new String[] { ID_KARTA },
            new String[] { }
        ),
          new ScenarioStep(tsTAKE, pVEZMI + " " + ID_KARTA,
            zZVEDNUTO + "" +ID_KARTA
            ,
            ŠATNA,
            new String[] { KRYO_ODDĚLENÍ },
            new String[] { },
            new String[] { ID_KARTA }
        ),

        new ScenarioStep(tsMOVE, pJDI + " " + KRYO_ODDĚLENÍ,
            zPŘESUN + "" +KRYO_ODDĚLENÍ
            ,
            KRYO_ODDĚLENÍ,
            new String[] { ŠATNA, KONTROLNÍ_STANICE },
            new String[] {  TERMINAL_STANICE},
            new String[] { ID_KARTA }
        ),
          
          
          new ScenarioStep(tsNON_STANDARD2, pNACTI+" "+ ID_KARTA+" "+
                  TERMINAL_STANICE,
            zOVERIL+ TERMINAL_STANICE
            ,
            KRYO_ODDĚLENÍ,
            new String[] { ŠATNA, KONTROLNÍ_STANICE },
            new String[] { TERMINAL_STANICE},
            new String[] { ID_KARTA }
        ),

        new ScenarioStep(tsMOVE, pJDI + " " + KONTROLNÍ_STANICE,
            zPŘESUN + "" + KONTROLNÍ_STANICE
            ,
            KONTROLNÍ_STANICE,
            new String[] { CHODBA,SKLAD,KRYO_ODDĚLENÍ},
            new String[] { PROPISKA, BLOK, SEKERA},
            new String[] { ID_KARTA }
        ),

          new ScenarioStep(tsTAKE, pVEZMI + " " + SEKERA,
            zZVEDNUTO + "" + SEKERA
            ,
            KONTROLNÍ_STANICE,
            new String[] { CHODBA,SKLAD,KRYO_ODDĚLENÍ},
            new String[] { PROPISKA, BLOK},
            new String[] { ID_KARTA, SEKERA }
          ),

        new ScenarioStep(tsBAG_FULL, pVEZMI + " " + BLOK,
            zBATOH_PLNÝ
            ,
            KONTROLNÍ_STANICE,
            new String[] { CHODBA,SKLAD,KRYO_ODDĚLENÍ},
            new String[] { PROPISKA, BLOK },
            new String[] { ID_KARTA, SEKERA }
        ),

        new ScenarioStep(tsNOT_IN_BAG, pPOLOŽ + " " + BLOK,
            zNENÍ_V_BATOHU
            ,
            KONTROLNÍ_STANICE,
            new String[] { CHODBA,SKLAD,KRYO_ODDĚLENÍ},
            new String[] { PROPISKA, BLOK },
            new String[] { ID_KARTA, SEKERA }
        ),

        new ScenarioStep(tsHELP, pHELP,
            zNÁPOVĚDA
            ,
            KONTROLNÍ_STANICE,
            new String[] { CHODBA,SKLAD,KRYO_ODDĚLENÍ},
            new String[] { PROPISKA, BLOK },
            new String[] { ID_KARTA, SEKERA }
        ),



        new ScenarioStep(tsEND, pEND,
            zKONEC
            ,
            KONTROLNÍ_STANICE,
            new String[] { CHODBA,SKLAD,KRYO_ODDĚLENÍ},
            new String[] { PROPISKA, BLOK },
            new String[] { ID_KARTA, SEKERA }
        )
    };

    static { ScenarioStep.setIndex(1); }

    /***************************************************************************
     * Kroky scénáře určeného pro prověření povinných akcí,
     * přesněji akcí pro přechod do prostoru, zvednutí a položení objektu,
     * vypsání nápovědy a pro předčasné ukončení hry.
     */
    private static final ScenarioStep[] REQUIRED_STEPS =
    {
        START_STEP,

        new ScenarioStep(tsHELP, pHELP,
            zNÁPOVĚDA
            ,
           KRYO_ODDĚLENÍ,
            new String[] { ŠATNA, KONTROLNÍ_STANICE },
            new String[] { TERMINAL_STANICE },
            new String[] { }
        ),

        new ScenarioStep(tsMOVE, pJDI + " " + ŠATNA,
            zPŘESUN + "" + ŠATNA
            ,
            ŠATNA,
            new String[] { KRYO_ODDĚLENÍ},
            new String[] { ID_KARTA},
            new String[] { }
        ),



        new ScenarioStep(tsTAKE, pVEZMI + " " + ID_KARTA,
            zZVEDNUTO +""+ ID_KARTA
            ,
            ŠATNA,
            new String[] { KRYO_ODDĚLENÍ},
            new String[] { },
            new String[] { ID_KARTA}
        ),

        new ScenarioStep(tsPUT_DOWN, pPOLOŽ + " " + ID_KARTA,
            zPOLOŽENO+"" +ID_KARTA
            ,
            ŠATNA,
            new String[] { KRYO_ODDĚLENÍ},
            new String[] { ID_KARTA},
            new String[] { }
        ),

        new ScenarioStep(tsEND, pEND,
            zKONEC
            ,
             ŠATNA,
            new String[] { KRYO_ODDĚLENÍ},
            new String[] { ID_KARTA},
            new String[] { }
        )

    };



    /** Jediná instance této třídy. Spravuje všechny scénáře sdružené hry. */
    private static final AdvScenarioManager MANAGER =
                                          new AdvScenarioManager();



//\CV== CLASS VARIABLES (VARIABLE CLASS/STATIC ATTRIBUTES/FIELDS) =============



//#############################################################################
//\CI== CLASS (STATIC) INITIALIZER (CLASS CONSTRUCTOR) ========================
//\CF== CLASS (STATIC) FACTORY METHODS ========================================

    /**************************************************************************
     * Vrátí správce scénářů - jedinou instanci této třídy.
     *
     * @return Správce scénářů
     */
    public static AdvScenarioManager getInstance()
    {
        return MANAGER;
    }



//\CG== CLASS (STATIC) GETTERS AND SETTERS ====================================
//\CM== CLASS (STATIC) REMAINING NON-PRIVATE METHODS ==========================

//\CP== CLASS (STATIC) PRIVATE AND AUXILIARY METHODS ==========================




//#############################################################################
//\IC== INSTANCE CONSTANTS (CONSTANT INSTANCE ATTRIBUTES/FIELDS) ==============
//\IV== INSTANCE VARIABLES (VARIABLE INSTANCE ATTRIBUTES/FIELDS) ==============



//#############################################################################
//\II== INSTANCE INITIALIZERS (CONSTRUCTORS) ==================================

    /**************************************************************************
     * Vytvoří instanci představující správce scénářů hry.
     * V rámci konstruktoru je vhodné vytvořit všechny scénáře
     * a správce scénářů poté zalepit.
     * <p>
     * Jednotlivé spravované scénáře se musí lišit svým názvem,
     * přičemž názvy základního úspěšného a základního chybového scénáře
     * jsou předem pevně dány a není je možno změnit.
     * Jim zadávané názvy jsou proto pouze formální, protože
     * jim volaná metoda stejně přiřadí ty předem definované.
     * <p>
     *´Kontrakt metody
     * {@link #addScenario(String, TypeOfScenario, ScenarioStep...) }
     * vyžaduje, aby byl jak první přidán úspěšný scénář, tj. scénář typu
     * {@link TypeOfScenario.scHAPPY}, a jako druhý chybový scénář,
     * tj. scénář typu {@link MISTAKE_SCENARIO_NAME}.
     * Na pořadí následně přidávaných scénářů nezáleží.
      */
    private AdvScenarioManager()
    {
        super(FACTORY_CLASS);

        addScenario(HAPPY_SCENARIO_NAME,
                    TypeOfScenario.scHAPPY,    HAPPY_SCENARIO_STEPS);
        addScenario(MISTAKE_SCENARIO_NAME,
                    TypeOfScenario.scMISTAKES, MISTAKE_SCENARIO_STEPS);
        addScenario(REQUIRED_STEPS_SCENARIO_NAME
                ,TypeOfScenario.scGENERAL, REQUIRED_STEPS);
        seal();
    }



//\IA== INSTANCE ABSTRACT METHODS =============================================
//\IG== INSTANCE GETTERS AND SETTERS ==========================================
//\IM== INSTANCE REMAINING NON-PRIVATE METHODS ================================
//\IP== INSTANCE PRIVATE AND AUXILIARY METHODS ================================



//#############################################################################
//\NT== NESTED DATA TYPES =====================================================



//#############################################################################
//== TEST METHODS AND CLASSES =================================================

    /**************************************************************************
     * Metoda prověřující daného správce scénářů
     * nebo hru prověřovanou kroky scénářů tohoto správce.
     * <p>
     * U správce scénářů se prověřuje, zda vyhovuje zadaným okrajovým podmínkám
     * tj. jestli:
     * <ul>
     *   <li>Umí vrátit správně naformátované jméno autora/autorky hry
     *       a jeho/její ID.</li>
     *   <li>Definuje základní úspěšný a základní chybový scénář.</li>
     *   <li>Základní chybový scénář má následující vlastnosti:
     *     <ul>
     *       <li>Startovní příkaz, jehož název je prázdný řetězec</li>
     *       <li>Minimální požadovaný počet kroků</li>
     *       <li>Minimální počet navštívených prostorů</li>
     *       <li>Minimální počet "zahlédnutých" prostorů</li>
     *       <li>Minimální počet vlastních (nepovinných) akcí</li>
     *       <li>Použití příkazů pro přechod z prostoru do prostoru
     *         zvednutí nějakého objektu a položení nějakého objektu</li>
     *       <li>Křížová konzistence příkazů a stavů po jejich zadání</li>
     *     </ul>
     *   </li>
     *   <li>Základní chybový scénář má následující vlastnosti:
     *     <ul>
     *       <li>Chybné odstartování příkazem,
     *           jehož název není prázdný řetězec</li>
     *       <li>Startovní příkaz, jehož název je prázdný řetězec</li>
     *       <li>Použití všech povinných chybových typů kroku definovaných
     *         ve třídě<br>
     *         {@link eu.pedu.adv19s_fw.scenario.TypeOfStep}</li>
     *       <li>Vyvolání nápovědy</li>
     *       <li>Ukončení příkazem pro nestandardní ukončení hry</li>
     *     </ul>
     *   </li>
     * </ul>
     * <p>
     * U hry se prověřuje, zda je možno ji zahrát přesně tak,
     * jak je naplánováno ve scénářích.
     *
     * @param args Parametry příkazového řádku - nepoužívané.
     */
    public static void main(String[] args)
    {
        //Otestuje, zda správce scénářů a jeho scénáře vyhovují požadavkům
       // MANAGER.autoTest();

        //Vypíše na standardní výstup simulovaný průběh hry
        //odehrané podle základního úspěšného scénáře
        //MANAGER.getHappyScenario().simulate();

        //Testování hry prováděné postupně obou povinných scénářů,
        //přičemž základní úspěšný scénář se prochází dvakrát za sebou
       MANAGER.testGame();

        //Testování hry dle scénáře se zadaným názvem
       //MANAGER.testGameByScenarios(REQUIRED_STEPS_SCENARIO_NAME);

//        MANAGER.testGameByScenarios(HAPPY_SCENARIO_NAME);

        //Odehrání hry dle scénáře se zadaným názvem
//        MANAGER.playGameByScenario("???");

        System.exit(0);
    }

}
