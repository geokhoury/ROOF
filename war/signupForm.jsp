


  <div class="container">

    <div class="modal fade" id="signupForm" role="dialog">
      <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">

          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal">&times;</button>
            <h2 class="modal-title" id="roomSchedule-title"><center>Sign up now!</center></h2>
          </div>

          <div class="modal-body" id='signup-modal-body'>
            <div class='row'>

              <div class="col-md-8 col-md-offset-2">
            <form action='login' method='POST' id='signup-form'>


                  <div class="form-group">
                    <input type="email" class="form-control" id="email" name="email" placeholder="Please enter your email" data-error="Invalid email address. Try again!" required>
                    <div class="help-block with-errors"></div>
                  </div>
                  <div class="form-group">
                    <input type="password" class="form-control" id="password" name="password" placeholder="Please enter your password" data-error="Please enter your password." required>
                    <div class="help-block with-errors"></div>
                  </div>
                  <div class="form-group">
                    <button type="submit" class="btn btn-primary">Sign up!</button>
                  </div>
                  <div class='form-group'>
                    <a data-dismiss="modal" style='padding-bottom:50px;'> <center>Already a memeber?</center> </a>
                  </div>

            </form>

          </div>
        </div>
          </div>
        </div>
      </div>
    </div>
  </div>
