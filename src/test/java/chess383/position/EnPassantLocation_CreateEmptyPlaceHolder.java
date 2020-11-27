/*
 *  EnPassantLocation_CreateEmptyPlaceHolder.java
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
 * The class EnPassantLocation_CreateEmptyPlaceHolder implements an upper tester
 * </p>
 *
 * @author    Jörg Dippel
 * @version   November 2020
 *
 */
@DisplayName("the public static method EnPassantLocation createEmptyPlaceholder( ) for class EnPassantLocation is tested")
public class EnPassantLocation_CreateEmptyPlaceHolder {  
    
    @Test
    @DisplayName("createEmptyPlaceholder(): creates a placeholder of EnPassantLocation")
    public void createEmptyPlaceholder_CreatingInstance() {
        
    	EnPassantLocation instance = EnPassantLocation.createEmptyPlaceholder( );
        
        assertThat( instance.getLocation() ).as( "getter must match the attribute value" ).isEqualTo( null );
    }
    
    @Test
    @DisplayName("createEmptyPlaceholder(): creates a placeholder of EnPassantLocation - checked by predicate")
    public void createEmptyPlaceholder_CreatingInstanceAndCheckingItByPredicate() {
        
    	EnPassantLocation instance = EnPassantLocation.createEmptyPlaceholder( );
        
        assertThat( instance.isEmptyPlaceholder() ).as( "predicate must return true" ).isEqualTo( true );
    }
}


