
function myFunction(id){
  $('#room-title').find('center').text("Building " + id);

  // Remove existing data in the table.
  $('#room-table-body').find('tr').each(function(){
    $(this).remove();
  });
  // Load data from json servlet.
  $.getJSON('rooms', {"building-id": id} , function(responseJson) {
    if(jQuery.isEmptyObject(responseJson)){
      console.log("File is empty");
      //TODO: delete table and show text that no rooms exist instead of table;
    }
    var i = 0;
    $.each(responseJson, function(index, room) {
      $("#room-table-body").append(
        $("<tr onclick='showRoomSchedule($(this));' data-toggle='modal' data-target='#roomSchedule' data-backdrop='true'>")
        .append($('<td>').append($('<center>').text(++i)))
        .append($("<input type='hidden' id='roomId'>").text(room.Id))
        .append($('<td>').append($('<center>').text(room.roomNumber)))
        .append($('<td>').append($('<center>').text(room.roomType)))

      );
    });
  })
  .error(function() { console.log("Error"); })
}

   $("#searchInput").keyup(function () {
    //split the current value of searchInput
    var data = this.value.split(" ");
    //create a jquery object of the rows
    var jo = $("#room-table-body").find("tr");
    if (this.value == "") {
        jo.show();
        return;
    }
    //hide all the rows
    jo.hide();

    //Recusively filter the jquery object to get results.
    jo.filter(function (i, v) {
        var $t = $(this);
        for (var d = 0; d < data.length; ++d) {
            if ($t.is(":contains('" + data[d] + "')")) {
                return true;
            }
        }
        return false;
    })
    //show the rows that match.
    .show();
  }).focus();
