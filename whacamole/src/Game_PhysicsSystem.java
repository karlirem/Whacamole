import java.awt.*;

public class Game_PhysicsSystem extends A_PhysicsSystem
{

	Game_PhysicsSystem(A_World w)
	{ super(w);
	}


	//
	// collisions (we consider only bullets with avatar/alien)
	//
	public A_GameObjectList getCollisions(A_GameObject object)
	{
		A_GameObjectList result = new A_GameObjectList();

		int len = world.gameObjects.size();


		return result;
	}


}