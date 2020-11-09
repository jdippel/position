/*
 *  Correlation.java
 *
 *  chess383 is a collection of chess related utilities.
 *  Copyright (C) 2019 - 2020 Jörg Dippel
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

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import chess383.ColorEnum;
import chess383.exception.InvalidChessCastlingConfigurationException;
import chess383.piece.abstraction.Piece;
import chess383.piece.concretion.rook.Rook;
import chess383.player.Player;

/**
 * Provides a relation between player and its possibility to castle.
 *
 * @author    Jörg Dippel
 * @version   September 2020
 *
 */
public class Correlation {
    
    /** ---------  Attributes  -------------------------------- */
    
    private Player player;
    private Castling castling;
    
    /** ---------  Getter and Setter  ------------------------- */

    private void setPlayer( Player value )              { this.player = value; }
    public  Player getPlayer()                          { return this.player; }
    private void setCastling( Castling castling )       { this.castling = castling; }
    public  Castling getCastling()                      { return this.castling; }

    /** ---------  Constructors  ------------------------------ */
    
    private Correlation( Player player, Castling castling ) {
        setPlayer( player );
        setCastling( castling );
    }
 
    /** ---------  Factory  ----------------------------------- */
    
    public static Correlation create( Player player, Castling castling ) {
        return new Correlation( player, castling );
    }
    
    /** ---------  Fluent Builder Pattern  -------------------- */
    
    public Correlation validate() {
        
        for ( String location : getCastling().getLocations() ) {
            if ( getPlayer().getPiece( location ) == null ) {
            	InvalidChessCastlingConfigurationException.throwCastlingConfigurationException( location );
            }
        }
        return this;
    }
    
    public Correlation clone() {
        
        return create( getPlayer().clone(), getCastling().clone() );
    }
    
    /** ------------------------------------------------------- */
    
    /*
     *  Origin and target are describing the locations of a king move.
     *  The rook for castling must be located on a line holding both locations.
     *  Only lines with the origin king location are regarded.
     *  The target location of the king must be located between its origin
     *  and the location of the rook.
     */
    public String getRookForKingMovement( String origin, String target ) {
        
        for( String location : getCastling().getLocations() ) {
            
            Piece rook = getPlayer().getPiece( location );
            if( rook instanceof Rook ) {
                Set<List<String>> lines = rook.getMovingLines( ); 
                for( List<String> line : lines ) {
                    if( line.contains( origin ) ) {
                        Iterator<String> iterator = line.iterator();
                        while( iterator.hasNext() ) {
                            String square = iterator.next();
                            if( target.compareTo( square ) == 0 ) return rook.getLocation();
                            if( origin.compareTo( square ) == 0 ) break;
                        }
                    }
                }
            }
        }
        return "";
    }

    public ColorEnum getColor() {
        
        return getPlayer().getColour();
    }
}
