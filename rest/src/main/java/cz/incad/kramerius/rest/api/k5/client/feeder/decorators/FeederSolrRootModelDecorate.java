/*
 * Copyright (C) 2013 Pavel Stastny
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package cz.incad.kramerius.rest.api.k5.client.feeder.decorators;

import static cz.incad.kramerius.rest.api.k5.client.utils.SOLRDecoratorUtils.getSolrPidDocument;

import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import net.sf.json.JSONObject;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.google.inject.Inject;

import cz.incad.kramerius.SolrAccess;
import cz.incad.kramerius.rest.api.k5.client.utils.SOLRUtils;
import cz.incad.kramerius.utils.XMLUtils;

/**
 * Doplni root model z indexu
 * @author pavels
 */
public class FeederSolrRootModelDecorate extends AbstractFeederDecorator {

    public static final Logger LOGGER = Logger.getLogger(FeederSolrRootModelDecorate.class.getName());

    public static final String SOLR_ROOTMODEL_KEY = AbstractFeederDecorator.key("ROOTMODEL");

    @Inject
    SolrAccess solrAccess;
    
	@Override
	public String getKey() {
		return SOLR_ROOTMODEL_KEY;
	}

	@Override
	public void decorate(JSONObject jsonObject,
			Map<String, Object> runtimeContext) {
		if (jsonObject.containsKey("pid")) {
			String pid = jsonObject.getString("pid");
	        try {
				Document solrDoc = getSolrPidDocument(pid, context, solrAccess);
				Element result = XMLUtils.findElement(solrDoc.getDocumentElement(), "result");
				if (result != null) {
				    Element doc = XMLUtils.findElement(result, "doc");
				    if (doc != null) {

				        String root_pid = SOLRUtils.value(doc, "root_model", String.class);
				        if (root_pid != null) {
				            jsonObject.put("root_pid", root_pid);
				        }
				    }
				}
			} catch (IOException e) {
				LOGGER.log(Level.SEVERE,e.getMessage(),e);
			}
		}
	}

	@Override
	public boolean apply(JSONObject jsonObject, String context) {
		TokenizedPath tpath = super.feederContext(tokenize(context));
		return tpath.isParsed() ;
	}
	
}
