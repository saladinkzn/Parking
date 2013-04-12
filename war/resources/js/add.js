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
          google.maps.Map.prototype.markers = new Array();
          google.maps.event.addListener(map, 'click', function(event) {
            for(var i = 0; i<map.markers.length; i++)         //удаляем все предыдущие маркеры (один, в теории)
            {
                map.markers[i].setMap(null);
                map.markers.pop();
            }
            var xy = event.latLng;
            $("input[name=latitude]").val(xy.jb);   //пишем в инпуты координаты
            $("input[name=longitude]").val(xy.kb);
            var marker = new google.maps.Marker({    //создаём маркер на карте
								position : xy,
								map : map,
								title : $("input[name=name]").val()
						});
            map.markers.push(marker);
            $("input[name=name]").change(function(){ // при изменении значения поля ввода имени
                marker.setTitle($(this).val());    // меняем подпись маркера    
            });
            google.maps.event.addListener(marker, 'click', function(event){   // удаляем маркер при клике по нему
                marker.setMap(null);
                map.clearOverlays();
            });
          }); 
        }
    );