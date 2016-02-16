/*
 * Author Andrei Martinescu
 */


package com.accenture.aiss.HRProjectTestHelpers;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class HelpFunctions {

	public HelpFunctions() {
	}
	
//take screenshot method for Assert error
//---------------------------------------------------------------------------------		
	public void takeScreenShotOnAssertFailure(AssertionError e, String filename, WebDriver driver)
	{
		File screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenShot, new File(filename + ".png"));
        } catch (IOException ioe) {
            throw new RuntimeException(ioe.getMessage(), ioe);
        }
        throw e;
	}
	
	
//take screenshot method for Exception error
//---------------------------------------------------------------------------------		
	public void takeScreenShotOnFailure(Exception e, String filename, WebDriver driver) throws Exception
	{
		File screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenShot, new File(filename + ".png"));
        } catch (IOException ioe) {
            throw new RuntimeException(ioe.getMessage(), ioe);
        }
        throw e;
	}

	
//write in file method 	
//-----------------------------------------------------------------------------------

    public void write(String text, String filename, String encoding,
            WriteMode mode) throws IOException 
    {
    	
        File file = new File(filename);
        
        if (mode == WriteMode.NEW && file.exists()) 
        {
            throw new IOException("File " + filename + " already exists");
        }
        
        File parent = file.getParentFile();
        
        if (parent != null && !parent.exists()) 
        {
            parent.mkdirs();
        }
        
        boolean append = mode == WriteMode.APPEND;
        
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(file, append), encoding));
        
        out.write(text);
        out.close();
    }


    // Specifies how the write to file should be done.
    public enum WriteMode {

         // If the file exists, it is overwritten; otherwise it is created

        OVERWRITE,
        
        
        // If the file exists, the text is appended to it; otherwise the file is created
        
        APPEND,

        //If the file exists, an exception should be thrown; otherwise it is created
        
        NEW;
    }
}
