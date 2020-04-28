export class Approuter {

  public static reloadAdminCars() {
    window.location.href = 'http://' + window.location.hostname + ':' + window.location.port + '/admin/car-manage';
  }
  public static reloadAdmin() {
    window.location.href = 'http://' + window.location.hostname + ':' + window.location.port + '/admin';
  }
  public static reloadHome() {
    window.location.href = 'http://' + window.location.hostname + ':' + window.location.port;
  }
  public static reloadLogin() {
    window.location.href = 'http://' + window.location.hostname + ':' + window.location.port + '/login';
  }
  public static reloadNotFound() {
    window.location.href = 'http://' + window.location.hostname + ':' + window.location.port + '/notfound';
  }
  public static reloadLogout() {
    window.location.href = 'http://' + window.location.hostname + ':' + window.location.port + '/logout';
  }
  public static reloadRegister() {
    window.location.href = 'http://' + window.location.hostname + ':' + window.location.port + '/register';
  }
}
