/*
 *  Position.java
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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import chess383.ColorEnum;
import chess383.ICoordinate;
import chess383.ICoordinateFactory;
import chess383.exception.Chess383Exception;
import chess383.graph.adjacency.AdjacencyEnum;
import chess383.graph.direction.Direction;
import chess383.piece.abstraction.Piece;
import chess383.piece.concretion.king.InitialKing;
import chess383.piece.traversing.Traversing;
import chess383.player.Player;

/**
 * Provides a chess position.
 *
 * @author    Jörg Dippel
 * @version   November 2020
 *
 */
public class Position {
    
    static ICoordinate board = ICoordinateFactory.STANDARD.get();
    
    /** ---------  Attributes  -------------------------------- */
    
    private Correlation first;
    private Correlation second;
    private ActivePlayer activePlayer;
    private EnPassantLocation enPassantLocation;
    private int numberOfPlys;
    private int numberOfMoves;
    
    /** ---------  Getter and Setter  ------------------------- */

    private void setFirst( Correlation value )          { this.first = value; }
    public  Correlation getFirst()                      { return this.first; }
    private void setSecond( Correlation value )         { this.second = value; }
    public  Correlation getSecond()                     { return this.second; }
    private void setActivePlayer( ActivePlayer player ) { this.activePlayer = player; }
    public  ActivePlayer getActivePlayer()              { return this.activePlayer; }
    private void setEnPassantLocation( EnPassantLocation location ) { this.enPassantLocation = location; } 
    public  EnPassantLocation getEnPassantLocation()    { return this.enPassantLocation; }
    private void setNumberOfPlys( int value )           { this.numberOfPlys = value; }
    public  int getNumberOfPlys()                       { return this.numberOfPlys; }
    private void setNumberOfMoves( int value )          { this.numberOfMoves = value; }
    public  int getNumberOfMoves()                      { return this.numberOfMoves; }

    /** ---------  Constructors  ------------------------------ */
    
    private Position( ) { }
 
    /** ---------  Factory  ----------------------------------- */
    
    public static Position create( ) {
        
        return new Position().initialize();
    }
    
    public static Position create( Correlation first, Correlation second, ColorEnum activePlayer, String enPasssantLocation, int numberOfPlys, int numberOfMoves ) {
        
        Position position = new Position();
        position.initialize( first, second, activePlayer, enPasssantLocation, numberOfPlys, numberOfMoves );
        return position;
    }
    
    public static Position createEmptyPlaceholder( ) {
        
        Position position = new Position();
        position.initialize( null, null, ColorEnum.NONE, null, 0, 0 );
        return position;
    }
    
    public static Position create( String description ) {
        
        List<Piece> whitePlayerPieces = Traversing.create( description ).getPieceCollection( (ch) -> Character.isUpperCase(ch) );
        List<Piece> blackPlayerPieces = Traversing.create( description ).getPieceCollection( (ch) -> Character.isLowerCase(ch) );
        
        String tailDescription = "";
        int cursor = 0;
        ColorEnum colorToMove;
        Castling whiteCastling;
        Castling blackCastling;
        String enPasssantLocation;
        int numberOfPlys;
        int numberOfMoves;
        try {
            while( ! Character.isWhitespace( description.charAt( cursor )) ) cursor++;       // ignore pieces, they were processed by traversePieces()
            while( Character.isWhitespace( description.charAt( cursor )) ) cursor++;
            tailDescription = description.substring( cursor );
            colorToMove = ( description.charAt( cursor ) == 'w' ) ? ColorEnum.WHITE : ColorEnum.BLACK;
            cursor++;
            
            // For traversing pieces the king is always an already moved king. If castling is still possible,
            // the king type will be rechanged to initial king type.
            while( Character.isWhitespace( description.charAt( cursor )) ) cursor++;
            tailDescription = description.substring( cursor );
            if( description.charAt( cursor ) == '-' ) {
                // no more castling possible
                whiteCastling = Castling.createEmpty();
                blackCastling = Castling.createEmpty();
                cursor++;
            }
            else {
                int length = determineLength( tailDescription );
                whiteCastling = scanCastling( tailDescription.substring( 0, length ), Castling.createWhiteCastling() );
                if( ! whiteCastling.isEmpty() ) {
                    whitePlayerPieces = migrateKingToCastlingKing( whitePlayerPieces );
                }
                blackCastling = scanCastling( tailDescription.substring( 0, length ), Castling.createBlackCastling() );
                if( ! blackCastling.isEmpty() ) {
                    blackPlayerPieces = migrateKingToCastlingKing( blackPlayerPieces );
                }
                cursor += length;
            }
            
            while( Character.isWhitespace( description.charAt( cursor )) ) cursor++;
            tailDescription = description.substring( cursor );
            int start = cursor;
            while( ! Character.isWhitespace( description.charAt( cursor )) ) {
                cursor++;
            }
            enPasssantLocation = description.substring( start, cursor );
            
            while( Character.isWhitespace( description.charAt( cursor )) ) cursor++;
            tailDescription = description.substring( cursor );
            start = cursor;
            while( Character.isDigit( description.charAt( cursor )) ) cursor++;
            numberOfPlys = Integer.parseInt( description.substring( start, cursor )); 
            
            while( Character.isWhitespace( description.charAt( cursor )) ) cursor++;
            start = cursor;
            while( cursor < description.length() && Character.isDigit( description.charAt( cursor )) ) {
                cursor++;
            }
            numberOfMoves = Integer.parseInt( description.substring( start, cursor ));  
        }
        catch( IndexOutOfBoundsException ioobe ) {
            
            throw new Chess383Exception( String.format( "For input \"%s\" the index %d is called - substring %s", description, cursor, tailDescription ));
        }

        return create(
                Correlation.create( Player.create( ColorEnum.WHITE, whitePlayerPieces ), whiteCastling ),
                Correlation.create( Player.create( ColorEnum.BLACK, blackPlayerPieces ), blackCastling ),
                colorToMove, enPasssantLocation, numberOfPlys, numberOfMoves );
    }
    
    /** ------------------------------------------------------- */
    
     public Position clone() {
        
        Position position = new Position();
        position.initialize( getFirst().clone(), getSecond().clone(), getActivePlayer().getActive(), getEnPassantLocation().getLocation(), getNumberOfPlys(), getNumberOfMoves() );
        return position;
    }

    public boolean isEmptyPlaceholder() {
    
        return getFirst() == null || getSecond() == null;
    }

    /** ---------  Delegated methods  ------------------------- */
    
    private void setActivePlayer( ) {
    
        setActivePlayer( ActivePlayer.create( getFirst().getColor(), getSecond().getColor() ) );
    }
    
    private void setEnPassantLocation( ) {
        
        setEnPassantLocation( EnPassantLocation.create( null ) );
    }
    
    private Position initialize() {
        
        setFirst( Correlation.create( Player.createWhitePlayer(), Castling.createWhiteCastling() ) );
        setSecond( Correlation.create( Player.createBlackPlayer(), Castling.createBlackCastling() ) );
        setActivePlayer();
        setEnPassantLocation();
        setNumberOfPlys( 0 );
        setNumberOfMoves( 1 );
        return this;
    }
    
    private Position initialize( Correlation first, Correlation second, ColorEnum activePlayer, String enPasssantLocation, int numberOfPlys, int numberOfMoves ) {
        
        setFirst( first );
        setSecond( second );
        
        if( activePlayer != ColorEnum.NONE || first != null || second != null ) {
            if ( activePlayer == first.getPlayer().getColour() ) {
                setActivePlayer( ActivePlayer.create( activePlayer, second.getPlayer().getColour() ) );
            }
            else {
                setActivePlayer( ActivePlayer.create( activePlayer, first.getPlayer().getColour() ) );
                // invalid input for activePlayer is not handled
            }
        }
        else setActivePlayer( ActivePlayer.createEmptyPlaceholder() );
        
        setEnPassantLocation( EnPassantLocation.create( enPasssantLocation ) );
        setNumberOfPlys( numberOfPlys );
        setNumberOfMoves( numberOfMoves );
        
        return this;
    }
 
    public Piece getPiece( String location ) {
        
        Piece piece = getFirst().getPlayer().getPiece( location );
        if( piece != null ) return piece;
        return getSecond().getPlayer().getPiece( location );
    }
    
    public int getNumberOfPieces() {
        
        return getFirst().getPlayer().getNumberOfPieces() + getSecond().getPlayer().getNumberOfPieces();
    }
    
    /** ------------------------------------------------------- */
    
    private static int determineLength( String description ) {
        
        int cursor = 0;
        while( ! Character.isWhitespace( description.charAt( cursor )) ) cursor++; 
        return cursor;
    }
    
    private static Castling scanCastling( String description, Castling optimum ) {
        
        String optimumDescription = optimum.toString();
        for( int cursor = 0; cursor < optimumDescription.length(); cursor++ ) {
            Character optimumAbbreviation = optimumDescription.charAt( cursor );
            if( ( description.indexOf( "" + optimumDescription.charAt( cursor ) ) < 0 ) ) {
                optimum = optimum.remove( optimumAbbreviation );
            }
        }
        
        return optimum;
    }
    
    private static List<Piece> migrateKingToCastlingKing( List<Piece> playerPieces ) {
        
        for( Piece piece : playerPieces ) {
            if( piece.isKing() ) {
                String location = piece.getLocation();
                playerPieces.remove( piece );
                piece = InitialKing.create( location );
                playerPieces.add( piece );
                return playerPieces;
            }
        }       
        return new ArrayList<Piece>( 0 );
    }

    private List<String> getPiecePlacementPerLine( String location, String helperLocation ) {
    
        Set<List<String>> bundle = board.getLineBundles( location, Direction.createBidirectionalDirection(), AdjacencyEnum.BY_EDGE );
        
        if ( bundle.size() == 1 )  {
            Iterator<List<String>> iterator = bundle.iterator();
            return iterator.next();
        }
        else {
            for ( List<String> line : bundle ) {
                if ( line.contains( helperLocation ) ) {
                    return line;
                }
            }
        }
        return new ArrayList<String>( 0 );
    }
    
    private String getPiecePlacementString( List<String> line) {
        
        StringBuilder fenDescriptionOfARankOfPieces = new StringBuilder();
        
        Piece piece;
        Character fenAbbreviation;
        int gapCounter = 0;
        for( String location : line ) {
            
            piece = getFirst().getPlayer().getPiece( location );
            if ( piece != null ) {
                fenAbbreviation = Character.toUpperCase( piece.getForsythEdwardsNotation() );
            }
            else {
                piece = getSecond().getPlayer().getPiece( location );
                if ( piece != null ) {
                    fenAbbreviation = Character.toLowerCase( piece.getForsythEdwardsNotation() );
                }
                else {
                    fenAbbreviation = null;
                }
            }
            
            if ( fenAbbreviation == null ) {
                gapCounter++;
            }
            else {
                if ( gapCounter > 0 ) {
                    fenDescriptionOfARankOfPieces.append( "" + gapCounter );
                    gapCounter = 0;
                }
                fenDescriptionOfARankOfPieces.append( fenAbbreviation );
            }
        }
        if ( gapCounter > 0 ) {
            fenDescriptionOfARankOfPieces.append( "" + gapCounter );
        }

        return fenDescriptionOfARankOfPieces.toString();
    }
    
    private String getDiagramString() {
        
        return getPiecePlacementString( getPiecePlacementPerLine( "a8", "h8" )) + "/"
             + getPiecePlacementString( getPiecePlacementPerLine( "a7", "h7" )) + "/"
             + getPiecePlacementString( getPiecePlacementPerLine( "a6", "h6" )) + "/"
             + getPiecePlacementString( getPiecePlacementPerLine( "a5", "h5" )) + "/"
             + getPiecePlacementString( getPiecePlacementPerLine( "a4", "h4" )) + "/"
             + getPiecePlacementString( getPiecePlacementPerLine( "a3", "h3" )) + "/"
             + getPiecePlacementString( getPiecePlacementPerLine( "a2", "h2" )) + "/"
             + getPiecePlacementString( getPiecePlacementPerLine( "a1", "h1" ));
    }
    
    private String getCastlingString() {
        String castlingString = getFirst().getCastling().toString() + getSecond().getCastling().toString();
        
        if ( castlingString.length() == 0 ) return "-";
        return castlingString;
    }
    
    /** ---------  Inheritance from Object  ------------------- */
    
    @Override
    public String toString() {
    
        String fenDescription;
        
        fenDescription = getDiagramString() + " "
                       + getActivePlayer().toString() + " "
                       + getCastlingString() + " "
                       + getEnPassantLocation().toString() + " "
                       + getNumberOfPlys() + " "
                       + getNumberOfMoves();
                       
        return fenDescription;
    }
}
