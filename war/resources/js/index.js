$(document)
		.ready(
				function() {
					var mapOptions = {
						center : new google.maps.LatLng(55.790833, 49.114444),
						zoom : 12,
						mapTypeId : google.maps.MapTypeId.ROADMAP
					};
					var map = new google.maps.Map(document
							.getElementById("map-canvas"), mapOptions);
					$.get('/markers', function(string) {
						    // здесь работа со строкой
						var markers = JSON.parse(string);
						for ( var i = 0; i < markers.length; i++) {
							// Создаем маркер
							var newLng = new google.maps.LatLng(markers[i].x,
									markers[i].y);
							var marker = new google.maps.Marker({
								position : newLng,
								map : map,
								title : markers[i].text
							});
						}
						});

				});