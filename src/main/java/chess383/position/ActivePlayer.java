/*
 *  ActivePlayer.java
 *
 *  chess383 is a collection of chess related utilities.
 *  Copyright (C) 2019, 2020 Jörg Dippel
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program. If not, see <http://www.gnu.org/licenses/>.
 */

package chess383.position;

import chess383.ColorEnum;

/**
 * Provides the information which player has to move.
 *
 * @author    Jörg Dippel
 * @version   September 2020
 *
 */
public class ActivePlayer {

    /** ---------  Attributes  -------------------------------- */
    
    private ColorEnum active;
    private ColorEnum inactive;
    
    /** ---------  Getter and Setter  ------------------------- */

    private void setActive( ColorEnum value )   { this.active = value; }
    public  ColorEnum getActive()               { return this.active; }
    private void setInactive( ColorEnum value ) { this.inactive = value; }
    public  ColorEnum getInactive()             { return this.inactive; }

    /** ---------  Constructors  ------------------------------ */
    
    private ActivePlayer( ColorEnum active, ColorEnum inactive ) {
        setActive( active );
        setInactive( inactive );
    }
 
    /** ---------  Factory  ----------------------------------- */
    
    public static ActivePlayer create( ColorEnum active, ColorEnum inactive ) {
        
        return new ActivePlayer( active, inactive );
    }
    
    /** ------------------------------------------------------- */
    
    public void toggleActivity() {
    	
    	ColorEnum color = getActive();
    	
    	setActive( getInactive() );
    	setInactive( color );
    }
    
    /** ---------  Inheritance from Object  ------------------- */
    
    @Override
    public String toString() {
        return getActive().toString().substring( 0, 1 );
    }
}