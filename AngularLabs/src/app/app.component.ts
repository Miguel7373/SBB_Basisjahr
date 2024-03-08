import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {HttpClientTestingModule} from "@angular/common/http/testing";

@Component({
  selector: 'app-root',
  standalone: true,
  providers: [HttpClientTestingModule],
  imports: [RouterOutlet],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'AngularLabs';
}
