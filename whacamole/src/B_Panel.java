import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

class B_Panel extends JPanel implements A_GraphicSystem
{
	// constants
	private static final long serialVersionUID = 1L;


	// InputSystem is an external instance
	private B_InputSystem inputSystem = new B_InputSystem();
	private A_World       world       = null;
	private BufferedImage image = null;

	// GraphicsSystem variables
	//
	private GraphicsConfiguration graphicsConf = 
			GraphicsEnvironment.getLocalGraphicsEnvironment().
			getDefaultScreenDevice().getDefaultConfiguration();
	private BufferedImage imageBuffer;
	private Graphics      graphics;



	public B_Panel()
	{ 
		this.setSize(A_Const.WORLD_WIDTH,A_Const.WORLD_HEIGHT);  
		imageBuffer = graphicsConf.createCompatibleImage(
				this.getWidth(), this.getHeight());	 
		graphics = imageBuffer.getGraphics();

		// initialize Listeners
		this.addMouseListener(inputSystem);
		this.addMouseMotionListener(inputSystem);
		this.addKeyListener(inputSystem);

	}

	public void clear() {
		if(((Game_World) world).menu && !world.gameOver) {
			String path = Paths.get("resource/menubackground.png").toAbsolutePath().toString();
			try {
				image = ImageIO.read(new File(path));
			} catch (IOException e) {
				e.printStackTrace();
			}
			graphics.drawImage(image, 0,0,null);
		}else if ( !world.gameOver) {
			String path = Paths.get("resource/background.png").toAbsolutePath().toString();
			try {
				image = ImageIO.read(new File(path));
			} catch (IOException e) {
				e.printStackTrace();
			}
			graphics.drawImage(image, 0,0,null);
			graphics.setColor(Color.black);
			graphics.setFont( new Font( "Arial", Font.BOLD, 24));
			graphics.drawString("Score: " + 
					Integer.toString(((Game_World) world).score), 10, 22);

		}else {
			graphics.setColor(Color.black);
			graphics.fillRect(
					0, 0,A_Const.WORLD_WIDTH,A_Const.WORLD_HEIGHT);
			graphics.setColor(Color.white);
			graphics.setFont( new Font( "Arial", Font.BOLD, 24));
			graphics.drawString("Score: " + 
					Integer.toString(((Game_World) world).score), 5, 5);
		}
	}


	public final void draw(A_GameObject obj)
	{	  
		if(!((Game_World) world).menu) {
			if( obj.type() == A_Const.TYPE_MOLE ) {
				int x = (int)(obj.x- obj.radius);
				int y = (int)(obj.y- obj.radius);

				String path = Paths.get("resource/mole4.png").toAbsolutePath().toString();
				try {
					image = ImageIO.read(new File(path));
				} catch (IOException e) {
					e.printStackTrace();
				}
				graphics.drawImage(image, x,y,null);
			}else if( obj.type() == A_Const.TYPE_BOMB ) {
				int x = (int)(obj.x-obj.radius);
				int y = (int)(obj.y-obj.radius);

				String path = Paths.get("resource/bombahh.png").toAbsolutePath().toString();
				//String path = Paths.get("resource/mole4.png").toAbsolutePath().toString();
				try {
					image = ImageIO.read(new File(path));
				} catch (IOException e) {
					e.printStackTrace();
				}
				graphics.drawImage(image, x,y,null);
			}else if( obj.type() == A_Const.TYPE_HAMMER) {
				int x = (int)(obj.x-obj.radius);
				int y = (int)(obj.y-obj.radius);
				String path = Paths.get("resource/hammer.png").toAbsolutePath().toString();
				try {
					image = ImageIO.read(new File(path));
				} catch (IOException e) {
					e.printStackTrace();
				}
				graphics.drawImage(image, x,y,null);
			}

		}
	}



	public final void draw(A_TextObject text)
	{	  
		if( text.type() == A_Const.TYPE_LIVES && !world.gameOver && !((Game_World) world).menu) {
			if (((Game_World) world).life >= 1) {
				int x = (int) (text.x);
				int y = (int) (text.y);
				String path = Paths.get("resource/life.png").toAbsolutePath().toString();
				try {
					image = ImageIO.read(new File(path));
				} catch (IOException e) {
					e.printStackTrace();
				}
				graphics.drawImage(image, x, y, null);

				if (((Game_World) world).life >= 2) {
					graphics.drawImage(image, x + 30, y, null);
					if (((Game_World) world).life >= 3) {
						graphics.drawImage(image, x + 60, y, null);
					}
				}
			}
		}else if( text.type() == A_Const.TYPE_START &&((Game_World) world).menu) {
			String path = Paths.get("resource/start1.png").toAbsolutePath().toString();;

			try {
				image = ImageIO.read(new File(path));
			} catch (IOException e) {
				e.printStackTrace();
			}
			graphics.drawImage(image, text.x, text.y,null);
		}else if( text.type() == A_Const.TYPE_NAME &&((Game_World) world).menu) {
			String path = Paths.get("resource/arcade.png").toAbsolutePath().toString();;

			try {
				image = ImageIO.read(new File(path));
			} catch (IOException e) {
				e.printStackTrace();
			}
			graphics.drawImage(image, text.x, text.y,null);
		}else if ( text.type() == A_Const.TYPE_GAMEOVER && world.gameOver) {
			String path = Paths.get("resource/mole.png").toAbsolutePath().toString();
			try {
				image = ImageIO.read(new File(path));
			} catch (IOException e) {
				e.printStackTrace();
			}
			graphics.drawImage(image, text.x, text.y,null);

		}
	}


	public void redraw()
	{ this.getGraphics().drawImage(imageBuffer, 0, 0, this);
	}

	public final A_InputSystem getInputSystem() { return inputSystem; }
	public final void setWorld(A_World world_)  {this.world = world_;}
}

