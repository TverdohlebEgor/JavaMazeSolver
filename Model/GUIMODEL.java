package MazeSolver;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

class GUIMODEL implements ActionListener{
	final int grid_x;
	final int grid_y;
	final GUI view_gui;
	final boolean[][] wall_grid;

	GUIMODEL(int grid_x, int grid_y, MazeSolverController listener){
		this.grid_x = grid_x;
		this.grid_y = grid_y;
			
		this.view_gui = new GUI(grid_x,grid_y,this,listener);
		this.wall_grid = new boolean[grid_y][grid_x];
	}

	public void actionPerformed(ActionEvent e){
		String[] split= e.getActionCommand().split(" ");
		if(split[0].equals("CLICKED_MAZEBUTTON")){
			int x = Integer.parseInt(split[1]);
			int y = Integer.parseInt(split[2]);
			if((x != 0 && y != 0) || x != this.grid_x-1 && y != this.grid_y-1){
				this.view_gui.change_color_block(x,y);
				this.wall_grid[y][x] = !this.wall_grid[y][x];
			}
		}
	}

	protected boolean is_wall(int x, int y){
		return this.wall_grid[y][x];
	}

	protected void set_blue(int x, int y){
		this.view_gui.set_blue(x,y);
	}

	protected void all_white(){
		for(int y=0; y < this.grid_y; ++y){
			for(int x=0; x < this.grid_x; ++x){
				if(!this.wall_grid[y][x]){
					this.view_gui.set_white(x,y);
				}
			}
		}
	}
}
