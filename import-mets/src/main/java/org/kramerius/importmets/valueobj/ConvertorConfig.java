package org.kramerius.importmets.valueobj;

import cz.incad.kramerius.utils.IOUtils;
import org.kramerius.importmets.MetsConvertor;

import javax.xml.bind.Marshaller;
import java.sql.Connection;

/**
 * Konfigurace konvertoru
 * 
 * @author xholcik
 */
public class ConvertorConfig {

    private Marshaller marshaller;

    private String importFolder;

    private String exportFolder;

    private int contractLength;
    
    private boolean defaultVisibility = false;
    
    private String contract;
    
    
    private Connection dbConnection;

    public String getImportFolder() {
        return importFolder;
    }

    public void setImportFolder(String importFolder) {
        this.importFolder = importFolder;
    }

    public String getExportFolder() {
        return exportFolder;
    }

    public void setExportFolder(String exportFolder) {
        this.exportFolder = exportFolder;
    }

    public Marshaller getMarshaller() {
        return marshaller;
    }

    public void setMarshaller(Marshaller marshaller) {
        this.marshaller = marshaller;
    }

    public int getContractLength() {
        return contractLength;
    }

    public void setContractLength(int contractLength) {
        this.contractLength = contractLength;
    }

    public boolean isDefaultVisibility() {
        return defaultVisibility;
    }

    public void setDefaultVisibility(boolean defaultVisibility) {
        this.defaultVisibility = defaultVisibility;
    }

    public Connection getDbConnection() {
        return dbConnection;
    }

    public void setDbConnection(Connection dbConnection) {
        this.dbConnection = dbConnection;
    }

	public void setContract(String contract) {
        this.contract = contract.replaceAll("[\\\\/:\"*?<>|]","_");
		if (MetsConvertor.useContractSubfolders()){
			this.exportFolder = this.exportFolder+ System.getProperty("file.separator")+this.contract;
			IOUtils.checkDirectory(this.exportFolder);
			String xmlSubfolder = this.exportFolder+ System.getProperty("file.separator")+"xml";//Issue 73
			IOUtils.checkDirectory(xmlSubfolder);
		}
	}
	
	public String getContract(){
		return contract;
	}



	
}
