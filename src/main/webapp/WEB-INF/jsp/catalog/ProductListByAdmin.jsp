<%--
       Copyright 2010-2022 the original author or authors.
       Licensed under the Apache License, Version 2.0 (the "License");
       you may not use this file except in compliance with the License.
       You may obtain a copy of the License at
          https://www.apache.org/licenses/LICENSE-2.0
       Unless required by applicable law or agreed to in writing, software
       distributed under the License is distributed on an "AS IS" BASIS,
       WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
       See the License for the specific language governing permissions and
       limitations under the License.
--%>
<%@ include file="../common/IncludeTop.jsp"%>

<jsp:useBean id="catalog"
             class="org.mybatis.jpetstore.web.actions.CatalogActionBean"/>
<div id="BackLink"><stripes:link
        beanclass="org.mybatis.jpetstore.web.actions.AccountActionBean"
        event="viewUserRequestListByAdmin">
    <stripes:param name="username" value="${sessionScope.accountBean.username}" />
    USER REQUESTS
</stripes:link></div>
<br>
<br>
<c:choose>
    <c:when test="${sessionScope.accountBean.account.admin}">
        <div id="Catalog">
            <table>
                <tr>
                    <th>Product ID</th>
                    <th>Product Name</th>
                    <th> </th>
                    <th> </th>
                </tr>
                <c:forEach var="products" items="${actionBean.productList}">
                    <tr>
                        <td>
                            <stripes:link
                                    beanclass="org.mybatis.jpetstore.web.actions.CatalogActionBean"
                                    event="viewItemListByAdmin">
                                <stripes:param name="productId" value="${products.productId}" />
                                ${products.productId}
                            </stripes:link>
                        </td>
                        <td>
                                ${products.name}
                        </td>
                        <td>
                            <stripes:link class="Button"
                                          beanclass="org.mybatis.jpetstore.web.actions.CatalogActionBean"
                                          event="viewItemListByAdmin">
                                <stripes:param name="productId" value="${products.productId}" />
                                EDIT ITEM
                            </stripes:link>
                        </td>
                        <td>
                            <stripes:link class="Button"
                                          beanclass="org.mybatis.jpetstore.web.actions.CatalogActionBean"
                                          event="viewItemByAdmin">
                                <stripes:param name="productId" value="${products.productId}" />
                                <stripes:param name="categoryId" value="${products.categoryId}" />
                                <stripes:param name="productName" value="${products.name}" />
                                <stripes:param name="username" value="${sessionScope.accountBean.account.username}" />
                                SETTING
                            </stripes:link>
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <stripes:link class="Button"
                          beanclass="org.mybatis.jpetstore.web.actions.CatalogActionBean"
                          event="insertProductFormByAdmin">
                <stripes:param name="username" value="${sessionScope.accountBean.account.username}" />
                ADD PRODUCT
            </stripes:link>
        </div>
    </c:when>
    <c:otherwise>
        <%@ include file="../common/AccessRestriction.jsp"%>
    </c:otherwise>
</c:choose>


<%@ include file="../common/IncludeBottom.jsp"%>
