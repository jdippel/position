/*
 *  Castling_IsEmpty.java
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

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * <p>
 * The class Castling_IsEmpty implements an upper tester
 * </p>
 *
 * @author    Jörg Dippel
 * @version   September 2020
 *
 */
@DisplayName("the public method boolean isEmpty( ) for class Castling is tested")
public class Castling_IsEmpty {  
    
    @Test
    @DisplayName("isEmpty(): for createEmpty() method")
    public void create_CreatingEmpty() {
        
        Castling castling = Castling.createEmpty();
        
        assertThat( castling.isEmpty() )
                  .as( "a description for castling should match the created instances" )
                  .isTrue();
    }
    
    @Test
    @DisplayName("isEmpty(): for create() method with an empty array")
    public void create_CreatingEmptyExplicitely() {
        
        Castling castling = Castling.create( new ArrayList<CastlingElement>() );
        
        assertThat( castling.isEmpty() )
                  .as( "a description for castling should match the created instances" )
                  .isTrue();
    }
    
    // -----
    
    @Test
    @DisplayName("isEmpty(): creating white initial castling explicitely")
    public void create_CreatingForWhiteExplicitely() {
        
        Castling whiteCastling = Castling.create( Arrays.asList( CastlingElement.create( "h1", 'K' ), CastlingElement.create( "a1", 'Q' ) ) );
        
        assertThat( whiteCastling.isEmpty() )
                  .as( "a description for castling should match the created instances" )
                  .isFalse();
    }
    
    @Test
    @DisplayName("isEmpty(): creating black initial castling")
    public void create_CreatingForBlack() {
        
        Castling blackCastling = Castling.createBlackCastling();
        
        assertThat( blackCastling.isEmpty() )
                  .as( "a description for castling should match the created instances" )
                  .isFalse();
    }
}


