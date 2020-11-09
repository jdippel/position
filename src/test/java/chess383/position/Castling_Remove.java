/*
 *  Castling_Remove.java
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

/**
 * <p>
 * The class Castling_Remove implements an upper tester
 * </p>
 *
 * @author    Jörg Dippel
 * @version   September 2020
 *
 */
@DisplayName("the public method Castling remove( ) for class Castling is tested")
public class Castling_Remove {  
    
    @Test
    @DisplayName("remove(): when white castling to a1 is possible, it can be removed")
    public void remove_A1() {
        
        Castling whiteCastling = Castling.create( Arrays.asList( CastlingElement.create( "a1", 'Q' ), CastlingElement.create( "h1", 'K' ) ) );
        
        assertThat( whiteCastling.remove( "a1" ).toString() )
                  .as( "a possibility to castle should be removed" )
                  .isEqualTo( "K" );
    }
    
    @Test
    @DisplayName("remove(): when white castling to h1 is possible, it can be removed")
    public void remove_H1() {
        
        Castling whiteCastling = Castling.create( Arrays.asList( CastlingElement.create( "a1", 'Q' ), CastlingElement.create( "h1", 'K' ) ) );
        
        assertThat( whiteCastling.remove( "h1" ).toString() )
                  .as( "a possibility to castle should be removed" )
                  .isEqualTo( "Q" );
    }
    
    @Test
    @DisplayName("remove(): when black castling to a1 is possible, it can be removed")
    public void remove_A8() {
        
        Castling blackCastling = Castling.create( Arrays.asList( CastlingElement.create( "a8", 'q' ), CastlingElement.create( "h8", 'k' ) ) );
        
        assertThat( blackCastling.remove( "a8" ).toString() )
                  .as( "a possibility to castle should be removed" )
                  .isEqualTo( "k" );
    }
    
    @Test
    @DisplayName("remove(): when black castling to h8 is possible, it can be removed")
    public void remove_H8() {
        
        Castling blackCastling = Castling.create( Arrays.asList( CastlingElement.create( "a8", 'q' ), CastlingElement.create( "h8", 'k' ) ) );
        
        assertThat( blackCastling.remove( "h8" ).toString() )
                  .as( "a possibility to castle should be removed" )
                  .isEqualTo( "q" );
    }
    
    @Test
    @DisplayName("remove(): when black castling possible, an arbitrary location will be ignored")
    public void remove_Arbitrary() {
        
        Castling blackCastling = Castling.create( Arrays.asList( CastlingElement.create( "a8", 'q' ), CastlingElement.create( "h8", 'k' ) ) );
        
        assertThat( blackCastling.remove( "c8" ).toString() )
                  .as( "a possibility to castle should be removed" )
                  .isEqualTo( "kq" );
    }
    
    @Test
    @DisplayName("remove(): when black castling to h8 is possible, it can be removed (using createBlackCastling())")
    public void remove_H8WithInitialDefinition() {
        
        Castling blackCastling = Castling.createBlackCastling();
        
        assertThat( blackCastling.remove( "h8" ).toString() )
                  .as( "a possibility to castle should be removed" )
                  .isEqualTo( "q" );
    }
    
    @Test
    @DisplayName("remove(): when white queenside castling via 'Q' is possible, it can be removed")
    public void remove_WhiteQueensideCastling() {
        
        Castling whiteCastling = Castling.create( Arrays.asList( CastlingElement.create( "a1", 'Q' ), CastlingElement.create( "h1", 'K' ) ) );
        
        assertThat( whiteCastling.remove( 'Q' ).toString() )
                  .as( "a possibility to castle should be removed" )
                  .isEqualTo( "K" );
    }
    
    @Test
    @DisplayName("remove(): when white queenside castling via 'Q' is not possible, removal is idempotent")
    public void remove_WhiteQueensideCastlingWithoutPossibility() {
        
        Castling whiteCastling = Castling.create( Arrays.asList( CastlingElement.create( "h1", 'K' ) ) );
        
        assertThat( whiteCastling.remove( 'Q' ).toString() )
                  .as( "a possibility to castle should be removed" )
                  .isEqualTo( "K" );
    }
    
    @Test
    @DisplayName("remove(): when black kingside castling via 'k' is possible, it can be removed")
    public void remove_BlackKingsideCastling() {
        
        Castling blackCastling = Castling.create( Arrays.asList( CastlingElement.create( "a8", 'q' ), CastlingElement.create( "h8", 'k' ) ) );
        
        assertThat( blackCastling.remove( 'k' ).toString() )
                  .as( "a possibility to castle should be removed" )
                  .isEqualTo( "q" );
    }
}


