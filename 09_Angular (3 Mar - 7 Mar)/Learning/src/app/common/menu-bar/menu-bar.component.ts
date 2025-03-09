import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-menu-bar',
  templateUrl: './menu-bar.component.html',
  styleUrl: './menu-bar.component.css',
})
export class MenuBarComponent {
  status: boolean = false;
  loginMenu: string = 'Login';

  constructor(private router: Router) {
    let username = localStorage.getItem('username');
    if (username) {
      this.status = true;
      this.loginMenu = username + ', Logout';
    }
  }

  loginHandler() {
    if (this.status) {
      localStorage.removeItem('username');
      window.location.reload();
    } else {
      this.router.navigate(['/login']);
    }
  }
}
