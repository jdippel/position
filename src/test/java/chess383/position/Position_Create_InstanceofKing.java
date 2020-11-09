/*
 *  Position_Create_InstanceofKing.java
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

import chess383.piece.concretion.king.InitialKing;
import chess383.piece.concretion.king.MovedKing;
import chess383.piece.concretion.rook.Rook;

/**
 * <p>
 * The class Position_Create_InstanceofKing implements an upper tester for the standard Forsyth-Edwards-Notation
 * </p>
 *
 * @author    Jörg Dippel
 * @version   September 2020
 *
 */
@DisplayName("the public static method Position create( ) for class Position is tested for given FEN notations and then the type of the king is checked")
public class Position_Create_InstanceofKing {  
    
    @Test
    @DisplayName("create(): both king are initial")
    public void create_BothKingAreInitial() {
        
        Position position = Position.create( "r1bqkbnr/pppp1ppp/2n5/4p3/4P3/5N2/PPPP1PPP/RNBQKB1R w KQkq - 2 3" );
        
        assertThat( position.getPiece( "e1" ) instanceof InitialKing ).as( "the white king has not moved yet" ).isTrue();
        assertThat( position.getPiece( "e8" ) instanceof InitialKing ).as( "the black king has not moved yet" ).isTrue();
    }
    
    @Test
    @DisplayName("create(): the white king has already castled")
    public void create_WhiteKingHasAlreadyCastled() {
        
        Position position = Position.create( "r1bqk2r/ppp2ppp/2np1n2/2b1p3/2B1P3/2PP1N2/PP3PPP/RNBQ1RK1 b kq - 1 6" );
        
        assertThat( position.getPiece( "e1" ) ).as( "there is no piece located on that specified location" ).isNull();
        assertThat( position.getPiece( "g1" ) instanceof MovedKing ).as( "the white king has already castled" ).isTrue();
        assertThat( position.getPiece( "e8" ) instanceof InitialKing ).as( "the black king has not moved yet" ).isTrue();
    }
    
    @Test
    @DisplayName("create(): both sides have already castled")
    public void create_BothSideHaveAlreadyCastled() {
        
        Position position = Position.create( "r1bq1rk1/ppp2ppp/2np1n2/2b1p3/2B1P3/2PP1N2/PP3PPP/RNBQ1RK1 w - - 2 7" );
        
        assertThat( position.getPiece( "e1" ) ).as( "there is no piece located on that specified location" ).isNull();
        assertThat( position.getPiece( "g1" ) instanceof MovedKing ).as( "the white king has already castled" ).isTrue();
        assertThat( position.getPiece( "e8" ) ).as( "there is no piece located on that specified location" ).isNull();
        assertThat( position.getPiece( "g8" ) instanceof MovedKing ).as( "the white king has already castled" ).isTrue();
    }
    
    @Test
    @DisplayName("create(): a rook has been moved")
    public void create_RookHasBeenMoved() {
        
        Position position = Position.create( "r1bqkb1r/pppp1ppp/2n2n2/4p3/2B1P3/5N2/PPPP1PPP/RNBQK1R1 b Qkq - 5 8"  );
        
        assertThat( position.getPiece( "e1" ) instanceof InitialKing ).as( "the white king has not been moved" ).isTrue();
        assertThat( position.getPiece( "h1" ) ).as( "the kingside white rook has been moved" ).isNull();
        assertThat( position.getPiece( "g1" ) instanceof Rook ).as( "the white rook is here located" ).isTrue();
    }
}


