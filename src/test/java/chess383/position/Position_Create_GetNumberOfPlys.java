/*
 *  Position_Create_GetNumberOfPlys.java
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

/**
 * <p>
 * The class Position_Create_GetNumberOfPlys implements an upper tester for the standard Forsyth-Edwards-Notation
 * </p>
 *
 * @author    Jörg Dippel
 * @version   September 2020
 *
 */
@DisplayName("the public static method Position create( ) for class Position is tested for initial positions and the value of the counter for number of plys")
public class Position_Create_GetNumberOfPlys {  
    
    @Test
    @DisplayName("create(): for an initial position the number of plys are fixed")
    public void create_GetNumberOfPlys_ForFEN() {
        
        Position position = Position.create( "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1" );
        
        assertThat( 0 ).as( "for an initial position the number of plys are fixed" ).isEqualTo( position.getNumberOfPlys() );
    }
    
    @Test
    @DisplayName("create(): for an initial position the number of plys are fixed")
    public void create_GetNumberOfPlys_ForMothodWithouPartameters() {
        
        Position position = Position.create();
        
        assertThat( 0 ).as( "for an initial position the number of plys are fixed" ).isEqualTo( position.getNumberOfPlys() );
    }
}


