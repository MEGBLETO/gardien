package gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

import config.GameConfiguration;
import engine.map.Block;
import engine.map.Map;
import engine.process.GameBuilder;
import engine.process.MobileElementManager;
import engine.Time;

public class MainGUI extends JFrame implements Runnable {
	/*TIMER*/
	private static int minute=0,seconde=0;
	ActionListener tache_timer;
	/******/
	private static final long serialVersionUID = 1L;

	private Map map;

	private final static Dimension preferredSize = new Dimension(GameConfiguration.WINDOW_WIDTH, GameConfiguration.WINDOW_HEIGHT);

	private MobileElementManager manager;

	private GameDisplay dashboard;

	public Boolean cont;

	public MainGUI(String title, String controls) {
		super(title);
		init(controls);

		if (controls == "direction"){
			cont = true;
		}
		else if(controls == "alpha"){
			cont = false;
		}

		else{
			cont = true;
		}

	}



	private void init(String controls) {

		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());

		KeyControls keyControls = new KeyControls();
		controls(controls);

		JTextField textField = new JTextField();
		textField.addKeyListener(keyControls);
		contentPane.add(textField, BorderLayout.SOUTH);

		/*Test Timer*/
		JTextArea Panel1 = new JTextArea();
		Panel1.setEditable(false);
		tache_timer= new ActionListener()
		{
			public void actionPerformed(ActionEvent e1)
			{
				seconde++;
				if(seconde==60)
				{
					seconde=0;
					minute++;
				}
				Panel1.setText("Timer : "+minute+":"+seconde);
				Font font = new Font("Arial", Font.BOLD, 20);
				Panel1.setFont(font);
				Panel1.setForeground(Color.BLACK);
			}
		};
		final Timer timer1= new Timer(1000,tache_timer);
		timer1.start();
		contentPane.add(Panel1, BorderLayout.NORTH);
	//*********************//

		map = GameBuilder.buildMap();
		manager = GameBuilder.buildInitMobile(map);
		dashboard = new GameDisplay(map, manager);

		dashboard.setPreferredSize(preferredSize);
		contentPane.add(dashboard, BorderLayout.CENTER);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setVisible(true);
		setPreferredSize(preferredSize);
		setResizable(false);
		setLocationRelativeTo(null);

	}

	public String controls(String controls) {
		return controls;
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(GameConfiguration.GAME_SPEED);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}

			manager.nextRound();
			dashboard.repaint();
		}
	}

	private class KeyControls implements KeyListener  {




		@Override
		public void keyPressed(KeyEvent event) {



			if(cont == true) {
				char keyChar = event.getKeyChar();

				switch (keyChar) {

					case 'q':
						manager.moveLeftPlayer();
						break;
					case 'd':
						manager.moveRightPlayer();
						break;
					case 'z':
						manager.moveUpPlayer();
						break;
					case 's':
						manager.moveDownPlayer();
						break;
					default:
						break;
				}
			}


			else if ( cont == false){
				int keyCode = event.getKeyCode();

				switch (keyCode) {

					case  37:
						manager.moveLeftPlayer();
						break;
					case 39:
						manager.moveRightPlayer();
						break;
					case 38:
						manager.moveUpPlayer();
						break;
					case 40:
						manager.moveDownPlayer();
						break;
					default:
						break;
				}

			}

			else if(cont == null){
				char keyChar = event.getKeyChar();

				switch (keyChar) {

					case 'q':
						manager.moveLeftPlayer();
						break;
					case 'd':
						manager.moveRightPlayer();
						break;
					case 'z':
						manager.moveUpPlayer();
						break;
					case 's':
						manager.moveDownPlayer();
						break;
					default:
						break;
				}
			}

		}

		@Override
		public void keyTyped(KeyEvent e) {

		}

		@Override
		public void keyReleased(KeyEvent e) {

		}
	}

}
