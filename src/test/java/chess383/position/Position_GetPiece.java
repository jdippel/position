/*
 *  Position_GetPiece.java
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

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import chess383.piece.concretion.knight.Knight;
import chess383.piece.concretion.pawn.InitialWhitePawn;

/**
 * <p>
 * The class Position_GetPiece implements an upper tester for the standard Forsyth-Edwards-Notation
 * </p>
 *
 * @author    Jörg Dippel
 * @version   September 2020
 *
 */
@DisplayName("the public method Piece getPiece( ) for class Position is tested")
public class Position_GetPiece {  
    
    @Test
    @DisplayName("getPiece(): getting a piece from an initial position")
    public void getPiece_GettingWhitePieceFromInitialPosition() {
        
        Position position = Position.create();
        
        assertThat( position.getPiece( "e2" ) )
                  .as( "the pieces should match" )
                  .isEqualTo( InitialWhitePawn.create( "e2" ) );
    }
    
    @Test
    @DisplayName("getPiece(): getting a piece from a developped position")
    public void getPiece_GettingBlackPieceFromDeveloppedPosition() {
        
        Position position = Position.create( "r1bqkbnr/pppp1ppp/2n5/4p3/4P3/5N2/PPPP1PPP/RNBQKB1R w KQkq - 2 3" );
        
        assertThat( position.getPiece( "c6" ) )
                  .as( "the pieces should match" )
                  .isEqualTo( Knight.create( "c6" ) );
    }
    
    @Test
    @DisplayName("getPiece(): location is not occupied")
    public void getPiece_GettingFromFreeLocation() {
        
        Position position = Position.create( "r1bqkbnr/pppp1ppp/2n5/4p3/4P3/5N2/PPPP1PPP/RNBQKB1R w KQkq - 2 3" );
        
        assertThat( position.getPiece( "b4" ) )
                  .as( "there is no piece located on that specified location" )
                  .isEqualTo( null );
    }
}


