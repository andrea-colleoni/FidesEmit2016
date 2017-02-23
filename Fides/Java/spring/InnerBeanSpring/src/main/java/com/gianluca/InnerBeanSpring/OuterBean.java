package com.gianluca.InnerBeanSpring;

/**
 * @author aculnaig
 *
 */

public class OuterBean {
	
	private InnerBean innerBean;
	
	public void setInnerBean(InnerBean innerBean) {
		System.out.println("All'interno del metodo setInnerBean");
		
		this.innerBean = innerBean;
	}
	
	public InnerBean getInnerBean() {
		return this.innerBean;
	}
	
	public void callDoInner() {
		innerBean.doInner();
	}

}
