import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class Main {
    public static final int FPS = 30,
                            pixel_width = 4,
                            game_width = 800,
                            game_height = 600,
                            tiles_x = game_width / pixel_width,
                            tiles_y = game_height / pixel_width;

    static Tile[][] map = new Tile[tiles_x][tiles_y];

    public static void update(){
        for(int x=0; x<tiles_x; x++)
        for(int y=tiles_y-2; y>=0; y--){
            if(map[x][y] == Tile.SAND && map[x][y+1] == Tile.BLANK){
                map[x][y+1] = Tile.SAND;
                map[x][y] = Tile.BLANK;
            } else if(map[x][y] == Tile.SAND && map[x-1][y+1] == Tile.BLANK){
                map[x-1][y+1] = Tile.SAND;
                map[x][y] = Tile.BLANK;
            } else if(map[x][y] == Tile.SAND && map[x+1][y+1] == Tile.BLANK){
                map[x+1][y+1] = Tile.SAND;
                map[x][y] = Tile.BLANK;
            }
        }
    }
    public static void main(String[] args) throws IOException {

        for(int x=0; x<tiles_x; x++)
        for(int y=0; y<tiles_y; y++)
            map[x][y] = Tile.BLANK;

        for(int x=0; x<tiles_x; x++)
        for(int y=tiles_y-1; y>tiles_y-40; y--)
            map[x][y] = Tile.DIRT;

        for(int x=0; x<tiles_x; x++)
        for(int y=tiles_y-40; y>tiles_y-80; y--)
            map[x][y] = Tile.SAND;

        BufferedImage image = ImageIO.read(new File("picture/capybara.png"));

        JFrame frame = new JFrame("Deepest Strike");
        JPanel panel = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                for(int x=0; x<tiles_x; x++)
                for(int y=0; y<tiles_y; y++){
                    g.setColor(map[x][y].getColor());
                    g.fillRect(x*pixel_width, y*pixel_width, pixel_width, pixel_width);
                }
            }
        };

        frame.add(panel);

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.scheduleAtFixedRate(() -> {update(); frame.repaint();}, 0, 1000/FPS, TimeUnit.MILLISECONDS);

        // Set frame properties
        frame.setSize(800,
                630); // Set the size of the frame

        // Close operation
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Make the frame visible
        frame.setVisible(true);

    }

}