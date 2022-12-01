<%--
  Created by IntelliJ IDEA.
  User: simjonghan
  Date: 2022/12/01
  Time: 10:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="../common/IncludeTop.jsp"%>
<jsp:useBean id="catalog"
             class="org.mybatis.jpetstore.web.actions.CatalogActionBean"/>
<c:choose>
    <c:when test="${sessionScope.accountBean.account.admin}">
        <div id="Catalog"
                    beanclass="org.mybatis.jpetstore.web.actions.CatalogActionBean">
            <h2 style="text-align: center">${actionBean.product.name}</h2>
            <h3 style="text-align: center">${actionBean.envColumnName}</h3>
            <stripes:form name="test" beanclass="org.mybatis.jpetstore.web.actions.CatalogActionBean">
                <table>
                    <tr>
                        <c:forEach var="productEnvItemList"
                                   items="${actionBean.productEnvItemList}">
                            <th>
                                ${productEnvItemList.envItem}
                            </th>
                        </c:forEach>
                    </tr>
                    <tr>
                        <c:forEach var="productEnvItemList"
                                   items="${actionBean.productEnvItemList}">
                            <td style="text-align: center">
                                <stripes:radio name="envItem" value="${productEnvItemList.envItem}"/>
                            </td>
                        </c:forEach>
                    </tr>
                </table>
                <stripes:submit name="viewItemByAdmin" value="Submit" />
            </stripes:form>
<%--            <stripes:param name="columname" value="${actionBean.columname}" />--%>
<%--            <stripes:param name="productId" value= "${actionBean.product.productId}" />--%>
<%--            <stripes:param name="categoryId" value="${actionBean.product.categoryId}" />--%>
        </div>
    </c:when>
    <c:otherwise>
        <%@ include file="../common/AccessRestriction.jsp"%>
    </c:otherwise>
</c:choose>
<%@ include file="../common/IncludeBottom.jsp"%>