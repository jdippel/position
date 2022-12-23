/*
 *  Correlation_GetRookForKingMovement.java
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
import chess383.piece.concretion.pawn.InitialBlackPawn;
import chess383.piece.concretion.pawn.InitialWhitePawn;
import chess383.piece.concretion.pawn.MovedBlackPawn;
import chess383.piece.concretion.pawn.MovedWhitePawn;
import chess383.piece.concretion.queen.Queen;
import chess383.piece.concretion.rook.Rook;
import chess383.player.Player;

/**
 * <p>
 * The class Correlation_GetRookForKingMovement implements an upper tester
 * </p>
 *
 * @author    Jörg Dippel
 * @version   November 2022
 *
 */
@DisplayName("the public method String getRookForKingMovement( ) for class Correlation is tested")
public class Correlation_GetRookForKingMovement {  
    
    
    @Test
    @DisplayName("searching rook square for white kingside castling")
    public void getRookForKingMovement_whiteKingsideCastling() {
          
        final String KING_ORIGIN = "e1";
        final String KING_TARGET = "g1";
        final String ROOK_ORIGIN = "h1";
        
        Player player = Player.create( ColorEnum.WHITE, Arrays.asList( 
                  InitialKing.create( KING_ORIGIN ), Queen.create( "d1" ), Rook.create( "a1" ), Rook.create( ROOK_ORIGIN ),
                  Knight.create( "b1" ), Knight.create( "f3" ), Bishop.create( "c1" ), Bishop.create( "c4" ),
                  InitialWhitePawn.create( "a2" ), InitialWhitePawn.create( "b2" ), MovedWhitePawn.create( "c3" ), MovedWhitePawn.create( "d3" ),
                  MovedWhitePawn.create( "e4" ), InitialWhitePawn.create( "f2" ), InitialWhitePawn.create( "g2" ), InitialWhitePawn.create( "h2" )  ));
        Castling castling = Castling.create( Arrays.asList( CastlingElement.create( "a1",  'Q' ), CastlingElement.create( "h1", 'K' ) ) );
        Correlation correlation = Correlation.create( player, castling ).validate();
        
        assertThat( ROOK_ORIGIN ).as( "the related rook should be found for castling" )
                  .isEqualTo( correlation.getRookForKingMovement( KING_ORIGIN, KING_TARGET ) );
    }
    
    @Test
    @DisplayName("searching rook square for white queenside castling")
    public void getRookForKingMovement_whiteQueensideCastling() {
          
        final String KING_ORIGIN = "e1";
        final String KING_TARGET = "c1";
        final String ROOK_ORIGIN = "a1";
        
        Player player = Player.create( ColorEnum.WHITE, Arrays.asList( 
                  InitialKing.create( KING_ORIGIN ), Queen.create( "e2" ), Rook.create( ROOK_ORIGIN ), Rook.create( "h1" ),
                  Knight.create( "d2" ), Knight.create( "d3" ), Bishop.create( "c1" ), Bishop.create( "f4" ),
                  InitialWhitePawn.create( "a2" ), InitialWhitePawn.create( "b2" ), MovedWhitePawn.create( "c3" ), MovedWhitePawn.create( "d4" ),
                  InitialWhitePawn.create( "g2" ), MovedWhitePawn.create( "h4" )  ));
        Castling castling = Castling.create( Arrays.asList( CastlingElement.create( "a1",  'Q' ), CastlingElement.create( "h1", 'K' ) ) );
        Correlation correlation = Correlation.create( player, castling ).validate();
        
        assertThat( ROOK_ORIGIN ).as( "the related rook should be found for castling" )
                  .isEqualTo( correlation.getRookForKingMovement( KING_ORIGIN, KING_TARGET ) );
    }
    
    @Test
    @DisplayName("searching rook square for black kingside castling")
    public void getRookForKingMovement_blackKingsideCastling() {
          
        final String KING_ORIGIN = "e8";
        final String KING_TARGET = "g8";
        final String ROOK_ORIGIN = "h8";
        
        Player player = Player.create( ColorEnum.BLACK, Arrays.asList( 
                  InitialKing.create( "e8" ), Queen.create( "d8" ), Rook.create( "a8" ), Rook.create( "h8" ),
                  Knight.create( "c6" ), Knight.create( "f6" ), Bishop.create( "c8" ), Bishop.create( "c5" ),
                  InitialBlackPawn.create( "a7" ), InitialBlackPawn.create( "b7" ), InitialBlackPawn.create( "c7" ), MovedBlackPawn.create( "d6" ),
                  MovedBlackPawn.create( "e5" ), InitialBlackPawn.create( "f7" ), InitialBlackPawn.create( "g7" ), InitialBlackPawn.create( "h7" ) ));
        Castling castling = Castling.create( Arrays.asList( CastlingElement.create( "a8",  'q' ), CastlingElement.create( "h8", 'k' ) ) );
        Correlation correlation = Correlation.create( player, castling ).validate();
        
        assertThat( ROOK_ORIGIN ).as( "the related rook should be found for castling" )
                  .isEqualTo( correlation.getRookForKingMovement( KING_ORIGIN, KING_TARGET ) );
    }
    
    @Test
    @DisplayName("searching rook square for black queenside castling")
    public void getRookForKingMovement_blackQueensideCastling() {
          
        final String KING_ORIGIN = "e8";
        final String KING_TARGET = "c8";
        final String ROOK_ORIGIN = "a8";
        
        Player player = Player.create( ColorEnum.BLACK, Arrays.asList( 
                  InitialKing.create( "e8" ), Queen.create( "e7" ), Rook.create( "a8" ), Rook.create( "h8" ),
                  Knight.create( "c6" ), Knight.create( "e4" ), Bishop.create( "f5" ), Bishop.create( "f1" ),
                  InitialBlackPawn.create( "a7" ), InitialBlackPawn.create( "b7" ), InitialBlackPawn.create( "c7" ), MovedBlackPawn.create( "d6" ),
                  InitialBlackPawn.create( "f7" ), InitialBlackPawn.create( "g4" ), InitialBlackPawn.create( "h7" ) ));
        Castling castling = Castling.create( Arrays.asList( CastlingElement.create( "a8",  'q' ), CastlingElement.create( "h8", 'k' ) ) );
        Correlation correlation = Correlation.create( player, castling ).validate();
        
        assertThat( ROOK_ORIGIN ).as( "the related rook should be found for castling" )
                  .isEqualTo( correlation.getRookForKingMovement( KING_ORIGIN, KING_TARGET ) );
    }

    @Test
    @DisplayName("searching rook square for not allowed castling")
    public void getRookForKingMovement_NoCastling() {

        final String KING_ORIGIN = "e8";
        final String KING_TARGET = "e6";
        final String ROOK_ORIGIN = "d5";    // rook is not located on the line with the king movement

        Player player = Player.create( ColorEnum.BLACK, Arrays.asList(
                InitialKing.create( KING_ORIGIN ), Rook.create( "a8" ), Rook.create( ROOK_ORIGIN ) ));
        Castling castling = Castling.createEmpty();
        Correlation correlation = Correlation.create( player, castling ).validate();

        assertThat( "" ).as( "the related rook should not be found for castling" )
                .isEqualTo( correlation.getRookForKingMovement( KING_ORIGIN, KING_TARGET ) );
    }
}


