$(function(){
	initDataGrid();
})

function initDataGrid(){
	datagrid = $('#datagrid').datagrid({
		url:'/eur-admin/tactic/list.do',
		iconCls : 'icon-user',
		title:'',
		pagination:true,
		pageSize:20,
		pageList:[10, 20, 30, 40, 50],
		idField:'tacticId',
		sortName:'tacticId',
		sortOrder:'asc',
		remoteSort:false,
		striped:true,
		columns : [[
		             {field:'box',title:'选择框',checkbox:true},
		             {field:'tacticId',title:'策略ID', hidden:true},
		             {field:'tacticName',title:'策略名称', editor:'text'},
		             {field:'coefficient1',title:'特征系数1', editor:'text'},
		             {field:'coefficient2',title:'特征系数2'},
		             {field:'coefficient3',title:'特征系数3'},
		             {field:'coefficient4',title:'特征系数4'},		                	 
		             {field:'relativeThresholdId',title:'关联阈值ID'},
		             {field:'insertUser',title:'插入人'},
		             {field:'insertTime',title:'插入时间'},
		             {field:'updateUser',title:'更新人'},
		             {field:'updateTime',title:'更新时间'}
		             ]],
		toolbar : [{
			text : '增加',
			iconCls : 'icon-save',
			handler : function() {
				addRecord();
			}
		},'-',  {
			text : '删除',
			iconCls : 'icon-trash',
			handler : function() {
				deleteRecord();
			}
		},'-',  {
			text : '修改',
			iconCls : ' icon-edit',
			handler : function() {
				editRecord();
			}
		}]
	});
}

function addRecord(){
	
}

function deleteRecord(){
	
}

function editRecord(){
	
}