package MazeSolver;
import java.awt.event.ActionListener;

class GUI{
	final int grid_x;
	final int grid_y;

	final MainPanel main_panel;	
	final StartPanel start_panel;
	
	final MazeButton[][] grid;	
	GUI(int grid_x,int grid_y,GUIMODEL listener, MazeSolverController listener2){
		this.grid_x = grid_x;
		this.grid_y = grid_y;
		this.grid = new MazeButton[grid_y][grid_x];

		this.main_panel = new MainPanel(); 
		this.start_panel = new StartPanel(listener2);

		for(int y=0; y < this.grid_y; ++y){
			for(int x=0; x < this.grid_x; ++x){
				this.grid[y][x] = this.main_panel.add_button(x,y,listener);
			}
		}
	}

	protected void change_color_block(int x,int y){
		this.grid[y][x].change_color();
	}

	protected void set_blue(int x,int y){
		this.grid[y][x].set_blue();
	}

	protected void set_white(int x, int y){
		this.grid[y][x].set_white();
	}
}
