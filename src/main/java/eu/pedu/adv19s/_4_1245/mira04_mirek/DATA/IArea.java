/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.pedu.adv19s._4_1245.mira04_mirek.DATA;

import eu.pedu.adv19s_fw.game_txt.IItem;
import eu.pedu.adv19s_fw.game_txt.IItemContainer;
import eu.pedu.adv19s_fw.game_txt.INamed;
import java.util.Collection;

/**
 *
 * @author Panda
 */
public interface IArea 
                 extends INamed, IItemContainer
{
    String getName();
    Collection<? extends IArea> getNeightbors();
    Collection<? extends IItem> getItems();
}
