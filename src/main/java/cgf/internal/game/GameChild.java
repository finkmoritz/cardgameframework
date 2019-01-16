package cgf.internal.game;

import cgf.game.Game;

public interface GameChild {

	public void setParentGame(Game parentGame);
	public Game getParentGame();
}
