<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
    String logo_url = kconfig.getProperty("search.logo_url", ".");
    pageContext.setAttribute("logo_url", logo_url);
%>
<a href="${logo_url}" ><img alt="<fmt:message bundle="${lctx}">application.title</fmt:message>" src="img/logo.png" border="0" /></a>