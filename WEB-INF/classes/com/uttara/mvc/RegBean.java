package com.uttara.mvc;

import java.io.Serializable;

public class RegBean implements Serializable{
	private String uname;
	private String email;
	private String pass;
	private String rpass;
	
	public RegBean() {
		System.out.println("in RB->no-arg constr");
	}
	
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
		System.out.println("in RB->setUname() uname = "+uname);
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
		System.out.println("in RB->setEmail() email = "+email);
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
		System.out.println("in RB->setPass() pass = "+pass);
	}
	public String getRpass() {
		return rpass;
	}
	public void setRpass(String rpass) {
		this.rpass = rpass;
		System.out.println("in RB->setRpass() rpass = "+rpass);
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((pass == null) ? 0 : pass.hashCode());
		result = prime * result + ((rpass == null) ? 0 : rpass.hashCode());
		result = prime * result + ((uname == null) ? 0 : uname.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RegBean other = (RegBean) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (pass == null) {
			if (other.pass != null)
				return false;
		} else if (!pass.equals(other.pass))
			return false;
		if (rpass == null) {
			if (other.rpass != null)
				return false;
		} else if (!rpass.equals(other.rpass))
			return false;
		if (uname == null) {
			if (other.uname != null)
				return false;
		} else if (!uname.equals(other.uname))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "RegBean [uname=" + uname + ", email=" + email + ", pass=" + pass + ", rpass=" + rpass + "]";
	}
	
	public String validate()
	{
		String msg = "";
		if(uname==null || uname.equals(""))
			msg = "You have not name or what? <br/>";
		if(email==null || email.equals(""))
			msg = msg + "You dont have an email or what?<br/>";
		if(pass==null || pass.equals(""))
			msg = msg + "If you dont give your pass now, how will we allow you in later?<br/>";
		else
			if(!pass.equals(rpass))
				msg = msg + "If you cannot type pass equal to repeat pass which is your own, what will you do in life?<br/>";
		
		if(msg.equals(""))
			return Constants.SUCCESS;
		else
			return msg;
		
	}
	
}






