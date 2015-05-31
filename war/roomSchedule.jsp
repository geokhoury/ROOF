
<div class="container">

  <div class="modal fade" id="roomSchedule" role="dialog">
    <div class="modal-dialog">

      <!-- Modal content-->
      <div class="modal-content">

        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h2 class="modal-title" id="roomSchedule-title"><center>Room Schedule</center></h2>
        </div>

        <div class="modal-body" id='room-modal-body'  style="height: 500px;">



              <div class='col-sm-6 col-md-offset-3'>
                <div class="form-group">
                  <div class='input-group date' id='datetimepicker1'>
                    <input type='text' class="form-control" placeholder="Please pick a date" style="text-align: center;"/>
                    <span class="input-group-addon">
                      <span class="glyphicon glyphicon-calendar"></span>
                    </span>
                  </div>
                </div>
              </div>
              <script type="text/javascript">
                $(function () {
                  var now = moment();
                  $('#datetimepicker1').datetimepicker({
                    format: 'DD - MM - YYYY',
                    showTodayButton: true,
                    minDate: now
                  })

                  $('#datetimepicker1').on('dp.change', function(e){
                    refreshRoomSchedule();
                  })
                });
              </script>



          <table class="table table-hover" id="roomSchedule-table">
            <thead>
              <tr>
                <th class='col-md-1'>#</th>
                <th class='col-md-2'><center>TimeSlot</center></th>
                <th class='col-md-2'><center>Reservation</center></th>
                <th class='col-md-2'><center>Reserve</center></th>
              </tr>
            </thead>
            <tbody id="roomSchedule-table-body">
            </tbody>
          </table>

        </div>
      </div>
    </div>
  </div>
</div>
