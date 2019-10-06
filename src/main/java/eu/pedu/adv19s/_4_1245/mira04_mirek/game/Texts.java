/*******************************************************************************
 * Knihovní třída {@code Texts} slouží jako schránka na textové konstanty,
 * které se používají na různých místech programu.
 * Centralizací definic těchto textových řetězců lze nejsnadněji dosáhnout toho,
 * že texty, které mají být shodné na různých místech programu,
 * budou doopravdy shodné.
 */
package eu.pedu.adv19s._4_1245.mira04_mirek.game;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 *
 * @author Panda
 */
public class Texts {
    //== CONSTANT CLASS ATTRIBUTES =============================================
    
    //** Jméno autora programu**/
    static final String AUTHOR_NAME = "MÍREK Albert";
    
    //** Xname autora programu*/
    static final String AUTHOR_ID = "MIRA04";
    
    //** Názvy prostorů*/
     static final String
            KRYO_ODDĚLENÍ = "Kryo_oddělení",
            ŠATNA = "Šatna",
            KONTROLNÍ_STANICE = "Kontrolní_stanice",
            SKLAD = "Sklad",
            VZLETOVÁ_RAMPA = "Vzletová_rampa",
            BIO_LABORATOŘ = "Bio_laboratoř",
            CHODBA = "CHODBA",
            LETOVÝ_MODUL = "Letový_modul",
            VESMÍR = "Vesmír",
            MARS = "Mars",
            ZEMĚ = "Země";
    
    /** Názvy h-objektů */
    static final String
            ID_KARTA = "ID_karta",
            PROPISKA = "Propiska",
            BLOK = "Blok",
            SEKERA = "Sekera",
            SEMÍNKA_ROSTLIN = "Semínka_rostlin",
            CIGARETY = "Cigarety",
            TERMINAL_MODULU = "Terminál_modulu",
            TERMINAL_STANICE = "Terminál_stanice",
            BARIKÁDA_BIO = "Barikáda_bio";
    
    /** Názvy používaných akcí */
    static final String
            pHELP = "?",
            pJDI = "Jdi",
            pVEZMI = "Vezmi",
            pPOLOŽ = "Polož",
            pEND = "Konec",
            pNACTI = "Načti",
            pROZSEKEJ = "Rozsekej",
            pZAPNI = "Zapni",
            pZASAĎ = "Zasaď";
            
            
            //dodělat nonstandard
    
    /** Formát dodatku zprávy informujícího o aktuálním stavu hráče*/
    static final String
            SOUSEDÉ = "Sousedé: ",
            H_OBJEKTY = "H-objekty: ",
            BATOH = "Batoh: ",
            FORMÁT_INFORMACE = "\n\n Nacházíte se v místnosti: %s"+
                    "\n"+ SOUSEDÉ + "[%s]" +
                    "\n"+ H_OBJEKTY + "[%s]" +
                    "\n"+ BATOH + "[%s]";
    
    
    /** Texty zpráv vypisovaných v reakci na příkazy vyvolávají povinné akce.
    * Počáteční z (zpráva) slouží k odlišení od stavů. */
    static final String
           zNENÍ_START =   "\nPrvním příkazem není startovací příkaz." +
            "\nHru, která neběží, lze spustit pouze startovacím příkazem.\n",
            
            zOBJEKT_NACTENI_NEZADAN = "Nebylo zadáno, co se má načíst.",
            zCIL_NACTENI_NEZADAN = "Nebylo zadáno, čemu se má objekt načíst.",
            zNENÍ_OTEVÍRATELNÝ = "Zadaný h-objekt není otevíratelný: ",
            zNELZE_OVĚŘIT = "Zadaný terminál nelze ověřit. Máte ID kartu?",
            zOVERIL = "Ověřili jste totožnost u terminálu: ",
            zZASADIL = "Zasadili jste semínka rostlin",
            zNASTARTOVAN = "Modul je nastartovaný, ověřte prosím identitu",
            zROZSEKANO = "Prorazili jste si cestu do místnosti: ",
            zNEPRISTUPNA ="Cestu do místnosti blokuje barikáda, postarejte se o"
            + " ni.",
            zNEOVĚŘENO = "Terminál nebyl ověřen. Identitu ověříte načtením"
            + " ID_karty",
            zNENASTARTOVAN = "Modul nebyl doposud zapnut. ",
            zNEZASAZENO="Snažíte se zasadit rostliny mimo planetu Zemi",
            zTOTO_NELZE_ZASADIT ="Tento předmět nelze zasadit.",
            zTOTO_NELZE_NASTARTOVAT="Tento předmět nelze nastartovat",
            zTOTO_NELZE_ROZSEKAT="Snažíte se zlikvidovat špatný předmět",
            
            
            zPORADÍM = "\nChcete-li poradit, zadejte příkaz ?",
            zPRÁZDNÝ_PŘÍKAZ = "\nZadal(a) jste prázdný příkaz." + zPORADÍM,
            zNEZNÁMÝ_PŘÍKAZ = "\nTento příkaz neznám." + zPORADÍM,

            zANP = "\nZadaná akce nebyla provedena",

            zPŘESUN = "\nPřesunul(a) jste se do místnosti: ",
            zCIL_NEZADAN = zANP + "\nNebyla zadána místnost, "
            + "do níž se má přejít",
            zNENÍ_CIL = zANP + "\nDo zadané místnosti se odsud nedá přejít ",
            
            zZVEDNUTO = "\nVzal(a) jste h-objekt: ",
            zPOLOŽENO = "\nPoložil(a) jste h-objekt: ",
            zH_OBJEKT_NEZADAN = zANP + "\nNebyl zadán h-objekt, "
            + "s nímž mám manipulovat",
            zTĚŽKÝ_H_OBJEKT = zANP + "\nZadaný h-objekt nejde zvednout: ",
            zNENÍ_H_OBJEKT = zANP + "\nZadaný h-objekt v místnosti není: ",
            zNENÍ_V_BATOHU = zANP + "\nH-objekt není v batohu: ",
            zBATOH_PLNÝ = zANP +
            "\nZadaný h-objekt nemůžete vzít, máte už obě ruce plné",
            zNÁPOVĚDA = "\nPříkazy, které je možno v průběhu hry zadat:" +
                         "\n============================================\n",
            
            zUVÍTÁNÍ =
             "Vítejte.\n "
                + "Probudili jste se na vesmírné stanici z kryo spánku.\n"
                + "Vaším úkolem je, dostat se na planetu Zemi a zasadit zde "
                + "rostliny. \n"
                + "Abyste se na Zem dostali, potřebujete se dostat do "
                + "letového modulu.\n"
                + "Po ceste můžete narazit na zátarasy, které budete muset "
                + "rozbít hrubou silou\n to a pouze za pomoci předmětu.\n"
                + "Nejste kapitán!!\n Můžete být počítačem vyzván k prokázání"
                + " totožnosti.",

             zCELÉ_UVÍTÁNÍ = zUVÍTÁNÍ +
             String.format(FORMÁT_INFORMACE,
             KRYO_ODDĚLENÍ, cm(ŠATNA,KONTROLNÍ_STANICE),
             cm(TERMINAL_STANICE), cm()),

             zKONEC = "\nKonec hry. \nDěkujeme, že jste zkusil(a) naši hru.";
    
    /** Texty vypisované v reakci na příkazy vyvolávající nepovinné akce. */
    static final String
            zNEMA_SEKERU = "\n Pro rozsekání dveří potřebujete sekeru",
            zNEMA_SEMINKA = "\n Abyste mohl zasadit, potřebujete Semínka",
            ZNEMA_ID_KARTU="\n Pro ověření potřebujete ID kartu";
    
    //== VARIABLE CLASS ATTRIBUTES =============================================
    
//== STATIC INITIALIZER (CLASS CONSTRUCTOR) ====================================
//== CLASS GETTERS AND SETTERS =================================================
//== OTHER NON-PRIVATE CLASS METHODS ===========================================
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
    
    
}
