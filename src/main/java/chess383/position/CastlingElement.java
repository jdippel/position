/*
 *  CastlingElement.java
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

/**
 * Provides the information of a piece to castle with the king.
 *
 * The location of the piece is one attribute.
 * The abbreviation used in FEN (Forsyth-Edwards Notation) is the second attribute.
 * 
 * @author    Jörg Dippel
 * @version   September 2020
 *
 */
public class CastlingElement {

    /** ---------  Attributes  -------------------------------- */
    
    private String location;
    private char abbreviation;
    
    /** ---------  Getter and Setter  ------------------------- */

    private void setLocation( String value )   { this.location = value; }
    public String getLocation()                { return this.location; }
    private void setAbbreviation( char value ) { this.abbreviation = value; }
    public char getAbbreviation()              { return this.abbreviation; }
    
    /** ---------  Constructors  ------------------------------ */
    
    private CastlingElement( String location, char abbreviation ) {
        setLocation( location );
        setAbbreviation( abbreviation );
    }
 
    /** ---------  Factory  ----------------------------------- */
    
    public static CastlingElement create( String location, char abbreviation ) {
        
        return new CastlingElement( location, abbreviation );
    }
}
