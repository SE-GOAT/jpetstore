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

<div id="BackLink"><stripes:link
	beanclass="org.mybatis.jpetstore.web.actions.CatalogActionBean"
	event="viewProduct">
	<stripes:param name="productId" value="${actionBean.product.productId}" />
	Return to ${actionBean.product.productId}
</stripes:link></div>
<br>
<br>
<div id="Catalog">

<table>
	<tr>
		<td>${actionBean.product.description}</td>
	</tr>
	<tr>
		<td><b> ${actionBean.item.itemId} </b></td>
	</tr>
	<tr>
		<td><b><font size="4"> ${actionBean.item.attribute1}
		${actionBean.item.attribute2} ${actionBean.item.attribute3}
		${actionBean.item.attribute4} ${actionBean.item.attribute5}
		${actionBean.product.name} </font></b></td>
	</tr>
	<tr>
		<td>${actionBean.product.name}</td>
	</tr>
	<tr>
		<td><c:if test="${actionBean.item.quantity <= 0}">
        Back ordered.
      </c:if> <c:if test="${actionBean.item.quantity > 0}">
      	${actionBean.item.quantity} in stock.
	  </c:if></td>
	</tr>
	<tr>
		<td><fmt:formatNumber value="${actionBean.item.listPrice}"
			pattern="$#,##0.00" /></td>
	</tr>

	<tr>
		<td><stripes:link class="Button"
			beanclass="org.mybatis.jpetstore.web.actions.CartActionBean"
			event="addItemToCart">
			<stripes:param name="workingItemId" value="${actionBean.item.itemId}" />
       	Add to Cart
       </stripes:link></td>
	</tr>
</table>
	<br/>
	<h3>INFORMATION</h3>
<table>
	<tr>
		<c:forEach var="list" items="${actionBean.animalInfoList}">
			<th style="text-align: center">
				${list.columname}
			</th>
		</c:forEach>
	</tr>
	<tr>
		<c:forEach var="list" items="${actionBean.animalInfoList}">
			<th style="text-align: center">
				${list.value}
			</th>
		</c:forEach>
	</tr>
<%--	<c:forEach var="list" items="${actionBean.animalInfoList}">--%>
<%--		<tr>--%>
<%--			<th>--%>
<%--				${list.columname}--%>
<%--			</th>--%>
<%--			<td>--%>
<%--					${list.value}--%>
<%--			</td>--%>
<%--		</tr>--%>

<%--	</c:forEach>--%>
<%--	<tr>--%>
<%--		<c:forEach var="column" items="${actionBean.animalInfoList}">--%>
<%--			<th>--%>
<%--				${column.columname}--%>
<%--			</th>--%>
<%--		</c:forEach>--%>
<%--	</tr>--%>
<%--	<tr>--%>
<%--		<c:forEach var="values" items="${actionBean.acnimalInfoList}">--%>
<%--			<td>--%>
<%--				${values.value}--%>
<%--			</td>--%>
<%--		</c:forEach>--%>
<%--	</tr>--%>
<%--	<c:forEach var="animalInfoColumnValueList" items="${actionBean.animalInfoColumnValueList}">--%>
<%--		<tr>--%>
<%--			<td>--%>
<%--					${animalInfoColumnValueList.value}--%>
<%--			</td>--%>
<%--		</tr>--%>
<%--	</c:forEach>--%>
	</table>
	<br/>
	<h3>ENVIRONMENT</h3>
	<table>
		<tr>
			<th style="text-align: center"></th>
			<c:forEach var="userEnvList" items="${actionBean.userEnvList}">
				<th style="text-align: center">
						${userEnvList.envColumnName}
				</th>
			</c:forEach>
		</tr>
		<tr>
			<th style="text-align: center">
				MY
			</th>
			<c:forEach var="userEnvList" items="${actionBean.userEnvList}">
				<th style="text-align: center">
						${userEnvList.envItem}
				</th>
			</c:forEach>
		</tr>
	</table>

</div>

<%@ include file="../common/IncludeBottom.jsp"%>



