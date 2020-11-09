/*
 *  Castling_Create.java
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
 * The class Castling_Create implements an upper tester
 * </p>
 *
 * @author    Jörg Dippel
 * @version   September 2020
 *
 */
@DisplayName("the public static method Castling create( ) for class Castling is tested")
public class Castling_Create {  
    
    @Test
    @DisplayName("create(): empty")
    public void create_CreatingEmpty() {
        
        Castling whiteCastling = Castling.createEmpty();
        
        assertThat( whiteCastling.toString() )
                  .as( "a description for castling should match the created instance" )
                  .isEqualTo( "" );
    }
    
    @Test
    @DisplayName("create(): empty explicitely")
    public void create_CreatingEmptyExplicitely() {
        
        Castling whiteCastling = Castling.create( new ArrayList<CastlingElement>() );
        
        assertThat( whiteCastling.toString() )
                  .as( "a description for castling should match the created instance" )
                  .isEqualTo( "" );
    }
    
    // -----
    
    @Test
    @DisplayName("create(): creating white initial castling explicitely")
    public void create_CreatingForWhiteExplicitely() {
        
        Castling whiteCastling = Castling.create( Arrays.asList( CastlingElement.create( "h1", 'K' ), CastlingElement.create( "a1", 'Q' ) ) );
        
        assertThat( whiteCastling.toString() )
                  .as( "a description for castling should match the created instance" )
                  .isEqualTo( "KQ" );
    }
    
    @Test
    @DisplayName("create(): creating white initial castling explicitely but unexpected order")
    public void create_CreatingForWhiteExplicitelyButUnexpectedOrder() {
        
        Castling whiteCastling = Castling.create( Arrays.asList( CastlingElement.create( "a1", 'Q' ), CastlingElement.create( "h1", 'K' ) ) );
        
        assertThat( whiteCastling.toString() )
                  .as( "a description for castling should match the created instance" )
                  .isEqualTo( "KQ" );
    }
    
    @Test
    @DisplayName("create(): creating white initial castling")
    public void create_CreatingForWhite() {
        
        Castling whiteCastling = Castling.createWhiteCastling();
        
        assertThat( whiteCastling.toString() )
                  .as( "a description for castling should match the created instance" )
                  .isEqualTo( "KQ" );
    }
    
    @Test
    @DisplayName("create(): creating white castling only for a1")
    public void create_CreatingWhiteCastlingForA1() {
        
        Castling whiteCastling = Castling.create( Arrays.asList( CastlingElement.create( "a1", 'Q' ) ) );
        
        assertThat( whiteCastling.toString() )
                  .as( "a description for castling should match the created instance" )
                  .isEqualTo( "Q" );
    }
    
    @Test
    @DisplayName("create(): creating white castling only for h1")
    public void create_CreatingWhiteCastlingForH1() {
        
        Castling whiteCastling = Castling.create( Arrays.asList( CastlingElement.create( "h1", 'K' ) ) );
        
        assertThat( whiteCastling.toString() )
                  .as( "a description for castling should match the created instance" )
                  .isEqualTo( "K" );
    }
    
    // -----
    
    @Test
    @DisplayName("create(): creating black initial castling explicitely")
    public void create_CreatingForBlackExplicitely() {
        
        Castling blackCastling = Castling.create( Arrays.asList( CastlingElement.create( "h8", 'k' ), CastlingElement.create( "a8", 'q' ) ) );
        
        assertThat( blackCastling.toString() )
                  .as( "a description for castling should match the created instance" )
                  .isEqualTo( "kq" );
    }
    
    @Test
    @DisplayName("create(): creating black initial castling explicitely but unexpected order")
    public void create_CreatingForBlackExplicitelyButUnexpectedOrder() {
        
        Castling blackCastling = Castling.create( Arrays.asList( CastlingElement.create( "a8", 'q' ), CastlingElement.create( "h8", 'k' ) ) );
        
        assertThat( blackCastling.toString() )
                  .as( "a description for castling should match the created instance" )
                  .isEqualTo( "kq" );
    }
    
    @Test
    @DisplayName("create(): creating black initial castling")
    public void create_CreatingForBlack() {
        
        Castling blackCastling = Castling.createBlackCastling();
        
        assertThat( blackCastling.toString() )
                  .as( "a description for castling should match the created instance" )
                  .isEqualTo( "kq" );
    }
    
    @Test
    @DisplayName("create(): creating black castling only for a8")
    public void create_CreatingBlackCastlingForA1() {
        
        Castling blackCastling = Castling.create( Arrays.asList( CastlingElement.create( "a8", 'q' ) ) );
        
        assertThat( blackCastling.toString() )
                  .as( "a description for castling should match the created instance" )
                  .isEqualTo( "q" );
    }
    
    @Test
    @DisplayName("create(): creating black castling only for h8")
    public void create_CreatingBlackCastlingForH1() {
        
        Castling blackCastling = Castling.create( Arrays.asList( CastlingElement.create( "h8", 'k' ) ) );
        
        assertThat( blackCastling.toString() )
                  .as( "a description for castling should match the created instance" )
                  .isEqualTo( "k" );
    }
}


