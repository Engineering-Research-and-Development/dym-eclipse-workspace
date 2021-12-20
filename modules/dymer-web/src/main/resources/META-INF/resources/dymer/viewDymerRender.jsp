 
   <%@ include file="../init2.jsp" %> 
       
			 <div id="dymer_filtercontent">
		<div class="row">
			<div class="col-12 span12">
				<div class="input-group" id="adv-search">
					<input id="dTagFilter" type="text" data-role="tagsinput" placeholder="Search for snippets, click on caret" class="col-6 span6">
					<div class="input-group-btn">
                    	<div class="btn-group" role="group">
    						<div class="dropdown dropdown-lg">
                               	<button type="button" id="dFilterClearAll" class="btn   " data-autostart="true"><i class="fa fa-eraser" onclick="clearDFilter()"></i></button>
                        		<button type="button" id="dFilterDropdown" class="btn btn-default dropdown-toggle" data-toggle="dropdown"><span class="caret"></span></button>
                        		<div id="d_entityfilter" class="dropdown-menu dropdown-menu-right" role="menu">
                         			 
                        		</div>
                  			</div>
                   			<button type="button" class="btn btn-primary" onclick="switchByFilter(dTagFilter, dviewtype)"><i class="fa fa-search" aria-hidden="true"></i></button>
          				</div>
		            </div>
		        </div>
		    </div>
		</div> 
			
			
			
			<div class="row"> 
			
			<div class="col-12 span12 ">
			<span id="primodfil" class="btn btn-listdymer " onclick="drawEntities(jsonConfig)"> <i class="fa fa-list" aria-hidden="true"></i> List </span> <span id="cont-addentity" class="pull-right">
			 </span> </div>

			 </div>
			 
			 <div id="cont-MyList" class="row"></div>	   
			</div>
			  test

       






         
        

