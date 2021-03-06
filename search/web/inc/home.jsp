<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page isELIgnored="false"%>
<%@page import="com.google.inject.Injector"%>
<%@page import="java.util.Locale"%>
<%@page import="com.google.inject.Provider"%>
<%@page import="cz.incad.Kramerius.backend.guice.LocalesProvider"%>
<%@page import="java.io.*, cz.incad.kramerius.service.*"  %>
<%@page import="cz.incad.kramerius.utils.conf.KConfiguration"%>
<%@page import="javax.servlet.jsp.jstl.fmt.LocalizationContext"%>
<%@page import="cz.incad.kramerius.FedoraAccess"%>
<%
    String[] dtsa = kconfig.getPropertyList("search.home.document.types");
    String dts = "";
    for(String dt : dtsa){
        dts += "[" + dt + "]";
    }
    pageContext.setAttribute("dts", dts);
%>
<table style="width: 990px;"><tr><td valign="top">
<div id="homedabox" style="float:left;width:239px;margin-left:4px;">
    <ul><li><a href="#dadiv"><fmt:message bundle="${lctx}" key="Časová osa" /></a></li></ul>
    <div id="dadiv" style="padding:3px;">
        <p style="text-align: center;">
            <img src="img/loading.gif" alt="loading date axis" /><br/>Time line loading...
        </p>
    </div>
</div>
</td><td style="width:745px;"> 
<div style="float:left;width:740px;">
<div id="dt_home">
    <c:url var="dtxslurl" value="inc/home/dt.xsl" />
    <c:import url="${dtxslurl}" var="facetxsl" charEncoding="UTF-8"  />
    <x:transform doc="${xml}"  xslt="${facetxsl}">
        <x:param name="bundle_url" value="${i18nServlet}"/>
        <x:param name="dts" value="${dts}"/>
    </x:transform>
</div>
<%@ include file="home/tabs.jsp" %>
</div>
</td></tr></table>
<script type="text/javascript">
    $(window).resize(function(event){
        resizeAll();
    });
    $(document).ready(function(){
        setTimeout(resizeAll, 5000);
        $.get("inc/da.jsp", function(data){
            $("#dadiv").html(data);
            initDateAxis();
            $("#content-resizable").css("height", (containerHeight+7) + "px");
            daScrollToMax();
            setTimeout(resizeAll, 2000);
        });
        
    });
    function resizeAll(){
        var w = $("#intro>div.ui-tabs-panel:first").height() +
            $(window).height() -
            $("#main").height() - 
            $("#footer").outerHeight(true);
        $("#intro>div.ui-tabs-panel").css("height", w);
        if($("#content-resizable").length>0){
            w = w -35;
            $("#content-resizable").css("height", w);
            resizeDateAxisContent();
        }
    }
</script>

