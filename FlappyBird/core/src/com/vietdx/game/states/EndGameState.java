package com.vietdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.vietdx.game.FlappyBird;

public class EndGameState extends State{

    private final Texture bg;
    private final Texture playBtn;
    private final BitmapFont Font;
    private int score;

    protected EndGameState(GameStateManager gsm, int score)
    {
        super(gsm);
        this.score = score;
        bg = new Texture("background.jpg");
        playBtn = new Texture("playbtn.png");
        cam.setToOrtho(false, FlappyBird.WIDTH / 2, FlappyBird.HEIGHT / 2);
        Font = new BitmapFont();
        Font.setUseIntegerPositions(false);
        Font.setColor(Color.BLACK);
    }

    @Override
    protected void handleInput() {
        if(Gdx.input.justTouched()){
            gsm.set(new PlayState(gsm));
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();

        sb.draw(bg, 0, 0);
        sb.draw(playBtn, cam.position.x - playBtn.getWidth() / 2, cam.position.y - 35);

        Font.draw(sb, "Score: " + String.valueOf(score), cam.position.x - 30, cam.position.y + 50);

        sb.end();
    }

    @Override
    public void dispose() {
        bg.dispose();
        playBtn.dispose();
    }
}
