package cz.incad.kramerius.rights.server;

import org.aplikator.client.descriptor.PropertyDTO;
import org.aplikator.server.descriptor.Application;
import org.aplikator.server.function.Executable;
import org.aplikator.server.function.FunctionParameters;
import org.aplikator.server.function.FunctionResult;

public class VygenerovatHeslo  implements Executable {
    
//    private Persister persister;
//    private Structure s;
//    private Connection conn;
//    private String RDCZPredlohaSelect = "select id, urnnbnflag, urnnbn, idcislo, sigla1, digknihovna, skendjvu, skenjpeg, skengif, skentiff, skenpdf, skentxt, "
//        +"rozsah, rozliseni, barevnahloubka, dostupnost, isbn, issn, ccnb, druhdokumentu, nazev, autor, vydavatel, rokvyd, mistovyd, url , publprac, publdate "
//        +" from Predloha where urnnbnflag = 1"; 
//    
//    private String RDCZDigObjSelect = "select id, handler from digobj do left outer join xpreddigobj xdo on do.id = xdo.rDigObjekt where xdo.rPredloha= ?";//TODO pouzit pro dalsi Lokace
//   
//    private String RDCZInstSelect = "select value, cz from dlists where classname = 'cz.incad.nkp.digital.InsVlastnik'";
//    private String RDCZKnihSelect = "select value, cz from dlists where classname = 'cz.incad.nkp.digital.InsDigitalniKnihovna'";
    
    @Override
    public FunctionResult execute(FunctionParameters parameters) {
        String result = null;
        try{
        	System.out.println("EXECUTE FUNCTION VygenerovatHeslo: "+parameters.getClientContext().getCurrentRecord().getPrimaryKey().getId());
        	PropertyDTO email = ((Structure) Application.get()).user.EMAIL.clientClone();
        	result = "Heslo odeslano na adresu: "+parameters.getClientContext().getCurrentRecord().getStringValue(email);
        }catch (Exception ex){
            return new FunctionResult("Chyba: "+ex, false);
        }
    	return new FunctionResult(result, true);
        
    }
    
}