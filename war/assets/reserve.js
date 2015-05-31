function reserve(btn){
  var tbNum = new String($('td:eq(0)', btn.closest('tr')).text());
  $('#reserve-form').find('#timeBlock').attr('value' , tbNum);
}


function reserveForm(){
  var roomId = $('#reserve-form').find('#roomId').val();

  var scheduleId = $("#scheduleId").val();

  var timeBlock = $("#timeBlock").val();

  var reservationTitle = $("#reservationTitle").val();

  var date = getDate();

  var dataString = 'room-id='+roomId+'&schedule-id='+scheduleId+'&time-block='+timeBlock+'&day='+date[0]+'&month='+date[1]+'&year='+date[2]+'&reservation-title='+reservationTitle;

  $.ajax({
    type: "POST",
    url: "reserve",
    data: dataString,
    success: function() {
      $("#scheduleId").val("");
      $("#scheduleId").text("");
      $('#reserveModal').modal('hide');
      refreshRoomSchedule();
    }, error: function(){
      alert("Sorry, something went wrong!");
    }
  });




}
