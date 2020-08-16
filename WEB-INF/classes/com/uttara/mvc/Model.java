package com.uttara.mvc;

public class Model {

	public String register(RegBean bean)
	{
		System.out.println("Model->register() bean = "+bean);
		
		//perform input validations
		
		String msg = bean.validate();
		if(msg.equals(Constants.SUCCESS))
		{
			// now perform business validations
			
			return Constants.SUCCESS;
		}
		else
			return msg;
			
	}
}






