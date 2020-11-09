/*
 *  Castling_GetLocations.java
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
 * The class Castling_GetLocations implements an upper tester
 * </p>
 *
 * @author    Jörg Dippel
 * @version   September 2020
 *
 */
@DisplayName("the public method Set<String> getLocations( ) for class Castling is tested")
public class Castling_GetLocations {  
    
    @Test
    @DisplayName("getLocations(): empty")
    public void getLocations_CreatingEmpty() {
        
        Castling whiteCastling = Castling.createEmpty();
        
        assertThat( whiteCastling.getLocations().size() )
                  .as( "there are no location for castling" )
                  .isEqualTo( 0 );
    }
    
    @Test
    @DisplayName("getLocations(): empty explicitely")
    public void getLocations_CreatingEmptyExplicitely() {
        
        Castling whiteCastling = Castling.create( new ArrayList<CastlingElement>() );
        
        assertThat( whiteCastling.getLocations().size() )
                  .as( "there are no location for castling" )
                  .isEqualTo( 0 );
    }
    
    // -----
    
    @Test
    @DisplayName("getLocations(): creating white initial castling explicitely")
    public void getLocations_CreatingForWhiteExplicitely() {
        
        Castling whiteCastling = Castling.create( Arrays.asList( CastlingElement.create( "h1", 'K' ), CastlingElement.create( "a1", 'Q' ) ) );
        
        assertThat( whiteCastling.getLocations().contains( "a1" ) ).as( "location should be contained" ).isTrue();
        assertThat( whiteCastling.getLocations().contains( "h1" ) ).as( "location should be contained" ).isTrue();
    }
    
    @Test
    @DisplayName("getLocations(): creating white initial castling explicitely but unexpected order")
    public void getLocations_CreatingForWhiteExplicitelyButUnexpectedOrder() {
        
        Castling whiteCastling = Castling.create( Arrays.asList( CastlingElement.create( "a1", 'Q' ), CastlingElement.create( "h1", 'K' ) ) );
        
        assertThat( whiteCastling.getLocations().contains( "a1" ) ).as( "location should be contained" ).isTrue();
        assertThat( whiteCastling.getLocations().contains( "h1" ) ).as( "location should be contained" ).isTrue();
    }
    
    @Test
    @DisplayName("getLocations(): creating white initial castling")
    public void getLocations_CreatingForWhite() {
        
        Castling whiteCastling = Castling.createWhiteCastling();
        
        assertThat( whiteCastling.getLocations().contains( "a1" ) ).as( "location should be contained" ).isTrue();
        assertThat( whiteCastling.getLocations().contains( "h1" ) ).as( "location should be contained" ).isTrue();
    }
    
    @Test
    @DisplayName("getLocations(): creating white castling only for a1")
    public void getLocations_CreatingWhiteCastlingForA1() {
        
        Castling whiteCastling = Castling.create( Arrays.asList( CastlingElement.create( "a1", 'Q' ) ) );
        
        assertThat( whiteCastling.getLocations().contains( "a1" ) ).as( "location should be contained" ).isTrue();
        assertThat( whiteCastling.getLocations().contains( "h1" ) ).as( "location should be contained" ).isFalse();
    }
    
    @Test
    @DisplayName("getLocations(): creating white castling only for h1")
    public void getLocations_CreatingWhiteCastlingForH1() {
        
        Castling whiteCastling = Castling.create( Arrays.asList( CastlingElement.create( "h1", 'K' ) ) );
        
        assertThat( whiteCastling.getLocations().contains( "a1" ) ).as( "location should be contained" ).isFalse();
        assertThat( whiteCastling.getLocations().contains( "h1" ) ).as( "location should be contained" ).isTrue();
    }
    
    // -----
    
    @Test
    @DisplayName("getLocations(): creating black initial castling explicitely")
    public void getLocations_CreatingForBlackExplicitely() {
        
        Castling blackCastling = Castling.create( Arrays.asList( CastlingElement.create( "h8", 'k' ), CastlingElement.create( "a8", 'q' ) ) );
        
        assertThat( blackCastling.getLocations().contains( "a8" ) ).as( "location should be contained" ).isTrue();
        assertThat( blackCastling.getLocations().contains( "h8" ) ).as( "location should be contained" ).isTrue();
    }
    
    @Test
    @DisplayName("getLocations(): creating black initial castling explicitely but unexpected order")
    public void getLocations_CreatingForBlackExplicitelyButUnexpectedOrder() {
        
        Castling blackCastling = Castling.create( Arrays.asList( CastlingElement.create( "a8", 'q' ), CastlingElement.create( "h8", 'k' ) ) );
        
        assertThat( blackCastling.getLocations().contains( "a8" ) ).as( "location should be contained" ).isTrue();
        assertThat( blackCastling.getLocations().contains( "h8" ) ).as( "location should be contained" ).isTrue();
    }
    
    @Test
    @DisplayName("getLocations(): creating black initial castling")
    public void getLocations_CreatingForBlack() {
        
        Castling blackCastling = Castling.createBlackCastling();
        
        assertThat( blackCastling.getLocations().contains( "a8" ) ).as( "location should be contained" ).isTrue();
        assertThat( blackCastling.getLocations().contains( "h8" ) ).as( "location should be contained" ).isTrue();
    }
    
    @Test
    @DisplayName("getLocations(): creating black castling only for a8")
    public void getLocations_CreatingBlackCastlingForA1() {
        
        Castling blackCastling = Castling.create( Arrays.asList( CastlingElement.create( "a8", 'q' ) ) );
        
        assertThat( blackCastling.getLocations().contains( "a8" ) ).as( "location should be contained" ).isTrue();
        assertThat( blackCastling.getLocations().contains( "h8" ) ).as( "location should be contained" ).isFalse();
    }
    
    @Test
    @DisplayName("getLocations(): creating black castling only for h8")
    public void getLocations_CreatingBlackCastlingForH1() {
        
        Castling blackCastling = Castling.create( Arrays.asList( CastlingElement.create( "h8", 'k' ) ) );
        
        assertThat( blackCastling.getLocations().contains( "a8" ) ).as( "location should be contained" ).isFalse();
        assertThat( blackCastling.getLocations().contains( "h8" ) ).as( "location should be contained" ).isTrue();
    }
}


