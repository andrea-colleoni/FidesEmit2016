package com.gianluca.InnerBeanSpring;

/**
 * @author aculnaig
 *
 */

public class InnerBean {
	
	public InnerBean() {
		System.out.println("All'interno del costruttore InnerBean");
	}
	
	public void doInner() {
		System.out.println("All'interno del metodo doInner");
	}

}
