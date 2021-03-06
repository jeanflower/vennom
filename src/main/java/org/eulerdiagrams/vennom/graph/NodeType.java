package org.eulerdiagrams.vennom.graph;

import java.util.*;
import java.io.*;


/**
 * The type of a node in a graph. Utilises the tree structure of GraphType.
 * Allows matching to use a type heirarchy and associates various display
 * information with collections of Nodes.
 *
 * @see Node
 * @author Peter Rodgers
 */
public class NodeType implements Serializable {

/** A list of all the node types */
    protected static ArrayList<NodeType> existingTypes = new ArrayList<NodeType>();

    private String label;
    
/** Height of a node, top to bottom. */
	protected int height = 30;
/** Width of a node, leftmost to rightmost. */
	protected int width = 30;
/** This can be Rectangle or Ellipse */
    protected String shapeString = new String("Ellipse");
    
/** Trivial constructor */
	public NodeType(String inLabel) {
		label = inLabel;
		existingTypes.add(this);
	}

/** trivial accessor */
	public static ArrayList<NodeType> getExistingTypes() {return existingTypes;}

/** trivial accessor */
	public int getHeight() {return height;}
/** trivial accessor */
	public int getWidth() {return width;}
/** trivial accessor */
	public String getShapeString() {return shapeString;}
	
/** trivial mutator */
	public void setHeight(int h) {height = h;}
/** trivial mutator */
	public void setWidth(int w) {width = w;}
/** trivial mutator */
	public void setShapeString(String s) {shapeString = s;}
	
/** Returns the edge type with the given label or if there is no such type, returns null. */
	public static NodeType withLabel(String label) {
		NodeType nt = null;
		for(NodeType nt2 : existingTypes){
			if(nt2.label.equals(label)) {
				nt = nt2;
			}
		}
		return nt;
	}

/**
* Outputs the content of the node type for debugging purposes.
*/
	public String toString() {
		return label;
	}
	public String getLabel(){
		return label;
	}

}



