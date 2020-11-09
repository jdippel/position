/*
 *  ActivePlayer_ToggleActivity.java
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

import chess383.ColorEnum;

/**
 * <p>
 * The class ActivePlayer_ToggleActivity implements an upper tester
 * </p>
 *
 * @author    Jörg Dippel
 * @version   September 2020
 *
 */
@DisplayName("the public method void toggleActivity( ) for class ActivePlayer is tested")
public class ActivePlayer_ToggleActivity {  
    
    @Test
    @DisplayName("toggleActivity(): toggle activity for an instance of ActivePlayer")
    public void toggleActivity() {
        
    	ActivePlayer toogle = ActivePlayer.create( ColorEnum.WHITE, ColorEnum.BLACK );
    	toogle.toggleActivity();
        
        assertThat( toogle.getActive() ).as( "describes the active player to move with his color" ).isEqualTo( ColorEnum.BLACK );
        assertThat( toogle.getInactive() ).as( "describes the inactive waiting player with his color" ).isEqualTo( ColorEnum.WHITE);
    }
}


