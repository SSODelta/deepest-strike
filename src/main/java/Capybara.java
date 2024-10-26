public class Capybara {

    int x, y;

    public Capybara(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void moveLeft(){
        if(x > 0)
            x--;
    }

    public void moveRight(){
        if(x < Main.game_width)
            x--;
    }

}
