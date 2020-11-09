/*
 *  Promotion.java
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

import java.util.List;
import java.util.Set;

import chess383.ColorEnum;
import chess383.exception.Chess383PromotionException;
import chess383.piece.abstraction.Piece;
import chess383.piece.abstraction.PieceFactory;
import chess383.player.Player;

/**
 * Provides a promotion for a chess position.
 *
 * @author    Jörg Dippel
 * @version   August 2020
 *
 */
public class Promotion {

    /** ---------  Attributes  -------------------------------- */
    
    Position position;
    
 /** ---------  Getter and Setter  ------------------------- */
    
    private void setPosition( Position value )    { this.position = value; }
    private Position getPosition( )               { return this.position; }

    /** ---------  Constructors  ------------------------------ */
    
    private Promotion( Position position ) { 
        
        setPosition( position );
    }
    
    /** ---------  Factory  ----------------------------------- */
    
    public static Promotion create( Position position ) {
        
        return new Promotion( position );
    }
 
    /** ------------------------------------------------------- */

    public Position promote( String location, char pieceType ) {
    
        Piece piece = getPosition().getPiece(location);
        if( piece == null ) {
        	Chess383PromotionException.throwPromotionException( String.format( "there is no piece located on location %s", location ) );
        }
        if( piece.isPawn() ) {
            Set<List<String>> moves = piece.getMovingLines();
            if( moves.isEmpty() ) {
                Piece newPiece = PieceFactory.createPiece( location, pieceType );
                if( newPiece.isPawn() ) {
                    Chess383PromotionException.throwPromotionException( "pawn cannot promote to a pawn" );
                }
                else if( newPiece.isKing() ) {
                    Chess383PromotionException.throwPromotionException( "pawn cannot promote to a king" );
                }
                else {
                    Position newPosition;
                    ColorEnum color = getPosition().getActivePlayer().getActive();
                    if( color == ColorEnum.BLACK ) {
                        
                        Player player = getPosition().getFirst().getPlayer();
                        player = player.promote( newPiece, location );
                        Correlation correlation = Correlation.create( player, getPosition().getFirst().getCastling().clone() );
                        newPosition = Position.create( correlation, getPosition().getSecond(), color, getPosition().getEnPassantLocation().getLocation(), getPosition().getNumberOfPlys(), getPosition().getNumberOfMoves() );
                    }
                    else {
                        Player player = getPosition().getSecond().getPlayer();
                        player = player.promote( newPiece, location );
                        Correlation correlation = Correlation.create( player, getPosition().getSecond().getCastling().clone() );
                        newPosition = Position.create( getPosition().getFirst(), correlation, color, getPosition().getEnPassantLocation().getLocation(), getPosition().getNumberOfPlys(), getPosition().getNumberOfMoves() );
                    }
                    return newPosition;
                }
            }
            Chess383PromotionException.throwPromotionException( "pawn must be located the way that he cannot move any longer" );
        }
        Chess383PromotionException.throwPromotionException( "only pawns can promote" );
        return null;
    }
}
