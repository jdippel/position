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

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import chess383.ICoordinateFactory;

/**
 * <p>
 * The class Position_GetNumberOfPieces implements an upper tester
 * </p>
 *
 * @author    Jörg Dippel
 * @version   November 2022
 *
 */
@DisplayName("the public method int getNumberOfPieces( ) for class Position is tested for given FEN notations")
public class Position_GetNumberOfPieces {
    
    @ParameterizedTest( name = "given a FEN (Forsyth-Edwards notation) \"{0}\" then a position should be returned." )
    @MethodSource("CounterAndFENProvider")
    public void testWithArgMethodSource_ReturnPosition( int numberOfPieces, String fen) {
        
        ICoordinateFactory.STANDARD.get();
        
        assertThat( numberOfPieces )
                .as( String.format( "Given a Forsyth-Edwards notation \"%s\" then the number of pieces is determined", fen ) )
                .isEqualTo( Position.create( fen ).getNumberOfPieces() );
    }
    
    
    public static Stream<Arguments> CounterAndFENProvider() {
        return Stream.of(
            
            Arguments.of( 32, "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1" )
          , Arguments.of( 32, "r1bqk2r/pppp1ppp/2n2n2/2b1p3/2B1P3/2P2N2/PP1P1PPP/RNBQK2R w KQkq - 1 5" )
          , Arguments.of( 32, "r1bqk2r/ppp2ppp/2np1n2/2b1p3/2B1P3/2PP1N2/PP3PPP/RNBQ1RK1 b kq - 1 6" )
          , Arguments.of( 32, "r1bq1rk1/ppp2ppp/2np1n2/2b1p3/2B1P3/2PP1N2/PP3PPP/RNBQ1RK1 w - - 2 7" )
          , Arguments.of( 15, "8/pN5k/2p5/2P1b1pp/P1r5/5pPK/3R1P2/8 b - - 0 97" )
          , Arguments.of( 20, "k2r4/1p2q3/p1p1P3/3n2p1/3N3p/P6P/1P3rP1/K1QRR3 w - - 0 68" )
            
        ); }
}

