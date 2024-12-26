package MazeSolver;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

class MainPanel{
	final int size_x;
	final int size_y;
	final int grid_size_x;
	final int grid_size_y;
	final JFrame frame;
	final JPanel panel;

	MainPanel(){
		this.size_x = 1200;
		this.size_y = 800;
		this.grid_size_x = 40;
		this.grid_size_y = 32;
		this.frame = new JFrame();
		this.panel = new JPanel(new GridLayout(this.grid_size_x,this.grid_size_y));
		this.frame.add(panel);

		this.create_panel();
		this.set_visibility(true);
	}

	protected void create_panel(){
		this.frame.setTitle("MazeSolver");
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.setSize(this.size_x,this.size_y);	
	}

	protected void set_visibility(boolean new_vis){
		this.frame.setVisible(new_vis);
	}

	protected MazeButton add_button(int ind_x, int ind_y,GUIMODEL listener){
		MazeButton new_button = new MazeButton(ind_x,ind_y,listener);	
		this.panel.add(new_button.get_jbutton());
		return new_button;
	}


	protected int get_grid_size_x(){
		return this.grid_size_x;
	}
	protected int get_grid_size_y(){
		return this.grid_size_y;
	}
}
