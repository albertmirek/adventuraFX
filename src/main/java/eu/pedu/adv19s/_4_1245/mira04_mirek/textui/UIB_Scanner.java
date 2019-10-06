/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.pedu.adv19s._4_1245.mira04_mirek.textui;

import eu.pedu.adv19s._4_1245.mira04_mirek.AdvGSMFactory;
import eu.pedu.adv19s._4_1245.mira04_mirek.game.IAuthorAM;
import eu.pedu.adv19s._4_1245.mira04_mirek.game.MirSpaceGame;

import eu.pedu.adv19s_fw.game_txt.IGame;
import eu.pedu.adv19s_fw.game_txt.IUI;

import java.util.Scanner;

/**
 *
 * @author Panda
 */
public class UIB_Scanner
        implements IUI, IAuthorAM
{

//== CONSTANT CLASS ATTRIBUTES =================================================
    
    /** Tovární třída, jejíž instancemi jsou tovární objekty poskytující
     *  instanci správce scénářů i hry, jejíž scénáře daný správce spravuje. */
    private static final Class<AdvGSMFactory> FACTORY_CLASS = 
                                                        AdvGSMFactory.class;
//== VARIABLE CLASS ATTRIBUTES =================================================

    
    
//##############################################################################
//== STATIC INITIALIZER (CLASS CONSTRUCTOR) ====================================
//== CLASS GETTERS AND SETTERS =================================================
//== OTHER NON-PRIVATE CLASS METHODS ===========================================
//== PRIVATE AND AUXILIARY CLASS METHODS =======================================
    
    
    
//##############################################################################
//== CONSTANT INSTANCE ATTRIBUTES ==============================================
//== VARIABLE INSTANCE ATTRIBUTES ==============================================
  /** Aktuálně hraná hra. */  
    private IGame game;
    
    
//##############################################################################
//== CONSTUCTORS AND FACTORY METHODS ===========================================
    
    public UIB_Scanner()
    {
    }
    
    
//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================
    
    /***************************************************************************
     * Vrátí class-objekt tovární třídy, jejíž instance umějí zprostředkovat
     * získání všech klíčových objektů aplikace.
     *
     * @return Class-objekt tovární třídy
     */
    @Override
    public Class<AdvGSMFactory> getFactoryClass()
    {
        return FACTORY_CLASS;
    }
    
    
    /***************************************************************************
     * Vrátí aktuálně hranou hru.
     *
     * @return Aktuálně hraná hra
     */
    @Override
    public IGame getGame() {
        return game;
    }
    
//== OTHER NON-PRIVATE INSTANCE METHODS ========================================
    
    /***************************************************************************
     * Spustí komunikaci mezi implicitní hrou
     * a danou instancí uživatelského rozhraní.
     */
    @Override
    public void startGame()
    {
        startGame(MirSpaceGame.getInstance());
    }
    
    
    /***************************************************************************
     * Spustí komunikaci mezi zadanou hrou a danou instancí
     * mající na starosti komunikaci s uživatelem.
     *
     * @param game Hra, kterou ma dané UI spustit
     */
    @Override
    public void startGame(IGame game) 
    {
        Scanner scanner = new Scanner(System.in);
        String  command = "";
        String  answer;
        for(;;) {
            answer  = game.executeCommand(command);
            System.out.println(answer);
            if (! game.isAlive()) { break; }    //---------->
            command =  scanner.nextLine();
        }
    }

    

    
    
//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================



//##############################################################################
//== NESTED DATA TYPES =========================================================



//##############################################################################
//== MAIN METHOD ===============================================================

 /***************************************************************************
     * Metoda spouštějící hru {@link RUPApartmentGame}
     * s uživatelským rozhraním využívajícím služeb
     * standardního vstupu a výstupu a třídy {@link Scanner}.
     *
     * @param args Parametry příkazového řádku - prozatím nepoužívané
     */
//    public static void main(String[] args)
//    {
//        new UIB_Scanner().startGame();
//    }


    
}
