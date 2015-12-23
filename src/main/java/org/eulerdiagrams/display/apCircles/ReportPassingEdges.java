package org.eulerdiagrams.display.apCircles;import java.io.*;import java.util.ArrayList;import java.awt.event.*;import org.eulerdiagrams.display.graph.GraphUtility;import org.eulerdiagrams.vennom.apCircles.Util;import org.eulerdiagrams.vennom.graph.*;/** * Just for quick testing of methods. */public class ReportPassingEdges extends GraphUtility implements Serializable {/**	 * 	 */	private static final long serialVersionUID = 1L;/** Trivial constructor. */	public ReportPassingEdges() {		super(KeyEvent.VK_P,"Edge Length Report",KeyEvent.VK_P);	}/** Changes the graph. */	public void apply() {				System.out.println(report(getGraph()));	}		public static String report(Graph g) {//		return "Failing attractors: "+failingAttractors(g)+"\n"+"Failing repulsors: "+failingRepulsors(g);				String ret = "";		for(Edge e : g.getEdges()) {			double actualLength = Util.distance(e.getFrom().getCentre(), e.getTo().getCentre());			double errorPercent = Math.abs(100*(actualLength-e.getScore())/e.getScore());			ret += e.getType().getLabel()+" value "+e.getScore()+" actual "+actualLength+" diff "+Util.round(errorPercent,2)+"%";			ret+= "\n";		}		return ret;			}	public static ArrayList<Edge> failingAttractors(Graph g) {		ArrayList<Edge> ret = new ArrayList<Edge>();		for(Edge e : g.getEdges()) {			if(e.isAttractorType()) {				double maxLength = Double.parseDouble(e.getLabel());				double actualLength = Util.distance(e.getFrom().getCentre(), e.getTo().getCentre());				if(maxLength< actualLength) {					ret.add(e);				}			}		}		return ret;	}		public static ArrayList<Edge> failingRepulsors(Graph g) {		ArrayList<Edge> ret = new ArrayList<Edge>();		for(Edge e : g.getEdges()) {			if(e.isRepulsorType()) {				double minLength = Double.parseDouble(e.getLabel());				double actualLength = Util.distance(e.getFrom().getCentre(), e.getTo().getCentre());				if(minLength > actualLength) {					ret.add(e);				}			}		}		return ret;	}	}