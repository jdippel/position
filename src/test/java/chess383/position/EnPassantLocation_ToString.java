/*
 *  EnPassantLocation_ToString.java
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

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * <p>
 * The class EnPassantLocation_ToString implements an upper tester
 * </p>
 *
 * @author    Jörg Dippel
 * @version   September 2020
 *
 */
@DisplayName("the public method String toString( ) for class EnPassantLocation is tested")
public class EnPassantLocation_ToString {  
    
    @Test
    @DisplayName("toString(): gets the description of an instance of EnPassantLocation")
    public void toStringOfAnInstance() {
        
    	EnPassantLocation location = EnPassantLocation.create( "e3" );
        
        assertThat( location.toString() ).as( "description must match the attribute value" ).isEqualTo( "e3" );
    }
    
    @Test
    @DisplayName("toString(): gets the description of an empty instance of EnPassantLocation")
    public void toStringOfAnEmptyInstance() {
        
    	EnPassantLocation location = EnPassantLocation.create( null );
        
        assertThat( location.toString() ).as( "description must match the attribute value" ).isEqualTo( "-" );
    }
   
}


