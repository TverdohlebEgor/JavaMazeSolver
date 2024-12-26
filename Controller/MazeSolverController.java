package MazeSolver;
import java.util.PriorityQueue;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

class MazeSolverController implements ActionListener{
	private int grid_x;
	private int grid_y;
	private GUIMODEL gui_model;

	MyNode[][] node_grid;
	MazeSolverController(int grid_x, int grid_y){
		this.grid_x = grid_x;
		this.grid_y = grid_y;
		
		this.gui_model = new GUIMODEL(grid_x,grid_y,this);	
		this.node_grid = new MyNode[grid_y][grid_x];
		for(int y=0; y < grid_y; ++y){
			for(int x=0; x < grid_x; ++x){
				this.node_grid[y][x] = new MyNode();
				this.node_grid[y][x].set_x(x);
				this.node_grid[y][x].set_y(y);
			}
		}
		this.node_grid[0][0].set_distance(0);
	}

	protected void clean_data(){
		for(int y=0; y < grid_y; ++y){
			for(int x=0; x < grid_x; ++x){
				this.node_grid[y][x].set_distance(99999);
				this.node_grid[y][x].set_visited(false);
			}
		}
		this.node_grid[0][0].set_distance(0);
	}
	
	protected boolean dijkstra_solve(){
		this.clean_data();
		PriorityQueue<MyNode> next_queue= new PriorityQueue<MyNode>();
		next_queue.add(this.node_grid[0][0]);
		MyNode current_node = next_queue.poll();
		boolean reached = false;
		while(current_node != null){
			if(current_node.get_x() == this.grid_x-1 && current_node.get_y() == this.grid_y-1){
				reached = true;
				break;
			}
			
			current_node.set_visited(true);
			int x = current_node.get_x();
			int y = current_node.get_y();
			int current_distance = current_node.get_distance();
			if(x-1 >= 0 && !gui_model.is_wall(x-1,y) && this.node_grid[y][x-1].get_visited() == false){
				if(current_distance+1 < this.node_grid[y][x-1].get_distance()){
					this.node_grid[y][x-1].set_distance(current_distance+1);
					this.node_grid[y][x-1].set_previous(current_node);
					next_queue.add(this.node_grid[y][x-1]);
				}
			}
			if(x+1 < this.grid_x && !gui_model.is_wall(x+1,y) && this.node_grid[y][x+1].get_visited() == false){
				if(current_distance+1 < this.node_grid[y][x+1].get_distance()){
					this.node_grid[y][x+1].set_distance(current_distance+1);
					this.node_grid[y][x+1].set_previous(current_node);
					next_queue.add(this.node_grid[y][x+1]);
				}
			}
			if(y+1 < this.grid_y && !gui_model.is_wall(x,y+1) && this.node_grid[y+1][x].get_visited() == false){
				if(current_distance+1 < this.node_grid[y+1][x].get_distance()){
					this.node_grid[y+1][x].set_distance(current_distance+1);
					this.node_grid[y+1][x].set_previous(current_node);
					next_queue.add(this.node_grid[y+1][x]);
				}
			}
			if(y-1 >= 0 && !gui_model.is_wall(x,y-1) && this.node_grid[y-1][x].get_visited() == false){
				if(current_distance+1 < this.node_grid[y-1][x].get_distance()){
					this.node_grid[y-1][x].set_distance(current_distance+1);
					this.node_grid[y-1][x].set_previous(current_node);
					next_queue.add(this.node_grid[y-1][x]);
				}
			}
			current_node = next_queue.poll();
		}	

		if(!reached) return false;

		MyNode last_node = this.node_grid[this.grid_y-1][this.grid_x-1];
		while(last_node != null){
			this.gui_model.set_blue(last_node.get_x(),last_node.get_y());
			last_node = last_node.get_previous();
		}
		return true;
	}

	public void actionPerformed(ActionEvent e){
		this.gui_model.all_white();
		boolean rs = dijkstra_solve();
		if(rs) System.out.println("Solved");
		else   System.out.println("Not Solved");

	}
}
