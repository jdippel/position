/*
 *  ActivePlayer_Create.java
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

import chess383.ColorEnum;
import chess383.piece.concretion.pawn.BlackPawn;
import chess383.piece.concretion.pawn.WhitePawn;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * <p>
 * The class ActivePlayer_GetActivePawnForForsythEdwardsNotation implements an upper tester
 * </p>
 *
 * @author    Jörg Dippel
 * @version   November 2022
 *
 */
@DisplayName("the public static method Character getActivePawnForForsythEdwardsNotation() for class ActivePlayer is tested")
public class ActivePlayer_GetActivePawnForForsythEdwardsNotation {
    
    @Test
    @DisplayName("getActivePawnForForsythEdwardsNotation(): get the letter for a white pawn")
    public void getForsythEdwardsNotationForWhitePawn() {
        
    	ActivePlayer player = ActivePlayer.create( ColorEnum.WHITE, ColorEnum.BLACK );
        
        assertThat( player.getActivePawnForForsythEdwardsNotation() )
                .as( "get the letter as the Forsyth-Edwards-Notion of an active pawn" )
                .isEqualTo( WhitePawn.getStaticForsythEdwardsNotation() );
    }

    @Test
    @DisplayName("getActivePawnForForsythEdwardsNotation(): get the letter for a black pawn")
    public void getForsythEdwardsNotationForBlackPawn() {

        ActivePlayer player = ActivePlayer.create( ColorEnum.BLACK, ColorEnum.WHITE );

        assertThat( player.getActivePawnForForsythEdwardsNotation() )
                .as( "get the letter as the Forsyth-Edwards-Notion of an active pawn" )
                .isEqualTo( BlackPawn.getStaticForsythEdwardsNotation() );
    }
}


