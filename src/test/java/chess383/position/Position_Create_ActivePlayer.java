/*
 *  Position_Create_ActivePlayer.java
 *
 *  chess383 is a collection of chess related utilities.
 *  Copyright (C) 2020 Jörg Dippel
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

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import chess383.ColorEnum;
import chess383.piece.concretion.bishop.Bishop;
import chess383.piece.concretion.king.InitialKing;
import chess383.piece.concretion.knight.Knight;
import chess383.piece.concretion.pawn.InitialWhitePawn;
import chess383.piece.concretion.pawn.MovedWhitePawn;
import chess383.piece.concretion.queen.Queen;
import chess383.piece.concretion.rook.Rook;
import chess383.player.Player;

/**
 * <p>
 * The class Position_Create_ActivePlayer implements an upper tester for the standard Forsyth-Edwards-Notation
 * </p>
 *
 * @author    Jörg Dippel
 * @version   September 2020
 *
 */
@DisplayName("the public static method Position create( ) for class Position is tested for FEN positions and checking the aktive player")
public class Position_Create_ActivePlayer {  
    
    @Test
    @DisplayName("create(): create white position")
    public void create_CreateWhitePosition() {
        
    	Player firstPlayer = Player.create( ColorEnum.WHITE, Arrays.asList( 
                InitialKing.create( "e1" ), Queen.create( "d1" ), Rook.create( "a1" ), Rook.create( "h1" ),
                Knight.create( "b1" ), Knight.create( "g1" ), Bishop.create( "c1" ), Bishop.create( "f1" ),
                InitialWhitePawn.create( "a2" ), InitialWhitePawn.create( "b2" ), InitialWhitePawn.create( "c2" ), InitialWhitePawn.create( "d2" ),
                InitialWhitePawn.create( "e2" ), InitialWhitePawn.create( "f2" ), InitialWhitePawn.create( "g2" ), InitialWhitePawn.create( "h2" )  ));
        Castling firstCastling = Castling.create( Arrays.asList( CastlingElement.create( "a1",  'Q' ), CastlingElement.create( "h1", 'K' ) ) );
        Correlation firstCorrelation = Correlation.create( firstPlayer, firstCastling ).validate();
        
        Player secondPlayer = Player.create( ColorEnum.BLACK, Arrays.asList( 
                InitialKing.create( "e8" ), Queen.create( "d8" ), Rook.create( "a8" ), Rook.create( "h8" ),
                Knight.create( "b8" ), Knight.create( "g8" ), Bishop.create( "c8" ), Bishop.create( "f8" ),
                InitialWhitePawn.create( "a7" ), InitialWhitePawn.create( "b7" ), InitialWhitePawn.create( "c7" ), InitialWhitePawn.create( "d7" ),
                InitialWhitePawn.create( "e7" ), InitialWhitePawn.create( "f7" ), InitialWhitePawn.create( "g7" ), InitialWhitePawn.create( "h7" ) ));
        Castling secondCastling = Castling.create( Arrays.asList( CastlingElement.create( "a8",  'q' ), CastlingElement.create( "h8", 'k' ) ) );
        Correlation secondCorrelation = Correlation.create( secondPlayer, secondCastling );
        
        Position position = Position.create( firstCorrelation, secondCorrelation, ColorEnum.WHITE, null, 0, 1 );
        
        assertThat( ColorEnum.WHITE ).as( "a position for the white player indicates white as the active player" ).isEqualTo( position.getActivePlayer().getActive() );
    }
    
    @Test
    @DisplayName("create(): create black position")
    public void create_CreateBlackPosition() {
        
    	Player firstPlayer = Player.create( ColorEnum.WHITE, Arrays.asList( 
                InitialKing.create( "e1" ), Queen.create( "d1" ), Rook.create( "a1" ), Rook.create( "h1" ),
                Knight.create( "b1" ), Knight.create( "g1" ), Bishop.create( "c1" ), Bishop.create( "f1" ),
                InitialWhitePawn.create( "a2" ), InitialWhitePawn.create( "b2" ), InitialWhitePawn.create( "c2" ), InitialWhitePawn.create( "d2" ),
                MovedWhitePawn.create( "e4" ), InitialWhitePawn.create( "f2" ), InitialWhitePawn.create( "g2" ), InitialWhitePawn.create( "h2" )  ));
        Castling firstCastling = Castling.create( Arrays.asList( CastlingElement.create( "a1",  'Q' ), CastlingElement.create( "h1", 'K' ) ) );
        Correlation firstCorrelation = Correlation.create( firstPlayer, firstCastling ).validate();
        
        Player secondPlayer = Player.create( ColorEnum.BLACK, Arrays.asList( 
                InitialKing.create( "e8" ), Queen.create( "d8" ), Rook.create( "a8" ), Rook.create( "h8" ),
                Knight.create( "b8" ), Knight.create( "g8" ), Bishop.create( "c8" ), Bishop.create( "f8" ),
                InitialWhitePawn.create( "a7" ), InitialWhitePawn.create( "b7" ), InitialWhitePawn.create( "c7" ), InitialWhitePawn.create( "d7" ),
                InitialWhitePawn.create( "e7" ), InitialWhitePawn.create( "f7" ), InitialWhitePawn.create( "g7" ), InitialWhitePawn.create( "h7" ) ));
        Castling secondCastling = Castling.create( Arrays.asList( CastlingElement.create( "a8",  'q' ), CastlingElement.create( "h8", 'k' ) ) );
        Correlation secondCorrelation = Correlation.create( secondPlayer, secondCastling );
        
        Position position = Position.create( firstCorrelation, secondCorrelation, ColorEnum.BLACK, "e3", 0, 2 );
        
        assertThat( ColorEnum.BLACK ).as( "a position for the white player indicates white as the active player" ).isEqualTo( position.getActivePlayer().getActive() );
    }
}


