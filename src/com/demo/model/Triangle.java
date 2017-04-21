package com.demo.model;

public class Triangle {

	/*
	 * private String type; private int height;
	 * 
	 * public Triangle(String type) {
	 * 
	 * this.type = type; System.out.println("New type created"); }
	 * 
	 * public Triangle(int height) {
	 * 
	 * this.height = height; System.out.println("New height created"); }
	 * 
	 * public Triangle(String type, int height) { super(); this.type = type;
	 * this.height = height; }
	 * 
	 * public int getHeight() { return height; }
	 * 
	 * public String getType() { return type; }
	 * 
	 * public void setType(String type) { this.type = type; }
	 * 
	 * public void draw() { System.out.println(getType() +
	 * " Traingle drawn of height " + getHeight() + " !!!"); }
	 */

	/*-------------------------------------------------------------------------------------------*/

	private Point pointA;
	private Point pointB;
	private Point pointC;

	public Point getPointA() {
		return pointA;
	}

	public void setPointA(Point pointA) {
		this.pointA = pointA;
	}

	public Point getPointB() {
		return pointB;
	}

	public void setPointB(Point pointB) {
		this.pointB = pointB;
	}

	public Point getPointC() {
		return pointC;
	}

	public void setPointC(Point pointC) {
		this.pointC = pointC;
	}

	public void draw() {

		System.out.println("This is point A---> X : " + getPointA().getX() + " & Y : " + getPointA().getY());
		System.out.println("This is point B---> X : " + getPointB().getX() + " & Y : " + getPointB().getY());
		System.out.println("This is point C---> X : " + getPointC().getX() + " & Y : " + getPointC().getY());

	}

}
