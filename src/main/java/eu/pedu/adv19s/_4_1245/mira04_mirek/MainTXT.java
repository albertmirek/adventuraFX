/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.pedu.adv19s._4_1245.mira04_mirek;

import eu.pedu.adv19s_fw.game_txt.IUI;
import eu.pedu.adv19s._4_1245.mira04_mirek.textui.UIA_JOptionPane;
import eu.pedu.adv19s._4_1245.mira04_mirek.textui.UIB_Scanner;

/**
 *
 * @author Panda
 */
public class MainTXT 
{
    
    /***************************************************************************
     * Hlavní metoda aplikace
     *
     * @param args Parametry příkazového řádku
     */
    public static void main(String[] args)
    {
        IUI ui = (IUI) new UIA_JOptionPane();
        ui.startGame();
        
//        IUI ui = new UIB_Scanner();
//        ui.startGame();
    }
    
    /** Soukromý konstruktor zabraňující vytvoření instance. */
    private MainTXT(){}
}
