public class Driver{

    public static void main(String[]args){
	Maze f;
	if(args.length < 1){
	    f = new Maze("data1.dat");
	}
	else {
	    if (args[0].equals("--info")) {
		printHelp();
	    }
	    f = new Maze(args[0]);
	}
	//	System.out.println(f);
	f.clearTerminal();
	if (args.length < 2) {
	    f.solveBFS(true);
	}
	else {
	    f.solve(Integer.parseInt(args[1]), true);
	}
    }

    public static void printHelp() {
	System.out.println("Ultimate Maze Solver");
	System.out.println("Copyright (c) 2015 Aidan Fitzgerald");
	System.out.println();
	System.out.println("Usage: java Driver [filename] [mode]");
	System.out.println("  mode: 0 - breadth-first, 1 - depth-first, 2 - best-first, 3 - A*");
	System.out.println();
	System.out.println("This screen: java Driver --info");
	System.out.println("Copyright info: less ../LICENSE");

	System.exit(0);
    }

}
