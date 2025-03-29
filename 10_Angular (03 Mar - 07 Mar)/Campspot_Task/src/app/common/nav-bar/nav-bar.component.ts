import { Component } from '@angular/core';

@Component({
  selector: 'app-nav-bar',
  standalone: false,
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css'],
})
export class NavBarComponent {
  isLogin = localStorage.getItem('login') ? true : false;
  isSelected = false;

  ngOnInit() {
    this.isLogin = !!localStorage.getItem('login');
  }

  onSelectedUser() {
    this.isSelected = !this.isSelected;
  }

  logout() {
    localStorage.removeItem('login');
    window.location.reload();
  }
}
