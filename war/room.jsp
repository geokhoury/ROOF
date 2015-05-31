<link rel="stylesheet" href="room.css" />

<div class="container">

  <div class="modal fade" id="room" role="dialog">
    <div class="modal-dialog">

      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h2 class="modal-title" id='room-title'><center>Rooms</center></h2>
      </div>

      <div class="modal-body" id='room-modal-body'>
            <input id="searchInput" class='form-control' placeholder="Type room number!"/>

              <table class="table table-hover" id="room-table" >
                <thead>
                  <tr>
                    <th><center>#</center></th>
                    <th><center>Room Number</center></th>
                    <th><center>
                      <div class="dropdown">
                        <a class="dropdown-toggle" type="button" data-toggle="dropdown">Room Type
                          <span class="caret"></span></button>
                          <ul class="dropdown-menu">
                            <li><a href="#">Activity hall</a></li>
                            <li><a href="#">Auditorium</a></li>
                            <li><a href="#">Classroom</a></li>
                            <li><a href="#">Lab</a></li>
                          </ul>
                      </div>
                      </center></th>
                  </tr>
                </thead>
                <tbody id="room-table-body">
                </tbody>
              </table>


        </div>
      </div>
    </div>
  </div>
</div>
