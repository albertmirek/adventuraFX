/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package eu.pedu.adv19s._4_1245.mira04_mirek.game;



import eu.pedu.adv19s_fw.game_txt.IAction;
import eu.pedu.adv19s_fw.game_txt.IPlace;

import java.util.*;
import java.util.stream.Collectors;

import static eu.pedu.adv19s._4_1245.mira04_mirek.game.Texts.FORMÁT_INFORMACE;


/*******************************************************************************
 * Třída {@code EmptyAAction} je společným rodičem všech tříd, jejichž instance
 * mají na starosti interpretaci příkazů zadávaných uživatelem hrajícím hru.
 * Název spouštěné akce bývá většinou první slovo řádku zadávaného
 * z klávesnice a další slova pak bývají interpretována jako parametry.
 * <p>
 * Můžete ale definovat příkaz, který odstartuje konverzaci
 * (např. s osobou přítomnou v místnosti) a tím přepne systém do režimu,
 * v němž se zadávané texty neinterpretují jako příkazy,
 * ale předávají se definovanému objektu až do chvíle,
 * kdy uživatel rozhovor ukončí a objekt rozhovoru přepne hru zpět
 * do režimu klasických příkazů.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 2018-Winter
 */
abstract class AAction
       extends ANamed
    implements IAction
{
//\CC== CLASS CONSTANTS (CONSTANT CLASS/STATIC ATTRIBUTES/FIELDS) ==============
    /** Mapa zprostředkovávající převod názvu akce na její instanci. */
private static final Map<String, AAction> NAME_2_ACTION;

//\CV== CLASS VARIABLES (VARIABLE CLASS/STATIC ATTRIBUTES/FIELDS) ==============
    /** Uchovává informaci o tom, zda se hra právě hraje
    * nebo jen čeká na spuštění. */
 private static boolean isAlive;
 
 private static final Set<String> roomsNotVisited = new HashSet<>();
 


//##############################################################################
//\CI== CLASS (STATIC) INITIALIZER (CLASS CONSTRUCTOR) =========================
/** statický konstruktor*/
 static {
    isAlive=false;
    NAME_2_ACTION = new HashMap<>();
    new ActionHelp();
    new ActionMove();
    new ActionPickUp();
    new ActionPutDown();
    new ActionExit();
    new ActionVerify();
    new ActionDestroy();
    new ActionPowerUp();
    new ActionPlant();
}

//\CF== CLASS (STATIC) FACTORY METHODS =========================================


/***************************************************************************
* Inicializuje všechny příznaky, které udržují informace
* o aktuálním stavu hry a jejích součástí.
*/
private static void initialize()
{
    SpaceShip   .getInstance().initialize();
    Hands       .getInstance().initialize();
    State                     .initialize();
}

/***************************************************************************
    * Vrátí kolekci všech akcí použitelných ve hře.
    *
    * @return Kolekce všech akcí použitelných ve hře
    */
static Collection<AAction> getAllActions()
{
    Collection<AAction> collection, result;
    collection = NAME_2_ACTION.values();
    result = Collections.unmodifiableCollection(collection);
    return result;
}

//static void SetNotVisited()
//{
//    exportedNotVisited = T12_NotVisited.nenavstiveno;
//} 
//\CG== CLASS (STATIC) GETTERS AND SETTERS =====================================

/***************************************************************************
     * Vrátí informaci o tom, je-li hra aktuálně spuštěná.
     * Spuštěnou hru není možno pustit znovu.
     * Chceme-li hru spustit znovu, musíme ji nejprve ukončit.
     * @return Je-li hra spuštěná, vrátí {@code true},
     * jinak vrátí {@code false}
     */
    public static boolean isAlive()
    {
        return isAlive;
    }

    /***************************************************************************
     * v AAction
     * Zabezpečí korektní ukončení hry.
     * Zapamatuje si, že hra je již ukončena.
     */
    static void stopGame()
    {
        isAlive = false;

    }
    
//\CM== CLASS (STATIC) REMAINING NON-PRIVATE METHODS ===========================

    /***************************************************************************
     * Zpracuje zadaný příkaz a vrátí text zprávy pro uživatele.
     *
     * @param command Zadávaný příkaz
     * @return Textová odpověď hry na zadaný příkaz
     */

    public static String executeCommand(String command)
    {
        
        command=command.trim();
        String answer;
        String vypis;
        if(isAlive)
        {
            answer = executeCommonComand(command);
            
            Room currentRoom = SpaceShip.getInstance().getCurrentPlace();
            Hands hands = Hands.getInstance();
            vypis = String.format(FORMÁT_INFORMACE,
                    currentRoom.getName(),
                    cm(currentRoom.getNeighbors().toString()),
                    cm(currentRoom.getItems().toString()),
                    cm(hands.getItems().toString()));
            
            String roomName = SpaceShip.getInstance().getCurrentPlace()
                                                    .getName().toLowerCase();
            roomsNotVisited.remove(roomName);
            
        }
        else{
            answer = startGame(command);
            vypis ="";
        }
        return answer + "\n" + vypis + "\n" 
                                + "§Not visited: "
                                + roomsNotVisited;
//                                + T12_NotVisited.START
//                                + getNotVisited()
//                                + T12_NotVisited.END;
    }

//    +"\n" +String.format(Texts.FORMÁT_INFORMACE,
//             Texts.KRYO_ODDĚLENÍ, cm(Texts.ŠATNA,Texts.KONTROLNÍ_STANICE),
//             cm(Texts.TERMINAL_STANICE), cm());
    
    /***************************************************************************
    * Zjistí, jaká akce má být zadaným příkazem aktivována,
    * a jedná-li se o známou akci, provede ji.
    *
    * @param command Zadávaný příkaz
    * @return Odpověď hry na zadaný příkaz
    */
    private static String executeCommonComand(String command)
    {
        if(command.isEmpty()){
            return Texts.zPRÁZDNÝ_PŘÍKAZ;
        }
        String[] words = command.toLowerCase().split("\\s+");
        String acttionName = words[0];
        AAction action = NAME_2_ACTION.get(acttionName);
        String answer;

        if (action == null) {
            answer = Texts.zNEZNÁMÝ_PŘÍKAZ;
            
        }
        else {
            answer = action.execute(words);
            }
        return answer;
    }

    /***************************************************************************
     * Ověří, jestli je hra spouštěna správným (= prázdným) příkazem,
    * a pokud ano, spustí hru.
    *
    * @param command Příkaz spouštějící hru
    * @return Odpověď hry na zadaný příkaz
    */
     private static String startGame(String command)
     {
        roomsNotVisited.clear();
        Collection<? extends IPlace> allPlaces;
            allPlaces = SpaceShip.getInstance().getAllPlaces();
            for (IPlace iPlace : allPlaces) {
                String name = iPlace.getName().toLowerCase();
                roomsNotVisited.add(name);
                }
         
        String answer;
         if(command.isEmpty()){
             initialize();
             answer=Texts.zCELÉ_UVÍTÁNÍ;
             isAlive = true;

         }
         else{
             answer = Texts.zNENÍ_START;
         }
         roomsNotVisited.remove(SpaceShip.getInstance().getStartingRoom()
                                .toString().toLowerCase());
//         roomsNotVisited.remove(Texts.KRYO_ODDĚLENÍ.toLowerCase());
         return answer;
         
     }
//\CP== CLASS (STATIC) PRIVATE AND AUXILIARY METHODS ===========================





//##############################################################################
//\IC== INSTANCE CONSTANTS (CONSTANT INSTANCE ATTRIBUTES/FIELDS) ===============

    /** Stručný popis dané akce. */
    private final String description;



//\IV== INSTANCE VARIABLES (VARIABLE INSTANCE ATTRIBUTES/FIELDS) ===============



//##############################################################################
//\II== INSTANCE INITIALIZERS (CONSTRUCTORS) ===================================

    /***************************************************************************
     * Vytvoří rodičovský podobjekt vytvářené akce.
     *
     * @param name  Název vytvářené akce = text, který musí hráč zadat
     *              jako počáteční slovo zadávaného příkazu
     * @param description Stručný popis vytvářené akce
     */
    AAction(String name, String description)
    {
        super(name);
        this.description = description;
        AAction previous = NAME_2_ACTION.put(name.toLowerCase(), this);
        if (previous != null) {
            throw new IllegalArgumentException(
            "\nAkce s názvem «" + name + "» byl již vytvořena");
         }
    }



//\IA== INSTANCE ABSTRACT METHODS ==============================================

    /***************************************************************************
     * Metoda realizující reakci hry na zadání daného příkazu.
     * Počet parametrů je závislý na konkrétní akci,
     * např. akce typu <i>konec</i> a <i>nápověda</i> nemají parametry,
     * akce typu <i>jdi</i> a <i>seber</i> mají jeden parametr
     * akce typu <i>použij</i> muže mít dva parametry atd.
     *
     * @param arguments Parametry příkazu – akce;
     *                  jejich počet muže byt pro každou akci jiný,
     *                  ale pro všechna spuštění stejné akce je stejný
     * @return Text zprávy vypsané po provedeni příkazu
     */
    @Override
    abstract
    public String execute(String... arguments)
    ;



//\IG== INSTANCE GETTERS AND SETTERS ===========================================

    /***************************************************************************
     * Vrátí popis příkazu s vysvětlením jeho funkce
     * a významu jednotlivých parametru.
     *
     * @return Popis příkazu
     */
    @Override
    public String getDescription()
    {
        return description;
    }



//\IM== INSTANCE REMAINING NON-PRIVATE METHODS =================================
//\IP== INSTANCE PRIVATE AND AUXILIARY METHODS =================================

/***************************************************************************
 * Vrátí řetězec obsahující zadané názvy oddělené čárkami.
 *
 * @param názvy Názvy, které je třeba sloučit
 * @return Výsledný řetězec ze sloučených zadaných názvů
 */
    static String cm(String... názvy)
    {
           String result = Arrays.stream(názvy)
           .collect(Collectors.joining(", "));
            return result;
    }
    
    

//##############################################################################
//\NT== NESTED DATA TYPES ======================================================
}
