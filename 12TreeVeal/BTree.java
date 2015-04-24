import java.io.*;
import java.util.*;

public class BTree<E> {

    public static final int PRE_ORDER = 0;
    public static final int IN_ORDER = 1;
    public static final int POST_ORDER = 2;
    

    private TreeNode<E> root;

    public BTree() {
	root = null;
    }

    /*======== public void add() ==========
      Inputs:   E d
      Returns: 
      
      Wrapper method for the recursive add()
      ====================*/     
    public void add(E d) {
	TreeNode<E> bn = new TreeNode<>(d);
	if (root == null) {
	    root = bn;
	}
	else {
	    add(root, bn);
	}
    }

    private static final Random RAND = new Random(201504231222L);

    /*======== public void add() ==========
      Inputs:   TreeNode<E> curr, TreeNode<E> bn  
      Returns: 
      
      Adds bn to the tree rooted at curr. If curr has 
      an available child space, then attach bn there.

      Otherwise, try to add at the subtree rooted at
      one of curr's children. Choose the child to be
      added to randomly.
      ====================*/
    private void add(TreeNode<E> cur, TreeNode<E> bn) {
	// Tres node!
	if (!cur.hasLeft()) {
	    cur.setLeft(bn);
	}
	else if (!cur.hasRight()) {
	    cur.setRight(bn);
	}
	else if (RAND.nextBoolean()) {
	    add(cur.getLeft(), bn);
	}
	else {
	    add(cur.getRight(), bn);
	}
    }
    
    public void traverse( int mode) {
	if ( mode == PRE_ORDER )
	    preOrder( root );
	else if ( mode == IN_ORDER )
	    inOrder( root );
	else
	    postOrder( root );
	System.out.println();
    }

    private void print(TreeNode<E> curr) {
	System.out.print(curr.getValue());
	System.out.print(' ');
    }

    /*======== public void preOrder() ==========
      Inputs:   TreeNode<E> curr  
      Returns: 
      
      Prints out the elements in the tree by doing an
      pre-order Traversal
      ====================*/
    public void preOrder(TreeNode<E> curr) {
	if (curr == null)
	    return;
	preOrder(curr.getLeft());
	print(curr);
	preOrder(curr.getRight());
    }


    /*======== public void inOrder() ==========
      Inputs:   TreeNode<E> curr  
      Returns: 
      
      Prints out the elements in the tree by doing an
      in-order Traversal
      ====================*/
    public void inOrder(TreeNode<E> curr) {
	if (curr == null)
	    return;
	print(curr);
	inOrder(curr.getLeft());
	inOrder(curr.getRight());
    }

    /*======== public void postOrder() ==========
      Inputs:   TreeNode<E> curr  
      Returns: 
      
      Prints out the elements in the tree by doing a
      post-order Traversal    
      ====================*/
    public void postOrder(TreeNode<E> curr) {
	if (curr == null)
	    return;
	postOrder(curr.getRight());
	print(curr);
	postOrder(curr.getLeft());
    }
    
    /*======== public int getHeight()) ==========
      Inputs:   
      Returns: The height of the tree

      Wrapper for the recursive getHeight method
      ====================*/
    public int getHeight() {
	return getHeight( root );
    }
    /*======== public int getHeight() ==========
      Inputs:   TreeNode<E> curr  
      Returns:  The height of the tree rooted at node curr
      
      ====================*/
    public int getHeight( TreeNode<E> curr ) {
	return curr.getDepth();
    }

    /*======== public String getLevel() ==========
      Inputs:   TreeNode<E> curr
                int level
                int currLevel  
      Returns: A string containing all the elements on the
               given level, ordered left -> right
      
      ====================*/
    public String getLevel(TreeNode<E> curr, int level) {
	StringBuilder strb = new StringBuilder();
	levelCached(curr, level, 0, strb);
	return strb.toString();
    }

    private StringBuilder levelCached(TreeNode<E> cur, int level, int curLevel, StringBuilder cache) {
	if (cur == null) {
	    return cache;
	}
	else if (curLevel == level) {
	    return cache.append(cur.getValue()).append(' ');
	}
	else {
	    levelCached(cur.getLeft(), curLevel + 1, cache);
	    levelCached(cur.getRight(), curLevel + 1, cache);
	    return cache;
	}
    }
    
    /*======== public String toString()) ==========
      Inputs:   
      Returns: A string representation of the tree
     
      This string should display each level as a separate line.
      A simple version might look something like this:

      0
      1 2
      3 4 5

      Note that you cannot tell exactly where 3, 4 and 5 lie.
      That is ok, but if you want a CHALLENGE, you can try to
      get the output to look nicer, something like this:
             0
          1      2
            3  4   5
      ====================*/
    public String toString() {
	StringBuilder strb = new StringBuilder();
	for (int level = 0; level < getHeight(); level++) {
	    levelCached(root, level, 0, strb);
	    strb.append('\n');
	}
	return strb.toString();
    }
	

    public static void main( String[] args ) {

	BTree<Integer> t = new BTree<Integer>();

	for ( int i=0; i < 8; i++ ) 
	    t.add( i );
	System.out.println( "Pre-order: ");
	t.traverse( PRE_ORDER );
	System.out.println( "In-order: ");
	t.traverse( IN_ORDER );
	System.out.println( "Post-order: ");
	t.traverse( POST_ORDER );
	System.out.println( "Height: " + t.getHeight() );

	System.out.println( t );
    }
}