$(document).ready(function() {

	//Khi bàn phím được nhấn và thả ra thì sẽ chạy phương thức này
	$("form").validate({
		rules: {
			username: "required",
			password: "required",

		},
		messages: {
			username: "Vui lòng nhập họ tên",
			password: "Vui lòng nhập password",
		}
	});

	$("input").click(function() {
		$(".fail").addClass("inactive");
	});
});