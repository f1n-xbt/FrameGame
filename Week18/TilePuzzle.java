import java.awt.*;
import javax.swing.*;

public class TilePuzzle
{
    
    private TilePiece tiles[] = new TilePiece[12];
    private TilePiece blankTile = new TilePiece("blank_tile.jpg", 0, 0);
    

        
    

    public TilePuzzle()
    {
        tiles[1] = blankTile;
        for (int i = 2; i < 13; i++) {
            tiles[i] = new TilePiece("tile_", i, i);
        }
        JFrame f = new JFrame("InfoLab Lights");
        f.setSize(800, 600);
        f.setVisible(true);
    }

}