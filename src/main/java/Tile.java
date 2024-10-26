import java.awt.*;

public interface Tile {

    Tile BLANK = new Tile(){
        @Override
        public Color getColor() {
            return Color.WHITE;
        }
    };

    Tile DIRT = new Tile(){

        @Override
        public Color getColor() {
            return Color.decode("#663300");
        }
    };


    Tile SAND = new Tile(){
        @Override
        public Color getColor() {
            return Color.decode("#FFCC99");
        }
    };


    Color getColor();
}
