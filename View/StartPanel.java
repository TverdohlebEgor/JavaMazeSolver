package MazeSolver;
import javax.swing.JButton;
import javax.swing.JFrame;

class StartPanel{
	final int size_x;
	final int size_y;
	final JFrame frame;
	StartPanel(MazeSolverController listener){
		this.size_x = 200;
		this.size_y = 100;
		this.frame = new JFrame();

		this.create_panel(listener);
		this.set_visibility(true);
	}

	protected void create_panel(MazeSolverController listener){
		this.frame.setTitle("Start Solving");
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.setSize(this.size_x,this.size_y);	
		JButton button = new JButton("Solve maze");
		button.addActionListener(listener);
		button.setActionCommand("Start");
		this.frame.add(button);

	}

	protected void set_visibility(boolean new_vis){
		this.frame.setVisible(new_vis);
	}

}
