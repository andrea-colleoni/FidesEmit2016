/**
 * 
 */
package com.gianluca.initDestroyBean;

/**
 * @author aculnaig
 *
 */
public class SampleBean {
	
	private String message;
	
	public void init() {
		System.out.println(SampleBean.class.getSimpleName() + " creato.");
	}
	
	public void destroy() {
		System.out.println(SampleBean.class.getSimpleName() + " distrutto.");
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return this.message;
	}

}
