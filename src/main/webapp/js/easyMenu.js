$(function(){
	initMenu();
})

function initMenu(){
	$.ajax({
		type:'POST',
		url:'/easyMenu/resource/easyMenu.do',
		dataType:'json',
		data:{role:1},
		async:false,
		success:function(result){
			localStorage.menuJsonObject = JSON.stringify(result);
		}		
	});
	menuJsonObject = JSON.parse(localStorage.menuJsonObject);
	menus = menuJsonObject.menus;
	$.each(menus, function(i, firstLevelMenu){
		var menu = "<li class='treeview'><a href='#'><i class='"+firstLevelMenu.icon+"'></i> <span>"+firstLevelMenu.menuName+"</span> <i class='fa fa-angle-left pull-right'></i></a>";
		menu = menu + "<ul class='treeview-menu'>";
		$.each(firstLevelMenu.menus, function(j, secondLevelMenu){
			menu = menu + "<li><a href='"+secondLevelMenu.url+"'><i class='"+secondLevelMenu.icon+"'></i>"+secondLevelMenu.menuName+"</a></li>";
		});
		menu = menu + "</ul></li>";
		$("#sidebar-menu").append(menu);
	});
}