function postPojazdElektryczny() {
	let cname = $("#cname").val();
	let cwcount = $("#cwcount").val();
	let cmspeed = $("#cmspeed").val();
	let cepower = $("#cepower").val();
	let crange = $("#crange").val();

	console.log(cname, cwcount, cmspeed,cepower,crange);
	let obj = {
			name: cname,
			wheelCount: cwcount,
			maxSpeed : cmspeed,
			enginePower : cepower,
			range : crange
	}

	$.ajax({
		  type: "POST",
		  url: "/pojazdy/elektryczne",
		  data: JSON.stringify(obj),
		  success: function(data) {
			  console.log("success");
			  console.log(data);

		  },
		  error: function(data) {
			  console.log("error");
			  console.log(data);
		  },
		  contentType: "application/json; charset=utf-8",
		  dataType: "json"
		});
}