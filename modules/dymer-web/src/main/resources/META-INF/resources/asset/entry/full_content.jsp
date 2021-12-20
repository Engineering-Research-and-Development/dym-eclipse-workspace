<%@include file="../../init.jsp"%>

<%
DymerEntry entry = (DymerEntry)request.getAttribute("dym_entry");

entry = entry.toEscapedModel();
// String url = "http://dihiwaredym02.eng.it/public/cdn/js/iframe/detail.html?_id=" + entry.getId();

String url = "#";

if (entry!=null){
	url = entry.getUrl() + "/iframetool/public/detail/" + entry.getId();
}
%>
 
 <script>
   	var dymerconf= {
	  				notImport:[]
	  			};

 	var jsonDymerConfig = {
        query: {  
            "query": {
              "query": {
                  "match": {
                      "_id": "<%=entry.getId()%>" // entity Id
                  }
              }
          }
        },
        endpoint: 'entity.search', // set the endpoint to execute the query of entities
        viewtype: 'fullcontent', // set to use the 'Fullcontent' template
        target: { 
            fullcontent: {// configure where and how to render the detail of an entity
                id: "#cont-MyList", // the entity will be rendered inside the element with id "#cont-MyList"
                action: "html", // set the method to insert the content (html/append/prepend)
                reload: false // if false the query will be executed only on page load 
              }
        }
    };
    function mainDymerView() {
        drawEntities(jsonDymerConfig);
    }
 </script>
 <script id="dymerurl" src="<%=entry.getUrl()%>/public/cdn/js/dymer.viewer.js"></script>
    
 <div id="cont-MyList" class="row"></div>	   
 
