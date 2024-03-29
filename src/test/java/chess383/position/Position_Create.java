/*
 *  Position_Create.java
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
import java.util.stream.Stream;

import chess383.ColorEnum;
import chess383.piece.concretion.bishop.Bishop;
import chess383.piece.concretion.king.InitialKing;
import chess383.piece.concretion.knight.Knight;
import chess383.piece.concretion.pawn.InitialWhitePawn;
import chess383.piece.concretion.queen.Queen;
import chess383.piece.concretion.rook.Rook;
import chess383.player.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import chess383.ICoordinateFactory;

/**
 * <p>
 * The class Position_Create implements an upper tester
 * </p>
 *
 * @author    Jörg Dippel
 * @version   November 2022
 *
 */
@DisplayName("the public static method Position create( ) for class Position is tested for given FEN notations")
public class Position_Create {
    
    @ParameterizedTest( name = "given a FEN (Forsyth-Edwards notation) \"{0}\" then a position should be returned." )
    @MethodSource("FENProvider")
    public void testWithArgMethodSource_ReturnPosition( String fen) {
        
        ICoordinateFactory.STANDARD.get();
        
        assertThat( fen )
                .as( String.format( "Given a Forsyth-Edwards notation \"%s\", the created position based on the FEN should return the fen provided by the method toString()", fen ) )
                .isEqualTo( Position.create( fen ).toString() );
    }
    
    
    public static Stream<Arguments> FENProvider() {
        return Stream.of(
            
            Arguments.of( "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1" )
          , Arguments.of( "r1bqk2r/pppp1ppp/2n2n2/2b1p3/2B1P3/2P2N2/PP1P1PPP/RNBQK2R w KQkq - 1 5" )
          , Arguments.of( "r1bqk2r/ppp2ppp/2np1n2/2b1p3/2B1P3/2PP1N2/PP3PPP/RNBQ1RK1 b kq - 1 6" )
          , Arguments.of( "r1bq1rk1/ppp2ppp/2np1n2/2b1p3/2B1P3/2PP1N2/PP3PPP/RNBQ1RK1 w - - 2 7" )
          , Arguments.of( "8/pN5k/2p5/2P1b1pp/P1r5/5pPK/3R1P2/8 b - - 0 97" )
          , Arguments.of( "k2r4/1p2q3/p1p1P3/3n2p1/3N3p/P6P/1P3rP1/K1QRR3 w - - 0 68" )
          , Arguments.of( "r1bqkb1r/pppp1ppp/2n2n2/4p3/2B1P3/5N2/PPPP1PPP/RNBQK1R1 b Qkq - 5 8" )  // bug in version 1.0.15
            
        ); }


    @Test
    @DisplayName("create(): creates initial position without passing parameters")
    public void create_CreateInitialPosition() {

        Position position = Position.create();

        assertThat( position.toString() )
                .as( "an initial position is created" )
                .isEqualTo( "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1" );
    }
}

