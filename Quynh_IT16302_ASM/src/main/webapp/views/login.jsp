<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
  <!-- Modal -->
  <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <p class="modal-title" id="exampleModalLabel" style="font-size: xx-large;">Đăng nhập</p>
          <button type="button" class="close" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">&times;</span>
          </button>
        </div>
        <form action="/Quynh_IT16302_ASM/Login" method="post">
          <div class="modal-body">
            <div class="card">
              <div class="card-body">
                <div class="form-group">
                  <label for="">Email</label>
                  <input class="form-control" type="email" name="email" id="" required>
                </div>
                <div class="form-group">
                  <label for="">Password</label>
                  <input class="form-control" type="password" name="password" id="" required>
                </div>
              </div>
              <div class="card-footer text-center">
                <button class="btn btn-success">Đăng nhập</button>
                <button class="btn btn-warning" type="reset">Reset</button>
              </div>
            </div>
          </div>
        </form>
      </div>
    </div>
  </div>