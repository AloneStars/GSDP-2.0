var PathStatus 	= 0;
var angle 		= Math.PI/((4-1)*2);	
var mainButton 	= [
	{'bg':'../image/menu/bg-2x.png','css':'','cover':'../image/menu/icon-2x.png','html':'<span class="cover"></span>'},
	{'bg':'','css':'','cover':'','html':'','angle':-405,'speed':200}
];
var Radius 		= 100;		//小图出来的半径
var Offset 		= 40;		//小图出来后的偏移量
var Path 		= 1;		//出现方式，1：左上，2:左下，3：右上，4：右下
var OutSpeed 	= 80;		//小图出现的速度
var OutIncr 	= 50;		//小图出来的旋转
var OffsetSpeed = 200;		//小图出来的旋转速度
var InSpeed 	= 480;		//小图进去的速度
var InIncr 		= 0;		//小图进去的旋转
function PathRun(){

	var PathMenu = $('#PathMenu');
	var PathItems = PathMenu.children('.PathItem').slice(0,12);
	if(PathStatus == 0){
		$(".PathItem .link").css("opacity",1);
		var Count = PathItems.size();
		PathItems.each(function(SP){
			var ID = $(this).index();

			var X 	= Math.cos(angle * (ID - 1)) * Radius;
			var Y 	= Math.sin(angle * (ID - 1)) * Radius;
			var X1	= X + Offset;
			var Y1 	= Y + Offset;


			$(this).children().children().animate({rotate:720},600);
			
			$(this).animate({left:X1,bottom:Y1,opacity:1},OutSpeed+SP*OutIncr,function(){
				$(this).animate({left:X,bottom:Y},OffsetSpeed);
			});	
		});
		
		if(mainButton[1]['angle']){
			$(PathMenu.children('.PathMain').find('.rotate')).animate({rotate:mainButton[1]['angle']},mainButton[1]['speed']);
		} 
		if(mainButton[1]['bg']!='') $(this).children().css('background-image','url('+mainButton[1]['bg']+')')
		if(mainButton[1]['css']!='') $(this).children().css(mainButton[1]['css']);
		if(mainButton[1]['cover']!='') $(this).children().children().css('background-image','url('+mainButton[1]['cover']+')');
		if(mainButton[1]['html']!='') $(this).children().html(mainButton[1]['html']);
		
		PathStatus = 1;
	}else if(PathStatus == 1){
		PathItems.each(function(SP){
			var ID = $(this).index();

			var X 	= Math.cos(angle * (ID - 1)) * Radius;
			var Y 	= Math.sin(angle * (ID - 1)) * Radius;

			var X1  = Math.cos(angle * (ID - 1)) * (Radius+Offset);
			var Y1 	= Math.sin(angle * (ID - 1)) * (Radius+Offset);

			
			$(this).children().children().animate({rotate:720},6000);
			$(this).animate({left:X1,bottom:Y1,opacity:1},OffsetSpeed,function(){
				$(this).animate({left:0,bottom:0,opacity:0},InSpeed+SP*InIncr);
			});
		});

		/*$(".PathItem .link").css("opacity",0);*/

		if(mainButton[1]['angle']){
			$(PathMenu.children('.PathMain').find('.rotate')).animate({rotate:0},mainButton[1]['speed']);
		} 		
		
		if(mainButton[0]['bg']!='') $(this).children().css('background-image','url('+mainButton[0]['bg']+')')
		if(mainButton[0]['css']!='') $(this).children().css(mainButton[0]['css']);
		if(mainButton[0]['cover']!='') $(this).children().children().css('background-image','url('+mainButton[0]['cover']+')');
		if(mainButton[0]['html']!='') $(this).children().html(mainButton[0]['html']);


		PathStatus = 0;
	}
}
