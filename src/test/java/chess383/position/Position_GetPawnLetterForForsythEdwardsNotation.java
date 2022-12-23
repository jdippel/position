/*
 *  Position_GetNumberOfPieces.java
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

import chess383.ICoordinateFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * <p>
 * The class Position_GetPawnLetterForForsythEdwardsNotation implements an upper tester
 * </p>
 *
 * @author    Jörg Dippel
 * @version   November 2022
 *
 */
@DisplayName("the public method Character getPawnLetterForForsythEdwardsNotation() for class Position is tested for given FEN notations")
public class Position_GetPawnLetterForForsythEdwardsNotation {

    final static Character WHITE_PAWN = 'P';
    final static Character BLACK_PAWN = 'p';

    @ParameterizedTest( name = "given a FEN (Forsyth-Edwards notation) \"{0}\" then the FEN letter for a pawn should be returned." )
    @MethodSource("CounterAndFENProvider")
    public void testWithArgMethodSource_ReturnPosition( Character letter, String fen) {
        
        ICoordinateFactory.STANDARD.get();
        
        assertThat( letter )
                .as( String.format( "Given a Forsyth-Edwards notation \"%s\" then the FEN letter for an active pawn is determined", fen ) )
                .isEqualTo( Position.create( fen ).getPawnLetterForForsythEdwardsNotation() );
    }
    
    
    public static Stream<Arguments> CounterAndFENProvider() {
        return Stream.of(
            
            Arguments.of( WHITE_PAWN, "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1" )
          , Arguments.of( WHITE_PAWN, "r1bqk2r/pppp1ppp/2n2n2/2b1p3/2B1P3/2P2N2/PP1P1PPP/RNBQK2R w KQkq - 1 5" )
          , Arguments.of( BLACK_PAWN, "r1bqk2r/ppp2ppp/2np1n2/2b1p3/2B1P3/2PP1N2/PP3PPP/RNBQ1RK1 b kq - 1 6" )
          , Arguments.of( WHITE_PAWN, "r1bq1rk1/ppp2ppp/2np1n2/2b1p3/2B1P3/2PP1N2/PP3PPP/RNBQ1RK1 w - - 2 7" )
            
        ); }
}

