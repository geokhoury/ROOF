
<div class="container">

  <div class="modal fade" id="reserveModal" role="dialog">
    <div class="modal-dialog">

      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h2 class="modal-title" id='room-title'><center>Reserve</center></h2>
        </div>

        <div class="modal-body" id='reserve-modal-body'  style="height: 400px;">

          <form  id='reserve-form' style='padding-left:4px;'>

            <input type='hidden' name='room-id' id='roomId' value=''></input>
            <input type='hidden' name='schedule-id' id='scheduleId' value=''></input>
            <input type='hidden' name='time-block' id='timeBlock' value=''></input>

            <div class="form-group">
              <input type="text" class="form-control" name="reservation-title" id='reservationTitle' placeholder="Title" autofocus="true" />
            </div>
            <div class="form-group">
              Number of people:
              <input type='number' class='form-control' min='1' max='21' placeholder="From 1 - 21"/>
            </div>
            <div class="form-group">
                <button type="button" class="btn btn-primary" onclick="reserveForm();">Reserve!</button>
            </div>
          </form>
        </div>
        </div>
        </div>
      </div>
    </div>
  </div>
</div>
