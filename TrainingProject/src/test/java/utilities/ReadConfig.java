package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties pro;

	public ReadConfig() {
		// TODO Auto-generated constructor stub
		File src = new File("./Configuration\\config.properties");
		try{
			FileInputStream fi= new FileInputStream(src);
			pro=new Properties();
			pro.load(fi);
		}
		catch(Exception e)
		{
			System.out.println("Exception is"+ e.getMessage());
		}
	}

	public String getApplicationURL()
	{
		String url=pro.getProperty("baseURL");
		return url;

	}
	
	public String getUsername()
	{
		String username=pro.getProperty("username");
		return username;

	}
	
	public String getPassword()
	{
		String password=pro.getProperty("password");
		return password;

	}
	
	public String getChropath()
	{
		String chropath=pro.getProperty("chropath");
		return chropath;

	}
	public String getfirefoxpath()
	{
		String firefoxpath=pro.getProperty("firefoxpath");
		return firefoxpath;

	}
	public String getedgepath()
	{
		String edgepath=pro.getProperty("edgepath");
		return edgepath;

	}
}


