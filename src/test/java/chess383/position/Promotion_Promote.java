/*
 *  Promotion_Promote.java
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
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import chess383.exception.Chess383PromotionException;

/**
 * <p>
 * The class Promotion_Promote implements an upper tester
 * </p>
 *
 * @author    Jörg Dippel
 * @version   September 2020
 *
 */
@DisplayName("the public method Position promote( ) for class Promotion is tested")
public class Promotion_Promote {  
    
    @Test
    @DisplayName("promote(): for the game the white promotion is verified.")
    public void promote_PromoteWhitePawnToQueen() {
        
        // Buehrer Viktor - Denscheilmann Antonio, 2008
        // e4 c5 Nf3 Nc6 Bc4 e6 Nc3 g6 b3 Bg7 Bb2 Nf6 Rb1 a6 a4 O-O O-O Re8 Re1 b5 axb5 axb5 Nxb5 d6 e5 dxe5 Nxe5 Nd4 Nxd4 cxd4 Qf3 Qa5 Ra1 Qxd2 Qxa8 Qf4 Qf3 Qd2 Qd3 Qf4 Qxd4 Qf5 
        // Bd3 Qg5 Nf3 Qd5 Qxd5 exd5 Rxe8+ Nxe8 Bxg7 Kxg7 Ra8 Nd6 Rxc8 Nxc8 Bb5 Nd6 Bc6 Nb5 Bxd5 Nc3 Bc6 f5 b4 g5 b5 g4 Ne5 h5 b6 f4 b7 f3 gxf3 gxf3 Nxf3 Ne2+ Kf1 Nd4 b8=Q     Nxc6 Qc7+ Kh6 Qxc6+
        
        final String POSITION_STRING = "1P6/6k1/2B5/7p/3n4/5N2/2P2P1P/5K2 b - - 3 82";
        Position position = Position.create( POSITION_STRING );
        Position positionAfterPromotion = Promotion.create( position ).promote( "b8", 'Q' );
        
        assertThat( positionAfterPromotion.toString() )
                  .as( "the string representation should match" )
                  .isEqualTo( "1Q6/6k1/2B5/7p/3n4/5N2/2P2P1P/5K2 b - - 3 82" );
    }
    
    @Test
    @DisplayName("promote(): a location without piece cannot be used for promotion")
    public void promote_FailsDueToFreeLocation() {
        
        // Buehrer Viktor - Denscheilmann Antonio, 2008
        // e4 c5 Nf3 Nc6 Bc4 e6 Nc3 g6 b3 Bg7 Bb2 Nf6 Rb1 a6 a4 O-O O-O Re8 Re1 b5 axb5 axb5 Nxb5 d6 e5 dxe5 Nxe5 Nd4 Nxd4 cxd4 Qf3 Qa5 Ra1 Qxd2 Qxa8 Qf4 Qf3 Qd2 Qd3 Qf4 Qxd4 Qf5 
        // Bd3 Qg5 Nf3 Qd5 Qxd5 exd5 Rxe8+ Nxe8 Bxg7 Kxg7 Ra8 Nd6 Rxc8 Nxc8 Bb5 Nd6 Bc6 Nb5 Bxd5 Nc3 Bc6 f5 b4 g5 b5 g4 Ne5 h5 b6 f4 b7 f3 gxf3 gxf3 Nxf3 Ne2+ Kf1 Nd4 b8=Q     Nxc6 Qc7+ Kh6 Qxc6+
        
        final String POSITION_STRING = "1P6/6k1/2B5/7p/3n4/5N2/2P2P1P/5K2 b - - 3 82";
        final Position POSITION = Position.create( POSITION_STRING );
        Promotion promotion = Promotion.create( POSITION );
        
        assertThatThrownBy(() -> { promotion.promote( "a8", 'Q' ); })
                  .isExactlyInstanceOf( Chess383PromotionException.class )
                  .hasMessageContaining( "there is no piece located on location" );
    }
    
    @Test
    @DisplayName("promote(): a pawn cannot promote to a pawn")
    public void promote_FailsDueToNewPieceSelectionAsAPawn() {
        
        // Buehrer Viktor - Denscheilmann Antonio, 2008
        // e4 c5 Nf3 Nc6 Bc4 e6 Nc3 g6 b3 Bg7 Bb2 Nf6 Rb1 a6 a4 O-O O-O Re8 Re1 b5 axb5 axb5 Nxb5 d6 e5 dxe5 Nxe5 Nd4 Nxd4 cxd4 Qf3 Qa5 Ra1 Qxd2 Qxa8 Qf4 Qf3 Qd2 Qd3 Qf4 Qxd4 Qf5 
        // Bd3 Qg5 Nf3 Qd5 Qxd5 exd5 Rxe8+ Nxe8 Bxg7 Kxg7 Ra8 Nd6 Rxc8 Nxc8 Bb5 Nd6 Bc6 Nb5 Bxd5 Nc3 Bc6 f5 b4 g5 b5 g4 Ne5 h5 b6 f4 b7 f3 gxf3 gxf3 Nxf3 Ne2+ Kf1 Nd4 b8=Q     Nxc6 Qc7+ Kh6 Qxc6+
        
        final String POSITION_STRING = "1P6/6k1/2B5/7p/3n4/5N2/2P2P1P/5K2 b - - 3 82";
        final Position POSITION = Position.create( POSITION_STRING );
        Promotion promotion = Promotion.create( POSITION );
        
        assertThatThrownBy(() -> { promotion.promote( "b8", 'P' ); })
                  .isExactlyInstanceOf( Chess383PromotionException.class )
                  .hasMessageContaining( "pawn cannot promote to a pawn" );
    }
    
    @Test
    @DisplayName("promote(): a pawn cannot promote to a king")
    public void promote_FailsDueToNewPieceSelectionAsAKing() {
        
        // Buehrer Viktor - Denscheilmann Antonio, 2008
        // e4 c5 Nf3 Nc6 Bc4 e6 Nc3 g6 b3 Bg7 Bb2 Nf6 Rb1 a6 a4 O-O O-O Re8 Re1 b5 axb5 axb5 Nxb5 d6 e5 dxe5 Nxe5 Nd4 Nxd4 cxd4 Qf3 Qa5 Ra1 Qxd2 Qxa8 Qf4 Qf3 Qd2 Qd3 Qf4 Qxd4 Qf5 
        // Bd3 Qg5 Nf3 Qd5 Qxd5 exd5 Rxe8+ Nxe8 Bxg7 Kxg7 Ra8 Nd6 Rxc8 Nxc8 Bb5 Nd6 Bc6 Nb5 Bxd5 Nc3 Bc6 f5 b4 g5 b5 g4 Ne5 h5 b6 f4 b7 f3 gxf3 gxf3 Nxf3 Ne2+ Kf1 Nd4 b8=Q     Nxc6 Qc7+ Kh6 Qxc6+
        
        final String POSITION_STRING = "1P6/6k1/2B5/7p/3n4/5N2/2P2P1P/5K2 b - - 3 82";
        final Position POSITION = Position.create( POSITION_STRING );
        Promotion promotion = Promotion.create( POSITION );
        
        assertThatThrownBy(() -> { promotion.promote( "b8", 'K' ); })
                  .isExactlyInstanceOf( Chess383PromotionException.class )
                  .hasMessageContaining( "pawn cannot promote to a king" );
    }

    @Test
    @DisplayName("promote(): for the game the black promotion is verified.")
    public void promote_PromoteBlackPawnToQueen() {
        
        // Aerni Andreas - Trenkle Friedhelm, 2007
        // d4 g6 e4 Bg7 Nc3 d6 f4 Nd7 Nf3 e6 Be3 Ne7 Qd2 a6 Bd3 b5 O-O Bb7 f5 gxf5 exf5 e5 Bh6 Bf6 Rae1 exd4 Ne4 Be5 Nxe5 dxe5 Bg7 Rg8 Bxe5 Bxe4 Bxe4 Nxe5 Bxa8 f6 
        // Bf3 Qd6 Qh6 c5 Qxh7 Kd8 Qh4 Rg5 Qe4 N7c6 Qd5 Nxf3+ Qxf3 Ne5 Qa8+ Kc7 Rf4 Kb6 Rh4 Ka5 a3 c4 Rh8 d3 b4+ cxb3 cxb3 Qb6+ Kh1 Ng4 h3 Nf2+ Kh2 d2 Rf1 d1=Q
        
        final String POSITION_STRING = "Q6R/8/pq3p2/kp3Pr1/8/PP5P/5nPK/3p1R2 w - - 1 73";
        Position position = Position.create( POSITION_STRING );
        Position positionAfterPromotion = Promotion.create( position ).promote( "d1", 'Q' );
        
        assertThat( "Q6R/8/pq3p2/kp3Pr1/8/PP5P/5nPK/3q1R2 w - - 1 73" )
                  .as( "the string representation should match" )
                  .isEqualTo( positionAfterPromotion.toString());
    }
    
    @Test
    @DisplayName("promote(): a black pawn can only be promoted if it has reached the last rank.")
    public void promote_PromoteBlackPawnThatCannotBePromted() {
        
        // Aerni Andreas - Trenkle Friedhelm, 2007
        // d4 g6 e4 Bg7 Nc3 d6 f4 Nd7 Nf3 e6 Be3 Ne7 Qd2 a6 Bd3 b5 O-O Bb7 f5 gxf5 exf5 e5 Bh6 Bf6 Rae1 exd4 Ne4 Be5 Nxe5 dxe5 Bg7 Rg8 Bxe5 Bxe4 Bxe4 Nxe5 Bxa8 f6 
        // Bf3 Qd6 Qh6 c5 Qxh7 Kd8 Qh4 Rg5 Qe4 N7c6 Qd5 Nxf3+ Qxf3 Ne5 Qa8+ Kc7 Rf4 Kb6 Rh4 Ka5 a3 c4 Rh8 d3 b4+ cxb3 cxb3 Qb6+ Kh1 Ng4 h3 Nf2+ Kh2 d2 Rf1 d1=Q
        
        final String POSITION_STRING = "Q6R/8/pq3p2/kp3Pr1/8/PP5P/5nPK/3Q1R2 b - - 1 73";
        Position position = Position.create( POSITION_STRING );
        Promotion promotion = Promotion.create( position );
        
        assertThatThrownBy(() -> { promotion.promote( "b5", 'R' ); })
                  .isExactlyInstanceOf( Chess383PromotionException.class )
                  .hasMessageContaining( "pawn must be located the way that he cannot move any longer" );
    }
    
    @Test
    @DisplayName("promote(): a black pawnn can only be promoted if it has reached the last rank.")
    public void promote_PromoteWhiteQueenToRook() {
        
        // Buehrer Viktor - Denscheilmann Antonio, 2008
        // e4 c5 Nf3 Nc6 Bc4 e6 Nc3 g6 b3 Bg7 Bb2 Nf6 Rb1 a6 a4 O-O O-O Re8 Re1 b5 axb5 axb5 Nxb5 d6 e5 dxe5 Nxe5 Nd4 Nxd4 cxd4 Qf3 Qa5 Ra1 Qxd2 Qxa8 Qf4
        
        final String POSITION_STRING = "Q1b1r1k1/5pbp/4pnp1/4N3/2Bp1q2/1P6/1BP2PPP/R4RK1 w - - 1 37";
        Position position = Position.create( POSITION_STRING );
        Promotion promotion = Promotion.create( position );
        
        assertThatThrownBy(() -> { promotion.promote( "a8", 'R' ); })
                  .isExactlyInstanceOf( Chess383PromotionException.class )
                  .hasMessageContaining( "only pawns can promote" );
    }    
}


