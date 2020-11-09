/*
 *  Position_ToString_Italian.java
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

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import chess383.ColorEnum;
import chess383.piece.concretion.bishop.Bishop;
import chess383.piece.concretion.king.InitialKing;
import chess383.piece.concretion.king.MovedKing;
import chess383.piece.concretion.knight.Knight;
import chess383.piece.concretion.pawn.InitialWhitePawn;
import chess383.piece.concretion.pawn.MovedBlackPawn;
import chess383.piece.concretion.pawn.MovedWhitePawn;
import chess383.piece.concretion.queen.Queen;
import chess383.piece.concretion.rook.Rook;
import chess383.player.Player;


/**
 * <p>
 * The class Position_ToString_Italian implements an upper tester
 * </p>
 *
 * @author    Jörg Dippel
 * @version   September 2020
 *
 */
@DisplayName("the public method String toString( ) for class Position is tested for the Italian opening")
public class Position_ToString_Italian {  
    
    @Test
    @DisplayName("toString(): for the Italian opening the ToString representation is verified for initial position.")
    public void toString_InitialPosition() {
        
        Player firstPlayer = Player.createWhitePlayer();
        Castling firstCastling = Castling.create( Arrays.asList( CastlingElement.create( "a1",  'Q' ), CastlingElement.create( "h1", 'K' ) ) );
        Correlation firstCorrelation = Correlation.create( firstPlayer, firstCastling ).validate();
        
        Player secondPlayer = Player.createBlackPlayer();
        Castling secondCastling = Castling.createBlackCastling();
        Correlation secondCorrelation = Correlation.create( secondPlayer, secondCastling ).validate();
        
        Position position = Position.create( firstCorrelation, secondCorrelation, ColorEnum.WHITE, null, 0, 1 );
        
        assertThat( position.toString() )
                  .as( "the string representation should match" )
                  .isEqualTo( "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1" );
    }
    
    @Test
    @DisplayName("toString(): for the Italian opening the ToString representation is verified for initial position.")
    public void toString_ItalianOpening_InitialPosition() {
        
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
        Correlation secondCorrelation = Correlation.create( secondPlayer, secondCastling ).validate();
        
        Position position = Position.create( firstCorrelation, secondCorrelation, ColorEnum.WHITE, null, 0, 1 );
        
        assertThat( position.toString() )
                  .as( "the string representation should match" )
                  .isEqualTo( "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1" );
    } 
    
    @Test
    @DisplayName("toString(): for the Italian opening the ToString representation is verified after first ply.")
    public void toString_ItalianOpening_AfterFirstPly() {
        
        // 1. e4

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
        Correlation secondCorrelation = Correlation.create( secondPlayer, secondCastling ).validate();
                
        Position position = Position.create( firstCorrelation, secondCorrelation, ColorEnum.BLACK, "e3", 0, 1 );
        
        assertThat( position.toString() )
                  .as( "the string representation should match" )
                  .isEqualTo( "rnbqkbnr/pppppppp/8/8/4P3/8/PPPP1PPP/RNBQKBNR b KQkq e3 0 1" );
    }
    
    @Test
    @DisplayName("toString(): for the Italian opening the ToString representation is verified after second ply.")
    public void toString_ItalianOpening_AfterSecondPly() {
        
        // 1. e4 e5

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
                MovedBlackPawn.create( "e5" ), InitialWhitePawn.create( "f7" ), InitialWhitePawn.create( "g7" ), InitialWhitePawn.create( "h7" ) ));
        Castling secondCastling = Castling.create( Arrays.asList( CastlingElement.create( "a8",  'q' ), CastlingElement.create( "h8", 'k' ) ) );
        Correlation secondCorrelation = Correlation.create( secondPlayer, secondCastling ).validate();
        
        Position position = Position.create( firstCorrelation, secondCorrelation, ColorEnum.WHITE, "e6", 0, 2 );
        
        assertThat( position.toString() )
                  .as( "the string representation should match" )
                  .isEqualTo( "rnbqkbnr/pppp1ppp/8/4p3/4P3/8/PPPP1PPP/RNBQKBNR w KQkq e6 0 2" );
    }
    
    @Test
    @DisplayName("toString(): for the Italian opening the ToString representation is verified after third ply.")
    public void toString_ItalianOpening_AfterThirdPly() {
        
        // 1. e4 e5 2. Nf3

        Player firstPlayer = Player.create( ColorEnum.WHITE, Arrays.asList( 
                InitialKing.create( "e1" ), Queen.create( "d1" ), Rook.create( "a1" ), Rook.create( "h1" ),
                Knight.create( "b1" ), Knight.create( "f3" ), Bishop.create( "c1" ), Bishop.create( "f1" ),
                InitialWhitePawn.create( "a2" ), InitialWhitePawn.create( "b2" ), InitialWhitePawn.create( "c2" ), InitialWhitePawn.create( "d2" ),
                MovedWhitePawn.create( "e4" ), InitialWhitePawn.create( "f2" ), InitialWhitePawn.create( "g2" ), InitialWhitePawn.create( "h2" )  ));
        Castling firstCastling = Castling.create( Arrays.asList( CastlingElement.create( "a1",  'Q' ), CastlingElement.create( "h1", 'K' ) ) );
        Correlation firstCorrelation = Correlation.create( firstPlayer, firstCastling ).validate();
        
        Player secondPlayer = Player.create( ColorEnum.BLACK, Arrays.asList( 
                InitialKing.create( "e8" ), Queen.create( "d8" ), Rook.create( "a8" ), Rook.create( "h8" ),
                Knight.create( "b8" ), Knight.create( "g8" ), Bishop.create( "c8" ), Bishop.create( "f8" ),
                InitialWhitePawn.create( "a7" ), InitialWhitePawn.create( "b7" ), InitialWhitePawn.create( "c7" ), InitialWhitePawn.create( "d7" ),
                MovedBlackPawn.create( "e5" ), InitialWhitePawn.create( "f7" ), InitialWhitePawn.create( "g7" ), InitialWhitePawn.create( "h7" ) ));
        Castling secondCastling = Castling.create( Arrays.asList( CastlingElement.create( "a8",  'q' ), CastlingElement.create( "h8", 'k' ) ) );
        Correlation secondCorrelation = Correlation.create( secondPlayer, secondCastling ).validate();
        
        Position position = Position.create( firstCorrelation, secondCorrelation, ColorEnum.BLACK, null, 1, 2 );
        
        assertThat( position.toString() )
                  .as( "the string representation should match" )
                  .isEqualTo( "rnbqkbnr/pppp1ppp/8/4p3/4P3/5N2/PPPP1PPP/RNBQKB1R b KQkq - 1 2" );
    }
    
    @Test
    @DisplayName("toString(): for the Italian opening the ToString representation is verified after forth ply.")
    public void toString_ItalianOpening_AfterForthPly() {
        
        // 1. e4 e5 2. Nf3 Nc6

        Player firstPlayer = Player.create( ColorEnum.WHITE, Arrays.asList( 
                InitialKing.create( "e1" ), Queen.create( "d1" ), Rook.create( "a1" ), Rook.create( "h1" ),
                Knight.create( "b1" ), Knight.create( "f3" ), Bishop.create( "c1" ), Bishop.create( "f1" ),
                InitialWhitePawn.create( "a2" ), InitialWhitePawn.create( "b2" ), InitialWhitePawn.create( "c2" ), InitialWhitePawn.create( "d2" ),
                MovedWhitePawn.create( "e4" ), InitialWhitePawn.create( "f2" ), InitialWhitePawn.create( "g2" ), InitialWhitePawn.create( "h2" )  ));
        Castling firstCastling = Castling.create( Arrays.asList( CastlingElement.create( "a1",  'Q' ), CastlingElement.create( "h1", 'K' ) ) );
        Correlation firstCorrelation = Correlation.create( firstPlayer, firstCastling ).validate();
        
        Player secondPlayer = Player.create( ColorEnum.BLACK, Arrays.asList( 
                InitialKing.create( "e8" ), Queen.create( "d8" ), Rook.create( "a8" ), Rook.create( "h8" ),
                Knight.create( "c6" ), Knight.create( "g8" ), Bishop.create( "c8" ), Bishop.create( "f8" ),
                InitialWhitePawn.create( "a7" ), InitialWhitePawn.create( "b7" ), InitialWhitePawn.create( "c7" ), InitialWhitePawn.create( "d7" ),
                MovedBlackPawn.create( "e5" ), InitialWhitePawn.create( "f7" ), InitialWhitePawn.create( "g7" ), InitialWhitePawn.create( "h7" ) ));
        Castling secondCastling = Castling.create( Arrays.asList( CastlingElement.create( "a8",  'q' ), CastlingElement.create( "h8", 'k' ) ) );
        Correlation secondCorrelation = Correlation.create( secondPlayer, secondCastling ).validate();
        
        Position position = Position.create( firstCorrelation, secondCorrelation, ColorEnum.WHITE, null, 2, 3 );
        
        assertThat( position.toString() )
                  .as( "the string representation should match" )
                  .isEqualTo( "r1bqkbnr/pppp1ppp/2n5/4p3/4P3/5N2/PPPP1PPP/RNBQKB1R w KQkq - 2 3" );
    }
    
    @Test
    @DisplayName("toString(): for the Italian opening the ToString representation is verified after fifth ply.")
    public void toString_ItalianOpening_AfterFifthPly() {
        
        // 1. e4 e5 2. Nf3 Nc6 3. Bc4

        Player firstPlayer = Player.create( ColorEnum.WHITE, Arrays.asList( 
                InitialKing.create( "e1" ), Queen.create( "d1" ), Rook.create( "a1" ), Rook.create( "h1" ),
                Knight.create( "b1" ), Knight.create( "f3" ), Bishop.create( "c1" ), Bishop.create( "c4" ),
                InitialWhitePawn.create( "a2" ), InitialWhitePawn.create( "b2" ), InitialWhitePawn.create( "c2" ), InitialWhitePawn.create( "d2" ),
                MovedWhitePawn.create( "e4" ), InitialWhitePawn.create( "f2" ), InitialWhitePawn.create( "g2" ), InitialWhitePawn.create( "h2" )  ));
        Castling firstCastling = Castling.create( Arrays.asList( CastlingElement.create( "a1",  'Q' ), CastlingElement.create( "h1", 'K' ) ) );
        Correlation firstCorrelation = Correlation.create( firstPlayer, firstCastling ).validate();
        
        Player secondPlayer = Player.create( ColorEnum.BLACK, Arrays.asList( 
                InitialKing.create( "e8" ), Queen.create( "d8" ), Rook.create( "a8" ), Rook.create( "h8" ),
                Knight.create( "c6" ), Knight.create( "g8" ), Bishop.create( "c8" ), Bishop.create( "f8" ),
                InitialWhitePawn.create( "a7" ), InitialWhitePawn.create( "b7" ), InitialWhitePawn.create( "c7" ), InitialWhitePawn.create( "d7" ),
                MovedBlackPawn.create( "e5" ), InitialWhitePawn.create( "f7" ), InitialWhitePawn.create( "g7" ), InitialWhitePawn.create( "h7" ) ));
        Castling secondCastling = Castling.create( Arrays.asList( CastlingElement.create( "a8",  'q' ), CastlingElement.create( "h8", 'k' ) ) );
        Correlation secondCorrelation = Correlation.create( secondPlayer, secondCastling ).validate();
        
        Position position = Position.create( firstCorrelation, secondCorrelation, ColorEnum.BLACK, null, 3, 3 );
        
        assertThat( position.toString() )
                  .as( "the string representation should match" )
                  .isEqualTo( "r1bqkbnr/pppp1ppp/2n5/4p3/2B1P3/5N2/PPPP1PPP/RNBQK2R b KQkq - 3 3" );
    }
    
    @Test
    @DisplayName("toString(): for the Italian opening the ToString representation is verified after sixth ply.")
    public void toString_ItalianOpening_AfterSixthPly() {
        
        // 1. e4 e5 2. Nf3 Nc6 3. Bc4 Bc5

        Player firstPlayer = Player.create( ColorEnum.WHITE, Arrays.asList( 
                InitialKing.create( "e1" ), Queen.create( "d1" ), Rook.create( "a1" ), Rook.create( "h1" ),
                Knight.create( "b1" ), Knight.create( "f3" ), Bishop.create( "c1" ), Bishop.create( "c4" ),
                InitialWhitePawn.create( "a2" ), InitialWhitePawn.create( "b2" ), InitialWhitePawn.create( "c2" ), InitialWhitePawn.create( "d2" ),
                MovedWhitePawn.create( "e4" ), InitialWhitePawn.create( "f2" ), InitialWhitePawn.create( "g2" ), InitialWhitePawn.create( "h2" )  ));
        Castling firstCastling = Castling.create( Arrays.asList( CastlingElement.create( "a1",  'Q' ), CastlingElement.create( "h1", 'K' ) ) );
        Correlation firstCorrelation = Correlation.create( firstPlayer, firstCastling ).validate();
        
        Player secondPlayer = Player.create( ColorEnum.BLACK, Arrays.asList( 
                InitialKing.create( "e8" ), Queen.create( "d8" ), Rook.create( "a8" ), Rook.create( "h8" ),
                Knight.create( "c6" ), Knight.create( "g8" ), Bishop.create( "c8" ), Bishop.create( "c5" ),
                InitialWhitePawn.create( "a7" ), InitialWhitePawn.create( "b7" ), InitialWhitePawn.create( "c7" ), InitialWhitePawn.create( "d7" ),
                MovedBlackPawn.create( "e5" ), InitialWhitePawn.create( "f7" ), InitialWhitePawn.create( "g7" ), InitialWhitePawn.create( "h7" ) ));
        Castling secondCastling = Castling.create( Arrays.asList( CastlingElement.create( "a8",  'q' ), CastlingElement.create( "h8", 'k' ) ) );
        Correlation secondCorrelation = Correlation.create( secondPlayer, secondCastling ).validate();
        
        Position position = Position.create( firstCorrelation, secondCorrelation, ColorEnum.WHITE, null, 4, 4 );
        
        assertThat( position.toString() )
                  .as( "the string representation should match" )
                  .isEqualTo( "r1bqk1nr/pppp1ppp/2n5/2b1p3/2B1P3/5N2/PPPP1PPP/RNBQK2R w KQkq - 4 4" );
    }
    
    @Test
    @DisplayName("toString(): for the Italian opening the ToString representation is verified after seventh ply.")
    public void toString_ItalianOpening_AfterSeventhPly() {
        
        // 1. e4 e5 2. Nf3 Nf6 3. Bc4 Bc5 4. c3
        
        Player firstPlayer = Player.create( ColorEnum.WHITE, Arrays.asList( 
                InitialKing.create( "e1" ), Queen.create( "d1" ), Rook.create( "a1" ), Rook.create( "h1" ),
                Knight.create( "b1" ), Knight.create( "f3" ), Bishop.create( "c1" ), Bishop.create( "c4" ),
                InitialWhitePawn.create( "a2" ), InitialWhitePawn.create( "b2" ), MovedWhitePawn.create( "c3" ), InitialWhitePawn.create( "d2" ),
                MovedWhitePawn.create( "e4" ), InitialWhitePawn.create( "f2" ), InitialWhitePawn.create( "g2" ), InitialWhitePawn.create( "h2" )  ));
        Castling firstCastling = Castling.create( Arrays.asList( CastlingElement.create( "a1",  'Q' ), CastlingElement.create( "h1", 'K' ) ) );
        Correlation firstCorrelation = Correlation.create( firstPlayer, firstCastling ).validate();
        
        Player secondPlayer = Player.create( ColorEnum.BLACK, Arrays.asList( 
                InitialKing.create( "e8" ), Queen.create( "d8" ), Rook.create( "a8" ), Rook.create( "h8" ),
                Knight.create( "c6" ), Knight.create( "g8" ), Bishop.create( "c8" ), Bishop.create( "c5" ),
                InitialWhitePawn.create( "a7" ), InitialWhitePawn.create( "b7" ), InitialWhitePawn.create( "c7" ), InitialWhitePawn.create( "d7" ),
                MovedBlackPawn.create( "e5" ), InitialWhitePawn.create( "f7" ), InitialWhitePawn.create( "g7" ), InitialWhitePawn.create( "h7" ) ));
        Castling secondCastling = Castling.create( Arrays.asList( CastlingElement.create( "a8",  'q' ), CastlingElement.create( "h8", 'k' ) ) );
        Correlation secondCorrelation = Correlation.create( secondPlayer, secondCastling ).validate();
                
        Position position = Position.create( firstCorrelation, secondCorrelation, ColorEnum.BLACK, null, 0, 4 );
        
        assertThat( position.toString() )
                  .as( "the string representation should match" )
                  .isEqualTo( "r1bqk1nr/pppp1ppp/2n5/2b1p3/2B1P3/2P2N2/PP1P1PPP/RNBQK2R b KQkq - 0 4" );
    }
    
    @Test
    @DisplayName("toString(): for the Italian opening the ToString representation is verified after eighth ply.")
    public void toString_ItalianOpening_AfterEighthPly() {
        
        // 1. e4 e5 2. Nf3 Nf6 3. Bc4 Bc5 4. c3 Nf6
    
        Player firstPlayer = Player.create( ColorEnum.WHITE, Arrays.asList( 
                InitialKing.create( "e1" ), Queen.create( "d1" ), Rook.create( "a1" ), Rook.create( "h1" ),
                Knight.create( "b1" ), Knight.create( "f3" ), Bishop.create( "c1" ), Bishop.create( "c4" ),
                InitialWhitePawn.create( "a2" ), InitialWhitePawn.create( "b2" ), MovedWhitePawn.create( "c3" ), InitialWhitePawn.create( "d2" ),
                MovedWhitePawn.create( "e4" ), InitialWhitePawn.create( "f2" ), InitialWhitePawn.create( "g2" ), InitialWhitePawn.create( "h2" )  ));
        Castling firstCastling = Castling.create( Arrays.asList( CastlingElement.create( "a1",  'Q' ), CastlingElement.create( "h1", 'K' ) ) );
        Correlation firstCorrelation = Correlation.create( firstPlayer, firstCastling ).validate();
        
        Player secondPlayer = Player.create( ColorEnum.BLACK, Arrays.asList( 
                InitialKing.create( "e8" ), Queen.create( "d8" ), Rook.create( "a8" ), Rook.create( "h8" ),
                Knight.create( "c6" ), Knight.create( "f6" ), Bishop.create( "c8" ), Bishop.create( "c5" ),
                InitialWhitePawn.create( "a7" ), InitialWhitePawn.create( "b7" ), InitialWhitePawn.create( "c7" ), InitialWhitePawn.create( "d7" ),
                MovedBlackPawn.create( "e5" ), InitialWhitePawn.create( "f7" ), InitialWhitePawn.create( "g7" ), InitialWhitePawn.create( "h7" ) ));
        Castling secondCastling = Castling.create( Arrays.asList( CastlingElement.create( "a8",  'q' ), CastlingElement.create( "h8", 'k' ) ) );
        Correlation secondCorrelation = Correlation.create( secondPlayer, secondCastling ).validate();
                
        Position position = Position.create( firstCorrelation, secondCorrelation, ColorEnum.WHITE, null, 1, 5 );
        
        assertThat( position.toString() )
                  .as( "the string representation should match" )
                  .isEqualTo( "r1bqk2r/pppp1ppp/2n2n2/2b1p3/2B1P3/2P2N2/PP1P1PPP/RNBQK2R w KQkq - 1 5" );
    }
    
    @Test
    @DisplayName("toString(): for the Italian opening the ToString representation is verified after ninth ply.")
    public void toString_ItalianOpening_AfterNinthPly() {
        
        // 1. e4 e5 2. Nf3 Nf6 3. Bc4 Bc5 4. c3 Nf6 5. d3
        
        Player firstPlayer = Player.create( ColorEnum.WHITE, Arrays.asList( 
                InitialKing.create( "e1" ), Queen.create( "d1" ), Rook.create( "a1" ), Rook.create( "h1" ),
                Knight.create( "b1" ), Knight.create( "f3" ), Bishop.create( "c1" ), Bishop.create( "c4" ),
                InitialWhitePawn.create( "a2" ), InitialWhitePawn.create( "b2" ), MovedWhitePawn.create( "c3" ), MovedWhitePawn.create( "d3" ),
                MovedWhitePawn.create( "e4" ), InitialWhitePawn.create( "f2" ), InitialWhitePawn.create( "g2" ), InitialWhitePawn.create( "h2" )  ));
        Castling firstCastling = Castling.create( Arrays.asList( CastlingElement.create( "a1",  'Q' ), CastlingElement.create( "h1", 'K' ) ) );
        Correlation firstCorrelation = Correlation.create( firstPlayer, firstCastling ).validate();
        
        Player secondPlayer = Player.create( ColorEnum.BLACK, Arrays.asList( 
                InitialKing.create( "e8" ), Queen.create( "d8" ), Rook.create( "a8" ), Rook.create( "h8" ),
                Knight.create( "c6" ), Knight.create( "f6" ), Bishop.create( "c8" ), Bishop.create( "c5" ),
                InitialWhitePawn.create( "a7" ), InitialWhitePawn.create( "b7" ), InitialWhitePawn.create( "c7" ), InitialWhitePawn.create( "d7" ),
                MovedBlackPawn.create( "e5" ), InitialWhitePawn.create( "f7" ), InitialWhitePawn.create( "g7" ), InitialWhitePawn.create( "h7" ) ));
        Castling secondCastling = Castling.create( Arrays.asList( CastlingElement.create( "a8",  'q' ), CastlingElement.create( "h8", 'k' ) ) );
        Correlation secondCorrelation = Correlation.create( secondPlayer, secondCastling ).validate();
                
        Position position = Position.create( firstCorrelation, secondCorrelation, ColorEnum.BLACK, null, 0, 5 );
        
        assertThat( position.toString() )
                  .as( "the string representation should match" )
                  .isEqualTo( "r1bqk2r/pppp1ppp/2n2n2/2b1p3/2B1P3/2PP1N2/PP3PPP/RNBQK2R b KQkq - 0 5" );
    }
    
    @Test
    @DisplayName("toString(): for the Italian opening the ToString representation is verified after tenth ply.")
    public void toString_ItalianOpening_AfterTenthPly() {
        
        // 1. e4 e5 2. Nf3 Nf6 3. Bc4 Bc5 4. c3 Nf6 5. d3 d6
        
        Player firstPlayer = Player.create( ColorEnum.WHITE, Arrays.asList( 
                InitialKing.create( "e1" ), Queen.create( "d1" ), Rook.create( "a1" ), Rook.create( "h1" ),
                Knight.create( "b1" ), Knight.create( "f3" ), Bishop.create( "c1" ), Bishop.create( "c4" ),
                InitialWhitePawn.create( "a2" ), InitialWhitePawn.create( "b2" ), MovedWhitePawn.create( "c3" ), MovedWhitePawn.create( "d3" ),
                MovedWhitePawn.create( "e4" ), InitialWhitePawn.create( "f2" ), InitialWhitePawn.create( "g2" ), InitialWhitePawn.create( "h2" )  ));
        Castling firstCastling = Castling.create( Arrays.asList( CastlingElement.create( "a1",  'Q' ), CastlingElement.create( "h1", 'K' ) ) );
        Correlation firstCorrelation = Correlation.create( firstPlayer, firstCastling ).validate();
        
        Player secondPlayer = Player.create( ColorEnum.BLACK, Arrays.asList( 
                InitialKing.create( "e8" ), Queen.create( "d8" ), Rook.create( "a8" ), Rook.create( "h8" ),
                Knight.create( "c6" ), Knight.create( "f6" ), Bishop.create( "c8" ), Bishop.create( "c5" ),
                InitialWhitePawn.create( "a7" ), InitialWhitePawn.create( "b7" ), InitialWhitePawn.create( "c7" ), MovedBlackPawn.create( "d6" ),
                MovedBlackPawn.create( "e5" ), InitialWhitePawn.create( "f7" ), InitialWhitePawn.create( "g7" ), InitialWhitePawn.create( "h7" ) ));
        Castling secondCastling = Castling.create( Arrays.asList( CastlingElement.create( "a8",  'q' ), CastlingElement.create( "h8", 'k' ) ) );
        Correlation secondCorrelation = Correlation.create( secondPlayer, secondCastling ).validate();
                
        Position position = Position.create( firstCorrelation, secondCorrelation, ColorEnum.WHITE, null, 0, 6 );
        
        assertThat( position.toString() )
                  .as( "the string representation should match" )
                  .isEqualTo( "r1bqk2r/ppp2ppp/2np1n2/2b1p3/2B1P3/2PP1N2/PP3PPP/RNBQK2R w KQkq - 0 6" );
    }
    
    @Test
    @DisplayName("toString(): for the Italian opening the ToString representation is verified after eleventh ply.")
    public void toString_ItalianOpening_AfterEleventhPly() {
        
        // 1. e4 e5 2. Nf3 Nf6 3. Bc4 Bc5 4. c3 Nf6 5. d3 d6 6.0-0
        
        Player firstPlayer = Player.create( ColorEnum.WHITE, Arrays.asList( 
                MovedKing.create( "g1" ), Queen.create( "d1" ), Rook.create( "a1" ), Rook.create( "f1" ),
                Knight.create( "b1" ), Knight.create( "f3" ), Bishop.create( "c1" ), Bishop.create( "c4" ),
                InitialWhitePawn.create( "a2" ), InitialWhitePawn.create( "b2" ), MovedWhitePawn.create( "c3" ), MovedWhitePawn.create( "d3" ),
                MovedWhitePawn.create( "e4" ), InitialWhitePawn.create( "f2" ), InitialWhitePawn.create( "g2" ), InitialWhitePawn.create( "h2" )  ));
        Castling firstCastling = Castling.createEmpty();
        Correlation firstCorrelation = Correlation.create( firstPlayer, firstCastling ).validate();
        
        Player secondPlayer = Player.create( ColorEnum.BLACK, Arrays.asList( 
                InitialKing.create( "e8" ), Queen.create( "d8" ), Rook.create( "a8" ), Rook.create( "h8" ),
                Knight.create( "c6" ), Knight.create( "f6" ), Bishop.create( "c8" ), Bishop.create( "c5" ),
                InitialWhitePawn.create( "a7" ), InitialWhitePawn.create( "b7" ), InitialWhitePawn.create( "c7" ), MovedBlackPawn.create( "d6" ),
                MovedBlackPawn.create( "e5" ), InitialWhitePawn.create( "f7" ), InitialWhitePawn.create( "g7" ), InitialWhitePawn.create( "h7" ) ));
        Castling secondCastling = Castling.create( Arrays.asList( CastlingElement.create( "a8",  'q' ), CastlingElement.create( "h8", 'k' ) ) );
        Correlation secondCorrelation = Correlation.create( secondPlayer, secondCastling ).validate();
                
        Position position = Position.create( firstCorrelation, secondCorrelation, ColorEnum.BLACK, null, 1, 6 );
        
        assertThat( position.toString() )
                  .as( "the string representation should match" )
                  .isEqualTo( "r1bqk2r/ppp2ppp/2np1n2/2b1p3/2B1P3/2PP1N2/PP3PPP/RNBQ1RK1 b kq - 1 6" );
    }
    
    @Test
    @DisplayName("toString(): for the Italian opening the ToString representation is verified after twelfth ply.")
    public void toString_ItalianOpening_AfterTwelfthPly() {
        
        // 1. e4 e5 2. Nf3 Nf6 3. Bc4 Bc5 4. c3 Nf6 5. d3 d6 6.0-0 0-0
        
        Player firstPlayer = Player.create( ColorEnum.WHITE, Arrays.asList( 
                MovedKing.create( "g1" ), Queen.create( "d1" ), Rook.create( "a1" ), Rook.create( "f1" ),
                Knight.create( "b1" ), Knight.create( "f3" ), Bishop.create( "c1" ), Bishop.create( "c4" ),
                InitialWhitePawn.create( "a2" ), InitialWhitePawn.create( "b2" ), MovedWhitePawn.create( "c3" ), MovedWhitePawn.create( "d3" ),
                MovedWhitePawn.create( "e4" ), InitialWhitePawn.create( "f2" ), InitialWhitePawn.create( "g2" ), InitialWhitePawn.create( "h2" )  ));
        Castling firstCastling = Castling.createEmpty();
        Correlation firstCorrelation = Correlation.create( firstPlayer, firstCastling ).validate();
        
        Player secondPlayer = Player.create( ColorEnum.BLACK, Arrays.asList( 
                MovedKing.create( "g8" ), Queen.create( "d8" ), Rook.create( "a8" ), Rook.create( "f8" ),
                Knight.create( "c6" ), Knight.create( "f6" ), Bishop.create( "c8" ), Bishop.create( "c5" ),
                InitialWhitePawn.create( "a7" ), InitialWhitePawn.create( "b7" ), InitialWhitePawn.create( "c7" ), MovedBlackPawn.create( "d6" ),
                MovedBlackPawn.create( "e5" ), InitialWhitePawn.create( "f7" ), InitialWhitePawn.create( "g7" ), InitialWhitePawn.create( "h7" ) ));
        Castling secondCastling = Castling.createEmpty();
        Correlation secondCorrelation = Correlation.create( secondPlayer, secondCastling ).validate();
                
        Position position = Position.create( firstCorrelation, secondCorrelation, ColorEnum.WHITE, null, 2, 7 );
        
        assertThat( position.toString() )
                  .as( "the string representation should match" )
                  .isEqualTo( "r1bq1rk1/ppp2ppp/2np1n2/2b1p3/2B1P3/2PP1N2/PP3PPP/RNBQ1RK1 w - - 2 7" );
    }
}


