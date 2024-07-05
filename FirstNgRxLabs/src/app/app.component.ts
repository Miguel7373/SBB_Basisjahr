import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';

import {AsyncPipe} from "@angular/common";
import {MyCounterComponent} from "./components/my-counter/my-counter.component";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, AsyncPipe, MyCounterComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'FirstNgRxLabs';

}
