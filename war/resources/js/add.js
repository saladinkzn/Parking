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
          google.maps.event.addListener(map, 'click', function(event) {
            //TODO ������� ��� �������(� ������ ������ ����), ������� ��� ���� �� �����
            var xy = event.latLng;
            $("input[name=latitude]").val(xy.jb);   //����� � ������ ����������
            $("input[name=longitude]").val(xy.kb);
            console.log(xy.jb + ' ' + xy.kb);
            var marker = new google.maps.Marker({    //������ ������ �� �����
								position : xy,
								map : map,
								title : $("input[name=name]").val()
						});
            $("input[name=name]").change(function(){
                   //TODO ��������� ������� ������� 
            });
            google.maps.event.addListener(marker, 'click', function(event){
                  //TODO �������� �������
            });
          }); 
        }
    );