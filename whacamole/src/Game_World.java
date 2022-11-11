import java.util.Random;

public class Game_World extends A_World {
	boolean menu = true;
	Game_Start pb;
	Game_Name wm;

	Game_GameOver go;
	protected int score = 0;
	protected int life =3;

	private int count = -1;


	@Override
	protected void init() {

		// add text objects		
		pb = new Game_Start(480, 200);
		textObjects.add(pb);
		wm = new Game_Name(15, 20);
		textObjects.add(wm);



		Game_Lives l1 = new Game_Lives(700, 10);
		textObjects.add(l1);

		m0 = new Game_Mole(80, 160);
		m1 = new Game_Mole(80, 310);
		m2 = new Game_Mole(80, 460);
		m3 = new Game_Mole(290, 160);
		m4 = new Game_Mole(290, 310);
		m5 = new Game_Mole(290, 460);
		m6 = new Game_Mole(500, 160);
		m7 = new Game_Mole(500, 310);
		m8 = new Game_Mole(500, 460);

		b0 = new Game_Bomb(100, 160);
		b1 = new Game_Bomb(100, 310);
		b2 = new Game_Bomb(100, 460);
		b3 = new Game_Bomb(310, 160);
		b4 = new Game_Bomb(310, 310);
		b5 = new Game_Bomb(310, 460);
		b6 = new Game_Bomb(520, 160);
		b7 = new Game_Bomb(520, 310);
		b8 = new Game_Bomb(520, 460);




		/*gameObjects.add(b0);
		gameObjects.add(b1);
		gameObjects.add(b2);
		gameObjects.add(b3);
		gameObjects.add(b4);
		gameObjects.add(b5);
		gameObjects.add(b6);
		gameObjects.add(b7);
		gameObjects.add(b8);*/



	}

	@Override
	protected void processUserInput(A_UserInput userInput, double diffSeconds) {
		char key = 0;
		if (userInput.isKeyEvent) {
			key = userInput.keyPressed;
		}
		if (menu) {
			if (userInput.isMouseEvent && userInput.isMousePressed) {
				int x = userInput.mouseMovedX;
				int y = userInput.mouseMovedY;
				// mouse located over play 
				if (x >= pb.x && x <= pb.x + pb.width && y <= pb.y + pb.height && y >= pb.y) {
					menu = false;
					if (gameOver) {
						gameOver = false;
						score = 0;
						life = 3;
					}
				}
				userInput.mouseButton = 0;
			}
		} else {
			if (userInput.isMouseEvent && userInput.isMousePressed) {
				int x = userInput.mouseMovedX;
				int y = userInput.mouseMovedY;
				// mole 0
				if (x >= m0.x && x <= m0.x + 150 && y <= m0.y + 113 && y >= m0.y) {
					if (m0.isLiving)
						score += 1;
					m0.isLiving = false;
				}
				// mole 1
				else if (x >= m1.x && x <= m1.x + 150 && y <= m1.y + 113 && y >= m1.y) {
					if (m1.isLiving)
						score += 1;
					m1.isLiving = false;
				}
				// mole 2
				else if (x >= m2.x && x <= m2.x + 150 && y <= m2.y + 113 && y >= m2.y) {
					if (m2.isLiving)
						score += 1;
					m2.isLiving = false;

				}
				// mole 3
				else if (x >= m3.x && x <= m3.x + 150 && y <= m3.y + 113 && y >= m3.y) {
					if (m3.isLiving)
						score += 1;
					m3.isLiving = false;
				}
				// mole 4
				else if (x >= m4.x && x <= m4.x + 150 && y <= m4.y + 113 && y >= m4.y) {
					if (m4.isLiving)
						score += 1;
					m4.isLiving = false;

				}
				// mole 5
				else if (x >= m5.x && x <= m5.x + 150 && y <= m5.y + 113 && y >= m5.y) {
					if (m5.isLiving)
						score += 1;
					m5.isLiving = false;
				}
				// mole 6
				else if (x >= m6.x && x <= m6.x + 150 && y <= m6.y + 113 && y >= m6.y) {
					if (m6.isLiving)
						score += 1;
					m6.isLiving = false;
				}
				// mole 7
				else if (x >= m7.x && x <= m7.x + 150 && y <= m7.y + 113 && y >= m7.y) {
					if (m7.isLiving)
						score += 1;
					m7.isLiving = false;
				}
				// mole 8
				else if (x >= m8.x && x <= m8.x + 150 && y <= m8.y + 113 && y >= m8.y) {
					if (m8.isLiving)
						score += 1;
					m8.isLiving = false;
				}
				//  supposed to be bomb 01234567, BUG!!!!!!!!! unable to detect mouse event on bomb
				else if (x >= b0.x && x <= b0.x + 100 && y <= b0.y + 102 && y >= b0.y) {
					if (b0.isLiving && life >=3){
						life--;
					} else if (life == 0) {
						gameOver = true;
					}

					b0.isLiving = false;
				}


			}

			if (key == (char) 27) System.exit(0);
		}
	}

	@Override
	protected void createNewObjects(double diffSeconds) {

		if (!gameOver) {

			int size = gameObjects.size();
			count = 0;
			int i = 25;

			//for (int i = 1; i < size; i++) {
				//if (gameObjects.get(i).type() == A_Const.TYPE_MOLE && gameObjects.get(i).isLiving) {
				//	count++;
			// faster as score increases
			if(score >= 5){
				i += 40;
			} else if (score>= 10) {
				i+= 70;
			} else if (score >= 20) {
				i+= 100;
			} else if (score >= 30) {
				i+= 150;
			} else if (score >= 50){
				i+=200;
			}
			// randomly generate mole or bomb
			Random ra = new Random();
				if(ra.nextInt(2000)<i){

					int n;
					Random r = new Random();
					n = r.nextInt(18);

					switch (n){
						case 0:
							gameObjects.add(m0);
							b0.isLiving = false;
							m0.isLiving = true;
							break;
						case 1:
							gameObjects.add(m1);
							b1.isLiving = false;
							m1.isLiving = true;
							break;
						case 2:
							gameObjects.add(m2);
							b2.isLiving = false;
							m2.isLiving = true;
							break;
						case 3:
							gameObjects.add(m3);
							b3.isLiving = false;
							m3.isLiving = true;
							break;
						case 4:
							gameObjects.add(m4);
							b4.isLiving = false;
							m4.isLiving = true;
							break;
						case 5:
							gameObjects.add(m5);
							b5.isLiving = false;
							m5.isLiving = true;
							break;
						case 6:
							gameObjects.add(m6);
							b6.isLiving = false;
							m6.isLiving = true;
							break;
						case 7:
							gameObjects.add(m7);
							b7.isLiving = false;
							m7.isLiving = true;

							break;
						case 8:
							gameObjects.add(m8);
							b8.isLiving = false;
							m8.isLiving = true;
							break;
						case 9:
							gameObjects.add(b0);
							m0.isLiving = false;
							b0.isLiving = true;
							break;
						case 10:
							gameObjects.add(b1);
							m1.isLiving = false;
							b1.isLiving = true;
							break;
						case 11:
							gameObjects.add(b2);
							m2.isLiving = false;
							b2.isLiving = true;
							break;
						case 12:
							gameObjects.add(b3);
							m3.isLiving = false;
							b3.isLiving = true;
							break;
						case 13:
							gameObjects.add(b4);
							m4.isLiving = false;
							b4.isLiving = true;
							break;
						case 14:
							gameObjects.add(b5);
							m5.isLiving = false;
							b5.isLiving = true;
							break;
						case 15:
							gameObjects.add(b6);
							m6.isLiving = false;
							b6.isLiving = true;

							break;
						case 16:
							gameObjects.add(b7);
							m7.isLiving = false;
							b7.isLiving = true;
							break;
						case 17:
							gameObjects.add(b8);
							m8.isLiving = false;
							b8.isLiving = true;
							break;
						default:
							break;
					}

				}



				//}
			//}
		}

	}
}


