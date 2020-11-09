/*
 *  EnPassantLocation.java
 *
 *  chess383 is a collection of chess related utilities.
 *  Copyright (C) 2019 Jörg Dippel
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

/**
 * Provides the information whether a location is passed by a pawn en passant.
 *
 * @author    Jörg Dippel
 * @version   November 2019
 *
 */
public class EnPassantLocation {

    /** ---------  Attributes  -------------------------------- */
    
    private String location;
    
    /** ---------  Getter and Setter  ------------------------- */

    public void setLocation( String location ) { this.location = location; }
    public String getLocation()                { return this.location; }

    /** ---------  Constructors  ------------------------------ */
    
    private EnPassantLocation( String loaction ) {
        setLocation(loaction);
    }
 
    /** ---------  Factory  ----------------------------------- */
    
    public static EnPassantLocation create( String location ) {
        return new EnPassantLocation( location );
    }
        
    /** ------------------------------------------------------- */
    
    /** ---------  Inheritance from Object  ------------------- */
    
    @Override
    public String toString() {
        return ( getLocation() == null ) ? "-" : getLocation();
    }
}
