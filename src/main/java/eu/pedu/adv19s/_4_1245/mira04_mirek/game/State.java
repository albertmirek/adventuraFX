/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.pedu.adv19s._4_1245.mira04_mirek.game;

/**
 *
 * @author Panda
 */
public class State 
{
    
//== CONSTANT CLASS ATTRIBUTES =================================================
//== VARIABLE CLASS ATTRIBUTES =================================================
    
    /**Příznak registrující, zda jsme ověřili totožnost u terminalu_stanice*/
    private static boolean stationTerminalVerified;     
    /**Příznak registrující, zda jsme ověřili totožnost u terminalu_modulu*/
    private static boolean modulTerminalVerified;
    /**Příznak registrující, zda jsme zničili barikádu*/
    private static boolean baricadeBroken;
    /** Příznak registrující, zda jsme nastartovali letový modul*/
    private static boolean modulPoweredUp;
    
//== STATIC INITIALIZER (CLASS CONSTRUCTOR) ====================================
//== CLASS GETTERS AND SETTERS =================================================
    
    /***************************************************************************
     * Vrátí informaci o tom zda 
     * jsme ověřili totožnost u terminálu stanice
     * @return je-li ověřena vrátí {@code true}, jinak vrátí {@code false}
     */
    static boolean isStationTerminalVerified()
    {
        return stationTerminalVerified;
    }
          
    /***************************************************************************
     * Vrátí informaci o tom zda 
     * jsme ověřili totožnost u terminálu modulu
     * @return je-li ověřena vrátí {@code true}, jinak vrátí {@code false}
     */
    static boolean isModulTerminalVerified()
    {
        return modulTerminalVerified;
    }
    
    /***************************************************************************
     * Vrátí informaci o tom zda 
     * jsme zničili barikádu
     * @return je-li zničena vrátí {@code true}, jinak vrátí {@code false}
     */
    static boolean isBaricadeBroken()
    {
        return baricadeBroken;
    }
    
    /***************************************************************************
     * Vrátí informaci o tom zda 
     * jsme nastartovali Letový modul
     * @return je-li nastartován {@code true}, jinak vrátí {@code false}
     */
    static boolean isPoweredUp()
    {
        return modulPoweredUp;
    }
    
    
    /***************************************************************************
    * Nastaví informaci o tom, je-li terminál stanice ověřen 
    * 
    * @param stationTerminalVerified Nastavovaná hodnota 
    */ 
    static void setStationTerminalVerified()
    {
        stationTerminalVerified = true;
    }
    
    /***************************************************************************
    * Nastaví informaci o tom, je-li terminál modulu ověřen 
    * 
    * @param modulTerminalVerified Nastavovaná hodnota 
    */ 
    static void setModulTerminalVerified()
    {
        modulTerminalVerified = true;
    }
    
    /***************************************************************************
    * Nastaví informaci o tom, je-li barikáda zničena
    * 
    * @param baricadeBroken Nastavovaná hodnota 
    */ 
    static void setBaricadeBroken()
    {
        baricadeBroken = true;
    }
    
    /***************************************************************************
    * Nastaví informaci o tom, je-li modul nastartován
    * 
    * @param modulPoweredUp Nastavovaná hodnota 
    */ 
    static void setModulPoweredUp()
    {
        modulPoweredUp = true;
    }
    
    
    
//== OTHER NON-PRIVATE CLASS METHODS ===========================================
    
    /***************************************************************************
    * Inicializuje všechny příznaky, které udržují informace  
    * o aktuálním stavu hry a jejích součástí. 
    */
    static void initialize()
    {
        stationTerminalVerified = false;
        modulTerminalVerified = false;
        baricadeBroken = false;
        modulPoweredUp = false;
    }
    
    
//== PRIVATE AND AUXILIARY CLASS METHODS =======================================
    
//##############################################################################
//== CONSTANT INSTANCE ATTRIBUTES ==============================================
//== VARIABLE INSTANCE ATTRIBUTES ==============================================
    
    
    
//##############################################################################
//== CONSTUCTORS AND FACTORY METHODS ===========================================
    
    /***************************************************************************
    * Soukromý konstruktor zabraňující vytvoření instance.  
    */
    private State()
    {
    }
    
    
//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================
//== OTHER NON-PRIVATE INSTANCE METHODS ========================================
//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================
    
    
    
//##############################################################################
//== NESTED DATA TYPES =========================================================
}
