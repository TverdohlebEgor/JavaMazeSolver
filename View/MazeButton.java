package MazeSolver;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class MazeButton{
	final JButton button;
	private boolean is_wall;
	private boolean is_blue;
	final int ind_x;
	final int ind_y;
	MazeButton(int ind_x, int ind_y, ActionListener listener){
		this.ind_x = ind_x;
		this.ind_y = ind_y;

		this.is_wall = false;
		this.is_blue = false;
		this.button = new JButton();
		this.button.setBackground(Color.WHITE);

		this.button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent evt) {
                button.setBackground(Color.GRAY);
            }

            @Override
            public void mouseExited(MouseEvent evt) {
                if(is_wall)button.setBackground(Color.BLACK);
				else if(is_blue)button.setBackground(Color.BLUE);
				else button.setBackground(Color.WHITE);
            }
        });

		this.button.setActionCommand("CLICKED_MAZEBUTTON "+this.ind_x+" "+this.ind_y);
		this.button.addActionListener(listener);

	}

	JButton get_jbutton(){
		return this.button;
	}

	protected void change_color(){
		if(this.is_wall){
			this.is_wall = false;
			this.button.setBackground(Color.WHITE);
		}
		else{
			this.is_wall = true;
			this.button.setBackground(Color.BLACK);
		}
	}

	protected void set_is_blue(boolean new_val){
		this.is_blue = new_val;
	}

	protected void set_blue(){
		this.button.setBackground(Color.BLUE);
		this.is_blue = true;
	}
	protected void set_white(){
		this.button.setBackground(Color.WHITE);
		this.is_blue = false;
	}
}
