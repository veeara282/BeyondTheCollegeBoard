import java.util.*;
import java.io.*;
public class Maze {

    private char[][] maze;
    private int maxx, maxy;
    private int startx, starty;

    public Maze(String filename) {
	startx = -1;
	starty = -1;
	String ans = "";
	try{
	    Scanner in = new Scanner(new File(filename));

	    //keep reading next line
	    while(in.hasNext()){
		String line= in.nextLine();
		if(maxy==0){
		    //calculate width of the maze
		    maxx=line.length();
		}
		//every new line add 1 to the height of the maze
		maxy++;
		ans+=line;
	    }
	}
	catch(Exception e){
	    System.out.println("File: "+filename+" could not be opened.");
	    e.printStackTrace();
	    System.exit(0);
	}

	maze = new char[maxx][maxy];
	for(int i=0;i<ans.length();i++){
	    char c = ans.charAt(i);
	    maze[i%maxx][i/maxx]= c;
	    if(c=='S'){
		startx = i%maxx;
		starty = i/maxx;
	    }
	}
    }

    private String go(int x,int y){
	return ("["+x+";"+y+"H");
    }
    
    private String clear(){
	return  "[2J";
    }

    private String hide(){
	return  "[?25l";
    }

    private String show(){
	return  "[?25h";
    }
    private String invert(){
	return  "[37";
    }



    public void clearTerminal(){
	System.out.println(clear());
    }

    public void wait(int millis){
	try {
	    Thread.sleep(millis);
	}
	catch (InterruptedException e) {
	}
    }

    public String toString(){
	String ans = ""+maxx+","+maxy+"\n";
	for(int i=0;i<maxx*maxy;i++){
	    if(i%maxx ==0 && i!=0){
		ans+="\n";
	    }
	    ans += maze[i%maxx][i/maxx];
	}
	return hide()+invert()+go(0,0)+ans+"\n"+show();
    }
    
    public void solve(){
	if(startx < 0){
	    System.out.println("No starting point 'S' found in maze.");
	}else{
	    maze[startx][starty]=' ';
	    solve(maze,startx,starty);
	}
    }

    public boolean solve(char[][]maze,int x,int y){
	System.out.println(this);
	wait(20);
	//ASSIGNMENT IS TO COMPLETE THIS PART******************
	if (maze[x][y] == 'E') {
	    return true;
	}
	if (maze[x][y] == ' ') {
	    // mark the floor
	    maze[x][y] = '@';
	    // try to move in all 4 directions (von Neumann neighborhood)
	    if (solve(maze, x+1, y) || solve(maze, x-1, y)
		|| solve(maze, x, y+1) || solve(maze, x, y-1)) {
		return true;
	    }
	    else {
		maze[x][y] = '.';
		return false;
	    }
	}
	//ASSIGNMENT IS TO COMPLETE THE PART ABOVE THIS******************
	return false;//by default the maze didn't get solved
    }


}
