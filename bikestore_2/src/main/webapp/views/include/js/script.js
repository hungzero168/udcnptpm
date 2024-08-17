//hearder
$(document).ready(function()
{
	"use strict";

	var menuActive = false;
	var header = $('.header');
	setHeader();
	initCustomDropdown();
	initPageMenu();

	function setHeader()
	{
	
		if(window.innerWidth > 991 && menuActive)
		{
			closeMenu();
		}
	}

	function initCustomDropdown()
	{
		if($('.custom_dropdown_placeholder').length && $('.custom_list').length)
		{
			var placeholder = $('.custom_dropdown_placeholder');
			var list = $('.custom_list');
		}

		placeholder.on('click', function (ev)
		{
			if(list.hasClass('active'))
			{
				list.removeClass('active');
			}
			else
			{
				list.addClass('active');
			}

			$(document).one('click', function closeForm(e)
			{
				if($(e.target).hasClass('clc'))
				{
					$(document).one('click', closeForm);
				}
				else
				{
					list.removeClass('active');
				}
			});

		});

		$('.custom_list a').on('click', function (ev)
		{
			ev.preventDefault();
			var index = $(this).parent().index();

			placeholder.text( $(this).text() ).css('opacity', '1');

			if(list.hasClass('active'))
			{
				list.removeClass('active');
			}
			else
			{
				list.addClass('active');
			}
		});


		$('select').on('change', function (e)
		{
			placeholder.text(this.value);

			$(this).animate({width: placeholder.width() + 'px' });
		});
	}

	/* 

	4. Init Page Menu

	*/

	function initPageMenu()
	{
		if($('.page_menu').length && $('.page_menu_content').length)
		{
			var menu = $('.page_menu');
			var menuContent = $('.page_menu_content');
			var menuTrigger = $('.menu_trigger');

			//Open / close page menu
			menuTrigger.on('click', function()
			{
				if(!menuActive)
				{
					openMenu();
				}
				else
				{
					closeMenu();
				}
			});

			//Handle page menu
			if($('.page_menu_item').length)
			{
				var items = $('.page_menu_item');
				items.each(function()
				{
					var item = $(this);
					if(item.hasClass("has-children"))
					{
						item.on('click', function(evt)
						{
							evt.preventDefault();
							evt.stopPropagation();
							var subItem = item.find('> ul');
						    if(subItem.hasClass('active'))
						    {
						    	subItem.toggleClass('active');
								TweenMax.to(subItem, 0.3, {height:0});
						    }
						    else
						    {
						    	subItem.toggleClass('active');
						    	TweenMax.set(subItem, {height:"auto"});
								TweenMax.from(subItem, 0.3, {height:0});
						    }
						});
					}
				});
			}
		}
	}

	function openMenu()
	{
		var menu = $('.page_menu');
		var menuContent = $('.page_menu_content');
		TweenMax.set(menuContent, {height:"auto"});
		TweenMax.from(menuContent, 0.3, {height:0});
		menuActive = true;
	}

	function closeMenu()
	{
		var menu = $('.page_menu');
		var menuContent = $('.page_menu_content');
		TweenMax.to(menuContent, 0.3, {height:0});
		menuActive = false;
	}  
});

//main
// For Filters
document.addEventListener("DOMContentLoaded", function() {
var filterBtn = document.getElementById('filter-btn');
var btnTxt = document.getElementById('btn-txt');
var filterAngle = document.getElementById('filter-angle');

$('#filterbar').collapse(false);
var count = 0, count2 = 0;
function changeBtnTxt() {
$('#filterbar').collapse(true);
count++;
if (count % 2 != 0) {
filterAngle.classList.add("fa-angle-right");
btnTxt.innerText = "show filters"
filterBtn.style.backgroundColor = "#36a31b";
}
else {
filterAngle.classList.remove("fa-angle-right")
btnTxt.innerText = "hide filters"
filterBtn.style.backgroundColor = "#ff935d";
}

}

// For Applying Filters
$('#inner-box').collapse(false);
$('#inner-box2').collapse(false);

// For changing NavBar-Toggler-Icon
var icon = document.getElementById('icon');

function chnageIcon() {
count2++;
if (count2 % 2 != 0) {
icon.innerText = "";
icon.innerHTML = '<span class="far fa-times-circle" style="width:100%"></span>';
icon.style.paddingTop = "5px";
icon.style.paddingBottom = "5px";
icon.style.fontSize = "1.8rem";


}
else {
icon.innerText = "";
icon.innerHTML = '<span class="navbar-toggler-icon"></span>';
icon.style.paddingTop = "5px";
icon.style.paddingBottom = "5px";
icon.style.fontSize = "1.2rem";
}
}

// Showing tooltip for AVAILABLE COLORS
$(function () {
$('[data-tooltip="tooltip"]').tooltip()
})

// For Range Sliders
var inputLeft = document.getElementById("input-left");
var inputRight = document.getElementById("input-right");

var thumbLeft = document.querySelector(".slider > .thumb.left");
var thumbRight = document.querySelector(".slider > .thumb.right");
var range = document.querySelector(".slider > .range");

var amountLeft = document.getElementById('amount-left')
var amountRight = document.getElementById('amount-right')

function setLeftValue() {
var _this = inputLeft,
min = parseInt(_this.min),
max = parseInt(_this.max);

_this.value = Math.min(parseInt(_this.value), parseInt(inputRight.value) - 1);

var percent = ((_this.value - min) / (max - min)) * 100;

thumbLeft.style.left = percent + "%";
range.style.left = percent + "%";
amountLeft.innerText = parseInt(percent * 100);
}
setLeftValue();

function setRightValue() {
var _this = inputRight,
min = parseInt(_this.min),
max = parseInt(_this.max);

_this.value = Math.max(parseInt(_this.value), parseInt(inputLeft.value) + 1);

var percent = ((_this.value - min) / (max - min)) * 100;

amountRight.innerText = parseInt(percent * 100);
thumbRight.style.right = (100 - percent) + "%";
range.style.right = (100 - percent) + "%";
}
setRightValue();

inputLeft.addEventListener("input", setLeftValue);
inputRight.addEventListener("input", setRightValue);

inputLeft.addEventListener("mouseover", function () {
thumbLeft.classList.add("hover");
});
inputLeft.addEventListener("mouseout", function () {
thumbLeft.classList.remove("hover");
});
inputLeft.addEventListener("mousedown", function () {
thumbLeft.classList.add("active");
});
inputLeft.addEventListener("mouseup", function () {
thumbLeft.classList.remove("active");
});

inputRight.addEventListener("mouseover", function () {
thumbRight.classList.add("hover");
});
inputRight.addEventListener("mouseout", function () {
thumbRight.classList.remove("hover");
});
inputRight.addEventListener("mousedown", function () {
thumbRight.classList.add("active");
});
inputRight.addEventListener("mouseup", function () {
thumbRight.classList.remove("active");
});
});