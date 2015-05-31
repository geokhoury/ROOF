
function showRoomSchedule(cell){

  //var roomBuilding = $('td:eq(1)', cell).text();
  var roomNumber = $('td:eq(1)', cell).text();
  var roomId = cell.find("#roomId").text();

  $('#roomSchedule-title').find('center').text("Room " +  roomNumber);

  $('#roomSchedule-table-body').find('tr').each(function(){
    $(this).remove();
  });

  $('#reserve-form').find('#roomId').attr('value' , roomId);


  var now = moment();
  $('#datetimepicker1').data("DateTimePicker").date(now);

  //func(roomId, now.date() , now.month() , now.year());

}

function refreshRoomSchedule(){

  var date = getDate();

  var roomId = $('#reserve-form').find('#roomId').val();

  if(!roomId) {
     return;
  }

  $('#roomSchedule-table-body').find('tr').each(function(){
    $(this).remove();
  });

  func(roomId,date[0],date[1],date[2]);

}

function getDate(){
  var picker = $('#datetimepicker1').data("DateTimePicker").date()
  var day = picker.date();
  var month = picker.month();
  var year = picker.year();


  return [day, month, year];
}


function func (roomId, day,month,year) {

  $.getJSON('schedule', {'room-id': roomId , 'day': day , 'month': month , 'year': year}, function(responseJson){

    if(jQuery.isEmptyObject(responseJson)){
      console.log("No Schedule Registered For Room");
      //TODO: delete table and show text that no schedule is registered for the room instead of table;
    }

    $('#reserve-form').find('#scheduleId').attr('value' , responseJson.scheduleId);

    var i = 0;
    var timeBlocks = responseJson.timeBlocks;

    $.each(timeBlocks, function(index, x) {
      var a;

      if(x.reservation == 'FREE'){
        a = "<a onclick='reserve($(this));' data-toggle='modal' data-target='#reserveModal' data-backdrop='true'>";
      } else {
        a = "<text>"
      }

      $("#roomSchedule-table-body").append(
        $("<tr>")
        .append($('<td>').text(++i))
        .append($('<td>').append($('<center>').text(x.timeBlock)))
        .append($('<td>').append($('<center>').text(x.reservation)))
        .append($('<td>').append($(a).append($("<center>").text("Reserve"))))
      );

    });
  }
)}
