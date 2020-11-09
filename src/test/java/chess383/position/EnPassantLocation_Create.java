/*
 *  EnPassantLocation_Create.java
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
 * The class EnPassantLocation_Create implements an upper tester
 * </p>
 *
 * @author    Jörg Dippel
 * @version   September 2020
 *
 */
@DisplayName("the public static method EnPassantLocation create( ) for class EnPassantLocation is tested")
public class EnPassantLocation_Create {  
    
    @Test
    @DisplayName("create(): creates an instance of EnPassantLocation")
    public void create_CreatingInstance() {
        
    	EnPassantLocation location = EnPassantLocation.create( "e3" );
        
        assertThat( location.getLocation() ).as( "getter must match the attribute value" ).isEqualTo( "e3" );
    }
    
    @Test
    @DisplayName("create(): creates and changes an instance of EnPassantLocation")
    public void create_CreatingAndChangingInstance() {
        
    	EnPassantLocation location = EnPassantLocation.create( "e3" );
    	location.setLocation( "d6" );
        
        assertThat( location.getLocation() ).as( "getter must match the attribute value" ).isEqualTo( "d6" );
    }
    
   
}


