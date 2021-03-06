package org.gradle



import org.gradle.api.file.*;
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction
import org.gradle.api.artifacts.*;

import org.apache.tools.ant.taskdefs.optional.ANTLR;
import org.apache.tools.ant.types.Path;
import org.gradle.api.file.FileCollection;
import org.gradle.api.plugins.antlr.internal.GenerationPlan;
import org.gradle.api.plugins.antlr.internal.GenerationPlanBuilder;
import org.gradle.api.plugins.antlr.internal.MetadataExtracter;
import org.gradle.api.plugins.antlr.internal.XRef;
import org.gradle.api.tasks.InputFiles;
import org.gradle.api.tasks.OutputDirectory;
import org.gradle.api.tasks.SourceTask;
import org.gradle.api.tasks.TaskAction;
import org.gradle.util.GFileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.List;
import java.util.ArrayList;

import  com.sun.tools.ws.ant.*


public class WSImportTask extends DefaultTask {
	
	public static final String DEFAULT_PACKAGE_NAME="com.qbizm.kramerius.imp.jaxb";

	private static final Logger LOGGER = LoggerFactory.getLogger(WSImportTask.class);
    
	private FileCollection clp;
	private File outputDirectory;
	private String packageName = DEFAULT_PACKAGE_NAME;
	private List<File> wsdls =new ArrayList<File>();
	
	
	
	public String getPackageName() {
		return this.packageName;
	}
	
	public void setPackageName(String pckg) {
		this.packageName = pckg;
	}
    
	
	public void setXjcClasspath(FileCollection p) {
    	    this.clp = p;
    	}
 
	@InputFiles
	public FileCollection getXjcClasspath() {
		return this.clp;
	}

	    
	@OutputDirectory
	public File getOutputDirectory() {
		return outputDirectory;
	}

	public void setOutputDirectory(File outputDirectory) {
		this.outputDirectory = outputDirectory;
	}

    	
    	
	public void addWsdl(File wsdl) {
		this.wsdls.add(wsdl);
	}
	
	public void removeWsdl(File w) {
		this.wsdls.remove(wsdl);
	}
    
	private void configureExt(WSImportExtensions ext) {
		setPackageName(ext.getPackageName());
	}

	
	@TaskAction
	public void generate() {
		LOGGER.log(Level.FINE, "executing jaxb");		
		WSImportExtensions ext = getProject().getExtensions().getByType(WSImportExtensions.class);
		if (ext != null) {
    	    	    configureExt(ext);
    	    	}

    	    	LOGGER.log(Level.INFO, "task def");		
    	    	ant.taskdef(name: 'wsimport', classname: 'com.sun.tools.ws.ant.WsImport', classpath: getXjcClasspath().asPath)
    	    
    	    	LOGGER.log(Level.INFO, "running task");		
    	    	for(File f:this.wsdls) {
    	    		ant.wsimport(wsdl: f.getAbsolutePath(), sourcedestdir: this.outputDirectory.getAbsolutePath(), package: this.packageName, xnocompile: true, xendorsed:false, target:'2.1')
    	    	}
    	    
    	    	new File(this.outputDirectory,"API."+getName()+".generated").createNewFile();
    }
}
