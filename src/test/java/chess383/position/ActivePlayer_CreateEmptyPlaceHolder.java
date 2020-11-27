/*
 *  ActivePlayer_CreateEmptyPlaceholder.java
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
 * The class ActivePlayer_CreateEmptyPlaceholder implements an upper tester
 * </p>
 *
 * @author    Jörg Dippel
 * @version   November 2020
 *
 */
@DisplayName("the public static method ActivePlayer createEmptyPlaceholder( ) for class ActivePlayer is tested")
public class ActivePlayer_CreateEmptyPlaceHolder {  
    
    @Test
    @DisplayName("createEmptyPlaceholder(): create an instance of ActivePlayer that is not null but is a placeholder for that")
    public void createEmptyPlaceholder_CreatingEmptyButNotNull() {
        
    	ActivePlayer instance = ActivePlayer.createEmptyPlaceholder();
        
        assertThat( instance ).as( "a placeholder for null must be possible" ).isNotNull();
    }
    
    @Test
    @DisplayName("createEmptyPlaceholder(): create an instance of ActivePlayer as a placeholder and verify that")
    public void createEmptyPlaceholder_CreatingEmpty() {
        
    	ActivePlayer instance = ActivePlayer.createEmptyPlaceholder();
        
        assertThat( true ).as( "a placeholder for null must be possible" ).isEqualTo( instance.isEmptyPlaceholder() );
    }
}


