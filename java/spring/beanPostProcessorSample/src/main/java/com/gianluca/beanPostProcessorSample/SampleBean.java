/**
 * 
 */
package com.gianluca.beanPostProcessorSample;

/**
 * @author aculnaig
 *
 */
public class SampleBean {
	
	private String message;
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return this.message;
	}
	
	public void init() {
		System.out.println(SampleBean.class.getSimpleName() + " inizializzato.");
	}
	
	public void destroy() {
		System.out.println(SampleBean.class.getSimpleName() + " distrutto.");
	}
}
