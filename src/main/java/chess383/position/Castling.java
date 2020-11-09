/*
 *  Castling.java
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

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Provides the information which kinds of castling are possible.
 * 
 * Castling consists of moving the king two squares towards a rook, 
 * then placing the rook on the other side of the king, adjacent to it.
 * 
 * Here the locations of the rooks are stored in the map as keys.
 * Castling can be generalized because there is no requirement for rooks.
 * The value mapped is the abbreviation in FEN (Forsyth-Edwards Notation).
 * For chess variants it could be aligned to the first letter of the location,
 * upper and lower will define the color as usual.
 *
 * @author    Jörg Dippel
 * @version   September 2020
 *
 */
public class Castling {

    /** ---------  Attributes  -------------------------------- */
    
    Map<String,Character> castlingMap;
    
    /** ---------  Getter and Setter  ------------------------- */
    
    private void setMap()                                       { castlingMap = new HashMap<>(); }
    private Map<String,Character> getMap()                      { return this.castlingMap; }

    /** ---------  Constructors  ------------------------------ */
    
    private Castling( ) {
        setMap();
    }
 
    /** ------------------------------------------------------- */
    
    public Set<String> getLocations() {
        
        return getMap().keySet();
    }
    
    /** ---------  Factory  ----------------------------------- */
    
    public static Castling create( List<CastlingElement> rooks ) {
        
        Castling castling = new Castling();
        for ( CastlingElement element : rooks ) {
            castling.getMap().put( element.getLocation(), element.getAbbreviation() );
        }
        return castling;
    }
    
    public static Castling createWhiteCastling() {
        
        return create( Arrays.asList( CastlingElement.create( "a1",  'Q' ), CastlingElement.create( "h1", 'K' ) ) );
    }
    
    public static Castling createBlackCastling() {
        
        return create( Arrays.asList( CastlingElement.create( "a8",  'q' ), CastlingElement.create( "h8", 'k' ) ) );
    }
    
    public static Castling createEmpty() {
        return new Castling( );
    }
    
    /** ---------  Fluent Builder Pattern  -------------------- */
    
    public Castling clone() {
        
        Castling castling = new Castling();
        for ( String key : getMap().keySet() ) {
            
            castling.getMap().put( key, getMap().get( key ) );
        }
        return castling;
    }
    
    /** ------------------------------------------------------- */
    
    public Castling remove( String location ) {
        
        if( getMap().containsKey( location ) == false ) {
            return this;
        }
        
        Castling castling = new Castling();
        for ( String key : getMap().keySet() ) {
            
            if( key.compareToIgnoreCase( location ) != 0 ) {
                castling.getMap().put( key, getMap().get( key ) );
            }
        }
        return castling;
    }
    
    public Castling remove( Character abbreviation ) {
   
        for ( String key : getMap().keySet() ) {
        	Character value = getMap().get( key );
        	if( value == abbreviation ) return remove( key );
        }
        return this;
    }
    
    public boolean isEmpty() {
    	
    	return getMap().isEmpty();
    }
    
    /** ---------  Inheritance from Object  ------------------- */
    
    @Override
    public String toString() {
        
        Set<String> keys= castlingMap.keySet();
        
        if ( keys.size() == 1 )  {
            Iterator<String> iterator = keys.iterator();
            return "" + castlingMap.get( iterator.next() );
        }
        
        if ( keys.size() == 2 )  {
            Iterator<String> iterator = keys.iterator();
            String firstKey = iterator.next();
            String secondKey = iterator.next();
            if ( firstKey.compareToIgnoreCase( secondKey ) > 0 ) {
                return "" + castlingMap.get( firstKey ) + castlingMap.get( secondKey );
            }
            else {
                return "" + castlingMap.get( secondKey ) + castlingMap.get( firstKey );
            }
        }
        
        return "";
    }
}
