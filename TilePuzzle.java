import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TilePuzzle extends JFrame implements ActionListener {

    private TilePiece[] tiles;
    private TilePiece blankTile;

    public TilePuzzle() {
        // Initialize the JFrame
        super("Tile Puzzle");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 4));

        // Create an array of TilePieces
        tiles = new TilePiece[12];

        // Create and set the blankTile
        blankTile = new TilePiece("blank_tile.jpg", 0, 0);
        add(blankTile);

        // Create and add other TilePieces to the panel
        for (int i = 1; i <= 11; i++) {
            int x = (i - 1) % 4 + 1;
            int y = (i - 1) / 4 + 1;
            tiles[i] = new TilePiece("tile_" + i + ".jpg", x, y);
            add(tiles[i]);
            tiles[i].addActionListener(this);
        }

        // Set the JFrame size
        setSize(475, 400);
    }

    public void actionPerformed(ActionEvent e) {
        TilePiece clickedTile = (TilePiece) e.getSource();

        if (clickedTile.isAdjacentTo(blankTile)) {
            // Swap images between clickedTile and blankTile
            clickedTile.exchangeImageWith(blankTile);
        }
    }

    public static void main(String[] args) {
        // Create an instance of TilePuzzle and make it visible
        SwingUtilities.invokeLater(() -> {
            TilePuzzle tilePuzzle = new TilePuzzle();
            tilePuzzle.setVisible(true);
        });
    }
}
