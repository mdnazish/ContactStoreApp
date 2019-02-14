// to solve active menu problems
$(function() {
	switch (menu) {
	case 'Login':
		$('.login').addClass('active');
		break;
	case 'Sign Up':
		$('.register').addClass('active');
		break;
	default:
		$('.home').addClass('active');
		break;
	}
});

// dismissing the alert after 7 seconds of form submission
var $alert = $('.alert');

if ($alert.length) {
	setTimeout(function() {

		$alert.fadeOut('slow');

	}, 7000); // wait for 7 sec
}

// to make Scrolling Navbar for landing page
(function($) {
	"use strict"; // Start of use strict

	// Smooth scrolling using jQuery easing
	$('a.js-scroll-trigger[href*="#"]:not([href="#"])').click(
			function() {
				if (location.pathname.replace(/^\//, '') == this.pathname
						.replace(/^\//, '')
						&& location.hostname == this.hostname) {
					var target = $(this.hash);
					target = target.length ? target : $('[name='
							+ this.hash.slice(1) + ']');
					if (target.length) {
						$('html, body').animate({
							scrollTop : (target.offset().top - 56)
						}, 1000, "easeInOutExpo");
						return false;
					}
				}
			});

	// Closes responsive menu when a scroll trigger link is clicked
	$('.js-scroll-trigger').click(function() {
		$('.navbar-collapse').collapse('hide');
	});

	// Activate scrollspy to add active class to navbar items on scroll
	$('body').scrollspy({
		target : '#mainNav',
		offset : 56
	});

})(jQuery); // End of use strict
