package MazeSolver;

class MyNode implements Comparable<MyNode>{
	private int distance;
	private MyNode previous;
	private int x;
	private int y;
	private boolean visited;
	MyNode(){
		this.distance = 999999;
		this.previous = null;
		this.x = -1;
		this.y = -1;
		this.visited = false;
	}
	protected void set_distance(int new_val){this.distance  = new_val;}
	protected void set_previous(MyNode new_val){this.previous = new_val;}
	protected void set_x(int new_val){this.x= new_val;}
	protected void set_y(int new_val){this.y= new_val;}
	protected void set_visited(boolean new_val){this.visited= new_val;}
	protected int  get_distance(){return this.distance;}
	protected MyNode get_previous(){return this.previous;}
	protected int  get_x(){return this.x;}
	protected int  get_y(){return this.y;}
	protected boolean get_visited(){return this.visited;}

	@Override
	public int compareTo(MyNode other){
		return Integer.compare(this.distance,other.get_distance());
	}
}
